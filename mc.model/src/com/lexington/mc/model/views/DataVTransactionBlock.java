//package com.lexington.mc.model.views;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.log4j.Logger;
//
//import com.lexington.mc.model.util.UtilData;
//import com.mallocinc.codegenerator.exceptions.GDAOException;
//import com.mallocinc.database.generated.to.VTransactionBlockTo;
//import com.mallocinc.database.generated.working.BlockTab;
//import com.mallocinc.database.generated.working.VTransactionBlockTab;
//
//public class DataVTransactionBlock {
//	final static Logger log = Logger.getLogger(DataVTransactionBlock.class.getName());
//	   
//    /**********************************************************************
//    *
//    * TRANSACTION_STRATEGY_TRESHOLD is the number of records that will 
//    * be changed and it is used to determine most optimum strategy
//    * for executing the task. 
//    * In order to get the best results this number should be determined 
//    * by experience or by experimenting.
//    *
//    **********************************************************************/
//   final static long TRANSACTION_STRATEGY_TRESHOLD = 100000;
//   
//    /**********************************************************************
//    *
//    * TRANSACTION_TRESHOLD identifies number of updates/inserts or deletes
//    * in one database transaction.
//    * In order to get the best results this number should be determined 
//    * by experience or by experimenting.
//    *
//    **********************************************************************/
//   final static long TRANSACTION_TRESHOLD = 1000;
//   UtilData utilData=new UtilData();
//   
//	public List<VTransactionBlockTo> getTxBlocksForPaging(Connection conn, int first, int pageSize, String sortField,
//			String sortOrder, Map<String, Object> filters) throws GDAOException {
//		List<VTransactionBlockTo> res=new ArrayList<>();
//	      log.debug("Starting select from VIEW \"V_TRANSACTION_BLOCK\".");
//
//	            java.math.BigDecimal transactionId = null;
//	      java.lang.String transactionHash = null;
//	      java.math.BigDecimal version = null;
//	      java.math.BigDecimal locktime = null;
//	      java.math.BigDecimal blockId = null;
//	      java.sql.Timestamp createTimestamp = null;
//	      java.lang.String blockHash = null;
//	      java.math.BigDecimal height = null;
//
//
//	      VTransactionBlockTab vTransactionBlockTab = new VTransactionBlockTab(conn);
//
//	      try {
//
//	         /**********************************************************************
//	          *
//	          * !IMPORTANT!:
//	          * Use the following parameters in order to speed up SELECT
//	          * and to prevent program from failing because of EXAUSTED MEMORY error:
//	          * java.lang.OutOfMemoryError: Java heap space
//	          *
//	          **********************************************************************/
//	         vTransactionBlockTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
//	         vTransactionBlockTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);
//
//	         /**********************************************************************
//	          *
//	          * Selects specific records from the table:
//	          * Limit number of rows selected to "100" (just an example)
//	          * Change "WHERE" condition to meet your needs.
//	          *
//	          **********************************************************************/
//	         vTransactionBlockTab.getResultSet(utilData.preparePagingStatementString(first, pageSize, sortField, sortOrder, filters, true));
//
//	         /**********************************************************************
//	          *
//	          * Selects all records from the table - no "WHERE" condition.
//	          * Both methods below are equal:
//	          *
//	          **********************************************************************/
//	         //vTransactionBlockTab.getResultSet(null, (Object[])null);
//	         //vTransactionBlockTab.getAllRecordsRs();
//
//	         /**********************************************************************
//	          *
//	          * Loop through database result set:
//	          *
//	          **********************************************************************/
//	         while (vTransactionBlockTab.next()) {
//res.add(vTransactionBlockTab.getTo());
//	            /**********************************************************************
//	            *
//	            * Print all values from the row in one line delimited by "; "
//	            *
//	            **********************************************************************/
//	            vTransactionBlockTab.print("; ");
//
//	            /**********************************************************************
//	            *
//	            * Fetch data from the database into local variables:
//	            *
//	            **********************************************************************/
//	                  transactionId = vTransactionBlockTab.getTRANSACTION_ID();
//	      transactionHash = vTransactionBlockTab.getTRANSACTION_HASH();
//	      version = vTransactionBlockTab.getVERSION();
//	      locktime = vTransactionBlockTab.getLOCKTIME();
//	      blockId = vTransactionBlockTab.getBLOCK_ID();
//	      createTimestamp = vTransactionBlockTab.getCREATE_TIMESTAMP();
//	      blockHash = vTransactionBlockTab.getBLOCK_HASH();
//	      height = vTransactionBlockTab.getHEIGHT();
//
//
//	            /**********************************************************************
//	            *
//	            * Print all values from the row - one line per column:
//	            *
//	            **********************************************************************/
//	               log.debug(String.format("%-30s [%s]", "transactionId", transactionId));
//	      log.debug(String.format("%-30s [%s]", "transactionHash", transactionHash));
//	      log.debug(String.format("%-30s [%s]", "version", version));
//	      log.debug(String.format("%-30s [%s]", "locktime", locktime));
//	      log.debug(String.format("%-30s [%s]", "blockId", blockId));
//	      log.debug(String.format("%-30s [%s]", "createTimestamp", createTimestamp));
//	      log.debug(String.format("%-30s [%s]", "blockHash", blockHash));
//	      log.debug(String.format("%-30s [%s]", "height", height));
//	   
//
//	            log.debug("---------------^^^^^^^^^-----------------");
//	         }
//
//	      } catch (GDAOException e) {
//	         e.printStackTrace();
//	         log.error("Cannot select from VIEW \"V_TRANSACTION_BLOCK\".");
//	         throw new GDAOException(e);
//	      } finally {
//	         vTransactionBlockTab.releaseStatement();
//	      }
//
//	      log.debug("Finished select from VIEW \"V_TRANSACTION_BLOCK\".");
//	      return res;
//	}
//
//	public long getTxBlocksFilterCount(Connection conn, Map<String, Object> filters) throws GDAOException {
//		long rowCount=0;
//		 VTransactionBlockTab vTransactionBlockTab = new VTransactionBlockTab(conn);
//
//	      try {
//
//	    	  vTransactionBlockTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
//	    	  vTransactionBlockTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);
//
//	      
//	           rowCount = vTransactionBlockTab.getRowCount(utilData.prepareCountString(filters, true));
//
//	  
//
//	      } catch (GDAOException e) {
//	         e.printStackTrace();
//	         log.error("Cannot select from TABLE \"BLOCK\".");
//	         throw new GDAOException(e);
//	      } finally {
//	    	  vTransactionBlockTab.releaseStatement();
//	      }
//
//	      log.debug("Finished count from VIEW \"V_TRANSACTION_BLOCK\".");
//	      return rowCount;
//	}
//
//	public List<VTransactionBlockTo> getNewestTransactions(Connection conn, int numberOfTxs) throws GDAOException {
//		List<VTransactionBlockTo> res=new ArrayList<>();
//	      log.debug("Starting select from VIEW \"V_TRANSACTION_BLOCK\".");
//
//	            java.math.BigDecimal transactionId = null;
//	      java.lang.String transactionHash = null;
//	      java.math.BigDecimal version = null;
//	      java.math.BigDecimal locktime = null;
//	      java.math.BigDecimal blockId = null;
//	      java.sql.Timestamp createTimestamp = null;
//	      java.lang.String blockHash = null;
//	      java.math.BigDecimal height = null;
//
//
//	      VTransactionBlockTab vTransactionBlockTab = new VTransactionBlockTab(conn);
//
//	      try {
//
//	         /**********************************************************************
//	          *
//	          * !IMPORTANT!:
//	          * Use the following parameters in order to speed up SELECT
//	          * and to prevent program from failing because of EXAUSTED MEMORY error:
//	          * java.lang.OutOfMemoryError: Java heap space
//	          *
//	          **********************************************************************/
//	         vTransactionBlockTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
//	         vTransactionBlockTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);
//
//	         /**********************************************************************
//	          *
//	          * Selects specific records from the table:
//	          * Limit number of rows selected to "100" (just an example)
//	          * Change "WHERE" condition to meet your needs.
//	          *
//	          **********************************************************************/
//	         
//	         vTransactionBlockTab.getResultSet("ORDER BY CREATE_TIMESTAMP DESC OFFSET 0 ROWS FETCH NEXT ? ROWS ONLY", numberOfTxs);
//
//	         /**********************************************************************
//	          *
//	          * Selects all records from the table - no "WHERE" condition.
//	          * Both methods below are equal:
//	          *
//	          **********************************************************************/
//	         //vTransactionBlockTab.getResultSet(null, (Object[])null);
//	         //vTransactionBlockTab.getAllRecordsRs();
//
//	         /**********************************************************************
//	          *
//	          * Loop through database result set:
//	          *
//	          **********************************************************************/
//	         while (vTransactionBlockTab.next()) {
//res.add(vTransactionBlockTab.getTo());
//	            /**********************************************************************
//	            *
//	            * Print all values from the row in one line delimited by "; "
//	            *
//	            **********************************************************************/
//	            vTransactionBlockTab.print("; ");
//
//	            /**********************************************************************
//	            *
//	            * Fetch data from the database into local variables:
//	            *
//	            **********************************************************************/
//	                  transactionId = vTransactionBlockTab.getTRANSACTION_ID();
//	      transactionHash = vTransactionBlockTab.getTRANSACTION_HASH();
//	      version = vTransactionBlockTab.getVERSION();
//	      locktime = vTransactionBlockTab.getLOCKTIME();
//	      blockId = vTransactionBlockTab.getBLOCK_ID();
//	      createTimestamp = vTransactionBlockTab.getCREATE_TIMESTAMP();
//	      blockHash = vTransactionBlockTab.getBLOCK_HASH();
//	      height = vTransactionBlockTab.getHEIGHT();
//
//
//	            /**********************************************************************
//	            *
//	            * Print all values from the row - one line per column:
//	            *
//	            **********************************************************************/
//	               log.debug(String.format("%-30s [%s]", "transactionId", transactionId));
//	      log.debug(String.format("%-30s [%s]", "transactionHash", transactionHash));
//	      log.debug(String.format("%-30s [%s]", "version", version));
//	      log.debug(String.format("%-30s [%s]", "locktime", locktime));
//	      log.debug(String.format("%-30s [%s]", "blockId", blockId));
//	      log.debug(String.format("%-30s [%s]", "createTimestamp", createTimestamp));
//	      log.debug(String.format("%-30s [%s]", "blockHash", blockHash));
//	      log.debug(String.format("%-30s [%s]", "height", height));
//	   
//
//	            log.debug("---------------^^^^^^^^^-----------------");
//	         }
//
//	      } catch (GDAOException e) {
//	         e.printStackTrace();
//	         log.error("Cannot select from VIEW \"V_TRANSACTION_BLOCK\".");
//	         throw new GDAOException(e);
//	      } finally {
//	         vTransactionBlockTab.releaseStatement();
//	      }
//
//	      log.debug("Finished select from VIEW \"V_TRANSACTION_BLOCK\".");
//	      return res;
//	}
//
//}
