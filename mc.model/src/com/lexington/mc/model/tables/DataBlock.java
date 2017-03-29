package com.lexington.mc.model.tables;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.lexington.mc.model.util.UtilData;
import com.mallocinc.codegenerator.exceptions.GDAOException;
import com.mallocinc.database.generated.samples.oltp.BlockSample;
import com.mallocinc.database.generated.to.BlockTo;
import com.mallocinc.database.generated.working.BlockTab;

public class DataBlock {
	UtilData utilData=new UtilData();
	 final static Logger log = Logger.getLogger(DataBlock.class.getName());
	   
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
	
	   
	 


	public List<BlockTo> getBlocksForPaging(Connection conn, int first, int pageSize, String sortField,
			String sortOrder, Map<String, Object> filters) throws GDAOException {
		 List<BlockTo> res=new ArrayList<>();
	      log.debug("Starting select from TABLE \"BLOCK\".");

	            java.math.BigDecimal blockId = null;
	      java.lang.String miner = null;
	      java.math.BigDecimal nonce = null;
	      java.math.BigDecimal difficulty = null;
	      java.lang.String chainwork = null;
	      java.math.BigDecimal confirmations = null;
	      java.math.BigDecimal version = null;
	      java.lang.String bits = null;
	      java.lang.String merkleroot = null;
	      java.math.BigDecimal time = null;
	      java.lang.String blockHash = null;
	      java.lang.String previousBlockHash = null;
	      java.lang.String nextBlockHash = null;
	      java.math.BigDecimal height = null;
	      java.sql.Timestamp createTimestamp = null;
	      java.math.BigDecimal blockSize = null;


	      BlockTab blockTab = new BlockTab(conn);

	      try {

	         /**********************************************************************
	          *
	          * !IMPORTANT!:
	          * Use the following parameters in order to speed up SELECT
	          * and to prevent program from failing because of EXAUSTED MEMORY error:
	          * java.lang.OutOfMemoryError: Java heap space
	          *
	          **********************************************************************/
	         blockTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
	         blockTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

	         /**********************************************************************
	          *
	          * Selects specific records from the table:
	          * Limit number of rows selected to "100" (just an example)
	          * Change "WHERE" condition to meet your needs.
	          *
	          **********************************************************************/
	         blockTab.getResultSet(utilData.preparePagingStatementString(first, pageSize, sortField, sortOrder, filters, true));

	         /**********************************************************************
	          *
	          * Selects all records from the table - no "WHERE" condition.
	          * Both methods below are equal:
	          *
	          **********************************************************************/
	         //blockTab.getResultSet(null, (Object[])null);
	         //blockTab.getAllRecordsRs();

	         /**********************************************************************
	          *
	          * Loop through database result set:
	          *
	          **********************************************************************/
	         while (blockTab.next()) {
	        	 res.add(blockTab.getTo());
	            /**********************************************************************
	            *
	            * Print all values from the row in one line delimited by "; "
	            *
	            **********************************************************************/
	            blockTab.print("; ");

	            /**********************************************************************
	            *
	            * Fetch data from the database into local variables:
	            *
	            **********************************************************************/
	                  blockId = blockTab.getBLOCK_ID();
	      miner = blockTab.getMINER();
	      nonce = blockTab.getNONCE();
	      difficulty = blockTab.getDIFFICULTY();
	      chainwork = blockTab.getCHAINWORK();
	      confirmations = blockTab.getCONFIRMATIONS();
	      version = blockTab.getVERSION();
	      bits = blockTab.getBITS();
	      merkleroot = blockTab.getMERKLEROOT();
	      time = blockTab.getTIME();
	      blockHash = blockTab.getBLOCK_HASH();
	      previousBlockHash = blockTab.getPREVIOUS_BLOCK_HASH();
	      nextBlockHash = blockTab.getNEXT_BLOCK_HASH();
	      height = blockTab.getHEIGHT();
	      createTimestamp = blockTab.getCREATE_TIMESTAMP();
	      blockSize = blockTab.getBLOCK_SIZE();


	            /**********************************************************************
	            *
	            * Print all values from the row - one line per column:
	            *
	            **********************************************************************/
	               log.debug(String.format("%-30s [%s]", "blockId", blockId));
	      log.debug(String.format("%-30s [%s]", "miner", miner));
	      log.debug(String.format("%-30s [%s]", "nonce", nonce));
	      log.debug(String.format("%-30s [%s]", "difficulty", difficulty));
	      log.debug(String.format("%-30s [%s]", "chainwork", chainwork));
	      log.debug(String.format("%-30s [%s]", "confirmations", confirmations));
	      log.debug(String.format("%-30s [%s]", "version", version));
	      log.debug(String.format("%-30s [%s]", "bits", bits));
	      log.debug(String.format("%-30s [%s]", "merkleroot", merkleroot));
	      log.debug(String.format("%-30s [%s]", "time", time));
	      log.debug(String.format("%-30s [%s]", "blockHash", blockHash));
	      log.debug(String.format("%-30s [%s]", "previousBlockHash", previousBlockHash));
	      log.debug(String.format("%-30s [%s]", "nextBlockHash", nextBlockHash));
	      log.debug(String.format("%-30s [%s]", "height", height));
	      log.debug(String.format("%-30s [%s]", "createTimestamp", createTimestamp));
	      log.debug(String.format("%-30s [%s]", "blockSize", blockSize));
	   

	            log.debug("---------------^^^^^^^^^-----------------");
	         }

	      } catch (GDAOException e) {
	         e.printStackTrace();
	         log.error("Cannot select from TABLE \"BLOCK\".");
	         throw new GDAOException(e);
	      } finally {
	         blockTab.releaseStatement();
	      }

	      log.debug("Finished select from TABLE \"BLOCK\".");
	      return res;
	}


	public long getBlocksFilterCount(Connection conn, Map<String, Object> filters) throws GDAOException {
		long rowCount=0;
	      BlockTab vAssetAddressCountTab = new BlockTab(conn);

	      try {
 
	         vAssetAddressCountTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
	         vAssetAddressCountTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

	      
	           rowCount = vAssetAddressCountTab.getRowCount(utilData.prepareCountString(filters, true));

	  

	      } catch (GDAOException e) {
	         e.printStackTrace();
	         log.error("Cannot select from TABLE \"BLOCK\".");
	         throw new GDAOException(e);
	      } finally {
	         vAssetAddressCountTab.releaseStatement();
	      }

	      log.debug("Finished count from VIEW \"BLOCK\".");
	      return rowCount;
	}


	public List<BlockTo> getLatestBlocks(Connection conn, int numberOfBlocks) throws GDAOException {
		 List<BlockTo> res=new ArrayList<>();
	      log.debug("Starting select from TABLE \"BLOCK\".");

	            java.math.BigDecimal blockId = null;
	      java.lang.String miner = null;
	      java.math.BigDecimal nonce = null;
	      java.math.BigDecimal difficulty = null;
	      java.lang.String chainwork = null;
	      java.math.BigDecimal confirmations = null;
	      java.math.BigDecimal version = null;
	      java.lang.String bits = null;
	      java.lang.String merkleroot = null;
	      java.math.BigDecimal time = null;
	      java.lang.String blockHash = null;
	      java.lang.String previousBlockHash = null;
	      java.lang.String nextBlockHash = null;
	      java.math.BigDecimal height = null;
	      java.sql.Timestamp createTimestamp = null;
	      java.math.BigDecimal blockSize = null;


	      BlockTab blockTab = new BlockTab(conn);

	      try {

	         /**********************************************************************
	          *
	          * !IMPORTANT!:
	          * Use the following parameters in order to speed up SELECT
	          * and to prevent program from failing because of EXAUSTED MEMORY error:
	          * java.lang.OutOfMemoryError: Java heap space
	          *
	          **********************************************************************/
	         blockTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
	         blockTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

	         /**********************************************************************
	          *
	          * Selects specific records from the table:
	          * Limit number of rows selected to "100" (just an example)
	          * Change "WHERE" condition to meet your needs.
	          *
	          **********************************************************************/
	         blockTab.getResultSet("ORDER BY HEIGHT DESC OFFSET 0 ROWS FETCH NEXT ? ROWS ONLY", numberOfBlocks);

	         /**********************************************************************
	          *
	          * Selects all records from the table - no "WHERE" condition.
	          * Both methods below are equal:
	          *
	          **********************************************************************/
	         //blockTab.getResultSet(null, (Object[])null);
	         //blockTab.getAllRecordsRs();

	         /**********************************************************************
	          *
	          * Loop through database result set:
	          *
	          **********************************************************************/
	         while (blockTab.next()) {
	        	 res.add(blockTab.getTo());
	            /**********************************************************************
	            *
	            * Print all values from the row in one line delimited by "; "
	            *
	            **********************************************************************/
	            blockTab.print("; ");

	            /**********************************************************************
	            *
	            * Fetch data from the database into local variables:
	            *
	            **********************************************************************/
	                  blockId = blockTab.getBLOCK_ID();
	      miner = blockTab.getMINER();
	      nonce = blockTab.getNONCE();
	      difficulty = blockTab.getDIFFICULTY();
	      chainwork = blockTab.getCHAINWORK();
	      confirmations = blockTab.getCONFIRMATIONS();
	      version = blockTab.getVERSION();
	      bits = blockTab.getBITS();
	      merkleroot = blockTab.getMERKLEROOT();
	      time = blockTab.getTIME();
	      blockHash = blockTab.getBLOCK_HASH();
	      previousBlockHash = blockTab.getPREVIOUS_BLOCK_HASH();
	      nextBlockHash = blockTab.getNEXT_BLOCK_HASH();
	      height = blockTab.getHEIGHT();
	      createTimestamp = blockTab.getCREATE_TIMESTAMP();
	      blockSize = blockTab.getBLOCK_SIZE();


	            /**********************************************************************
	            *
	            * Print all values from the row - one line per column:
	            *
	            **********************************************************************/
	               log.debug(String.format("%-30s [%s]", "blockId", blockId));
	      log.debug(String.format("%-30s [%s]", "miner", miner));
	      log.debug(String.format("%-30s [%s]", "nonce", nonce));
	      log.debug(String.format("%-30s [%s]", "difficulty", difficulty));
	      log.debug(String.format("%-30s [%s]", "chainwork", chainwork));
	      log.debug(String.format("%-30s [%s]", "confirmations", confirmations));
	      log.debug(String.format("%-30s [%s]", "version", version));
	      log.debug(String.format("%-30s [%s]", "bits", bits));
	      log.debug(String.format("%-30s [%s]", "merkleroot", merkleroot));
	      log.debug(String.format("%-30s [%s]", "time", time));
	      log.debug(String.format("%-30s [%s]", "blockHash", blockHash));
	      log.debug(String.format("%-30s [%s]", "previousBlockHash", previousBlockHash));
	      log.debug(String.format("%-30s [%s]", "nextBlockHash", nextBlockHash));
	      log.debug(String.format("%-30s [%s]", "height", height));
	      log.debug(String.format("%-30s [%s]", "createTimestamp", createTimestamp));
	      log.debug(String.format("%-30s [%s]", "blockSize", blockSize));
	   

	            log.debug("---------------^^^^^^^^^-----------------");
	         }

	      } catch (GDAOException e) {
	         e.printStackTrace();
	         log.error("Cannot select from TABLE \"BLOCK\".");
	         throw new GDAOException(e);
	      } finally {
	         blockTab.releaseStatement();
	      }

	      log.debug("Finished select from TABLE \"BLOCK\".");
	      return res;
	}
	
	
}
