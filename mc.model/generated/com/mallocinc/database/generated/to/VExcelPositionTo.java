package com.mallocinc.database.generated.to;

import com.mallocinc.codegenerator.superclasses.oracle.*;
import java.io.*;
import java.sql.*;
import java.util.Arrays;
import org.apache.log4j.Logger;

/****************************************************************
 *  <pre>
 *
 *  Generated Class: VExcelPositionTo.java
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
public class VExcelPositionTo extends BaseOracleToClass implements Serializable {

   final static Logger log = Logger.getLogger(VExcelPositionTo.class.getName());

   private static final long serialVersionUID = 1L;
   public static final String workingClassName ="VExcelPositionTab";

   /**********************************************************************
    *
    * Database Variables declarations
    *
    **********************************************************************/
   private java.lang.String ACCOUNT_ID = null;
private java.math.BigDecimal BANK_ID = null;
private java.math.BigDecimal ACCOUNT_NUMBER = null;
private java.lang.String FIRST_NAME = null;
private java.lang.String LAST_NAME = null;
private java.lang.String BANK_NAME = null;
private java.lang.String SECURITY_SYMBOL = null;
private java.math.BigDecimal QUANTITY = null;


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
   public void setLAST_NAME( java.lang.String value ) {
      this.LAST_NAME = value;
   }
   public void setBANK_NAME( java.lang.String value ) {
      this.BANK_NAME = value;
   }
   public void setSECURITY_SYMBOL( java.lang.String value ) {
      this.SECURITY_SYMBOL = value;
   }
   public void setQUANTITY( java.math.BigDecimal value ) {
      this.QUANTITY = value;
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
   //@JsonProperty("LAST_NAME")
   public java.lang.String getLAST_NAME( ) {
      return this.LAST_NAME;
   }
   //@JsonProperty("BANK_NAME")
   public java.lang.String getBANK_NAME( ) {
      return this.BANK_NAME;
   }
   //@JsonProperty("SECURITY_SYMBOL")
   public java.lang.String getSECURITY_SYMBOL( ) {
      return this.SECURITY_SYMBOL;
   }
   //@JsonProperty("QUANTITY")
   public java.math.BigDecimal getQUANTITY( ) {
      return this.QUANTITY;
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
      content = String.format("5.\t%-30s -> [%s]\n", "LAST_NAME",  this.getLAST_NAME());
      log.debug(content);
      content = String.format("6.\t%-30s -> [%s]\n", "BANK_NAME",  this.getBANK_NAME());
      log.debug(content);
      content = String.format("7.\t%-30s -> [%s]\n", "SECURITY_SYMBOL",  this.getSECURITY_SYMBOL());
      log.debug(content);
      content = String.format("8.\t%-30s -> [%s]\n", "QUANTITY",  this.getQUANTITY());
      log.debug(content);

      log.debug("Transfer object - Ends.");
   }
}