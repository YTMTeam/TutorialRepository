package com.lexington.mc.model.tables;

import java.sql.Connection;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.mallocinc.codegenerator.exceptions.GDAOException;
import com.mallocinc.database.generated.to.UsersTo;
import com.mallocinc.database.generated.working.UsersTab;

public class DataUser {

	final static Logger log = Logger.getLogger(DataUser.class.getName());

	public UsersTo getUserByUsername(Connection conn, String userName) throws GDAOException {
		UsersTo  res = null;
		log.debug("Starting select from TABLE \"USERS\".");

		UsersTab usersTab = new UsersTab(conn);

		try {

			/**********************************************************************
			 *
			 * !IMPORTANT!:
			 * Use the following parameters in order to speed up SELECT
			 * and to prevent program from failing because of EXAUSTED MEMORY error:
			 * java.lang.OutOfMemoryError: Java heap space
			 *
			 **********************************************************************/
			usersTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
			usersTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

			/**********************************************************************
			 *
			 * Selects specific records from the table:
			 * Limit number of rows selected to "100" (just an example)
			 * Change "WHERE" condition to meet your needs.
			 *
			 **********************************************************************/
			usersTab.getResultSet("WHERE USER_NAME = ? ", userName);

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
			if (usersTab.next()) {
				res = usersTab.getTo();
				/**********************************************************************
				 *
				 * Print all values from the row in one line delimited by "; "
				 *
				 **********************************************************************/
				usersTab.print("; ");

			}

		} catch (GDAOException e) {
			e.printStackTrace();
			log.error("Cannot select from TABLE \"USERS\".");
			throw new GDAOException(e);
		} finally {
			usersTab.releaseStatement();
		}

		log.debug("Finished select from TABLE \"USERS\".");
		return res;
	}
}
