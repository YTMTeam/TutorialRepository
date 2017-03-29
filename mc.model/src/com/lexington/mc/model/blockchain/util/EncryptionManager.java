package com.lexington.mc.model.blockchain.util;



import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.lexington.mc.model.blockchain.exception.EncryptionException;


public class EncryptionManager {

	public static final String ALGORITHM = "AES";
	
	public static byte[] encryptToByteArray(String value , String keyString) throws EncryptionException {
		
		byte[] encrypted = null;
		try {

			byte[] raw =  keyString.getBytes(StandardCharsets.UTF_8);

			Key skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			byte[] iv = new byte[cipher.getBlockSize()];

			IvParameterSpec ivParams = new IvParameterSpec(iv);
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec,ivParams);
			encrypted  = cipher.doFinal(value.getBytes());
			System.out.println("Encrypted string length: " + encrypted.length);
			System.out.println("Encrypted string value: "+new String(encrypted));

		} catch (Exception ex) {
	         throw new EncryptionException();
		}
		return encrypted;
	}
	public static String encryptToString(String value , String keyString) throws EncryptionException {
	   
	   byte[] encrypted = null;
	   try {
	      
	      byte[] raw =  keyString.getBytes(StandardCharsets.UTF_8);
	      
	      Key skeySpec = new SecretKeySpec(raw, "AES");
	      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	      byte[] iv = new byte[cipher.getBlockSize()];
	      
	      IvParameterSpec ivParams = new IvParameterSpec(iv);
	      cipher.init(Cipher.ENCRYPT_MODE, skeySpec,ivParams);
	      encrypted  = cipher.doFinal(value.getBytes());
	      System.out.println("Encrypted string length: " + encrypted.length);
	      
	   } catch (Exception ex) {
         throw new EncryptionException();

	   }
	   
	   String encrString =  Base64.getEncoder().encodeToString(encrypted);
	   System.out.println(encrString);
	   return encrString;
	}

	public static  String  decryptFromByteArray(byte[] encrypted, String keyString) throws EncryptionException {
		byte[] original = null;
		Cipher cipher = null;
		try {

			byte[] raw =  keyString.getBytes(StandardCharsets.UTF_8);

			Key key = new SecretKeySpec(raw, "AES");
			cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			//the block size (in bytes), or 0 if the underlying algorithm is not a block cipher
			byte[] ivByte = new byte[cipher.getBlockSize()];
			//This class specifies an initialization vector (IV). Examples which use
			//IVs are ciphers in feedback mode, e.g., DES in CBC mode and RSA ciphers with OAEP encoding operation.
			IvParameterSpec ivParamsSpec = new IvParameterSpec(ivByte);
			cipher.init(Cipher.DECRYPT_MODE, key, ivParamsSpec);
			original= cipher.doFinal(encrypted);
		} catch (Exception ex) {
			throw new EncryptionException();
		}
		return new String(original,StandardCharsets.UTF_8);
	}
	public static  String  decryptFromString(String encryptedString, String keyString) throws EncryptionException {
	   
	   byte[] encrypted = Base64.getDecoder().decode(encryptedString);
	   byte[] original = null;
	   Cipher cipher = null;
	   try {
	      
	      byte[] raw =  keyString.getBytes(StandardCharsets.UTF_8);
	      
	      Key key = new SecretKeySpec(raw, "AES");
	      cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	      //the block size (in bytes), or 0 if the underlying algorithm is not a block cipher
	      byte[] ivByte = new byte[cipher.getBlockSize()];
	      //This class specifies an initialization vector (IV). Examples which use
	      //IVs are ciphers in feedback mode, e.g., DES in CBC mode and RSA ciphers with OAEP encoding operation.
	      IvParameterSpec ivParamsSpec = new IvParameterSpec(ivByte);
	      cipher.init(Cipher.DECRYPT_MODE, key, ivParamsSpec);
	      original= cipher.doFinal(encrypted);
	   } catch (Exception ex) {
	      throw new EncryptionException();
	   }
	   return new String(original,StandardCharsets.UTF_8);
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException, EncryptionException {
      EncryptionManager em = new EncryptionManager();
      
     String encryption = em.encryptToString("this is random string", "thisisasecretaco");
     
    // String encrString =  Base64.getEncoder().encodeToString(encryption);
     
     String decrypted = em.decryptFromString(encryption, "thisisasecretaco");
     
     System.out.println(decrypted);
   }
	   public static String fillPassword(String password) {
	       
	       String newPassword = password;
	       
	       while(newPassword.length()<16) {
	          newPassword = newPassword + "A";
	       }
	       return newPassword; 
	    }
	   
}
