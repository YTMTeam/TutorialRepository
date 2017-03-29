package com.lexington.mc.webview.junit.main;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import com.google.gson.Gson;
import com.lexington.mc.logic.providers.BlockchainUtilProvider;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.blockchain.common.BlockchainConstants;
import com.lexington.mc.model.blockchain.common.BlockchainErrorMessages;
import com.lexington.mc.model.blockchain.common.StreamDataCreator;
import com.lexington.mc.model.blockchain.exception.BlockchainClientException;
import com.lexington.mc.model.blockchain.exception.EncryptionException;
import com.lexington.mc.model.blockchain.pojos.AccountPojo;
import com.lexington.mc.model.blockchain.pojos.EmployeePojo;
import com.lexington.mc.model.blockchain.pojos.LoginPojo;
import com.lexington.mc.model.blockchain.pojos.MonitorPojo;
import com.lexington.mc.model.blockchain.pojos.PositionPojo;
import com.lexington.mc.model.blockchain.pojos.TradePojo;
import com.lexington.mc.model.blockchain.pojos.streams.StreamData;
import com.lexington.mc.model.blockchain.pojos.streams.StreamDataWrapper;
import com.lexington.mc.model.blockchain.pojos.streams.StreamKeyItemsPojo;
import com.lexington.mc.model.blockchain.util.EncryptionManager;
import com.lexington.mc.model.blockchain.util.HexConverter;
import com.lexington.mc.model.entities.EntityAccount;
import com.lexington.mc.model.entities.EntityBank;
import com.lexington.mc.model.entities.EntityTrade;
import com.lexington.mc.model.entities.EntityUser;
import com.lexington.mc.model.singletons.connection.BlockchainConnection;
import com.lexington.mc.model.singletons.datasource.AccountEntityDatasource;
import com.lexington.mc.model.singletons.datasource.BankEntityDatasource;
import com.lexington.mc.model.singletons.datasource.TradeEntityDatasource;
import com.lexington.mc.model.singletons.datasource.UserEntityDatasource;
import com.lexington.mc.webview.junit.util.BlockchainObjectsFactory;

public class JunitTesting {
	BlockchainObjectsFactory objectFactory = new BlockchainObjectsFactory();
	StreamDataCreator dataCreator = new StreamDataCreator();
	
	
//	private ArrayList<EntityAccount> allAccounts = AccountEntityDatasource.getAll();
//	private ArrayList<EntityBank> allBanks = BankEntityDatasource.getAll();
//	private ArrayList<EntityTrade> allTrades = TradeEntityDatasource.getAll();
//	
//	public ArrayList<EntityAccount> addTest(){
//		ArrayList<EntityAccount> all = new ArrayList<>();
//		
//		
//		return all;
//	}
	
//	@Test
//	   public void testChecker() {
//		assertTrue(allAccounts.size() > 10);
//		assertFalse(allAccounts.size() > 8);
//		assertTrue(allTrades.size() < 5);
//		
//	   }
	
	@Test
	public void testLogIn() throws MessageException, InterruptedException, EncryptionException{
		
		LoginPojo login = (LoginPojo) objectFactory.getObject("LOGIN");
		String stream = "SCOTIA-LOGINS";
		String key = login.getLOGIN_ID();
		
		String importedData = dataCreator.createDataStringFromObject(login, BlockchainConstants.StreamTypes.LOGIN_CREDENTIALS);
		BlockchainConnection.getClient().publishToStream(stream, key, importedData);
		Thread.sleep(5000);
		
		EntityUser user = new EntityUser();
		ArrayList<StreamKeyItemsPojo> streamKeyItems = BlockchainConnection.getClient().listStreamKeyItems(user.getEntityBank().getBank().getBANK_CODE()+
	            BlockchainConstants.General.APPENDER+
	            BlockchainConstants.StreamNames.PRIVATE_KEY, user.getEntityBank().getBank().getBANK_CODE());
		
		StreamKeyItemsPojo item;
	    item = streamKeyItems.get(streamKeyItems.size()-1);
	    
	    String exportedData  =null;
	    exportedData = item.getData().toUpperCase();
	    //**************************************************************************************************
//	    String encryptionKey = EncryptionManager.fillPassword(encryptionKey);
//	    HexConverter      hexConverter      = new HexConverter();
//	    Gson              gson              = new Gson();
//	    String stramDataWrapperString = hexConverter.convertFromHex(item.getData());
//	    StreamDataWrapper wrapper = gson.fromJson(stramDataWrapperString, StreamDataWrapper.class);
//	    
//	    
//	    String streamDataString = null;
//	    streamDataString = EncryptionManager.decryptFromString(wrapper.getEncryptedStringData(), encryptionKey);
//	    StreamData streamData = gson.fromJson(streamDataString, StreamData.class);
//	    String privateKey =  (String) streamData.getData();
//		
	    assertTrue(importedData.equals(exportedData));
	      
	}
	
	
	@Test
	public void testMonitorImport() throws InterruptedException{
		MonitorPojo monitor = (MonitorPojo) objectFactory.getObject("MONITOR");
		
		String stream = "SCOTIA-MONITORS";
		String key = monitor.getEMPLOYEE_ID();
		String importedData = dataCreator.createDataStringFromObject(monitor, BlockchainConstants.StreamTypes.MONITOR);
		BlockchainConnection.getClient().publishToStream(stream, key, importedData);
		Thread.sleep(5000);
		ArrayList<StreamKeyItemsPojo> items = BlockchainConnection.getClient().listStreamKeyItems(stream, key);
		String exportedData = null;
		try{
			exportedData = items.get(items.size()-1).getData().toUpperCase();
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("There are no items.");
		}
		  assertTrue(importedData.equals(exportedData));
	}
	@Test
	public void testEmployeeImport() throws InterruptedException{
		EmployeePojo employee = (EmployeePojo) objectFactory.getObject("EMPLOYEE");
		
		String stream = "SCOTIA-ЕMPLOYEES";
		String key = employee.getEMPLOYEE_ID();
		String importedData = dataCreator.createDataStringFromObject(employee, BlockchainConstants.StreamTypes.CREATE_EMPLOYEE);
		BlockchainConnection.getClient().publishToStream(stream, key, importedData);
		Thread.sleep(5000);
		ArrayList<StreamKeyItemsPojo> items = BlockchainConnection.getClient().listStreamKeyItems(stream, key);
		String exportedData = null;
		try{
			exportedData = items.get(items.size()-1).getData().toUpperCase();
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("There are no items.");
		}
		  assertTrue(importedData.equals(exportedData));
	}
	
	
	
	@Test
	public void testPositionImport() throws InterruptedException{
		PositionPojo position = (PositionPojo) objectFactory.getObject("POSITION");
		
		String stream = "SCOTIA-POSITIONS";
		String key = position.getPOSITION_ID();
		String importedData = dataCreator.createDataStringFromObject(position, BlockchainConstants.StreamTypes.CREATE_POSITION);
		BlockchainConnection.getClient().publishToStream(stream, key, importedData);
		Thread.sleep(5000);
		ArrayList<StreamKeyItemsPojo> items = BlockchainConnection.getClient().listStreamKeyItems(stream, key);
		String exportedData = null;
		try{
			exportedData = items.get(items.size()-1).getData().toUpperCase();
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("There are no items.");
		}
		  assertTrue(importedData.equals(exportedData));
	}
	

	@Test
	public void testTradeImport() throws InterruptedException{
		TradePojo trade = (TradePojo) objectFactory.getObject("TRADE");
		
		String stream = "SCOTIA-TRADES";
		String key = trade.getTRADE_ID();
		String importedData = dataCreator.createDataStringFromObject(trade, BlockchainConstants.StreamTypes.CREATE_TRADE);
		BlockchainConnection.getClient().publishToStream(stream, key, importedData);
		Thread.sleep(5000);
		ArrayList<StreamKeyItemsPojo> items = BlockchainConnection.getClient().listStreamKeyItems(stream, key);
		String exportedData = null;
		try{
			exportedData = items.get(items.size()-1).getData().toUpperCase();
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("There are no items.");
		}
		  assertTrue(importedData.equals(exportedData));
	}

	
	@Test
	public void testAccountImport() throws InterruptedException {
	   
	   AccountPojo account = (AccountPojo) objectFactory.getObject("ACCOUNT");
	   
	   //stream name is a combination of BANK CODE-TYPE OF INFORMATION
	   String stream = "SCOTIA-ACCOUNTS";
	   
	   //key is always a primary key
	   String key = account.getACCOUNT_ID();
	   
	   //in order to create data, use StreamDataCreator class
	   String importedData = dataCreator.createDataStringFromObject(account, BlockchainConstants.StreamTypes.CREATE_ACCOUNT);
	   
	   BlockchainConnection.getClient().publishToStream(stream, key, importedData);
	   
	   //Sleep for 5sec to make sure that we can access the stream
	   Thread.sleep(5000);
	   
	   //access the streams items
	   ArrayList<StreamKeyItemsPojo> items = BlockchainConnection.getClient().listStreamKeyItems(stream, key);
	   
	   //get the most recent data (mind out of bounds exception if item list is empty)
	   String exportedData = null;
	   try {
	   exportedData = items.get(items.size()-1).getData().toUpperCase();
	   } catch(ArrayIndexOutOfBoundsException e) {
	      System.out.println("There are no items.");
	   }

	   assertTrue(importedData.equals(exportedData));
	}
	
	
//	@Test
//	public void testUserLoginScotia() throws InterruptedException {
//		
//		LoginPojo login = (LoginPojo) objectFactory.getObject("LOGIN");
//		String stream = "SCOTIA-LOGINS";
//		String key = login.getLOGIN_ID();
//		
//		String importedData = dataCreator.createDataStringFromObject(login, BlockchainConstants.StreamTypes.LOGIN_CREDENTIALS);
//		String address = "19xGorUy1nqh1iqWbnz4bjUyiT7ewyCPex7k2q";
//		String privateKey = "VCe6GG1t9PLfDARy5X9wkoneKczyHWmaBta7BxDg4ABSMg9C3SPt67VE";
//		String txId = null;
//		 try {
//			   txId = BlockchainConnection.getClient().publishToStream(stream, key, importedData, privateKey, address);
//			   } catch (BlockchainClientException e) {
//			      if (e.getMessage().contains(BlockchainErrorMessages.PrivateKeys.INVALID_PRIVATE_KEY) || e.getMessage().contains(BlockchainErrorMessages.PrivateKeys.NON_STANDARD_TRANSACTION) ) {
//			        System.out.println("Invalid private key!");
//			      }
//			      else {
//			        System.out.println("We don't have a answer for this!");
//			      }
//			   }
//		 
//		 if(txId == null){
//			 
//		 }else{
//		
//			 
//			 Thread.sleep(5000);
//			 ArrayList<StreamKeyItemsPojo> items = BlockchainConnection.getClient().listStreamKeyItems(stream, key);
//			 String exportedData = null;
//			   try {
//			   exportedData = items.get(items.size()-1).getData().toUpperCase();
//			   } catch(ArrayIndexOutOfBoundsException e) {
//			      System.out.println("There are no items.");
//			   }
//
//			   assertTrue(importedData.equals(exportedData));
//		 }
//		 
//		}
		
	
	
	
	 public static junit.framework.Test suite() {
	        return new junit.framework.JUnit4TestAdapter(JunitTesting.class);
	    }

	 public static void main (String args[]){
		 org.junit.runner.JUnitCore.main("JunitTesting");
	 }
}
