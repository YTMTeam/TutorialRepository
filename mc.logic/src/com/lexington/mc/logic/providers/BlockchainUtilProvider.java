package com.lexington.mc.logic.providers;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.blockchain.common.BlockchainConstants;
import com.lexington.mc.model.blockchain.common.BlockchainErrorMessages;
import com.lexington.mc.model.blockchain.common.StreamDataCreator;
import com.lexington.mc.model.blockchain.exception.BlockchainClientException;
import com.lexington.mc.model.blockchain.exception.EncryptionException;
import com.lexington.mc.model.blockchain.pojos.BlockPojo;
import com.lexington.mc.model.blockchain.pojos.LoginPojo;
import com.lexington.mc.model.blockchain.pojos.PojoApi;
import com.lexington.mc.model.blockchain.pojos.TransactionPojo;
import com.lexington.mc.model.blockchain.pojos.streams.StreamData;
import com.lexington.mc.model.blockchain.pojos.streams.StreamDataWrapper;
import com.lexington.mc.model.blockchain.pojos.streams.StreamKeyItemsPojo;
import com.lexington.mc.model.blockchain.util.EncryptionManager;
import com.lexington.mc.model.blockchain.util.HexConverter;
import com.lexington.mc.model.entities.EntityUser;
import com.lexington.mc.model.singletons.connection.BlockchainConnection;
import com.mallocinc.shared.util.time.TimestampUtility;

public class BlockchainUtilProvider {

   HexConverter      hexConverter      = new HexConverter();
   Gson              gson              = new Gson();


   public ArrayList<TransactionPojo> getDecodedTransactions(BlockPojo newBlock) {
      ArrayList<TransactionPojo> transactions = new ArrayList<>();

      for (int i = 0; i < newBlock.getTx().size(); i++) {
         TransactionPojo decodedTransaction = BlockchainConnection.getClient().getRawTransaction(newBlock.getTx().get(i));
         //		TransactionTo transaction = ConvertTransaction.convert(decodedTransaction, transactionTab, blockId);
         transactions.add(decodedTransaction);
      }
      return transactions;
   }
   public String getStreamType(TransactionPojo decodedTransaction) {
      Gson gson = new Gson();

      StreamDataWrapper streamWrapper = null;
      try{
         streamWrapper = gson.fromJson(hexConverter.convertFromHex(decodedTransaction.getData().get(0)), StreamDataWrapper.class);
      } catch(IllegalStateException | JsonSyntaxException e) {
         System.out.println("NullData transaction.");
      } catch(IndexOutOfBoundsException e1) {
         System.out.println("Stream creator - no data");
      }

      if(streamWrapper == null) {
         return BlockchainConstants.StreamTypes.NONE;
      }

      try {
//      StreamData streamData = gson.fromJson(EncryptionManager.decryptFromByteArray(streamWrapper.getData(), BlockchainConstants.General.KEY), StreamData.class);
        StreamData streamData = gson.fromJson(streamWrapper.getJSONData(), StreamData.class);
         return streamData.getType();
      } catch (NullPointerException e) {
         return "NULLDATA";
      }
   }	

   public PojoApi convertDataFromTransaction(TransactionPojo decodedTransaction, PojoApi pojo) {
      gson = new Gson();

      StreamDataWrapper streamWrapper = gson.fromJson(hexConverter.convertFromHex(decodedTransaction.getData().get(0)), StreamDataWrapper.class);

      
      String decryptedJson = null;
      
//      try {
//         decryptedJson = EncryptionManager.decryptFromByteArray(streamWrapper.getData(), BlockchainConstants.General.KEY);
//      } catch (EncryptionException e1) {
//         // TODO -MILOS HANDLE
//         e1.printStackTrace();
//      }
      
      decryptedJson = streamWrapper.getJSONData();

      StreamData streamData = gson.fromJson(decryptedJson, StreamData.class);

      String decryptedDataJson = gson.toJson(streamData.getData());

      try {
         pojo = gson.fromJson(decryptedDataJson, pojo.getClass());
      } catch(JsonSyntaxException e) {
         System.out.println("Error");
      }
      return pojo;
   }


   /**
    * This method will try to publish into login stream that the bank has logged in, if successful then return true.
    * @param walletAddress
    * @param privateKey
    * @return
    * @throws MessageException 
    */
   public boolean checkLoginCredentials(EntityUser user, String privateKey) throws MessageException {
      StreamDataCreator dataCreator = new StreamDataCreator();

      /**LoginPojo is not fully optimized for displaying data, for now it will only be used for authentication 
       * (We need to find a way how to implement unique identifier for this obj)
       * **/
      LoginPojo loginPojo = new LoginPojo();

      loginPojo.setLOGIN_ID(user.getEntityBank().getBank().getBANK_CODE()+BlockchainConstants.General.APPENDER+user.getUser().getUSER_NAME());
      loginPojo.setUSER_NAME(user.getUser().getUSER_NAME());
      loginPojo.setBANK_CODE(user.getEntityBank().getBank().getBANK_CODE());
      loginPojo.setCREATE_TIMESTAMP(TimestampUtility.getCurrentTimestamp());


      String streamName = user.getEntityBank().getBank().getBANK_CODE()+BlockchainConstants.General.APPENDER+BlockchainConstants.StreamNames.LOG_IN;

      String data = dataCreator.createDataStringFromObject(loginPojo, BlockchainConstants.StreamTypes.LOGIN_CREDENTIALS);

      String key = loginPojo.getLOGIN_ID();

      String address = user.getEntityBank().getBank().getWALLET_ADDRESS();


      String txId = null;
      try {
         txId = BlockchainConnection.getClient().publishToStream(streamName, key, data, privateKey, address);
      } catch (BlockchainClientException e) {
         if (e.getMessage().contains(BlockchainErrorMessages.PrivateKeys.INVALID_PRIVATE_KEY) || e.getMessage().contains(BlockchainErrorMessages.PrivateKeys.NON_STANDARD_TRANSACTION) ) {
            throw new MessageException("privateKeyError");
         }
         else if(e.getMessage().contains(BlockchainErrorMessages.Streams.UNSPENT_OUTPUTS)) {
            throw new MessageException(e.getMessage());
         }
         else {
            throw new MessageException("somethingWentWrong");
         }
      }
      return txId != null;
   }
   /**
    * This method will try to fetch the private key of this bank by decrypting its related stream using the provided encryption key
    * @param walletAddress
    * @param privateKey
    * @return
    * @throws MessageException 
    */

   /** TODO **/
   public String checkLoginCredentialsUsingEncryption(EntityUser user, String encryptionKey) throws MessageException {

      encryptionKey = EncryptionManager.fillPassword(encryptionKey);


      String streamDataWrapperString = null;
      try {
            streamDataWrapperString = BlockchainConnection.getClient().getLastItemFromStreamKey(user.getEntityBank().getBank().getBANK_CODE()+
            BlockchainConstants.General.APPENDER+
            BlockchainConstants.StreamNames.PRIVATE_KEY, user.getEntityBank().getBank().getBANK_CODE());
      }
       catch(BlockchainClientException e) {
          throw new MessageException(e.getMessage()); 
       }
      
      StreamDataWrapper wrapper = gson.fromJson(streamDataWrapperString, StreamDataWrapper.class);

      String streamDataString = null;
      try {
         streamDataString = EncryptionManager.decryptFromString(wrapper.getEncryptedStringData(), encryptionKey);
      } catch (EncryptionException e) {
         throw new MessageException("encryptionKeyError");
      }

      StreamData streamData = gson.fromJson(streamDataString, StreamData.class);

      String privateKey =  (String) streamData.getData();
      return privateKey;
   }
}
