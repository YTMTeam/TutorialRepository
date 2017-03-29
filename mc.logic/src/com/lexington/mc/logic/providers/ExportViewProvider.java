package com.lexington.mc.logic.providers;


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.log4j.Logger;

import com.lexington.mc.logic.excel.export.AccountExporter;
import com.lexington.mc.logic.excel.export.AccountFullExporter;
import com.lexington.mc.logic.excel.export.AccountTableExporter;
import com.lexington.mc.logic.excel.export.MonitoredAccTableExporter;
import com.lexington.mc.logic.excel.export.PositionExporter;
import com.lexington.mc.logic.excel.export.PositionTableExporter;
import com.lexington.mc.logic.excel.export.TradeExporter;
import com.lexington.mc.logic.excel.export.TradeTableExporter;
import com.lexington.mc.logic.util.Connect;
import com.lexington.mc.logic.util.MessageException;
import com.mallocinc.codegenerator.exceptions.GDAOException;
import com.mallocinc.database.generated.samples.excel.TradeExcelSample;

public class ExportViewProvider {
	
	   final static Logger log = Logger.getLogger(ExportViewProvider.class.getName());

	   public byte[] generateExcelFileForUserTrades(String userId) throws MessageException {
		   	  TradeTableExporter tableExporter = new TradeTableExporter();
		      byte[] res;
		      Connection connection = null;

		      try {
		         connection = Connect.obtainConn(connection);
		         res = tableExporter.exportByAccount(userId, connection);
		      } finally {
		         Connect.returnConn(connection);
		      }
		      return res;
	   }
	   public byte[] generateExcelFileForAccount(String accountId, String bankId) throws MessageException {
	     AccountFullExporter tableExporter = new AccountFullExporter();
	      byte[] res;
	      
	     res = tableExporter.exportFullAccountInfo(accountId, bankId);

	      return res;
	   }
	   
	   public byte[] generateExcelFileForAccountDate(String accId,Timestamp date1, Timestamp date2) throws MessageException {
			 AccountExporter tableExporter = new AccountExporter();
		      byte[] res;
		      
		     res = tableExporter.exportFullAccountInfo(accId,date1,date2);

		      return res;
		   }
	   public byte[] generateExcelFileForAccountTrades(String accountId,Timestamp date1, Timestamp date2) throws MessageException {
		  TradeExporter tableExporter = new TradeExporter();
		  byte[] res;
		  res = tableExporter.exportFullTradeInfo(accountId, date1, date2);

		  return res;
	   }
	   public byte[] generateExcelFileForAccountPositions(String accountId,Timestamp date1, Timestamp date2) throws MessageException {
			 PositionExporter tableExporter = new PositionExporter();
			  byte[] res;
			  res = tableExporter.exportFullPositionInfo(accountId, date1, date2);

			  return res;
		   }
	 
	   public byte[] generateExcelFileForBankAccountList(BigDecimal bankId) throws MessageException {
		   AccountTableExporter tableExporter = new AccountTableExporter();
		   byte[] res;
		   Connection connection = null;
		   
		   try {
			   connection = Connect.obtainConn(connection);
			   res = tableExporter.exportAccounts(connection,bankId);
		   } finally {
			   Connect.returnConn(connection);
		   }
		   return res;
	   }
//	   public byte[] generateExcelFileForMonitoredAccountList(BigDecimal bankId) throws MessageException {
//		  
//		 AccountExporter tableExporter = new AccountExporter();
//		      byte[] res;
//		      
//		     res = tableExporter.exportFullAccountInfo(bankId);
//
//		      return res;
//	   }
}
