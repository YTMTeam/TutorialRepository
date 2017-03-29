package com.lexington.mc.model.blockchain.pojos;


import com.mallocinc.codegenerator.superclasses.oracle.*;
import com.mallocinc.database.generated.to.BankTo;

import java.io.*;
import java.math.BigDecimal;
import java.sql.*;
import java.util.Arrays;

import org.apache.log4j.Logger;


public class BankPojo extends PojoApi {
   final static Logger log = Logger.getLogger(BankTo.class.getName());

   private static final long serialVersionUID = 1L;
   public static final String workingClassName ="BankTab";

   /**********************************************************************
    *
    * Database Variables declarations
    *
    **********************************************************************/
   private java.math.BigDecimal BANK_ID = null;
   private java.lang.String BANK_CODE = null;
   private java.lang.String BANK_NAME = null;
   private java.lang.String WALLET_ADDRESS = null;
   private byte[] BANK_LOGO = null;
   private java.lang.String KEY_CODE = null;


   /**********************************************************************
    *
    * Setters
    *
    **********************************************************************/   
   public void setBANK_ID( java.math.BigDecimal value ) {
      this.BANK_ID = value;
   }
   public void setBANK_CODE( java.lang.String value ) {
      this.BANK_CODE = value;
   }
   public void setWALLET_ADDRESS( java.lang.String value ) {
      this.WALLET_ADDRESS = value;
   }
   public void setBANK_NAME( java.lang.String value ) {
      this.BANK_NAME = value;
   }
   public void setBANK_LOGO( byte[] value ) {
      if (value != null) {   this.BANK_LOGO = Arrays.copyOf(value, value.length);
      } else {  this.BANK_LOGO = null;}}
   public void setKEY_CODE( java.lang.String value ) {
      this.KEY_CODE = value;
   }

   /**********************************************************************
    *
    * Getters
    *
    **********************************************************************/   
   //@JsonProperty("BANK_ID")
   public java.math.BigDecimal getBANK_ID( ) {
      return this.BANK_ID;
   }
   //@JsonProperty("BANK_CODE")
   public java.lang.String getBANK_CODE( ) {
      return this.BANK_CODE;
   }
   //@JsonProperty("BANK_NAME")
   public java.lang.String getBANK_NAME( ) {
      return this.BANK_NAME;
   }
   //@JsonProperty("WALLET_ADDRESS")
   public java.lang.String getWALLET_ADDRESS( ) {
      return this.WALLET_ADDRESS;
   }
   //@JsonProperty("BANK_LOGO")
   public byte[] getBANK_LOGO( ) {
      return this.BANK_LOGO;
   }
   //@JsonProperty("KEY_CODE")
   public java.lang.String getKEY_CODE( ) {
      return this.KEY_CODE;
   }

   /**********************************************************
    * 
    * This print() method is used for debugging.
    * 
    ***********************************************************/
   public void print() {
      log.debug("Transfer object - Begins:");
      String content;
      content = String.format("1.\t%-30s -> [%s]\n", "BANK_ID",  this.getBANK_ID());
      log.debug(content);
      content = String.format("2.\t%-30s -> [%s]\n", "BANK_CODE",  this.getBANK_CODE());
      log.debug(content);
      content = String.format("3.\t%-30s -> [%s]\n", "BANK_NAME",  this.getBANK_NAME());
      log.debug(content);
      content = String.format("4.\t%-30s -> [%s]\n", "BANK_LOGO",  this.getBANK_LOGO());
      log.debug(content);
      content = String.format("5.\t%-30s -> [%s]\n", "KEY_CODE",  this.getKEY_CODE());
      log.debug(content);

      log.debug("Transfer object - Ends.");
   }


   public String getRowKey() {
      return BANK_ID.toString();
   }
}