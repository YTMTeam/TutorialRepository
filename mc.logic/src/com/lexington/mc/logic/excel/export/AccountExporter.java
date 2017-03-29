package com.lexington.mc.logic.excel.export;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.entities.EntityAccount;
import com.lexington.mc.model.entities.EntityBank;
import com.lexington.mc.model.entities.EntityPosition;
import com.lexington.mc.model.singletons.datasource.AccountEntityDatasource;


public class AccountExporter extends ExcelBasic{

	  ArrayList<String> 		   accountHeaderList 	 = new ArrayList<>();
	  ArrayList<ExcelExportEntity> accountContents 		 = new ArrayList<>();
	  
	  String 						 excelName  	 = null;
	  
	  //wraper for every excel file
	  public byte[] exportFullAccountInfo(String accID,Timestamp date1, Timestamp date2) throws MessageException {
	      try {
	         excelName = "Account info";
	         fetchData(accID, date1,date2);
	         return exportDataFromDatabaseIntoByteArray();
	      } catch (MessageException e) {
	         throw e;
	      }
	   }
	  
	  
	  public void fetchData(String accID,Timestamp date1, Timestamp date2) throws MessageException {
		  
	      ArrayList<EntityAccount> entityAccount = AccountEntityDatasource.getAccountBySignutureDate(accID,date1, date2);
	      populateAccountHeaderList(accountHeaderList);
	      populateAccountContents(accountContents, entityAccount);
	 
	   }
	  
	  private byte[] exportDataFromDatabaseIntoByteArray() throws MessageException {

	      XSSFWorkbook workbook = new XSSFWorkbook();

	      insertData(workbook, accountHeaderList, accountContents, "Account");


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
	  
	  void populateAccountContents(ArrayList<ExcelExportEntity> contents,ArrayList<EntityAccount> accounts) {
		  for (EntityAccount account : accounts) {
	      ExcelExportEntity entity = new ExcelExportEntity();
	      ArrayList<String> rowFields = new ArrayList<>();

	      
	      //ACCOUNT_NUMBER
	      rowFields.add(account.getAccount().getACCOUNT_NUMBER() != null ? account.getAccount().getACCOUNT_NUMBER() : "");
	      
	      //BROKER CODE 
	      rowFields.add(account.getAccount().getBROKER_CODE() != null ? account.getAccount().getBROKER_CODE() : "");
	    
	      //BANK NAME
	      rowFields.add(account.getEntityBank().getBank().getBANK_NAME() != null ? account.getEntityBank().getBank().getBANK_NAME() : "");
	      

	      //FIRST_NAME
	      rowFields.add(account.getAccount().getFIRST_NAME() != null ? account.getAccount().getFIRST_NAME() : "");
	      
	      //MIDDLE_NAME
	      rowFields.add(account.getAccount().getMIDDLE_NAME() != null ? account.getAccount().getMIDDLE_NAME() : "");
	      
	      //LAST_NAME
	      rowFields.add(account.getAccount().getLAST_NAME() != null ? account.getAccount().getLAST_NAME() : "");
	      
	      //BROKER_CODE
//	      rowFields.add(account.getAccount().getBROKER_CODE() != null ? account.getAccount().getBROKER_CODE() : "");
	      
	      //MANAGED_ACCOUNT
	      rowFields.add(account.getAccount().getMANAGED_ACCOUNT() != null ? account.getAccount().getMANAGED_ACCOUNT() : "");
	      
	      //ACCOUNT_TYPE
	      rowFields.add(account.getAccount().getTYPE() != null ? account.getAccount().getTYPE() : "");
	      
	      //REQUESTING_INSITUTION
	      rowFields.add("");
	      
	      //ACCOUNT_STATUS
          rowFields.add(account.getAccount().getACCOUNT_STATUS() != null ? account.getAccount().getACCOUNT_STATUS() : "");

	      
	      
	      entity.setRowFields(rowFields);
	      
	      contents.add(entity);
		  }
	   }
	   
	   public void populateAccountHeaderList(ArrayList<String> accountHeader) {
	      accountHeader.add("ACCOUNT NUMBER");
	      accountHeader.add("BROKER CODE");
	      accountHeader.add("BANK NAME");
	      accountHeader.add("FIRST NAME");
	      accountHeader.add("MIDDLE NAME");
	      accountHeader.add("LAST NAME");
	      accountHeader.add("MANAGED ACCOUNT");
	      accountHeader.add("ACCOUNT TYPE");
	      accountHeader.add("REQUESTING INSTITUTION");
	      accountHeader.add("ACCOUNT STATUS");
	   }
	  
}
