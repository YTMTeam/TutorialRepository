package com.mallocinc.database.generated.to;

import com.mallocinc.codegenerator.superclasses.oracle.*;
import java.io.*;
import java.sql.*;
import java.util.Arrays;
import org.apache.log4j.Logger;

/****************************************************************
 *  <pre>
 *
 *  Generated Class: AccountTo.java
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
 *  This code is generated on: 2017-February-27 06:45:54 PM CET
 *
 *  Copyright (C) 2015 Malloc Inc.
 *
 *  </pre>
 ****************************************************************/
public class AccountTo extends BaseOracleToClass implements Serializable {

   final static Logger log = Logger.getLogger(AccountTo.class.getName());

   private static final long serialVersionUID = 1L;
   public static final String workingClassName ="AccountTab";

   /**********************************************************************
    *
    * Database Variables declarations
    *
    **********************************************************************/
   private java.lang.String ACCOUNT_ID = null;
private java.math.BigDecimal BANK_ID = null;
private java.math.BigDecimal ACCOUNT_NUMBER = null;
private java.lang.String FIRST_NAME = null;
private java.lang.String MIDDLE_NAME = null;
private java.lang.String LAST_NAME = null;
private java.lang.String TYPE = null;
private java.lang.String BROKER_CODE = null;
private java.lang.String MANAGED_ACCOUNT = null;
private java.lang.String ACCOUNT_STATUS = null;


   /**********************************************************************
    *
    * Setters
    *
    **********************************************************************/   
   public void setACCOUNT_ID( java.lang.String value ) {
      this.ACCOUNT_ID = value;
   }
   public void setBANK_ID( java.math.BigDecimal value ) {
      this.BANK_ID = value;
   }
   public void setACCOUNT_NUMBER( java.math.BigDecimal value ) {
      this.ACCOUNT_NUMBER = value;
   }
   public void setFIRST_NAME( java.lang.String value ) {
      this.FIRST_NAME = value;
   }
   public void setMIDDLE_NAME( java.lang.String value ) {
      this.MIDDLE_NAME = value;
   }
   public void setLAST_NAME( java.lang.String value ) {
      this.LAST_NAME = value;
   }
   public void setTYPE( java.lang.String value ) {
      this.TYPE = value;
   }
   public void setBROKER_CODE( java.lang.String value ) {
      this.BROKER_CODE = value;
   }
   public void setMANAGED_ACCOUNT( java.lang.String value ) {
      this.MANAGED_ACCOUNT = value;
   }
   public void setACCOUNT_STATUS( java.lang.String value ) {
      this.ACCOUNT_STATUS = value;
   }

   /**********************************************************************
    *
    * Getters
    *
    **********************************************************************/   
   //@JsonProperty("ACCOUNT_ID")
   public java.lang.String getACCOUNT_ID( ) {
      return this.ACCOUNT_ID;
   }
   //@JsonProperty("BANK_ID")
   public java.math.BigDecimal getBANK_ID( ) {
      return this.BANK_ID;
   }
   //@JsonProperty("ACCOUNT_NUMBER")
   public java.math.BigDecimal getACCOUNT_NUMBER( ) {
      return this.ACCOUNT_NUMBER;
   }
   //@JsonProperty("FIRST_NAME")
   public java.lang.String getFIRST_NAME( ) {
      return this.FIRST_NAME;
   }
   //@JsonProperty("MIDDLE_NAME")
   public java.lang.String getMIDDLE_NAME( ) {
      return this.MIDDLE_NAME;
   }
   //@JsonProperty("LAST_NAME")
   public java.lang.String getLAST_NAME( ) {
      return this.LAST_NAME;
   }
   //@JsonProperty("TYPE")
   public java.lang.String getTYPE( ) {
      return this.TYPE;
   }
   //@JsonProperty("BROKER_CODE")
   public java.lang.String getBROKER_CODE( ) {
      return this.BROKER_CODE;
   }
   //@JsonProperty("MANAGED_ACCOUNT")
   public java.lang.String getMANAGED_ACCOUNT( ) {
      return this.MANAGED_ACCOUNT;
   }
   //@JsonProperty("ACCOUNT_STATUS")
   public java.lang.String getACCOUNT_STATUS( ) {
      return this.ACCOUNT_STATUS;
   }
   
   /**********************************************************
    * 
    * This print() method is used for debugging.
    * 
    ***********************************************************/
   public void print() {
      log.debug("Transfer object - Begins:");
            String content;
      content = String.format("1.\t%-30s -> [%s]\n", "ACCOUNT_ID",  this.getACCOUNT_ID());
      log.debug(content);
      content = String.format("2.\t%-30s -> [%s]\n", "BANK_ID",  this.getBANK_ID());
      log.debug(content);
      content = String.format("3.\t%-30s -> [%s]\n", "ACCOUNT_NUMBER",  this.getACCOUNT_NUMBER());
      log.debug(content);
      content = String.format("4.\t%-30s -> [%s]\n", "FIRST_NAME",  this.getFIRST_NAME());
      log.debug(content);
      content = String.format("5.\t%-30s -> [%s]\n", "MIDDLE_NAME",  this.getMIDDLE_NAME());
      log.debug(content);
      content = String.format("6.\t%-30s -> [%s]\n", "LAST_NAME",  this.getLAST_NAME());
      log.debug(content);
      content = String.format("7.\t%-30s -> [%s]\n", "TYPE",  this.getTYPE());
      log.debug(content);
      content = String.format("8.\t%-30s -> [%s]\n", "BROKER_CODE",  this.getBROKER_CODE());
      log.debug(content);
      content = String.format("9.\t%-30s -> [%s]\n", "MANAGED_ACCOUNT",  this.getMANAGED_ACCOUNT());
      log.debug(content);
      content = String.format("10.\t%-30s -> [%s]\n", "ACCOUNT_STATUS",  this.getACCOUNT_STATUS());
      log.debug(content);

      log.debug("Transfer object - Ends.");
   }
}