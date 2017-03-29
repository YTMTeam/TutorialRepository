package com.mallocinc.database.generated.samples.excel;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import jxl.Cell;
import jxl.CellView;
import jxl.DateCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.read.biff.BiffException;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import org.apache.log4j.Logger;

import com.mallocinc.codegenerator.exceptions.GDAOException;
import com.mallocinc.shared.util.dbconnection.GDAODatabaseConnectionFactory;

import com.mallocinc.database.generated.working.HouseholdTab;
import com.mallocinc.database.generated.to.HouseholdTo;

 
/**********************************************************************
 *  <pre>
 *
 *  Generated Class: HouseholdExcelSample.java
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
 *  This code is generated on: 2017-February-13 05:34:30 PM CET
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
 *  Sample GDAO code for TABLE "HOUSEHOLD"
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
public class HouseholdExcelSample {

   final static Logger log = Logger.getLogger(HouseholdExcelSample.class.getName());
   
   final static String ENTITY_NAME = "HOUSEHOLD";
   
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

        HouseholdExcelSample householdExcelSample = new HouseholdExcelSample();

        String testFile = excelTestFilesDirectory + ENTITY_NAME + "." + excelFileSuffix;
        log.info("Test File = " + testFile);

        /**********************************************************************
         *
         * Uncomment test that you want to execute:
         *
         **********************************************************************/
         householdExcelSample.saveDataToExcelFile(connection, testFile);
         
         HouseholdTab householdTab = new HouseholdTab(connection);
         householdTab.deleteAllRecords();
         householdExcelSample.loadDataFromExcelFile(connection, testFile);
         
         //householdExcelSample.updateOrInsertDataFromExcelFile(connection, testFile);

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
      } catch (ConfigurationException e) {
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
   * Demonstrates saving data from the database table into Excel File
   *
   *
   */
   private void saveDataToExcelFile(Connection connection, String excelFileName) throws GDAOException {

      String whatWeAreDoing = "\"saveDataToExcelFile()\" for TABLE \"HOUSEHOLD\"";

      log.debug("Starting " + whatWeAreDoing);

      WritableWorkbook writableWorkbook = null;
      int inserted = 0;

      HouseholdTab householdTab = new HouseholdTab(connection);

      try {

         writableWorkbook = Workbook.createWorkbook(new File(excelFileName));

         WritableSheet writableSheet = writableWorkbook.createSheet("HOUSEHOLD", 0);

         if (!householdTab.exists()) {
            String errMessage = "Table " + householdTab.getDbEntityName() + " does not exist.";
            log.error(errMessage);
            throw new GDAOException(errMessage);
         } else {
            log.debug("Table " + householdTab.getDbEntityName() + " exists.");
         }

         /**********************************************************************
          *
          * Use the following parameters in order to speed up SELECT
          * and to prevent program from failing because of exhausted memory
          *
          **********************************************************************/
         householdTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         householdTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

         /**********************************************************************
          *
          * Selects specific records from the table:
          * Limit number of rows selected to "100" (just an example)
          *
          **********************************************************************/
         //householdTab.getResultSet("WHERE UPPER(CREDIT_DEBIT_CODE) LIKE ? AND ROWNUM < ?", "%A%", 100);
         
         /**********************************************************************
          *
          * Alternatively selects all records from the table - no "WHERE" condition.
          * Both methods shown below are equal
          * Note that method "getAllRecordsRs()" can also accept a "where" clause, 
          * for example: 
          * 
          * getAllRecordsRs("where customer_type = 'REG'")
          * 
          **********************************************************************/
         //householdTabb.getResultSet(null, (Object[])null);
         householdTab.getAllRecordsRs();
         

        /**********************************************************************
         *
         * Set format for the Header Cells
         *
         **********************************************************************/
         WritableFont font = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
         font.setColour(Colour.BLACK);
         WritableCellFormat cellFormat = new WritableCellFormat(font);
         cellFormat.setBackground(Colour.GRAY_25);
         cellFormat.setAlignment(Alignment.CENTRE);
         cellFormat.setBorder(Border.ALL, BorderLineStyle.MEDIUM);
         
         //Alternative way:
         //CellView cellViewForHeaderRow = new CellView();
         //cellViewForHeaderRow.setFormat(cellFormat);

         /**********************************************************************
          *
          * Create EXCEL Header
          *
          **********************************************************************/
         writableSheet.addCell(new jxl.write.Label(0, 0,"HOUSEHOLD_ID", cellFormat));
writableSheet.addCell(new jxl.write.Label(1, 0,"HOUSEHOLD_NAME", cellFormat));

         
         /**********************************************************************
          *
          * Freeze Header row
          *
          **********************************************************************/
         writableSheet.getSettings().setVerticalFreeze(1);    
         
          /**********************************************************************
          *
          * Set EXCEL column to be "Auto-size"
          *
          **********************************************************************/
          CellView cv = new CellView(); 
          cv.setAutosize(true);

          writableSheet.setColumnView(0, cv);
writableSheet.setColumnView(1, cv);


         int row = 1;  // start with data in the row after the Excel Header  
         int column = 0;

         /**********************************************************************
          *
          * Loop through database result set:
          *
          **********************************************************************/
         while (householdTab.next()) {

            column = 0;
            inserted++;

            /**********************************************************************
            *
            * Print all values from the row in one line delimited by "; "
            *
            **********************************************************************/
            householdTab.print("; ");

            /**********************************************************************
            *
            * Add Excel cells into a Workbook row for this record:
            *
            **********************************************************************/

            addNumberCell(writableSheet, column++, row, householdTab.getHOUSEHOLD_ID());
addStringCell(writableSheet, column++, row, householdTab.getHOUSEHOLD_NAME());


            row++;
         }

         writableWorkbook.write();
         writableWorkbook.close();

         log.info("Created " + inserted + " records in spreadheet \"" + excelFileName + "\"");

         log.debug("Finished " + whatWeAreDoing + ".");
      } catch (IOException e) {
         e.printStackTrace();
      } catch (WriteException e) {
         e.printStackTrace();
      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot select from TABLE \"HOUSEHOLD\".");
         throw new GDAOException(e);
      } finally {
         householdTab.releaseStatement();
      }

      log.debug(whatWeAreDoing);
   }


  /**********************************************************************
   *
   *  Demonstrates Loading Data from Excel File to 
   *  TABLE \"HOUSEHOLD\". 
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

      String whatWeAreDoing = "\"loadDataFromExcelFile()\" for TABLE \"HOUSEHOLD\"";
      log.debug("Starting " + whatWeAreDoing);

      Workbook workbook = null;
      int row = 0;
      int column = 0;
      int inserted = 0;
      int errors = 0;

      try {
         workbook = Workbook.getWorkbook(new File(excelFileName));

         Sheet sheet = workbook.getSheet(0); //open first sheet in workbook

         int rows = sheet.getRows();
         int columns = sheet.getColumns();

         log.info("Spreadsheet has " + rows + " rows and " + columns + " columns");

         HouseholdTab householdTab = new HouseholdTab(connection);

         if (!householdTab.exists()) {
            String errMessage = "TABLE " + householdTab.getDbEntityName() + " does not exist.";
            log.error(errMessage);
            throw new GDAOException(errMessage);
         } else {
            log.debug("TABLE " + householdTab.getDbEntityName() + " exists.");
         }

         if (rows > 0 && columns > 0) {
            for (row = 1; row < rows; row++) { // skip first row since it is header row
               for (column = 0; column < columns; column++) { 
                  Cell cell = sheet.getCell(column, row);
                  String cellContent = cell.getContents();
                  log.debug("Cell[" + column + "," + row + "]=" + cellContent);

                        householdTab.setHOUSEHOLD_ID(getNumber(sheet.getCell(0, row)));
      householdTab.setHOUSEHOLD_NAME(getString(sheet.getCell(1, row)));

               }
                
               try {
                  householdTab.print(";");
                  householdTab.insertThisRecord();
                  inserted++;
               } catch (GDAOException e) {
                  log.error("----------------------");
                  String err="ERROR occurred on row :" + row + " with first four columns:";
                  log.error(err);
                  log.error(sheet.getCell(0, row).getContents());
                  log.error(sheet.getCell(1, row).getContents());
                  log.error(sheet.getCell(2, row).getContents());
                  log.error(sheet.getCell(3, row).getContents());
                  errors++;
                  e.printStackTrace();
                  throw new GDAOException(err);
               }
            }
         }

         connection.commit();
         workbook.close();

         long rowCount = householdTab.getRowCount();

         log.info("Inserted Records in TABLE HOUSEHOLD DB: " + inserted);
         log.info("Total errors: " + errors);
         log.info("Total row count in TABLE \"HOUSEHOLD\" is " + rowCount);

      } catch (SQLException e) {
         e.printStackTrace();
         throw new GDAOException(e.getMessage());
      } catch (GDAOException e) {
         e.printStackTrace();
         throw new GDAOException(e.getMessage());
      } catch (BiffException e) {
         e.printStackTrace();
         throw new GDAOException(e.getMessage());
      } catch (IOException e) {
         e.printStackTrace();
         throw new GDAOException(e.getMessage());
      }
      
      log.debug("Finished " + whatWeAreDoing);
      
   }
   
   
   
   
  /**********************************************************************
   *
   *  TABLE HOUSEHOLD
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
   private void updateOrInsertDataFromExcelFile(Connection connection, String excelFileName) {

      String whatWeAreDoing = "\"updateOrInsertDataFromExcelFile()\" for TABLE \"HOUSEHOLD\"";
      log.debug("Starting " + whatWeAreDoing);

      Workbook workbook = null;
      int row = 0;
      int column = 0;
      int inserted = 0;
      int updated = 0;
      int errors = 0;

      try {
         workbook = Workbook.getWorkbook(new File(excelFileName));

         Sheet sheet = workbook.getSheet(0); //open first sheet in workbook

         int rows = sheet.getRows();
         int columns = sheet.getColumns();

         log.info("Spreadsheet has " + rows + " rows and " + columns + " columns");

         HouseholdTab householdTab = new HouseholdTab(connection);

         if (!householdTab.exists()) {
            String errMessage = "TABLE " + householdTab.getDbEntityName() + " does not exist.";
            log.error(errMessage);
            throw new GDAOException(errMessage);
         } else {
            log.debug("TABLE " + householdTab.getDbEntityName() + " exists.");
         }

         if (rows > 0 && columns > 0) {
            for (row = 1; row < rows; row++) { // skip first row since it is header row
               for (column = 0; column < columns; column++) { 
                  Cell cell = sheet.getCell(column, row);
                  String cellContent = cell.getContents();
                  log.debug("Cell[" + column + "," + row + "]=" + cellContent);

                        householdTab.setHOUSEHOLD_ID(getNumber(sheet.getCell(0, row)));
      householdTab.setHOUSEHOLD_NAME(getString(sheet.getCell(1, row)));

               }
                
               householdTab.print(";");

               int recordsUpdated = 0;

               /**********************************************************************
                *
                * Try to update this record. If it could not be updates then record
                * does not exist and it has to be inserted.
                *
                **********************************************************************/
               try {
                  recordsUpdated = householdTab.updateThisRecord();
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
                     householdTab.insertThisRecord();
                     inserted++;
                  } else {
                     updated++;
                  }

               } catch (GDAOException e) {
                  log.error("----------------------");
                  log.error("ERROR occurred in row :" + row + " with these values in first four columns:");
                  log.error(sheet.getCell(0, row).getContents());
                  log.error(sheet.getCell(1, row).getContents());
                  log.error(sheet.getCell(2, row).getContents());
                  log.error(sheet.getCell(3, row).getContents());
                  errors++;
                  e.printStackTrace();
               }
            }
         }

         connection.commit();
         workbook.close();

         long rowCount = householdTab.getRowCount();

         log.info("Inserted Records in TABLE HOUSEHOLD DB: " + inserted);
         log.info("Updated Records in TABLE HOUSEHOLD DB: " + updated);
         log.info("Total errors: " + errors);
         log.info("Row Count (TABLE HOUSEHOLD) =" + rowCount);

      } catch (SQLException e) {
         e.printStackTrace();
      } catch (GDAOException e) {
         e.printStackTrace();
      } catch (BiffException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
      
      log.debug("Finished " + whatWeAreDoing);
   }
   
   
  /**********************************************************************
   * 
   * Utility method for adding String value in the spreadheet cell
   *
   * @param  WritableSheet    worksheet
   * @param  int              worksheet column
   * @param  int              worksheet row
   * @param  String           value to be set in the cell
   * @throws RowsExceededException
   * @throws WriteException
   *
   **********************************************************************/
   private void addStringCell(WritableSheet writableSheet, int column, int row, String value) throws RowsExceededException,
                                                                                             WriteException {
      if (value == null) {
         return;
      } else {
         writableSheet.addCell(new jxl.write.Label(column++, row, value));
      }
   }

  /**********************************************************************
   * 
   * Utility method for adding numeric value in the spreadheet cell
   *
   * @param  WritableSheet    worksheet
   * @param  int              worksheet column
   * @param  int              worksheet row
   * @param  BigDecimal       value to be set in the cell
   * @throws RowsExceededException
   * @throws WriteException
   *
   **********************************************************************/
   private void addNumberCell(WritableSheet writableSheet, int column, int row, BigDecimal value) throws RowsExceededException,
                                                                                                 WriteException {
      if (value == null) {
         return;
      } else {
         writableSheet.addCell(new jxl.write.Number(column++, row, value.doubleValue()));
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
   private void addTimestampCell(WritableSheet writableSheet, int column, int row, Timestamp value) throws RowsExceededException,
                                                                                                   WriteException {
      if (value == null) {
         return;
      } else {
         writableSheet.addCell(new jxl.write.DateTime(column++, row, value));
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
      return (cell.getContents().isEmpty()) ? null : cell.getContents().replace(",", "");
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
      return (cell.getContents().isEmpty()) ? null : new BigDecimal(cell.getContents().replace(",", ""));
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
      return ((cell.getContents().isEmpty()) ? null : new Timestamp(((DateCell) (cell)).getDate().getTime()));
   }
}
