package com.lexington.mc.model.blockchain.pojos.streams;



/**
 * This is Hexed object that is being sent to blockchain
 * @author Dev
 *
 */
public class StreamDataWrapper {
   /**
    * This field has information to whom this message is assigned
    */
   String bankSigned;

   /**
    * This field is encrypted JSON string (Serialized StreamData.java)
    */
   byte[] encryptedByteData;

   /**
    * This field is encrypted JSON string into encrypted String
    */
   String encryptedStringData;
   
   /**
    * This field is for not encrypted JSON string
    */
   String jsonData;

   public String getBankSigned() {
      return bankSigned;
   }
   public void setBankSigned(String bankSigned) {
      this.bankSigned = bankSigned;
   }
   public byte[] getEncryptedByteData() {
      return encryptedByteData;
   }
   public void setEncryptedByteData(byte[] encryptedByteData) {
      this.encryptedByteData = encryptedByteData;
   }
   public String getJSONData() {
      return jsonData;
   }
   public void setJSONData(String jsonData) {
      this.jsonData = jsonData;
   }
   public String getEncryptedStringData() {
      return encryptedStringData;
   }
   public void setEncryptedStringData(String encryptedStringData) {
      this.encryptedStringData = encryptedStringData;
   }

}
