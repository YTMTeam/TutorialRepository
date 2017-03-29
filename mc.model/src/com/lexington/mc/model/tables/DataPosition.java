package com.lexington.mc.model.tables;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.lexington.mc.model.util.UtilCodeTypes;
import com.lexington.mc.model.util.UtilData;
import com.mallocinc.codegenerator.exceptions.GDAOException;
import com.mallocinc.database.generated.to.AccountTo;
import com.mallocinc.database.generated.to.PositionTo;
import com.mallocinc.database.generated.working.AccountTab;
import com.mallocinc.database.generated.working.PositionTab;

public class DataPosition {
	   UtilCodeTypes uct = new UtilCodeTypes();
	   final static Logger log = Logger.getLogger(DataPosition.class.getName());
	   
	    /**********************************************************************
	    *
	    * TRANSACTION_STRATEGY_TRESHOLD is the number of records that will 
	    * be changed and it is used to determine most optimum strategy
	    * for executing the task. 
	    * In order to get the best results this number should be determined 
	    * by experience or by experimenting.
	    *
	    **********************************************************************/
	   final static long TRANSACTION_STRATEGY_TRESHOLD = 100000;
	   
	    /**********************************************************************
	    *
	    * TRANSACTION_TRESHOLD identifies number of updates/inserts or deletes
	    * in one database transaction.
	    * In order to get the best results this number should be determined 
	    * by experience or by experimenting.
	    *
	    **********************************************************************/
	   final static long TRANSACTION_TRESHOLD = 1000;
	   
	   UtilData utilData= new UtilData();
	
	   public List<PositionTo> getPositionByAccountIdForPaging(Connection conn, int first, int pageSize, String sortField,
				String sortOrder, Map<String, Object> filters, String accountId) throws GDAOException {
			List<PositionTo> res= new ArrayList<PositionTo>();
			log.debug("Starting select from TABLE \"POSITION\".");
			
			PositionTab positionTab = new PositionTab(conn);
			
			try {
				
				/**********************************************************************
				 *
				 * !IMPORTANT!:
				 * Use the following parameters in order to speed up SELECT
				 * and to prevent program from failing because of EXAUSTED MEMORY error:
				 * java.lang.OutOfMemoryError: Java heap space
				 *
				 **********************************************************************/
				positionTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
				positionTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);
				
				/**********************************************************************
				 *
				 * Selects specific records from the table:
				 * Limit number of rows selected to "100" (just an example)
				 * Change "WHERE" condition to meet your needs.
				 *
				 **********************************************************************/
		         String andCheck = utilData.checkAndClause(filters);
		         String queryString = "WHERE ACCOUNT_ID = ? ";
		         
		            queryString += ""
	                        + andCheck
	                        + utilData.preparePagingStatementString(first, pageSize, sortField, sortOrder, filters, false);
		            
				positionTab.getResultSet(queryString, accountId);
				
				/**********************************************************************
				 *
				 * Selects all records from the table - no "WHERE" condition.
				 * Both methods below are equal:
				 *
				 **********************************************************************/
				//AccountTab.getResultSet(null, (Object[])null);
				//AccountTab.getAllRecordsRs();
				
				/**********************************************************************
				 *
				 * Loop through database result set:
				 *
				 **********************************************************************/
				while (positionTab.next()) {
					res.add(positionTab.getTo());
					/**********************************************************************
					 *
					 * Print all values from the row in one line delimited by "; "
					 *
					 **********************************************************************/
					positionTab.print("; ");
					
					/**********************************************************************
					 *
					 * Fetch data from the database into local variables:
					 *
					 **********************************************************************/
					
					
					log.debug("---------------^^^^^^^^^-----------------");
				}
				
			} catch (GDAOException e) {
				e.printStackTrace();
				log.error("Cannot select from TABLE \"POSITION\".");
				throw new GDAOException(e);
			} finally {
				positionTab.releaseStatement();
			}
			
			log.debug("Finished select from TABLE \"POSITION\".");
			return res;
		}
		
		   public long getPositionByAccountIdFilterCount(Connection conn, Map<String, Object> filters, String accountId) throws GDAOException {
			long rowCount=0;
			AccountTab accountTab = new AccountTab(conn);

		    try {
		    	
		    	  accountTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
		    	  accountTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);
		    	  
		          String andCheck = utilData.checkAndClause(filters);
		          String queryString = "WHERE ACCOUNT_ID =? ";
		          queryString += "" + andCheck + utilData.prepareCountString(filters, false);
		          
		    	  rowCount = accountTab.getRowCount(queryString, accountId);

		      } catch (GDAOException e) {
		         e.printStackTrace();
		         log.error("Cannot select from TABLE \"POSITION\".");
		         throw new GDAOException(e);
		      } finally {
		    	  accountTab.releaseStatement();
		      }

		      log.debug("Finished count from VIEW \"POSITION\".");
		      return rowCount;
		}
			public ArrayList<PositionTo> insertArrayOfPositions(Connection connection, ArrayList<PositionTo> positions) {

			      ArrayList<PositionTo> result = new ArrayList<>();
			      String whatWeAreDoing = "\"insertArrayOfUsersTo()\" for TABLE \"USERS\"";

			      log.debug("Starting " + whatWeAreDoing);

			      PositionTab position = new PositionTab(connection);
			      for (PositionTo positionForInsert : positions) {

			         try {
			            position.insert(positionForInsert);
			            result.add(positionForInsert);
			         } catch (GDAOException exception) {
			            log.info("Account with POSITION_ID: " + positionForInsert.getPOSITION_ID() + " ,already exists into database.");
			         }
			      }
			      try {
			         position.releaseStatement();
			      } catch (GDAOException e) {
			         log.error("Error on releaseStatement() on accountTab object.", e);
			      }
			      log.debug("Ending " + whatWeAreDoing);
			      return result;
			   	}
}
