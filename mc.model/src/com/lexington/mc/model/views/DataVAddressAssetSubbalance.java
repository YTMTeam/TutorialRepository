//package com.lexington.mc.model.views;
//
//import java.math.BigDecimal;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//
//import org.apache.log4j.Logger;
//
//import com.mallocinc.codegenerator.exceptions.GDAOException;
//import com.mallocinc.database.generated.samples.oltp.VAddressAssetSubbalanceSample;
//import com.mallocinc.database.generated.to.VAddressAssetSubbalanceTo;
//import com.mallocinc.database.generated.working.VAddressAssetSubbalanceTab;
//
//public class DataVAddressAssetSubbalance {
//
//
//	   final static Logger log = Logger.getLogger(VAddressAssetSubbalanceSample.class.getName());
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
//	   public ArrayList<VAddressAssetSubbalanceTo> getLastAddressAsssetBalances(Connection connection, BigDecimal address_id, BigDecimal asset_id, int numberOfChanges) throws GDAOException {
//		   
//		   ArrayList<VAddressAssetSubbalanceTo> res=new ArrayList<>();
//		   
//		      log.debug("Starting select from VIEW \"V_ADDRESS_ASSET_SUBBALANCE\".");
//
//		            java.math.BigDecimal addressId = null;
//		      java.lang.String addressName = null;
//		      java.math.BigDecimal assetId = null;
//		      java.sql.Timestamp createTimestamp = null;
//		      java.lang.String assetName = null;
//		      java.math.BigDecimal assetBalance = null;
//
//
//		      VAddressAssetSubbalanceTab vAddressAssetSubbalanceTab = new VAddressAssetSubbalanceTab(connection);
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
//		         vAddressAssetSubbalanceTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
//		         vAddressAssetSubbalanceTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);
//
//		         /**********************************************************************
//		          *
//		          * Selects specific records from the table:
//		          * Limit number of rows selected to "100" (just an example)
//		          * Change "WHERE" condition to meet your needs.
//		          *
//		          **********************************************************************/
//		         vAddressAssetSubbalanceTab.getResultSet("WHERE ADDRESS_ID = ? AND ASSET_ID= ? AND ASSET_ID IS NOT NULL AND CREATE_TIMESTAMP IS NOT NULL ORDER BY PAYMENT_ID DESC, CREATE_TIMESTAMP DESC OFFSET 0 ROWS FETCH NEXT ? ROWS ONLY", address_id, asset_id, numberOfChanges );
//
//		         /**********************************************************************
//		          *
//		          * Selects all records from the table - no "WHERE" condition.
//		          * Both methods below are equal:
//		          *
//		          **********************************************************************/
//		         //vAddressAssetSubbalanceTab.getResultSet(null, (Object[])null);
//		         //vAddressAssetSubbalanceTab.getAllRecordsRs();
//
//		         /**********************************************************************
//		          *
//		          * Loop through database result set:
//		          *
//		          **********************************************************************/
//		         while (vAddressAssetSubbalanceTab.next()) {
//		        	 res.add(vAddressAssetSubbalanceTab.getTo()); 
//		            /**********************************************************************
//		            *
//		            * Print all values from the row in one line delimited by "; "
//		            *
//		            **********************************************************************/
//		            vAddressAssetSubbalanceTab.print("; ");
//
//		            /**********************************************************************
//		            *
//		            * Fetch data from the database into local variables:
//		            *
//		            **********************************************************************/
//		                  addressId = vAddressAssetSubbalanceTab.getADDRESS_ID();
//		      addressName = vAddressAssetSubbalanceTab.getADDRESS_NAME();
//		      assetId = vAddressAssetSubbalanceTab.getASSET_ID();
//		      createTimestamp = vAddressAssetSubbalanceTab.getCREATE_TIMESTAMP();
//		      assetName = vAddressAssetSubbalanceTab.getASSET_NAME();
//		      assetBalance = vAddressAssetSubbalanceTab.getASSET_BALANCE();
//
//
//		            /**********************************************************************
//		            *
//		            * Print all values from the row - one line per column:
//		            *
//		            **********************************************************************/
//		               log.debug(String.format("%-30s [%s]", "addressId", addressId));
//		      log.debug(String.format("%-30s [%s]", "addressName", addressName));
//		      log.debug(String.format("%-30s [%s]", "assetId", assetId));
//		      log.debug(String.format("%-30s [%s]", "createTimestamp", createTimestamp));
//		      log.debug(String.format("%-30s [%s]", "assetName", assetName));
//		      log.debug(String.format("%-30s [%s]", "assetBalance", assetBalance));
//		   
//
//		            log.debug("---------------^^^^^^^^^-----------------");
//		         }
//
//		      } catch (GDAOException e) {
//		         e.printStackTrace();
//		         log.error("Cannot select from VIEW \"V_ADDRESS_ASSET_SUBBALANCE\".");
//		         throw new GDAOException(e);
//		      } finally {
//		         vAddressAssetSubbalanceTab.releaseStatement();
//		      }
//
//		      log.debug("Finished select from VIEW \"V_ADDRESS_ASSET_SUBBALANCE\".");
//		      return res;
//		   }
//	
//	
//}
