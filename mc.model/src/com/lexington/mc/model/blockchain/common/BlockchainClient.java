package com.lexington.mc.model.blockchain.common;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lexington.mc.model.blockchain.exception.BlockchainClientException;
import com.lexington.mc.model.blockchain.exception.ExceptionMessageHandler;
import com.lexington.mc.model.blockchain.exception.HttpSessionException;
import com.lexington.mc.model.blockchain.pojos.BlockPojo;
import com.lexington.mc.model.blockchain.pojos.TransactionPojo;
import com.lexington.mc.model.blockchain.pojos.streams.StreamKeyItemsPojo;
import com.lexington.mc.model.blockchain.pojos.streams.StreamKeyPojo;
import com.lexington.mc.model.blockchain.util.HexConverter;
import com.lexington.mc.model.singletons.connection.BlockchainConnection;

public class BlockchainClient {

   private static final Logger logger = Logger.getLogger(BlockchainClient.class);

   private BigDecimal currentBlockHeight = new BigDecimal(0);

   private HttpClient client = null;

   public BlockchainClient() {
      this.client = new HttpClient();
   }

   public BlockchainClient(HttpClient client) {
      this.client = client;
   }

   public void setSession(HttpClient client) {
      this.client = client;
   }

   public  BigDecimal getCurrentBlockHeight() {
      return currentBlockHeight;
   }

   public  void setCurrentBlockHeight(BigDecimal currentBlockHeight) {
      this.currentBlockHeight = currentBlockHeight;
   }

   private JSONObject createRequest(String method, JSONArray parameters) {
      JSONObject request = new JSONObject();
      request.put("jsonrpc", "2.0");
      request.put("id",      UUID.randomUUID().toString());
      request.put("method", method);
      request.put("params",  parameters);        
      return request;
   }

   private JSONObject getResponse(String method, JSONArray parameters){
      JSONObject jsonRequest = createRequest(method, parameters);
      JSONObject jsonResponse = client.sendAndReceive(jsonRequest);
      return jsonResponse;            
   }

   @SuppressWarnings("unchecked")
   public BlockPojo getBlock(String blockNum) {
      JSONArray parameters = new JSONArray();
      parameters.add(blockNum);
      String method = "getblock";
      JSONObject response = this.getResponse(method,parameters);  
      JSONObject error = (JSONObject) response.get("error");            
      if(error != null){
         logger.error("Response Error: '" + method + "' " + error.get("message").toString());
         if(error.get("message").toString().contains("Block height out of range")) {
            return null;
         }
         throw new BlockchainClientException("Response Error: '" + method + "' " + error.get("message").toString());
      } 
      Gson gson = new Gson();
      BlockPojo block = gson.fromJson(response.get("result").toString(), BlockPojo.class);
      return block;
   }
   @SuppressWarnings("unchecked")
   public TransactionPojo getRawTransaction(String hash) {
      JSONArray parameters = new JSONArray();
      parameters.add(hash);		parameters.add(1);
      String method = "getrawtransaction";
      JSONObject response = this.getResponse(method,parameters);  
      JSONObject error = (JSONObject) response.get("error");            
      if(error != null){
         logger.error("Response Error: '" + method + "' " + error.get("message").toString());
         throw new BlockchainClientException("Response Error: '" + method + "' " + error.get("message").toString());
      } 
      String responseString = response.get("result").toString();
      //			System.out.println(responseString);
      Gson gson = new Gson();
      TransactionPojo entityDecodedTransaction = gson.fromJson(responseString, TransactionPojo.class);

      return entityDecodedTransaction;
   }
   @SuppressWarnings("unchecked")
   public TransactionPojo decodeRawTransaction(String rawTransaction) {
      JSONArray parameters = new JSONArray();
      parameters.add(rawTransaction);
      String method = "decoderawtransaction";
      JSONObject response = this.getResponse(method,parameters);  
      JSONObject error = (JSONObject) response.get("error");            
      if(error != null){
         logger.error("Response Error: '" + method + "' " + error.get("message").toString());
         throw new BlockchainClientException("Response Error: '" + method + "' " + error.get("message").toString());
      } 
      String responseString = response.get("result").toString();

      Gson gson = new Gson();
      TransactionPojo entityDecodedTransaction = gson.fromJson(responseString, TransactionPojo.class);
      return entityDecodedTransaction;
   }
   /**
    * Stream specific API's
    * @param streamName
    * @param key
    * @return
    */
   @SuppressWarnings("unchecked")
   public ArrayList<StreamKeyItemsPojo> listStreamKeyItems(String streamName, String key) throws BlockchainClientException {
      JSONArray parameters = new JSONArray();
      parameters.add(streamName);
      parameters.add(key);

      String method = "liststreamkeyitems"; 
      JSONObject response = new JSONObject();

      try {
         response = this.getResponse(method,parameters);  
      } catch(HttpSessionException e) {
         throw new BlockchainClientException(ExceptionMessageHandler.handleBlockchainClientMessage(e.getMessage()));
      }
      JSONObject error = (JSONObject) response.get("error");            
      if(error != null){
         logger.error("Response Error: '" + method + "' " + error.get("message").toString());
         System.out.println(error.get("message").toString());
         throw new BlockchainClientException(ExceptionMessageHandler.handleBlockchainClientMessage(error.get("message").toString()));
      } 
      String responseString = response.get("result").toString();

      Type listOfTestObject = new TypeToken<ArrayList<StreamKeyItemsPojo>>(){}.getType();
      Gson gson = new Gson();
      ArrayList<StreamKeyItemsPojo> streamKeyItems = gson.fromJson(responseString.toString(), listOfTestObject);

      return streamKeyItems;
   }
   
   public String getLastItemFromStreamKey(String streamName, String key) throws BlockchainClientException {
      ArrayList<StreamKeyItemsPojo> streamKeyItems = listStreamKeyItems(streamName, key);
      
      StreamKeyItemsPojo item;
      try {
         item = streamKeyItems.get(streamKeyItems.size()-1);
      } catch (IndexOutOfBoundsException e) {
         throw new BlockchainClientException("streamItemsEmpty");
      }


      String streamDataWrapperString = new HexConverter().convertFromHex(item.getData());
      
      return streamDataWrapperString;

   }
   @SuppressWarnings("unchecked")
   public ArrayList<StreamKeyPojo> listStreamKeys(String streamName) {
      JSONArray parameters = new JSONArray();
      parameters.add(streamName);
      
      String method = "liststreamkeys"; 
      JSONObject response = new JSONObject();
      
      try {
         response = this.getResponse(method,parameters);  
      } catch(HttpSessionException e) {
         throw new BlockchainClientException(ExceptionMessageHandler.handleBlockchainClientMessage(e.getMessage()));
      }
      JSONObject error = (JSONObject) response.get("error");            
      if(error != null){
         logger.error("Response Error: '" + method + "' " + error.get("message").toString());
         System.out.println(error.get("message").toString());
         throw new BlockchainClientException(ExceptionMessageHandler.handleBlockchainClientMessage(error.get("message").toString()));
      } 
      String responseString = response.get("result").toString();
      
      Type listOfTestObject = new TypeToken<ArrayList<StreamKeyPojo>>(){}.getType();
      Gson gson = new Gson();
      ArrayList<StreamKeyPojo> streamKeys = gson.fromJson(responseString.toString(), listOfTestObject);
      
      return streamKeys;
   }

   @SuppressWarnings("unchecked")
   public String createStream(String streamName) throws BlockchainClientException {
      JSONArray parameters = new JSONArray();
      parameters.add("stream");
      parameters.add(streamName);
      parameters.add(true);

      String method = "create";
      JSONObject response = this.getResponse(method,parameters);  
      JSONObject error = (JSONObject) response.get("error");            
      if(error != null){
         logger.error("Response Error: '" + method + "' " + error.get("message").toString());
         throw new BlockchainClientException("Response Error: '" + method + "' " + error.get("message").toString());
      } 
      String responseString = response.get("result").toString();
      return responseString;
   }

   @SuppressWarnings("unchecked")
   private String publishToStreamSigned(String streamName, String key, String data) throws BlockchainClientException {
      JSONArray parameters = new JSONArray();
      parameters.add(streamName);
      parameters.add(key);
      parameters.add(data);

      String method = "publish";
      JSONObject response = this.getResponse(method,parameters);  
      JSONObject error = (JSONObject) response.get("error");            
      if(error != null){
         logger.error("Response Error: '" + method + "' " + error.get("message").toString());
         throw new BlockchainClientException("Response Error: '" + method + "' " + error.get("message").toString());
      } 
      String responseString = response.get("result").toString();
      return responseString;
   }
   @SuppressWarnings("unchecked")
   public String publishToStream(String streamName, String key, String data) throws BlockchainClientException {
      String txId = null;
      try {
     txId = publishToStreamSigned(streamName, key, data);
      } catch (BlockchainClientException e) {
         txId = e.getMessage();
         if(e.getMessage().contains(BlockchainErrorMessages.Streams.STREAM_NOT_FOUND)) {
            logger.info("Creating a stream and trying again...");
            createStream(streamName);
            
         txId = publishToStream(streamName, key, data);
         }
      }
      return txId;
   }
   
   public String publishToStream(String streamName, String key, String data, String privateKey, String address) {
      
      String txId = null;
      try {
     txId = publishToStreamUnsigned(streamName, key, data, privateKey, address);
      } catch (BlockchainClientException e) {
         txId = e.getMessage();
         if(e.getMessage().contains(BlockchainErrorMessages.Streams.STREAM_NOT_FOUND)) {
            logger.info("Creating a stream and trying again...");
            createStream(streamName);
            
         txId = publishToStream(streamName, key, data, privateKey, address);
         } else if(e.getMessage().contains(BlockchainErrorMessages.Streams.UNSPENT_OUTPUTS)) {
            logger.info("Unspent output error...");
            throw new BlockchainClientException(e);
                   }
         else {
            throw new BlockchainClientException(e);
         }
      }
      return txId;
   }
   
   /**
    * This is a wrapper method that contains multiple API calls to the blockchain in order to publish into stream externally
    * @param streamName
    * @param key
    * @param data
    * @param privateKey
    * @param address
    * @return
    * @throws BlockchainClientException
    */
   @SuppressWarnings("unchecked")
   private String publishToStreamUnsigned(String streamName, String key, String data, String privateKey, String address) throws BlockchainClientException {   

      String rawHex = createRawSendFrom(address, streamName, key, data);
      String signedHex = signRawTransaction(rawHex, privateKey);
      String txId = sendRawTransaction(signedHex);
      System.out.println(txId);
      return txId;

   }

   private String createRawSendFrom(String address, String streamName, String key, String data) {

      JSONObject streamObject = new JSONObject();
      streamObject.put("for", streamName);
      streamObject.put("key", key);
      streamObject.put("data", data);

      JSONArray streamArray = new JSONArray();
      streamArray.add(streamObject);
      
      JSONArray parameters = new JSONArray();

      parameters.add(address);
      parameters.add(new JSONObject());
      parameters.add(streamArray);

      String method = "createrawsendfrom";
      JSONObject response = this.getResponse(method,parameters);  
      JSONObject error = (JSONObject) response.get("error");            
      if(error != null){
         logger.error("Response Error: '" + method + "' " + error.get("message").toString());
         throw new BlockchainClientException("Response Error: '" + method + "' " + error.get("message").toString());
      } 
      String responseString = response.get("result").toString();
      return responseString;      
   }

   private String signRawTransaction(String rawHex, String privateKey) {

      JSONArray privateKeyJSONArray =new JSONArray();
      
      privateKeyJSONArray.add(privateKey);

      JSONArray parameters = new JSONArray();
      parameters.add(rawHex);
      parameters.add(new JSONArray());
      parameters.add(privateKeyJSONArray);

      String method = "signrawtransaction";
      JSONObject response = this.getResponse(method,parameters);  
      JSONObject error = (JSONObject) response.get("error");            
      if(error != null){
         logger.error("Response Error: '" + method + "' " + error.get("message").toString());
         throw new BlockchainClientException("Response Error: '" + method + "' " + error.get("message").toString());
      } 
      JSONObject responseString = (JSONObject) response.get("result");
      return responseString.get("hex").toString();      

   }

   private String sendRawTransaction(String signedHex) {


      JSONArray parameters = new JSONArray();
      parameters.add(signedHex);

      String method = "sendrawtransaction";
      JSONObject response = this.getResponse(method,parameters);  
      JSONObject error = (JSONObject) response.get("error");            
      if(error != null){
         logger.error("Response Error: '" + method + "' " + error.get("message").toString());
         throw new BlockchainClientException("Response Error: '" + method + "' " + error.get("message").toString());
      } 
      String responseString = response.get("result").toString();
      return responseString;      

   }


   public static void main(String[] args) {
      BlockchainConnection.getClient().publishToStream("streamsek3", "key1", "45787465726e616c20697320736166657374","V874owKBXJeP4psiRqPokrM3tKZuwbaFApK7ojRT1BYjC8btGRmYKSmy","1ZogB4Au3EVkye7boQLoebMNu6XavQaZmx1hLg");
   }
}
