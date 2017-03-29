package com.mallocinc.database.generated.to;

import com.mallocinc.codegenerator.superclasses.oracle.*;
import java.io.*;
import java.sql.*;
import java.util.Arrays;
import org.apache.log4j.Logger;

/****************************************************************
 *  <pre>
 *
 *  Generated Class: TradeTo.java
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
 *  This code is generated on: 2017-February-28 02:45:09 PM CET
 *
 *  Copyright (C) 2015 Malloc Inc.
 *
 *  </pre>
 ****************************************************************/
public class TradeTo extends BaseOracleToClass implements Serializable {

   final static Logger log = Logger.getLogger(TradeTo.class.getName());

   private static final long serialVersionUID = 1L;
   public static final String workingClassName ="TradeTab";

   /**********************************************************************
    *
    * Database Variables declarations
    *
    **********************************************************************/
   private java.lang.String TRADE_ID = null;
private java.math.BigDecimal TRANSACTION_ID = null;
private java.lang.String TRANSACTION_TYPE = null;
private java.lang.String ACCOUNT_ID = null;
private java.math.BigDecimal BANK_ID = null;
private java.math.BigDecimal QUANTITY = null;
private java.lang.String SECURITY_SYMBOL = null;
private java.lang.String CURRENCY = null;
private java.lang.String SECURITY_TYPE = null;
private java.lang.String SECURITY_NAME = null;
private java.math.BigDecimal EXECUTION_PRICE = null;
private java.math.BigDecimal NET_AMOUNT = null;
private java.lang.String EXCHANGE = null;
private java.lang.String CUSIP = null;
private java.lang.String ISIN = null;
private java.lang.String SEDOL = null;
private java.sql.Timestamp TRADE_DATE = null;
private java.sql.Timestamp CREATE_TIMESTAMP = null;


   /**********************************************************************
    *
    * Setters
    *
    **********************************************************************/   
   public void setTRADE_ID( java.lang.String value ) {
      this.TRADE_ID = value;
   }
   public void setTRANSACTION_ID( java.math.BigDecimal value ) {
      this.TRANSACTION_ID = value;
   }
   public void setTRANSACTION_TYPE( java.lang.String value ) {
      this.TRANSACTION_TYPE = value;
   }
   public void setACCOUNT_ID( java.lang.String value ) {
      this.ACCOUNT_ID = value;
   }
   public void setBANK_ID( java.math.BigDecimal value ) {
      this.BANK_ID = value;
   }
   public void setQUANTITY( java.math.BigDecimal value ) {
      this.QUANTITY = value;
   }
   public void setSECURITY_SYMBOL( java.lang.String value ) {
      this.SECURITY_SYMBOL = value;
   }
   public void setCURRENCY( java.lang.String value ) {
      this.CURRENCY = value;
   }
   public void setSECURITY_TYPE( java.lang.String value ) {
      this.SECURITY_TYPE = value;
   }
   public void setSECURITY_NAME( java.lang.String value ) {
      this.SECURITY_NAME = value;
   }
   public void setEXECUTION_PRICE( java.math.BigDecimal value ) {
      this.EXECUTION_PRICE = value;
   }
   public void setNET_AMOUNT( java.math.BigDecimal value ) {
      this.NET_AMOUNT = value;
   }
   public void setEXCHANGE( java.lang.String value ) {
      this.EXCHANGE = value;
   }
   public void setCUSIP( java.lang.String value ) {
      this.CUSIP = value;
   }
   public void setISIN( java.lang.String value ) {
      this.ISIN = value;
   }
   public void setSEDOL( java.lang.String value ) {
      this.SEDOL = value;
   }
   public void setTRADE_DATE( java.sql.Timestamp value ) {
      this.TRADE_DATE = value;
   }
   public void setCREATE_TIMESTAMP( java.sql.Timestamp value ) {
      this.CREATE_TIMESTAMP = value;
   }

   /**********************************************************************
    *
    * Getters
    *
    **********************************************************************/   
   //@JsonProperty("TRADE_ID")
   public java.lang.String getTRADE_ID( ) {
      return this.TRADE_ID;
   }
   //@JsonProperty("TRANSACTION_ID")
   public java.math.BigDecimal getTRANSACTION_ID( ) {
      return this.TRANSACTION_ID;
   }
   //@JsonProperty("TRANSACTION_TYPE")
   public java.lang.String getTRANSACTION_TYPE( ) {
      return this.TRANSACTION_TYPE;
   }
   //@JsonProperty("ACCOUNT_ID")
   public java.lang.String getACCOUNT_ID( ) {
      return this.ACCOUNT_ID;
   }
   //@JsonProperty("BANK_ID")
   public java.math.BigDecimal getBANK_ID( ) {
      return this.BANK_ID;
   }
   //@JsonProperty("QUANTITY")
   public java.math.BigDecimal getQUANTITY( ) {
      return this.QUANTITY;
   }
   //@JsonProperty("SECURITY_SYMBOL")
   public java.lang.String getSECURITY_SYMBOL( ) {
      return this.SECURITY_SYMBOL;
   }
   //@JsonProperty("CURRENCY")
   public java.lang.String getCURRENCY( ) {
      return this.CURRENCY;
   }
   //@JsonProperty("SECURITY_TYPE")
   public java.lang.String getSECURITY_TYPE( ) {
      return this.SECURITY_TYPE;
   }
   //@JsonProperty("SECURITY_NAME")
   public java.lang.String getSECURITY_NAME( ) {
      return this.SECURITY_NAME;
   }
   //@JsonProperty("EXECUTION_PRICE")
   public java.math.BigDecimal getEXECUTION_PRICE( ) {
      return this.EXECUTION_PRICE;
   }
   //@JsonProperty("NET_AMOUNT")
   public java.math.BigDecimal getNET_AMOUNT( ) {
      return this.NET_AMOUNT;
   }
   //@JsonProperty("EXCHANGE")
   public java.lang.String getEXCHANGE( ) {
      return this.EXCHANGE;
   }
   //@JsonProperty("CUSIP")
   public java.lang.String getCUSIP( ) {
      return this.CUSIP;
   }
   //@JsonProperty("ISIN")
   public java.lang.String getISIN( ) {
      return this.ISIN;
   }
   //@JsonProperty("SEDOL")
   public java.lang.String getSEDOL( ) {
      return this.SEDOL;
   }
   //@JsonProperty("TRADE_DATE")
   public java.sql.Timestamp getTRADE_DATE( ) {
      return this.TRADE_DATE;
   }
   //@JsonProperty("CREATE_TIMESTAMP")
   public java.sql.Timestamp getCREATE_TIMESTAMP( ) {
      return this.CREATE_TIMESTAMP;
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
      content = String.format("2.\t%-30s -> [%s]\n", "TRANSACTION_ID",  this.getTRANSACTION_ID());
      log.debug(content);
      content = String.format("3.\t%-30s -> [%s]\n", "TRANSACTION_TYPE",  this.getTRANSACTION_TYPE());
      log.debug(content);
      content = String.format("4.\t%-30s -> [%s]\n", "ACCOUNT_ID",  this.getACCOUNT_ID());
      log.debug(content);
      content = String.format("5.\t%-30s -> [%s]\n", "BANK_ID",  this.getBANK_ID());
      log.debug(content);
      content = String.format("6.\t%-30s -> [%s]\n", "QUANTITY",  this.getQUANTITY());
      log.debug(content);
      content = String.format("7.\t%-30s -> [%s]\n", "SECURITY_SYMBOL",  this.getSECURITY_SYMBOL());
      log.debug(content);
      content = String.format("8.\t%-30s -> [%s]\n", "CURRENCY",  this.getCURRENCY());
      log.debug(content);
      content = String.format("9.\t%-30s -> [%s]\n", "SECURITY_TYPE",  this.getSECURITY_TYPE());
      log.debug(content);
      content = String.format("10.\t%-30s -> [%s]\n", "SECURITY_NAME",  this.getSECURITY_NAME());
      log.debug(content);
      content = String.format("11.\t%-30s -> [%s]\n", "EXECUTION_PRICE",  this.getEXECUTION_PRICE());
      log.debug(content);
      content = String.format("12.\t%-30s -> [%s]\n", "NET_AMOUNT",  this.getNET_AMOUNT());
      log.debug(content);
      content = String.format("13.\t%-30s -> [%s]\n", "EXCHANGE",  this.getEXCHANGE());
      log.debug(content);
      content = String.format("14.\t%-30s -> [%s]\n", "CUSIP",  this.getCUSIP());
      log.debug(content);
      content = String.format("15.\t%-30s -> [%s]\n", "ISIN",  this.getISIN());
      log.debug(content);
      content = String.format("16.\t%-30s -> [%s]\n", "SEDOL",  this.getSEDOL());
      log.debug(content);
      content = String.format("17.\t%-30s -> [%s]\n", "TRADE_DATE",  this.getTRADE_DATE());
      log.debug(content);
      content = String.format("18.\t%-30s -> [%s]\n", "CREATE_TIMESTAMP",  this.getCREATE_TIMESTAMP());
      log.debug(content);

      log.debug("Transfer object - Ends.");
   }
}