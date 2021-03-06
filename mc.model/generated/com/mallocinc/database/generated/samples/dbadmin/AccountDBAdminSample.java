package com.mallocinc.database.generated.samples.dbadmin;

import java.sql.Connection;
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

import com.mallocinc.database.generated.working.AccountTab;
import com.mallocinc.database.generated.to.AccountTo;

 /**********************************************************************
 *  <pre>
 *
 *  Generated Class: AccountDBAdminSample.java
 * 
 *  This is sample class that demonstrates how GDAO Working class
 *  could be used for Database Administration and DDL.
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
 *  Template file:    /templates/Oracle/SampleOracleDBAdminTemplate.txt
 *  Target database:  Oracle 10g, 11g, 12c
 *
 *  "/templates/Oracle/SampleOracleDBAdminTemplate.txt" must be on the CLASSPATH
 *
 *  This code is generated on: 2017-February-27 06:45:54 PM CET
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
 *  Sample GDAO code for TABLE "ACCOUNT"
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
public class AccountDBAdminSample {

   final static Logger log = Logger.getLogger(AccountDBAdminSample.class.getName());
   
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
        * Get database connection.
        * Replace "CONNECTION_ID" with your connection identifier:
        * Refer to database connection definition file:
        * "conf/dbconnections/dbconnections.txt"
        *
        * Use default DB connection file (1st line) or supply yours (2nd line)
        *
        **********************************************************************/
        GDAODatabaseConnectionFactory gDAODatabaseConnectionFactory = new GDAODatabaseConnectionFactory();
        //GDAODatabaseConnectionFactory gDAODatabaseConnectionFactory = new GDAODatabaseConnectionFactory("/dbconnections.txt");
        
        connection = gDAODatabaseConnectionFactory.getConnection("GDAODEMO");
        //connection = gDAODatabaseConnectionFactory.getConnection("XE");

       /**********************************************************************
        *
        * Create DAO Object
        *
        **********************************************************************/
        AccountDBAdminSample accountDBAdminSample = new AccountDBAdminSample();

        /**********************************************************************
         *
         * Uncomment test that you want to execute:
         *
         **********************************************************************/
         //accountDBAdminSample.backupTable(connection);
         //accountDBAdminSample.restoreTable(connection);
         //accountDBAdminSample.restoreTableInOneStatement(connection);
         
         //accountDBAdminSample.showVolumesInformation(connection);
         //accountDBAdminSample.showMetaDataInformation(connection);
         
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
   * This method demonstrates usage of plain SQL by creating a backup
   * of the TABLE "ACCOUNT"
   *
   * @throws GDAOException
   *
   **********************************************************************/
   public void backupTable(Connection connection) throws GDAOException {
   
      String whatWeAreDoing = "\"backupTable()\" for TABLE \"ACCOUNT\"";
   
      String SQL = null;
      OracleSystemTab oracleSystemTab = new OracleSystemTab(connection);
      log.debug("Backing up TABLE \"ACCOUNT\"...");
      try {
         /**********************************************************************
         *
         * Executing statement which will ignore Oracle error:
         *
         **********************************************************************/
         SQL = "DROP TABLE ACCOUNT_BKP";
         oracleSystemTab.runSQL(SQL, OracleErrorCodes.ORA_ERR_CODE_OBJECT_DOES_NOT_EXIST);

         /**********************************************************************
         *
         * Executing statement that will not ignore Oracle errors:
         *
         **********************************************************************/
         SQL = "CREATE TABLE ACCOUNT_BKP AS SELECT * FROM ACCOUNT";
         oracleSystemTab.runSQL(SQL);
      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Error occurred while executing SQL statement:" + SQL);
         log.error("Cannot perform DDL on TABLE \"ACCOUNT\".");
         throw new GDAOException(e);
      }

      log.debug("TABLE \"ACCOUNT\" is backed up.");
   }

   /**********************************************************************
   *
   * This method demonstrates usage of plain SQL by restoring
   * TABLE "ACCOUNT" from the backup
   *
   * @throws GDAOException
   *
   **********************************************************************/
   public void restoreTableInOneStatement(Connection connection) throws GDAOException {
   
      String whatWeAreDoing = "\"restoreTable()\" for TABLE \"ACCOUNT\"";
   
      String SQL = null;
      OracleSystemTab oracleSystemTab = new OracleSystemTab(connection);
      
      log.debug("Restoring TABLE \"ACCOUNT\"...");
      
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
         //SQL = "ALTER TABLE ACCOUNT DISABLE CONSTRAINT ....";
         //oracleSystemTab.runSQL(SQL);

         //SQL = "DROP INDEX ...";
         //oracleSystemTab.runSQL(SQL);
         
         SQL = "TRUNCATE TABLE ACCOUNT";
         oracleSystemTab.runSQL(SQL);

         SQL = "INSERT INTO ACCOUNT (SELECT * FROM ACCOUNT_BKP)";
         oracleSystemTab.runSQL(SQL);
      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Error occurred while executing SQL statement:" + SQL);
         log.error("Cannot perform DDL/DML on TABLE \"ACCOUNT\".");
         log.error("Database Tip: Table cannot be truncated if it has a \"child\" table with foreign key pointing to the field table being truncated. Use \"DELETE\" instead.");
         throw new GDAOException(e);
      }

      log.debug("TABLE \"ACCOUNT\" is restored from the backup.");
   }
   
   
   
  /**********************************************************************
   *
   * This method demonstrates:
   * 1.  Two different strategies for restoring
   *     TABLE \"ACCOUNT\" from the backup table 
   *     ACCOUNT_BKP (see description below).
   * 2.  Using Transfer Objects
   * 
   * Two different strategies for restoring table:
   * 1. If table is too big to restore it in one SQL statement (it has more 
   *    than "TRANSACTION_STRATEGY_TRESHOLD" records) Oracle cursor is 
   *    used to restore number of records in one transaction at the time.
   * 
   * 2. Otherwise table is restored in one SQL statement.
   * 
   * NOTE: It is generally more efficient to restore table in one SQL 
   * statement however if table is too big that may be impossible because 
   * Oracle UNDO segment can be exhausted because transaction may become too
   * big.   
   *
   * @throws GDAOException
   *
   **********************************************************************/
   public void restoreTable(Connection connection) throws GDAOException {
      String SQL = null;
      OracleSystemTab oracleSystemTab = new OracleSystemTab(connection);
      
      log.info("Restoring TABLE \"ACCOUNT\"...");
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
         //SQL = "ALTER TABLE ACCOUNT DISABLE CONSTRAINT ....";
         //oracleSystemTab.runSQL(SQL);

         //SQL = "DROP INDEX ...";
         //oracleSystemTab.runSQL(SQL);
         
         SQL = "TRUNCATE TABLE ACCOUNT";
         oracleSystemTab.runSQL(SQL);

         log.info("TABLE \"ACCOUNT\" is truncated.");

         AccountTab accountTab = new AccountTab(connection);

         /**********************************************************************
         *
         * Change underlying table for this DAO object to 
         * ACCOUNT_BKP. 
         * This will affect only selects from this DAO object.
         *
         **********************************************************************/
         accountTab.setDbEntityName("ACCOUNT_BKP");
         long rowCount = accountTab.getRowCount();

         if (rowCount > TRANSACTION_STRATEGY_TRESHOLD ) {
            log.info("Use Oracle cursors for inserting large number of records...");
            
            connection.setAutoCommit(false);

            accountTab.setDbEntityName("ACCOUNT_BKP");
            accountTab.getAllRecordsRs();

            long recordsInserted = 0;
            while (accountTab.next()) {
               /**********************************************************************
                *
                * Retrieve values from table ACCOUNT_BKP
                * using DAO object "accountTab"
                *
                **********************************************************************/
               AccountTo accountTo = accountTab.getTo();

               /**********************************************************************
                *
                * Insert record in table ACCOUNT
                * using the same DAO object "accountTab"
                *
                **********************************************************************/
               accountTab.setDbEntityName("ACCOUNT");
               accountTab.insert(accountTo);
               recordsInserted++;
               
               if (recordsInserted % TRANSACTION_TRESHOLD == 0) {
                  connection.commit();
                  log.info("Inserted and committed " + recordsInserted + " records into TABLE \"ACCOUNT\".");
               }
            }

            connection.commit();
            log.info("Inserted and committed " + recordsInserted + " records into TABLE \"ACCOUNT\".");

            connection.setAutoCommit(true);
         } else {
            log.info("TABLE \"ACCOUNT\" has only "
                     + rowCount
                     + " records ( less than " + TRANSACTION_STRATEGY_TRESHOLD + " ) so all of them will be inserted in one SQL statement.");

            /**********************************************************************
            *
            * Executing statements which will NOT ignore Oracle errors:
            *
            **********************************************************************/
            SQL = "INSERT INTO ACCOUNT (SELECT * FROM ACCOUNT_BKP)";
            oracleSystemTab.runSQL(SQL);
         }

      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Error occurred while executing SQL statement:" + SQL);
         log.error("Cannot perform DDL/DML on TABLE \"ACCOUNT\".");
         throw new GDAOException(e);
      } catch (SQLException e) {
         e.printStackTrace();
         throw new GDAOException(e);
      }

      log.info("TABLE \"ACCOUNT\" is restored from the backup TABLE ACCOUNT_BKP.");
   }
   
   
 


   /**********************************************************************
    *
    * Demonstrates showing various volumes information about this 
    * table/view/resultset
    *
    * @throws GDAOException
    *
    **********************************************************************/
   public void showVolumesInformation(Connection connection) throws GDAOException {
   
      String whatWeAreDoing = "\"showVolumesInformation()\" for TABLE \"ACCOUNT\"";

      log.debug("Starting " + whatWeAreDoing);

      AccountTab accountTab = new AccountTab(connection);

      try {
      
          if (accountTab.exists()) {
             log.info("TABLE \"ACCOUNT\" exists in the database.");
          } else {
             log.info("TABLE \"ACCOUNT\" does not exist in the database.");
             return;
          }

         /**********************************************************************
          *
          * Get Table Total Row Count
          *
          **********************************************************************/
         log.info("TABLE \"ACCOUNT\" row count=" + accountTab.getRowCount());

         /**********************************************************************
          *
          * Next section shows number of records to be returned by result set 
          * and therefore possibly affected.
          * 
          * Use the following parameters in order to speed up SELECT
          * and to prevent program from failing because of exhausted memory
          *
          **********************************************************************/
         accountTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         accountTab.setResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE);

         /**********************************************************************
          *
          * Selects specific records from the table:
          *
          **********************************************************************/
         accountTab.getResultSet("WHERE UPPER(ACCOUNT_ID) LIKE ?", "%R%");

         /**********************************************************************
          *
          * Selects all records from the table - no "WHERE" condition.
          * Both methods below are equal:
          *
          **********************************************************************/
         //accountTab.getResultSet(null, (Object[])null);
         //accountTab.getAllRecordsRs();

         /**********************************************************************
         *
         * Get result set row count
         * NOTE: cannot be done if
         * "setResultSetType(ResultSet.TYPE_FORWARD_ONLY)" is used.
         *
         * For example, this is useful when updating records in ResultSet -
         * you can display information about how many records are going to be
         * affected.
         *
         **********************************************************************/
         log.info("ResultSet Row Count=" + accountTab.getResultSetRowCount());

      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot select from TABLE \"ACCOUNT\".");
         throw new GDAOException(e);
      } finally {
         accountTab.releaseStatement();
      }

      log.debug("Finished " + whatWeAreDoing + ".");
   }
   
   
   /**********************************************************************
   *
   * Demonstrates showing various Meta Data information about 
   * this table/view/resultset
   *
   *
   * @throws GDAOException
   *
   **********************************************************************/
   public void showMetaDataInformation(Connection connection) throws GDAOException {

      String whatWeAreDoing = "\"showMetaDataInformation()\" for TABLE \"ACCOUNT\"";

      log.debug("Starting " + whatWeAreDoing);

      ResultSet tablesResultSet = null;
      ResultSet columnsResultSet = null;
      ResultSet bestRowIdentifierResultSet = null;

      try {
         DatabaseMetaData databaseMetaData = connection.getMetaData();

         /**********************************************************************
         *
         * TABLE Information
         *
         **********************************************************************/

         /**********************************************************************
          *
          * Specifying "null" for database and schema name will cause using 
          * whatever database and schema connection is using.
          *
          **********************************************************************/
         tablesResultSet = databaseMetaData.getTables(null, null, "ACCOUNT", null);

         while (tablesResultSet.next()) {

            String catalogName = tablesResultSet.getString(1);
            String schemaName = tablesResultSet.getString(2);
            String tableName = tablesResultSet.getString(3);
            String tableType = tablesResultSet.getString(4);
            String tableRemarks = tablesResultSet.getString(5);

            System.out.println("\n--------------------> Table <-------------------------\n");

            System.out.println("Catalog Name:\t" + catalogName);
            System.out.println("Schema Name:\t" + schemaName);
            System.out.println("Table Name:\t" + tableName);
            System.out.println("Table Type:\t" + tableType);
            System.out.println("Table Remarks:\t" + tableRemarks);
         }

         tablesResultSet.close();

         /**********************************************************************
          *
          * COLUMNS Information
          *
          **********************************************************************/
         columnsResultSet = databaseMetaData.getColumns(null, null, "ACCOUNT", null);

         System.out.println("\n--------------------> Columns <-------------------------\n");

         long recordLengt = 0;

         while (columnsResultSet.next()) {

            String catalogName = columnsResultSet.getString(1);
            String schemaName = columnsResultSet.getString(2);
            String tableName = columnsResultSet.getString(3);
            String columnName = columnsResultSet.getString(4);
            String dataType = columnsResultSet.getString(6);
            int columnSize = columnsResultSet.getInt(7);
            int decimalDigits = columnsResultSet.getInt(9);
            int ordinalPosition = columnsResultSet.getInt(17);
            String isNullable = columnsResultSet.getString(18);
            String remarks = columnsResultSet.getString(12);

            String columnTypeWithSize = dataType
                                        + "["
                                        + columnSize
                                        + ((decimalDigits == 0) ? "" : "." + decimalDigits)
                                        + "]";

            System.out.printf("%2d. %-30s %-20s %-10s %s\n",
                              ordinalPosition,
                              columnName,
                              columnTypeWithSize,
                              (isNullable.equals("YES") ? "NULL" : "NOT NULL"),
                              (remarks == null) ? "" : remarks);

            recordLengt += columnSize + decimalDigits;
         }

         columnsResultSet.close();

         System.out.println("\nRecord length: " + recordLengt);
         //System.out.println("------------------------------");

         /**********************************************************************
         *
         * BEST ROW IDENTIFIER
         * Retrieves a description of a table's optimal set of columns that 
         * uniquely identifies a row.
         *
         **********************************************************************/
         bestRowIdentifierResultSet = databaseMetaData.getBestRowIdentifier(null,
                                                                            null,
                                                                            "ACCOUNT",
                                                                            DatabaseMetaData.bestRowSession,
                                                                            false);

         System.out.println("\n--------------------> Best Row Identifier <-------------------------\n");

         while (bestRowIdentifierResultSet.next()) {

            short scope = bestRowIdentifierResultSet.getShort(1);
            String columnName = bestRowIdentifierResultSet.getString(2);
            String dataType = bestRowIdentifierResultSet.getString(4);
            int columnSize = bestRowIdentifierResultSet.getInt(5);
            int decimalDigits = bestRowIdentifierResultSet.getInt(7);

            String columnTypeWithSize = dataType
                                        + "["
                                        + columnSize
                                        + ((decimalDigits == 0) ? "" : "." + decimalDigits)
                                        + "]";

            System.out.printf(" - %-30s %-20s\n", columnName, columnTypeWithSize);
         }

         bestRowIdentifierResultSet.close();

      } catch (SQLException e) {
         e.printStackTrace();
         log.error("Cannot get meta data for TABLE \"ACCOUNT\".");
         throw new GDAOException(e);
      } finally {
        // Do what you need to do

      }

      log.debug("Finished " + whatWeAreDoing + ".");
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
     //accountTabSource.setDbEntityName("GDAODEMO.ACCOUNT");


***************************************************************************/
   
   
   
   
   
}
