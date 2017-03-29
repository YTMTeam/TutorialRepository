package com.lexington.mc.logic.excel.export;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.entities.EntityBank;
import com.lexington.mc.model.entities.EntityTrade;
import com.lexington.mc.model.singletons.datasource.BankEntityDatasource;
import com.lexington.mc.model.singletons.datasource.TradeEntityDatasource;

public class TradeExporter extends ExcelBasic  {
	ArrayList<String> 			 tradeHeaderList 	 = new ArrayList<>();
	ArrayList<ExcelExportEntity> tradeContents 		 = new ArrayList<>();
	  String 						 excelName  	 = null;
	
	 public byte[] exportFullTradeInfo(String accountId, Timestamp date1, Timestamp date2) throws MessageException {
	      try {
	         excelName = "Trade info";
	         fetchData(accountId, date1, date2);
	         return exportDataFromDatabaseIntoByteArray();
	      } catch (MessageException e) {
	         throw e;
	      }
	   }
	 
	 
	 public void fetchData(String accountId, Timestamp date1, Timestamp date2) throws MessageException {
	 
	      ArrayList<EntityTrade> entityTrades = TradeEntityDatasource.getTradesBySignutureDate(accountId, date1, date2);
	      populateTradeHeaderList(tradeHeaderList);
	      populateTradeContents(tradeContents, entityTrades);
	

	   }
	   private byte[] exportDataFromDatabaseIntoByteArray() throws MessageException {

	      XSSFWorkbook workbook = new XSSFWorkbook();

	   
	      insertData(workbook, tradeHeaderList, tradeContents, "Trades");
	 

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
	   
	   void populateTradeContents(ArrayList<ExcelExportEntity> contents,ArrayList<EntityTrade> trades) {
           
		      for(EntityTrade trade : trades) {
		         EntityBank bank = BankEntityDatasource.getByBankId(trade.getTrade().getBANK_ID());
		         
		         
		      ExcelExportEntity entity = new ExcelExportEntity();
		      ArrayList<String> rowFields = new ArrayList<>();
		      
		      //TRANSACTION ID
		      rowFields.add(trade.getTrade().getTRANSACTION_ID() != null ? trade.getTrade().getTRANSACTION_ID().toString() : "");
		      
		      //TRANSACTION TYPE
		      rowFields.add(trade.getTrade().getTRANSACTION_TYPE() != null ? trade.getTrade().getTRANSACTION_TYPE() : "");
		     
              //QUANTITY
              rowFields.add(trade.getTrade().getQUANTITY() != null ? trade.getTrade().getQUANTITY().toString() : "");
             
              //SECURITY SYMBOL
              rowFields.add(trade.getTrade().getSECURITY_SYMBOL() != null ? trade.getTrade().getSECURITY_SYMBOL().toString() : "");
              
              //SECURITY NAME
              rowFields.add(trade.getTrade().getSECURITY_NAME() != null ? trade.getTrade().getSECURITY_NAME() : "");
              
              //SECURITY TYPE
              rowFields.add(trade.getTrade().getSECURITY_TYPE() != null ? trade.getTrade().getSECURITY_TYPE().toString() : "");

              //EXCHANGE
              rowFields.add(trade.getTrade().getEXCHANGE() != null ? trade.getTrade().getEXCHANGE() : "");

              //BROKER CODE
              rowFields.add(bank.getBank().getBANK_NAME() != null ? bank.getBank().getBANK_NAME() : "");

              
		      //ACCOUNT NUMBER
		      rowFields.add(trade.getEntityAccount().getAccount().getACCOUNT_NUMBER() != null ? trade.getEntityAccount().getAccount().getACCOUNT_NUMBER() : "");		      
		     
              // TRADE DATE
              rowFields.add(trade.getTrade().getTRADE_DATE().toString() != null ? trade.getTrade().getTRADE_DATE().toString() : "");

              //EXECUTION PRICE
              rowFields.add(trade.getTrade().getEXECUTION_PRICE() != null ? trade.getTrade().getEXECUTION_PRICE().toString() : "");

              //DATA AS OF
              rowFields.add(trade.getTrade().getDATA_AS_OF() != null ? trade.getTrade().getDATA_AS_OF().toString() : "");
              
              //CUSIP
              rowFields.add(trade.getTrade().getCUSIP() != null ? trade.getTrade().getCUSIP() : "");
              
              //ISIN
              rowFields.add(trade.getTrade().getISIN() != null ? trade.getTrade().getISIN() : "");
              
              //SEDOL
              rowFields.add(trade.getTrade().getSEDOL() != null ? trade.getTrade().getSEDOL() : "");
              
              //NET AMMOUNT
              rowFields.add(trade.getTrade().getNET_AMOUNT() != null ? trade.getTrade().getNET_AMOUNT().toString() : "");

		      
		      //CURRENCY
		      rowFields.add(trade.getTrade().getCURRENCY() != null ? trade.getTrade().getCURRENCY() : "");
		      
		      
		      	      
		      
		      entity.setRowFields(rowFields);
		      
		      contents.add(entity);
		      }
		      
		   }
		   
		   public void populateTradeHeaderList(ArrayList<String> tradeHeader) {
		      tradeHeader.add("TRANSACTION ID");
		      tradeHeader.add("TRANSACTION TYPE");
		      tradeHeader.add("QUANTITY");
		      tradeHeader.add("SECURITY SYMBOL");
		      tradeHeader.add("SECURITY NAME");
		      tradeHeader.add("SECURITY TYPE");
		      tradeHeader.add("EXCHANGE");
		      tradeHeader.add("BROKER CODE");
		      tradeHeader.add("ACCOUNT NUMBER");
		      tradeHeader.add("TRADE DATE");
		      tradeHeader.add("EXECUTION PRICE");
		      tradeHeader.add("DATA AS OF");
		      tradeHeader.add("CUSIP");
		      tradeHeader.add("ISIN");
		      tradeHeader.add("SEDOL");
		      tradeHeader.add("NET AMMOUNT");
		      tradeHeader.add("CURRENCY");
		   }
}
