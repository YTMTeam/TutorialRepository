package com.lexington.mc.model.tables;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.lexington.mc.model.util.UtilCodeTypes;
import com.lexington.mc.model.util.UtilData;
import com.mallocinc.codegenerator.exceptions.GDAOException;
import com.mallocinc.database.generated.to.HouseholdTo;
import com.mallocinc.database.generated.working.HouseholdTab;
import com.mallocinc.shared.util.time.TimestampUtility;

public class DataHousehold {
	   UtilCodeTypes uct = new UtilCodeTypes();
	   final static Logger log = Logger.getLogger(DataHousehold.class.getName());
	   
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
	
	   public HouseholdTo getHouseholdByName(Connection conn, String householdName) throws GDAOException {
			HouseholdTo res = null;
			log.debug("Starting select from TABLE \"HOUSEHOLD\".");
			
			
			HouseholdTab householdTab = new HouseholdTab(conn);
			
			try {
				
				/**********************************************************************
				 *
				 * !IMPORTANT!:
				 * Use the following parameters in order to speed up SELECT
				 * and to prevent program from failing because of EXAUSTED MEMORY error:
				 * java.lang.OutOfMemoryError: Java heap space
				 *
				 **********************************************************************/
				householdTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
				householdTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);
				
				/**********************************************************************
				 *
				 * Selects specific records from the table:
				 * Limit number of rows selected to "100" (just an example)
				 * Change "WHERE" condition to meet your needs.
				 *
				 **********************************************************************/
				householdTab.getResultSet("WHERE HOUSEHOLD_NAME = ? ", householdName);
				
				/**********************************************************************
				 *
				 * Selects all records from the table - no "WHERE" condition.
				 * Both methods below are equal:
				 *
				 **********************************************************************/
				//AccountTab.getResultSet(null, (Object[])null);
				//AccountTab.getAllRecordsRs();
				
				/**********************************************************************
				 *
				 * Loop through database result set:
				 *
				 **********************************************************************/
				if (householdTab.next()) {
					res = householdTab.getTo();
					/**********************************************************************
					 *
					 * Print all values from the row in one line delimited by "; "
					 *
					 **********************************************************************/
					householdTab.print("; ");
					
					/**********************************************************************
					 *
					 * Fetch data from the database into local variables:
					 *
					 **********************************************************************/

				}
				
			} catch (GDAOException e) {
				e.printStackTrace();
				log.error("Cannot select from TABLE \"ACCOUNT\".");
				throw new GDAOException(e);
			} finally {
				householdTab.releaseStatement();
			}
			
			log.debug("Finished select from TABLE \"ACCOUNT\".");
			return res;
		}
		public BigDecimal insertTo(Connection connection, HouseholdTo household) throws GDAOException {
			BigDecimal result = null;
			String whatWeAreDoing = "\"insert()\" for TABLE \"HOUSEHOLD\"";

			log.debug("Starting " + whatWeAreDoing);

			HouseholdTab householdTab = new HouseholdTab(connection);

			try {

				/**********************************************************************
				 *
				 * Insert row in TABLE \"COURSE\" using values set in
				 * this Transfer Object courseTo.
				 *
				 * NOTE:
				 * Remember that values for Primary Key have to be unique.
				 * Transfer Object courseTo could be also
				 * created from scratch (not retrieved from the database).
				 *
				 **********************************************************************/
				result = householdTab.getNextval();
				household.setHOUSEHOLD_ID(result);
				householdTab.insert(household);

			} catch (GDAOException e) {
				e.printStackTrace();
				log.error("Cannot insert CourseTo in TABLE \"QUIZ_INSTANCE\".");
				throw new GDAOException(e);
			} finally {
				householdTab.releaseStatement();
			}

			log.debug("Ending " + whatWeAreDoing);
			return result;
		}

	
}
