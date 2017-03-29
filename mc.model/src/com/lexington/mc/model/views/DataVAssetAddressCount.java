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
//import com.mallocinc.database.generated.samples.oltp.VAssetAddressCountSample;
//import com.mallocinc.database.generated.to.VAssetAddressCountTo;
//import com.mallocinc.database.generated.working.VAssetAddressCountTab;
//
//public class DataVAssetAddressCount {
//		UtilData utilData= new UtilData();
//	
//	  final static Logger log = Logger.getLogger(VAssetAddressCountSample.class.getName());
//	   
//	    /**********************************************************************
//	    *
//	    * TRANSACTION_STRATEGY_TRESHOLD is the number of records that will 
//	    * be changed and it is used to determine most optimum strategy
//	    * for executing the task. 
//	    * In order to get the best results this number should be determined 
//	    * by experience or by experimenting.
//	    *
//	    **********************************************************************/
//	   final static long TRANSACTION_STRATEGY_TRESHOLD = 100000;
//	   
//	    /**********************************************************************
//	    *
//	    * TRANSACTION_TRESHOLD identifies number of updates/inserts or deletes
//	    * in one database transaction.
//	    * In order to get the best results this number should be determined 
//	    * by experience or by experimenting.
//	    *
//	    **********************************************************************/
//	   final static long TRANSACTION_TRESHOLD = 1000;
//
//		public long getVAssetAddressCountFilterCount(Connection conn, Map<String, Object> filters) throws GDAOException {
//			  log.debug("Starting select from VIEW \"V_ASSET_ADDRESS_COUNT\".");
//			  long rowCount = 0;
//	          
//
//
//	      VAssetAddressCountTab vAssetAddressCountTab = new VAssetAddressCountTab(conn);
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
//	         vAssetAddressCountTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
//	         vAssetAddressCountTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);
//
//	         /**********************************************************************
//	          *
//	          * Selects specific records from the table:
//	          * Limit number of rows selected to "100" (just an example)
//	          * Change "WHERE" condition to meet your needs.
//	          *
//	          **********************************************************************/
//	           rowCount = vAssetAddressCountTab.getRowCount(utilData.prepareCountString(filters, true));
//
//	         /**********************************************************************
//	          *
//	          * Selects all records from the table - no "WHERE" condition.
//	          * Both methods below are equal:
//	          *
//	          **********************************************************************/
//	         //vAssetAddressCountTab.getResultSet(null, (Object[])null);
//	         //vAssetAddressCountTab.getAllRecordsRs();
//
//	         /**********************************************************************
//	          *
//	          * Loop through database result set:
//	          *
//	          **********************************************************************/
//	          
//
//	      } catch (GDAOException e) {
//	         e.printStackTrace();
//	         log.error("Cannot select from VIEW \"V_ASSET_ADDRESS_COUNT\".");
//	         throw new GDAOException(e);
//	      } finally {
//	         vAssetAddressCountTab.releaseStatement();
//	      }
//
//	      log.debug("Finished select from VIEW \"V_ASSET_ADDRESS_COUNT\".");
//	      return rowCount;
//		}
//
//		public List<VAssetAddressCountTo> getVAssetAddressCountForPaging(Connection conn, int first, int pageSize,
//				String sortField, String sortOrder, Map<String, Object> filters) throws GDAOException {
//			List<VAssetAddressCountTo> res= new ArrayList<>();
//		      log.debug("Starting select from VIEW \"V_ASSET_ADDRESS_COUNT\".");
//
//		            java.math.BigDecimal assetId = null;
//		      java.lang.String assetName = null;
//		      java.lang.String issueTransactionId = null;
//		      java.math.BigDecimal multiple = null;
//		      java.math.BigDecimal assetReference = null;
//		      java.math.BigDecimal unitsQuantity = null;
//		      java.lang.String openFlag = null;
//		      java.math.BigDecimal securityType = null;
//		      java.math.BigDecimal lastQuantity = null;
//		      java.sql.Timestamp tradeDate = null;
//		      java.sql.Timestamp businessDate = null;
//		      java.sql.Timestamp settlementDate = null;
//		      java.lang.String currency = null;
//		      java.lang.String settlementCurrency = null;
//		      java.math.BigDecimal lastSpotRate = null;
//		      java.math.BigDecimal issueQuantity = null;
//		      java.sql.Timestamp createTimestamp = null;
//		      java.math.BigDecimal addressCount = null;
//
//
//		      VAssetAddressCountTab vAssetAddressCountTab = new VAssetAddressCountTab(conn);
//
//		      try {
//
//		         /**********************************************************************
//		          *
//		          * !IMPORTANT!:
//		          * Use the following parameters in order to speed up SELECT
//		          * and to prevent program from failing because of EXAUSTED MEMORY error:
//		          * java.lang.OutOfMemoryError: Java heap space
//		          *
//		          **********************************************************************/
//		         vAssetAddressCountTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
//		         vAssetAddressCountTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);
//
//		         /**********************************************************************
//		          *
//		          * Selects specific records from the table:
//		          * Limit number of rows selected to "100" (just an example)
//		          * Change "WHERE" condition to meet your needs.
//		          *
//		          **********************************************************************/
//		         vAssetAddressCountTab.getResultSet(utilData.preparePagingStatementString(first, pageSize, sortField, sortOrder, filters, true));
//
//		         /**********************************************************************
//		          *
//		          * Selects all records from the table - no "WHERE" condition.
//		          * Both methods below are equal:
//		          *
//		          **********************************************************************/
//		         //vAssetAddressCountTab.getResultSet(null, (Object[])null);
//		         //vAssetAddressCountTab.getAllRecordsRs();
//
//		         /**********************************************************************
//		          *
//		          * Loop through database result set:
//		          *
//		          **********************************************************************/
//		         while (vAssetAddressCountTab.next()) {
//		        	 res.add(vAssetAddressCountTab.getTo());
//		            /**********************************************************************
//		            *
//		            * Print all values from the row in one line delimited by "; "
//		            *
//		            **********************************************************************/
//		            vAssetAddressCountTab.print("; ");
//
//		            /**********************************************************************
//		            *
//		            * Fetch data from the database into local variables:
//		            *
//		            **********************************************************************/
//		                  assetId = vAssetAddressCountTab.getASSET_ID();
//		      assetName = vAssetAddressCountTab.getASSET_NAME();
////		      issueTransactionId = vAssetAddressCountTab.getISSUE_TRANSACTION_ID();
//		      multiple = vAssetAddressCountTab.getMULTIPLE();
////		      assetReference = vAssetAddressCountTab.getASSET_REFERENCE();
//		      unitsQuantity = vAssetAddressCountTab.getUNITS_QUANTITY();
//		      openFlag = vAssetAddressCountTab.getOPEN_FLAG();
//		      securityType = vAssetAddressCountTab.getSECURITY_TYPE();
//		      lastQuantity = vAssetAddressCountTab.getLAST_QUANTITY();
//		      tradeDate = vAssetAddressCountTab.getTRADE_DATE();
//		      businessDate = vAssetAddressCountTab.getBUSINESS_DATE();
//		      settlementDate = vAssetAddressCountTab.getSETTLEMENT_DATE();
//		      currency = vAssetAddressCountTab.getCURRENCY();
//		      settlementCurrency = vAssetAddressCountTab.getSETTLEMENT_CURRENCY();
//		      lastSpotRate = vAssetAddressCountTab.getLAST_SPOT_RATE();
//		      issueQuantity = vAssetAddressCountTab.getISSUE_QUANTITY();
//		      createTimestamp = vAssetAddressCountTab.getCREATE_TIMESTAMP();
//		      addressCount = vAssetAddressCountTab.getADDRESS_COUNT();
//
//
//		            /**********************************************************************
//		            *
//		            * Print all values from the row - one line per column:
//		            *
//		            **********************************************************************/
//		               log.debug(String.format("%-30s [%s]", "assetId", assetId));
//		      log.debug(String.format("%-30s [%s]", "assetName", assetName));
//		      log.debug(String.format("%-30s [%s]", "issueTransactionId", issueTransactionId));
//		      log.debug(String.format("%-30s [%s]", "multiple", multiple));
//		      log.debug(String.format("%-30s [%s]", "assetReference", assetReference));
//		      log.debug(String.format("%-30s [%s]", "unitsQuantity", unitsQuantity));
//		      log.debug(String.format("%-30s [%s]", "openFlag", openFlag));
//		      log.debug(String.format("%-30s [%s]", "securityType", securityType));
//		      log.debug(String.format("%-30s [%s]", "lastQuantity", lastQuantity));
//		      log.debug(String.format("%-30s [%s]", "tradeDate", tradeDate));
//		      log.debug(String.format("%-30s [%s]", "businessDate", businessDate));
//		      log.debug(String.format("%-30s [%s]", "settlementDate", settlementDate));
//		      log.debug(String.format("%-30s [%s]", "currency", currency));
//		      log.debug(String.format("%-30s [%s]", "settlementCurrency", settlementCurrency));
//		      log.debug(String.format("%-30s [%s]", "lastSpotRate", lastSpotRate));
//		      log.debug(String.format("%-30s [%s]", "issueQuantity", issueQuantity));
//		      log.debug(String.format("%-30s [%s]", "createTimestamp", createTimestamp));
//		      log.debug(String.format("%-30s [%s]", "addressCount", addressCount));
//		   
//
//		            log.debug("---------------^^^^^^^^^-----------------");
//		         }
//
//		      } catch (GDAOException e) {
//		         e.printStackTrace();
//		         log.error("Cannot select from VIEW \"V_ASSET_ADDRESS_COUNT\".");
//		         throw new GDAOException(e);
//		      } finally {
//		         vAssetAddressCountTab.releaseStatement();
//		      }
//
//		      log.debug("Finished select from VIEW \"V_ASSET_ADDRESS_COUNT\".");
//		      return res;
//		}
//
//		public List<VAssetAddressCountTo> getNewestAssets(Connection conn, int numberOfAssets) throws GDAOException {
//			List<VAssetAddressCountTo> res= new ArrayList<>();
//		      log.debug("Starting select from VIEW \"V_ASSET_ADDRESS_COUNT\".");
//
//		            java.math.BigDecimal assetId = null;
//		      java.lang.String assetName = null;
//		      java.lang.String issueTransactionId = null;
//		      java.math.BigDecimal multiple = null;
//		      java.math.BigDecimal assetReference = null;
//		      java.math.BigDecimal unitsQuantity = null;
//		      java.lang.String openFlag = null;
//		      java.math.BigDecimal securityType = null;
//		      java.math.BigDecimal lastQuantity = null;
//		      java.sql.Timestamp tradeDate = null;
//		      java.sql.Timestamp businessDate = null;
//		      java.sql.Timestamp settlementDate = null;
//		      java.lang.String currency = null;
//		      java.lang.String settlementCurrency = null;
//		      java.math.BigDecimal lastSpotRate = null;
//		      java.math.BigDecimal issueQuantity = null;
//		      java.sql.Timestamp createTimestamp = null;
//		      java.math.BigDecimal addressCount = null;
//
//
//		      VAssetAddressCountTab vAssetAddressCountTab = new VAssetAddressCountTab(conn);
//
//		      try {
//
//		         /**********************************************************************
//		          *
//		          * !IMPORTANT!:
//		          * Use the following parameters in order to speed up SELECT
//		          * and to prevent program from failing because of EXAUSTED MEMORY error:
//		          * java.lang.OutOfMemoryError: Java heap space
//		          *
//		          **********************************************************************/
//		         vAssetAddressCountTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
//		         vAssetAddressCountTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);
//
//		         /**********************************************************************
//		          *
//		          * Selects specific records from the table:
//		          * Limit number of rows selected to "100" (just an example)
//		          * Change "WHERE" condition to meet your needs.
//		          *
//		          **********************************************************************/
//		         vAssetAddressCountTab.getResultSet("ORDER BY CREATE_TIMESTAMP DESC OFFSET 0 ROWS FETCH NEXT ? ROWS ONLY", numberOfAssets);
//
//		         /**********************************************************************
//		          *
//		          * Selects all records from the table - no "WHERE" condition.
//		          * Both methods below are equal:
//		          *
//		          **********************************************************************/
//		         //vAssetAddressCountTab.getResultSet(null, (Object[])null);
//		         //vAssetAddressCountTab.getAllRecordsRs();
//
//		         /**********************************************************************
//		          *
//		          * Loop through database result set:
//		          *
//		          **********************************************************************/
//		         while (vAssetAddressCountTab.next()) {
//		        	 res.add(vAssetAddressCountTab.getTo());
//		            /**********************************************************************
//		            *
//		            * Print all values from the row in one line delimited by "; "
//		            *
//		            **********************************************************************/
//		            vAssetAddressCountTab.print("; ");
//
//		            /**********************************************************************
//		            *
//		            * Fetch data from the database into local variables:
//		            *
//		            **********************************************************************/
//		                  assetId = vAssetAddressCountTab.getASSET_ID();
//		      assetName = vAssetAddressCountTab.getASSET_NAME();
////		      issueTransactionId = vAssetAddressCountTab.getISSUE_TRANSACTION_ID();
//		      multiple = vAssetAddressCountTab.getMULTIPLE();
////		      assetReference = vAssetAddressCountTab.getASSET_REFERENCE();
//		      unitsQuantity = vAssetAddressCountTab.getUNITS_QUANTITY();
//		      openFlag = vAssetAddressCountTab.getOPEN_FLAG();
//		      securityType = vAssetAddressCountTab.getSECURITY_TYPE();
//		      lastQuantity = vAssetAddressCountTab.getLAST_QUANTITY();
//		      tradeDate = vAssetAddressCountTab.getTRADE_DATE();
//		      businessDate = vAssetAddressCountTab.getBUSINESS_DATE();
//		      settlementDate = vAssetAddressCountTab.getSETTLEMENT_DATE();
//		      currency = vAssetAddressCountTab.getCURRENCY();
//		      settlementCurrency = vAssetAddressCountTab.getSETTLEMENT_CURRENCY();
//		      lastSpotRate = vAssetAddressCountTab.getLAST_SPOT_RATE();
//		      issueQuantity = vAssetAddressCountTab.getISSUE_QUANTITY();
//		      createTimestamp = vAssetAddressCountTab.getCREATE_TIMESTAMP();
//		      addressCount = vAssetAddressCountTab.getADDRESS_COUNT();
//
//
//		            /**********************************************************************
//		            *
//		            * Print all values from the row - one line per column:
//		            *
//		            **********************************************************************/
//		               log.debug(String.format("%-30s [%s]", "assetId", assetId));
//		      log.debug(String.format("%-30s [%s]", "assetName", assetName));
//		      log.debug(String.format("%-30s [%s]", "issueTransactionId", issueTransactionId));
//		      log.debug(String.format("%-30s [%s]", "multiple", multiple));
//		      log.debug(String.format("%-30s [%s]", "assetReference", assetReference));
//		      log.debug(String.format("%-30s [%s]", "unitsQuantity", unitsQuantity));
//		      log.debug(String.format("%-30s [%s]", "openFlag", openFlag));
//		      log.debug(String.format("%-30s [%s]", "securityType", securityType));
//		      log.debug(String.format("%-30s [%s]", "lastQuantity", lastQuantity));
//		      log.debug(String.format("%-30s [%s]", "tradeDate", tradeDate));
//		      log.debug(String.format("%-30s [%s]", "businessDate", businessDate));
//		      log.debug(String.format("%-30s [%s]", "settlementDate", settlementDate));
//		      log.debug(String.format("%-30s [%s]", "currency", currency));
//		      log.debug(String.format("%-30s [%s]", "settlementCurrency", settlementCurrency));
//		      log.debug(String.format("%-30s [%s]", "lastSpotRate", lastSpotRate));
//		      log.debug(String.format("%-30s [%s]", "issueQuantity", issueQuantity));
//		      log.debug(String.format("%-30s [%s]", "createTimestamp", createTimestamp));
//		      log.debug(String.format("%-30s [%s]", "addressCount", addressCount));
//		   
//
//		            log.debug("---------------^^^^^^^^^-----------------");
//		         }
//
//		      } catch (GDAOException e) {
//		         e.printStackTrace();
//		         log.error("Cannot select from VIEW \"V_ASSET_ADDRESS_COUNT\".");
//		         throw new GDAOException(e);
//		      } finally {
//		         vAssetAddressCountTab.releaseStatement();
//		      }
//
//		      log.debug("Finished select from VIEW \"V_ASSET_ADDRESS_COUNT\".");
//		      return res;
//		}
//}
