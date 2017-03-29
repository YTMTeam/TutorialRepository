package com.lexington.mc.model.views;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.mallocinc.codegenerator.exceptions.GDAOException;
import com.mallocinc.database.generated.to.VExcelMonitoredAccountsTo;
import com.mallocinc.database.generated.working.VExcelAccountTab;
import com.mallocinc.database.generated.working.VExcelMonitoredAccountsTab;

public class DataVExcelMonitoredAccount {
	final static Logger log = Logger.getLogger(DataVExcelMonitoredAccount.class.getName());

	public VExcelMonitoredAccountsTab getExcelDataForMonitoredAccountsByBankId(Connection conn, BigDecimal bankId) throws GDAOException {
		ArrayList<VExcelMonitoredAccountsTo>  res= new ArrayList<>();
		log.debug("Starting select from VIEW \"V_EXCEL_MONITORED_ACCOUNTS\".");


		VExcelMonitoredAccountsTab vExcelMonitoredAccountsTab = new VExcelMonitoredAccountsTab(conn);

		try {

			/**********************************************************************
			 *
			 * !IMPORTANT!:
			 * Use the following parameters in order to speed up SELECT
			 * and to prevent program from failing because of EXAUSTED MEMORY error:
			 * java.lang.OutOfMemoryError: Java heap space
			 *
			 **********************************************************************/
			vExcelMonitoredAccountsTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
			vExcelMonitoredAccountsTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

			/**********************************************************************
			 *
			 * Selects specific records from the table:
			 * Limit number of rows selected to "100" (just an example)
			 * Change "WHERE" condition to meet your needs.
			 *
			 **********************************************************************/
			vExcelMonitoredAccountsTab.getResultSet("WHERE MONITOR_BANK_ID = ?", bankId);
			
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
		

		} catch (GDAOException e) {
			e.printStackTrace();
			log.error("Cannot select from TABLE \"V_EXCEL_MONITORED_ACCOUNTS\".");
			throw new GDAOException(e);
		} 
		
		log.debug("Finished select from TABLE \"V_EXCEL_MONITORED_ACCOUNTS\".");
		return vExcelMonitoredAccountsTab;
	}
	}
