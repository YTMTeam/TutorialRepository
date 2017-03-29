package com.lexington.mc.logic.excel.export;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.lexington.mc.logic.excel.util.ExcelExportUtil;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.entities.EntityAccount;
import com.lexington.mc.model.entities.EntityBank;
import com.lexington.mc.model.entities.EntityPosition;
import com.lexington.mc.model.entities.EntityTrade;
import com.lexington.mc.model.singletons.datasource.AccountEntityDatasource;
import com.lexington.mc.model.singletons.datasource.BankEntityDatasource;
import com.lexington.mc.model.singletons.datasource.PositionEntityDatasource;
import com.lexington.mc.model.singletons.datasource.TradeEntityDatasource;
import com.lexington.mc.model.views.DataVExcelAccount;


public class AccountFullExporter {

   private static Logger        log          = Logger.getLogger(AccountFullExporter.class.getName());

   DataVExcelAccount			 excelVAccount	 = new DataVExcelAccount();
   ExcelExportUtil 			 excelExportUtil = new ExcelExportUtil();

   String 						 excelName  	 = null;

   ArrayList<String> 			 accountHeaderList 	 = new ArrayList<>();
   ArrayList<ExcelExportEntity> accountContents 		 = new ArrayList<>();

   ArrayList<String> 			 positionHeaderList 	 = new ArrayList<>();
   ArrayList<ExcelExportEntity> positionContents 		 = new ArrayList<>();

   ArrayList<String> 			 tradeHeaderList 	 = new ArrayList<>();
   ArrayList<ExcelExportEntity> tradeContents 		 = new ArrayList<>();


   public byte[] exportFullAccountInfo(String accountId, String bankId) throws MessageException {
      try {
         excelName = "Account info";
         fetchData(accountId, bankId);
         return exportDataFromDatabaseIntoByteArray();
      } catch (MessageException e) {
         throw e;
      }
   }

   public void fetchData(String accountId, String bankId) throws MessageException {
      EntityAccount entityAccount = AccountEntityDatasource.getAccountByAccountId(accountId);

      ArrayList<EntityTrade> entityTrades = TradeEntityDatasource.getAvailableTradesByAccountId(accountId, bankId);

      ArrayList<EntityPosition> entityPositions = PositionEntityDatasource.getAvailablePositionsByAccountId(accountId, bankId);

      
      populateAccountHeaderList(accountHeaderList);
      populatePositionHeaderList(positionHeaderList);
      populateTradeHeaderList(tradeHeaderList);
      
      populateAccountContents(accountContents, entityAccount);
      populateTradeContents(tradeContents, entityTrades);
      populatePositionContents(positionContents, entityPositions);

   }
   private byte[] exportDataFromDatabaseIntoByteArray() throws MessageException {

      XSSFWorkbook workbook = new XSSFWorkbook();

      insertData(workbook, accountHeaderList, accountContents, "Account");
      insertData(workbook, tradeHeaderList, tradeContents, "Trades");
      insertData(workbook, positionHeaderList, positionContents, "Positions");

      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      //write this workbook to an Outputstream.
      try {
         workbook.write(bos);
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
         throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
      } finally {
         try {
            bos.close();
            workbook.close();
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
      byte[] bytes = bos.toByteArray();
      return bytes;
   }
   
//ovo u super class
   class ExcelExportEntity {
      ArrayList<String> rowFields = new ArrayList<>();

      public ArrayList<String> getRowFields() {
         return rowFields;
      }

      public void setRowFields(ArrayList<String> rowFields) {
         this.rowFields = rowFields;
      }

   }
   
//u super class
   XSSFWorkbook insertData(XSSFWorkbook workbook, ArrayList<String> headerList, ArrayList<ExcelExportEntity> contents, String sheetName) {
      XSSFSheet sheet = workbook.createSheet(sheetName);

      //First we create header row using headerList
      XSSFRow rowHeader = sheet.createRow(0);
      for (int i = 0; i < headerList.size(); i++) {
         XSSFCell cell = rowHeader.createCell(i);
         cell.setCellValue(headerList.get(i));
         cell.setCellStyle(excelExportUtil.getStyle("Header", workbook));
      }

      //Then we add data
      for (int i = 0; i < contents.size(); i++) {
         XSSFRow rowData = sheet.createRow(i+1);
         ExcelExportEntity content = contents.get(i);
         ArrayList<String> rowField = content.getRowFields();
         for (int j = 0; j < rowField.size(); j++) {
            excelExportUtil.exportValueIntoExcel(rowField.get(j), j, workbook , rowData);
         }
      }

      //finally we autosize columns
      for (int i = 0; i < headerList.size(); i++) {
         sheet.autoSizeColumn(i); 
      }
      return workbook;
   }

   void populateAccountContents(ArrayList<ExcelExportEntity> contents,EntityAccount account) {
      ExcelExportEntity entity = new ExcelExportEntity();
      ArrayList<String> rowFields = new ArrayList<>();

      
      //ACCOUNT_ID
      rowFields.add(account.getAccount().getACCOUNT_ID() != null ? account.getAccount().getACCOUNT_ID() : "");
      
      //FIRST_NAME
      rowFields.add(account.getAccount().getFIRST_NAME() != null ? account.getAccount().getFIRST_NAME() : "");
      
      //MIDDLE_NAME
      rowFields.add(account.getAccount().getMIDDLE_NAME() != null ? account.getAccount().getMIDDLE_NAME() : "");
      
      //LAST_NAME
      rowFields.add(account.getAccount().getLAST_NAME() != null ? account.getAccount().getLAST_NAME() : "");
      
      //BROKER_CODE
      rowFields.add(account.getAccount().getBROKER_CODE() != null ? account.getAccount().getBROKER_CODE() : "");
      
      //MANAGED_ACCOUNT
      rowFields.add(account.getAccount().getMANAGED_ACCOUNT() != null ? account.getAccount().getMANAGED_ACCOUNT() : "");
      
      //ACCOUNT_STATUS
      rowFields.add(account.getAccount().getACCOUNT_STATUS() != null ? account.getAccount().getACCOUNT_STATUS() : "");
      
      
      entity.setRowFields(rowFields);
      
      contents.add(entity);
   }
   
   public void populateAccountHeaderList(ArrayList<String> accountHeader) {
      accountHeader.add("ACCOUNT ID");
      accountHeader.add("FIRST NAME");
      accountHeader.add("MIDDLE NAME");
      accountHeader.add("LAST NAME");
      accountHeader.add("BROKER CODE");
      accountHeader.add("MANAGED ACCOUNT");
      accountHeader.add("ACCOUNT STATUS");
   }
   
   void populateTradeContents(ArrayList<ExcelExportEntity> contents,ArrayList<EntityTrade> trades) {
            
      for(EntityTrade trade : trades) {
         EntityBank bank = BankEntityDatasource.getByBankId(trade.getTrade().getBANK_ID());
         
         
      ExcelExportEntity entity = new ExcelExportEntity();
      ArrayList<String> rowFields = new ArrayList<>();
      
      //TRANSACTION ID
      rowFields.add(trade.getTrade().getTRANSACTION_ID() != null ? trade.getTrade().getTRANSACTION_ID().toString() : "");
      
      //BANK NAME
      rowFields.add(bank.getBank().getBANK_NAME() != null ? bank.getBank().getBANK_NAME() : "");
      
      //TRANSACTION TYPE
      rowFields.add(trade.getTrade().getTRANSACTION_TYPE() != null ? trade.getTrade().getTRANSACTION_TYPE() : "");
      
      //CURRENCY
      rowFields.add(trade.getTrade().getCURRENCY() != null ? trade.getTrade().getCURRENCY() : "");
      
      //EXECUTION PRICE
      rowFields.add(trade.getTrade().getEXECUTION_PRICE() != null ? trade.getTrade().getEXECUTION_PRICE().toString() : "");
      
      //QUANTITY
      rowFields.add(trade.getTrade().getQUANTITY() != null ? trade.getTrade().getQUANTITY().toString() : "");
      
      //NET AMMOUNT
      rowFields.add(trade.getTrade().getNET_AMOUNT() != null ? trade.getTrade().getNET_AMOUNT().toString() : "");
      
      //EXCHANGE
      rowFields.add(trade.getTrade().getEXCHANGE() != null ? trade.getTrade().getEXCHANGE() : "");
      
      //DATE
      rowFields.add(trade.getTrade().getTRADE_DATE().toString() != null ? trade.getTrade().getTRADE_DATE().toString() : "");
      
      //CUSIP
      rowFields.add(trade.getTrade().getCUSIP() != null ? trade.getTrade().getCUSIP() : "");
      
      //ISIN
      rowFields.add(trade.getTrade().getISIN() != null ? trade.getTrade().getISIN() : "");
      
      //SEDOL
      rowFields.add(trade.getTrade().getSEDOL() != null ? trade.getTrade().getSEDOL() : "");
      
      entity.setRowFields(rowFields);
      
      contents.add(entity);
      }
      
   }
   
   public void populateTradeHeaderList(ArrayList<String> tradeHeader) {
      tradeHeader.add("TRANSACTION ID");
      tradeHeader.add("BANK NAME");
      tradeHeader.add("TRANSACTION TYPE");
      tradeHeader.add("CURRENCY");
      tradeHeader.add("EXECUTION PRICE");
      tradeHeader.add("QUANTITY");
      tradeHeader.add("NET AMOUNT");
      tradeHeader.add("EXCHANGE");
      tradeHeader.add("TRADE DATE");
      tradeHeader.add("CUSIP");
      tradeHeader.add("ISIN");
      tradeHeader.add("SEDOL");
   }
   void populatePositionContents(ArrayList<ExcelExportEntity> contents,ArrayList<EntityPosition> positions) {
      
      for(EntityPosition position : positions) {
         //EntityBank bank = BankEntityDatasource.getByBankId(position.getPosition().getBROKER_CODE());
         
         
         ExcelExportEntity entity = new ExcelExportEntity();
         ArrayList<String> rowFields = new ArrayList<>();
         
         //BROKER CODE
         rowFields.add(position.getPosition().getBROKER_CODE() != null ? position.getPosition().getBROKER_CODE() : "");
         
         //SECURITY SYMBOL
         rowFields.add(position.getPosition().getSECURITY_SYMBOL() != null ? position.getPosition().getSECURITY_SYMBOL() : "");
         
         //CURRENCY
         rowFields.add(position.getPosition().getCURRENCY() != null ? position.getPosition().getCURRENCY() : "");
         
         //EXECUTION PRICE
         rowFields.add(position.getPosition().getEXECUTION_PRICE() != null ? position.getPosition().getEXECUTION_PRICE().toString() : "");
         
         //EXPIRATION DATE
         rowFields.add(position.getPosition().getEXPIRATION_DATE() != null ? position.getPosition().getEXPIRATION_DATE().toString() : "");
         
         //CUSIP
         rowFields.add(position.getPosition().getCUSIP() != null ? position.getPosition().getCUSIP().toString() : "");
         
         //ISIN
         rowFields.add(position.getPosition().getISIN() != null ? position.getPosition().getISIN().toString() : "");
         
         //SEDOL
         rowFields.add(position.getPosition().getSEDOL() != null ? position.getPosition().getSEDOL().toString() : "");
         
         entity.setRowFields(rowFields);
         
         contents.add(entity);
      }    
   }

   public void populatePositionHeaderList(ArrayList<String> positionHeader) {
      positionHeader.add("BROKER CODE");
      positionHeader.add("SECURITY SYMBOL");
      positionHeader.add("CURRENCY");
      positionHeader.add("EXECUTION PRICE");
      positionHeader.add("EXPIRATION DATE");
      positionHeader.add("CUSIP");
      positionHeader.add("ISIN");
      positionHeader.add("SEDOL");
   }
}
