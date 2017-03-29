package com.lexington.mc.logic.excel.util;

import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.blockchain.common.BlockchainConstants;
import com.lexington.mc.model.blockchain.common.BlockchainErrorMessages;
import com.lexington.mc.model.blockchain.common.StreamDataCreator;
import com.lexington.mc.model.blockchain.exception.BlockchainClientException;
import com.lexington.mc.model.blockchain.pojos.AccountPojo;
import com.lexington.mc.model.blockchain.pojos.EmployeePojo;
import com.lexington.mc.model.blockchain.pojos.MonitorPojo;
import com.lexington.mc.model.blockchain.pojos.PermissionPojo;
import com.lexington.mc.model.blockchain.pojos.PositionPojo;
import com.lexington.mc.model.blockchain.pojos.TradePojo;
import com.lexington.mc.model.entities.EntityUser;
import com.lexington.mc.model.singletons.connection.BlockchainConnection;

/**
 * This class is used to insert JSON objects into multichain
 * @author Dev
 *
 */
public class ExcelObjectInserter {

   StreamDataCreator dataCreator = new StreamDataCreator();


   public void insertEmployees(EmployeePojo employee,EntityUser user, String privateKey) throws MessageException {

      String hexData = dataCreator.createDataStringFromObject(employee, BlockchainConstants.StreamTypes.CREATE_EMPLOYEE);

      String key = employee.getEMPLOYEE_ID();

      String address = user.getEntityBank().getBank().getWALLET_ADDRESS();
      try{
         //         BlockchainConnection.getClient().publishToStream(user.getEntityBank().getBank().getBANK_CODE()+BlockchainConstants.General.APPENDER+BlockchainConstants.StreamNames.ACCOUNTS, key , hexData, privateKey, address);
         BlockchainConnection.getClient().publishToStream(user.getEntityBank().getBank().getBANK_CODE()+BlockchainConstants.General.APPENDER+BlockchainConstants.StreamNames.EMPLOYEES, key , hexData);
      } catch(BlockchainClientException e) {
         if(e.getMessage().contains(BlockchainErrorMessages.Streams.UNSPENT_OUTPUTS)) {
            throw new MessageException("unspentOutputError");
         } 
         else {
            throw new MessageException("somethingWentWrong");
         }
      }    
   }

   public void insertMonitors(MonitorPojo monitor, EntityUser user, String privateKey) throws MessageException {

      String hexData = dataCreator.createDataStringFromObject(monitor, BlockchainConstants.StreamTypes.MONITOR);

      String key = monitor.getMONITOR_ID();

      String address = user.getEntityBank().getBank().getWALLET_ADDRESS();
      try{
         //         BlockchainConnection.getClient().publishToStream(user.getEntityBank().getBank().getBANK_CODE()+BlockchainConstants.General.APPENDER+BlockchainConstants.StreamNames.ACCOUNTS, key , hexData, privateKey, address);
         BlockchainConnection.getClient().publishToStream(user.getEntityBank().getBank().getBANK_CODE()+BlockchainConstants.General.APPENDER+BlockchainConstants.StreamNames.MONITORS, key , hexData);
      } catch(BlockchainClientException e) {
         if(e.getMessage().contains(BlockchainErrorMessages.Streams.UNSPENT_OUTPUTS)) {
            throw new MessageException("unspentOutputError");
         } 
         else {
            throw new MessageException("somethingWentWrong");
         }
      }    
   }

   public void insertAccounts(AccountPojo account, EntityUser user, String privateKey) throws MessageException {

      String hexData = dataCreator.createDataStringFromObject(account, BlockchainConstants.StreamTypes.CREATE_ACCOUNT);

      String key = account.getACCOUNT_ID();

      String address = user.getEntityBank().getBank().getWALLET_ADDRESS();
      try{
         //         BlockchainConnection.getClient().publishToStream(user.getEntityBank().getBank().getBANK_CODE()+BlockchainConstants.General.APPENDER+BlockchainConstants.StreamNames.ACCOUNTS, key , hexData, privateKey, address);
         BlockchainConnection.getClient().publishToStream(user.getEntityBank().getBank().getBANK_CODE()+BlockchainConstants.General.APPENDER+BlockchainConstants.StreamNames.ACCOUNTS, key , hexData);
      } catch(BlockchainClientException e) {
         if(e.getMessage().contains(BlockchainErrorMessages.Streams.UNSPENT_OUTPUTS)) {
            throw new MessageException("unspentOutputError");
         } 
         else {
            throw new MessageException("somethingWentWrong");
         }
      }    
   }

   public void insertPermissions(PermissionPojo permission, EntityUser user, String privateKey) throws MessageException {

      String hexData = dataCreator.createDataStringFromObject(permission, BlockchainConstants.StreamTypes.CREATE_PERMISSION);

      String key = permission.getPERMISSION_ID();

      String address = user.getEntityBank().getBank().getWALLET_ADDRESS();
      try{
         //BlockchainConnection.getClient().publishToStream(user.getEntityBank().getBank().getBANK_CODE()+BlockchainConstants.General.APPENDER+BlockchainConstants.StreamNames.ACCOUNTS, key , hexData, privateKey, address);
         BlockchainConnection.getClient().publishToStream(user.getEntityBank().getBank().getBANK_CODE()+BlockchainConstants.General.APPENDER+BlockchainConstants.StreamNames.PERMISSION, key , hexData);
      } catch(BlockchainClientException e) {
         if(e.getMessage().contains(BlockchainErrorMessages.Streams.UNSPENT_OUTPUTS)) {
            throw new MessageException("unspentOutputError");
         } 
         else {
            throw new MessageException("somethingWentWrong");
         }
      }
   }

   public void insertPositions(PositionPojo position, EntityUser user, String privateKey) throws MessageException {


      String hexData = dataCreator.createDataStringFromObject(position, BlockchainConstants.StreamTypes.CREATE_POSITION);

      String key = position.getPOSITION_ID();

      String address = user.getEntityBank().getBank().getWALLET_ADDRESS();
      try{
         //       BlockchainConnection.getClient().publishToStream(user.getEntityBank().getBank().getBANK_CODE()+BlockchainConstants.General.APPENDER+BlockchainConstants.StreamNames.ACCOUNTS, key , hexData, privateKey, address);
         BlockchainConnection.getClient().publishToStream(user.getEntityBank().getBank().getBANK_CODE()+BlockchainConstants.General.APPENDER+BlockchainConstants.StreamNames.POSITIONS, key , hexData);
      } catch(BlockchainClientException e) {
         if(e.getMessage().contains(BlockchainErrorMessages.Streams.UNSPENT_OUTPUTS)) {
            throw new MessageException("unspentOutputError");
         } 
         else {
            throw new MessageException("somethingWentWrong");
         }
      }
   }

   public void insertTrades(TradePojo trade, EntityUser user, String privateKey) throws MessageException {

      String hexData = dataCreator.createDataStringFromObject(trade, BlockchainConstants.StreamTypes.CREATE_TRADE);

      String key = trade.getTRADE_ID();

      String address = user.getEntityBank().getBank().getWALLET_ADDRESS();
      try{
         //         BlockchainConnection.getClient().publishToStream(user.getEntityBank().getBank().getBANK_CODE()+BlockchainConstants.General.APPENDER+BlockchainConstants.StreamNames.ACCOUNTS, key , hexData, privateKey, address);
         BlockchainConnection.getClient().publishToStream(user.getEntityBank().getBank().getBANK_CODE()+BlockchainConstants.General.APPENDER+BlockchainConstants.StreamNames.TRADES, key , hexData);
      } catch(BlockchainClientException e) {
         if(e.getMessage().contains(BlockchainErrorMessages.Streams.UNSPENT_OUTPUTS)) {
            throw new MessageException("unspentOutputError");
         } 
         else {
            throw new MessageException("somethingWentWrong");
         }
      }
   }
}
