//package com.lexington.mc.model.views;
//
//import java.math.BigDecimal;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.log4j.Logger;
//
//import com.mallocinc.codegenerator.exceptions.GDAOException;
//import com.mallocinc.database.generated.to.VAddressAssetBalanceTo;
//import com.mallocinc.database.generated.working.VAddressAssetBalanceTab;
//
//public class DataVAddressAssetBalance {
//	 final static Logger log = Logger.getLogger(DataVAddressAssetBalance.class.getName());
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
//
//	    /**********************************************************************
//	    *
//	    * main()
//	     * @throws GDAOException 
//	    *
//	    **********************************************************************/
//	public  VAddressAssetBalanceTo getBalanceByAddressAsset(BigDecimal address_Id, BigDecimal asset_Id, Connection connection) throws GDAOException{
//		VAddressAssetBalanceTo res=null;
//		  log.debug("Starting select from VIEW \"V_ADDRESS_ASSET_BALANCE\".");
//
//          java.math.BigDecimal addressId = null;
//    java.lang.String addressName = null;
//    java.math.BigDecimal assetId = null;
//    java.lang.String assetName = null;
//    java.math.BigDecimal assetBalance = null;
//
//
//    VAddressAssetBalanceTab vAddressAssetBalanceTab = new VAddressAssetBalanceTab(connection);
//
//    try {
//
//       /**********************************************************************
//        *
//        * !IMPORTANT!:
//        * Use the following parameters in order to speed up SELECT
//        * and to prevent program from failing because of EXAUSTED MEMORY error:
//        * java.lang.OutOfMemoryError: Java heap space
//        *
//        **********************************************************************/
//       vAddressAssetBalanceTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
//       vAddressAssetBalanceTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);
//
//       /**********************************************************************
//        *
//        * Selects specific records from the table:
//        * Limit number of rows selected to "100" (just an example)
//        * Change "WHERE" condition to meet your needs.
//        *
//        **********************************************************************/
//       vAddressAssetBalanceTab.getResultSet("WHERE ADDRESS_ID = ? AND ASSET_ID = ?",address_Id,asset_Id);
//
//       /**********************************************************************
//        *
//        * Selects all records from the table - no "WHERE" condition.
//        * Both methods below are equal:
//        *
//        **********************************************************************/
//       //vAddressAssetBalanceTab.getResultSet(null, (Object[])null);
//       //vAddressAssetBalanceTab.getAllRecordsRs();
//
//       /**********************************************************************
//        *
//        * Loop through database result set:
//        *
//        **********************************************************************/
//       if (vAddressAssetBalanceTab.next()) {
//    	   
//          /**********************************************************************
//          *
//          * Print all values from the row in one line delimited by "; "
//          *
//          **********************************************************************/
//          vAddressAssetBalanceTab.print("; ");
//
//          /**********************************************************************
//          *
//          * Fetch data from the database into local variables:
//          *
//          **********************************************************************/
//                addressId = vAddressAssetBalanceTab.getADDRESS_ID();
//    addressName = vAddressAssetBalanceTab.getADDRESS_NAME();
//    assetId = vAddressAssetBalanceTab.getASSET_ID();
//    assetName = vAddressAssetBalanceTab.getASSET_NAME();
//    assetBalance = vAddressAssetBalanceTab.getASSET_BALANCE();
//
//
//          /**********************************************************************
//          *
//          * Print all values from the row - one line per column:
//          *
//          **********************************************************************/
//             log.debug(String.format("%-30s [%s]", "addressId", addressId));
//    log.debug(String.format("%-30s [%s]", "addressName", addressName));
//    log.debug(String.format("%-30s [%s]", "assetId", assetId));
//    log.debug(String.format("%-30s [%s]", "assetName", assetName));
//    log.debug(String.format("%-30s [%s]", "assetBalance", assetBalance));
// 
//
//          log.debug("---------------^^^^^^^^^-----------------");
//       }
//
//    } catch (GDAOException e) {
//       e.printStackTrace();
//       log.error("Cannot select from VIEW \"V_ADDRESS_ASSET_BALANCE\".");
//       throw new GDAOException(e);
//    } finally {
//       vAddressAssetBalanceTab.releaseStatement();
//    }
//
//    log.debug("Finished select from VIEW \"V_ADDRESS_ASSET_BALANCE\".");
//		return res;
//	}
//
//
//		public List<VAddressAssetBalanceTo> getAllAddressBalances(Connection conn, BigDecimal address_id) throws GDAOException {
//			List<VAddressAssetBalanceTo> res=new ArrayList<>();
//			  log.debug("Starting select from VIEW \"V_ADDRESS_ASSET_BALANCE\".");
//
//	          java.math.BigDecimal addressId = null;
//	    java.lang.String addressName = null;
//	    java.math.BigDecimal assetId = null;
//	    java.lang.String assetName = null;
//	    java.math.BigDecimal assetBalance = null;
//
//
//	    VAddressAssetBalanceTab vAddressAssetBalanceTab = new VAddressAssetBalanceTab(conn);
//
//	    try {
//
//	       /**********************************************************************
//	        *
//	        * !IMPORTANT!:
//	        * Use the following parameters in order to speed up SELECT
//	        * and to prevent program from failing because of EXAUSTED MEMORY error:
//	        * java.lang.OutOfMemoryError: Java heap space
//	        *
//	        **********************************************************************/
//	       vAddressAssetBalanceTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
//	       vAddressAssetBalanceTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);
//
//	       /**********************************************************************
//	        *
//	        * Selects specific records from the table:
//	        * Limit number of rows selected to "100" (just an example)
//	        * Change "WHERE" condition to meet your needs.
//	        *
//	        **********************************************************************/
//	       vAddressAssetBalanceTab.getResultSet("WHERE ADDRESS_ID = ?",address_id);
//
//	       /**********************************************************************
//	        *
//	        * Selects all records from the table - no "WHERE" condition.
//	        * Both methods below are equal:
//	        *
//	        **********************************************************************/
//	       //vAddressAssetBalanceTab.getResultSet(null, (Object[])null);
//	       //vAddressAssetBalanceTab.getAllRecordsRs();
//
//	       /**********************************************************************
//	        *
//	        * Loop through database result set:
//	        *
//	        **********************************************************************/
//	       while (vAddressAssetBalanceTab.next()) {
//	    	   res.add(vAddressAssetBalanceTab.getTo());
//	          /**********************************************************************
//	          *
//	          * Print all values from the row in one line delimited by "; "
//	          *
//	          **********************************************************************/
//	          vAddressAssetBalanceTab.print("; ");
//
//	          /**********************************************************************
//	          *
//	          * Fetch data from the database into local variables:
//	          *
//	          **********************************************************************/
//	                addressId = vAddressAssetBalanceTab.getADDRESS_ID();
//	    addressName = vAddressAssetBalanceTab.getADDRESS_NAME();
//	    assetId = vAddressAssetBalanceTab.getASSET_ID();
//	    assetName = vAddressAssetBalanceTab.getASSET_NAME();
//	    assetBalance = vAddressAssetBalanceTab.getASSET_BALANCE();
//
//
//	          /**********************************************************************
//	          *
//	          * Print all values from the row - one line per column:
//	          *
//	          **********************************************************************/
//	             log.debug(String.format("%-30s [%s]", "addressId", addressId));
//	    log.debug(String.format("%-30s [%s]", "addressName", addressName));
//	    log.debug(String.format("%-30s [%s]", "assetId", assetId));
//	    log.debug(String.format("%-30s [%s]", "assetName", assetName));
//	    log.debug(String.format("%-30s [%s]", "assetBalance", assetBalance));
//	 
//
//	          log.debug("---------------^^^^^^^^^-----------------");
//	       }
//
//	    } catch (GDAOException e) {
//	       e.printStackTrace();
//	       log.error("Cannot select from VIEW \"V_ADDRESS_ASSET_BALANCE\".");
//	       throw new GDAOException(e);
//	    } finally {
//	       vAddressAssetBalanceTab.releaseStatement();
//	    }
//
//	    log.debug("Finished select from VIEW \"V_ADDRESS_ASSET_BALANCE\".");
//			return res;
//		}
//	
//}
