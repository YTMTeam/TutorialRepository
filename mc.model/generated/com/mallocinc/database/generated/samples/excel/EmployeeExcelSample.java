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

import com.mallocinc.database.generated.working.EmployeeTab;
import com.mallocinc.database.generated.to.EmployeeTo;


/**********************************************************************
 *  <pre>
 *
 *  Generated Class: EMPLOYEEExcelSample.java
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
 *  - modifying TABLE
 *  - batch updates
 *  - batch deletes
 *  - update and delete one records based on PK (or To object)
 *
 *  This is the template class used as a model to dynamically
 *  create similar class for every working class.
 *
 *  Sample GDAO code for TABLE "EMPLOYEE"
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
public class EmployeeExcelSample {

   final static Logger log = Logger.getLogger(EmployeeExcelSample.class.getName());

   final static String ENTITY_NAME = "EMPLOYEE";

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

         EmployeeExcelSample employeeExcelSample = new EmployeeExcelSample();

         String testFile = excelTestFilesDirectory + ENTITY_NAME + "." + excelFileSuffix;
         log.info("Test File = " + testFile);

         /**********************************************************************
          *
          * Uncomment test that you want to execute:
          *
          **********************************************************************/
         employeeExcelSample.createExcelFileAsByteArray(connection, testFile);
         
         EmployeeTab employeeTab = new EmployeeTab(connection);
         employeeTab.deleteAllRecords();
         employeeExcelSample.loadDataFromExcelFile(connection, testFile);
         
         //employeeExcelSample.updateOrInsertDataFromExcelFile(connection, testFile);

         //EMPLOYEEExcelSample.updateOrInsertDataFromExcelFile(connection, testFile);

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
    * Demonstrates saving data from the database TABLE into Excel File
    *
    *
    */
   private byte[] createExcelFileAsByteArray(Connection connection, String excelFileName) throws GDAOException {

      String whatWeAreDoing = "\"saveDataToExcelFile()\" for TABLE \"EMPLOYEE\"";

      log.debug("Starting " + whatWeAreDoing);

      XSSFWorkbook workbook = new XSSFWorkbook();
      int inserted = 0;

      EmployeeTab employeeTab = new EmployeeTab(connection);

      try {
         XSSFSheet sheet = workbook.createSheet("EMPLOYEE");

         if (!employeeTab.exists()) {
            String errMessage = "TABLE " + employeeTab.getDbEntityName() + " does not exist.";
            log.error(errMessage);
            throw new GDAOException(errMessage);
         } else {
            log.debug("TABLE " + employeeTab.getDbEntityName() + " exists.");
         }

         /**********************************************************************
          *
          * Use the following parameters in order to speed up SELECT
          * and to prevent program from failing because of exhausted memory
          *
          **********************************************************************/
         employeeTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         employeeTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

         /**********************************************************************
          *
          * Selects specific records from the TABLE:
          * Limit number of rows selected to "100" (just an example)
          *
          **********************************************************************/
         //employeeTab.getResultSet("WHERE UPPER(CREDIT_DEBIT_CODE) LIKE ? AND ROWNUM < ?", "%A%", 100);

         /**********************************************************************
          *
          * Alternatively selects all records from the TABLE - no "WHERE" condition.
          * Both methods shown below are equal
          * Note that method "getAllRecordsRs()" can also accept a "where" clause, 
          * for example: 
          * 
          * getAllRecordsRs("where customer_type = 'REG'")
          * 
          **********************************************************************/
         //employeeTabb.getResultSet(null, (Object[])null);
         employeeTab.getAllRecordsRs();


         /**********************************************************************
          *
          * Create EXCEL Header
          *
          **********************************************************************/
         XSSFRow rowHeader = sheet.createRow(0);

         XSSFCell EMPLOYEE_ID_cell = rowHeader.createCell(0);
EMPLOYEE_ID_cell.setCellValue("EMPLOYEE ID");
EMPLOYEE_ID_cell.setCellStyle(getStyle("Header", workbook));

XSSFCell BANK_ID_cell = rowHeader.createCell(1);
BANK_ID_cell.setCellValue("BANK ID");
BANK_ID_cell.setCellStyle(getStyle("Header", workbook));

XSSFCell FIRST_NAME_cell = rowHeader.createCell(2);
FIRST_NAME_cell.setCellValue("FIRST NAME");
FIRST_NAME_cell.setCellStyle(getStyle("Header", workbook));

XSSFCell MIDDLE_NAME_cell = rowHeader.createCell(3);
MIDDLE_NAME_cell.setCellValue("MIDDLE NAME");
MIDDLE_NAME_cell.setCellStyle(getStyle("Header", workbook));

XSSFCell LAST_NAME_cell = rowHeader.createCell(4);
LAST_NAME_cell.setCellValue("LAST NAME");
LAST_NAME_cell.setCellStyle(getStyle("Header", workbook));

XSSFCell EMPLOYING_INSTITUTION_cell = rowHeader.createCell(5);
EMPLOYING_INSTITUTION_cell.setCellValue("EMPLOYING INSTITUTION");
EMPLOYING_INSTITUTION_cell.setCellStyle(getStyle("Header", workbook));





         int row = 1;  // start with data in the row after the Excel Header  
         int column = 0;

         /**********************************************************************
          *
          * Loop through database result set:
          *
          **********************************************************************/
         while (employeeTab.next()) {

            column = 0;
            inserted++;

            /**********************************************************************
             *
             * Print all values from the row in one line delimited by "; "
             *
             **********************************************************************/
            employeeTab.print("; ");

            /**********************************************************************
             *
             * Add Excel cells into a Workbook row for this record:
             *
             **********************************************************************/
            XSSFRow currentRow = sheet.createRow(row);

            addStringCell(workbook, currentRow, column++, row, employeeTab.getEMPLOYEE_ID());
addNumberCell(workbook, currentRow, column++, row, employeeTab.getBANK_ID());
addStringCell(workbook, currentRow, column++, row, employeeTab.getFIRST_NAME());
addStringCell(workbook, currentRow, column++, row, employeeTab.getMIDDLE_NAME());
addStringCell(workbook, currentRow, column++, row, employeeTab.getLAST_NAME());
addStringCell(workbook, currentRow, column++, row, employeeTab.getEMPLOYING_INSTITUTION());


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



         log.info("Created " + inserted + " records in spreadheet \"" + excelFileName + "\"");


         ByteArrayOutputStream bos = new ByteArrayOutputStream();

         //write this workbook to an Outputstream.
         try {
            workbook.write(bos);
         } catch (IOException e) {
            e.printStackTrace();  
            log.error("Cannot write workbook to byte[] output stream for TABLE \"EMPLOYEE\".");
            throw new GDAOException(e);
         }

         byte[] bytes = bos.toByteArray();
         return bytes;

      }  finally {
         employeeTab.releaseStatement();
         try {
            workbook.close();
         } catch (IOException e) {
            log.error("Cannot close workbook for TABLE \"EMPLOYEE\".");
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }


   /**********************************************************************
    *
    *  Demonstrates Loading Data from Excel File to 
    *  TABLE \"EMPLOYEE\". 
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

      String whatWeAreDoing = "\"loadDataFromExcelFile()\" for TABLE \"EMPLOYEE\"";
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

         EmployeeTab employeeTab = new EmployeeTab(connection);

         if (!employeeTab.exists()) {
            String errMessage = "TABLE " + employeeTab.getDbEntityName() + " does not exist.";
            log.error(errMessage);
            throw new GDAOException(errMessage);
         } else {
            log.debug("TABLE " + employeeTab.getDbEntityName() + " exists.");
         }

         if (rows > 0 && columns > 0) {
            for (row = 1; row < rows; row++) { // skip first row since it is header row
                  Row currentRow =sheet.getRow(row);
                  
                  int rowColumn = 0;
                  
                        employeeTab.setEMPLOYEE_ID(getString(currentRow.getCell(0)));
      employeeTab.setBANK_ID(getNumber(currentRow.getCell(1)));
      employeeTab.setFIRST_NAME(getString(currentRow.getCell(2)));
      employeeTab.setMIDDLE_NAME(getString(currentRow.getCell(3)));
      employeeTab.setLAST_NAME(getString(currentRow.getCell(4)));
      employeeTab.setEMPLOYING_INSTITUTION(getString(currentRow.getCell(5)));

               

               try {
                  employeeTab.print(";");
                  employeeTab.insertThisRecord();
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

         long rowCount = employeeTab.getRowCount();

         log.info("Inserted Records in TABLE EMPLOYEE DB: " + inserted);
         log.info("Total errors: " + errors);
         log.info("Total row count in TABLE \"EMPLOYEE\" is " + rowCount);

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
    *  TABLE EMPLOYEE
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

      String whatWeAreDoing = "\"updateOrInsertDataFromExcelFile()\" for TABLE \"EMPLOYEE\"";
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

         EmployeeTab employeeTab = new EmployeeTab(connection);

         if (!employeeTab.exists()) {
            String errMessage = "TABLE " + employeeTab.getDbEntityName() + " does not exist.";
            log.error(errMessage);
            throw new GDAOException(errMessage);
         } else {
            log.debug("TABLE " + employeeTab.getDbEntityName() + " exists.");
         }

         if (rows > 0 && columns > 0) {
            for (row = 1; row < rows; row++) { // skip first row since it is header row
               Row currentRow =sheet.getRow(row);
               
               int rowColumn = 0;
               
                     employeeTab.setEMPLOYEE_ID(getString(currentRow.getCell(0)));
      employeeTab.setBANK_ID(getNumber(currentRow.getCell(1)));
      employeeTab.setFIRST_NAME(getString(currentRow.getCell(2)));
      employeeTab.setMIDDLE_NAME(getString(currentRow.getCell(3)));
      employeeTab.setLAST_NAME(getString(currentRow.getCell(4)));
      employeeTab.setEMPLOYING_INSTITUTION(getString(currentRow.getCell(5)));


               employeeTab.print(";");

               int recordsUpdated = 0;

               /**********************************************************************
                *
                * Try to update this record. If it could not be updates then record
                * does not exist and it has to be inserted.
                *
                **********************************************************************/
               try {
                  recordsUpdated = employeeTab.updateThisRecord();
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
                     employeeTab.insertThisRecord();
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

         long rowCount = employeeTab.getRowCount();

         log.info("Inserted Records in TABLE EMPLOYEE DB: " + inserted);
         log.info("Updated Records in TABLE EMPLOYEE DB: " + updated);
         log.info("Total errors: " + errors);
         log.info("Row Count (TABLE EMPLOYEE) =" + rowCount);

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
