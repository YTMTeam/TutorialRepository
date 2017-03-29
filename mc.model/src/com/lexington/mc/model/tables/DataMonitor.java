package com.lexington.mc.model.tables;


import java.math.BigDecimal;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;

import com.lexington.mc.model.util.UtilCodeTypes;
import com.mallocinc.codegenerator.exceptions.GDAOException;
import com.mallocinc.database.generated.to.MonitorTo;
import com.mallocinc.database.generated.working.MonitorTab;
 

public class DataMonitor {

	UtilCodeTypes       uct                           = new UtilCodeTypes();
	   final static Logger log                           = Logger.getLogger(DataMonitor.class.getName());

	   /**********************************************************************
	    *
	    * TRANSACTION_STRATEGY_TRESHOLD is the number of records that will 
	    * be changed and it is used to determine most optimum strategy
	    * for executing the task. 
	    * In order to get the best results this number should be determined 
	    * by experience or by experimenting.
	    *
	    **********************************************************************/
	   final static long   TRANSACTION_STRATEGY_TRESHOLD = 100000;

	   /**********************************************************************
	    *
	    * TRANSACTION_TRESHOLD identifies number of updates/inserts or deletes
	    * in one database transaction.
	    * In order to get the best results this number should be determined 
	    * by experience or by experimenting.
	    *
	    **********************************************************************/
	   final static long   TRANSACTION_TRESHOLD          = 1000;
	
	
	   
	   public void updateMonitorBatch(Connection connection, ArrayList<MonitorTo> batch) throws GDAOException {
	      String whatWeAreDoing = "\"updateByToArrayBatch()\" for TABLE \"MONITOR\"";

	      
	      PreparedStatement preparedStatementForUpdate = null;

	      MonitorTab monitorTab = null;

	      log.info("Starting " + whatWeAreDoing);

	      try {

	         /**********************************************************************
	         *
	         * Executing statements which will NOT ignore Oracle errors:
	         *
	         * NOTE:
	         * Disabling constraints and dropping indexes may improve Delete
	         * performances. If you choose to do that, do not forget to enable
	         * constraints and recreate indexes after deletion is done.
	         *
	         **********************************************************************/

	         monitorTab = new MonitorTab(connection);

	         /**********************************************************************
	          *
	          * Target ResultSet should be:
	          * - ResultSet.TYPE_SCROLL_SENSITIVE,
	          * - ResultSet.CONCUR_UPDATABLE
	          *
	          **********************************************************************/
	         monitorTab.setResultSetConcurrency(ResultSet.CONCUR_UPDATABLE);
	         monitorTab.setResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE);

	         log.info("Number of records before Batch Update: " + monitorTab.getRowCount());

	         log.info("Use Oracle Cursors for selecting large number of records...");

	         preparedStatementForUpdate = monitorTab.getUpdateByPkPreparedStatement();

	         Iterator<MonitorTo> iterator = batch.iterator();

	         long executedUpdateStatement = 0;

	         while (iterator.hasNext()) {

	        	 MonitorTo monitorTo = iterator.next();

	            monitorTab.updateByToAddToBach(preparedStatementForUpdate, monitorTo);

	            executedUpdateStatement++;

	         }

	         int[] updateCountsArray = preparedStatementForUpdate.executeBatch();

	         log.info("Number of records after Batch Update: " + monitorTab.getRowCount());

	      } catch (GDAOException e) {
	         log.error("Cannot perform DDL/DML on TABLE \"MONITOR\".");
	         throw new GDAOException(e);
	      } catch (BatchUpdateException b) {
	         /**********************************************************************
	          *
	          * Handles exception in statement:
	          * ps.executeBatch();
	          *
	          **********************************************************************/
	         log.error("----BatchUpdateException----");
	         log.error("SQLState:  " + b.getSQLState());
	         log.error("Message:  " + b.getMessage());
	         log.error("Vendor:  " + b.getErrorCode());
	         log.error("Delete counts:  ");

	         int[] updateCounts = b.getUpdateCounts();
	         for (int i = 0; i < updateCounts.length; i++) {
	            log.error(updateCounts[i] + "   ");
	         }

	         log.error("----------------------------");

	         throw new GDAOException(b);
	      } catch (SQLException e) {
	         throw new GDAOException(e);
	      } finally {
	         try {

	            preparedStatementForUpdate.close();
	         } catch (SQLException e) {
	            throw new GDAOException(e);
	         }
	      }
	      log.info("Finished " + whatWeAreDoing);

	   }
	   
	   
	   
	   public void deleteByAccountId(Connection connection, String accountId) throws GDAOException {
		      long recordsDeleted = -1;

		      log.debug("Starting delete of TABLE \"MONITOR\".");

		      MonitorTab monitorTab = new MonitorTab(connection);

		      try {
		         //  connection.setAutoCommit(false); // manage transactions manually

		         /**********************************************************************
		          *
		          * Delete records that match WHERE clause in the table:
		          * NOTE:
		          * "WHERE ROWNUM <" or "GROUP BY" cannot be used when updating result set
		          *
		          **********************************************************************/
		         String SQL = "WHERE ACCOUNT_ID = ?";
		         recordsDeleted = monitorTab.deleteRecords(SQL, accountId);

		         /**********************************************************************
		          *
		          * Display number of records that will be affected:
		          *
		          **********************************************************************/
		         log.info(recordsDeleted + " records are deleted from TABLE \"MONITOR\"");

		         /**********************************************************************
		          *
		          * Commit transaction.
		          *
		          **********************************************************************/
		         //  connection.commit();
		        

		      } catch (GDAOException e) {
		         e.printStackTrace();
		         log.error("Cannot delete  records from TABLE \"MONITOR\".");
 
		         throw new GDAOException(e);
		      }

		      log.debug("Finished delete of TABLE \"MONITOR\".");

		   }



	public void insertMonitorBatch(Connection connection, ArrayList<MonitorTo> toInsert) throws GDAOException {
		
		String whatWeAreDoing = "\"insertByToArrayBatch()\" for TABLE \"MONITOR\"";

	      MonitorTab monitorTab = null;

	      log.info("Starting " + whatWeAreDoing);

	      try {

	         

	         monitorTab = new MonitorTab(connection);
	         

	         
	         monitorTab.insert(toInsert);
	        

	      } catch (GDAOException e) {
	         log.error("Cannot perform INSERT on TABLE \"MONITOR\".");
	         throw new GDAOException(e);
	      
	      }
	      log.info("Finished " + whatWeAreDoing);
	}
	   
	
}
