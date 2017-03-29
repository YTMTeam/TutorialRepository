package com.lexington.mc.model.blockchain.common;

import com.google.gson.Gson;
import com.lexington.mc.model.blockchain.exception.EncryptionException;
import com.lexington.mc.model.blockchain.pojos.PojoApi;
import com.lexington.mc.model.blockchain.pojos.streams.StreamData;
import com.lexington.mc.model.blockchain.pojos.streams.StreamDataWrapper;
import com.lexington.mc.model.blockchain.util.EncryptionManager;
import com.lexington.mc.model.blockchain.util.HexConverter;

public class StreamDataCreator {
   
Gson gson = new Gson();
   
   /**
    * This method returns hex string used in order to publish data into stream
    * @param pojoObject
    * @param streamType - see possible values: BlockchainConstants.StreamTypes
    * @return
    */
   public String createDataStringFromObject(PojoApi pojoObject, String streamType) {
      
      StreamData streamData = new StreamData();
      streamData.setData(pojoObject);
      streamData.setType(streamType);
      String streamDataString = gson.toJson(streamData);

//      byte[] encryptedData = null;
//      try {
//         encryptedData = EncryptionManager.encryptToByteArray(streamDataString,BlockchainConstants.General.KEY);
//      } catch (EncryptionException e) {
//         // TODO Auto-generated catch block
//         e.printStackTrace();
//      }

      StreamDataWrapper sWrapper = new StreamDataWrapper();
//      sWrapper.setData(encryptedData);
      sWrapper.setJSONData(streamDataString);
      String data = gson.toJson(sWrapper);

      String hexData = new HexConverter().convertToHex(data);
      return hexData;
   }
}
