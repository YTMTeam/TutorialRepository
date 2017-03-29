package com.mallocinc.database.generated.to;

import com.mallocinc.codegenerator.superclasses.oracle.*;
import java.io.*;
import java.sql.*;
import java.util.Arrays;
import org.apache.log4j.Logger;

/****************************************************************
 *  <pre>
 *
 *  Generated Class: VExcelTradeTo.java
 *
 *  TO (Transfer Object) Class  
 * 
 *  This lightweight class is used to hold and transfer data between 
 *  modules, threads, processes and applications.
 *  It is also suitable for data export and import.
 *
 *  Template version: 3.0
 *  Template date:    NLS missing message: template_date in: templates.gdao
 *  Template file:    /templates/Oracle/ToOracleTemplate.txt
 *  Target database:  Oracle 10g, 11g, 12c
 *
 *  @author Malloc Inc.
 *
 *  This code is generated on: 2017-February-27 06:45:58 PM CET
 *
 *  Copyright (C) 2015 Malloc Inc.
 *
 *  </pre>
 ****************************************************************/
public class VExcelTradeTo extends BaseOracleToClass implements Serializable {

   final static Logger log = Logger.getLogger(VExcelTradeTo.class.getName());

   private static final long serialVersionUID = 1L;
   public static final String workingClassName ="VExcelTradeTab";

   /**********************************************************************
    *
    * Database Variables declarations
    *
    **********************************************************************/
   private java.math.BigDecimal TRADE_ID = null;
private java.math.BigDecimal BANK_ID = null;
private java.lang.String ACCOUNT_ID = null;
private java.lang.String BANK_NAME = null;
private java.lang.String FIRST_NAME = null;
private java.lang.String LAST_NAME = null;
private java.lang.String TRANSACTION_TYPE = null;
private java.lang.String SECURITY_TYPE = null;
private java.math.BigDecimal NET_AMOUNT = null;
private java.lang.String CURRENCY = null;
private java.math.BigDecimal QUANTITY = null;
private java.lang.String EXCHANGE = null;
private java.sql.Timestamp TRADE_DATE = null;


   /**********************************************************************
    *
    * Setters
    *
    **********************************************************************/   
   public void setTRADE_ID( java.math.BigDecimal value ) {
      this.TRADE_ID = value;
   }
   public void setBANK_ID( java.math.BigDecimal value ) {
      this.BANK_ID = value;
   }
   public void setACCOUNT_ID( java.lang.String value ) {
      this.ACCOUNT_ID = value;
   }
   public void setBANK_NAME( java.lang.String value ) {
      this.BANK_NAME = value;
   }
   public void setFIRST_NAME( java.lang.String value ) {
      this.FIRST_NAME = value;
   }
   public void setLAST_NAME( java.lang.String value ) {
      this.LAST_NAME = value;
   }
   public void setTRANSACTION_TYPE( java.lang.String value ) {
      this.TRANSACTION_TYPE = value;
   }
   public void setSECURITY_TYPE( java.lang.String value ) {
      this.SECURITY_TYPE = value;
   }
   public void setNET_AMOUNT( java.math.BigDecimal value ) {
      this.NET_AMOUNT = value;
   }
   public void setCURRENCY( java.lang.String value ) {
      this.CURRENCY = value;
   }
   public void setQUANTITY( java.math.BigDecimal value ) {
      this.QUANTITY = value;
   }
   public void setEXCHANGE( java.lang.String value ) {
      this.EXCHANGE = value;
   }
   public void setTRADE_DATE( java.sql.Timestamp value ) {
      this.TRADE_DATE = value;
   }

   /**********************************************************************
    *
    * Getters
    *
    **********************************************************************/   
   //@JsonProperty("TRADE_ID")
   public java.math.BigDecimal getTRADE_ID( ) {
      return this.TRADE_ID;
   }
   //@JsonProperty("BANK_ID")
   public java.math.BigDecimal getBANK_ID( ) {
      return this.BANK_ID;
   }
   //@JsonProperty("ACCOUNT_ID")
   public java.lang.String getACCOUNT_ID( ) {
      return this.ACCOUNT_ID;
   }
   //@JsonProperty("BANK_NAME")
   public java.lang.String getBANK_NAME( ) {
      return this.BANK_NAME;
   }
   //@JsonProperty("FIRST_NAME")
   public java.lang.String getFIRST_NAME( ) {
      return this.FIRST_NAME;
   }
   //@JsonProperty("LAST_NAME")
   public java.lang.String getLAST_NAME( ) {
      return this.LAST_NAME;
   }
   //@JsonProperty("TRANSACTION_TYPE")
   public java.lang.String getTRANSACTION_TYPE( ) {
      return this.TRANSACTION_TYPE;
   }
   //@JsonProperty("SECURITY_TYPE")
   public java.lang.String getSECURITY_TYPE( ) {
      return this.SECURITY_TYPE;
   }
   //@JsonProperty("NET_AMOUNT")
   public java.math.BigDecimal getNET_AMOUNT( ) {
      return this.NET_AMOUNT;
   }
   //@JsonProperty("CURRENCY")
   public java.lang.String getCURRENCY( ) {
      return this.CURRENCY;
   }
   //@JsonProperty("QUANTITY")
   public java.math.BigDecimal getQUANTITY( ) {
      return this.QUANTITY;
   }
   //@JsonProperty("EXCHANGE")
   public java.lang.String getEXCHANGE( ) {
      return this.EXCHANGE;
   }
   //@JsonProperty("TRADE_DATE")
   public java.sql.Timestamp getTRADE_DATE( ) {
      return this.TRADE_DATE;
   }
   
   /**********************************************************
    * 
    * This print() method is used for debugging.
    * 
    ***********************************************************/
   public void print() {
      log.debug("Transfer object - Begins:");
            String content;
      content = String.format("1.\t%-30s -> [%s]\n", "TRADE_ID",  this.getTRADE_ID());
      log.debug(content);
      content = String.format("2.\t%-30s -> [%s]\n", "BANK_ID",  this.getBANK_ID());
      log.debug(content);
      content = String.format("3.\t%-30s -> [%s]\n", "ACCOUNT_ID",  this.getACCOUNT_ID());
      log.debug(content);
      content = String.format("4.\t%-30s -> [%s]\n", "BANK_NAME",  this.getBANK_NAME());
      log.debug(content);
      content = String.format("5.\t%-30s -> [%s]\n", "FIRST_NAME",  this.getFIRST_NAME());
      log.debug(content);
      content = String.format("6.\t%-30s -> [%s]\n", "LAST_NAME",  this.getLAST_NAME());
      log.debug(content);
      content = String.format("7.\t%-30s -> [%s]\n", "TRANSACTION_TYPE",  this.getTRANSACTION_TYPE());
      log.debug(content);
      content = String.format("8.\t%-30s -> [%s]\n", "SECURITY_TYPE",  this.getSECURITY_TYPE());
      log.debug(content);
      content = String.format("9.\t%-30s -> [%s]\n", "NET_AMOUNT",  this.getNET_AMOUNT());
      log.debug(content);
      content = String.format("10.\t%-30s -> [%s]\n", "CURRENCY",  this.getCURRENCY());
      log.debug(content);
      content = String.format("11.\t%-30s -> [%s]\n", "QUANTITY",  this.getQUANTITY());
      log.debug(content);
      content = String.format("12.\t%-30s -> [%s]\n", "EXCHANGE",  this.getEXCHANGE());
      log.debug(content);
      content = String.format("13.\t%-30s -> [%s]\n", "TRADE_DATE",  this.getTRADE_DATE());
      log.debug(content);

      log.debug("Transfer object - Ends.");
   }
}