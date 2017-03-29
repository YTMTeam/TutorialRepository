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

import com.mallocinc.database.generated.working.VExcelTradeTab;
import com.mallocinc.database.generated.to.VExcelTradeTo;

/**********************************************************************
 *  <pre>
 *
 *  Generated Class: VExcelTradeSample.java
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
 *  This code is generated on: 2017-February-27 06:45:58 PM CET
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
 *  Sample GDAO code for VIEW "V_EXCEL_TRADE"
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
public class VExcelTradeSample {

   final static Logger log = Logger.getLogger(VExcelTradeSample.class.getName());
   
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
        VExcelTradeSample vExcelTradeSample = new VExcelTradeSample();

        /**********************************************************************
         *
         * Uncomment test that you want to execute:
         *
         **********************************************************************/
         //vExcelTradeSample.select(connection);
         //vExcelTradeSample.insert(connection);
         //vExcelTradeSample.update(connection);

         //vExcelTradeSample.dataProvider1(connection);
         //vExcelTradeSample.dataProvider2(connection);

         //vExcelTradeSample.deleteViaResultSet(connection);
         //vExcelTradeSample.deleteViaSQL(connection);
         
         //vExcelTradeSample.batchInsert(connection);
         
         //vExcelTradeSample.selectIntoTransferObject(connection);
         
         //vExcelTradeSample.copyDataBetweenDatabases(connection_source, connection_target);
         //vExcelTradeSample.updateByToArray(connection_source, connection_target);
         
         //vExcelTradeSample.deleteByToArrayBatch(connection_source, connection_target);
         //vExcelTradeSample.deleteByToArray(connection_source, connection_target);
         
         //vExcelTradeSample.updateByTo(connection);
         //vExcelTradeSample.deleteByTo(connection);
         
         
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

      log.debug("Starting select from VIEW \"V_EXCEL_TRADE\".");

            java.math.BigDecimal tradeId = null;
      java.math.BigDecimal bankId = null;
      java.lang.String accountId = null;
      java.lang.String bankName = null;
      java.lang.String firstName = null;
      java.lang.String lastName = null;
      java.lang.String transactionType = null;
      java.lang.String securityType = null;
      java.math.BigDecimal netAmount = null;
      java.lang.String currency = null;
      java.math.BigDecimal quantity = null;
      java.lang.String exchange = null;
      java.sql.Timestamp tradeDate = null;


      VExcelTradeTab vExcelTradeTab = new VExcelTradeTab(connection);

      try {

         /**********************************************************************
          *
          * !IMPORTANT!:
          * Use the following parameters in order to speed up SELECT
          * and to prevent program from failing because of EXAUSTED MEMORY error:
          * java.lang.OutOfMemoryError: Java heap space
          *
          **********************************************************************/
         vExcelTradeTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         vExcelTradeTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

         /**********************************************************************
          *
          * Selects specific records from the table:
          * Limit number of rows selected to "100" (just an example)
          * Change "WHERE" condition to meet your needs.
          *
          **********************************************************************/
         vExcelTradeTab.getResultSet("WHERE UPPER(ACCOUNT_ID) LIKE ? AND ROWNUM < ?", "%R%", 100);

         /**********************************************************************
          *
          * Selects all records from the table - no "WHERE" condition.
          * Both methods below are equal:
          *
          **********************************************************************/
         //vExcelTradeTab.getResultSet(null, (Object[])null);
         //vExcelTradeTab.getAllRecordsRs();

         /**********************************************************************
          *
          * Loop through database result set:
          *
          **********************************************************************/
         while (vExcelTradeTab.next()) {

            /**********************************************************************
            *
            * Print all values from the row in one line delimited by "; "
            *
            **********************************************************************/
            vExcelTradeTab.print("; ");

            /**********************************************************************
            *
            * Fetch data from the database into local variables:
            *
            **********************************************************************/
                  tradeId = vExcelTradeTab.getTRADE_ID();
      bankId = vExcelTradeTab.getBANK_ID();
      accountId = vExcelTradeTab.getACCOUNT_ID();
      bankName = vExcelTradeTab.getBANK_NAME();
      firstName = vExcelTradeTab.getFIRST_NAME();
      lastName = vExcelTradeTab.getLAST_NAME();
      transactionType = vExcelTradeTab.getTRANSACTION_TYPE();
      securityType = vExcelTradeTab.getSECURITY_TYPE();
      netAmount = vExcelTradeTab.getNET_AMOUNT();
      currency = vExcelTradeTab.getCURRENCY();
      quantity = vExcelTradeTab.getQUANTITY();
      exchange = vExcelTradeTab.getEXCHANGE();
      tradeDate = vExcelTradeTab.getTRADE_DATE();


            /**********************************************************************
            *
            * Print all values from the row - one line per column:
            *
            **********************************************************************/
               log.debug(String.format("%-30s [%s]", "tradeId", tradeId));
      log.debug(String.format("%-30s [%s]", "bankId", bankId));
      log.debug(String.format("%-30s [%s]", "accountId", accountId));
      log.debug(String.format("%-30s [%s]", "bankName", bankName));
      log.debug(String.format("%-30s [%s]", "firstName", firstName));
      log.debug(String.format("%-30s [%s]", "lastName", lastName));
      log.debug(String.format("%-30s [%s]", "transactionType", transactionType));
      log.debug(String.format("%-30s [%s]", "securityType", securityType));
      log.debug(String.format("%-30s [%s]", "netAmount", netAmount));
      log.debug(String.format("%-30s [%s]", "currency", currency));
      log.debug(String.format("%-30s [%s]", "quantity", quantity));
      log.debug(String.format("%-30s [%s]", "exchange", exchange));
      log.debug(String.format("%-30s [%s]", "tradeDate", tradeDate));
   

            log.debug("---------------^^^^^^^^^-----------------");
         }

      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot select from VIEW \"V_EXCEL_TRADE\".");
         throw new GDAOException(e);
      } finally {
         vExcelTradeTab.releaseStatement();
      }

      log.debug("Finished select from VIEW \"V_EXCEL_TRADE\".");
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

      String whatWeAreDoing = "\"selectIntoTransferObject()\" for VIEW \"V_EXCEL_TRADE\"";

      log.debug("Starting " + whatWeAreDoing);

      /**********************************************************************
       *
       * Create DAO object for selecting data from the database
       *
       **********************************************************************/
      VExcelTradeTab vExcelTradeTabForSelect = new VExcelTradeTab(connection);

      try {

         /**********************************************************************
          *
          * Use the following parameters in order to speed up SELECT
          * and to prevent program from failing because of exhausted memory
          *
          **********************************************************************/
         vExcelTradeTabForSelect.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         vExcelTradeTabForSelect.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

         /**********************************************************************
          *
          * Selects specific records from the table:
          * Limit number of rows selected to "100" (just an example)
          *
          **********************************************************************/
         vExcelTradeTabForSelect.getResultSet("WHERE UPPER(CREDIT_DEBIT_CODE) LIKE ? AND ROWNUM < ?", "%C%", 100);

         /**********************************************************************
          *
          * Selects all records from the table - no "WHERE" condition.
          * Both methods below are equal:
          *
          **********************************************************************/
         //vExcelTradeTab.getResultSet(null, (Object[])null);
         //vExcelTradeTab.getAllRecordsRs();

         /**********************************************************************
          *
          * Loop through database result set:
          *
          **********************************************************************/
         while (vExcelTradeTabForSelect.next()) {
         
            /**********************************************************************
            *
            * Print all values from the row in one line delimited by "; "
            *
            **********************************************************************/
            //vExcelTradeTab.print("; ");

            /**********************************************************************
            *
            * Fetch data from the database into local variables:
            *
            **********************************************************************/
            VExcelTradeTo vExcelTradeTo  = vExcelTradeTabForSelect.getTo();

            /**********************************************************************
             *
             * Print Transfer object content
             *
             **********************************************************************/
            //vExcelTradeTo.print();

            /**********************************************************************
             *
             * Make desired changes to data
             * Sample is provided below.
             *
             **********************************************************************/
             /*
            vExcelTradeTo.setRECURRING_TRANS_HIST_ID(vExcelTradeTabForSelect.getNextval());
            vExcelTradeTo.setCOMMENTS("This is Zoran's test record");
            vExcelTradeTo.setREJECT_REASON(null);
            vExcelTradeTo.setCREATE_DATETIME(TimestampUtility.getCurrentTimestamp());
            */

            /**********************************************************************
             *
             * Create another DAO object for inserting data into database.
             *
             **********************************************************************/
            VExcelTradeTab vExcelTradeTabForInsert = new VExcelTradeTab(connection);

            vExcelTradeTabForInsert.setThisFromTo(vExcelTradeTo);

            vExcelTradeTabForInsert.insertThisRecord();

            log.debug("---------------^^^^^^^^^-----------------");
         }

      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot select into TO's from VIEW \"V_EXCEL_TRADE\".");
         throw new GDAOException(e);
      } finally {
         vExcelTradeTabForSelect.releaseStatement();
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

      log.debug("Starting insert into VIEW \"V_EXCEL_TRADE\"...");

            java.math.BigDecimal tradeId = null;
      java.math.BigDecimal bankId = null;
      java.lang.String accountId = null;
      java.lang.String bankName = null;
      java.lang.String firstName = null;
      java.lang.String lastName = null;
      java.lang.String transactionType = null;
      java.lang.String securityType = null;
      java.math.BigDecimal netAmount = null;
      java.lang.String currency = null;
      java.math.BigDecimal quantity = null;
      java.lang.String exchange = null;
      java.sql.Timestamp tradeDate = null;


      

      VExcelTradeTab vExcelTradeTab = new VExcelTradeTab(connection);

      try {

        /**********************************************************************
         *
         * For PK values use sequence, something like:
         * BigDecimal VExcelTradeTab_id = VExcelTradeTab.getNextval(sequenceName);
         * or if sequence has a standard name like "S_V_EXCEL_TRADE":
         * BigDecimal VExcelTradeTab_id = VExcelTradeTab.getNextval();
         *
         **********************************************************************/
               tradeId = new BigDecimal(0);
      bankId = new BigDecimal(0);
      accountId = "new accountId";
      bankName = "new bankName";
      firstName = "new firstName";
      lastName = "new lastName";
      transactionType = "new transactionType";
      securityType = "new securityType";
      netAmount = new BigDecimal(0);
      currency = "new currency";
      quantity = new BigDecimal(0);
      exchange = "new exchange";
      tradeDate = TimestampUtility.getCurrentTimestamp();


               vExcelTradeTab.setTRADE_ID(tradeId);  // java.math.BigDecimal - Mandatory
      vExcelTradeTab.setBANK_ID(bankId);  // java.math.BigDecimal
      vExcelTradeTab.setACCOUNT_ID(accountId);  // java.lang.String
      vExcelTradeTab.setBANK_NAME(bankName);  // java.lang.String
      vExcelTradeTab.setFIRST_NAME(firstName);  // java.lang.String
      vExcelTradeTab.setLAST_NAME(lastName);  // java.lang.String
      vExcelTradeTab.setTRANSACTION_TYPE(transactionType);  // java.lang.String - Mandatory
      vExcelTradeTab.setSECURITY_TYPE(securityType);  // java.lang.String - Mandatory
      vExcelTradeTab.setNET_AMOUNT(netAmount);  // java.math.BigDecimal - Mandatory
      vExcelTradeTab.setCURRENCY(currency);  // java.lang.String - Mandatory
      vExcelTradeTab.setQUANTITY(quantity);  // java.math.BigDecimal - Mandatory
      vExcelTradeTab.setEXCHANGE(exchange);  // java.lang.String - Mandatory
      vExcelTradeTab.setTRADE_DATE(tradeDate);  // java.sql.Timestamp


         vExcelTradeTab.insertThisRecord();

      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot insert into VIEW \"V_EXCEL_TRADE\".");
         throw new GDAOException(e);
      }
      

      log.debug("Finished insert into VIEW \"V_EXCEL_TRADE\".");
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

      log.debug("Starting update of VIEW \"V_EXCEL_TRADE\".");

            java.math.BigDecimal tradeId = null;
      java.math.BigDecimal bankId = null;
      java.lang.String accountId = null;
      java.lang.String bankName = null;
      java.lang.String firstName = null;
      java.lang.String lastName = null;
      java.lang.String transactionType = null;
      java.lang.String securityType = null;
      java.math.BigDecimal netAmount = null;
      java.lang.String currency = null;
      java.math.BigDecimal quantity = null;
      java.lang.String exchange = null;
      java.sql.Timestamp tradeDate = null;

      
      

      VExcelTradeTab vExcelTradeTab = new VExcelTradeTab(connection);

      try {
         connection.setAutoCommit(false);  // manage transactions manually

         /*************************************************************************
          *
          * Note:
          * Use vExcelTradeTab.setResultSetHoldability(ResultSet.HOLD_CURSORS_OVER_COMMIT);
          *
          * OR
          *
          * "COMMIT" should not be used while looping through the cursor because
          * it will cause Oracle Error:
          * ORA-01002: fetch out of sequence
          *
          **************************************************************************/
         //vExcelTradeTab.setResultSetHoldability(ResultSet.HOLD_CURSORS_OVER_COMMIT);


         /**********************************************************************
          *
          * Updates specific records in the table:
          * NOTE:
          * "WHERE ROWNUM <" or "GROUP BY" cannot be used when updating result set
          *
          **********************************************************************/
         vExcelTradeTab.getResultSetForUpdate("WHERE ACCOUNT_ID LIKE ?", "%R%");

         /**********************************************************************
          *
          * Updates all records in the table:
          *
          **********************************************************************/
         //vExcelTradeTab.getResultSetForUpdate(null, (Object[])null);

         /**********************************************************************
          *
          * Display number of records that will be affected:
          *
          **********************************************************************/
         log.info("ResultSet Row Count (number of records to be affected) = " + vExcelTradeTab.getResultSetRowCount());

         /*************************************************************************
          *
          * Note:
          * "COMMIT" should not be used while looping through the cursor because
          * it will cause Oracle Error:
          * ORA-01002: fetch out of sequence
          *
          **************************************************************************/
         while (vExcelTradeTab.next()) {
                  tradeId = vExcelTradeTab.getTRADE_ID();
      bankId = vExcelTradeTab.getBANK_ID();
      accountId = vExcelTradeTab.getACCOUNT_ID();
      bankName = vExcelTradeTab.getBANK_NAME();
      firstName = vExcelTradeTab.getFIRST_NAME();
      lastName = vExcelTradeTab.getLAST_NAME();
      transactionType = vExcelTradeTab.getTRANSACTION_TYPE();
      securityType = vExcelTradeTab.getSECURITY_TYPE();
      netAmount = vExcelTradeTab.getNET_AMOUNT();
      currency = vExcelTradeTab.getCURRENCY();
      quantity = vExcelTradeTab.getQUANTITY();
      exchange = vExcelTradeTab.getEXCHANGE();
      tradeDate = vExcelTradeTab.getTRADE_DATE();


            log.debug("Updating following values:");
            log.debug("--------------------------");
               log.debug(String.format("%-30s [%s]", "tradeId", tradeId));
      log.debug(String.format("%-30s [%s]", "bankId", bankId));
      log.debug(String.format("%-30s [%s]", "accountId", accountId));
      log.debug(String.format("%-30s [%s]", "bankName", bankName));
      log.debug(String.format("%-30s [%s]", "firstName", firstName));
      log.debug(String.format("%-30s [%s]", "lastName", lastName));
      log.debug(String.format("%-30s [%s]", "transactionType", transactionType));
      log.debug(String.format("%-30s [%s]", "securityType", securityType));
      log.debug(String.format("%-30s [%s]", "netAmount", netAmount));
      log.debug(String.format("%-30s [%s]", "currency", currency));
      log.debug(String.format("%-30s [%s]", "quantity", quantity));
      log.debug(String.format("%-30s [%s]", "exchange", exchange));
      log.debug(String.format("%-30s [%s]", "tradeDate", tradeDate));
   
            log.debug(" ");

                  tradeId = new BigDecimal(0);
      bankId = new BigDecimal(0);
      accountId = "new accountId";
      bankName = "new bankName";
      firstName = "new firstName";
      lastName = "new lastName";
      transactionType = "new transactionType";
      securityType = "new securityType";
      netAmount = new BigDecimal(0);
      currency = "new currency";
      quantity = new BigDecimal(0);
      exchange = "new exchange";
      tradeDate = TimestampUtility.getCurrentTimestamp();


            log.debug("Updating to following values:");
            log.debug("-----------------------------");
               log.debug(String.format("%-30s [%s]", "tradeId", tradeId));
      log.debug(String.format("%-30s [%s]", "bankId", bankId));
      log.debug(String.format("%-30s [%s]", "accountId", accountId));
      log.debug(String.format("%-30s [%s]", "bankName", bankName));
      log.debug(String.format("%-30s [%s]", "firstName", firstName));
      log.debug(String.format("%-30s [%s]", "lastName", lastName));
      log.debug(String.format("%-30s [%s]", "transactionType", transactionType));
      log.debug(String.format("%-30s [%s]", "securityType", securityType));
      log.debug(String.format("%-30s [%s]", "netAmount", netAmount));
      log.debug(String.format("%-30s [%s]", "currency", currency));
      log.debug(String.format("%-30s [%s]", "quantity", quantity));
      log.debug(String.format("%-30s [%s]", "exchange", exchange));
      log.debug(String.format("%-30s [%s]", "tradeDate", tradeDate));
   
            log.debug("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

           /**********************************************************************
           *
           * Set new values for the record which is going to be updated. 
           *
           ***********************************************************************/
                  vExcelTradeTab.setTRADE_ID(tradeId);  // java.math.BigDecimal - Mandatory
      vExcelTradeTab.setBANK_ID(bankId);  // java.math.BigDecimal
      vExcelTradeTab.setACCOUNT_ID(accountId);  // java.lang.String
      vExcelTradeTab.setBANK_NAME(bankName);  // java.lang.String
      vExcelTradeTab.setFIRST_NAME(firstName);  // java.lang.String
      vExcelTradeTab.setLAST_NAME(lastName);  // java.lang.String
      vExcelTradeTab.setTRANSACTION_TYPE(transactionType);  // java.lang.String - Mandatory
      vExcelTradeTab.setSECURITY_TYPE(securityType);  // java.lang.String - Mandatory
      vExcelTradeTab.setNET_AMOUNT(netAmount);  // java.math.BigDecimal - Mandatory
      vExcelTradeTab.setCURRENCY(currency);  // java.lang.String - Mandatory
      vExcelTradeTab.setQUANTITY(quantity);  // java.math.BigDecimal - Mandatory
      vExcelTradeTab.setEXCHANGE(exchange);  // java.lang.String - Mandatory
      vExcelTradeTab.setTRADE_DATE(tradeDate);  // java.sql.Timestamp


           /**********************************************************************
           *
           * Update database record with new values set in the "set" statements 
           * above. 
           *
           ***********************************************************************/
            vExcelTradeTab.updateThisRecordInResultSet();

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
         log.error("Cannot update VIEW \"V_EXCEL_TRADE\".");

         try {
            connection.rollback();  // rollback all updates
         } catch (SQLException e1) {
            log.error("Cannot rollback transaction for updating records from VIEW \"V_EXCEL_TRADE\".");
            e1.printStackTrace();
            throw new GDAOException(e1);
         }
         throw new GDAOException(e);
      }  catch (SQLException e) {
         e.printStackTrace();
         throw new GDAOException(e);
      }
      
      finally {
         vExcelTradeTab.releaseStatement();
      }

      log.debug("Finished update of VIEW \"V_EXCEL_TRADE\".");
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

      log.debug("Starting delete of VIEW \"V_EXCEL_TRADE\".");

      VExcelTradeTab vExcelTradeTab = new VExcelTradeTab(connection);

      try {
         connection.setAutoCommit(false);  // manage transactions manually

         /**********************************************************************
          *
          * Delete records that match WHERE clause in the table:
          * NOTE:
          * "WHERE ROWNUM <" or "GROUP BY" cannot be used when updating result set
          *
          **********************************************************************/
         String SQL = "WHERE ACCOUNT_ID LIKE ?";          
         recordsDeleted = vExcelTradeTab.deleteRecords(SQL, "%R%");

         /**********************************************************************
          *
          * Display number of records that will be affected:
          *
          **********************************************************************/
         log.info(recordsDeleted + " records are deleted from VIEW \"V_EXCEL_TRADE\"");

         /**********************************************************************
          *
          * Commit transaction.
          *
          **********************************************************************/
          connection.commit();
          log.debug("Records deleted=" + recordsDeleted + " - transaction is committed.");

      }  catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot delete  records from VIEW \"V_EXCEL_TRADE\".");

         try {
            connection.rollback();  // rollback all deletes
         } catch (SQLException e1) {
            log.error("Cannot rollback transaction for deleting records from VIEW \"V_EXCEL_TRADE\".");
            e1.printStackTrace();
            throw new GDAOException(e1);
         }
         throw new GDAOException(e);
      }  catch (SQLException e) {
         e.printStackTrace();
         throw new GDAOException(e);
      }

      log.debug("Finished delete of VIEW \"V_EXCEL_TRADE\".");
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

      log.debug("Starting UPDATE by TO of VIEW \"V_EXCEL_TRADE\".");

      VExcelTradeTab vExcelTradeTab = new VExcelTradeTab(connection);

      try {
         connection.setAutoCommit(false); // manage transactions manually

         /**********************************************************************
         *
         * Selects all records from the table - various methods are provided.
         * Uncomment and change one that works for you. 
         *
         **********************************************************************/
         //vExcelTradeTab.getResultSet("WHERE UPPER(USERNAME) LIKE ? ", "%Z%");
         //vExcelTradeTab.getResultSet(null, (Object[])null);
         //vExcelTradeTab.getAllRecordsRs();

         /**********************************************************************
          *
          * Loop through database result set:
          *
          **********************************************************************/
         while (vExcelTradeTab.next()) {

            /**********************************************************************
            *
            * Print all values from the row in one line delimited by "; "
            *
            **********************************************************************/
            //vExcelTradeTab.print("; ");

            /**********************************************************************
            *
            * Fetch data from the database into Transfer Object:
            *
            **********************************************************************/
            VExcelTradeTo vExcelTradeTo = vExcelTradeTab.getTo();
            
            
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
            //vExcelTradeTo.setCITY("Belgrado"); 
            
            int recordsAffected = vExcelTradeTab.updateRecordUsingTo(vExcelTradeTo);

            
            /**********************************************************************
            *
            * Special code has to be developed to display PK values since there 
            * could be multiple fields and names may be different than table name:
            *
            **********************************************************************/
             log.info("Updated " + recordsAffected + " record with PK: "  );

            //Alternative method:
            //recordsDeleted = vExcelTradeTab.updateRecordsUsingPKs(SQL, vExcelTradeTo.getV_EXCEL_TRADE_ID());

         }

         connection.commit();

      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot update records from VIEW \"V_EXCEL_TRADE\".");

         try {
            connection.rollback(); // rollback all updates
         } catch (SQLException e1) {
            log.error("Cannot rollback transaction for deleting records from VIEW \"V_EXCEL_TRADE\".");
            e1.printStackTrace();
            throw new GDAOException(e1);
         }
         throw new GDAOException(e);
      } catch (SQLException e) {
         e.printStackTrace();
         throw new GDAOException(e);
      }

      log.debug("Finished update of VIEW \"V_EXCEL_TRADE\".");
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

      log.debug("Starting delete of VIEW \"V_EXCEL_TRADE\".");

      VExcelTradeTab vExcelTradeTab = new VExcelTradeTab(connection);

      try {
         connection.setAutoCommit(false); // manage transactions manually

         /**********************************************************************
         *
         * Selects all records from the table - no "WHERE" condition.
         * Both methods below are equal:
         *
         **********************************************************************/
         //vExcelTradeTab.getResultSet(null, (Object[])null);
         vExcelTradeTab.getAllRecordsRs();

         /**********************************************************************
          *
          * Loop through database result set:
          *
          **********************************************************************/
         while (vExcelTradeTab.next()) {

            /**********************************************************************
            *
            * Print all values from the row in one line delimited by "; "
            *
            **********************************************************************/
            //vExcelTradeTab.print("; ");

            /**********************************************************************
            *
            * Fetch data from the database into Transfer Object:
            *
            **********************************************************************/
            VExcelTradeTo vExcelTradeTo = vExcelTradeTab.getTo();

            int recordsAffected = vExcelTradeTab.deleteRecordUsingTo(vExcelTradeTo);
         
            log.info("Deleted " + recordsAffected + " record with PK values: "  );

            //Alternative method:
            //recordsDeleted = vExcelTradeTab.deleteRecordsUsingPKs(SQL, vExcelTradeTo.getV_EXCEL_TRADE_ID());

         }

         connection.commit();

      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot delete records from VIEW \"V_EXCEL_TRADE\".");

         try {
            connection.rollback(); // rollback all updates
         } catch (SQLException e1) {
            log.error("Cannot rollback transaction for deleting records from VIEW \"V_EXCEL_TRADE\".");
            e1.printStackTrace();
            throw new GDAOException(e1);
         }
         throw new GDAOException(e);
      } catch (SQLException e) {
         e.printStackTrace();
         throw new GDAOException(e);
      }

      log.debug("Finished delete of VIEW \"V_EXCEL_TRADE\".");
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
   
      String whatWeAreDoing = "\"deleteViaSQLS()\" for VIEW \"V_EXCEL_TRADE\"";

      long recordsDeleted = -1;
      long deleteThisManyRecords = 1000;  //sample number, find optimum number for your database (usually by experimenting)

      log.debug("Starting " + whatWeAreDoing);

      VExcelTradeTab vExcelTradeTab = new VExcelTradeTab(connection);

      try {
         connection.setAutoCommit(false);  // manage transactions manually

         /**********************************************************************
          *
          * Updates specific records in the table:
          * NOTE:
          * "WHERE ROWNUM <" or "GROUP BY" cannot be used when updating result set
          *
          **********************************************************************/
         String SQL = "WHERE ACCOUNT_ID LIKE ?";  
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
            recordsDeleted = vExcelTradeTab.deleteRecords(SQL, "%R%", deleteThisManyRecords);

            /**********************************************************************
             *
             * Display number of records that will be affected:
             *
             **********************************************************************/
            log.info(recordsDeleted + " records are deleted from VIEW \"V_EXCEL_TRADE\"");

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

      String whatWeAreDoing = "\"deleteViaResultSet()\" for VIEW \"V_EXCEL_TRADE\"";

      long recordsProcessed = 0;

      log.debug("Starting " + whatWeAreDoing);

      VExcelTradeTab vExcelTradeTab = new VExcelTradeTab(connection);

      try {
         connection.setAutoCommit(false);  // manage transactions manually

         /*************************************************************************
          *
          * Note:
          * Use vExcelTradeTab.setResultSetHoldability(ResultSet.HOLD_CURSORS_OVER_COMMIT);
          *
          * OR
          *
          * "COMMIT" should not be used while looping through the cursor because
          * it will cause Oracle Error:
          * ORA-01002: fetch out of sequence
          *
          **************************************************************************/
         vExcelTradeTab.setResultSetHoldability(ResultSet.HOLD_CURSORS_OVER_COMMIT);

         /**********************************************************************
          *
          * Updates specific records in the table:
          * NOTE:
          * "WHERE ROWNUM <" or "GROUP BY" cannot be used when updating result set
          *
          **********************************************************************/
         vExcelTradeTab.getResultSet("WHERE ACCOUNT_ID LIKE ?", "%R%");

         /**********************************************************************
          *
          * Display number of records that will be affected:
          *
          **********************************************************************/
         log.info("ResultSet Row Count (number of records to be affected) = " + vExcelTradeTab.getResultSetRowCount());

         while (vExcelTradeTab.next()) {

            vExcelTradeTab.deleteThisRecordFromResultSet();
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
         log.error("Cannot update VIEW \"V_EXCEL_TRADE\".");

         try {
            connection.rollback();  // rollback all deletes
         } catch (SQLException e1) {
            log.error("Cannot rollback transaction for deleting records from VIEW \"V_EXCEL_TRADE\".");
            e1.printStackTrace();
            throw new GDAOException(e1);
         }
         throw new GDAOException(e);
      }  catch (SQLException e) {
         e.printStackTrace();
         throw new GDAOException(e);
      }
      finally {
         vExcelTradeTab.releaseStatement();
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


      String whatWeAreDoing = "\"batchInsert()\" for VIEW \"V_EXCEL_TRADE\"";

      String SQL = null;
      OracleSystemTab oracleSystemTab = new OracleSystemTab(connection);
      int[] insertCounts = null;
      PreparedStatement ps = null;
      VExcelTradeTab vExcelTradeTab = null;

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
         //SQL = "ALTER TABLE V_EXCEL_TRADE DISABLE CONSTRAINT ....";
         //oracleSystemTab.runSQL(SQL);

         //SQL = "DROP INDEX ...";
         //oracleSystemTab.runSQL(SQL);

         SQL = "TRUNCATE TABLE V_EXCEL_TRADE";
         oracleSystemTab.runSQL(SQL);

         log.info("VIEW \"V_EXCEL_TRADE\" is truncated.");

         vExcelTradeTab = new VExcelTradeTab(connection);

         log.info("Use Oracle Cursors for selecting and Batch Inserts for inserting large number of records...");

         connection.setAutoCommit(false);

         /**********************************************************************
         *
         * Change underlying table for this DAO object to 
         * V_EXCEL_TRADE_BKP 
         * This will affect only selects from this DAO object.
         *
         **********************************************************************/
         vExcelTradeTab.setDbEntityName("V_EXCEL_TRADE_BKP");
         vExcelTradeTab.getAllRecordsRs();

         vExcelTradeTab.setDbEntityName("V_EXCEL_TRADE");
         ps = vExcelTradeTab.getInsertPreparedStatement();

         long recordsInserted = 0;
         while (vExcelTradeTab.next()) {
            /**********************************************************************
             *
             * Retrieve values from table V_EXCEL_TRADE_BKP
             * using DAO object "vExcelTradeTo"
             *
             **********************************************************************/
            VExcelTradeTo vExcelTradeTo = vExcelTradeTab.getTo();
            vExcelTradeTab.addInsertBatch(ps, vExcelTradeTo);

            recordsInserted++;

            if (recordsInserted % TRANSACTION_TRESHOLD == 0) {
               /**********************************************************************
                *
                * Execute Batch Insert
                *
                **********************************************************************/
               insertCounts = ps.executeBatch();
               connection.commit();
               log.info("Inserted and committed " + recordsInserted + " records into VIEW \"V_EXCEL_TRADE\".");
            }
         }

         insertCounts = ps.executeBatch();
         connection.commit();
         
         log.info("Inserted and committed " + recordsInserted + " records into VIEW \"V_EXCEL_TRADE\".");

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
         log.error("Cannot perform DDL/DML on VIEW \"V_EXCEL_TRADE\".");
         throw new GDAOException(e);
      } catch (SQLException e) {
         e.printStackTrace();
         throw new GDAOException(e);
      } finally {
         try {
            vExcelTradeTab.releaseStatement();
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

      String whatWeAreDoing = "\"batchDelete()\" for VIEW \"V_EXCEL_TRADE\"";

      String SQL = null;
      OracleSystemTab oracleSystemTab = new OracleSystemTab(connection);
      int[] insertCounts = null;
      PreparedStatement ps = null;
      VExcelTradeTab vExcelTradeTab = null;

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
         //SQL = "ALTER TABLE V_EXCEL_TRADE DISABLE CONSTRAINT ....";
         //oracleSystemTab.runSQL(SQL);

         //SQL = "DROP INDEX ...";
         //oracleSystemTab.runSQL(SQL);

         //log.info("VIEW \"V_EXCEL_TRADE\" indexes are dropped.");

         vExcelTradeTab = new VExcelTradeTab(connection);

         log.info("Use Oracle Cursors for selecting and Batch Inserts for inserting large number of records...");

         connection.setAutoCommit(false);

         /**********************************************************************
         *
         * Change underlying table for this DAO object to 
         * V_EXCEL_TRADE_BKP 
         * This will affect only selects from this DAO object.
         *
         **********************************************************************/
         vExcelTradeTab.setDbEntityName("V_EXCEL_TRADE_BKP");
         vExcelTradeTab.getAllRecordsRs();

         vExcelTradeTab.setDbEntityName("V_EXCEL_TRADE");
         ps = vExcelTradeTab.getDeleteByPkPreparedStatement();

         int[] deleteCounts = null;
         long recordsDeleted = 0;
         while (vExcelTradeTab.next()) {
            /**********************************************************************
             *
             * Retrieve values from table V_EXCEL_TRADE_BKP
             * using DAO object "vExcelTradeTo"
             *
             **********************************************************************/
            VExcelTradeTo vExcelTradeTo = vExcelTradeTab.getTo();
            vExcelTradeTab.addInsertBatch(ps, vExcelTradeTo);

            recordsDeleted++;

            if (recordsDeleted % TRANSACTION_TRESHOLD == 0) {
               /**********************************************************************
                *
                * Execute Batch Insert
                *
                **********************************************************************/
               deleteCounts = ps.executeBatch();
               connection.commit();
               log.info("Deleted and committed " + recordsDeleted + " records from VIEW \"V_EXCEL_TRADE\".");
            }
         }

         deleteCounts = ps.executeBatch();
         connection.commit();
         
         log.info("Deleted and committed " + recordsDeleted + " records from VIEW \"V_EXCEL_TRADE\".");

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
         log.error("Cannot perform DDL/DML on VIEW \"V_EXCEL_TRADE\".");
         throw new GDAOException(e);
      } catch (SQLException e) {
         e.printStackTrace();
         throw new GDAOException(e);
      } finally {
         try {
            vExcelTradeTab.releaseStatement();
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
   * vExcelTradeTo
   *
   * @param  connection      Database connection
   * @throws GDAOException
   *
   **********************************************************************/
   public void dataProvider1(Connection connection) throws GDAOException {
   
      String whatWeAreDoing = "\"dataProvider1()\" for VIEW \"V_EXCEL_TRADE\"";

      log.debug("Starting " + whatWeAreDoing);

      VExcelTradeTab vExcelTradeTab = new VExcelTradeTab(connection);

      try {

         vExcelTradeTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         vExcelTradeTab.setResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE);

         /**********************************************************************
          *
          * Selects specific records from the table:
          *
          **********************************************************************/
         //vExcelTradeTab.getResultSet("WHERE UPPER(ACCOUNT_ID) LIKE ?", "%R%");

         /**********************************************************************
          *
          * Retrieves all records from the table -
          * Both methods below are equal:
          *
          **********************************************************************/
         //vExcelTradeTab.getResultSet(null, (Object[])null);
         vExcelTradeTab.getAllRecordsRs();

         /**********************************************************************
         *
         * Loop through database result set:
         *
         **********************************************************************/
         while (vExcelTradeTab.next()) {

            VExcelTradeTo vExcelTradeTo = vExcelTradeTab.getTo();

             /**********************************************************************
             *
             * Now use "vExcelTradeTo" object.
             * Below are few examples of what you can do with it:
             *
             * You can us it in Front End or just show it for debugging purposes:
             * NOTE: each values in this Transfer Object has it's own "getter"
             * and "setter" already defined.
             *
             **********************************************************************/
            //vExcelTradeTo.print();
            //Or alternatively, using Working class static method:
            VExcelTradeTab.print(vExcelTradeTo, "; ");


            /**********************************************************************
            *
            * Change some values:
            * For example:
            * vExcelTradeTo.setSOME_VALUE(123);
            * vExcelTradeTo.setSOME_OTHER_VALUE("Some name");
            * etc...
            *
            **********************************************************************/


            /**********************************************************************
            *
            * Update row in VIEW \"V_EXCEL_TRADE\" with values from this
            * Transfer Object vExcelTradeTo.
            *
            * NOTE:
            * Variables that keep values of the Primary Key in Transfer Object
            * vExcelTradeTo will be used to find
            * record to be updated. Generally those values should not be changed.
            *
            **********************************************************************/
            //vExcelTradeTab.update(vExcelTradeTo);

            /**********************************************************************
            *
            * Insert row in VIEW \"V_EXCEL_TRADE\" using values set in
            * this Transfer Object vExcelTradeTo.
            *
            * NOTE:
            * Remember that values for Primary Key have to be unique.
            * Transfer Object vExcelTradeTo could be also
            * created from scratch (not retrieved from the database).
            *
            **********************************************************************/
            //vExcelTradeTab.insert(vExcelTradeTo);

            /**********************************************************************
            *
            * Delete row in VIEW \"V_EXCEL_TRADE\" with values from this
            * Transfer Object vExcelTradeTo.
            *
            * NOTE:
            * Variables that keep values of the Primary Key in Transfer Object
            * vExcelTradeTo will be used to find
            * record to be deleted. Generally those values should not be changed.
            *
            **********************************************************************/
            //vExcelTradeTab.delete(vExcelTradeTo);
         }
      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot fetch data from VIEW \"V_EXCEL_TRADE\".");
         throw new GDAOException(e);
      } finally {
         vExcelTradeTab.releaseStatement();
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
   
      String whatWeAreDoing = "\"dataProvider2()\" for VIEW \"V_EXCEL_TRADE\"";

      log.debug("Starting " + whatWeAreDoing);

      VExcelTradeTab vExcelTradeTab = new VExcelTradeTab(connection);
      //int sampleTransferObjectArraySize = 100;  // sample number, change according to your needs

      try {

         vExcelTradeTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         vExcelTradeTab.setResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE);

         /**********************************************************************
          *
          * Selects specific records from the table:
          *
          **********************************************************************/
         //vExcelTradeTab.getResultSet("WHERE UPPER(ACCOUNT_ID) LIKE ?", "%R%");

         /**********************************************************************
          *
          * Retrieves all records from the table -
          * Both methods below are equal:
          *
          **********************************************************************/
         //vExcelTradeTab.getResultSet(null, (Object[])null);
         vExcelTradeTab.getAllRecordsRs();

         /**********************************************************************
          *
          * This will fetch "sampleTransferObjectArraySize" number of rows into
          * array "vExcelTradeToArray".
          * If there is less than "sampleTransferObjectArraySize"  rows returned
          * then all available data will be stored into array
          * "vExcelTradeToArray".
          *
          * Alternatively you can use parameter "BaseOracleDbEntityClass.FETCH_ALL"
          * to fetch all records returned by result set.
          *
          **********************************************************************/
         //ArrayList<VExcelTradeTo> vExcelTradeToArray = vExcelTradeTab.getToArray(sampleTransferObjectArraySize);
         ArrayList<VExcelTradeTo> vExcelTradeToArray = vExcelTradeTab.getToArray(BaseOracleDbEntityClass.FETCH_ALL);

         Iterator<VExcelTradeTo> iterator = vExcelTradeToArray.iterator();
         while (iterator.hasNext()) {
            VExcelTradeTo vExcelTradeTo = iterator.next();

             /**********************************************************************
             *
             * Now use "vExcelTradeTo" object.
             * Below are few examples of what you can do with it:
             *
             * You can us it in Front End or just show it for debugging purposes:
             * NOTE: each values in this Transfer Object has it's own "getter"
             * and "setter" already defined.
             *
             **********************************************************************/
            //vExcelTradeTo.print();
            //Or alternatively, using Working class static method:
            VExcelTradeTab.print(vExcelTradeTo, "; ");


            /**********************************************************************
            *
            * Change some values - for example:
            * vExcelTradeTo.setSOME_VALUE(123);
            * vExcelTradeTo.setSOME_OTHER_VALUE("Some name");
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
            //vExcelTradeTab.update(vExcelTradeTo);
         }

      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot fetch data from VIEW \"V_EXCEL_TRADE\".");
         throw new GDAOException(e);
      }  finally {
         vExcelTradeTab.releaseStatement();
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

      String whatWeAreDoing = "\"copyDataBetweenDatabases()\" for VIEW \"V_EXCEL_TRADE\"";

      String SQL = null;

      OracleSystemTab oracleSystemTabSource = new OracleSystemTab(sourceConnection);
      OracleSystemTab oracleSystemTabTarget = new OracleSystemTab(targetConnection);

      int[] insertCounts = null;
      PreparedStatement preparedStatement = null;

      VExcelTradeTab vExcelTradeTabSource = null;
      VExcelTradeTab vExcelTradeTabTarget = null;

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
         //SQL = "ALTER VIEW V_EXCEL_TRADE DISABLE CONSTRAINT ....";
         //oracleSystemTab.runSQL(SQL);

         //SQL = "DROP INDEX ...";
         //oracleSystemTab.runSQL(SQL);

         SQL = "TRUNCATE VIEW V_EXCEL_TRADE";
         oracleSystemTabTarget.runSQL(SQL);

         log.info("Target VIEW \"V_EXCEL_TRADE\" is truncated.");

         vExcelTradeTabSource = new VExcelTradeTab(sourceConnection);
         vExcelTradeTabTarget = new VExcelTradeTab(targetConnection);

         /**********************************************************************
         *
         * Use the following parameters in order to speed up SELECT
         * and to prevent program from failing because of EXAUSTED MEMORY error:
         * java.lang.OutOfMemoryError: Java heap space
         *
         **********************************************************************/
         vExcelTradeTabSource.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         vExcelTradeTabSource.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

         /**********************************************************************
          *
          * Target ResultSet should be:
          * - ResultSet.TYPE_SCROLL_SENSITIVE,
          * - ResultSet.CONCUR_UPDATABLE
          *
          **********************************************************************/
         vExcelTradeTabTarget.setResultSetConcurrency(ResultSet.CONCUR_UPDATABLE);
         vExcelTradeTabTarget.setResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE);
 
         log.info("Use Oracle Cursors for selecting and Batch Inserts for inserting large number of records...");

         targetConnection.setAutoCommit(false);

         /**********************************************************************
          *
          * Get Source Data
          *
          **********************************************************************/
         vExcelTradeTabSource.getAllRecordsRs();

         /**********************************************************************
          *
          * Prepare Batch Insert Statement
          *
          **********************************************************************/
         preparedStatement = vExcelTradeTabTarget.getInsertPreparedStatement();

         long recordsInserted = 0;
         while (vExcelTradeTabSource.next()) {
            /**********************************************************************
             *
             * Retrieve values from table V_EXCEL_TRADE
             * using DAO object "vExcelTradeTabSource"
             *
             * This is also the place to put Data Transformation code if data is
             * being copied to tables with different structures or names.
             *
             **********************************************************************/
            VExcelTradeTo vExcelTradeTo = vExcelTradeTabSource.getTo();

            vExcelTradeTabTarget.addInsertBatch(preparedStatement, vExcelTradeTo);

            recordsInserted++;

            if (recordsInserted % TRANSACTION_TRESHOLD == 0) {
               /**********************************************************************
                *
                * Execute Batch Insert
                *
                **********************************************************************/
               insertCounts = preparedStatement.executeBatch();
               targetConnection.commit();
               log.info("Inserted and committed " + recordsInserted + " records into VIEW \"V_EXCEL_TRADE\".");
               log.debug("insertCounts.length=" + insertCounts.length);
            }
         }

         insertCounts = preparedStatement.executeBatch();
         targetConnection.commit();

         log.info("Inserted and committed " + recordsInserted + " records into VIEW \"V_EXCEL_TRADE\".");
         log.debug("insertCounts.length=" + insertCounts.length);

         targetConnection.setAutoCommit(true);

      } catch (GDAOException e) {
         log.error("Cannot perform DDL/DML on VIEW \"V_EXCEL_TRADE\".");
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
            vExcelTradeTabSource.releaseStatement();
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

      String whatWeAreDoing = "\"deleteByToArrayBatch()\" for VIEW \"V_EXCEL_TRADE\"";

      long rowsAffected = 0;

      int[] deleteCountsArray = null;
      PreparedStatement preparedStatement = null;

      VExcelTradeTab vExcelTradeTabSource = null;
      VExcelTradeTab vExcelTradeTabTarget = null;

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
         //SQL = "ALTER VIEW V_EXCEL_TRADE DISABLE CONSTRAINT ....";
         //oracleSystemTab.runSQL(SQL);

         //SQL = "DROP INDEX ...";
         //oracleSystemTab.runSQL(SQL);

         vExcelTradeTabSource = new VExcelTradeTab(sourceConnection);
         vExcelTradeTabTarget = new VExcelTradeTab(targetConnection);

         /**********************************************************************
         *
         * Use the following parameters in order to speed up SELECT
         * and to prevent program from failing because of EXAUSTED MEMORY error:
         * java.lang.OutOfMemoryError: Java heap space
         *
         **********************************************************************/
         vExcelTradeTabSource.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         vExcelTradeTabSource.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

         /**********************************************************************
          *
          * Target ResultSet should be:
          * - ResultSet.TYPE_SCROLL_SENSITIVE,
          * - ResultSet.CONCUR_UPDATABLE
          *
          **********************************************************************/
         vExcelTradeTabTarget.setResultSetConcurrency(ResultSet.CONCUR_UPDATABLE);
         vExcelTradeTabTarget.setResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE);

         log.info("Number of records before Batch Delete: " + vExcelTradeTabTarget.getRowCount());

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
         vExcelTradeTabSource.getAllRecordsRs();
         ArrayList<VExcelTradeTo> vExcelTradeToArrayList = vExcelTradeTabSource.getToArrayEntireResultSet();

         /**********************************************************************
          *
          * Prepare Batch Delete Statement
          *
          **********************************************************************/
         preparedStatement = vExcelTradeTabTarget.getDeleteByPkPreparedStatement();

         Iterator<VExcelTradeTo> iterator = vExcelTradeToArrayList.iterator();

         long executedDeleteStatement = 0;

         while (iterator.hasNext()) {
            /**********************************************************************
             *
             * Retrieve values from table V_EXCEL_TRADE
             * using DAO object "vExcelTradeTo"
             *
             **********************************************************************/

            VExcelTradeTo vExcelTradeTo = iterator.next();
            vExcelTradeTabTarget.deleteByToAddToBach(preparedStatement, vExcelTradeTo);

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
                  log.info("Deleted " + executedDeleteStatement + " records from VIEW \"V_EXCEL_TRADE\".");
               } else {
                  /**********************************************************************
                   *
                   * Results from JDBC are unreliable so we only know that statements are
                   * executed but we don't know if rows are deleted.
                   *
                   **********************************************************************/
                  log.info("Executed " + executedDeleteStatement + " delete statements for VIEW \"V_EXCEL_TRADE\".");
               }
            }
         }

         deleteCountsArray = preparedStatement.executeBatch();
         targetConnection.commit();

         rowsAffected = checkBatchUpdateResults(deleteCountsArray);

         if (rowsAffected >= 0) {
            log.info("Deleted " + executedDeleteStatement + " records from VIEW \"V_EXCEL_TRADE\".");
         } else {
            /**********************************************************************
             *
             * Results from JDBC are unreliable so we only know that statements are
             * executed but we don't know if rows are deleted.
             *
             **********************************************************************/
            log.info("Executed " + executedDeleteStatement + " delete statements for VIEW \"V_EXCEL_TRADE\".");
         }

         targetConnection.setAutoCommit(true);

         log.info("Number of records after Batch Delete: " + vExcelTradeTabTarget.getRowCount());

      } catch (GDAOException e) {
         log.error("Cannot perform DDL/DML on VIEW \"V_EXCEL_TRADE\".");
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
            vExcelTradeTabSource.releaseStatement();
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

      String whatWeAreDoing = "\"deleteByToArray()\" for VIEW \"V_EXCEL_TRADE\"";

      long executedDeleteStatement = 0;
      long totalRecordsDeleted = 0;
      OracleSystemTab oracleSystemTabTarget = new OracleSystemTab(targetConnection);

      VExcelTradeTab vExcelTradeTabSource = null;
      VExcelTradeTab vExcelTradeTabTarget = null;

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
         //SQL = "ALTER VIEW V_EXCEL_TRADE DISABLE CONSTRAINT ....";
         //oracleSystemTab.runSQL(SQL);

         //SQL = "DROP INDEX ...";
         //oracleSystemTab.runSQL(SQL);

         vExcelTradeTabSource = new VExcelTradeTab(sourceConnection);
         vExcelTradeTabTarget = new VExcelTradeTab(targetConnection);

         /**********************************************************************
         *
         * Use the following parameters in order to speed up SELECT
         * and to prevent program from failing because of EXAUSTED MEMORY error:
         * java.lang.OutOfMemoryError: Java heap space
         *
         **********************************************************************/
         vExcelTradeTabSource.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         vExcelTradeTabSource.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

         /**********************************************************************
          *
          * Target ResultSet should be:
          * - ResultSet.TYPE_SCROLL_SENSITIVE,
          * - ResultSet.CONCUR_UPDATABLE
          *
          **********************************************************************/
         vExcelTradeTabTarget.setResultSetConcurrency(ResultSet.CONCUR_UPDATABLE);
         vExcelTradeTabTarget.setResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE);

         log.info("Number of records before Delete: " + vExcelTradeTabTarget.getRowCount());

         targetConnection.setAutoCommit(false);

         /**********************************************************************
          *
          * Get Source Data into array of Transfer Objects
          * NOTE:
          * This is just a sample how to create array of transfer objects.
          * In WEB application this could be result of the user input or similar.
          *
          **********************************************************************/
         vExcelTradeTabSource.getAllRecordsRs();
         //vExcelTradeTabSource.getResultSet("WHERE OPERATION_TYPE = ?", "M");

         ArrayList<VExcelTradeTo> vExcelTradeToArrayList = vExcelTradeTabSource.getToArrayEntireResultSet();

         Iterator<VExcelTradeTo> iterator = vExcelTradeToArrayList.iterator();

         /**********************************************************************
          *
          * Loop through array of Transfer objects and delete matching records
          * using DAO Object "vExcelTradeTabTarget"
          *
          **********************************************************************/
         while (iterator.hasNext()) {

            VExcelTradeTo vExcelTradeTo = iterator.next();

            /**********************************************************************
             *
             * Only one record should be delete for tables with Primary key
             * Primary Key is automatically recognized by GDAO.
             * If table does not have PK, deletes using this method is unreliable
             * and it should not be used.
             *
             **********************************************************************/
            int recordsDeleted = vExcelTradeTabTarget.deleteRecordUsingTo(vExcelTradeTo);
            
            //alternative method - to be tested:
            //vExcelTradeTabTarget.delete(vExcelTradeTo);

            totalRecordsDeleted += recordsDeleted;
            executedDeleteStatement++;

            /**********************************************************************
             *
             * Commit transaction after certain number of records are deleted.
             *
             **********************************************************************/
            if (totalRecordsDeleted % TRANSACTION_TRESHOLD == 0) {
               targetConnection.commit();
               log.info("Deleted " + totalRecordsDeleted + " records from VIEW \"V_EXCEL_TRADE\".");
               log.info("Executed " + executedDeleteStatement + " delete statements for VIEW \"V_EXCEL_TRADE\".");
            }
         }

         targetConnection.commit();

         log.info("Deleted " + totalRecordsDeleted + " records from VIEW \"V_EXCEL_TRADE\".");
         log.info("Executed " + executedDeleteStatement + " DELETE statements for VIEW \"V_EXCEL_TRADE\".");
         targetConnection.setAutoCommit(true);

         log.info("Number of records after Delete: " + vExcelTradeTabTarget.getRowCount());

      } catch (GDAOException e) {
         log.error("Cannot perform DDL/DML on VIEW \"V_EXCEL_TRADE\".");
         throw new GDAOException(e);
      } catch (SQLException e) {
         throw new GDAOException(e);
      } finally {
         vExcelTradeTabSource.releaseStatement();
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

      String whatWeAreDoing = "\"updateByToArray()\" for VIEW \"V_EXCEL_TRADE\"";

      long executedUpdateStatement = 0;
      long totalRecordsUpdated = 0;

      VExcelTradeTab vExcelTradeTabSource = null;
      VExcelTradeTab vExcelTradeTabTarget = null;

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
         //SQL = "ALTER VIEW V_EXCEL_TRADE DISABLE CONSTRAINT ....";
         //oracleSystemTab.runSQL(SQL);

         //SQL = "DROP INDEX ...";
         //oracleSystemTab.runSQL(SQL);

         vExcelTradeTabSource = new VExcelTradeTab(sourceConnection);
         vExcelTradeTabTarget = new VExcelTradeTab(targetConnection);

         /**********************************************************************
         *
         * Use the following parameters in order to speed up SELECT
         * and to prevent program from failing because of EXAUSTED MEMORY error:
         * java.lang.OutOfMemoryError: Java heap space
         *
         **********************************************************************/
         vExcelTradeTabSource.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         vExcelTradeTabSource.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

         /**********************************************************************
          *
          * Target ResultSet should be:
          * - ResultSet.TYPE_SCROLL_SENSITIVE,
          * - ResultSet.CONCUR_UPDATABLE
          *
          **********************************************************************/
         vExcelTradeTabTarget.setResultSetConcurrency(ResultSet.CONCUR_UPDATABLE);
         vExcelTradeTabTarget.setResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE);

         log.info("Number of records before Update: " + vExcelTradeTabTarget.getRowCount());

         targetConnection.setAutoCommit(false);

         /**********************************************************************
          *
          * Get Source Data into array of Transfer Objects
          * NOTE:
          * This is just a sample how to create array of transfer objects.
          * In WEB application this could be result of the user input or similar.
          *
          **********************************************************************/
         //vExcelTradeTabSource.getAllRecordsRs();
         vExcelTradeTabSource.getResultSet("WHERE OPERATION_TYPE = ?", "M");

         ArrayList<VExcelTradeTo> vExcelTradeToArrayList = vExcelTradeTabSource.getToArrayEntireResultSet();

         Iterator<VExcelTradeTo> iterator = vExcelTradeToArrayList.iterator();

         /**********************************************************************
          *
          * Loop through array of Transfer objects and update matching records
          * using DAO Object "vExcelTradeTabTarget"
          *
          **********************************************************************/
         while (iterator.hasNext()) {

            VExcelTradeTo vExcelTradeTo = iterator.next();

            /**********************************************************************
             *
             *  Change values in Transfer Object
             *  These values will be updated in the database.
             *
             **********************************************************************/
            //vExcelTradeTo.setOPERATION_TYPE("Z");

            /**********************************************************************
             *
             * Only one record should be updated for tables with Primary key
             * Primary Key is automatically recognized by GDAO.
             * If table does not have PK, updates using this method is unreliable
             * and it should not be used.
             *
             **********************************************************************/
            int recordsUpdated = vExcelTradeTabTarget.updateRecordUsingTo(vExcelTradeTo);

            totalRecordsUpdated += recordsUpdated;
            executedUpdateStatement++;

            /**********************************************************************
             *
             * Commit transaction after certain number of records are updated.
             *
             **********************************************************************/
            if (totalRecordsUpdated % TRANSACTION_TRESHOLD == 0) {
               targetConnection.commit();
               log.info("Updated " + totalRecordsUpdated + " records in VIEW \"V_EXCEL_TRADE\".");
               log.info("Executed " + executedUpdateStatement + " UPDATE statements for VIEW \"V_EXCEL_TRADE\".");
            }
         }

         targetConnection.commit();

         log.info("Updated " + totalRecordsUpdated + " records in VIEW \"V_EXCEL_TRADE\".");
         log.info("Executed " + executedUpdateStatement + " UPDATE statements for VIEW \"V_EXCEL_TRADE\".");
         targetConnection.setAutoCommit(true);

         log.info("Number of records after Update: " + vExcelTradeTabTarget.getRowCount());

      } catch (GDAOException e) {
         log.error("Cannot perform DDL/DML on VIEW \"V_EXCEL_TRADE\".");
         throw new GDAOException(e);
      } catch (SQLException e) {
         throw new GDAOException(e);
      } finally {
         vExcelTradeTabSource.releaseStatement();
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

      String whatWeAreDoing = "\"updateByToArrayBatch()\" for VIEW \"V_EXCEL_TRADE\"";

      long rowsAffected = 0;

      int[] updateCountsArray = null;
      PreparedStatement preparedStatementForUpdate = null;

      VExcelTradeTab vExcelTradeTabSource = null;
      VExcelTradeTab vExcelTradeTabTarget = null;

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
         //SQL = "ALTER VIEW V_EXCEL_TRADE DISABLE CONSTRAINT ....";
         //oracleSystemTab.runSQL(SQL);

         //SQL = "DROP INDEX ...";
         //oracleSystemTab.runSQL(SQL);

         vExcelTradeTabSource = new VExcelTradeTab(sourceConnection);
         vExcelTradeTabTarget = new VExcelTradeTab(targetConnection);

         /**********************************************************************
         *
         * Use the following parameters in order to speed up SELECT
         * and to prevent program from failing because of EXAUSTED MEMORY error:
         * java.lang.OutOfMemoryError: Java heap space
         *
         **********************************************************************/
         vExcelTradeTabSource.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         vExcelTradeTabSource.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

         /**********************************************************************
          *
          * Target ResultSet should be:
          * - ResultSet.TYPE_SCROLL_SENSITIVE,
          * - ResultSet.CONCUR_UPDATABLE
          *
          **********************************************************************/
         vExcelTradeTabTarget.setResultSetConcurrency(ResultSet.CONCUR_UPDATABLE);
         vExcelTradeTabTarget.setResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE);

         log.info("Number of records before Batch Update: " + vExcelTradeTabTarget.getRowCount());

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
         //vExcelTradeTabSource.getAllRecordsRs();
         vExcelTradeTabSource.getResultSet("WHERE OPERATION_TYPE = ?", "M");


         ArrayList<VExcelTradeTo> vExcelTradeToArrayList = vExcelTradeTabSource.getToArrayEntireResultSet();

         /**********************************************************************
          *
          * Prepare Batch Update Statement
          *
          **********************************************************************/
         preparedStatementForUpdate = vExcelTradeTabTarget.getUpdateByPkPreparedStatement();

         Iterator<VExcelTradeTo> iterator = vExcelTradeToArrayList.iterator();

         long executedUpdateStatement = 0;

         while (iterator.hasNext()) {
            /**********************************************************************
             *
             * Retrieve values from table V_EXCEL_TRADE
             * using DAO object "vExcelTradeTo"
             *
             **********************************************************************/

            VExcelTradeTo vExcelTradeTo = iterator.next();


            /**********************************************************************
             *
             *  Change values in Transfer Object
             *  These values will be updated in the database.
             *
             **********************************************************************/
            //vExcelTradeTo.setOPERATION_TYPE("Z");

            vExcelTradeTabTarget.updateByToAddToBach(preparedStatementForUpdate, vExcelTradeTo);

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
                  log.info("Updated " + executedUpdateStatement + " records in VIEW \"V_EXCEL_TRADE\".");
               } else {
                  /**********************************************************************
                   *
                   * Results from JDBC are unreliable so we only know that statements are
                   * executed but we don't know if rows are updated.
                   *
                   **********************************************************************/
                  log.info("Executed " + executedUpdateStatement + " update statements for VIEW \"V_EXCEL_TRADE\".");
               }
            }
         }

         updateCountsArray = preparedStatementForUpdate.executeBatch();
         targetConnection.commit();

         rowsAffected = checkBatchUpdateResults(updateCountsArray);

         if (rowsAffected >= 0) {
            log.info("Updated " + executedUpdateStatement + " records in VIEW \"V_EXCEL_TRADE\".");
         } else {
            /**********************************************************************
             *
             * Results from JDBC are unreliable so we only know that statements are
             * executed but we don't know if rows are updated.
             *
             **********************************************************************/
            log.info("Executed " + executedUpdateStatement + " UPDATE statements for VIEW \"V_EXCEL_TRADE\".");
         }

         targetConnection.setAutoCommit(true);

         log.info("Number of records after Batch Update: " + vExcelTradeTabTarget.getRowCount());

      } catch (GDAOException e) {
         log.error("Cannot perform DDL/DML on VIEW \"V_EXCEL_TRADE\".");
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
            vExcelTradeTabSource.releaseStatement();
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
     //vExcelTradeTabSource.setDbEntityName("GDAODEMO.V_EXCEL_TRADE");


***************************************************************************/
  
}
