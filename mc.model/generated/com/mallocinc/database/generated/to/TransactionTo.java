package com.mallocinc.database.generated.to;

import com.mallocinc.codegenerator.superclasses.oracle.*;
import java.io.*;
import java.sql.*;
import java.util.Arrays;
import org.apache.log4j.Logger;

/****************************************************************
 *  <pre>
 *
 *  Generated Class: TransactionTo.java
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
 *  This code is generated on: 2017-February-27 06:45:56 PM CET
 *
 *  Copyright (C) 2015 Malloc Inc.
 *
 *  </pre>
 ****************************************************************/
public class TransactionTo extends BaseOracleToClass implements Serializable {

   final static Logger log = Logger.getLogger(TransactionTo.class.getName());

   private static final long serialVersionUID = 1L;
   public static final String workingClassName ="TransactionTab";

   /**********************************************************************
    *
    * Database Variables declarations
    *
    **********************************************************************/
   private java.math.BigDecimal TRANSACTION_ID = null;
private java.math.BigDecimal BLOCK_ID = null;
private java.lang.String TRANSACTION_HASH = null;
private java.math.BigDecimal VERSION = null;
private java.math.BigDecimal LOCKTIME = null;
private java.sql.Timestamp CREATE_TIMESTAMP = null;
private java.lang.String TYPE = null;


   /**********************************************************************
    *
    * Setters
    *
    **********************************************************************/   
   public void setTRANSACTION_ID( java.math.BigDecimal value ) {
      this.TRANSACTION_ID = value;
   }
   public void setBLOCK_ID( java.math.BigDecimal value ) {
      this.BLOCK_ID = value;
   }
   public void setTRANSACTION_HASH( java.lang.String value ) {
      this.TRANSACTION_HASH = value;
   }
   public void setVERSION( java.math.BigDecimal value ) {
      this.VERSION = value;
   }
   public void setLOCKTIME( java.math.BigDecimal value ) {
      this.LOCKTIME = value;
   }
   public void setCREATE_TIMESTAMP( java.sql.Timestamp value ) {
      this.CREATE_TIMESTAMP = value;
   }
   public void setTYPE( java.lang.String value ) {
      this.TYPE = value;
   }

   /**********************************************************************
    *
    * Getters
    *
    **********************************************************************/   
   //@JsonProperty("TRANSACTION_ID")
   public java.math.BigDecimal getTRANSACTION_ID( ) {
      return this.TRANSACTION_ID;
   }
   //@JsonProperty("BLOCK_ID")
   public java.math.BigDecimal getBLOCK_ID( ) {
      return this.BLOCK_ID;
   }
   //@JsonProperty("TRANSACTION_HASH")
   public java.lang.String getTRANSACTION_HASH( ) {
      return this.TRANSACTION_HASH;
   }
   //@JsonProperty("VERSION")
   public java.math.BigDecimal getVERSION( ) {
      return this.VERSION;
   }
   //@JsonProperty("LOCKTIME")
   public java.math.BigDecimal getLOCKTIME( ) {
      return this.LOCKTIME;
   }
   //@JsonProperty("CREATE_TIMESTAMP")
   public java.sql.Timestamp getCREATE_TIMESTAMP( ) {
      return this.CREATE_TIMESTAMP;
   }
   //@JsonProperty("TYPE")
   public java.lang.String getTYPE( ) {
      return this.TYPE;
   }
   
   /**********************************************************
    * 
    * This print() method is used for debugging.
    * 
    ***********************************************************/
   public void print() {
      log.debug("Transfer object - Begins:");
            String content;
      content = String.format("1.\t%-30s -> [%s]\n", "TRANSACTION_ID",  this.getTRANSACTION_ID());
      log.debug(content);
      content = String.format("2.\t%-30s -> [%s]\n", "BLOCK_ID",  this.getBLOCK_ID());
      log.debug(content);
      content = String.format("3.\t%-30s -> [%s]\n", "TRANSACTION_HASH",  this.getTRANSACTION_HASH());
      log.debug(content);
      content = String.format("4.\t%-30s -> [%s]\n", "VERSION",  this.getVERSION());
      log.debug(content);
      content = String.format("5.\t%-30s -> [%s]\n", "LOCKTIME",  this.getLOCKTIME());
      log.debug(content);
      content = String.format("6.\t%-30s -> [%s]\n", "CREATE_TIMESTAMP",  this.getCREATE_TIMESTAMP());
      log.debug(content);
      content = String.format("7.\t%-30s -> [%s]\n", "TYPE",  this.getTYPE());
      log.debug(content);

      log.debug("Transfer object - Ends.");
   }
}