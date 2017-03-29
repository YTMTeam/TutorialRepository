package com.lexington.mc.model.views;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.mallocinc.codegenerator.exceptions.GDAOException;
import com.mallocinc.database.generated.to.VExcelTradeTo;
import com.mallocinc.database.generated.working.VExcelPositionTab;
import com.mallocinc.database.generated.working.VExcelTradeTab;

public class DataVExcelPosition {
	final static Logger log = Logger.getLogger(DataVExcelPosition.class.getName());

	public VExcelPositionTab getExcelDataForPositionbyAccountId(Connection conn, String account) throws GDAOException {
		ArrayList<VExcelTradeTo>  res= new ArrayList<>();
		log.debug("Starting select from VIEW \"V_EXCEL_POSITION\".");


		VExcelPositionTab vExcelPositionTab = new VExcelPositionTab(conn);

		try {

			/**********************************************************************
			 *
			 * !IMPORTANT!:
			 * Use the following parameters in order to speed up SELECT
			 * and to prevent program from failing because of EXAUSTED MEMORY error:
			 * java.lang.OutOfMemoryError: Java heap space
			 *
			 **********************************************************************/
			vExcelPositionTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
			vExcelPositionTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

			/**********************************************************************
			 *
			 * Selects specific records from the table:
			 * Limit number of rows selected to "100" (just an example)
			 * Change "WHERE" condition to meet your needs.
			 *
			 **********************************************************************/
			vExcelPositionTab.getResultSet("WHERE ACCOUNT_ID = ?",account);
			
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
			log.error("Cannot select from TABLE \"V_EXCEL_POSITION\".");
			throw new GDAOException(e);
		} 
		
		log.debug("Finished select from TABLE \"V_EXCEL_POSITION\".");
		return vExcelPositionTab;
	}
	}
