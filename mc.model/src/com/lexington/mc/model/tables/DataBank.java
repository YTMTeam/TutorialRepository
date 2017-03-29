package com.lexington.mc.model.tables;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.lexington.mc.model.util.UtilCodeTypes;
import com.lexington.mc.model.util.UtilData;
import com.mallocinc.codegenerator.exceptions.GDAOException;
import com.mallocinc.database.generated.to.AccountTo;
import com.mallocinc.database.generated.to.BankTo;
import com.mallocinc.database.generated.working.AccountTab;
import com.mallocinc.database.generated.working.BankTab;

public class DataBank {
	   UtilCodeTypes uct = new UtilCodeTypes();
	   final static Logger log = Logger.getLogger(DataBank.class.getName());
	   
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
	
	public BankTo getBankByBankId(Connection conn, BigDecimal bankId) throws GDAOException {
		 BankTo  res= null;
	      log.debug("Starting select from TABLE \"BANK\".");


	      BankTab bankTab = new BankTab(conn);

	      try {

	         /**********************************************************************
	          *
	          * !IMPORTANT!:
	          * Use the following parameters in order to speed up SELECT
	          * and to prevent program from failing because of EXAUSTED MEMORY error:
	          * java.lang.OutOfMemoryError: Java heap space
	          *
	          **********************************************************************/
	         bankTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
	         bankTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

	         /**********************************************************************
	          *
	          * Selects specific records from the table:
	          * Limit number of rows selected to "100" (just an example)
	          * Change "WHERE" condition to meet your needs.
	          *
	          **********************************************************************/
	         bankTab.getResultSet("WHERE BANK_ID = ?", bankId);

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
	         if (bankTab.next()) {
	        	 res = bankTab.getTo();
	            /**********************************************************************
	            *
	            * Print all values from the row in one line delimited by "; "
	            *
	            **********************************************************************/
	            bankTab.print("; ");

	            /**********************************************************************
	            *
	            * Fetch data from the database into local variables:
	            *
	            **********************************************************************/


	            /**********************************************************************
	            *
	            * Print all values from the row - one line per column:
	            *
	            **********************************************************************/

	         }

	      } catch (GDAOException e) {
	         e.printStackTrace();
	         log.error("Cannot select from TABLE \"BANK\".");
	         throw new GDAOException(e);
	      } finally {
	         bankTab.releaseStatement();
	      }

	      log.debug("Finished select from TABLE \"BANK\".");
	      return res;
	}
	
	public BankTo getBankByBankCode(Connection conn, String bankCode) throws GDAOException {
		BankTo  res= null;
		log.debug("Starting select from TABLE \"BANK\".");
		
		
		BankTab bankTab = new BankTab(conn);
		
		try {
			
			/**********************************************************************
			 *
			 * !IMPORTANT!:
			 * Use the following parameters in order to speed up SELECT
			 * and to prevent program from failing because of EXAUSTED MEMORY error:
			 * java.lang.OutOfMemoryError: Java heap space
			 *
			 **********************************************************************/
			bankTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
			bankTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);
			
			/**********************************************************************
			 *
			 * Selects specific records from the table:
			 * Limit number of rows selected to "100" (just an example)
			 * Change "WHERE" condition to meet your needs.
			 *
			 **********************************************************************/
			bankTab.getResultSet("WHERE BANK_CODE = ?", bankCode);
			
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
			if (bankTab.next()) {
				res = bankTab.getTo();
				/**********************************************************************
				 *
				 * Print all values from the row in one line delimited by "; "
				 *
				 **********************************************************************/
				bankTab.print("; ");
				
				/**********************************************************************
				 *
				 * Fetch data from the database into local variables:
				 *
				 **********************************************************************/
				
				
				/**********************************************************************
				 *
				 * Print all values from the row - one line per column:
				 *
				 **********************************************************************/
				
			}
			
		} catch (GDAOException e) {
			e.printStackTrace();
			log.error("Cannot select from TABLE \"BANK\".");
			throw new GDAOException(e);
		} finally {
			bankTab.releaseStatement();
		}
		
		log.debug("Finished select from TABLE \"BANK\".");
		return res;
	}

	public ArrayList<BankTo> getAllBanks(Connection conn) throws GDAOException {
		ArrayList<BankTo> res= new ArrayList<>();
	      log.debug("Starting select from TABLE \"BANK\".");


	      BankTab bankTab = new BankTab(conn);

	      try {

	         /**********************************************************************
	          *
	          * !IMPORTANT!:
	          * Use the following parameters in order to speed up SELECT
	          * and to prevent program from failing because of EXAUSTED MEMORY error:
	          * java.lang.OutOfMemoryError: Java heap space
	          *
	          **********************************************************************/
	         bankTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
	         bankTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

	         /**********************************************************************
	          *
	          * Selects specific records from the table:
	          * Limit number of rows selected to "100" (just an example)
	          * Change "WHERE" condition to meet your needs.
	          *
	          **********************************************************************/
	         bankTab.getAllRecordsRs();

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
	         while (bankTab.next()) {
	        	 res.add(bankTab.getTo());
	            /**********************************************************************
	            *
	            * Print all values from the row in one line delimited by "; "
	            *
	            **********************************************************************/
	            bankTab.print("; ");

	            /**********************************************************************
	            *
	            * Fetch data from the database into local variables:
	            *
	            **********************************************************************/


	            /**********************************************************************
	            *
	            * Print all values from the row - one line per column:
	            *
	            **********************************************************************/

	         }

	      } catch (GDAOException e) {
	         e.printStackTrace();
	         log.error("Cannot select from TABLE \"BANK\".");
	         throw new GDAOException(e);
	      } finally {
	         bankTab.releaseStatement();
	      }

	      log.debug("Finished select from TABLE \"BANK\".");
	      return res;
	}
	public ArrayList<BankTo> getBankToListByBankCodes(Connection conn, String unionString) throws GDAOException {
       ArrayList<BankTo>  res=  new ArrayList<>();
       log.debug("Starting select from TABLE \"BANK\".");
           
       
       BankTab bankTab = new BankTab(conn);
       
       try {
          
          /**********************************************************************
           *
           * !IMPORTANT!:
           * Use the following parameters in order to speed up SELECT
           * and to prevent program from failing because of EXAUSTED MEMORY error:
           * java.lang.OutOfMemoryError: Java heap space
           *
           **********************************************************************/
          bankTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
          bankTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);
          
          /**********************************************************************
           *
           * Selects specific records from the table:
           * Limit number of rows selected to "100" (just an example)
           * Change "WHERE" condition to meet your needs.
           *
           **********************************************************************/
          bankTab.getResultSet("WHERE BANK_CODE IN "+ unionString);
          
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
          while (bankTab.next()) {
             res.add(bankTab.getTo());
             /**********************************************************************
              *
              * Print all values from the row in one line delimited by "; "
              *
              **********************************************************************/
             bankTab.print("; ");
             
             /**********************************************************************
              *
              * Fetch data from the database into local variables:
              *
              **********************************************************************/
             
          }
          
       } catch (GDAOException e) {
          e.printStackTrace();
          log.error("Cannot select from TABLE \"BANK\".");
          throw new GDAOException(e);
       } finally {
          bankTab.releaseStatement();
       }
       
       log.debug("Finished select from TABLE \"BANK\".");
       return res;
    }
}
