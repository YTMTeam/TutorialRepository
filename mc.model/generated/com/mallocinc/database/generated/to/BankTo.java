package com.mallocinc.database.generated.to;

import com.mallocinc.codegenerator.superclasses.oracle.*;
import java.io.*;
import java.sql.*;
import java.util.Arrays;
import org.apache.log4j.Logger;

/****************************************************************
 *  <pre>
 *
 *  Generated Class: BankTo.java
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
public class BankTo extends BaseOracleToClass implements Serializable {

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
}