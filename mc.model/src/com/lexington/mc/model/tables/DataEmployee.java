package com.lexington.mc.model.tables;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.lexington.mc.model.util.UtilCodeTypes;
import com.lexington.mc.model.util.UtilData;
import com.mallocinc.codegenerator.exceptions.GDAOException;
import com.mallocinc.database.generated.to.EmployeeTo;
import com.mallocinc.database.generated.working.EmployeeTab;

public class DataEmployee {
	UtilCodeTypes uct = new UtilCodeTypes();
	final static Logger log = Logger.getLogger(DataEmployee.class.getName());

	/**********************************************************************
	 *
	 * TRANSACTION_STRATEGY_TRESHOLD is the number of records that will be
	 * changed and it is used to determine most optimum strategy for executing
	 * the task. In order to get the best results this number should be
	 * determined by experience or by experimenting.
	 *
	 **********************************************************************/
	final static long TRANSACTION_STRATEGY_TRESHOLD = 100000;

	/**********************************************************************
	 *
	 * TRANSACTION_TRESHOLD identifies number of updates/inserts or deletes in
	 * one database transaction. In order to get the best results this number
	 * should be determined by experience or by experimenting.
	 *
	 **********************************************************************/
	final static long TRANSACTION_TRESHOLD = 1000;

	UtilData utilData = new UtilData();

	public ArrayList<EmployeeTo> getEmployeeByBankId(Connection conn, BigDecimal bankId) throws GDAOException {
		ArrayList<EmployeeTo> res = new ArrayList<>();
		log.debug("Starting select from TABLE \"EMPLOYEE\".");

		EmployeeTab employeeTab = new EmployeeTab(conn);

		try {

			/**********************************************************************
			 *
			 * !IMPORTANT!: Use the following parameters in order to speed up
			 * SELECT and to prevent program from failing because of EXAUSTED
			 * MEMORY error: java.lang.OutOfMemoryError: Java heap space
			 *
			 **********************************************************************/
			employeeTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
			employeeTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

			/**********************************************************************
			 *
			 * Selects specific records from the table: Limit number of rows
			 * selected to "100" (just an example) Change "WHERE" condition to
			 * meet your needs.
			 *
			 **********************************************************************/
			employeeTab.getResultSet("WHERE BANK_ID = ?", bankId);

			/**********************************************************************
			 *
			 * Selects all records from the table - no "WHERE" condition. Both
			 * methods below are equal:
			 *
			 **********************************************************************/
			// AccountTab.getResultSet(null, (Object[])null);
			// AccountTab.getAllRecordsRs();

			/**********************************************************************
			 *
			 * Loop through database result set:
			 *
			 **********************************************************************/
			while (employeeTab.next()) {
				res.add(employeeTab.getTo());
				/**********************************************************************
				 *
				 * Print all values from the row in one line delimited by "; "
				 *
				 **********************************************************************/
				employeeTab.print("; ");

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
			log.error("Cannot select from TABLE \"EMPLOYEE\".");
			throw new GDAOException(e);
		} finally {
			employeeTab.releaseStatement();
		}

		log.debug("Finished select from TABLE \"EMPLOYEE\".");
		return res;
	}

	public EmployeeTo getEmployeeById(Connection conn, String employeeId) throws GDAOException {
		EmployeeTo res = null;
		log.debug("Starting select from TABLE \"EMPLOYEE\".");

		EmployeeTab employeeTab = new EmployeeTab(conn);

		try {

			employeeTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
			employeeTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

			employeeTab.getResultSet("WHERE EMPLOYEE_ID = ?", employeeId);

			if (employeeTab.next()) {
				res = employeeTab.getTo();

				employeeTab.print("; ");

			}

		} catch (GDAOException e) {
			e.printStackTrace();
			log.error("Cannot select from TABLE \"EMPLOYEE\".");
			throw new GDAOException(e);
		} finally {
			employeeTab.releaseStatement();
		}

		log.debug("Finished select from TABLE \"EMPLOYEE\".");
		return res;
	}
}
