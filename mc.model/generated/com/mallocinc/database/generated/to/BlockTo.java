package com.mallocinc.database.generated.to;

import com.mallocinc.codegenerator.superclasses.oracle.*;
import java.io.*;
import java.sql.*;
import java.util.Arrays;
import org.apache.log4j.Logger;

/****************************************************************
 *  <pre>
 *
 *  Generated Class: BlockTo.java
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
 *  This code is generated on: 2017-February-27 06:45:55 PM CET
 *
 *  Copyright (C) 2015 Malloc Inc.
 *
 *  </pre>
 ****************************************************************/
public class BlockTo extends BaseOracleToClass implements Serializable {

   final static Logger log = Logger.getLogger(BlockTo.class.getName());

   private static final long serialVersionUID = 1L;
   public static final String workingClassName ="BlockTab";

   /**********************************************************************
    *
    * Database Variables declarations
    *
    **********************************************************************/
   private java.math.BigDecimal BLOCK_ID = null;
private java.lang.String MINER = null;
private java.math.BigDecimal NONCE = null;
private java.math.BigDecimal DIFFICULTY = null;
private java.lang.String CHAINWORK = null;
private java.math.BigDecimal CONFIRMATIONS = null;
private java.math.BigDecimal VERSION = null;
private java.lang.String BITS = null;
private java.lang.String MERKLEROOT = null;
private java.math.BigDecimal TIME = null;
private java.lang.String BLOCK_HASH = null;
private java.lang.String PREVIOUS_BLOCK_HASH = null;
private java.lang.String NEXT_BLOCK_HASH = null;
private java.math.BigDecimal HEIGHT = null;
private java.math.BigDecimal BLOCK_SIZE = null;
private java.sql.Timestamp CREATE_TIMESTAMP = null;


   /**********************************************************************
    *
    * Setters
    *
    **********************************************************************/   
   public void setBLOCK_ID( java.math.BigDecimal value ) {
      this.BLOCK_ID = value;
   }
   public void setMINER( java.lang.String value ) {
      this.MINER = value;
   }
   public void setNONCE( java.math.BigDecimal value ) {
      this.NONCE = value;
   }
   public void setDIFFICULTY( java.math.BigDecimal value ) {
      this.DIFFICULTY = value;
   }
   public void setCHAINWORK( java.lang.String value ) {
      this.CHAINWORK = value;
   }
   public void setCONFIRMATIONS( java.math.BigDecimal value ) {
      this.CONFIRMATIONS = value;
   }
   public void setVERSION( java.math.BigDecimal value ) {
      this.VERSION = value;
   }
   public void setBITS( java.lang.String value ) {
      this.BITS = value;
   }
   public void setMERKLEROOT( java.lang.String value ) {
      this.MERKLEROOT = value;
   }
   public void setTIME( java.math.BigDecimal value ) {
      this.TIME = value;
   }
   public void setBLOCK_HASH( java.lang.String value ) {
      this.BLOCK_HASH = value;
   }
   public void setPREVIOUS_BLOCK_HASH( java.lang.String value ) {
      this.PREVIOUS_BLOCK_HASH = value;
   }
   public void setNEXT_BLOCK_HASH( java.lang.String value ) {
      this.NEXT_BLOCK_HASH = value;
   }
   public void setHEIGHT( java.math.BigDecimal value ) {
      this.HEIGHT = value;
   }
   public void setBLOCK_SIZE( java.math.BigDecimal value ) {
      this.BLOCK_SIZE = value;
   }
   public void setCREATE_TIMESTAMP( java.sql.Timestamp value ) {
      this.CREATE_TIMESTAMP = value;
   }

   /**********************************************************************
    *
    * Getters
    *
    **********************************************************************/   
   //@JsonProperty("BLOCK_ID")
   public java.math.BigDecimal getBLOCK_ID( ) {
      return this.BLOCK_ID;
   }
   //@JsonProperty("MINER")
   public java.lang.String getMINER( ) {
      return this.MINER;
   }
   //@JsonProperty("NONCE")
   public java.math.BigDecimal getNONCE( ) {
      return this.NONCE;
   }
   //@JsonProperty("DIFFICULTY")
   public java.math.BigDecimal getDIFFICULTY( ) {
      return this.DIFFICULTY;
   }
   //@JsonProperty("CHAINWORK")
   public java.lang.String getCHAINWORK( ) {
      return this.CHAINWORK;
   }
   //@JsonProperty("CONFIRMATIONS")
   public java.math.BigDecimal getCONFIRMATIONS( ) {
      return this.CONFIRMATIONS;
   }
   //@JsonProperty("VERSION")
   public java.math.BigDecimal getVERSION( ) {
      return this.VERSION;
   }
   //@JsonProperty("BITS")
   public java.lang.String getBITS( ) {
      return this.BITS;
   }
   //@JsonProperty("MERKLEROOT")
   public java.lang.String getMERKLEROOT( ) {
      return this.MERKLEROOT;
   }
   //@JsonProperty("TIME")
   public java.math.BigDecimal getTIME( ) {
      return this.TIME;
   }
   //@JsonProperty("BLOCK_HASH")
   public java.lang.String getBLOCK_HASH( ) {
      return this.BLOCK_HASH;
   }
   //@JsonProperty("PREVIOUS_BLOCK_HASH")
   public java.lang.String getPREVIOUS_BLOCK_HASH( ) {
      return this.PREVIOUS_BLOCK_HASH;
   }
   //@JsonProperty("NEXT_BLOCK_HASH")
   public java.lang.String getNEXT_BLOCK_HASH( ) {
      return this.NEXT_BLOCK_HASH;
   }
   //@JsonProperty("HEIGHT")
   public java.math.BigDecimal getHEIGHT( ) {
      return this.HEIGHT;
   }
   //@JsonProperty("BLOCK_SIZE")
   public java.math.BigDecimal getBLOCK_SIZE( ) {
      return this.BLOCK_SIZE;
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
      content = String.format("1.\t%-30s -> [%s]\n", "BLOCK_ID",  this.getBLOCK_ID());
      log.debug(content);
      content = String.format("2.\t%-30s -> [%s]\n", "MINER",  this.getMINER());
      log.debug(content);
      content = String.format("3.\t%-30s -> [%s]\n", "NONCE",  this.getNONCE());
      log.debug(content);
      content = String.format("4.\t%-30s -> [%s]\n", "DIFFICULTY",  this.getDIFFICULTY());
      log.debug(content);
      content = String.format("5.\t%-30s -> [%s]\n", "CHAINWORK",  this.getCHAINWORK());
      log.debug(content);
      content = String.format("6.\t%-30s -> [%s]\n", "CONFIRMATIONS",  this.getCONFIRMATIONS());
      log.debug(content);
      content = String.format("7.\t%-30s -> [%s]\n", "VERSION",  this.getVERSION());
      log.debug(content);
      content = String.format("8.\t%-30s -> [%s]\n", "BITS",  this.getBITS());
      log.debug(content);
      content = String.format("9.\t%-30s -> [%s]\n", "MERKLEROOT",  this.getMERKLEROOT());
      log.debug(content);
      content = String.format("10.\t%-30s -> [%s]\n", "TIME",  this.getTIME());
      log.debug(content);
      content = String.format("11.\t%-30s -> [%s]\n", "BLOCK_HASH",  this.getBLOCK_HASH());
      log.debug(content);
      content = String.format("12.\t%-30s -> [%s]\n", "PREVIOUS_BLOCK_HASH",  this.getPREVIOUS_BLOCK_HASH());
      log.debug(content);
      content = String.format("13.\t%-30s -> [%s]\n", "NEXT_BLOCK_HASH",  this.getNEXT_BLOCK_HASH());
      log.debug(content);
      content = String.format("14.\t%-30s -> [%s]\n", "HEIGHT",  this.getHEIGHT());
      log.debug(content);
      content = String.format("15.\t%-30s -> [%s]\n", "BLOCK_SIZE",  this.getBLOCK_SIZE());
      log.debug(content);
      content = String.format("16.\t%-30s -> [%s]\n", "CREATE_TIMESTAMP",  this.getCREATE_TIMESTAMP());
      log.debug(content);

      log.debug("Transfer object - Ends.");
   }
}