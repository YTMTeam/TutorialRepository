package com.mallocinc.database.generated.samples.excel;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.mallocinc.codegenerator.exceptions.GDAOException;
import com.mallocinc.shared.util.dbconnection.GDAODatabaseConnectionFactory;

import com.mallocinc.codegenerator.exceptions.GDAOException;
import com.mallocinc.shared.util.dbconnection.GDAODatabaseConnectionFactory;

import com.mallocinc.database.generated.working.VMonitoredAccountsTab;
import com.mallocinc.database.generated.to.VMonitoredAccountsTo;


/**********************************************************************
 *  <pre>
 *
 *  Generated Class: V_MONITORED_ACCOUNTSExcelSample.java
 * 
 *  This is sample class that demonstrates how GDAO Working class
 *  could be used to manipulate data in Excel spreadsheets.
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
 *  Template file:    /templates/Oracle/SampleExcelOracleTemplate.txt
 *  Target database:  Oracle 10g, 11g, 12c
 *
 *  "/templates/Oracle/SampleExcelOracleTemplate.txt" must be on the CLASSPATH
 *
 *  This code is generated on: 2017-February-20 03:28:22 PM CET
 *   
 *  Sample code demonstrates:
 *  - selecting, modifying, inserting and deleting data
 *  - modifying VIEW
 *  - batch updates
 *  - batch deletes
 *  - update and delete one records based on PK (or To object)
 *
 *  This is the template class used as a model to dynamically
 *  create similar class for every working class.
 *
 *  Sample GDAO code for VIEW "V_MONITORED_ACCOUNTS"
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
@SuppressWarnings("unused")
public class VMonitoredAccountsExcelSample {

   final static Logger log = Logger.getLogger(VMonitoredAccountsExcelSample.class.getName());

   final static String ENTITY_NAME = "V_MONITORED_ACCOUNTS";

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
    * main() method is used for unit testing
    *
    **********************************************************************/
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

         log.info("Current Directory -> " + System.getProperty("user.dir"));

         /**********************************************************************
          *
          * Read configuration from properties file
          *
          **********************************************************************/
         File propertiesFile = new File("conf/templates/Oracle/gdao_application.cfg");
         Configuration configuration = new PropertiesConfiguration(propertiesFile);
         String dbConnectionId = configuration.getString("db_connection_id");
         String excelTestFilesDirectory = configuration.getString("excel_test_files_directory");
         String excelFileSuffix = configuration.getString("excel_file_suffix");

         log.info("dbConnectionId = " + dbConnectionId);
         log.info("excelTestFilesDirectory = " + excelTestFilesDirectory);
         log.info("excelFileSuffix = " + excelFileSuffix);

         /**********************************************************************
          *
          * Use default DB connection file (1st line) or supply yours (2nd line)
          *
          **********************************************************************/
         GDAODatabaseConnectionFactory gDAODatabaseConnectionFactory = new GDAODatabaseConnectionFactory();
         /**********************************************************************
          *
          * Alternatively if directory where "dbconnections.txt" is located
          * is added as a "source" directory in eclipse
          *
          **********************************************************************/
         //GDAODatabaseConnectionFactory gDAODatabaseConnectionFactory = new GDAODatabaseConnectionFactory("/dbconnections.txt");

         connection = gDAODatabaseConnectionFactory.getConnection(dbConnectionId);

         VMonitoredAccountsExcelSample vMonitoredAccountsExcelSample = new VMonitoredAccountsExcelSample();

         String testFile = excelTestFilesDirectory + ENTITY_NAME + "." + excelFileSuffix;
         log.info("Test File = " + testFile);

         /**********************************************************************
          *
          * Uncomment test that you want to execute:
          *
          **********************************************************************/
         vMonitoredAccountsExcelSample.createExcelFileAsByteArray(connection, testFile);
         
         VMonitoredAccountsTab vMonitoredAccountsTab = new VMonitoredAccountsTab(connection);
         vMonitoredAccountsTab.deleteAllRecords();
         vMonitoredAccountsExcelSample.loadDataFromExcelFile(connection, testFile);
         
         //vMonitoredAccountsExcelSample.updateOrInsertDataFromExcelFile(connection, testFile);

         //V_MONITORED_ACCOUNTSExcelSample.updateOrInsertDataFromExcelFile(connection, testFile);

         if (connection != null && !connection.isClosed()) {
            connection.close();
         }
      } catch (SQLException e) {
         e.printStackTrace();
         String err="Problem occurred during processing: " + e.getMessage();
         log.error(err);
         //   throw new GDAOException(err);
      } catch (GDAOException e) {
         e.printStackTrace();
         String err="Problem occurred during processing: " + e.getMessage();
         log.error(err);
         //  throw new GDAOException(err);
      }
         catch (ConfigurationException e) {
         String err="Problem occurred during processing: " + "could not process Properties File";
         log.error(err);
         // throw new GDAOException(err);        
      } finally {
         try {
            if (connection != null && !connection.isClosed()) {
               connection.close();
               log.debug("Database connection is now closed.");
            }
         } catch (SQLException e) {
            e.printStackTrace();
            String err="Problem occurred while closing database connection.";
            log.error(err);
            // throw new GDAOException(err);
         }
      }
   }

   /**
    * 
    * Demonstrates saving data from the database VIEW into Excel File
    *
    *
    */
   private byte[] createExcelFileAsByteArray(Connection connection, String excelFileName) throws GDAOException {

      String whatWeAreDoing = "\"saveDataToExcelFile()\" for VIEW \"V_MONITORED_ACCOUNTS\"";

      log.debug("Starting " + whatWeAreDoing);

      XSSFWorkbook workbook = new XSSFWorkbook();
      int inserted = 0;

      VMonitoredAccountsTab vMonitoredAccountsTab = new VMonitoredAccountsTab(connection);

      try {
         XSSFSheet sheet = workbook.createSheet("V_MONITORED_ACCOUNTS");

         if (!vMonitoredAccountsTab.exists()) {
            String errMessage = "VIEW " + vMonitoredAccountsTab.getDbEntityName() + " does not exist.";
            log.error(errMessage);
            throw new GDAOException(errMessage);
         } else {
            log.debug("VIEW " + vMonitoredAccountsTab.getDbEntityName() + " exists.");
         }

         /**********************************************************************
          *
          * Use the following parameters in order to speed up SELECT
          * and to prevent program from failing because of exhausted memory
          *
          **********************************************************************/
         vMonitoredAccountsTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         vMonitoredAccountsTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

         /**********************************************************************
          *
          * Selects specific records from the VIEW:
          * Limit number of rows selected to "100" (just an example)
          *
          **********************************************************************/
         //vMonitoredAccountsTab.getResultSet("WHERE UPPER(CREDIT_DEBIT_CODE) LIKE ? AND ROWNUM < ?", "%A%", 100);

         /**********************************************************************
          *
          * Alternatively selects all records from the VIEW - no "WHERE" condition.
          * Both methods shown below are equal
          * Note that method "getAllRecordsRs()" can also accept a "where" clause, 
          * for example: 
          * 
          * getAllRecordsRs("where customer_type = 'REG'")
          * 
          **********************************************************************/
         //vMonitoredAccountsTabb.getResultSet(null, (Object[])null);
         vMonitoredAccountsTab.getAllRecordsRs();


         /**********************************************************************
          *
          * Create EXCEL Header
          *
          **********************************************************************/
         XSSFRow rowHeader = sheet.createRow(0);

         XSSFCell MONITOR_ID_cell = rowHeader.createCell(0);
MONITOR_ID_cell.setCellValue("MONITOR ID");
MONITOR_ID_cell.setCellStyle(getStyle("Header", workbook));

XSSFCell ACCOUNT_ID_cell = rowHeader.createCell(1);
ACCOUNT_ID_cell.setCellValue("ACCOUNT ID");
ACCOUNT_ID_cell.setCellStyle(getStyle("Header", workbook));

XSSFCell MONITOR_BANK_ID_cell = rowHeader.createCell(2);
MONITOR_BANK_ID_cell.setCellValue("MONITOR BANK ID");
MONITOR_BANK_ID_cell.setCellStyle(getStyle("Header", workbook));

XSSFCell MONITOR_BANK_NAME_cell = rowHeader.createCell(3);
MONITOR_BANK_NAME_cell.setCellValue("MONITOR BANK NAME");
MONITOR_BANK_NAME_cell.setCellStyle(getStyle("Header", workbook));

XSSFCell ACCOUNT_FIRST_NAME_cell = rowHeader.createCell(4);
ACCOUNT_FIRST_NAME_cell.setCellValue("ACCOUNT FIRST NAME");
ACCOUNT_FIRST_NAME_cell.setCellStyle(getStyle("Header", workbook));

XSSFCell ACCOUNT_LAST_NAME_cell = rowHeader.createCell(5);
ACCOUNT_LAST_NAME_cell.setCellValue("ACCOUNT LAST NAME");
ACCOUNT_LAST_NAME_cell.setCellStyle(getStyle("Header", workbook));

XSSFCell ACCOUNT_BANK_ID_cell = rowHeader.createCell(6);
ACCOUNT_BANK_ID_cell.setCellValue("ACCOUNT BANK ID");
ACCOUNT_BANK_ID_cell.setCellStyle(getStyle("Header", workbook));

XSSFCell ACCOUNT_BANK_NAME_cell = rowHeader.createCell(7);
ACCOUNT_BANK_NAME_cell.setCellValue("ACCOUNT BANK NAME");
ACCOUNT_BANK_NAME_cell.setCellStyle(getStyle("Header", workbook));

XSSFCell EMPLOYEE_ID_cell = rowHeader.createCell(8);
EMPLOYEE_ID_cell.setCellValue("EMPLOYEE ID");
EMPLOYEE_ID_cell.setCellStyle(getStyle("Header", workbook));

XSSFCell EMPLOYEE_FIRST_NAME_cell = rowHeader.createCell(9);
EMPLOYEE_FIRST_NAME_cell.setCellValue("EMPLOYEE FIRST NAME");
EMPLOYEE_FIRST_NAME_cell.setCellStyle(getStyle("Header", workbook));

XSSFCell EMPLOYEE_LAST_NAME_cell = rowHeader.createCell(10);
EMPLOYEE_LAST_NAME_cell.setCellValue("EMPLOYEE LAST NAME");
EMPLOYEE_LAST_NAME_cell.setCellStyle(getStyle("Header", workbook));

XSSFCell EMPLOYEE_BANK_NAME_cell = rowHeader.createCell(11);
EMPLOYEE_BANK_NAME_cell.setCellValue("EMPLOYEE BANK NAME");
EMPLOYEE_BANK_NAME_cell.setCellStyle(getStyle("Header", workbook));

XSSFCell MONITOR_PERMISSION_DATE_cell = rowHeader.createCell(12);
MONITOR_PERMISSION_DATE_cell.setCellValue("MONITOR PERMISSION DATE");
MONITOR_PERMISSION_DATE_cell.setCellStyle(getStyle("Header", workbook));

XSSFCell MONITOR_AS_OF_DATE_cell = rowHeader.createCell(13);
MONITOR_AS_OF_DATE_cell.setCellValue("MONITOR AS OF DATE");
MONITOR_AS_OF_DATE_cell.setCellStyle(getStyle("Header", workbook));

XSSFCell MONITOR_END_DATE_cell = rowHeader.createCell(14);
MONITOR_END_DATE_cell.setCellValue("MONITOR END DATE");
MONITOR_END_DATE_cell.setCellStyle(getStyle("Header", workbook));

XSSFCell MONITOR_COMMENT_cell = rowHeader.createCell(15);
MONITOR_COMMENT_cell.setCellValue("MONITOR COMMENT");
MONITOR_COMMENT_cell.setCellStyle(getStyle("Header", workbook));

XSSFCell MONITOR_STATUS_cell = rowHeader.createCell(16);
MONITOR_STATUS_cell.setCellValue("MONITOR STATUS");
MONITOR_STATUS_cell.setCellStyle(getStyle("Header", workbook));





         int row = 1;  // start with data in the row after the Excel Header  
         int column = 0;

         /**********************************************************************
          *
          * Loop through database result set:
          *
          **********************************************************************/
         while (vMonitoredAccountsTab.next()) {

            column = 0;
            inserted++;

            /**********************************************************************
             *
             * Print all values from the row in one line delimited by "; "
             *
             **********************************************************************/
            vMonitoredAccountsTab.print("; ");

            /**********************************************************************
             *
             * Add Excel cells into a Workbook row for this record:
             *
             **********************************************************************/
            XSSFRow currentRow = sheet.createRow(row);

            addStringCell(workbook, currentRow, column++, row, vMonitoredAccountsTab.getMONITOR_ID());
addStringCell(workbook, currentRow, column++, row, vMonitoredAccountsTab.getACCOUNT_ID());
addNumberCell(workbook, currentRow, column++, row, vMonitoredAccountsTab.getMONITOR_BANK_ID());
addStringCell(workbook, currentRow, column++, row, vMonitoredAccountsTab.getMONITOR_BANK_NAME());
addNumberCell(workbook, currentRow, column++, row, vMonitoredAccountsTab.getACCOUNT_FIRST_NAME());
addStringCell(workbook, currentRow, column++, row, vMonitoredAccountsTab.getACCOUNT_LAST_NAME());
addStringCell(workbook, currentRow, column++, row, vMonitoredAccountsTab.getACCOUNT_BANK_ID());
addNumberCell(workbook, currentRow, column++, row, vMonitoredAccountsTab.getACCOUNT_BANK_NAME());
addStringCell(workbook, currentRow, column++, row, vMonitoredAccountsTab.getEMPLOYEE_ID());
addStringCell(workbook, currentRow, column++, row, vMonitoredAccountsTab.getEMPLOYEE_FIRST_NAME());
addStringCell(workbook, currentRow, column++, row, vMonitoredAccountsTab.getEMPLOYEE_LAST_NAME());
addStringCell(workbook, currentRow, column++, row, vMonitoredAccountsTab.getEMPLOYEE_BANK_NAME());
addStringCell(workbook, currentRow, column++, row, vMonitoredAccountsTab.getMONITOR_PERMISSION_DATE());
addTimestampCell(workbook, currentRow, column++, row, vMonitoredAccountsTab.getMONITOR_AS_OF_DATE());
addTimestampCell(workbook, currentRow, column++, row, vMonitoredAccountsTab.getMONITOR_END_DATE());
addTimestampCell(workbook, currentRow, column++, row, vMonitoredAccountsTab.getMONITOR_COMMENT());
addStringCell(workbook, currentRow, column++, row, vMonitoredAccountsTab.getMONITOR_STATUS());


            row++;
         }


         /**********************************************************************
          *
          * Set EXCEL column to be "Auto-size"
          *
          **********************************************************************/
         sheet.autoSizeColumn(0);
sheet.autoSizeColumn(1);
sheet.autoSizeColumn(2);
sheet.autoSizeColumn(3);
sheet.autoSizeColumn(4);
sheet.autoSizeColumn(5);
sheet.autoSizeColumn(6);
sheet.autoSizeColumn(7);
sheet.autoSizeColumn(8);
sheet.autoSizeColumn(9);
sheet.autoSizeColumn(10);
sheet.autoSizeColumn(11);
sheet.autoSizeColumn(12);
sheet.autoSizeColumn(13);
sheet.autoSizeColumn(14);
sheet.autoSizeColumn(15);
sheet.autoSizeColumn(16);



         log.info("Created " + inserted + " records in spreadheet \"" + excelFileName + "\"");


         ByteArrayOutputStream bos = new ByteArrayOutputStream();

         //write this workbook to an Outputstream.
         try {
            workbook.write(bos);
         } catch (IOException e) {
            e.printStackTrace();  
            log.error("Cannot write workbook to byte[] output stream for VIEW \"V_MONITORED_ACCOUNTS\".");
            throw new GDAOException(e);
         }

         byte[] bytes = bos.toByteArray();
         return bytes;

      }  finally {
         vMonitoredAccountsTab.releaseStatement();
         try {
            workbook.close();
         } catch (IOException e) {
            log.error("Cannot close workbook for VIEW \"V_MONITORED_ACCOUNTS\".");
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }


   /**********************************************************************
    *
    *  Demonstrates Loading Data from Excel File to 
    *  VIEW \"V_MONITORED_ACCOUNTS\". 
    *
    *  It is assumed that the first row of the spreadsheet is a header row
    *  so it is always skipped.
    *
    * @param  Connection   Database connection
    * @param  String       Excel File name 
    *
    * @throws GDAOException
    *
    **********************************************************************/
   private void loadDataFromExcelFile(Connection connection, String excelFileName) throws GDAOException{

      String whatWeAreDoing = "\"loadDataFromExcelFile()\" for VIEW \"V_MONITORED_ACCOUNTS\"";
      log.debug("Starting " + whatWeAreDoing);

      Workbook workbook = null;
      int row = 0;
      int column = 0;
      int inserted = 0;
      int errors = 0;

      try {
         workbook = WorkbookFactory.create(new File(excelFileName));

         Sheet sheet = workbook.getSheetAt(0); //open first sheet in workbook

         int rows = sheet.getLastRowNum();
         int columns = sheet.getRow(0).getLastCellNum();

         log.info("Spreadsheet has " + rows + " rows and " + columns + " columns");

         VMonitoredAccountsTab vMonitoredAccountsTab = new VMonitoredAccountsTab(connection);

         if (!vMonitoredAccountsTab.exists()) {
            String errMessage = "VIEW " + vMonitoredAccountsTab.getDbEntityName() + " does not exist.";
            log.error(errMessage);
            throw new GDAOException(errMessage);
         } else {
            log.debug("VIEW " + vMonitoredAccountsTab.getDbEntityName() + " exists.");
         }

         if (rows > 0 && columns > 0) {
            for (row = 1; row < rows; row++) { // skip first row since it is header row
                  Row currentRow =sheet.getRow(row);
                  
                  int rowColumn = 0;
                  
                        vMonitoredAccountsTab.setMONITOR_ID(getString(currentRow.getCell(0)));
      vMonitoredAccountsTab.setACCOUNT_ID(getString(currentRow.getCell(1)));
      vMonitoredAccountsTab.setMONITOR_BANK_ID(getNumber(currentRow.getCell(2)));
      vMonitoredAccountsTab.setMONITOR_BANK_NAME(getString(currentRow.getCell(3)));
      vMonitoredAccountsTab.setACCOUNT_FIRST_NAME(getNumber(currentRow.getCell(4)));
      vMonitoredAccountsTab.setACCOUNT_LAST_NAME(getString(currentRow.getCell(5)));
      vMonitoredAccountsTab.setACCOUNT_BANK_ID(getString(currentRow.getCell(6)));
      vMonitoredAccountsTab.setACCOUNT_BANK_NAME(getNumber(currentRow.getCell(7)));
      vMonitoredAccountsTab.setEMPLOYEE_ID(getString(currentRow.getCell(8)));
      vMonitoredAccountsTab.setEMPLOYEE_FIRST_NAME(getString(currentRow.getCell(9)));
      vMonitoredAccountsTab.setEMPLOYEE_LAST_NAME(getString(currentRow.getCell(10)));
      vMonitoredAccountsTab.setEMPLOYEE_BANK_NAME(getString(currentRow.getCell(11)));
      vMonitoredAccountsTab.setMONITOR_PERMISSION_DATE(getString(currentRow.getCell(12)));
      vMonitoredAccountsTab.setMONITOR_AS_OF_DATE(getTimestamp(currentRow.getCell(13)));
      vMonitoredAccountsTab.setMONITOR_END_DATE(getTimestamp(currentRow.getCell(14)));
      vMonitoredAccountsTab.setMONITOR_COMMENT(getTimestamp(currentRow.getCell(15)));
      vMonitoredAccountsTab.setMONITOR_STATUS(getString(currentRow.getCell(16)));

               

               try {
                  vMonitoredAccountsTab.print(";");
                  vMonitoredAccountsTab.insertThisRecord();
                  inserted++;
               } catch (GDAOException e) {
                  log.error("----------------------");
                  String err="ERROR occurred on row :" + row;
                  errors++;
                  e.printStackTrace();
                  throw new GDAOException(err);
               }
            }
         }

         connection.commit();
         workbook.close();

         long rowCount = vMonitoredAccountsTab.getRowCount();

         log.info("Inserted Records in VIEW V_MONITORED_ACCOUNTS DB: " + inserted);
         log.info("Total errors: " + errors);
         log.info("Total row count in VIEW \"V_MONITORED_ACCOUNTS\" is " + rowCount);

      } catch (SQLException e) {
         e.printStackTrace();
         throw new GDAOException(e.getMessage());
      } catch (GDAOException e) {
         e.printStackTrace();
         throw new GDAOException(e.getMessage());
      } catch (IOException e) {
         e.printStackTrace();
         throw new GDAOException(e.getMessage());
      } catch (InvalidFormatException e) {
         e.printStackTrace();
         throw new GDAOException(e.getMessage());
      }

      log.debug("Finished " + whatWeAreDoing);

   }




   /**********************************************************************
    *
    *  VIEW V_MONITORED_ACCOUNTS
    *
    *  Demonstrates Loading Data from Excel File:
    *  1. If record exists it is updated
    *  2. If record does not exist it is inserted
    *  
    *  Primary Key is used to find a matching record.
    *  GDAO Automatically recognizes Primary Key
    *
    * @param  Connection   Database connection
    * @param  String       Excel File name 
    *   
    * @throws GDAOException
    *
    **********************************************************************/
   private void updateOrInsertDataFromExcelFile(Connection connection, String excelFileName) throws GDAOException {

      String whatWeAreDoing = "\"updateOrInsertDataFromExcelFile()\" for VIEW \"V_MONITORED_ACCOUNTS\"";
      log.debug("Starting " + whatWeAreDoing);

      Workbook workbook = null;
      int row = 0;
      int column = 0;
      int inserted = 0;
      int updated = 0;
      int errors = 0;

      try {
         workbook = WorkbookFactory.create(new File(excelFileName));

         Sheet sheet = workbook.getSheetAt(0); //open first sheet in workbook

         int rows = sheet.getLastRowNum();
         int columns = sheet.getRow(0).getLastCellNum();

         log.info("Spreadsheet has " + rows + " rows and " + columns + " columns");

         VMonitoredAccountsTab vMonitoredAccountsTab = new VMonitoredAccountsTab(connection);

         if (!vMonitoredAccountsTab.exists()) {
            String errMessage = "VIEW " + vMonitoredAccountsTab.getDbEntityName() + " does not exist.";
            log.error(errMessage);
            throw new GDAOException(errMessage);
         } else {
            log.debug("VIEW " + vMonitoredAccountsTab.getDbEntityName() + " exists.");
         }

         if (rows > 0 && columns > 0) {
            for (row = 1; row < rows; row++) { // skip first row since it is header row
               Row currentRow =sheet.getRow(row);
               
               int rowColumn = 0;
               
                     vMonitoredAccountsTab.setMONITOR_ID(getString(currentRow.getCell(0)));
      vMonitoredAccountsTab.setACCOUNT_ID(getString(currentRow.getCell(1)));
      vMonitoredAccountsTab.setMONITOR_BANK_ID(getNumber(currentRow.getCell(2)));
      vMonitoredAccountsTab.setMONITOR_BANK_NAME(getString(currentRow.getCell(3)));
      vMonitoredAccountsTab.setACCOUNT_FIRST_NAME(getNumber(currentRow.getCell(4)));
      vMonitoredAccountsTab.setACCOUNT_LAST_NAME(getString(currentRow.getCell(5)));
      vMonitoredAccountsTab.setACCOUNT_BANK_ID(getString(currentRow.getCell(6)));
      vMonitoredAccountsTab.setACCOUNT_BANK_NAME(getNumber(currentRow.getCell(7)));
      vMonitoredAccountsTab.setEMPLOYEE_ID(getString(currentRow.getCell(8)));
      vMonitoredAccountsTab.setEMPLOYEE_FIRST_NAME(getString(currentRow.getCell(9)));
      vMonitoredAccountsTab.setEMPLOYEE_LAST_NAME(getString(currentRow.getCell(10)));
      vMonitoredAccountsTab.setEMPLOYEE_BANK_NAME(getString(currentRow.getCell(11)));
      vMonitoredAccountsTab.setMONITOR_PERMISSION_DATE(getString(currentRow.getCell(12)));
      vMonitoredAccountsTab.setMONITOR_AS_OF_DATE(getTimestamp(currentRow.getCell(13)));
      vMonitoredAccountsTab.setMONITOR_END_DATE(getTimestamp(currentRow.getCell(14)));
      vMonitoredAccountsTab.setMONITOR_COMMENT(getTimestamp(currentRow.getCell(15)));
      vMonitoredAccountsTab.setMONITOR_STATUS(getString(currentRow.getCell(16)));


               vMonitoredAccountsTab.print(";");

               int recordsUpdated = 0;

               /**********************************************************************
                *
                * Try to update this record. If it could not be updates then record
                * does not exist and it has to be inserted.
                *
                **********************************************************************/
               try {
                  recordsUpdated = vMonitoredAccountsTab.updateThisRecord();
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
                     vMonitoredAccountsTab.insertThisRecord();
                     inserted++;
                  } else {
                     updated++;
                  }

               } catch (GDAOException e) {
                  log.error("----------------------");
                  log.error("ERROR occurred in row :" + row);
                  errors++;
                  e.printStackTrace();
               }
            }
         }

         connection.commit();
         workbook.close();

         long rowCount = vMonitoredAccountsTab.getRowCount();

         log.info("Inserted Records in VIEW V_MONITORED_ACCOUNTS DB: " + inserted);
         log.info("Updated Records in VIEW V_MONITORED_ACCOUNTS DB: " + updated);
         log.info("Total errors: " + errors);
         log.info("Row Count (VIEW V_MONITORED_ACCOUNTS) =" + rowCount);

      } catch (SQLException e) {
         e.printStackTrace();
         throw new GDAOException(e.getMessage());
      } catch (GDAOException e) {
         e.printStackTrace();
         throw new GDAOException(e.getMessage());
      } catch (IOException e) {
         e.printStackTrace();
         throw new GDAOException(e.getMessage());
      } catch (InvalidFormatException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
         throw new GDAOException(e.getMessage());
      }

      log.debug("Finished " + whatWeAreDoing);
   }


   /**********************************************************************
    * 
    * Utility method for adding String value in the spreadheet cell
    *
    * @param  WriTABLESheet    worksheet
    * @param  int              worksheet column
    * @param  int              worksheet row
    * @param  String           value to be set in the cell
    * @throws RowsExceededException
    * @throws WriteException
    *
    **********************************************************************/
   private void addStringCell(Workbook workbook, XSSFRow currentRow, int column, int row, String value) {
      XSSFCell cell = currentRow.createCell(column);
      //cell.setCellStyle(getStyle("Data", workbook));
      
      if (value == null) {
         return;
      } else {
         cell.setCellValue(value);
      }
   }

   /**********************************************************************
    * 
    * Utility method for adding numeric value in the spreadheet cell
    *
    * @param  WriTABLESheet    worksheet
    * @param  int              worksheet column
    * @param  int              worksheet row
    * @param  BigDecimal       value to be set in the cell
    * @throws RowsExceededException
    * @throws WriteException
    *
    **********************************************************************/
   private void addNumberCell(Workbook workbook, XSSFRow currentRow, int column, int row, BigDecimal value) {
      XSSFCell cell = currentRow.createCell(column);
      //cell.setCellStyle(getStyle("Data", workbook));
      
      if (value == null) {
         return;
      } else {
         cell.setCellValue(value.doubleValue());
      }
   }

   /**********************************************************************
    * 
    * Utility method for adding Timestamp value in the spreadheet cell
    *
    * @param  WritableSheet    worksheet
    * @param  int              worksheet column
    * @param  int              worksheet row
    * @param  Timestamp        value to be set in the cell
    * @throws RowsExceededException
    * @throws WriteException
    *
    **********************************************************************/
   private void addTimestampCell(Workbook workbook, XSSFRow currentRow, int column, int row, Timestamp value) {
      XSSFCell cell = currentRow.createCell(column);
      //cell.setCellStyle(getStyle("Data", workbook));
      
      if (value == null) {
         return;
      } else {
         cell.setCellValue(value.toString());
      }
   }

   /**********************************************************************
    * 
    * Utility method for getting String value from the spreadheet cell
    *
    * @param  Cell    worksheet cell
    * @return String
    *
    **********************************************************************/
   private String getString(Cell cell) {
      try {
      return cell.getStringCellValue();
      } catch (NullPointerException e) {
         return null;
      }
   }

   /**********************************************************************
    * 
    * Utility method for getting numeric value from the spreadheet cell
    *
    * @param  Cell    worksheet cell
    * @return BigDecimal
    *
    **********************************************************************/
   private BigDecimal getNumber(Cell cell) {
      try {
      return new BigDecimal(cell.getNumericCellValue());
      } catch (NullPointerException e) {
         return null;
      }
   }

   /**********************************************************************
    * 
    * Utility method for getting Timestamp value from the spreadheet cell
    *
    * @param  Cell    worksheet cell
    * @return Timestamp
    *
    **********************************************************************/
   private Timestamp getTimestamp(Cell cell) {
      try {
      return new Timestamp(cell.getDateCellValue().getTime());
      } catch (NullPointerException e) {
         return null;
      }
   }

   public CellStyle getStyle(String styleName, Workbook workbook) {
      Map<String, CellStyle> styles = new HashMap<String, CellStyle>();

      CellStyle headerStyle;
      Font headerFont = workbook.createFont();
      headerStyle = createBorderedStyle(workbook);
      headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
      headerStyle.setAlignment(CellStyle.ALIGN_CENTER);
      headerStyle.setFont(headerFont);
      headerStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
      headerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND); 
      styles.put("Header", headerStyle);

      CellStyle dataStyle;
      dataStyle = createBorderedStyle(workbook);
      dataStyle.setAlignment(CellStyle.ALIGN_CENTER);

      styles.put("Data", dataStyle);

      switch (styleName) {
         case "Header": {
            return styles.get("Header");
         }
         case "Data": {
            return styles.get("Data");
         }
         default: {
            return styles.get("Data");
         }
      }
   }

   private CellStyle createBorderedStyle(Workbook wb) {
      CellStyle style = wb.createCellStyle();
      style.setBorderRight(CellStyle.BORDER_THIN);
      style.setRightBorderColor(IndexedColors.BLACK.getIndex());
      style.setBorderBottom(CellStyle.BORDER_THIN);
      style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
      style.setBorderLeft(CellStyle.BORDER_THIN);
      style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
      style.setBorderTop(CellStyle.BORDER_THIN);
      style.setTopBorderColor(IndexedColors.BLACK.getIndex());
      return style;
   }
}
