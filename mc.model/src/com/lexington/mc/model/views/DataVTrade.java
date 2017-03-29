package com.lexington.mc.model.views;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import org.apache.log4j.Logger;

import com.lexington.mc.model.util.UtilData;
import com.mallocinc.codegenerator.exceptions.GDAOException;
import com.mallocinc.database.generated.to.VTradeTo;
import com.mallocinc.database.generated.working.VTradeTab;

public class DataVTrade {
	final static Logger log = Logger.getLogger(DataVTrade.class.getName());

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

	public VTradeTo getPaymentById(Connection conn, BigDecimal paymentId) throws GDAOException {
		VTradeTo  res= new VTradeTo();
		log.debug("Starting select from VIEW \"V_PAYMENT\".");

		java.math.BigDecimal walletAddressId = null;
		java.math.BigDecimal transactionId = null;
		java.lang.String addressName = null;
		java.lang.String isValid = null;
		java.lang.String pubkey = null;
		java.lang.String isCompressed = null;
		java.lang.String isScript = null;
		java.lang.String type = null;


		VTradeTab VTradeTab = new VTradeTab(conn);

		try {

			/**********************************************************************
			 *
			 * !IMPORTANT!:
			 * Use the following parameters in order to speed up SELECT
			 * and to prevent program from failing because of EXAUSTED MEMORY error:
			 * java.lang.OutOfMemoryError: Java heap space
			 *
			 **********************************************************************/
			VTradeTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
			VTradeTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

			/**********************************************************************
			 *
			 * Selects specific records from the table:
			 * Limit number of rows selected to "100" (just an example)
			 * Change "WHERE" condition to meet your needs.
			 *
			 **********************************************************************/
			VTradeTab.getResultSet("WHERE PAYMENT_ID = ? ", paymentId);

			/**********************************************************************
			 *
			 * Selects all records from the table - no "WHERE" condition.
			 * Both methods below are equal:
			 *
			 **********************************************************************/
			//walletAddressTab.getResultSet(null, (Object[])null);
			//walletAddressTab.getAllRecordsRs();

			/**********************************************************************
			 *
			 * Loop through database result set:
			 *
			 **********************************************************************/
			if (VTradeTab.next()) {
				res = VTradeTab.getTo();
				/**********************************************************************
				 *
				 * Print all values from the row in one line delimited by "; "
				 *
				 **********************************************************************/
				VTradeTab.print("; ");

			}

		} catch (GDAOException e) {
			e.printStackTrace();
			log.error("Cannot select from TABLE \"WALLET_ADDRESS\".");
			throw new GDAOException(e);
		} finally {
			VTradeTab.releaseStatement();
		}

		log.debug("Finished select from TABLE \"WALLET_ADDRESS\".");
		return res;
	}
	public long getDirectionCountForUser(Connection conn, BigDecimal userId, String direction) throws GDAOException {
		long  res = 0;
		log.debug("Starting select from VIEW \"V_PAYMENT\".");

		VTradeTab VTradeTab = new VTradeTab(conn);

		try {

			/**********************************************************************
			 *
			 * !IMPORTANT!:
			 * Use the following parameters in order to speed up SELECT
			 * and to prevent program from failing because of EXAUSTED MEMORY error:
			 * java.lang.OutOfMemoryError: Java heap space
			 *
			 **********************************************************************/
			VTradeTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
			VTradeTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

			/**********************************************************************
			 *
			 * Selects specific records from the table:
			 * Limit number of rows selected to "100" (just an example)
			 * Change "WHERE" condition to meet your needs.
			 *
			 **********************************************************************/
			String queryString = "WHERE (SENDER_ADDRESS_ID =? OR RECEIVER_ADDRESS_ID =?) AND DIRECTION = ?  ";
			res = VTradeTab.getRowCount(queryString, userId, userId,direction);

		} catch (GDAOException e) {
			e.printStackTrace();
			log.error("Cannot count from VIEW \"VPAYMENT\".");
			throw new GDAOException(e);
		} finally {
			VTradeTab.releaseStatement();
		}

		log.debug("Finished count from VIEW \"VPAYMENT\".");
		return res;
	}

	public long getDirectionCountForGroup(Connection conn, BigDecimal groupId, String direction) throws GDAOException {
		long  res = 0;
		log.debug("Starting select from VIEW \"V_PAYMENT\".");

		VTradeTab VTradeTab = new VTradeTab(conn);

		try {

			/**********************************************************************
			 *
			 * !IMPORTANT!:
			 * Use the following parameters in order to speed up SELECT
			 * and to prevent program from failing because of EXAUSTED MEMORY error:
			 * java.lang.OutOfMemoryError: Java heap space
			 *
			 **********************************************************************/
			VTradeTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
			VTradeTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

			/**********************************************************************
			 *
			 * Selects specific records from the table:
			 * Limit number of rows selected to "100" (just an example)
			 * Change "WHERE" condition to meet your needs.
			 *
			 **********************************************************************/
			String queryString = "WHERE (HOUSEHOLD_ID =?) AND DIRECTION = ?  ";

			res = VTradeTab.getRowCount(queryString, groupId,direction);

		} catch (GDAOException e) {
			e.printStackTrace();
			log.error("Cannot count from VIEW \"VPAYMENT\".");
			throw new GDAOException(e);
		} finally {
			VTradeTab.releaseStatement();
		}

		log.debug("Finished count from VIEW \"VPAYMENT\".");
		return res;
	}

	public long getAddressAssetPaymentsFilterCount(Connection conn, Map<String, Object> filters, BigDecimal addressId, BigDecimal assetId2) throws GDAOException {
		log.debug("Starting counting address payments from VIEW \"VPAYMENT\".");
		long result = 0;

		VTradeTab VTradeTab = new VTradeTab(conn);

		try {

			/**********************************************************************
			 *
			 * !IMPORTANT!:
			 * Use the following parameters in order to speed up SELECT
			 * and to prevent program from failing because of EXAUSTED MEMORY error:
			 * java.lang.OutOfMemoryError: Java heap space
			 *
			 **********************************************************************/
			VTradeTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
			VTradeTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

			/**********************************************************************
			 *
			 * Selects specific records from the table:
			 * Limit number of rows selected to "100" (just an example)
			 * Change "WHERE" condition to meet your needs.
			 *
			 **********************************************************************/
			String andCheck = utilData.checkAndClause(filters);
			String queryString = "WHERE (SENDER_ADDRESS_ID =? OR RECEIVER_ADDRESS_ID =?) AND ASSET_ID = ?  ";

			queryString += "" + andCheck + utilData.prepareCountString(filters, false);
			result = VTradeTab.getRowCount(queryString, addressId, addressId,assetId2);

		} catch (GDAOException e) {
			e.printStackTrace();
			log.error("Cannot count from VIEW \"VPAYMENT\".");
			throw new GDAOException(e);
		} finally {
			VTradeTab.releaseStatement();
		}

		log.debug("Finished count from VIEW \"VPAYMENT\".");
		return result;
	}

	public ArrayList<VTradeTo> getAddressAssetPaymentsForPaging(Connection conn, int first, int pageSize, String sortField,
			String sortOrder, Map<String, Object> filters, BigDecimal addressId, BigDecimal assetId2) throws GDAOException {
		ArrayList<VTradeTo>  res= new ArrayList<>();
		log.debug("Starting select from VIEW \"V_PAYMENT\".");

		java.math.BigDecimal paymentId = null;
		java.math.BigDecimal senderAddressId = null;
		java.lang.String senderAddressName = null;
		java.math.BigDecimal receiverAddressId = null;
		java.lang.String receiverAddressName = null;
		java.math.BigDecimal assetId = null;
		java.lang.String assetName = null;
		java.math.BigDecimal transactionId = null;
		java.lang.String transactionHash = null;
		java.math.BigDecimal quantity = null;
		java.sql.Timestamp createTimestamp = null;


		VTradeTab VTradeTab = new VTradeTab(conn);

		try {

			/**********************************************************************
			 *
			 * !IMPORTANT!:
			 * Use the following parameters in order to speed up SELECT
			 * and to prevent program from failing because of EXAUSTED MEMORY error:
			 * java.lang.OutOfMemoryError: Java heap space
			 *
			 **********************************************************************/
			VTradeTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
			VTradeTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

			/**********************************************************************
			 *
			 * Selects specific records from the table:
			 * Limit number of rows selected to "100" (just an example)
			 * Change "WHERE" condition to meet your needs.
			 *
			 **********************************************************************/
			String andCheck = utilData.checkAndClause(filters);
			String queryString = "WHERE (SENDER_ADDRESS_ID =? OR RECEIVER_ADDRESS_ID =?) AND ASSET_ID =? ";

			queryString += ""
					+ andCheck
					+ utilData.preparePagingStatementString(first, pageSize, sortField, sortOrder, filters, false);
			VTradeTab.getResultSet(queryString, addressId, addressId,assetId2);
			/**********************************************************************
			 *
			 * Selects all records from the table - no "WHERE" condition.
			 * Both methods below are equal:
			 *
			 **********************************************************************/
			//VTradeTab.getResultSet(null, (Object[])null);
			//VTradeTab.getAllRecordsRs();

			/**********************************************************************
			 *
			 * Loop through database result set:
			 *
			 **********************************************************************/
			while (VTradeTab.next()) {
				res.add(VTradeTab.getTo());
				/**********************************************************************
				 *
				 * Print all values from the row in one line delimited by "; "
				 *
				 **********************************************************************/
				VTradeTab.print("; ");

			}

		} catch (GDAOException e) {
			e.printStackTrace();
			log.error("Cannot select from VIEW \"V_PAYMENT\".");
			throw new GDAOException(e);
		} finally {
			VTradeTab.releaseStatement();
		}

		log.debug("Finished select from VIEW \"V_PAYMENT\".");
		return res;
	}
	public long getUserPaymentsFilterCount(Connection conn, Map<String, Object> filters, String addressId) throws GDAOException {
		log.debug("Starting counting address payments from VIEW \"VPAYMENT\".");
		long result = 0;

		VTradeTab VTradeTab = new VTradeTab(conn);

		try {

			/**********************************************************************
			 *
			 * !IMPORTANT!:
			 * Use the following parameters in order to speed up SELECT
			 * and to prevent program from failing because of EXAUSTED MEMORY error:
			 * java.lang.OutOfMemoryError: Java heap space
			 *
			 **********************************************************************/
			VTradeTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
			VTradeTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

			/**********************************************************************
			 *
			 * Selects specific records from the table:
			 * Limit number of rows selected to "100" (just an example)
			 * Change "WHERE" condition to meet your needs.
			 *
			 **********************************************************************/
			String andCheck = utilData.checkAndClause(filters);
			String queryString = "WHERE (ACCOUNT_ID =? OR BANK_ID =?)";

			queryString += "" + andCheck + utilData.prepareCountString(filters, false);
			result = VTradeTab.getRowCount(queryString, addressId, addressId);

		} catch (GDAOException e) {
			e.printStackTrace();
			log.error("Cannot count from VIEW \"VPAYMENT\".");
			throw new GDAOException(e);
		} finally {
			VTradeTab.releaseStatement();
		}

		log.debug("Finished count from VIEW \"VPAYMENT\".");
		return result;
	}

	public ArrayList<VTradeTo> getUserPaymentsForPaging(Connection conn, int first, int pageSize, String sortField,
			String sortOrder, Map<String, Object> filters, String addressId) throws GDAOException {
		ArrayList<VTradeTo>  res= new ArrayList<>();
		log.debug("Starting select from VIEW \"V_TRADE\".");

		java.math.BigDecimal paymentId = null;
		java.math.BigDecimal senderAddressId = null;
		java.lang.String senderAddressName = null;
		java.math.BigDecimal receiverAddressId = null;
		java.lang.String receiverAddressName = null;
		java.math.BigDecimal assetId = null;
		java.lang.String assetName = null;
		java.math.BigDecimal transactionId = null;
		java.lang.String transactionHash = null;
		java.math.BigDecimal quantity = null;
		java.sql.Timestamp createTimestamp = null;


		VTradeTab VTradeTab = new VTradeTab(conn);

		try {

			/**********************************************************************
			 *
			 * !IMPORTANT!:
			 * Use the following parameters in order to speed up SELECT
			 * and to prevent program from failing because of EXAUSTED MEMORY error:
			 * java.lang.OutOfMemoryError: Java heap space
			 *
			 **********************************************************************/
			VTradeTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
			VTradeTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

			/**********************************************************************
			 *
			 * Selects specific records from the table:
			 * Limit number of rows selected to "100" (just an example)
			 * Change "WHERE" condition to meet your needs.
			 *
			 **********************************************************************/
			String andCheck = utilData.checkAndClause(filters);
			String queryString = "WHERE (ACCOUNT_ID =? OR BANK_ID =?) ";

			queryString += ""
					+ andCheck
					+ utilData.preparePagingStatementString(first, pageSize, sortField, sortOrder, filters, false);
			VTradeTab.getResultSet(queryString, addressId, addressId);
			/**********************************************************************
			 *
			 * Selects all records from the table - no "WHERE" condition.
			 * Both methods below are equal:
			 *
			 **********************************************************************/
			//VTradeTab.getResultSet(null, (Object[])null);
			//VTradeTab.getAllRecordsRs();

			/**********************************************************************
			 *
			 * Loop through database result set:
			 *
			 **********************************************************************/
			while (VTradeTab.next()) {
				res.add(VTradeTab.getTo());
				/**********************************************************************
				 *
				 * Print all values from the row in one line delimited by "; "
				 *
				 **********************************************************************/
				VTradeTab.print("; ");


			}

		} catch (GDAOException e) {
			e.printStackTrace();
			log.error("Cannot select from VIEW \"V_PAYMENT\".");
			throw new GDAOException(e);
		} finally {
			VTradeTab.releaseStatement();
		}

		log.debug("Finished select from VIEW \"V_PAYMENT\".");
		return res;
	}
	public long getGroupPaymentsFilterCount(Connection conn, Map<String, Object> filters, BigDecimal groupId) throws GDAOException {
		log.debug("Starting counting address payments from VIEW \"VPAYMENT\".");
		long result = 0;

		VTradeTab VTradeTab = new VTradeTab(conn);

		try {

			/**********************************************************************
			 *
			 * !IMPORTANT!:
			 * Use the following parameters in order to speed up SELECT
			 * and to prevent program from failing because of EXAUSTED MEMORY error:
			 * java.lang.OutOfMemoryError: Java heap space
			 *
			 **********************************************************************/
			VTradeTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
			VTradeTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

			/**********************************************************************
			 *
			 * Selects specific records from the table:
			 * Limit number of rows selected to "100" (just an example)
			 * Change "WHERE" condition to meet your needs.
			 *
			 **********************************************************************/
			String andCheck = utilData.checkAndClause(filters);
			String queryString = "WHERE (SENDER_GROUP_ID =? OR RECEIVER_GROUP_ID =?)";

			queryString += "" + andCheck + utilData.prepareCountString(filters, false);
			result = VTradeTab.getRowCount(queryString, groupId, groupId);

		} catch (GDAOException e) {
			e.printStackTrace();
			log.error("Cannot count from VIEW \"VPAYMENT\".");
			throw new GDAOException(e);
		} finally {
			VTradeTab.releaseStatement();
		}

		log.debug("Finished count from VIEW \"VPAYMENT\".");
		return result;
	}

	public ArrayList<VTradeTo> getGroupPaymentsForPaging(Connection conn, int first, int pageSize, String sortField,
			String sortOrder, Map<String, Object> filters, BigDecimal groupId) throws GDAOException {
		ArrayList<VTradeTo>  res= new ArrayList<>();
		log.debug("Starting select from VIEW \"V_PAYMENT\".");

		java.math.BigDecimal paymentId = null;
		java.math.BigDecimal senderAddressId = null;
		java.lang.String senderAddressName = null;
		java.math.BigDecimal receiverAddressId = null;
		java.lang.String receiverAddressName = null;
		java.math.BigDecimal assetId = null;
		java.lang.String assetName = null;
		java.math.BigDecimal transactionId = null;
		java.lang.String transactionHash = null;
		java.math.BigDecimal quantity = null;
		java.sql.Timestamp createTimestamp = null;


		VTradeTab VTradeTab = new VTradeTab(conn);

		try {

			/**********************************************************************
			 *
			 * !IMPORTANT!:
			 * Use the following parameters in order to speed up SELECT
			 * and to prevent program from failing because of EXAUSTED MEMORY error:
			 * java.lang.OutOfMemoryError: Java heap space
			 *
			 **********************************************************************/
			VTradeTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
			VTradeTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

			/**********************************************************************
			 *
			 * Selects specific records from the table:
			 * Limit number of rows selected to "100" (just an example)
			 * Change "WHERE" condition to meet your needs.
			 *
			 **********************************************************************/
			String andCheck = utilData.checkAndClause(filters);
			String queryString = "WHERE (HOUSEHOLD_ID =?)";

			queryString += ""
					+ andCheck
					+ utilData.preparePagingStatementString(first, pageSize, sortField, sortOrder, filters, false);
			VTradeTab.getResultSet(queryString, groupId);
			/**********************************************************************
			 *
			 * Selects all records from the table - no "WHERE" condition.
			 * Both methods below are equal:
			 *
			 **********************************************************************/
			//VTradeTab.getResultSet(null, (Object[])null);
			//VTradeTab.getAllRecordsRs();

			/**********************************************************************
			 *
			 * Loop through database result set:
			 *
			 **********************************************************************/
			while (VTradeTab.next()) {
				res.add(VTradeTab.getTo());
				/**********************************************************************
				 *
				 * Print all values from the row in one line delimited by "; "
				 *
				 **********************************************************************/
				VTradeTab.print("; ");

			}

		} catch (GDAOException e) {
			e.printStackTrace();
			log.error("Cannot select from VIEW \"V_PAYMENT\".");
			throw new GDAOException(e);
		} finally {
			VTradeTab.releaseStatement();
		}

		log.debug("Finished select from VIEW \"V_PAYMENT\".");
		return res;
	}




}
