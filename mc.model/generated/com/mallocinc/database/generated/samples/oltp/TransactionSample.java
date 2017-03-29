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

import com.mallocinc.database.generated.working.TransactionTab;
import com.mallocinc.database.generated.to.TransactionTo;

/**********************************************************************
 *  <pre>
 *
 *  Generated Class: TransactionSample.java
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
 *  This code is generated on: 2017-February-27 06:45:57 PM CET
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
 *  Sample GDAO code for TABLE "TRANSACTION"
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
public class TransactionSample {

   final static Logger log = Logger.getLogger(TransactionSample.class.getName());
   
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
        TransactionSample transactionSample = new TransactionSample();

        /**********************************************************************
         *
         * Uncomment test that you want to execute:
         *
         **********************************************************************/
         //transactionSample.select(connection);
         //transactionSample.insert(connection);
         //transactionSample.update(connection);

         //transactionSample.dataProvider1(connection);
         //transactionSample.dataProvider2(connection);

         //transactionSample.deleteViaResultSet(connection);
         //transactionSample.deleteViaSQL(connection);
         
         //transactionSample.batchInsert(connection);
         
         //transactionSample.selectIntoTransferObject(connection);
         
         //transactionSample.copyDataBetweenDatabases(connection_source, connection_target);
         //transactionSample.updateByToArray(connection_source, connection_target);
         
         //transactionSample.deleteByToArrayBatch(connection_source, connection_target);
         //transactionSample.deleteByToArray(connection_source, connection_target);
         
         //transactionSample.updateByTo(connection);
         //transactionSample.deleteByTo(connection);
         
         
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

      log.debug("Starting select from TABLE \"TRANSACTION\".");

            java.math.BigDecimal transactionId = null;
      java.math.BigDecimal blockId = null;
      java.lang.String transactionHash = null;
      java.math.BigDecimal version = null;
      java.math.BigDecimal locktime = null;
      java.sql.Timestamp createTimestamp = null;
      java.lang.String type = null;


      TransactionTab transactionTab = new TransactionTab(connection);

      try {

         /**********************************************************************
          *
          * !IMPORTANT!:
          * Use the following parameters in order to speed up SELECT
          * and to prevent program from failing because of EXAUSTED MEMORY error:
          * java.lang.OutOfMemoryError: Java heap space
          *
          **********************************************************************/
         transactionTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         transactionTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

         /**********************************************************************
          *
          * Selects specific records from the table:
          * Limit number of rows selected to "100" (just an example)
          * Change "WHERE" condition to meet your needs.
          *
          **********************************************************************/
         transactionTab.getResultSet("WHERE UPPER(TRANSACTION_HASH) LIKE ? AND ROWNUM < ?", "%R%", 100);

         /**********************************************************************
          *
          * Selects all records from the table - no "WHERE" condition.
          * Both methods below are equal:
          *
          **********************************************************************/
         //transactionTab.getResultSet(null, (Object[])null);
         //transactionTab.getAllRecordsRs();

         /**********************************************************************
          *
          * Loop through database result set:
          *
          **********************************************************************/
         while (transactionTab.next()) {

            /**********************************************************************
            *
            * Print all values from the row in one line delimited by "; "
            *
            **********************************************************************/
            transactionTab.print("; ");

            /**********************************************************************
            *
            * Fetch data from the database into local variables:
            *
            **********************************************************************/
                  transactionId = transactionTab.getTRANSACTION_ID();
      blockId = transactionTab.getBLOCK_ID();
      transactionHash = transactionTab.getTRANSACTION_HASH();
      version = transactionTab.getVERSION();
      locktime = transactionTab.getLOCKTIME();
      createTimestamp = transactionTab.getCREATE_TIMESTAMP();
      type = transactionTab.getTYPE();


            /**********************************************************************
            *
            * Print all values from the row - one line per column:
            *
            **********************************************************************/
               log.debug(String.format("%-30s [%s]", "transactionId", transactionId));
      log.debug(String.format("%-30s [%s]", "blockId", blockId));
      log.debug(String.format("%-30s [%s]", "transactionHash", transactionHash));
      log.debug(String.format("%-30s [%s]", "version", version));
      log.debug(String.format("%-30s [%s]", "locktime", locktime));
      log.debug(String.format("%-30s [%s]", "createTimestamp", createTimestamp));
      log.debug(String.format("%-30s [%s]", "type", type));
   

            log.debug("---------------^^^^^^^^^-----------------");
         }

      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot select from TABLE \"TRANSACTION\".");
         throw new GDAOException(e);
      } finally {
         transactionTab.releaseStatement();
      }

      log.debug("Finished select from TABLE \"TRANSACTION\".");
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

      String whatWeAreDoing = "\"selectIntoTransferObject()\" for TABLE \"TRANSACTION\"";

      log.debug("Starting " + whatWeAreDoing);

      /**********************************************************************
       *
       * Create DAO object for selecting data from the database
       *
       **********************************************************************/
      TransactionTab transactionTabForSelect = new TransactionTab(connection);

      try {

         /**********************************************************************
          *
          * Use the following parameters in order to speed up SELECT
          * and to prevent program from failing because of exhausted memory
          *
          **********************************************************************/
         transactionTabForSelect.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         transactionTabForSelect.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

         /**********************************************************************
          *
          * Selects specific records from the table:
          * Limit number of rows selected to "100" (just an example)
          *
          **********************************************************************/
         transactionTabForSelect.getResultSet("WHERE UPPER(CREDIT_DEBIT_CODE) LIKE ? AND ROWNUM < ?", "%C%", 100);

         /**********************************************************************
          *
          * Selects all records from the table - no "WHERE" condition.
          * Both methods below are equal:
          *
          **********************************************************************/
         //transactionTab.getResultSet(null, (Object[])null);
         //transactionTab.getAllRecordsRs();

         /**********************************************************************
          *
          * Loop through database result set:
          *
          **********************************************************************/
         while (transactionTabForSelect.next()) {
         
            /**********************************************************************
            *
            * Print all values from the row in one line delimited by "; "
            *
            **********************************************************************/
            //transactionTab.print("; ");

            /**********************************************************************
            *
            * Fetch data from the database into local variables:
            *
            **********************************************************************/
            TransactionTo transactionTo  = transactionTabForSelect.getTo();

            /**********************************************************************
             *
             * Print Transfer object content
             *
             **********************************************************************/
            //transactionTo.print();

            /**********************************************************************
             *
             * Make desired changes to data
             * Sample is provided below.
             *
             **********************************************************************/
             /*
            transactionTo.setRECURRING_TRANS_HIST_ID(transactionTabForSelect.getNextval());
            transactionTo.setCOMMENTS("This is Zoran's test record");
            transactionTo.setREJECT_REASON(null);
            transactionTo.setCREATE_DATETIME(TimestampUtility.getCurrentTimestamp());
            */

            /**********************************************************************
             *
             * Create another DAO object for inserting data into database.
             *
             **********************************************************************/
            TransactionTab transactionTabForInsert = new TransactionTab(connection);

            transactionTabForInsert.setThisFromTo(transactionTo);

            transactionTabForInsert.insertThisRecord();

            log.debug("---------------^^^^^^^^^-----------------");
         }

      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot select into TO's from TABLE \"TRANSACTION\".");
         throw new GDAOException(e);
      } finally {
         transactionTabForSelect.releaseStatement();
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

      log.debug("Starting insert into TABLE \"TRANSACTION\"...");

            java.math.BigDecimal transactionId = null;
      java.math.BigDecimal blockId = null;
      java.lang.String transactionHash = null;
      java.math.BigDecimal version = null;
      java.math.BigDecimal locktime = null;
      java.sql.Timestamp createTimestamp = null;
      java.lang.String type = null;


      

      TransactionTab transactionTab = new TransactionTab(connection);

      try {

        /**********************************************************************
         *
         * For PK values use sequence, something like:
         * BigDecimal TransactionTab_id = TransactionTab.getNextval(sequenceName);
         * or if sequence has a standard name like "S_TRANSACTION":
         * BigDecimal TransactionTab_id = TransactionTab.getNextval();
         *
         **********************************************************************/
               transactionId = new BigDecimal(0);
      blockId = new BigDecimal(0);
      transactionHash = "new transactionHash";
      version = new BigDecimal(0);
      locktime = new BigDecimal(0);
      createTimestamp = TimestampUtility.getCurrentTimestamp();
      type = "new type";


               transactionTab.setTRANSACTION_ID(transactionId);  // java.math.BigDecimal - Mandatory
      transactionTab.setBLOCK_ID(blockId);  // java.math.BigDecimal - Mandatory
      transactionTab.setTRANSACTION_HASH(transactionHash);  // java.lang.String - Mandatory
      transactionTab.setVERSION(version);  // java.math.BigDecimal
      transactionTab.setLOCKTIME(locktime);  // java.math.BigDecimal
      transactionTab.setCREATE_TIMESTAMP(createTimestamp);  // java.sql.Timestamp - Mandatory
      transactionTab.setTYPE(type);  // java.lang.String


         transactionTab.insertThisRecord();

      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot insert into TABLE \"TRANSACTION\".");
         throw new GDAOException(e);
      }
      

      log.debug("Finished insert into TABLE \"TRANSACTION\".");
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

      log.debug("Starting update of TABLE \"TRANSACTION\".");

            java.math.BigDecimal transactionId = null;
      java.math.BigDecimal blockId = null;
      java.lang.String transactionHash = null;
      java.math.BigDecimal version = null;
      java.math.BigDecimal locktime = null;
      java.sql.Timestamp createTimestamp = null;
      java.lang.String type = null;

      
      

      TransactionTab transactionTab = new TransactionTab(connection);

      try {
         connection.setAutoCommit(false);  // manage transactions manually

         /*************************************************************************
          *
          * Note:
          * Use transactionTab.setResultSetHoldability(ResultSet.HOLD_CURSORS_OVER_COMMIT);
          *
          * OR
          *
          * "COMMIT" should not be used while looping through the cursor because
          * it will cause Oracle Error:
          * ORA-01002: fetch out of sequence
          *
          **************************************************************************/
         //transactionTab.setResultSetHoldability(ResultSet.HOLD_CURSORS_OVER_COMMIT);


         /**********************************************************************
          *
          * Updates specific records in the table:
          * NOTE:
          * "WHERE ROWNUM <" or "GROUP BY" cannot be used when updating result set
          *
          **********************************************************************/
         transactionTab.getResultSetForUpdate("WHERE TRANSACTION_HASH LIKE ?", "%R%");

         /**********************************************************************
          *
          * Updates all records in the table:
          *
          **********************************************************************/
         //transactionTab.getResultSetForUpdate(null, (Object[])null);

         /**********************************************************************
          *
          * Display number of records that will be affected:
          *
          **********************************************************************/
         log.info("ResultSet Row Count (number of records to be affected) = " + transactionTab.getResultSetRowCount());

         /*************************************************************************
          *
          * Note:
          * "COMMIT" should not be used while looping through the cursor because
          * it will cause Oracle Error:
          * ORA-01002: fetch out of sequence
          *
          **************************************************************************/
         while (transactionTab.next()) {
                  transactionId = transactionTab.getTRANSACTION_ID();
      blockId = transactionTab.getBLOCK_ID();
      transactionHash = transactionTab.getTRANSACTION_HASH();
      version = transactionTab.getVERSION();
      locktime = transactionTab.getLOCKTIME();
      createTimestamp = transactionTab.getCREATE_TIMESTAMP();
      type = transactionTab.getTYPE();


            log.debug("Updating following values:");
            log.debug("--------------------------");
               log.debug(String.format("%-30s [%s]", "transactionId", transactionId));
      log.debug(String.format("%-30s [%s]", "blockId", blockId));
      log.debug(String.format("%-30s [%s]", "transactionHash", transactionHash));
      log.debug(String.format("%-30s [%s]", "version", version));
      log.debug(String.format("%-30s [%s]", "locktime", locktime));
      log.debug(String.format("%-30s [%s]", "createTimestamp", createTimestamp));
      log.debug(String.format("%-30s [%s]", "type", type));
   
            log.debug(" ");

                  transactionId = new BigDecimal(0);
      blockId = new BigDecimal(0);
      transactionHash = "new transactionHash";
      version = new BigDecimal(0);
      locktime = new BigDecimal(0);
      createTimestamp = TimestampUtility.getCurrentTimestamp();
      type = "new type";


            log.debug("Updating to following values:");
            log.debug("-----------------------------");
               log.debug(String.format("%-30s [%s]", "transactionId", transactionId));
      log.debug(String.format("%-30s [%s]", "blockId", blockId));
      log.debug(String.format("%-30s [%s]", "transactionHash", transactionHash));
      log.debug(String.format("%-30s [%s]", "version", version));
      log.debug(String.format("%-30s [%s]", "locktime", locktime));
      log.debug(String.format("%-30s [%s]", "createTimestamp", createTimestamp));
      log.debug(String.format("%-30s [%s]", "type", type));
   
            log.debug("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

           /**********************************************************************
           *
           * Set new values for the record which is going to be updated. 
           *
           ***********************************************************************/
                  transactionTab.setTRANSACTION_ID(transactionId);  // java.math.BigDecimal - Mandatory
      transactionTab.setBLOCK_ID(blockId);  // java.math.BigDecimal - Mandatory
      transactionTab.setTRANSACTION_HASH(transactionHash);  // java.lang.String - Mandatory
      transactionTab.setVERSION(version);  // java.math.BigDecimal
      transactionTab.setLOCKTIME(locktime);  // java.math.BigDecimal
      transactionTab.setCREATE_TIMESTAMP(createTimestamp);  // java.sql.Timestamp - Mandatory
      transactionTab.setTYPE(type);  // java.lang.String


           /**********************************************************************
           *
           * Update database record with new values set in the "set" statements 
           * above. 
           *
           ***********************************************************************/
            transactionTab.updateThisRecordInResultSet();

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
         log.error("Cannot update TABLE \"TRANSACTION\".");

         try {
            connection.rollback();  // rollback all updates
         } catch (SQLException e1) {
            log.error("Cannot rollback transaction for updating records from TABLE \"TRANSACTION\".");
            e1.printStackTrace();
            throw new GDAOException(e1);
         }
         throw new GDAOException(e);
      }  catch (SQLException e) {
         e.printStackTrace();
         throw new GDAOException(e);
      }
      
      finally {
         transactionTab.releaseStatement();
      }

      log.debug("Finished update of TABLE \"TRANSACTION\".");
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

      log.debug("Starting delete of TABLE \"TRANSACTION\".");

      TransactionTab transactionTab = new TransactionTab(connection);

      try {
         connection.setAutoCommit(false);  // manage transactions manually

         /**********************************************************************
          *
          * Delete records that match WHERE clause in the table:
          * NOTE:
          * "WHERE ROWNUM <" or "GROUP BY" cannot be used when updating result set
          *
          **********************************************************************/
         String SQL = "WHERE TRANSACTION_HASH LIKE ?";          
         recordsDeleted = transactionTab.deleteRecords(SQL, "%R%");

         /**********************************************************************
          *
          * Display number of records that will be affected:
          *
          **********************************************************************/
         log.info(recordsDeleted + " records are deleted from TABLE \"TRANSACTION\"");

         /**********************************************************************
          *
          * Commit transaction.
          *
          **********************************************************************/
          connection.commit();
          log.debug("Records deleted=" + recordsDeleted + " - transaction is committed.");

      }  catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot delete  records from TABLE \"TRANSACTION\".");

         try {
            connection.rollback();  // rollback all deletes
         } catch (SQLException e1) {
            log.error("Cannot rollback transaction for deleting records from TABLE \"TRANSACTION\".");
            e1.printStackTrace();
            throw new GDAOException(e1);
         }
         throw new GDAOException(e);
      }  catch (SQLException e) {
         e.printStackTrace();
         throw new GDAOException(e);
      }

      log.debug("Finished delete of TABLE \"TRANSACTION\".");
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

      log.debug("Starting UPDATE by TO of TABLE \"TRANSACTION\".");

      TransactionTab transactionTab = new TransactionTab(connection);

      try {
         connection.setAutoCommit(false); // manage transactions manually

         /**********************************************************************
         *
         * Selects all records from the table - various methods are provided.
         * Uncomment and change one that works for you. 
         *
         **********************************************************************/
         //transactionTab.getResultSet("WHERE UPPER(USERNAME) LIKE ? ", "%Z%");
         //transactionTab.getResultSet(null, (Object[])null);
         //transactionTab.getAllRecordsRs();

         /**********************************************************************
          *
          * Loop through database result set:
          *
          **********************************************************************/
         while (transactionTab.next()) {

            /**********************************************************************
            *
            * Print all values from the row in one line delimited by "; "
            *
            **********************************************************************/
            //transactionTab.print("; ");

            /**********************************************************************
            *
            * Fetch data from the database into Transfer Object:
            *
            **********************************************************************/
            TransactionTo transactionTo = transactionTab.getTo();
            
            
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
            //transactionTo.setCITY("Belgrado"); 
            
            int recordsAffected = transactionTab.updateRecordUsingTo(transactionTo);

            
            /**********************************************************************
            *
            * Special code has to be developed to display PK values since there 
            * could be multiple fields and names may be different than table name:
            *
            **********************************************************************/
             log.info("Updated " + recordsAffected + " record with PK: "   + "TRANSACTION_ID=" + transactionTo.getTRANSACTION_ID() 
);

            //Alternative method:
            //recordsDeleted = transactionTab.updateRecordsUsingPKs(SQL, transactionTo.getTRANSACTION_ID());

         }

         connection.commit();

      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot update records from TABLE \"TRANSACTION\".");

         try {
            connection.rollback(); // rollback all updates
         } catch (SQLException e1) {
            log.error("Cannot rollback transaction for deleting records from TABLE \"TRANSACTION\".");
            e1.printStackTrace();
            throw new GDAOException(e1);
         }
         throw new GDAOException(e);
      } catch (SQLException e) {
         e.printStackTrace();
         throw new GDAOException(e);
      }

      log.debug("Finished update of TABLE \"TRANSACTION\".");
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

      log.debug("Starting delete of TABLE \"TRANSACTION\".");

      TransactionTab transactionTab = new TransactionTab(connection);

      try {
         connection.setAutoCommit(false); // manage transactions manually

         /**********************************************************************
         *
         * Selects all records from the table - no "WHERE" condition.
         * Both methods below are equal:
         *
         **********************************************************************/
         //transactionTab.getResultSet(null, (Object[])null);
         transactionTab.getAllRecordsRs();

         /**********************************************************************
          *
          * Loop through database result set:
          *
          **********************************************************************/
         while (transactionTab.next()) {

            /**********************************************************************
            *
            * Print all values from the row in one line delimited by "; "
            *
            **********************************************************************/
            //transactionTab.print("; ");

            /**********************************************************************
            *
            * Fetch data from the database into Transfer Object:
            *
            **********************************************************************/
            TransactionTo transactionTo = transactionTab.getTo();

            int recordsAffected = transactionTab.deleteRecordUsingTo(transactionTo);
         
            log.info("Deleted " + recordsAffected + " record with PK values: "   + "TRANSACTION_ID=" + transactionTo.getTRANSACTION_ID() 
);

            //Alternative method:
            //recordsDeleted = transactionTab.deleteRecordsUsingPKs(SQL, transactionTo.getTRANSACTION_ID());

         }

         connection.commit();

      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot delete records from TABLE \"TRANSACTION\".");

         try {
            connection.rollback(); // rollback all updates
         } catch (SQLException e1) {
            log.error("Cannot rollback transaction for deleting records from TABLE \"TRANSACTION\".");
            e1.printStackTrace();
            throw new GDAOException(e1);
         }
         throw new GDAOException(e);
      } catch (SQLException e) {
         e.printStackTrace();
         throw new GDAOException(e);
      }

      log.debug("Finished delete of TABLE \"TRANSACTION\".");
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
   
      String whatWeAreDoing = "\"deleteViaSQLS()\" for TABLE \"TRANSACTION\"";

      long recordsDeleted = -1;
      long deleteThisManyRecords = 1000;  //sample number, find optimum number for your database (usually by experimenting)

      log.debug("Starting " + whatWeAreDoing);

      TransactionTab transactionTab = new TransactionTab(connection);

      try {
         connection.setAutoCommit(false);  // manage transactions manually

         /**********************************************************************
          *
          * Updates specific records in the table:
          * NOTE:
          * "WHERE ROWNUM <" or "GROUP BY" cannot be used when updating result set
          *
          **********************************************************************/
         String SQL = "WHERE TRANSACTION_HASH LIKE ?";  
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
            recordsDeleted = transactionTab.deleteRecords(SQL, "%R%", deleteThisManyRecords);

            /**********************************************************************
             *
             * Display number of records that will be affected:
             *
             **********************************************************************/
            log.info(recordsDeleted + " records are deleted from TABLE \"TRANSACTION\"");

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

      String whatWeAreDoing = "\"deleteViaResultSet()\" for TABLE \"TRANSACTION\"";

      long recordsProcessed = 0;

      log.debug("Starting " + whatWeAreDoing);

      TransactionTab transactionTab = new TransactionTab(connection);

      try {
         connection.setAutoCommit(false);  // manage transactions manually

         /*************************************************************************
          *
          * Note:
          * Use transactionTab.setResultSetHoldability(ResultSet.HOLD_CURSORS_OVER_COMMIT);
          *
          * OR
          *
          * "COMMIT" should not be used while looping through the cursor because
          * it will cause Oracle Error:
          * ORA-01002: fetch out of sequence
          *
          **************************************************************************/
         transactionTab.setResultSetHoldability(ResultSet.HOLD_CURSORS_OVER_COMMIT);

         /**********************************************************************
          *
          * Updates specific records in the table:
          * NOTE:
          * "WHERE ROWNUM <" or "GROUP BY" cannot be used when updating result set
          *
          **********************************************************************/
         transactionTab.getResultSet("WHERE TRANSACTION_HASH LIKE ?", "%R%");

         /**********************************************************************
          *
          * Display number of records that will be affected:
          *
          **********************************************************************/
         log.info("ResultSet Row Count (number of records to be affected) = " + transactionTab.getResultSetRowCount());

         while (transactionTab.next()) {

            transactionTab.deleteThisRecordFromResultSet();
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
         log.error("Cannot update TABLE \"TRANSACTION\".");

         try {
            connection.rollback();  // rollback all deletes
         } catch (SQLException e1) {
            log.error("Cannot rollback transaction for deleting records from TABLE \"TRANSACTION\".");
            e1.printStackTrace();
            throw new GDAOException(e1);
         }
         throw new GDAOException(e);
      }  catch (SQLException e) {
         e.printStackTrace();
         throw new GDAOException(e);
      }
      finally {
         transactionTab.releaseStatement();
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


      String whatWeAreDoing = "\"batchInsert()\" for TABLE \"TRANSACTION\"";

      String SQL = null;
      OracleSystemTab oracleSystemTab = new OracleSystemTab(connection);
      int[] insertCounts = null;
      PreparedStatement ps = null;
      TransactionTab transactionTab = null;

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
         //SQL = "ALTER TABLE TRANSACTION DISABLE CONSTRAINT ....";
         //oracleSystemTab.runSQL(SQL);

         //SQL = "DROP INDEX ...";
         //oracleSystemTab.runSQL(SQL);

         SQL = "TRUNCATE TABLE TRANSACTION";
         oracleSystemTab.runSQL(SQL);

         log.info("TABLE \"TRANSACTION\" is truncated.");

         transactionTab = new TransactionTab(connection);

         log.info("Use Oracle Cursors for selecting and Batch Inserts for inserting large number of records...");

         connection.setAutoCommit(false);

         /**********************************************************************
         *
         * Change underlying table for this DAO object to 
         * TRANSACTION_BKP 
         * This will affect only selects from this DAO object.
         *
         **********************************************************************/
         transactionTab.setDbEntityName("TRANSACTION_BKP");
         transactionTab.getAllRecordsRs();

         transactionTab.setDbEntityName("TRANSACTION");
         ps = transactionTab.getInsertPreparedStatement();

         long recordsInserted = 0;
         while (transactionTab.next()) {
            /**********************************************************************
             *
             * Retrieve values from table TRANSACTION_BKP
             * using DAO object "transactionTo"
             *
             **********************************************************************/
            TransactionTo transactionTo = transactionTab.getTo();
            transactionTab.addInsertBatch(ps, transactionTo);

            recordsInserted++;

            if (recordsInserted % TRANSACTION_TRESHOLD == 0) {
               /**********************************************************************
                *
                * Execute Batch Insert
                *
                **********************************************************************/
               insertCounts = ps.executeBatch();
               connection.commit();
               log.info("Inserted and committed " + recordsInserted + " records into TABLE \"TRANSACTION\".");
            }
         }

         insertCounts = ps.executeBatch();
         connection.commit();
         
         log.info("Inserted and committed " + recordsInserted + " records into TABLE \"TRANSACTION\".");

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
         log.error("Cannot perform DDL/DML on TABLE \"TRANSACTION\".");
         throw new GDAOException(e);
      } catch (SQLException e) {
         e.printStackTrace();
         throw new GDAOException(e);
      } finally {
         try {
            transactionTab.releaseStatement();
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

      String whatWeAreDoing = "\"batchDelete()\" for TABLE \"TRANSACTION\"";

      String SQL = null;
      OracleSystemTab oracleSystemTab = new OracleSystemTab(connection);
      int[] insertCounts = null;
      PreparedStatement ps = null;
      TransactionTab transactionTab = null;

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
         //SQL = "ALTER TABLE TRANSACTION DISABLE CONSTRAINT ....";
         //oracleSystemTab.runSQL(SQL);

         //SQL = "DROP INDEX ...";
         //oracleSystemTab.runSQL(SQL);

         //log.info("TABLE \"TRANSACTION\" indexes are dropped.");

         transactionTab = new TransactionTab(connection);

         log.info("Use Oracle Cursors for selecting and Batch Inserts for inserting large number of records...");

         connection.setAutoCommit(false);

         /**********************************************************************
         *
         * Change underlying table for this DAO object to 
         * TRANSACTION_BKP 
         * This will affect only selects from this DAO object.
         *
         **********************************************************************/
         transactionTab.setDbEntityName("TRANSACTION_BKP");
         transactionTab.getAllRecordsRs();

         transactionTab.setDbEntityName("TRANSACTION");
         ps = transactionTab.getDeleteByPkPreparedStatement();

         int[] deleteCounts = null;
         long recordsDeleted = 0;
         while (transactionTab.next()) {
            /**********************************************************************
             *
             * Retrieve values from table TRANSACTION_BKP
             * using DAO object "transactionTo"
             *
             **********************************************************************/
            TransactionTo transactionTo = transactionTab.getTo();
            transactionTab.addInsertBatch(ps, transactionTo);

            recordsDeleted++;

            if (recordsDeleted % TRANSACTION_TRESHOLD == 0) {
               /**********************************************************************
                *
                * Execute Batch Insert
                *
                **********************************************************************/
               deleteCounts = ps.executeBatch();
               connection.commit();
               log.info("Deleted and committed " + recordsDeleted + " records from TABLE \"TRANSACTION\".");
            }
         }

         deleteCounts = ps.executeBatch();
         connection.commit();
         
         log.info("Deleted and committed " + recordsDeleted + " records from TABLE \"TRANSACTION\".");

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
         log.error("Cannot perform DDL/DML on TABLE \"TRANSACTION\".");
         throw new GDAOException(e);
      } catch (SQLException e) {
         e.printStackTrace();
         throw new GDAOException(e);
      } finally {
         try {
            transactionTab.releaseStatement();
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
   * transactionTo
   *
   * @param  connection      Database connection
   * @throws GDAOException
   *
   **********************************************************************/
   public void dataProvider1(Connection connection) throws GDAOException {
   
      String whatWeAreDoing = "\"dataProvider1()\" for TABLE \"TRANSACTION\"";

      log.debug("Starting " + whatWeAreDoing);

      TransactionTab transactionTab = new TransactionTab(connection);

      try {

         transactionTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         transactionTab.setResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE);

         /**********************************************************************
          *
          * Selects specific records from the table:
          *
          **********************************************************************/
         //transactionTab.getResultSet("WHERE UPPER(TRANSACTION_HASH) LIKE ?", "%R%");

         /**********************************************************************
          *
          * Retrieves all records from the table -
          * Both methods below are equal:
          *
          **********************************************************************/
         //transactionTab.getResultSet(null, (Object[])null);
         transactionTab.getAllRecordsRs();

         /**********************************************************************
         *
         * Loop through database result set:
         *
         **********************************************************************/
         while (transactionTab.next()) {

            TransactionTo transactionTo = transactionTab.getTo();

             /**********************************************************************
             *
             * Now use "transactionTo" object.
             * Below are few examples of what you can do with it:
             *
             * You can us it in Front End or just show it for debugging purposes:
             * NOTE: each values in this Transfer Object has it's own "getter"
             * and "setter" already defined.
             *
             **********************************************************************/
            //transactionTo.print();
            //Or alternatively, using Working class static method:
            TransactionTab.print(transactionTo, "; ");


            /**********************************************************************
            *
            * Change some values:
            * For example:
            * transactionTo.setSOME_VALUE(123);
            * transactionTo.setSOME_OTHER_VALUE("Some name");
            * etc...
            *
            **********************************************************************/


            /**********************************************************************
            *
            * Update row in TABLE \"TRANSACTION\" with values from this
            * Transfer Object transactionTo.
            *
            * NOTE:
            * Variables that keep values of the Primary Key in Transfer Object
            * transactionTo will be used to find
            * record to be updated. Generally those values should not be changed.
            *
            **********************************************************************/
            //transactionTab.update(transactionTo);

            /**********************************************************************
            *
            * Insert row in TABLE \"TRANSACTION\" using values set in
            * this Transfer Object transactionTo.
            *
            * NOTE:
            * Remember that values for Primary Key have to be unique.
            * Transfer Object transactionTo could be also
            * created from scratch (not retrieved from the database).
            *
            **********************************************************************/
            //transactionTab.insert(transactionTo);

            /**********************************************************************
            *
            * Delete row in TABLE \"TRANSACTION\" with values from this
            * Transfer Object transactionTo.
            *
            * NOTE:
            * Variables that keep values of the Primary Key in Transfer Object
            * transactionTo will be used to find
            * record to be deleted. Generally those values should not be changed.
            *
            **********************************************************************/
            //transactionTab.delete(transactionTo);
         }
      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot fetch data from TABLE \"TRANSACTION\".");
         throw new GDAOException(e);
      } finally {
         transactionTab.releaseStatement();
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
   
      String whatWeAreDoing = "\"dataProvider2()\" for TABLE \"TRANSACTION\"";

      log.debug("Starting " + whatWeAreDoing);

      TransactionTab transactionTab = new TransactionTab(connection);
      //int sampleTransferObjectArraySize = 100;  // sample number, change according to your needs

      try {

         transactionTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         transactionTab.setResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE);

         /**********************************************************************
          *
          * Selects specific records from the table:
          *
          **********************************************************************/
         //transactionTab.getResultSet("WHERE UPPER(TRANSACTION_HASH) LIKE ?", "%R%");

         /**********************************************************************
          *
          * Retrieves all records from the table -
          * Both methods below are equal:
          *
          **********************************************************************/
         //transactionTab.getResultSet(null, (Object[])null);
         transactionTab.getAllRecordsRs();

         /**********************************************************************
          *
          * This will fetch "sampleTransferObjectArraySize" number of rows into
          * array "transactionToArray".
          * If there is less than "sampleTransferObjectArraySize"  rows returned
          * then all available data will be stored into array
          * "transactionToArray".
          *
          * Alternatively you can use parameter "BaseOracleDbEntityClass.FETCH_ALL"
          * to fetch all records returned by result set.
          *
          **********************************************************************/
         //ArrayList<TransactionTo> transactionToArray = transactionTab.getToArray(sampleTransferObjectArraySize);
         ArrayList<TransactionTo> transactionToArray = transactionTab.getToArray(BaseOracleDbEntityClass.FETCH_ALL);

         Iterator<TransactionTo> iterator = transactionToArray.iterator();
         while (iterator.hasNext()) {
            TransactionTo transactionTo = iterator.next();

             /**********************************************************************
             *
             * Now use "transactionTo" object.
             * Below are few examples of what you can do with it:
             *
             * You can us it in Front End or just show it for debugging purposes:
             * NOTE: each values in this Transfer Object has it's own "getter"
             * and "setter" already defined.
             *
             **********************************************************************/
            //transactionTo.print();
            //Or alternatively, using Working class static method:
            TransactionTab.print(transactionTo, "; ");


            /**********************************************************************
            *
            * Change some values - for example:
            * transactionTo.setSOME_VALUE(123);
            * transactionTo.setSOME_OTHER_VALUE("Some name");
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
            //transactionTab.update(transactionTo);
         }

      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot fetch data from TABLE \"TRANSACTION\".");
         throw new GDAOException(e);
      }  finally {
         transactionTab.releaseStatement();
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

      String whatWeAreDoing = "\"copyDataBetweenDatabases()\" for TABLE \"TRANSACTION\"";

      String SQL = null;

      OracleSystemTab oracleSystemTabSource = new OracleSystemTab(sourceConnection);
      OracleSystemTab oracleSystemTabTarget = new OracleSystemTab(targetConnection);

      int[] insertCounts = null;
      PreparedStatement preparedStatement = null;

      TransactionTab transactionTabSource = null;
      TransactionTab transactionTabTarget = null;

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
         //SQL = "ALTER TABLE TRANSACTION DISABLE CONSTRAINT ....";
         //oracleSystemTab.runSQL(SQL);

         //SQL = "DROP INDEX ...";
         //oracleSystemTab.runSQL(SQL);

         SQL = "TRUNCATE TABLE TRANSACTION";
         oracleSystemTabTarget.runSQL(SQL);

         log.info("Target TABLE \"TRANSACTION\" is truncated.");

         transactionTabSource = new TransactionTab(sourceConnection);
         transactionTabTarget = new TransactionTab(targetConnection);

         /**********************************************************************
         *
         * Use the following parameters in order to speed up SELECT
         * and to prevent program from failing because of EXAUSTED MEMORY error:
         * java.lang.OutOfMemoryError: Java heap space
         *
         **********************************************************************/
         transactionTabSource.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         transactionTabSource.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

         /**********************************************************************
          *
          * Target ResultSet should be:
          * - ResultSet.TYPE_SCROLL_SENSITIVE,
          * - ResultSet.CONCUR_UPDATABLE
          *
          **********************************************************************/
         transactionTabTarget.setResultSetConcurrency(ResultSet.CONCUR_UPDATABLE);
         transactionTabTarget.setResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE);
 
         log.info("Use Oracle Cursors for selecting and Batch Inserts for inserting large number of records...");

         targetConnection.setAutoCommit(false);

         /**********************************************************************
          *
          * Get Source Data
          *
          **********************************************************************/
         transactionTabSource.getAllRecordsRs();

         /**********************************************************************
          *
          * Prepare Batch Insert Statement
          *
          **********************************************************************/
         preparedStatement = transactionTabTarget.getInsertPreparedStatement();

         long recordsInserted = 0;
         while (transactionTabSource.next()) {
            /**********************************************************************
             *
             * Retrieve values from table TRANSACTION
             * using DAO object "transactionTabSource"
             *
             * This is also the place to put Data Transformation code if data is
             * being copied to tables with different structures or names.
             *
             **********************************************************************/
            TransactionTo transactionTo = transactionTabSource.getTo();

            transactionTabTarget.addInsertBatch(preparedStatement, transactionTo);

            recordsInserted++;

            if (recordsInserted % TRANSACTION_TRESHOLD == 0) {
               /**********************************************************************
                *
                * Execute Batch Insert
                *
                **********************************************************************/
               insertCounts = preparedStatement.executeBatch();
               targetConnection.commit();
               log.info("Inserted and committed " + recordsInserted + " records into TABLE \"TRANSACTION\".");
               log.debug("insertCounts.length=" + insertCounts.length);
            }
         }

         insertCounts = preparedStatement.executeBatch();
         targetConnection.commit();

         log.info("Inserted and committed " + recordsInserted + " records into TABLE \"TRANSACTION\".");
         log.debug("insertCounts.length=" + insertCounts.length);

         targetConnection.setAutoCommit(true);

      } catch (GDAOException e) {
         log.error("Cannot perform DDL/DML on TABLE \"TRANSACTION\".");
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
            transactionTabSource.releaseStatement();
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

      String whatWeAreDoing = "\"deleteByToArrayBatch()\" for TABLE \"TRANSACTION\"";

      long rowsAffected = 0;

      int[] deleteCountsArray = null;
      PreparedStatement preparedStatement = null;

      TransactionTab transactionTabSource = null;
      TransactionTab transactionTabTarget = null;

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
         //SQL = "ALTER TABLE TRANSACTION DISABLE CONSTRAINT ....";
         //oracleSystemTab.runSQL(SQL);

         //SQL = "DROP INDEX ...";
         //oracleSystemTab.runSQL(SQL);

         transactionTabSource = new TransactionTab(sourceConnection);
         transactionTabTarget = new TransactionTab(targetConnection);

         /**********************************************************************
         *
         * Use the following parameters in order to speed up SELECT
         * and to prevent program from failing because of EXAUSTED MEMORY error:
         * java.lang.OutOfMemoryError: Java heap space
         *
         **********************************************************************/
         transactionTabSource.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         transactionTabSource.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

         /**********************************************************************
          *
          * Target ResultSet should be:
          * - ResultSet.TYPE_SCROLL_SENSITIVE,
          * - ResultSet.CONCUR_UPDATABLE
          *
          **********************************************************************/
         transactionTabTarget.setResultSetConcurrency(ResultSet.CONCUR_UPDATABLE);
         transactionTabTarget.setResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE);

         log.info("Number of records before Batch Delete: " + transactionTabTarget.getRowCount());

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
         transactionTabSource.getAllRecordsRs();
         ArrayList<TransactionTo> transactionToArrayList = transactionTabSource.getToArrayEntireResultSet();

         /**********************************************************************
          *
          * Prepare Batch Delete Statement
          *
          **********************************************************************/
         preparedStatement = transactionTabTarget.getDeleteByPkPreparedStatement();

         Iterator<TransactionTo> iterator = transactionToArrayList.iterator();

         long executedDeleteStatement = 0;

         while (iterator.hasNext()) {
            /**********************************************************************
             *
             * Retrieve values from table TRANSACTION
             * using DAO object "transactionTo"
             *
             **********************************************************************/

            TransactionTo transactionTo = iterator.next();
            transactionTabTarget.deleteByToAddToBach(preparedStatement, transactionTo);

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
                  log.info("Deleted " + executedDeleteStatement + " records from TABLE \"TRANSACTION\".");
               } else {
                  /**********************************************************************
                   *
                   * Results from JDBC are unreliable so we only know that statements are
                   * executed but we don't know if rows are deleted.
                   *
                   **********************************************************************/
                  log.info("Executed " + executedDeleteStatement + " delete statements for TABLE \"TRANSACTION\".");
               }
            }
         }

         deleteCountsArray = preparedStatement.executeBatch();
         targetConnection.commit();

         rowsAffected = checkBatchUpdateResults(deleteCountsArray);

         if (rowsAffected >= 0) {
            log.info("Deleted " + executedDeleteStatement + " records from TABLE \"TRANSACTION\".");
         } else {
            /**********************************************************************
             *
             * Results from JDBC are unreliable so we only know that statements are
             * executed but we don't know if rows are deleted.
             *
             **********************************************************************/
            log.info("Executed " + executedDeleteStatement + " delete statements for TABLE \"TRANSACTION\".");
         }

         targetConnection.setAutoCommit(true);

         log.info("Number of records after Batch Delete: " + transactionTabTarget.getRowCount());

      } catch (GDAOException e) {
         log.error("Cannot perform DDL/DML on TABLE \"TRANSACTION\".");
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
            transactionTabSource.releaseStatement();
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

      String whatWeAreDoing = "\"deleteByToArray()\" for TABLE \"TRANSACTION\"";

      long executedDeleteStatement = 0;
      long totalRecordsDeleted = 0;
      OracleSystemTab oracleSystemTabTarget = new OracleSystemTab(targetConnection);

      TransactionTab transactionTabSource = null;
      TransactionTab transactionTabTarget = null;

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
         //SQL = "ALTER TABLE TRANSACTION DISABLE CONSTRAINT ....";
         //oracleSystemTab.runSQL(SQL);

         //SQL = "DROP INDEX ...";
         //oracleSystemTab.runSQL(SQL);

         transactionTabSource = new TransactionTab(sourceConnection);
         transactionTabTarget = new TransactionTab(targetConnection);

         /**********************************************************************
         *
         * Use the following parameters in order to speed up SELECT
         * and to prevent program from failing because of EXAUSTED MEMORY error:
         * java.lang.OutOfMemoryError: Java heap space
         *
         **********************************************************************/
         transactionTabSource.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         transactionTabSource.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

         /**********************************************************************
          *
          * Target ResultSet should be:
          * - ResultSet.TYPE_SCROLL_SENSITIVE,
          * - ResultSet.CONCUR_UPDATABLE
          *
          **********************************************************************/
         transactionTabTarget.setResultSetConcurrency(ResultSet.CONCUR_UPDATABLE);
         transactionTabTarget.setResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE);

         log.info("Number of records before Delete: " + transactionTabTarget.getRowCount());

         targetConnection.setAutoCommit(false);

         /**********************************************************************
          *
          * Get Source Data into array of Transfer Objects
          * NOTE:
          * This is just a sample how to create array of transfer objects.
          * In WEB application this could be result of the user input or similar.
          *
          **********************************************************************/
         transactionTabSource.getAllRecordsRs();
         //transactionTabSource.getResultSet("WHERE OPERATION_TYPE = ?", "M");

         ArrayList<TransactionTo> transactionToArrayList = transactionTabSource.getToArrayEntireResultSet();

         Iterator<TransactionTo> iterator = transactionToArrayList.iterator();

         /**********************************************************************
          *
          * Loop through array of Transfer objects and delete matching records
          * using DAO Object "transactionTabTarget"
          *
          **********************************************************************/
         while (iterator.hasNext()) {

            TransactionTo transactionTo = iterator.next();

            /**********************************************************************
             *
             * Only one record should be delete for tables with Primary key
             * Primary Key is automatically recognized by GDAO.
             * If table does not have PK, deletes using this method is unreliable
             * and it should not be used.
             *
             **********************************************************************/
            int recordsDeleted = transactionTabTarget.deleteRecordUsingTo(transactionTo);
            
            //alternative method - to be tested:
            //transactionTabTarget.delete(transactionTo);

            totalRecordsDeleted += recordsDeleted;
            executedDeleteStatement++;

            /**********************************************************************
             *
             * Commit transaction after certain number of records are deleted.
             *
             **********************************************************************/
            if (totalRecordsDeleted % TRANSACTION_TRESHOLD == 0) {
               targetConnection.commit();
               log.info("Deleted " + totalRecordsDeleted + " records from TABLE \"TRANSACTION\".");
               log.info("Executed " + executedDeleteStatement + " delete statements for TABLE \"TRANSACTION\".");
            }
         }

         targetConnection.commit();

         log.info("Deleted " + totalRecordsDeleted + " records from TABLE \"TRANSACTION\".");
         log.info("Executed " + executedDeleteStatement + " DELETE statements for TABLE \"TRANSACTION\".");
         targetConnection.setAutoCommit(true);

         log.info("Number of records after Delete: " + transactionTabTarget.getRowCount());

      } catch (GDAOException e) {
         log.error("Cannot perform DDL/DML on TABLE \"TRANSACTION\".");
         throw new GDAOException(e);
      } catch (SQLException e) {
         throw new GDAOException(e);
      } finally {
         transactionTabSource.releaseStatement();
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

      String whatWeAreDoing = "\"updateByToArray()\" for TABLE \"TRANSACTION\"";

      long executedUpdateStatement = 0;
      long totalRecordsUpdated = 0;

      TransactionTab transactionTabSource = null;
      TransactionTab transactionTabTarget = null;

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
         //SQL = "ALTER TABLE TRANSACTION DISABLE CONSTRAINT ....";
         //oracleSystemTab.runSQL(SQL);

         //SQL = "DROP INDEX ...";
         //oracleSystemTab.runSQL(SQL);

         transactionTabSource = new TransactionTab(sourceConnection);
         transactionTabTarget = new TransactionTab(targetConnection);

         /**********************************************************************
         *
         * Use the following parameters in order to speed up SELECT
         * and to prevent program from failing because of EXAUSTED MEMORY error:
         * java.lang.OutOfMemoryError: Java heap space
         *
         **********************************************************************/
         transactionTabSource.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         transactionTabSource.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

         /**********************************************************************
          *
          * Target ResultSet should be:
          * - ResultSet.TYPE_SCROLL_SENSITIVE,
          * - ResultSet.CONCUR_UPDATABLE
          *
          **********************************************************************/
         transactionTabTarget.setResultSetConcurrency(ResultSet.CONCUR_UPDATABLE);
         transactionTabTarget.setResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE);

         log.info("Number of records before Update: " + transactionTabTarget.getRowCount());

         targetConnection.setAutoCommit(false);

         /**********************************************************************
          *
          * Get Source Data into array of Transfer Objects
          * NOTE:
          * This is just a sample how to create array of transfer objects.
          * In WEB application this could be result of the user input or similar.
          *
          **********************************************************************/
         //transactionTabSource.getAllRecordsRs();
         transactionTabSource.getResultSet("WHERE OPERATION_TYPE = ?", "M");

         ArrayList<TransactionTo> transactionToArrayList = transactionTabSource.getToArrayEntireResultSet();

         Iterator<TransactionTo> iterator = transactionToArrayList.iterator();

         /**********************************************************************
          *
          * Loop through array of Transfer objects and update matching records
          * using DAO Object "transactionTabTarget"
          *
          **********************************************************************/
         while (iterator.hasNext()) {

            TransactionTo transactionTo = iterator.next();

            /**********************************************************************
             *
             *  Change values in Transfer Object
             *  These values will be updated in the database.
             *
             **********************************************************************/
            //transactionTo.setOPERATION_TYPE("Z");

            /**********************************************************************
             *
             * Only one record should be updated for tables with Primary key
             * Primary Key is automatically recognized by GDAO.
             * If table does not have PK, updates using this method is unreliable
             * and it should not be used.
             *
             **********************************************************************/
            int recordsUpdated = transactionTabTarget.updateRecordUsingTo(transactionTo);

            totalRecordsUpdated += recordsUpdated;
            executedUpdateStatement++;

            /**********************************************************************
             *
             * Commit transaction after certain number of records are updated.
             *
             **********************************************************************/
            if (totalRecordsUpdated % TRANSACTION_TRESHOLD == 0) {
               targetConnection.commit();
               log.info("Updated " + totalRecordsUpdated + " records in TABLE \"TRANSACTION\".");
               log.info("Executed " + executedUpdateStatement + " UPDATE statements for TABLE \"TRANSACTION\".");
            }
         }

         targetConnection.commit();

         log.info("Updated " + totalRecordsUpdated + " records in TABLE \"TRANSACTION\".");
         log.info("Executed " + executedUpdateStatement + " UPDATE statements for TABLE \"TRANSACTION\".");
         targetConnection.setAutoCommit(true);

         log.info("Number of records after Update: " + transactionTabTarget.getRowCount());

      } catch (GDAOException e) {
         log.error("Cannot perform DDL/DML on TABLE \"TRANSACTION\".");
         throw new GDAOException(e);
      } catch (SQLException e) {
         throw new GDAOException(e);
      } finally {
         transactionTabSource.releaseStatement();
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

      String whatWeAreDoing = "\"updateByToArrayBatch()\" for TABLE \"TRANSACTION\"";

      long rowsAffected = 0;

      int[] updateCountsArray = null;
      PreparedStatement preparedStatementForUpdate = null;

      TransactionTab transactionTabSource = null;
      TransactionTab transactionTabTarget = null;

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
         //SQL = "ALTER TABLE TRANSACTION DISABLE CONSTRAINT ....";
         //oracleSystemTab.runSQL(SQL);

         //SQL = "DROP INDEX ...";
         //oracleSystemTab.runSQL(SQL);

         transactionTabSource = new TransactionTab(sourceConnection);
         transactionTabTarget = new TransactionTab(targetConnection);

         /**********************************************************************
         *
         * Use the following parameters in order to speed up SELECT
         * and to prevent program from failing because of EXAUSTED MEMORY error:
         * java.lang.OutOfMemoryError: Java heap space
         *
         **********************************************************************/
         transactionTabSource.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         transactionTabSource.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

         /**********************************************************************
          *
          * Target ResultSet should be:
          * - ResultSet.TYPE_SCROLL_SENSITIVE,
          * - ResultSet.CONCUR_UPDATABLE
          *
          **********************************************************************/
         transactionTabTarget.setResultSetConcurrency(ResultSet.CONCUR_UPDATABLE);
         transactionTabTarget.setResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE);

         log.info("Number of records before Batch Update: " + transactionTabTarget.getRowCount());

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
         //transactionTabSource.getAllRecordsRs();
         transactionTabSource.getResultSet("WHERE OPERATION_TYPE = ?", "M");


         ArrayList<TransactionTo> transactionToArrayList = transactionTabSource.getToArrayEntireResultSet();

         /**********************************************************************
          *
          * Prepare Batch Update Statement
          *
          **********************************************************************/
         preparedStatementForUpdate = transactionTabTarget.getUpdateByPkPreparedStatement();

         Iterator<TransactionTo> iterator = transactionToArrayList.iterator();

         long executedUpdateStatement = 0;

         while (iterator.hasNext()) {
            /**********************************************************************
             *
             * Retrieve values from table TRANSACTION
             * using DAO object "transactionTo"
             *
             **********************************************************************/

            TransactionTo transactionTo = iterator.next();


            /**********************************************************************
             *
             *  Change values in Transfer Object
             *  These values will be updated in the database.
             *
             **********************************************************************/
            //transactionTo.setOPERATION_TYPE("Z");

            transactionTabTarget.updateByToAddToBach(preparedStatementForUpdate, transactionTo);

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
                  log.info("Updated " + executedUpdateStatement + " records in TABLE \"TRANSACTION\".");
               } else {
                  /**********************************************************************
                   *
                   * Results from JDBC are unreliable so we only know that statements are
                   * executed but we don't know if rows are updated.
                   *
                   **********************************************************************/
                  log.info("Executed " + executedUpdateStatement + " update statements for TABLE \"TRANSACTION\".");
               }
            }
         }

         updateCountsArray = preparedStatementForUpdate.executeBatch();
         targetConnection.commit();

         rowsAffected = checkBatchUpdateResults(updateCountsArray);

         if (rowsAffected >= 0) {
            log.info("Updated " + executedUpdateStatement + " records in TABLE \"TRANSACTION\".");
         } else {
            /**********************************************************************
             *
             * Results from JDBC are unreliable so we only know that statements are
             * executed but we don't know if rows are updated.
             *
             **********************************************************************/
            log.info("Executed " + executedUpdateStatement + " UPDATE statements for TABLE \"TRANSACTION\".");
         }

         targetConnection.setAutoCommit(true);

         log.info("Number of records after Batch Update: " + transactionTabTarget.getRowCount());

      } catch (GDAOException e) {
         log.error("Cannot perform DDL/DML on TABLE \"TRANSACTION\".");
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
            transactionTabSource.releaseStatement();
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
     //transactionTabSource.setDbEntityName("GDAODEMO.TRANSACTION");


***************************************************************************/
  
}
