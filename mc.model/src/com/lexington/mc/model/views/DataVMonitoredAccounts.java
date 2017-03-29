package com.lexington.mc.model.views;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.lexington.mc.model.util.UtilData;
import com.mallocinc.codegenerator.exceptions.GDAOException;
import com.mallocinc.database.generated.to.AccountTo;
import com.mallocinc.database.generated.to.VMonitoredAccountsTo;
import com.mallocinc.database.generated.working.AccountTab;
import com.mallocinc.database.generated.working.VMonitoredAccountsTab;

public class DataVMonitoredAccounts {
	final static Logger log = Logger.getLogger(DataVMonitoredAccounts.class.getName());

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

	public List<VMonitoredAccountsTo> getMonitoredAccsByBankIdForPaging(Connection conn, int first, int pageSize, String sortField,
			String sortOrder, Map<String, Object> filters, BigDecimal bankId) throws GDAOException {
		List<VMonitoredAccountsTo> res= new ArrayList<VMonitoredAccountsTo>();
		log.debug("Starting select from VIEW \"V_MONITORED_ACCOUNTS\".");
		
		VMonitoredAccountsTab monitoredAccountsTab = new VMonitoredAccountsTab(conn);
		
		try {
			
			/**********************************************************************
			 *
			 * !IMPORTANT!:
			 * Use the following parameters in order to speed up SELECT
			 * and to prevent program from failing because of EXAUSTED MEMORY error:
			 * java.lang.OutOfMemoryError: Java heap space
			 *
			 **********************************************************************/
			monitoredAccountsTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
			monitoredAccountsTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);
			
			/**********************************************************************
			 *
			 * Selects specific records from the table:
			 * Limit number of rows selected to "100" (just an example)
			 * Change "WHERE" condition to meet your needs.
			 *
			 **********************************************************************/
	         String andCheck = utilData.checkAndClause(filters);
	         String queryString = "WHERE MONITOR_BANK_ID = ? ";
	         
	            queryString += ""
                        + andCheck
                        + utilData.preparePagingStatementString(first, pageSize, sortField, sortOrder, filters, false);
	            
			monitoredAccountsTab.getResultSet(queryString, bankId);
			
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
			while (monitoredAccountsTab.next()) {
				res.add(monitoredAccountsTab.getTo());
				/**********************************************************************
				 *
				 * Print all values from the row in one line delimited by "; "
				 *
				 **********************************************************************/
				monitoredAccountsTab.print("; ");
				
				/**********************************************************************
				 *
				 * Fetch data from the database into local variables:
				 *
				 **********************************************************************/
				
				
				log.debug("---------------^^^^^^^^^-----------------");
			}
			
		} catch (GDAOException e) {
			e.printStackTrace();
			log.error("Cannot select from TABLE \"ACCOUNT\".");
			throw new GDAOException(e);
		} finally {
			monitoredAccountsTab.releaseStatement();
		}
		
		log.debug("Finished select from TABLE \"ACCOUNT\".");
		return res;
	}
    
    public long getAccountsByBankIdFilterCount(Connection conn, Map<String, Object> filters, BigDecimal bankId) throws GDAOException {
     long rowCount=0;
     VMonitoredAccountsTab monitoredAccountsTab = new VMonitoredAccountsTab(conn);

     try {
         
           monitoredAccountsTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
           monitoredAccountsTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);
           
           String andCheck = utilData.checkAndClause(filters);
           String queryString = "WHERE MONITOR_BANK_ID =? ";
           queryString += "" + andCheck + utilData.prepareCountString(filters, false);
           
           rowCount = monitoredAccountsTab.getRowCount(queryString, bankId);

       } catch (GDAOException e) {
          e.printStackTrace();
          log.error("Cannot select from TABLE \"ACCOUNT\".");
          throw new GDAOException(e);
       } finally {
           monitoredAccountsTab.releaseStatement();
       }

       log.debug("Finished count from VIEW \"ACCOUNT\".");
       return rowCount;
 }
	

	
	/**
     * This method lazy fetches all accounts that is being monitored by inputed bank and its current status
     * @param conn
     * @param first
     * @param pageSize
     * @param sortField
     * @param sortOrder
     * @param filters
     * @param bankId
     * @return
     * @throws GDAOException
     */
    
    public List<VMonitoredAccountsTo> getMonitoredAccsByBankIdAndStatusForPaging(Connection conn, int first, int pageSize, String sortField,
          String sortOrder, Map<String, Object> filters, BigDecimal bankId, String status) throws GDAOException {
       List<VMonitoredAccountsTo> res= new ArrayList<VMonitoredAccountsTo>();
       log.debug("Starting select from VIEW \"V_MONITORED_ACCOUNTS\".");
       
       VMonitoredAccountsTab monitoredAccountsTab = new VMonitoredAccountsTab(conn);
       
       try {
          
          /**********************************************************************
           *
           * !IMPORTANT!:
           * Use the following parameters in order to speed up SELECT
           * and to prevent program from failing because of EXAUSTED MEMORY error:
           * java.lang.OutOfMemoryError: Java heap space
           *
           **********************************************************************/
          monitoredAccountsTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
          monitoredAccountsTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);
          
          /**********************************************************************
           *
           * Selects specific records from the table:
           * Limit number of rows selected to "100" (just an example)
           * Change "WHERE" condition to meet your needs.
           *
           **********************************************************************/
          String andCheck = utilData.checkAndClause(filters);
          String queryString = "WHERE MONITOR_BANK_ID = ? AND MONITOR_STATUS = ? ";
          
          queryString += ""
                + andCheck
                + utilData.preparePagingStatementString(first, pageSize, sortField, sortOrder, filters, false);
          
          monitoredAccountsTab.getResultSet(queryString, bankId, status);
          
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
          while (monitoredAccountsTab.next()) {
             res.add(monitoredAccountsTab.getTo());
             /**********************************************************************
              *
              * Print all values from the row in one line delimited by "; "
              *
              **********************************************************************/
             monitoredAccountsTab.print("; ");
             
             /**********************************************************************
              *
              * Fetch data from the database into local variables:
              *
              **********************************************************************/
             
             
             log.debug("---------------^^^^^^^^^-----------------");
          }
          
       } catch (GDAOException e) {
          e.printStackTrace();
          log.error("Cannot select from TABLE \"V_MONITORED_ACCOUNTS\".");
          throw new GDAOException(e);
       } finally {
          monitoredAccountsTab.releaseStatement();
       }
       
       log.debug("Finished select from TABLE \"V_MONITORED_ACCOUNTS\".");
       return res;
    }
    
    public long getAccountsByBankIdAndStatusFilterCount(Connection conn, Map<String, Object> filters, BigDecimal bankId, String status) throws GDAOException {
       long rowCount=0;
       VMonitoredAccountsTab monitoredAccountsTab = new VMonitoredAccountsTab(conn);

       try {
           
             monitoredAccountsTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
             monitoredAccountsTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);
             
             String andCheck = utilData.checkAndClause(filters);
             String queryString = "WHERE MONITOR_BANK_ID =? AND MONITOR_STATUS = ?";
             queryString += "" + andCheck + utilData.prepareCountString(filters, false);
             
             rowCount = monitoredAccountsTab.getRowCount(queryString, bankId, status);

         } catch (GDAOException e) {
            e.printStackTrace();
            log.error("Cannot select from TABLE \"ACCOUNT\".");
            throw new GDAOException(e);
         } finally {
             monitoredAccountsTab.releaseStatement();
         }

         log.debug("Finished count from VIEW \"ACCOUNT\".");
         return rowCount;
   }
    
    public List<VMonitoredAccountsTo> getAccountMonitors(Connection conn, String accountId) throws GDAOException {
       List<VMonitoredAccountsTo> res= new ArrayList<VMonitoredAccountsTo>();
       log.debug("Starting select from VIEW \"V_MONITORED_ACCOUNTS\".");
       
       VMonitoredAccountsTab monitoredAccountsTab = new VMonitoredAccountsTab(conn);
       
       try {
           
           /**********************************************************************
            *
            * !IMPORTANT!:
            * Use the following parameters in order to speed up SELECT
            * and to prevent program from failing because of EXAUSTED MEMORY error:
            * java.lang.OutOfMemoryError: Java heap space
            *
            **********************************************************************/
           monitoredAccountsTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
           monitoredAccountsTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);
           
           /**********************************************************************
            *
            * Selects specific records from the table:
            * Limit number of rows selected to "100" (just an example)
            * Change "WHERE" condition to meet your needs.
            *
            **********************************************************************/
           
            String queryString = "WHERE ACCOUNT_ID = ? ";
            
              
           monitoredAccountsTab.getResultSet(queryString, accountId);
           
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
           while (monitoredAccountsTab.next()) {
               res.add(monitoredAccountsTab.getTo());
               /**********************************************************************
                *
                * Print all values from the row in one line delimited by "; "
                *
                **********************************************************************/
               monitoredAccountsTab.print("; ");
               
               /**********************************************************************
                *
                * Fetch data from the database into local variables:
                *
                **********************************************************************/
               
               
               log.debug("---------------^^^^^^^^^-----------------");
           }
           
       } catch (GDAOException e) {
           e.printStackTrace();
           log.error("Cannot select from TABLE \"ACCOUNT\".");
           throw new GDAOException(e);
       } finally {
           monitoredAccountsTab.releaseStatement();
       }
       
       log.debug("Finished select from TABLE \"ACCOUNT\".");
       return res;
   }
    public List<VMonitoredAccountsTo> getBankMonitors(Connection conn, BigDecimal bankId) throws GDAOException {
       List<VMonitoredAccountsTo> res= new ArrayList<VMonitoredAccountsTo>();
       log.debug("Starting select from VIEW \"V_MONITORED_ACCOUNTS\".");
       
       VMonitoredAccountsTab monitoredAccountsTab = new VMonitoredAccountsTab(conn);
       
       try {
          
          /**********************************************************************
           *
           * !IMPORTANT!:
           * Use the following parameters in order to speed up SELECT
           * and to prevent program from failing because of EXAUSTED MEMORY error:
           * java.lang.OutOfMemoryError: Java heap space
           *
           **********************************************************************/
          monitoredAccountsTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
          monitoredAccountsTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);
          
          /**********************************************************************
           *
           * Selects specific records from the table:
           * Limit number of rows selected to "100" (just an example)
           * Change "WHERE" condition to meet your needs.
           *
           **********************************************************************/
          
          String queryString = "WHERE MONITOR_BANK_ID = ? ";
          
          
          monitoredAccountsTab.getResultSet(queryString, bankId);
          
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
          while (monitoredAccountsTab.next()) {
             res.add(monitoredAccountsTab.getTo());
             /**********************************************************************
              *
              * Print all values from the row in one line delimited by "; "
              *
              **********************************************************************/
             monitoredAccountsTab.print("; ");
             
             /**********************************************************************
              *
              * Fetch data from the database into local variables:
              *
              **********************************************************************/
             
             
             log.debug("---------------^^^^^^^^^-----------------");
          }
          
       } catch (GDAOException e) {
          e.printStackTrace();
          log.error("Cannot select from TABLE \"ACCOUNT\".");
          throw new GDAOException(e);
       } finally {
          monitoredAccountsTab.releaseStatement();
       }
       
       log.debug("Finished select from TABLE \"ACCOUNT\".");
       return res;
    }
    public List<VMonitoredAccountsTo> getMonitorsByAccountBankId(Connection conn, BigDecimal bankId) throws GDAOException {
       List<VMonitoredAccountsTo> res= new ArrayList<VMonitoredAccountsTo>();
       log.debug("Starting select from VIEW \"V_MONITORED_ACCOUNTS\".");
       
       VMonitoredAccountsTab monitoredAccountsTab = new VMonitoredAccountsTab(conn);
       
       try {
          
          /**********************************************************************
           *
           * !IMPORTANT!:
           * Use the following parameters in order to speed up SELECT
           * and to prevent program from failing because of EXAUSTED MEMORY error:
           * java.lang.OutOfMemoryError: Java heap space
           *
           **********************************************************************/
          monitoredAccountsTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
          monitoredAccountsTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);
          
          /**********************************************************************
           *
           * Selects specific records from the table:
           * Limit number of rows selected to "100" (just an example)
           * Change "WHERE" condition to meet your needs.
           *
           **********************************************************************/
          
          String queryString = "WHERE ACCOUNT_BANK_ID = ? ";
          
          
          monitoredAccountsTab.getResultSet(queryString, bankId);
          
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
          while (monitoredAccountsTab.next()) {
             res.add(monitoredAccountsTab.getTo());
             /**********************************************************************
              *
              * Print all values from the row in one line delimited by "; "
              *
              **********************************************************************/
             monitoredAccountsTab.print("; ");
             
             /**********************************************************************
              *
              * Fetch data from the database into local variables:
              *
              **********************************************************************/
             
             
             log.debug("---------------^^^^^^^^^-----------------");
          }
          
       } catch (GDAOException e) {
          e.printStackTrace();
          log.error("Cannot select from TABLE \"ACCOUNT\".");
          throw new GDAOException(e);
       } finally {
          monitoredAccountsTab.releaseStatement();
       }
       
       log.debug("Finished select from TABLE \"ACCOUNT\".");
       return res;
    }
    public List<VMonitoredAccountsTo> getMonitorsByAccountBankIdAndStatus(Connection conn, BigDecimal bankId, String status) throws GDAOException {
       List<VMonitoredAccountsTo> res= new ArrayList<VMonitoredAccountsTo>();
       log.debug("Starting select from VIEW \"V_MONITORED_ACCOUNTS\".");
       
       VMonitoredAccountsTab monitoredAccountsTab = new VMonitoredAccountsTab(conn);
       
       try {
          
          /**********************************************************************
           *
           * !IMPORTANT!:
           * Use the following parameters in order to speed up SELECT
           * and to prevent program from failing because of EXAUSTED MEMORY error:
           * java.lang.OutOfMemoryError: Java heap space
           *
           **********************************************************************/
          monitoredAccountsTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
          monitoredAccountsTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);
          
          /**********************************************************************
           *
           * Selects specific records from the table:
           * Limit number of rows selected to "100" (just an example)
           * Change "WHERE" condition to meet your needs.
           *
           **********************************************************************/
          
          String queryString = "WHERE ACCOUNT_BANK_ID = ? AND MONITOR_STATUS = ?";
          
          
          monitoredAccountsTab.getResultSet(queryString, bankId, status);
          
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
          while (monitoredAccountsTab.next()) {
             res.add(monitoredAccountsTab.getTo());
             /**********************************************************************
              *
              * Print all values from the row in one line delimited by "; "
              *
              **********************************************************************/
             monitoredAccountsTab.print("; ");
             
             /**********************************************************************
              *
              * Fetch data from the database into local variables:
              *
              **********************************************************************/
             
             
             log.debug("---------------^^^^^^^^^-----------------");
          }
          
       } catch (GDAOException e) {
          e.printStackTrace();
          log.error("Cannot select from TABLE \"ACCOUNT\".");
          throw new GDAOException(e);
       } finally {
          monitoredAccountsTab.releaseStatement();
       }
       
       log.debug("Finished select from TABLE \"ACCOUNT\".");
       return res;
    }
    public List<VMonitoredAccountsTo> getMonitoredAccountsByEmployeeId(Connection conn, String employeeId) throws GDAOException {
       List<VMonitoredAccountsTo> res= new ArrayList<VMonitoredAccountsTo>();
       log.debug("Starting select from VIEW \"V_MONITORED_ACCOUNTS\".");
       
       VMonitoredAccountsTab monitoredAccountsTab = new VMonitoredAccountsTab(conn);
       
       try {
          
          /**********************************************************************
           *
           * !IMPORTANT!:
           * Use the following parameters in order to speed up SELECT
           * and to prevent program from failing because of EXAUSTED MEMORY error:
           * java.lang.OutOfMemoryError: Java heap space
           *
           **********************************************************************/
          monitoredAccountsTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
          monitoredAccountsTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);
          
          /**********************************************************************
           *
           * Selects specific records from the table:
           * Limit number of rows selected to "100" (just an example)
           * Change "WHERE" condition to meet your needs.
           *
           **********************************************************************/
          
          String queryString = "WHERE EMPLOYEE_ID = ? ";
          
          
          monitoredAccountsTab.getResultSet(queryString, employeeId);
          
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
          while (monitoredAccountsTab.next()) {
             res.add(monitoredAccountsTab.getTo());
             /**********************************************************************
              *
              * Print all values from the row in one line delimited by "; "
              *
              **********************************************************************/
             monitoredAccountsTab.print("; ");
             
             /**********************************************************************
              *
              * Fetch data from the database into local variables:
              *
              **********************************************************************/
             
             
             log.debug("---------------^^^^^^^^^-----------------");
          }
          
       } catch (GDAOException e) {
          e.printStackTrace();
          log.error("Cannot select from TABLE \"ACCOUNT\".");
          throw new GDAOException(e);
       } finally {
          monitoredAccountsTab.releaseStatement();
       }
       
       log.debug("Finished select from TABLE \"ACCOUNT\".");
       return res;
    }
    
    public List<VMonitoredAccountsTo> getMonitoredAccsByBankIdAndStatus(Connection conn, BigDecimal bankId, String status) throws GDAOException {
       List<VMonitoredAccountsTo> res= new ArrayList<VMonitoredAccountsTo>();
       log.debug("Starting select from VIEW \"V_MONITORED_ACCOUNTS\".");
       
       VMonitoredAccountsTab monitoredAccountsTab = new VMonitoredAccountsTab(conn);
       
       try {
          
          /**********************************************************************
           *
           * !IMPORTANT!:
           * Use the following parameters in order to speed up SELECT
           * and to prevent program from failing because of EXAUSTED MEMORY error:
           * java.lang.OutOfMemoryError: Java heap space
           *
           **********************************************************************/
          monitoredAccountsTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
          monitoredAccountsTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);
          
          /**********************************************************************
           *
           * Selects specific records from the table:
           * Limit number of rows selected to "100" (just an example)
           * Change "WHERE" condition to meet your needs.
           *
           **********************************************************************/
          
          monitoredAccountsTab.getResultSet("WHERE MONITOR_BANK_ID = ? AND MONITOR_STATUS = ?", bankId, status);
          
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
          while (monitoredAccountsTab.next()) {
             res.add(monitoredAccountsTab.getTo());
             /**********************************************************************
              *
              * Print all values from the row in one line delimited by "; "
              *
              **********************************************************************/
             monitoredAccountsTab.print("; ");
             
             /**********************************************************************
              *
              * Fetch data from the database into local variables:
              *
              **********************************************************************/
             
             
             log.debug("---------------^^^^^^^^^-----------------");
          }
          
       } catch (GDAOException e) {
          e.printStackTrace();
          log.error("Cannot select from TABLE \"V_MONITORED_ACCOUNTS\".");
          throw new GDAOException(e);
       } finally {
          monitoredAccountsTab.releaseStatement();
       }
       
       log.debug("Finished select from TABLE \"V_MONITORED_ACCOUNTS\".");
       return res;
    }
}
