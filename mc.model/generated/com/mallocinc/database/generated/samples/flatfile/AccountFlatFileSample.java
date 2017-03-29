package com.mallocinc.database.generated.samples.flatfile;

import java.math.BigDecimal;
import java.text.NumberFormat;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.log4j.Logger;

import com.mallocinc.codegenerator.exceptions.GDAOException;
import com.mallocinc.shared.util.dbconnection.GDAODatabaseConnectionFactory;
import com.mallocinc.codegenerator.classgenerator.common.SharedConstants;

import com.mallocinc.database.generated.working.AccountTab;
//import com.mallocinc.database.generated.to.AccountTo;

import com.mallocinc.modules.flatfileloader.base.FlatFileLoaderBase;
import com.mallocinc.modules.flatfileloader.base.FlatFileLoaderException;

/**********************************************************************
 *  <pre>
 *
 *  Generated Class: AccountFlatFileSample.java
 * 
 *  This is sample class that demonstrates how GDAO Working class
 *  could be used to manipulate data in Flat Files:
 *  1. Load data from Flat Files into the database
 *  2. Create flat files from data in the database
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
 *  Template file:    /templates/Oracle/SampleFlatFileOracleTemplate.txt
 *  Target database:  Oracle 10g, 11g, 12c
 *
 *  "/templates/Oracle/SampleFlatFileOracleTemplate.txt" must be on the CLASSPATH
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
public class AccountFlatFileSample extends FlatFileLoaderBase {

    final static Logger log = Logger.getLogger(AccountFlatFileSample.class.getName());

    /**********************************************************************
    *
    * Constructor
    * @throws FlatFileLoaderException
    *
    **********************************************************************/
    public AccountFlatFileSample(String fileName) throws FlatFileLoaderException {
      super(fileName);
    }

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

   public static void main(String[] args) {

     Connection connection = null;

     /**********************************************************************
      *
      * Get database connection.
      * Replace "CONNECTION_ID" with your connection identifier:
      * Refer to database connection definition file:
      * "conf/dbconnections/dbconnections.txt"
      *
      **********************************************************************/
     try {
     
     
       /**********************************************************************
        *
        * Use default DB connection file (1st line) or supply yours (2nd line)
        *
        **********************************************************************/
        GDAODatabaseConnectionFactory gDAODatabaseConnectionFactory = new GDAODatabaseConnectionFactory();
        //GDAODatabaseConnectionFactory gDAODatabaseConnectionFactory = new GDAODatabaseConnectionFactory("/dbconnections.txt");
     
        //connection = gDAODatabaseConnectionFactory.getConnection("CONNECTION_ID");
        connection = gDAODatabaseConnectionFactory.getConnection("XE");

        /**********************************************************************
         *
         * Uncomment test that you want to execute:
         *
         **********************************************************************/

         String testDirectory = "C:/Software Development/Database Analyzer/Code/sql/oracle/Code Generator Demo/test_data/flat_files/";
         String inputFileName = testDirectory + "users.txt";

         try {
           log.info("Processing file " + inputFileName);
           AccountFlatFileSample accountFlatFileSample = new AccountFlatFileSample(inputFileName);
           accountFlatFileSample.loadDataFromFlatFile(connection, inputFileName);
           
           //accountFlatFileSample.saveDataToFlatFile(connection, testDirectory + "user.txt");
           //accountFlatFileSample.updateOrInsertDataFromFlatFile(connection, testDirectory + "user.txt");
           
         } catch (FlatFileLoaderException e) {
           e.printStackTrace();
           System.exit(SharedConstants.ERROR);
         }

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
   *  Demonstrates Loading Data from Flat File to Database Table
   *
   *  @throws GDAOException
   *
   **********************************************************************/
   private void loadDataFromFlatFile(Connection connection, String FlatFileName) throws GDAOException {

      String whatWeAreDoing = "\"loadDataFromFlatFile()\" for TABLE \"ACCOUNT\"";

      log.debug("Starting " + whatWeAreDoing);

      AccountTab accountTab = new AccountTab(connection);

      try {
         this.processInputFile(accountTab);
      } catch (FlatFileLoaderException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      log.debug(whatWeAreDoing);
   }
   
   @Override
   protected void processLine(Object... parameters) throws FlatFileLoaderException {
      String inputLine = this.getInputLine();
      log.debug("Current line ->" + inputLine);
      
      /****************************************************************
       *  
       * First parameter passed is instance of the Working Table Object
       *
       ****************************************************************/
      AccountTab accountTab = (AccountTab)parameters[0];

      /****************************************************************
       *  
       *  Get the all fields in the line assuming that "|"
       *  character is field delimiter.
       *  It is more practical to have TAB as a delimiter rather 
       *  then "," because "," is likely to be part of some fields.
       *
       ****************************************************************/
      String[] tokens = this.getLineFileds("|"); //"|" character in a field delimiter

      for (int i = 0; i < tokens.length; i++) {
         /****************************************************************
         * 
         *  Clean characters that will prevent proper data conversion: 
         *  """, "%" and ","
         * 
         ****************************************************************/
         String token = tokens[i].replace("\"", "").replace("%", "").replace(",", "").trim();
         log.debug("original token=[" + tokens[i] + "] new token=[" + token + "]");
      }
      
      /****************************************************************
       * 
       *  Load data into database 
       * 
       ****************************************************************/
       try {
                accountTab.setACCOUNT_ID( getString((tokens[0])) );
      accountTab.setBANK_ID( getNumber((tokens[1])) );
      accountTab.setACCOUNT_NUMBER( getNumber((tokens[2])) );
      accountTab.setFIRST_NAME( getString((tokens[3])) );
      accountTab.setMIDDLE_NAME( getString((tokens[4])) );
      accountTab.setLAST_NAME( getString((tokens[5])) );
      accountTab.setTYPE( getString((tokens[6])) );
      accountTab.setBROKER_CODE( getString((tokens[7])) );
      accountTab.setMANAGED_ACCOUNT( getString((tokens[8])) );
      accountTab.setACCOUNT_STATUS( getString((tokens[9])) );

          accountTab.insertThisRecord();

          log.info("Inserted line with first column = [" + tokens[0] + "]");

       }  catch (GDAOException e) {
          e.printStackTrace();
          throw new FlatFileLoaderException(e.getMessage());
      }
   }
   

   /**********************************************************************
   *
   *  Demonstrates Saving Data from database table to Flat File
   *
   * @throws GDAOException
   *
   **********************************************************************/
   private void saveDataToFlatFile(Connection connection, String FlatFileName) throws GDAOException {

      String whatWeAreDoing = "\"saveDataToFlatFile()\" for TABLE \"ACCOUNT\"";

      log.debug("Starting " + whatWeAreDoing);

      int inserted = 0;

      AccountTab accountTab = new AccountTab(connection);

      try {

        
         if (!accountTab.exists()) {
            String errMessage = "Table " + accountTab.getDbEntityName() + " does not exist.";
            log.error(errMessage);
            throw new GDAOException(errMessage);
         } else {
            log.debug("Table " + accountTab.getDbEntityName() + " exists.");
         }

         /**********************************************************************
          *
          * Use the following parameters in order to speed up SELECT
          * and to prevent program from failing because of exhausted memory
          *
          **********************************************************************/
         accountTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         accountTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

         /**********************************************************************
          *
          * Selects specific records from the table:
          * Limit number of rows selected to "100" (just an example)
          *
          **********************************************************************/
         //accountTab.getResultSet("WHERE UPPER(CREDIT_DEBIT_CODE) LIKE ? AND ROWNUM < ?", "%A%", 100);

         /**********************************************************************
          *
          * Selects all records from the table - no "WHERE" condition.
          * Both methods below are equal:
          *
          **********************************************************************/
         //accountTabb.getResultSet(null, (Object[])null);
         accountTab.getAllRecordsRs();


         int row = 1;  // start with data in the row after the Flat Header
         int column = 0;

         /**********************************************************************
          *
          * Loop through database result set:
          *
          **********************************************************************/
         while (accountTab.next()) {

            column = 0;
            inserted++;

            /**********************************************************************
            *
            * Print all values from the row in one line delimited by "; "
            *
            **********************************************************************/
            accountTab.print("; ");

            /**********************************************************************
            *
            * 
            *
            **********************************************************************/

           // <FLAT_FILE_SETTERS>

            row++;
         }

         log.info("Inserted records: " + inserted);

         log.debug("Finished " + whatWeAreDoing + ".");
      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot select from TABLE \"ACCOUNT\".");
         throw new GDAOException(e);
      } finally {
         accountTab.releaseStatement();
      }

      log.debug(whatWeAreDoing);
   }




   public void showList() {
      NumberFormat numberFormat = NumberFormat.getInstance(); // Get Instance of NumberFormat
      numberFormat.setMinimumIntegerDigits(5); // The minimum Digits required is 5
      numberFormat.setMaximumIntegerDigits(5); // The maximum Digits required is 5
      numberFormat.setGroupingUsed(false);

      int i = 1;

   }

   public void printList(String fileName) {

      File file = new File(fileName);
      int i = 0;

      try {
         PrintWriter printWriter = new PrintWriter(new FileOutputStream(file));

         log.info("About to print " + "zz" + " elements:");

         printWriter.flush();
         printWriter.close();

      } catch (FileNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   @Override
   protected void afterFileProcess(Object... parameters) throws FlatFileLoaderException {
   // TODO Auto-generated method stub

   }

   @Override
   protected void beforeFileProcess(Object... parameters) throws FlatFileLoaderException {
   // TODO Auto-generated method stub

   };




   /**********************************************************************
   *
   *  TABLE ACCOUNT
   *
   *  Demonstrates Loading Data from Flat File:
   *  1. If record exists it is updated
   *  2. If record does not exist it is inserted
   *
   *  Primary Key is used to find a matching record.
   *  GDAO Automatically recognizes Primary Key
   *
   * @throws GDAOException
   *
   **********************************************************************/
   private void updateOrInsertDataFromFlatFile(Connection connection, String FlatFileName) {

      String whatWeAreDoing = "\"updateOrInsertDataFromFlatFile()\" for TABLE \"ACCOUNT\"";
      log.debug("Starting " + whatWeAreDoing);


      int rows = 0;
      int columns = 0;
     
      int row = 0;
      int column = 0;
      int inserted = 0;
      int updated = 0;
      int errors = 0;

      try {
         

         log.info("Flat file has " + rows + " rows and " + columns + " columns");

         AccountTab accountTab = new AccountTab(connection);

         if (!accountTab.exists()) {
            String errMessage = "TABLE " + accountTab.getDbEntityName() + " does not exist.";
            log.error(errMessage);
            throw new GDAOException(errMessage);
         } else {
            log.debug("TABLE " + accountTab.getDbEntityName() + " exists.");
         }

         if (rows > 0 && columns > 0) {
            for (row = 1; row < rows; row++) { // skip first row since it is header row
               for (column = 0; column < columns; column++) {
                  
               }

               accountTab.print(";");

               int recordsUpdated = 0;

               /**********************************************************************
                *
                * Try to update this record. If it could not be updates then record
                * does not exist and it has to be inserted.
                *
                **********************************************************************/
               try {
                  recordsUpdated = accountTab.updateThisRecord();
               } catch (GDAOException e) {
                  if (e.getMessage().startsWith("Expecting to update")) {
                     recordsUpdated = 0;
                  }
               }

               try {
                  if (recordsUpdated == 0) {
                     /**********************************************************************
                     *
                     * Records does not exist so insert it into the database.
                     *
                     **********************************************************************/
                     log.debug("Record does not exist - it will be inserted.");
                     accountTab.insertThisRecord();
                     inserted++;
                  } else {
                     updated++;
                  }

               } catch (GDAOException e) {
                  log.error("----------------------");
                  log.error("ERROR occurred on row :" + row + " with first four columns:");
                  errors++;
                  e.printStackTrace();
               }
            }
         }

         connection.commit();


         long rowCount = accountTab.getRowCount();

         log.info("Inserted Records in TABLE ACCOUNT DB: " + inserted + ". Errors: " + errors);
         log.info("Updated Records in TABLE ACCOUNT DB: " + updated + ". Errors: " + errors);
         log.info("Row Count (TABLE ACCOUNT) =" + rowCount);

      } catch (SQLException e) {
         e.printStackTrace();
      } catch (GDAOException e1) {
         e1.printStackTrace();
      } 

      log.debug("Finished " + whatWeAreDoing);
   }
   
   
   
   private String getString(String value) {
      //return (value.isEmpty()) ? null : value.replace(",", "");
      return (value.isEmpty()) ? null : value.trim();
   }

   private BigDecimal getNumber(String value) {
      return (value.isEmpty()) ? null : new BigDecimal(value.trim().replace(",", ""));
   }
   
   /**********************************************************************
   *
   *  "value" has to be in the following format:
   *
   *  yyyy-mm-dd hh:mm:ss[.f...]
   *
   *  Fractions of the seconds are optional.
   *
   **********************************************************************/
   private Timestamp getTimestamp(String value) {
      return (value.isEmpty()) ? null : Timestamp.valueOf(value.trim());
   }
}
