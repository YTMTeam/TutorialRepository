package com.mallocinc.database.generated.samples.oltp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;
import java.sql.BatchUpdateException;

import java.util.ArrayList;
import java.util.Iterator;
import java.math.BigDecimal;



import org.apache.log4j.Logger;

import com.mallocinc.codegenerator.exceptions.GDAOException;
import com.mallocinc.codegenerator.superclasses.oracle.OracleSystemTab;
import com.mallocinc.codegenerator.superclasses.oracle.BaseOracleDbEntityClass;
import com.mallocinc.dbanalyzer.vendor.oracle.OracleErrorCodes;
import com.mallocinc.shared.util.dbconnection.GDAODatabaseConnectionFactory;
import com.mallocinc.shared.util.time.TimestampUtility;

import com.mallocinc.database.generated.working.PositionTab;
import com.mallocinc.database.generated.to.PositionTo;

/**********************************************************************
 *  <pre>
 *
 *  Generated Class: PositionSample.java
 * 
 *  This is sample class that demonstrates how GDAO Working class
 *  could be used.
 *
 *  This class can be used as a starting point for coding by following
 *  this procedure:
 *  1. Move them to your package. If you leave this class in the current
 *     package, it may be overwritten next time when you generate the code.
 *  2. Change the name of the Class to something more appropriate to the
 *     function it performs (for example: "ManageUser.java")
 *  3. Use Eclipse (or other IDE) code formatter to "beautify" the code
 *  4. Edit Class to suit your needs (some helpful hints are included in
 *     the comments).
 *  5. If case of database change, generate new code and include new
 *     pieces of code in your class.
 *
 *  Template version: 3.0
 *  Template date:    NLS missing message: template_date in: templates.gdao
 *  Template file:    /templates/Oracle/SampleOLTPOracleTemplate.txt
 *  Target database:  Oracle 10g, 11g, 12c
 *
 *  "/templates/Oracle/SampleOLTPOracleTemplate.txt" must be on the CLASSPATH
 *
 *  This code is generated on: 2017-February-27 06:45:56 PM CET
 *   
 *  Sample code demonstrates:
 *  - selecting, modifying, inserting and deleting data
 *  - modifying table
 *  - batch updates
 *  - batch deletes
 *  - update and delete one records based on PK (or To object)
 *
 *  This is the template class used as a model to dynamically
 *  create similar class for every working class.
 *
 *  Sample GDAO code for TABLE "POSITION"
 *
 *  Note commented lines of code - you may need to
 *  uncomment them to use different options.
 *
 *  @author  Malloc Inc.
 *  @version 3.0
 *  @since   DBA 6.0
 *
 *  Copyright (C) 2015 Malloc Inc.
 *
 *  <pre>
 **********************************************************************/
//@SuppressWarnings("unused")
public class PositionSample {

   final static Logger log = Logger.getLogger(PositionSample.class.getName());
   
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


    /**********************************************************************
    *
    * main()
    *
    **********************************************************************/
   public static void main(String[] args) {
    
     Connection connection = null;
     Connection connection_source = null;
     Connection connection_target = null;
     
     try {
       /**********************************************************************
        *
        * Create database connections.
        * Refer to database connection definition file:
        * "conf/dbconnections/dbconnections.txt"
        *        
        **********************************************************************/
        connection = getConnection();
        connection_source = getConnection("YTM1");
        connection_target = getConnection("YTM2");

       /**********************************************************************
        *
        * Create DAO Object
        *
        **********************************************************************/
        PositionSample positionSample = new PositionSample();

        /**********************************************************************
         *
         * Uncomment test that you want to execute:
         *
         **********************************************************************/
         //positionSample.select(connection);
         //positionSample.insert(connection);
         //positionSample.update(connection);

         //positionSample.dataProvider1(connection);
         //positionSample.dataProvider2(connection);

         //positionSample.deleteViaResultSet(connection);
         //positionSample.deleteViaSQL(connection);
         
         //positionSample.batchInsert(connection);
         
         //positionSample.selectIntoTransferObject(connection);
         
         //positionSample.copyDataBetweenDatabases(connection_source, connection_target);
         //positionSample.updateByToArray(connection_source, connection_target);
         
         //positionSample.deleteByToArrayBatch(connection_source, connection_target);
         //positionSample.deleteByToArray(connection_source, connection_target);
         
         //positionSample.updateByTo(connection);
         //positionSample.deleteByTo(connection);
         
         
         if (connection != null && !connection.isClosed()) {
            connection.close();
         }
      } catch (SQLException e) {
         e.printStackTrace();
         log.error("Problem occurred during processing: " + e.getMessage());
      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Problem occurred during processing: " + e.getMessage());
      } finally {
         try {
            if (connection != null && !connection.isClosed()) {
               connection.close();
               log.debug("Database connection is now closed.");
            }
         } catch (SQLException e) {
            e.printStackTrace();
            log.error("Problem occurred while closing database connection.");
         }
      }
   }

   /**********************************************************************
    *
    * Demonstrates "Selecting" data from the table/view
    *
    * @param  connection      Database connection
    * @throws GDAOException
    *
    **********************************************************************/
   public void select(Connection connection) throws GDAOException {

      log.debug("Starting select from TABLE \"POSITION\".");

            java.lang.String positionId = null;
      java.lang.String accountId = null;
      java.lang.String brokerCode = null;
      java.lang.String securitySymbol = null;
      java.lang.String cusip = null;
      java.lang.String isin = null;
      java.lang.String sedol = null;
      java.lang.String currency = null;
      java.sql.Timestamp expirationDate = null;
      java.math.BigDecimal executionPrice = null;
      java.math.BigDecimal marketPrice = null;
      java.math.BigDecimal quantity = null;


      PositionTab positionTab = new PositionTab(connection);

      try {

         /**********************************************************************
          *
          * !IMPORTANT!:
          * Use the following parameters in order to speed up SELECT
          * and to prevent program from failing because of EXAUSTED MEMORY error:
          * java.lang.OutOfMemoryError: Java heap space
          *
          **********************************************************************/
         positionTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         positionTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

         /**********************************************************************
          *
          * Selects specific records from the table:
          * Limit number of rows selected to "100" (just an example)
          * Change "WHERE" condition to meet your needs.
          *
          **********************************************************************/
         positionTab.getResultSet("WHERE UPPER(POSITION_ID) LIKE ? AND ROWNUM < ?", "%R%", 100);

         /**********************************************************************
          *
          * Selects all records from the table - no "WHERE" condition.
          * Both methods below are equal:
          *
          **********************************************************************/
         //positionTab.getResultSet(null, (Object[])null);
         //positionTab.getAllRecordsRs();

         /**********************************************************************
          *
          * Loop through database result set:
          *
          **********************************************************************/
         while (positionTab.next()) {

            /**********************************************************************
            *
            * Print all values from the row in one line delimited by "; "
            *
            **********************************************************************/
            positionTab.print("; ");

            /**********************************************************************
            *
            * Fetch data from the database into local variables:
            *
            **********************************************************************/
                  positionId = positionTab.getPOSITION_ID();
      accountId = positionTab.getACCOUNT_ID();
      brokerCode = positionTab.getBROKER_CODE();
      securitySymbol = positionTab.getSECURITY_SYMBOL();
      cusip = positionTab.getCUSIP();
      isin = positionTab.getISIN();
      sedol = positionTab.getSEDOL();
      currency = positionTab.getCURRENCY();
      expirationDate = positionTab.getEXPIRATION_DATE();
      executionPrice = positionTab.getEXECUTION_PRICE();
      marketPrice = positionTab.getMARKET_PRICE();
      quantity = positionTab.getQUANTITY();


            /**********************************************************************
            *
            * Print all values from the row - one line per column:
            *
            **********************************************************************/
               log.debug(String.format("%-30s [%s]", "positionId", positionId));
      log.debug(String.format("%-30s [%s]", "accountId", accountId));
      log.debug(String.format("%-30s [%s]", "brokerCode", brokerCode));
      log.debug(String.format("%-30s [%s]", "securitySymbol", securitySymbol));
      log.debug(String.format("%-30s [%s]", "cusip", cusip));
      log.debug(String.format("%-30s [%s]", "isin", isin));
      log.debug(String.format("%-30s [%s]", "sedol", sedol));
      log.debug(String.format("%-30s [%s]", "currency", currency));
      log.debug(String.format("%-30s [%s]", "expirationDate", expirationDate));
      log.debug(String.format("%-30s [%s]", "executionPrice", executionPrice));
      log.debug(String.format("%-30s [%s]", "marketPrice", marketPrice));
      log.debug(String.format("%-30s [%s]", "quantity", quantity));
   

            log.debug("---------------^^^^^^^^^-----------------");
         }

      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot select from TABLE \"POSITION\".");
         throw new GDAOException(e);
      } finally {
         positionTab.releaseStatement();
      }

      log.debug("Finished select from TABLE \"POSITION\".");
   }



  /**********************************************************************
   *
   * Demonstrates Select data from the table/view into Transfer Objects.
   * TO's can be transferred and manipulated much easier. 
   * They are especially useful in web applications.
   *
   * @param  connection      Database connection
   * @throws GDAOException
   *
   **********************************************************************/
   public void selectIntoTransferObject(Connection connection) throws GDAOException {

      String whatWeAreDoing = "\"selectIntoTransferObject()\" for TABLE \"POSITION\"";

      log.debug("Starting " + whatWeAreDoing);

      /**********************************************************************
       *
       * Create DAO object for selecting data from the database
       *
       **********************************************************************/
      PositionTab positionTabForSelect = new PositionTab(connection);

      try {

         /**********************************************************************
          *
          * Use the following parameters in order to speed up SELECT
          * and to prevent program from failing because of exhausted memory
          *
          **********************************************************************/
         positionTabForSelect.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         positionTabForSelect.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

         /**********************************************************************
          *
          * Selects specific records from the table:
          * Limit number of rows selected to "100" (just an example)
          *
          **********************************************************************/
         positionTabForSelect.getResultSet("WHERE UPPER(CREDIT_DEBIT_CODE) LIKE ? AND ROWNUM < ?", "%C%", 100);

         /**********************************************************************
          *
          * Selects all records from the table - no "WHERE" condition.
          * Both methods below are equal:
          *
          **********************************************************************/
         //positionTab.getResultSet(null, (Object[])null);
         //positionTab.getAllRecordsRs();

         /**********************************************************************
          *
          * Loop through database result set:
          *
          **********************************************************************/
         while (positionTabForSelect.next()) {
         
            /**********************************************************************
            *
            * Print all values from the row in one line delimited by "; "
            *
            **********************************************************************/
            //positionTab.print("; ");

            /**********************************************************************
            *
            * Fetch data from the database into local variables:
            *
            **********************************************************************/
            PositionTo positionTo  = positionTabForSelect.getTo();

            /**********************************************************************
             *
             * Print Transfer object content
             *
             **********************************************************************/
            //positionTo.print();

            /**********************************************************************
             *
             * Make desired changes to data
             * Sample is provided below.
             *
             **********************************************************************/
             /*
            positionTo.setRECURRING_TRANS_HIST_ID(positionTabForSelect.getNextval());
            positionTo.setCOMMENTS("This is Zoran's test record");
            positionTo.setREJECT_REASON(null);
            positionTo.setCREATE_DATETIME(TimestampUtility.getCurrentTimestamp());
            */

            /**********************************************************************
             *
             * Create another DAO object for inserting data into database.
             *
             **********************************************************************/
            PositionTab positionTabForInsert = new PositionTab(connection);

            positionTabForInsert.setThisFromTo(positionTo);

            positionTabForInsert.insertThisRecord();

            log.debug("---------------^^^^^^^^^-----------------");
         }

      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot select into TO's from TABLE \"POSITION\".");
         throw new GDAOException(e);
      } finally {
         positionTabForSelect.releaseStatement();
      }

      log.debug("Finished " + whatWeAreDoing);
   }



   /**********************************************************************
    *
    * Demonstrates Insert data into the table
    *
    * @param  connection      Database connection
    * @throws GDAOException
    *
    **********************************************************************/
   public void insert(Connection connection) throws GDAOException {

      log.debug("Starting insert into TABLE \"POSITION\"...");

            java.lang.String positionId = null;
      java.lang.String accountId = null;
      java.lang.String brokerCode = null;
      java.lang.String securitySymbol = null;
      java.lang.String cusip = null;
      java.lang.String isin = null;
      java.lang.String sedol = null;
      java.lang.String currency = null;
      java.sql.Timestamp expirationDate = null;
      java.math.BigDecimal executionPrice = null;
      java.math.BigDecimal marketPrice = null;
      java.math.BigDecimal quantity = null;


      

      PositionTab positionTab = new PositionTab(connection);

      try {

        /**********************************************************************
         *
         * For PK values use sequence, something like:
         * BigDecimal PositionTab_id = PositionTab.getNextval(sequenceName);
         * or if sequence has a standard name like "S_POSITION":
         * BigDecimal PositionTab_id = PositionTab.getNextval();
         *
         **********************************************************************/
               positionId = "new positionId";
      accountId = "new accountId";
      brokerCode = "new brokerCode";
      securitySymbol = "new securitySymbol";
      cusip = "new cusip";
      isin = "new isin";
      sedol = "new sedol";
      currency = "new currency";
      expirationDate = TimestampUtility.getCurrentTimestamp();
      executionPrice = new BigDecimal(0);
      marketPrice = new BigDecimal(0);
      quantity = new BigDecimal(0);


               positionTab.setPOSITION_ID(positionId);  // java.lang.String - Mandatory
      positionTab.setACCOUNT_ID(accountId);  // java.lang.String - Mandatory
      positionTab.setBROKER_CODE(brokerCode);  // java.lang.String - Mandatory
      positionTab.setSECURITY_SYMBOL(securitySymbol);  // java.lang.String - Mandatory
      positionTab.setCUSIP(cusip);  // java.lang.String
      positionTab.setISIN(isin);  // java.lang.String
      positionTab.setSEDOL(sedol);  // java.lang.String
      positionTab.setCURRENCY(currency);  // java.lang.String - Mandatory
      positionTab.setEXPIRATION_DATE(expirationDate);  // java.sql.Timestamp
      positionTab.setEXECUTION_PRICE(executionPrice);  // java.math.BigDecimal - Mandatory
      positionTab.setMARKET_PRICE(marketPrice);  // java.math.BigDecimal - Mandatory
      positionTab.setQUANTITY(quantity);  // java.math.BigDecimal - Mandatory


         positionTab.insertThisRecord();

      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot insert into TABLE \"POSITION\".");
         throw new GDAOException(e);
      }
      

      log.debug("Finished insert into TABLE \"POSITION\".");
   }


   /**********************************************************************
    *
    * Demonstrates Update data in table (or simple view). 
    * Result set is created with Oracle option "FOR UPDATE" meaning that 
    * the records are locked until updated and/or committed.
    *
    * The Select For Update statement allows you to lock the records in the 
    * cursor result set. You are not required to make changes to the records 
    * in order to use this statement. The record locks are released when 
    * the next commit or rollback statement is issued.
    *
    * @param  connection      Database connection
    * @throws GDAOException
    *
    **********************************************************************/
   public void update(Connection connection) throws GDAOException {

      log.debug("Starting update of TABLE \"POSITION\".");

            java.lang.String positionId = null;
      java.lang.String accountId = null;
      java.lang.String brokerCode = null;
      java.lang.String securitySymbol = null;
      java.lang.String cusip = null;
      java.lang.String isin = null;
      java.lang.String sedol = null;
      java.lang.String currency = null;
      java.sql.Timestamp expirationDate = null;
      java.math.BigDecimal executionPrice = null;
      java.math.BigDecimal marketPrice = null;
      java.math.BigDecimal quantity = null;

      
      

      PositionTab positionTab = new PositionTab(connection);

      try {
         connection.setAutoCommit(false);  // manage transactions manually

         /*************************************************************************
          *
          * Note:
          * Use positionTab.setResultSetHoldability(ResultSet.HOLD_CURSORS_OVER_COMMIT);
          *
          * OR
          *
          * "COMMIT" should not be used while looping through the cursor because
          * it will cause Oracle Error:
          * ORA-01002: fetch out of sequence
          *
          **************************************************************************/
         //positionTab.setResultSetHoldability(ResultSet.HOLD_CURSORS_OVER_COMMIT);


         /**********************************************************************
          *
          * Updates specific records in the table:
          * NOTE:
          * "WHERE ROWNUM <" or "GROUP BY" cannot be used when updating result set
          *
          **********************************************************************/
         positionTab.getResultSetForUpdate("WHERE POSITION_ID LIKE ?", "%R%");

         /**********************************************************************
          *
          * Updates all records in the table:
          *
          **********************************************************************/
         //positionTab.getResultSetForUpdate(null, (Object[])null);

         /**********************************************************************
          *
          * Display number of records that will be affected:
          *
          **********************************************************************/
         log.info("ResultSet Row Count (number of records to be affected) = " + positionTab.getResultSetRowCount());

         /*************************************************************************
          *
          * Note:
          * "COMMIT" should not be used while looping through the cursor because
          * it will cause Oracle Error:
          * ORA-01002: fetch out of sequence
          *
          **************************************************************************/
         while (positionTab.next()) {
                  positionId = positionTab.getPOSITION_ID();
      accountId = positionTab.getACCOUNT_ID();
      brokerCode = positionTab.getBROKER_CODE();
      securitySymbol = positionTab.getSECURITY_SYMBOL();
      cusip = positionTab.getCUSIP();
      isin = positionTab.getISIN();
      sedol = positionTab.getSEDOL();
      currency = positionTab.getCURRENCY();
      expirationDate = positionTab.getEXPIRATION_DATE();
      executionPrice = positionTab.getEXECUTION_PRICE();
      marketPrice = positionTab.getMARKET_PRICE();
      quantity = positionTab.getQUANTITY();


            log.debug("Updating following values:");
            log.debug("--------------------------");
               log.debug(String.format("%-30s [%s]", "positionId", positionId));
      log.debug(String.format("%-30s [%s]", "accountId", accountId));
      log.debug(String.format("%-30s [%s]", "brokerCode", brokerCode));
      log.debug(String.format("%-30s [%s]", "securitySymbol", securitySymbol));
      log.debug(String.format("%-30s [%s]", "cusip", cusip));
      log.debug(String.format("%-30s [%s]", "isin", isin));
      log.debug(String.format("%-30s [%s]", "sedol", sedol));
      log.debug(String.format("%-30s [%s]", "currency", currency));
      log.debug(String.format("%-30s [%s]", "expirationDate", expirationDate));
      log.debug(String.format("%-30s [%s]", "executionPrice", executionPrice));
      log.debug(String.format("%-30s [%s]", "marketPrice", marketPrice));
      log.debug(String.format("%-30s [%s]", "quantity", quantity));
   
            log.debug(" ");

                  positionId = "new positionId";
      accountId = "new accountId";
      brokerCode = "new brokerCode";
      securitySymbol = "new securitySymbol";
      cusip = "new cusip";
      isin = "new isin";
      sedol = "new sedol";
      currency = "new currency";
      expirationDate = TimestampUtility.getCurrentTimestamp();
      executionPrice = new BigDecimal(0);
      marketPrice = new BigDecimal(0);
      quantity = new BigDecimal(0);


            log.debug("Updating to following values:");
            log.debug("-----------------------------");
               log.debug(String.format("%-30s [%s]", "positionId", positionId));
      log.debug(String.format("%-30s [%s]", "accountId", accountId));
      log.debug(String.format("%-30s [%s]", "brokerCode", brokerCode));
      log.debug(String.format("%-30s [%s]", "securitySymbol", securitySymbol));
      log.debug(String.format("%-30s [%s]", "cusip", cusip));
      log.debug(String.format("%-30s [%s]", "isin", isin));
      log.debug(String.format("%-30s [%s]", "sedol", sedol));
      log.debug(String.format("%-30s [%s]", "currency", currency));
      log.debug(String.format("%-30s [%s]", "expirationDate", expirationDate));
      log.debug(String.format("%-30s [%s]", "executionPrice", executionPrice));
      log.debug(String.format("%-30s [%s]", "marketPrice", marketPrice));
      log.debug(String.format("%-30s [%s]", "quantity", quantity));
   
            log.debug("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

           /**********************************************************************
           *
           * Set new values for the record which is going to be updated. 
           *
           ***********************************************************************/
                  positionTab.setPOSITION_ID(positionId);  // java.lang.String - Mandatory
      positionTab.setACCOUNT_ID(accountId);  // java.lang.String - Mandatory
      positionTab.setBROKER_CODE(brokerCode);  // java.lang.String - Mandatory
      positionTab.setSECURITY_SYMBOL(securitySymbol);  // java.lang.String - Mandatory
      positionTab.setCUSIP(cusip);  // java.lang.String
      positionTab.setISIN(isin);  // java.lang.String
      positionTab.setSEDOL(sedol);  // java.lang.String
      positionTab.setCURRENCY(currency);  // java.lang.String - Mandatory
      positionTab.setEXPIRATION_DATE(expirationDate);  // java.sql.Timestamp
      positionTab.setEXECUTION_PRICE(executionPrice);  // java.math.BigDecimal - Mandatory
      positionTab.setMARKET_PRICE(marketPrice);  // java.math.BigDecimal - Mandatory
      positionTab.setQUANTITY(quantity);  // java.math.BigDecimal - Mandatory


           /**********************************************************************
           *
           * Update database record with new values set in the "set" statements 
           * above. 
           *
           ***********************************************************************/
            positionTab.updateThisRecordInResultSet();

           /**********************************************************************
           *
           * For large transactions (large number of records to be updated):
           * Consider performing 'commit' after certain number of updates to
           * improve performances and avoid space issues with Oracle 'redo' log.
           *
           **********************************************************************/
         }

         connection.commit(); // commit all updates in one transaction

      }  catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot update TABLE \"POSITION\".");

         try {
            connection.rollback();  // rollback all updates
         } catch (SQLException e1) {
            log.error("Cannot rollback transaction for updating records from TABLE \"POSITION\".");
            e1.printStackTrace();
            throw new GDAOException(e1);
         }
         throw new GDAOException(e);
      }  catch (SQLException e) {
         e.printStackTrace();
         throw new GDAOException(e);
      }
      
      finally {
         positionTab.releaseStatement();
      }

      log.debug("Finished update of TABLE \"POSITION\".");
   }


    /**********************************************************************
    *
    * Demonstrates record deletion using straight SQL.
    * All records are deleted in one SQL statement.
    *
    * NOTE:
    * Deletion is almost always more efficient when done in one or few SQL
    * statements. If you need to perform massive delete 
    * you may consider method demonstrated in:
    * 1. "deleteViaSQLS()"
    * 2. "deleteViaResultSet()"   
    *
    * @param  connection      Database connection
    * @throws GDAOException
    *
    **********************************************************************/
   public void deleteViaSQL(Connection connection) throws GDAOException {

      long recordsDeleted = -1;

      log.debug("Starting delete of TABLE \"POSITION\".");

      PositionTab positionTab = new PositionTab(connection);

      try {
         connection.setAutoCommit(false);  // manage transactions manually

         /**********************************************************************
          *
          * Delete records that match WHERE clause in the table:
          * NOTE:
          * "WHERE ROWNUM <" or "GROUP BY" cannot be used when updating result set
          *
          **********************************************************************/
         String SQL = "WHERE POSITION_ID LIKE ?";          
         recordsDeleted = positionTab.deleteRecords(SQL, "%R%");

         /**********************************************************************
          *
          * Display number of records that will be affected:
          *
          **********************************************************************/
         log.info(recordsDeleted + " records are deleted from TABLE \"POSITION\"");

         /**********************************************************************
          *
          * Commit transaction.
          *
          **********************************************************************/
          connection.commit();
          log.debug("Records deleted=" + recordsDeleted + " - transaction is committed.");

      }  catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot delete  records from TABLE \"POSITION\".");

         try {
            connection.rollback();  // rollback all deletes
         } catch (SQLException e1) {
            log.error("Cannot rollback transaction for deleting records from TABLE \"POSITION\".");
            e1.printStackTrace();
            throw new GDAOException(e1);
         }
         throw new GDAOException(e);
      }  catch (SQLException e) {
         e.printStackTrace();
         throw new GDAOException(e);
      }

      log.debug("Finished delete of TABLE \"POSITION\".");
   }


   /**********************************************************************
   *
   * Demonstrates record update using Transfer Object.
   * Record is updated using PK values from TO object.
   *
   * @param  connection      Database connection
   * @throws GDAOException
   *
   **********************************************************************/
   public void updateByTo(Connection connection) throws GDAOException {

      log.debug("Starting UPDATE by TO of TABLE \"POSITION\".");

      PositionTab positionTab = new PositionTab(connection);

      try {
         connection.setAutoCommit(false); // manage transactions manually

         /**********************************************************************
         *
         * Selects all records from the table - various methods are provided.
         * Uncomment and change one that works for you. 
         *
         **********************************************************************/
         //positionTab.getResultSet("WHERE UPPER(USERNAME) LIKE ? ", "%Z%");
         //positionTab.getResultSet(null, (Object[])null);
         //positionTab.getAllRecordsRs();

         /**********************************************************************
          *
          * Loop through database result set:
          *
          **********************************************************************/
         while (positionTab.next()) {

            /**********************************************************************
            *
            * Print all values from the row in one line delimited by "; "
            *
            **********************************************************************/
            //positionTab.print("; ");

            /**********************************************************************
            *
            * Fetch data from the database into Transfer Object:
            *
            **********************************************************************/
            PositionTo positionTo = positionTab.getTo();
            
            
           /**********************************************************************
            *
            * Change data in transfer object and the use that transfer object to 
            * update record in the database.
            *
            * IMPORTANT: 
            * If you change Primary Key values then record with those new PK values 
            * will be updated. Make sure that record exists, it it doesn't handle 
            * error condition accordingly.  
            *
            **********************************************************************/
            //positionTo.setCITY("Belgrado"); 
            
            int recordsAffected = positionTab.updateRecordUsingTo(positionTo);

            
            /**********************************************************************
            *
            * Special code has to be developed to display PK values since there 
            * could be multiple fields and names may be different than table name:
            *
            **********************************************************************/
             log.info("Updated " + recordsAffected + " record with PK: "   + "POSITION_ID=" + positionTo.getPOSITION_ID() 
);

            //Alternative method:
            //recordsDeleted = positionTab.updateRecordsUsingPKs(SQL, positionTo.getPOSITION_ID());

         }

         connection.commit();

      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot update records from TABLE \"POSITION\".");

         try {
            connection.rollback(); // rollback all updates
         } catch (SQLException e1) {
            log.error("Cannot rollback transaction for deleting records from TABLE \"POSITION\".");
            e1.printStackTrace();
            throw new GDAOException(e1);
         }
         throw new GDAOException(e);
      } catch (SQLException e) {
         e.printStackTrace();
         throw new GDAOException(e);
      }

      log.debug("Finished update of TABLE \"POSITION\".");
   }





   /**********************************************************************
   *
   * Demonstrates record deletion using Transfer Object.
   * Records are deleted one at the time using PK values from TO object.
   * This approach can be used in Java batch deletes.
   *
   * NOTE:
   * Deletion is almost always more efficient when done in one or few SQL
   * statements. If you need to perform massive delete
   * you may consider method demonstrated in:
   * 1. "deleteViaSQLS()"
   * 2. "deleteViaResultSet()"
   *
   * @param  connection      Database connection
   * @throws GDAOException
   *
   **********************************************************************/
   public void deleteByTo(Connection connection) throws GDAOException {

      log.debug("Starting delete of TABLE \"POSITION\".");

      PositionTab positionTab = new PositionTab(connection);

      try {
         connection.setAutoCommit(false); // manage transactions manually

         /**********************************************************************
         *
         * Selects all records from the table - no "WHERE" condition.
         * Both methods below are equal:
         *
         **********************************************************************/
         //positionTab.getResultSet(null, (Object[])null);
         positionTab.getAllRecordsRs();

         /**********************************************************************
          *
          * Loop through database result set:
          *
          **********************************************************************/
         while (positionTab.next()) {

            /**********************************************************************
            *
            * Print all values from the row in one line delimited by "; "
            *
            **********************************************************************/
            //positionTab.print("; ");

            /**********************************************************************
            *
            * Fetch data from the database into Transfer Object:
            *
            **********************************************************************/
            PositionTo positionTo = positionTab.getTo();

            int recordsAffected = positionTab.deleteRecordUsingTo(positionTo);
         
            log.info("Deleted " + recordsAffected + " record with PK values: "   + "POSITION_ID=" + positionTo.getPOSITION_ID() 
);

            //Alternative method:
            //recordsDeleted = positionTab.deleteRecordsUsingPKs(SQL, positionTo.getPOSITION_ID());

         }

         connection.commit();

      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot delete records from TABLE \"POSITION\".");

         try {
            connection.rollback(); // rollback all updates
         } catch (SQLException e1) {
            log.error("Cannot rollback transaction for deleting records from TABLE \"POSITION\".");
            e1.printStackTrace();
            throw new GDAOException(e1);
         }
         throw new GDAOException(e);
      } catch (SQLException e) {
         e.printStackTrace();
         throw new GDAOException(e);
      }

      log.debug("Finished delete of TABLE \"POSITION\".");
   }



    /**********************************************************************
    *
    * Demonstrates record deletion using straight SQLs.
    * Records are deleted in batches of 1,000 records. 
    *
    * NOTE:
    * Deletion is almost always more efficient when done in one or few SQL
    * statements however sometimes it is not practical because of the
    * large size of the transaction or if some specific logic has to be
    * applied. This example deletes large number of records and commits
    * in batches of 1,000 records (variable "deleteThisManyRecords" in the 
    * code below).
    *
    * @param  connection      Database connection
    * @throws GDAOException
    *
    **********************************************************************/
   public void deleteViaSQLS(Connection connection) throws GDAOException {
   
      String whatWeAreDoing = "\"deleteViaSQLS()\" for TABLE \"POSITION\"";

      long recordsDeleted = -1;
      long deleteThisManyRecords = 1000;  //sample number, find optimum number for your database (usually by experimenting)

      log.debug("Starting " + whatWeAreDoing);

      PositionTab positionTab = new PositionTab(connection);

      try {
         connection.setAutoCommit(false);  // manage transactions manually

         /**********************************************************************
          *
          * Updates specific records in the table:
          * NOTE:
          * "WHERE ROWNUM <" or "GROUP BY" cannot be used when updating result set
          *
          **********************************************************************/
         String SQL = "WHERE POSITION_ID LIKE ?";  
         SQL = SQL + " AND ROWNUM <= ?";    // limit number of rows to be deleted    

          /**********************************************************************
          *
          * Delete "deleteThisManyRecords" at the time. This will avoid deleting
          * large number of records at once and creating huge transactions
          * that can last forever and ultimately fail due to the lack of space 
          * in UNDO database segment.
          * 
          **********************************************************************/
         while (recordsDeleted !=0) {
            recordsDeleted = positionTab.deleteRecords(SQL, "%R%", deleteThisManyRecords);

            /**********************************************************************
             *
             * Display number of records that will be affected:
             *
             **********************************************************************/
            log.info(recordsDeleted + " records are deleted from TABLE \"POSITION\"");

            /**********************************************************************
             *
             * Commit transaction.
             *
             **********************************************************************/
             connection.commit();
             log.debug("Records deleted = " + recordsDeleted + " - transaction is committed.");
          }

      }  catch (GDAOException e) {
         e.printStackTrace();
         log.error("Error occurred in " + whatWeAreDoing);

         try {
            connection.rollback();  // rollback last deletion
         } catch (SQLException e1) {
            e1.printStackTrace();
            log.error("Cannot rollback transaction for " + whatWeAreDoing);
            throw new GDAOException(e1);
         }
         throw new GDAOException(e);
      }  catch (SQLException e) {
         e.printStackTrace();
         throw new GDAOException(e);
      } 

      log.debug("Finished " + whatWeAreDoing);
   }




   /**********************************************************************
    *
    * Demonstrates record deletion using result set and transaction
    * management within the cursor.
    *
    * NOTE:
    * Deletion is almost always more efficient when done in one or few SQL
    * statements however sometimes it is not practical because of the
    * large size of the transaction or if some specific logic has to be
    * applied. This example deletes large number of records and commits
    * after every 1000 deleted records.
    *
    * @param  connection      Database connection
    * @throws GDAOException
    *
    **********************************************************************/
   public void deleteViaResultSet(Connection connection) throws GDAOException {

      String whatWeAreDoing = "\"deleteViaResultSet()\" for TABLE \"POSITION\"";

      long recordsProcessed = 0;

      log.debug("Starting " + whatWeAreDoing);

      PositionTab positionTab = new PositionTab(connection);

      try {
         connection.setAutoCommit(false);  // manage transactions manually

         /*************************************************************************
          *
          * Note:
          * Use positionTab.setResultSetHoldability(ResultSet.HOLD_CURSORS_OVER_COMMIT);
          *
          * OR
          *
          * "COMMIT" should not be used while looping through the cursor because
          * it will cause Oracle Error:
          * ORA-01002: fetch out of sequence
          *
          **************************************************************************/
         positionTab.setResultSetHoldability(ResultSet.HOLD_CURSORS_OVER_COMMIT);

         /**********************************************************************
          *
          * Updates specific records in the table:
          * NOTE:
          * "WHERE ROWNUM <" or "GROUP BY" cannot be used when updating result set
          *
          **********************************************************************/
         positionTab.getResultSet("WHERE POSITION_ID LIKE ?", "%R%");

         /**********************************************************************
          *
          * Display number of records that will be affected:
          *
          **********************************************************************/
         log.info("ResultSet Row Count (number of records to be affected) = " + positionTab.getResultSetRowCount());

         while (positionTab.next()) {

            positionTab.deleteThisRecordFromResultSet();
            recordsProcessed++;

            /**********************************************************************
            *
            * For large transactions (large number of records to be updated):
            * Consider performing 'commit' after certain number of updates to
            * improve performances and avoid space issues with Oracle 'redo' log.
            *
            **********************************************************************/

            if ((recordsProcessed % 1000) == 0) {
               connection.commit();
               log.debug("Records processed=" + recordsProcessed + " - transaction is committed.");
            }
         }

         /**********************************************************************
          *
          * Commit last batch of deleted records.
          *
          **********************************************************************/
          connection.commit();
          log.debug("Records processed=" + recordsProcessed + " - transaction is committed.");

      }  catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot update TABLE \"POSITION\".");

         try {
            connection.rollback();  // rollback all deletes
         } catch (SQLException e1) {
            log.error("Cannot rollback transaction for deleting records from TABLE \"POSITION\".");
            e1.printStackTrace();
            throw new GDAOException(e1);
         }
         throw new GDAOException(e);
      }  catch (SQLException e) {
         e.printStackTrace();
         throw new GDAOException(e);
      }
      finally {
         positionTab.releaseStatement();
      }

      log.debug("Finished " + whatWeAreDoing);
   }


   
   /**********************************************************************
   *
   * Demonstrates Batch Insert data into the table
   *
   * @param  connection      Database connection
   * @throws GDAOException
   *
   **********************************************************************/
   public void batchInsert(Connection connection) throws GDAOException {


      String whatWeAreDoing = "\"batchInsert()\" for TABLE \"POSITION\"";

      String SQL = null;
      OracleSystemTab oracleSystemTab = new OracleSystemTab(connection);
      int[] insertCounts = null;
      PreparedStatement ps = null;
      PositionTab positionTab = null;

      log.info("Starting " + whatWeAreDoing);
      
      try {

         /**********************************************************************
         *
         * Executing statements which will NOT ignore Oracle errors:
         *
         * NOTE:
         * Disabling constraints and dropping indexes usually improves data load 
         * performances. If you choose to do that, do not forget to enable 
         * constraints and recreate indexes after load is done.
         *
         **********************************************************************/
         //SQL = "ALTER TABLE POSITION DISABLE CONSTRAINT ....";
         //oracleSystemTab.runSQL(SQL);

         //SQL = "DROP INDEX ...";
         //oracleSystemTab.runSQL(SQL);

         SQL = "TRUNCATE TABLE POSITION";
         oracleSystemTab.runSQL(SQL);

         log.info("TABLE \"POSITION\" is truncated.");

         positionTab = new PositionTab(connection);

         log.info("Use Oracle Cursors for selecting and Batch Inserts for inserting large number of records...");

         connection.setAutoCommit(false);

         /**********************************************************************
         *
         * Change underlying table for this DAO object to 
         * POSITION_BKP 
         * This will affect only selects from this DAO object.
         *
         **********************************************************************/
         positionTab.setDbEntityName("POSITION_BKP");
         positionTab.getAllRecordsRs();

         positionTab.setDbEntityName("POSITION");
         ps = positionTab.getInsertPreparedStatement();

         long recordsInserted = 0;
         while (positionTab.next()) {
            /**********************************************************************
             *
             * Retrieve values from table POSITION_BKP
             * using DAO object "positionTo"
             *
             **********************************************************************/
            PositionTo positionTo = positionTab.getTo();
            positionTab.addInsertBatch(ps, positionTo);

            recordsInserted++;

            if (recordsInserted % TRANSACTION_TRESHOLD == 0) {
               /**********************************************************************
                *
                * Execute Batch Insert
                *
                **********************************************************************/
               insertCounts = ps.executeBatch();
               connection.commit();
               log.info("Inserted and committed " + recordsInserted + " records into TABLE \"POSITION\".");
            }
         }

         insertCounts = ps.executeBatch();
         connection.commit();
         
         log.info("Inserted and committed " + recordsInserted + " records into TABLE \"POSITION\".");

         connection.setAutoCommit(true);

      } catch (BatchUpdateException b) {
         /**********************************************************************
          *
          * Handles exception in statement:
          * ps.executeBatch();
          *
          **********************************************************************/
         log.error("----BatchUpdateException----");
         log.error("SQLState:  " + b.getSQLState());
         log.error("Message:  " + b.getMessage());
         log.error("Vendor:  " + b.getErrorCode());
         log.error("Update counts:  ");

         int[] updateCounts = b.getUpdateCounts();
         for (int i = 0; i < updateCounts.length; i++) {
            log.error(updateCounts[i] + "   ");
         }

         log.error("----------------------------");

         throw new GDAOException(b);
      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot perform DDL/DML on TABLE \"POSITION\".");
         throw new GDAOException(e);
      } catch (SQLException e) {
         e.printStackTrace();
         throw new GDAOException(e);
      } finally {
         try {
            positionTab.releaseStatement();
            ps.close();
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }

      log.info("Finished " + whatWeAreDoing);

   }
   
   
   
   /**********************************************************************
   *
   * Demonstrates Batch Delete from database table
   *
   * @param  connection      Database connection
   * @throws GDAOException
   *
   **********************************************************************/
   public void batchDelete(Connection connection) throws GDAOException {

      String whatWeAreDoing = "\"batchDelete()\" for TABLE \"POSITION\"";

      String SQL = null;
      OracleSystemTab oracleSystemTab = new OracleSystemTab(connection);
      int[] insertCounts = null;
      PreparedStatement ps = null;
      PositionTab positionTab = null;

      log.info("Starting " + whatWeAreDoing);
      
      try {

         /**********************************************************************
         *
         * Executing statements which will NOT ignore Oracle errors:
         *
         * NOTE:
         * Disabling constraints and dropping indexes usually improves record 
         * deletion performances. If you choose to do that, do not forget to 
         * enable constraints and recreate indexes after load is done.
         *
         **********************************************************************/
         //SQL = "ALTER TABLE POSITION DISABLE CONSTRAINT ....";
         //oracleSystemTab.runSQL(SQL);

         //SQL = "DROP INDEX ...";
         //oracleSystemTab.runSQL(SQL);

         //log.info("TABLE \"POSITION\" indexes are dropped.");

         positionTab = new PositionTab(connection);

         log.info("Use Oracle Cursors for selecting and Batch Inserts for inserting large number of records...");

         connection.setAutoCommit(false);

         /**********************************************************************
         *
         * Change underlying table for this DAO object to 
         * POSITION_BKP 
         * This will affect only selects from this DAO object.
         *
         **********************************************************************/
         positionTab.setDbEntityName("POSITION_BKP");
         positionTab.getAllRecordsRs();

         positionTab.setDbEntityName("POSITION");
         ps = positionTab.getDeleteByPkPreparedStatement();

         int[] deleteCounts = null;
         long recordsDeleted = 0;
         while (positionTab.next()) {
            /**********************************************************************
             *
             * Retrieve values from table POSITION_BKP
             * using DAO object "positionTo"
             *
             **********************************************************************/
            PositionTo positionTo = positionTab.getTo();
            positionTab.addInsertBatch(ps, positionTo);

            recordsDeleted++;

            if (recordsDeleted % TRANSACTION_TRESHOLD == 0) {
               /**********************************************************************
                *
                * Execute Batch Insert
                *
                **********************************************************************/
               deleteCounts = ps.executeBatch();
               connection.commit();
               log.info("Deleted and committed " + recordsDeleted + " records from TABLE \"POSITION\".");
            }
         }

         deleteCounts = ps.executeBatch();
         connection.commit();
         
         log.info("Deleted and committed " + recordsDeleted + " records from TABLE \"POSITION\".");

         connection.setAutoCommit(true);

      } catch (BatchUpdateException b) {
         /**********************************************************************
          *
          * Handles exception in statement:
          * ps.executeBatch();
          *
          **********************************************************************/
         log.error("----BatchUpdateException----");
         log.error("SQLState:  " + b.getSQLState());
         log.error("Message:  " + b.getMessage());
         log.error("Vendor:  " + b.getErrorCode());
         log.error("Update counts:  ");

         int[] updateCounts = b.getUpdateCounts();
         for (int i = 0; i < updateCounts.length; i++) {
            log.error(updateCounts[i] + "   ");
         }

         log.error("----------------------------");

         throw new GDAOException(b);
      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot perform DDL/DML on TABLE \"POSITION\".");
         throw new GDAOException(e);
      } catch (SQLException e) {
         e.printStackTrace();
         throw new GDAOException(e);
      } finally {
         try {
            positionTab.releaseStatement();
            ps.close();
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }

      log.info("Finished " + whatWeAreDoing);

   }
   
   
   
   

   /**********************************************************************
   *
   * This method demonstrates fetching rows from the
   * the database into Java objects (in GDAO framework, they are called
   * "Transfer Objects" because they are used to "transfer" data between
   * various application components).
   *
   * Example of the GDAO Transfer object below is object:
   * positionTo
   *
   * @param  connection      Database connection
   * @throws GDAOException
   *
   **********************************************************************/
   public void dataProvider1(Connection connection) throws GDAOException {
   
      String whatWeAreDoing = "\"dataProvider1()\" for TABLE \"POSITION\"";

      log.debug("Starting " + whatWeAreDoing);

      PositionTab positionTab = new PositionTab(connection);

      try {

         positionTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         positionTab.setResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE);

         /**********************************************************************
          *
          * Selects specific records from the table:
          *
          **********************************************************************/
         //positionTab.getResultSet("WHERE UPPER(POSITION_ID) LIKE ?", "%R%");

         /**********************************************************************
          *
          * Retrieves all records from the table -
          * Both methods below are equal:
          *
          **********************************************************************/
         //positionTab.getResultSet(null, (Object[])null);
         positionTab.getAllRecordsRs();

         /**********************************************************************
         *
         * Loop through database result set:
         *
         **********************************************************************/
         while (positionTab.next()) {

            PositionTo positionTo = positionTab.getTo();

             /**********************************************************************
             *
             * Now use "positionTo" object.
             * Below are few examples of what you can do with it:
             *
             * You can us it in Front End or just show it for debugging purposes:
             * NOTE: each values in this Transfer Object has it's own "getter"
             * and "setter" already defined.
             *
             **********************************************************************/
            //positionTo.print();
            //Or alternatively, using Working class static method:
            PositionTab.print(positionTo, "; ");


            /**********************************************************************
            *
            * Change some values:
            * For example:
            * positionTo.setSOME_VALUE(123);
            * positionTo.setSOME_OTHER_VALUE("Some name");
            * etc...
            *
            **********************************************************************/


            /**********************************************************************
            *
            * Update row in TABLE \"POSITION\" with values from this
            * Transfer Object positionTo.
            *
            * NOTE:
            * Variables that keep values of the Primary Key in Transfer Object
            * positionTo will be used to find
            * record to be updated. Generally those values should not be changed.
            *
            **********************************************************************/
            //positionTab.update(positionTo);

            /**********************************************************************
            *
            * Insert row in TABLE \"POSITION\" using values set in
            * this Transfer Object positionTo.
            *
            * NOTE:
            * Remember that values for Primary Key have to be unique.
            * Transfer Object positionTo could be also
            * created from scratch (not retrieved from the database).
            *
            **********************************************************************/
            //positionTab.insert(positionTo);

            /**********************************************************************
            *
            * Delete row in TABLE \"POSITION\" with values from this
            * Transfer Object positionTo.
            *
            * NOTE:
            * Variables that keep values of the Primary Key in Transfer Object
            * positionTo will be used to find
            * record to be deleted. Generally those values should not be changed.
            *
            **********************************************************************/
            //positionTab.delete(positionTo);
         }
      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot fetch data from TABLE \"POSITION\".");
         throw new GDAOException(e);
      } finally {
         positionTab.releaseStatement();
      }

      log.debug("Ending " + whatWeAreDoing);
   }


   /**********************************************************************
   *
   * This method demonstrates fetching specified number of rows from the
   * the database into Java objects Array
   *
   * @param  connection      Database connection
   * @throws GDAOException
   *
   **********************************************************************/
   public void dataProvider2(Connection connection) throws GDAOException {
   
      String whatWeAreDoing = "\"dataProvider2()\" for TABLE \"POSITION\"";

      log.debug("Starting " + whatWeAreDoing);

      PositionTab positionTab = new PositionTab(connection);
      //int sampleTransferObjectArraySize = 100;  // sample number, change according to your needs

      try {

         positionTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         positionTab.setResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE);

         /**********************************************************************
          *
          * Selects specific records from the table:
          *
          **********************************************************************/
         //positionTab.getResultSet("WHERE UPPER(POSITION_ID) LIKE ?", "%R%");

         /**********************************************************************
          *
          * Retrieves all records from the table -
          * Both methods below are equal:
          *
          **********************************************************************/
         //positionTab.getResultSet(null, (Object[])null);
         positionTab.getAllRecordsRs();

         /**********************************************************************
          *
          * This will fetch "sampleTransferObjectArraySize" number of rows into
          * array "positionToArray".
          * If there is less than "sampleTransferObjectArraySize"  rows returned
          * then all available data will be stored into array
          * "positionToArray".
          *
          * Alternatively you can use parameter "BaseOracleDbEntityClass.FETCH_ALL"
          * to fetch all records returned by result set.
          *
          **********************************************************************/
         //ArrayList<PositionTo> positionToArray = positionTab.getToArray(sampleTransferObjectArraySize);
         ArrayList<PositionTo> positionToArray = positionTab.getToArray(BaseOracleDbEntityClass.FETCH_ALL);

         Iterator<PositionTo> iterator = positionToArray.iterator();
         while (iterator.hasNext()) {
            PositionTo positionTo = iterator.next();

             /**********************************************************************
             *
             * Now use "positionTo" object.
             * Below are few examples of what you can do with it:
             *
             * You can us it in Front End or just show it for debugging purposes:
             * NOTE: each values in this Transfer Object has it's own "getter"
             * and "setter" already defined.
             *
             **********************************************************************/
            //positionTo.print();
            //Or alternatively, using Working class static method:
            PositionTab.print(positionTo, "; ");


            /**********************************************************************
            *
            * Change some values - for example:
            * positionTo.setSOME_VALUE(123);
            * positionTo.setSOME_OTHER_VALUE("Some name");
            * etc...
            *
            **********************************************************************/
            //put your code here (if any)

            /**********************************************************************
            *
            * Update the database with values from this Transfer Object.
            *
            * NOTE:
            * Variables that keep values of the Primary Key will be used to find
            * record to be updated. Generally those values should not be changed.
            *
            **********************************************************************/
            //positionTab.update(positionTo);
         }

      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot fetch data from TABLE \"POSITION\".");
         throw new GDAOException(e);
      }  finally {
         positionTab.releaseStatement();
      }

      log.debug("Ending " + whatWeAreDoing);
   }

  
   
   /**********************************************************************
   *
   * Demonstrates Copying data between tables in different:
   * <li> databases
   * <li> schemas
   *
   * This is recommended way of copying data between databases and schemas.
   * Note that tables could have different structure and name and in that
   * case some transformation logic should be coded in the data transformation
   * block below.
   *
   * @param sourceConnection  Database Connection for source data 
   * @param targetConnection  Database Connection for target data
   * @throws GDAOException
   *
   **********************************************************************/
   public void copyDataBetweenDatabases(Connection sourceConnection, Connection targetConnection) throws GDAOException {

      String whatWeAreDoing = "\"copyDataBetweenDatabases()\" for TABLE \"POSITION\"";

      String SQL = null;

      OracleSystemTab oracleSystemTabSource = new OracleSystemTab(sourceConnection);
      OracleSystemTab oracleSystemTabTarget = new OracleSystemTab(targetConnection);

      int[] insertCounts = null;
      PreparedStatement preparedStatement = null;

      PositionTab positionTabSource = null;
      PositionTab positionTabTarget = null;

      log.info("Starting " + whatWeAreDoing);

      try {

         /**********************************************************************
         *
         * Executing statements which will NOT ignore Oracle errors:
         *
         * NOTE:
         * Disabling constraints and dropping indexes usually improves data load
         * performances. If you choose to do that, do not forget to enable
         * constraints and recreate indexes after load is done.
         *
         **********************************************************************/
         //SQL = "ALTER TABLE POSITION DISABLE CONSTRAINT ....";
         //oracleSystemTab.runSQL(SQL);

         //SQL = "DROP INDEX ...";
         //oracleSystemTab.runSQL(SQL);

         SQL = "TRUNCATE TABLE POSITION";
         oracleSystemTabTarget.runSQL(SQL);

         log.info("Target TABLE \"POSITION\" is truncated.");

         positionTabSource = new PositionTab(sourceConnection);
         positionTabTarget = new PositionTab(targetConnection);

         /**********************************************************************
         *
         * Use the following parameters in order to speed up SELECT
         * and to prevent program from failing because of EXAUSTED MEMORY error:
         * java.lang.OutOfMemoryError: Java heap space
         *
         **********************************************************************/
         positionTabSource.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         positionTabSource.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

         /**********************************************************************
          *
          * Target ResultSet should be:
          * - ResultSet.TYPE_SCROLL_SENSITIVE,
          * - ResultSet.CONCUR_UPDATABLE
          *
          **********************************************************************/
         positionTabTarget.setResultSetConcurrency(ResultSet.CONCUR_UPDATABLE);
         positionTabTarget.setResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE);
 
         log.info("Use Oracle Cursors for selecting and Batch Inserts for inserting large number of records...");

         targetConnection.setAutoCommit(false);

         /**********************************************************************
          *
          * Get Source Data
          *
          **********************************************************************/
         positionTabSource.getAllRecordsRs();

         /**********************************************************************
          *
          * Prepare Batch Insert Statement
          *
          **********************************************************************/
         preparedStatement = positionTabTarget.getInsertPreparedStatement();

         long recordsInserted = 0;
         while (positionTabSource.next()) {
            /**********************************************************************
             *
             * Retrieve values from table POSITION
             * using DAO object "positionTabSource"
             *
             * This is also the place to put Data Transformation code if data is
             * being copied to tables with different structures or names.
             *
             **********************************************************************/
            PositionTo positionTo = positionTabSource.getTo();

            positionTabTarget.addInsertBatch(preparedStatement, positionTo);

            recordsInserted++;

            if (recordsInserted % TRANSACTION_TRESHOLD == 0) {
               /**********************************************************************
                *
                * Execute Batch Insert
                *
                **********************************************************************/
               insertCounts = preparedStatement.executeBatch();
               targetConnection.commit();
               log.info("Inserted and committed " + recordsInserted + " records into TABLE \"POSITION\".");
               log.debug("insertCounts.length=" + insertCounts.length);
            }
         }

         insertCounts = preparedStatement.executeBatch();
         targetConnection.commit();

         log.info("Inserted and committed " + recordsInserted + " records into TABLE \"POSITION\".");
         log.debug("insertCounts.length=" + insertCounts.length);

         targetConnection.setAutoCommit(true);

      } catch (GDAOException e) {
         log.error("Cannot perform DDL/DML on TABLE \"POSITION\".");
         throw new GDAOException(e);
      } catch (BatchUpdateException b) {
         /**********************************************************************
          *
          * Handles exception in statement:
          * ps.executeBatch();
          *
          **********************************************************************/
         log.error("----BatchUpdateException----");
         log.error("SQLState:  " + b.getSQLState());
         log.error("Message:  " + b.getMessage());
         log.error("Vendor:  " + b.getErrorCode());
         log.error("Update counts:  ");

         int[] updateCounts = b.getUpdateCounts();
         for (int i = 0; i < updateCounts.length; i++) {
            log.error(updateCounts[i] + "   ");
         }

         log.error("----------------------------");

         throw new GDAOException(b);
      } catch (SQLException e) {
         throw new GDAOException(e);
      } finally {
         try {
            positionTabSource.releaseStatement();
            preparedStatement.close();
         } catch (SQLException e) {
            throw new GDAOException(e);
         }
      }

      log.info("Finished " + whatWeAreDoing);
   }
   
   
   
  /**********************************************************************
   *
   * Demonstrates Batch Delete using Array of Transfer Objects.
   *
   * An array of Transfer Objects will be selected from one schema and
   * then it will be used to delete records in another schema.
   *
   * NOTE:
   * Actual records deleted may not be possible to determine because
   * "preparedStatement.executeBatch()" mat return array of results
   * such as: PreparedStatement.SUCCESS_NO_INFO which means that SQL
   * Statement was successfully executed but is is unknown if record is
   * deleted or not (for example - not found).
   * This is the limitation of JDBC implementation.
   *
   * If you need reliable information about number of successful deletes
   * this method of deletion may not be a good choice.
   *
   * @param sourceConnection  Database Connection for source data 
   * @param targetConnection  Database Connection for target data
   * @throws GDAOException
   *
   **********************************************************************/
   public void deleteByToArrayBatch(Connection sourceConnection, Connection targetConnection) throws GDAOException {

      String whatWeAreDoing = "\"deleteByToArrayBatch()\" for TABLE \"POSITION\"";

      long rowsAffected = 0;

      int[] deleteCountsArray = null;
      PreparedStatement preparedStatement = null;

      PositionTab positionTabSource = null;
      PositionTab positionTabTarget = null;

      log.info("Starting " + whatWeAreDoing);

      try {

         /**********************************************************************
         *
         * Executing statements which will NOT ignore Oracle errors:
         *
         * NOTE:
         * Disabling constraints and dropping indexes may improve Delete
         * performances. If you choose to do that, do not forget to enable
         * constraints and recreate indexes after deletion is done.
         *
         **********************************************************************/
         //SQL = "ALTER TABLE POSITION DISABLE CONSTRAINT ....";
         //oracleSystemTab.runSQL(SQL);

         //SQL = "DROP INDEX ...";
         //oracleSystemTab.runSQL(SQL);

         positionTabSource = new PositionTab(sourceConnection);
         positionTabTarget = new PositionTab(targetConnection);

         /**********************************************************************
         *
         * Use the following parameters in order to speed up SELECT
         * and to prevent program from failing because of EXAUSTED MEMORY error:
         * java.lang.OutOfMemoryError: Java heap space
         *
         **********************************************************************/
         positionTabSource.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         positionTabSource.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

         /**********************************************************************
          *
          * Target ResultSet should be:
          * - ResultSet.TYPE_SCROLL_SENSITIVE,
          * - ResultSet.CONCUR_UPDATABLE
          *
          **********************************************************************/
         positionTabTarget.setResultSetConcurrency(ResultSet.CONCUR_UPDATABLE);
         positionTabTarget.setResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE);

         log.info("Number of records before Batch Delete: " + positionTabTarget.getRowCount());

         log.info("Use Oracle Cursors for selecting large number of records...");

         targetConnection.setAutoCommit(false);

         /**********************************************************************
          *
          * Get Source Data into array of Transfer Objects
          * NOTE:
          * This is just a sample how to create array of transfer objects.
          * In WEB application this could be result of the user input or similar.
          *
          **********************************************************************/
         positionTabSource.getAllRecordsRs();
         ArrayList<PositionTo> positionToArrayList = positionTabSource.getToArrayEntireResultSet();

         /**********************************************************************
          *
          * Prepare Batch Delete Statement
          *
          **********************************************************************/
         preparedStatement = positionTabTarget.getDeleteByPkPreparedStatement();

         Iterator<PositionTo> iterator = positionToArrayList.iterator();

         long executedDeleteStatement = 0;

         while (iterator.hasNext()) {
            /**********************************************************************
             *
             * Retrieve values from table POSITION
             * using DAO object "positionTo"
             *
             **********************************************************************/

            PositionTo positionTo = iterator.next();
            positionTabTarget.deleteByToAddToBach(preparedStatement, positionTo);

            executedDeleteStatement++;

            if (executedDeleteStatement % TRANSACTION_TRESHOLD == 0) {
               /**********************************************************************
                *
                * Execute Batch Insert
                *
                **********************************************************************/
               deleteCountsArray = preparedStatement.executeBatch();
               targetConnection.commit();

               rowsAffected = checkBatchUpdateResults(deleteCountsArray);

               if (rowsAffected >= 0) {
                  log.info("Deleted " + executedDeleteStatement + " records from TABLE \"POSITION\".");
               } else {
                  /**********************************************************************
                   *
                   * Results from JDBC are unreliable so we only know that statements are
                   * executed but we don't know if rows are deleted.
                   *
                   **********************************************************************/
                  log.info("Executed " + executedDeleteStatement + " delete statements for TABLE \"POSITION\".");
               }
            }
         }

         deleteCountsArray = preparedStatement.executeBatch();
         targetConnection.commit();

         rowsAffected = checkBatchUpdateResults(deleteCountsArray);

         if (rowsAffected >= 0) {
            log.info("Deleted " + executedDeleteStatement + " records from TABLE \"POSITION\".");
         } else {
            /**********************************************************************
             *
             * Results from JDBC are unreliable so we only know that statements are
             * executed but we don't know if rows are deleted.
             *
             **********************************************************************/
            log.info("Executed " + executedDeleteStatement + " delete statements for TABLE \"POSITION\".");
         }

         targetConnection.setAutoCommit(true);

         log.info("Number of records after Batch Delete: " + positionTabTarget.getRowCount());

      } catch (GDAOException e) {
         log.error("Cannot perform DDL/DML on TABLE \"POSITION\".");
         throw new GDAOException(e);
      } catch (BatchUpdateException b) {
         /**********************************************************************
          *
          * Handles exception in statement:
          * ps.executeBatch();
          *
          **********************************************************************/
         log.error("----BatchUpdateException----");
         log.error("SQLState:              " + b.getSQLState());
         log.error("Message:               " + b.getMessage());
         log.error("Vendor exception code: " + b.getErrorCode());
         
          log.error("Update count for each update statement in the batch update that executed successfully before this exception occurred:  ");

         int[] updateCounts = b.getUpdateCounts();
         for (int i = 0; i < updateCounts.length; i++) {
            log.error(updateCounts[i] + "   ");
         }

         log.error("----------------------------");

         throw new GDAOException(b);
      } catch (SQLException e) {
         throw new GDAOException(e);
      } finally {
         try {
            positionTabSource.releaseStatement();
            preparedStatement.close();
         } catch (SQLException e) {
            throw new GDAOException(e);
         }
      }
      log.info("Finished " + whatWeAreDoing);
   }

   /**********************************************************************
    *
    * This is utility method used to show results from Batch statements
    *
    **********************************************************************/
   private long checkBatchUpdateResults(int[] results) {
      long rowsAffected = 0;
      int i = 0;
      String resultText = "";

      log.debug("Batch update result array size = " + results.length);

      for (i = 0; i < results.length; i++) {
         if (results[i] >= 0) {
            /**********************************************************************
             *
             * If there were no errors so far and if all results of updates are
             * known continue to increase rowsAffected counter.
             * If there were any errors or unknown results - return the error code
             * (negative number).
             *
             **********************************************************************/
            if (rowsAffected >= 0) {
               rowsAffected++;
            }
            resultText = "Success - rows affected: " + results[i];
         } else {

            switch (results[i]) {
               case PreparedStatement.SUCCESS_NO_INFO:
                  resultText = "Success - no info";
                  rowsAffected = PreparedStatement.SUCCESS_NO_INFO;
                  break;
               case PreparedStatement.EXECUTE_FAILED:
                  resultText = "Failure";
                  rowsAffected = PreparedStatement.EXECUTE_FAILED;
                  break;
               default:
                  resultText = "Invalid return code";
                  rowsAffected = -1;
                  break;
            }
         }

         log.debug("result[" + i + "] = " + resultText);
      }

      log.debug("Returning rowsAffected = " + rowsAffected);

      return rowsAffected;
   }
   
   
   /**********************************************************************
   *
   * Demonstrates Delete using Array of Transfer Objects.
   *
   * This method differs from "deleteByToArrayBatch()" because deleted are
   * not done in "batch". Batch deletes are usually about 30% faster however
   * they don't provide reliable information about how many records are
   * deleted. When we need to know exactly how many records are deleted by
   * calling deleted methods we should use this approach.
   *
   * Process flow:
   * An array of Transfer Objects will be selected from one schema and
   * then it will be used to delete records in another schema.
   *
   * Note that this example uses two distinct database connections.
   * This is just to demonstrate that source and target database could be
   * different and that this method could be use to transfer data from 
   * one database to another. 
   *   
   * @param sourceConnection  Database Connection for source data 
   * @param targetConnection  Database Connection for target data
   * @return                  Total number of records deleted
   * @throws  GDAOException
   *
   **********************************************************************/
   public long deleteByToArray(Connection sourceConnection, Connection targetConnection) throws GDAOException {

      String whatWeAreDoing = "\"deleteByToArray()\" for TABLE \"POSITION\"";

      long executedDeleteStatement = 0;
      long totalRecordsDeleted = 0;
      OracleSystemTab oracleSystemTabTarget = new OracleSystemTab(targetConnection);

      PositionTab positionTabSource = null;
      PositionTab positionTabTarget = null;

      log.info("Starting " + whatWeAreDoing);

      try {

         /**********************************************************************
         *
         * Executing statements which will NOT ignore Oracle errors:
         *
         * NOTE:
         * Disabling constraints and dropping indexes may improve Delete
         * performances. If you choose to do that, do not forget to enable
         * constraints and recreate indexes after deletion is done.
         *
         **********************************************************************/
         //SQL = "ALTER TABLE POSITION DISABLE CONSTRAINT ....";
         //oracleSystemTab.runSQL(SQL);

         //SQL = "DROP INDEX ...";
         //oracleSystemTab.runSQL(SQL);

         positionTabSource = new PositionTab(sourceConnection);
         positionTabTarget = new PositionTab(targetConnection);

         /**********************************************************************
         *
         * Use the following parameters in order to speed up SELECT
         * and to prevent program from failing because of EXAUSTED MEMORY error:
         * java.lang.OutOfMemoryError: Java heap space
         *
         **********************************************************************/
         positionTabSource.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         positionTabSource.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

         /**********************************************************************
          *
          * Target ResultSet should be:
          * - ResultSet.TYPE_SCROLL_SENSITIVE,
          * - ResultSet.CONCUR_UPDATABLE
          *
          **********************************************************************/
         positionTabTarget.setResultSetConcurrency(ResultSet.CONCUR_UPDATABLE);
         positionTabTarget.setResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE);

         log.info("Number of records before Delete: " + positionTabTarget.getRowCount());

         targetConnection.setAutoCommit(false);

         /**********************************************************************
          *
          * Get Source Data into array of Transfer Objects
          * NOTE:
          * This is just a sample how to create array of transfer objects.
          * In WEB application this could be result of the user input or similar.
          *
          **********************************************************************/
         positionTabSource.getAllRecordsRs();
         //positionTabSource.getResultSet("WHERE OPERATION_TYPE = ?", "M");

         ArrayList<PositionTo> positionToArrayList = positionTabSource.getToArrayEntireResultSet();

         Iterator<PositionTo> iterator = positionToArrayList.iterator();

         /**********************************************************************
          *
          * Loop through array of Transfer objects and delete matching records
          * using DAO Object "positionTabTarget"
          *
          **********************************************************************/
         while (iterator.hasNext()) {

            PositionTo positionTo = iterator.next();

            /**********************************************************************
             *
             * Only one record should be delete for tables with Primary key
             * Primary Key is automatically recognized by GDAO.
             * If table does not have PK, deletes using this method is unreliable
             * and it should not be used.
             *
             **********************************************************************/
            int recordsDeleted = positionTabTarget.deleteRecordUsingTo(positionTo);
            
            //alternative method - to be tested:
            //positionTabTarget.delete(positionTo);

            totalRecordsDeleted += recordsDeleted;
            executedDeleteStatement++;

            /**********************************************************************
             *
             * Commit transaction after certain number of records are deleted.
             *
             **********************************************************************/
            if (totalRecordsDeleted % TRANSACTION_TRESHOLD == 0) {
               targetConnection.commit();
               log.info("Deleted " + totalRecordsDeleted + " records from TABLE \"POSITION\".");
               log.info("Executed " + executedDeleteStatement + " delete statements for TABLE \"POSITION\".");
            }
         }

         targetConnection.commit();

         log.info("Deleted " + totalRecordsDeleted + " records from TABLE \"POSITION\".");
         log.info("Executed " + executedDeleteStatement + " DELETE statements for TABLE \"POSITION\".");
         targetConnection.setAutoCommit(true);

         log.info("Number of records after Delete: " + positionTabTarget.getRowCount());

      } catch (GDAOException e) {
         log.error("Cannot perform DDL/DML on TABLE \"POSITION\".");
         throw new GDAOException(e);
      } catch (SQLException e) {
         throw new GDAOException(e);
      } finally {
         positionTabSource.releaseStatement();
      }

      log.info("Finished " + whatWeAreDoing);
      
      return totalRecordsDeleted;
   }
   
   
  /**********************************************************************
   *
   * Demonstrates Updates using Array of Transfer Objects.
   *
   * This method differs from "updateByToArrayBatch()" because updates are
   * not done in "batch". Batch updates are usually about 30% faster however
   * they don't provide reliable information about how many records are
   * updated. When we need to know exactly how many records are updated by
   * calling update methods we should use this approach.
   *
   * Process flow:
   * 1. An array of Transfer Objects will be selected from source schema
   * 2. Values are changed in Transfer Objects
   * 3. Transfer objects are used to update records in target schema.
   *    Data in the database will be updated with new values from Transfer
   *    Object.
   *
   * Note that this example uses two distinct database connections.
   * This is just to demonstrate that source and target database could be
   * different and that this method could be use to transfer data from 
   * one database to another. 
   * 
   * @param sourceConnection  Database Connection for source data 
   * @param targetConnection  Database Connection for target data
   * @return                  Total number of records updated
   * @throws GDAOException
   *
   **********************************************************************/
   public long updateByToArray(Connection sourceConnection, Connection targetConnection) throws GDAOException {

      String whatWeAreDoing = "\"updateByToArray()\" for TABLE \"POSITION\"";

      long executedUpdateStatement = 0;
      long totalRecordsUpdated = 0;

      PositionTab positionTabSource = null;
      PositionTab positionTabTarget = null;

      log.info("Starting " + whatWeAreDoing);

      try {

         /**********************************************************************
         *
         * Executing statements which will NOT ignore Oracle errors:
         *
         * NOTE:
         * Disabling constraints and dropping indexes may improve Update
         * performances. If you choose to do that, do not forget to enable
         * constraints and recreate indexes after update is done.
         *
         **********************************************************************/
         //SQL = "ALTER TABLE POSITION DISABLE CONSTRAINT ....";
         //oracleSystemTab.runSQL(SQL);

         //SQL = "DROP INDEX ...";
         //oracleSystemTab.runSQL(SQL);

         positionTabSource = new PositionTab(sourceConnection);
         positionTabTarget = new PositionTab(targetConnection);

         /**********************************************************************
         *
         * Use the following parameters in order to speed up SELECT
         * and to prevent program from failing because of EXAUSTED MEMORY error:
         * java.lang.OutOfMemoryError: Java heap space
         *
         **********************************************************************/
         positionTabSource.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         positionTabSource.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

         /**********************************************************************
          *
          * Target ResultSet should be:
          * - ResultSet.TYPE_SCROLL_SENSITIVE,
          * - ResultSet.CONCUR_UPDATABLE
          *
          **********************************************************************/
         positionTabTarget.setResultSetConcurrency(ResultSet.CONCUR_UPDATABLE);
         positionTabTarget.setResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE);

         log.info("Number of records before Update: " + positionTabTarget.getRowCount());

         targetConnection.setAutoCommit(false);

         /**********************************************************************
          *
          * Get Source Data into array of Transfer Objects
          * NOTE:
          * This is just a sample how to create array of transfer objects.
          * In WEB application this could be result of the user input or similar.
          *
          **********************************************************************/
         //positionTabSource.getAllRecordsRs();
         positionTabSource.getResultSet("WHERE OPERATION_TYPE = ?", "M");

         ArrayList<PositionTo> positionToArrayList = positionTabSource.getToArrayEntireResultSet();

         Iterator<PositionTo> iterator = positionToArrayList.iterator();

         /**********************************************************************
          *
          * Loop through array of Transfer objects and update matching records
          * using DAO Object "positionTabTarget"
          *
          **********************************************************************/
         while (iterator.hasNext()) {

            PositionTo positionTo = iterator.next();

            /**********************************************************************
             *
             *  Change values in Transfer Object
             *  These values will be updated in the database.
             *
             **********************************************************************/
            //positionTo.setOPERATION_TYPE("Z");

            /**********************************************************************
             *
             * Only one record should be updated for tables with Primary key
             * Primary Key is automatically recognized by GDAO.
             * If table does not have PK, updates using this method is unreliable
             * and it should not be used.
             *
             **********************************************************************/
            int recordsUpdated = positionTabTarget.updateRecordUsingTo(positionTo);

            totalRecordsUpdated += recordsUpdated;
            executedUpdateStatement++;

            /**********************************************************************
             *
             * Commit transaction after certain number of records are updated.
             *
             **********************************************************************/
            if (totalRecordsUpdated % TRANSACTION_TRESHOLD == 0) {
               targetConnection.commit();
               log.info("Updated " + totalRecordsUpdated + " records in TABLE \"POSITION\".");
               log.info("Executed " + executedUpdateStatement + " UPDATE statements for TABLE \"POSITION\".");
            }
         }

         targetConnection.commit();

         log.info("Updated " + totalRecordsUpdated + " records in TABLE \"POSITION\".");
         log.info("Executed " + executedUpdateStatement + " UPDATE statements for TABLE \"POSITION\".");
         targetConnection.setAutoCommit(true);

         log.info("Number of records after Update: " + positionTabTarget.getRowCount());

      } catch (GDAOException e) {
         log.error("Cannot perform DDL/DML on TABLE \"POSITION\".");
         throw new GDAOException(e);
      } catch (SQLException e) {
         throw new GDAOException(e);
      } finally {
         positionTabSource.releaseStatement();
      }

      log.info("Finished " + whatWeAreDoing);
      
      return totalRecordsUpdated;
   }


   /**********************************************************************
   *
   * Demonstrates Batch Update using Array of Transfer Objects.
   *
   * An array of Transfer Objects will be selected from one schema and
   * then it will be used to update records in another schema.
   *
   * NOTE:
   * Actual records updated may not be possible to determine because
   * "preparedStatement.executeBatch()" mat return array of results
   * such as: PreparedStatement.SUCCESS_NO_INFO which means that SQL
   * Statement was successfully executed but is is unknown if record is
   * updated or not (for example - not found).
   * This is the limitation of JDBC implementation.
   *
   * Note that this example uses two distinct database connections.
   * This is just to demonstrate that source and target database could be
   * different and that this method could be use to transfer data from 
   * one database to another. 
   *
   * If you need reliable information about number of successful updates
   * this method of deletion may not be a good choice.
   *
   * @param sourceConnection  Database Connection for source data 
   * @param targetConnection  Database Connection for target data
   * @return                  Total number of records updated
   * @throws GDAOException
   *
   **********************************************************************/
   public long updateByToArrayBatch(Connection sourceConnection, Connection targetConnection) throws GDAOException {

      String whatWeAreDoing = "\"updateByToArrayBatch()\" for TABLE \"POSITION\"";

      long rowsAffected = 0;

      int[] updateCountsArray = null;
      PreparedStatement preparedStatementForUpdate = null;

      PositionTab positionTabSource = null;
      PositionTab positionTabTarget = null;

      log.info("Starting " + whatWeAreDoing);

      try {

         /**********************************************************************
         *
         * Executing statements which will NOT ignore Oracle errors:
         *
         * NOTE:
         * Disabling constraints and dropping indexes may improve Update
         * performances. If you choose to do that, do not forget to enable
         * constraints and recreate indexes after deletion is done.
         *
         **********************************************************************/
         //SQL = "ALTER TABLE POSITION DISABLE CONSTRAINT ....";
         //oracleSystemTab.runSQL(SQL);

         //SQL = "DROP INDEX ...";
         //oracleSystemTab.runSQL(SQL);

         positionTabSource = new PositionTab(sourceConnection);
         positionTabTarget = new PositionTab(targetConnection);

         /**********************************************************************
         *
         * Use the following parameters in order to speed up SELECT
         * and to prevent program from failing because of EXAUSTED MEMORY error:
         * java.lang.OutOfMemoryError: Java heap space
         *
         **********************************************************************/
         positionTabSource.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         positionTabSource.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

         /**********************************************************************
          *
          * Target ResultSet should be:
          * - ResultSet.TYPE_SCROLL_SENSITIVE,
          * - ResultSet.CONCUR_UPDATABLE
          *
          **********************************************************************/
         positionTabTarget.setResultSetConcurrency(ResultSet.CONCUR_UPDATABLE);
         positionTabTarget.setResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE);

         log.info("Number of records before Batch Update: " + positionTabTarget.getRowCount());

         log.info("Use Oracle Cursors for selecting large number of records...");

         targetConnection.setAutoCommit(false);

         /**********************************************************************
          *
          * Get Source Data into array of Transfer Objects
          * NOTE:
          * This is just a sample how to create array of transfer objects.
          * In WEB application this could be result of the user input or similar.
          *
          **********************************************************************/
         //positionTabSource.getAllRecordsRs();
         positionTabSource.getResultSet("WHERE OPERATION_TYPE = ?", "M");


         ArrayList<PositionTo> positionToArrayList = positionTabSource.getToArrayEntireResultSet();

         /**********************************************************************
          *
          * Prepare Batch Update Statement
          *
          **********************************************************************/
         preparedStatementForUpdate = positionTabTarget.getUpdateByPkPreparedStatement();

         Iterator<PositionTo> iterator = positionToArrayList.iterator();

         long executedUpdateStatement = 0;

         while (iterator.hasNext()) {
            /**********************************************************************
             *
             * Retrieve values from table POSITION
             * using DAO object "positionTo"
             *
             **********************************************************************/

            PositionTo positionTo = iterator.next();


            /**********************************************************************
             *
             *  Change values in Transfer Object
             *  These values will be updated in the database.
             *
             **********************************************************************/
            //positionTo.setOPERATION_TYPE("Z");

            positionTabTarget.updateByToAddToBach(preparedStatementForUpdate, positionTo);

            executedUpdateStatement++;

            if (executedUpdateStatement % TRANSACTION_TRESHOLD == 0) {
               /**********************************************************************
                *
                * Execute Batch Insert
                *
                **********************************************************************/
               updateCountsArray = preparedStatementForUpdate.executeBatch();

               targetConnection.commit();

               rowsAffected = checkBatchUpdateResults(updateCountsArray);

               if (rowsAffected >= 0) {
                  log.info("Updated " + executedUpdateStatement + " records in TABLE \"POSITION\".");
               } else {
                  /**********************************************************************
                   *
                   * Results from JDBC are unreliable so we only know that statements are
                   * executed but we don't know if rows are updated.
                   *
                   **********************************************************************/
                  log.info("Executed " + executedUpdateStatement + " update statements for TABLE \"POSITION\".");
               }
            }
         }

         updateCountsArray = preparedStatementForUpdate.executeBatch();
         targetConnection.commit();

         rowsAffected = checkBatchUpdateResults(updateCountsArray);

         if (rowsAffected >= 0) {
            log.info("Updated " + executedUpdateStatement + " records in TABLE \"POSITION\".");
         } else {
            /**********************************************************************
             *
             * Results from JDBC are unreliable so we only know that statements are
             * executed but we don't know if rows are updated.
             *
             **********************************************************************/
            log.info("Executed " + executedUpdateStatement + " UPDATE statements for TABLE \"POSITION\".");
         }

         targetConnection.setAutoCommit(true);

         log.info("Number of records after Batch Update: " + positionTabTarget.getRowCount());

      } catch (GDAOException e) {
         log.error("Cannot perform DDL/DML on TABLE \"POSITION\".");
         throw new GDAOException(e);
      } catch (BatchUpdateException b) {
         /**********************************************************************
          *
          * Handles exception in statement:
          * ps.executeBatch();
          *
          **********************************************************************/
         log.error("----BatchUpdateException----");
         log.error("SQLState:  " + b.getSQLState());
         log.error("Message:  " + b.getMessage());
         log.error("Vendor:  " + b.getErrorCode());
         log.error("Update counts:  ");

         int[] updateCounts = b.getUpdateCounts();
         for (int i = 0; i < updateCounts.length; i++) {
            log.error(updateCounts[i] + "   ");
         }

         log.error("----------------------------");

         throw new GDAOException(b);
      } catch (SQLException e) {
         throw new GDAOException(e);
      } finally {
         try {
            positionTabSource.releaseStatement();
            preparedStatementForUpdate.close();
         } catch (SQLException e) {
            throw new GDAOException(e);
         }
      }
      
      log.info("Finished " + whatWeAreDoing);
      
      return rowsAffected;
   }
   
   /**********************************************************************
    *
    * Obtain database connection
    *
    * @return Database Connection
    * @throws GDAOException
    *
    **********************************************************************/
    public static Connection getConnection() throws GDAOException {
      Connection connection = null;

      String db_server = "zserver";
      String db_port = "1521";
      String db_name = "ZORACLE";
      String db_username = "scott";
      String db_password = "tiger";
      String db_url = "jdbc:oracle:thin:@" + db_server + ":" + db_port + ":" + db_name;

      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         connection = DriverManager.getConnection(db_url, db_username, db_password);
      } catch (ClassNotFoundException ex) {
         ex.printStackTrace();
         throw new GDAOException(ex);
      } catch (SQLException ex) {
         ex.printStackTrace();
         throw new GDAOException(ex);
      }
      return connection;
   }



   /**********************************************************************
    *
    * Obtain database connection based on parameters stored in 
    * database connection definition file:
    * "conf/dbconnections/dbconnections.txt"
    *        
    * Use default DB connection configuration file: GDAODatabaseConnectionFactory()
    * or supply yours:  GDAODatabaseConnectionFactory("/dbconnections.txt")
    *
    * @param  connectionId   This is one of coonectionId's as specified in  file "dbconnections.txt"
    * @return Database Connection
    * @throws GDAOException
    *
    **********************************************************************/
    public static Connection getConnection(String connectionId)  throws GDAOException {
        Connection connection = null;
        //GDAODatabaseConnectionFactory gDAODatabaseConnectionFactory = new GDAODatabaseConnectionFactory(); // uses default database configuration file
        GDAODatabaseConnectionFactory gDAODatabaseConnectionFactory = new GDAODatabaseConnectionFactory("/dbconnections.txt");
        connection = gDAODatabaseConnectionFactory.getConnection(connectionId);
        return connection;
    } 




/*************************************************************************
                          Various utility methods
                          -----------------------

     SQL = "ALTER SESSION SET CURRENT_SCHEMA = GDAODEMO";
     oracleSystemTabSource.runSQL(SQL);

     //Alternative 1 for changing active schema:
     //oracleSystemTabSource.setOracleCurrentSchema("GDAODEMO");

     log.info("Session in source database connection is altered to schema GDAODEMO.");

     //Alternative 2 for changing active schema:
     //positionTabSource.setDbEntityName("GDAODEMO.POSITION");


***************************************************************************/
  
}
