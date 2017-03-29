package com.mallocinc.database.generated.to;

import com.mallocinc.codegenerator.superclasses.oracle.*;
import java.io.*;
import java.sql.*;
import java.util.Arrays;
import org.apache.log4j.Logger;

/****************************************************************
 *  <pre>
 *
 *  Generated Class: MonitorTo.java
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
public class MonitorTo extends BaseOracleToClass implements Serializable {

   final static Logger log = Logger.getLogger(MonitorTo.class.getName());

   private static final long serialVersionUID = 1L;
   public static final String workingClassName ="MonitorTab";

   /**********************************************************************
    *
    * Database Variables declarations
    *
    **********************************************************************/
   private java.lang.String MONITOR_ID = null;
private java.lang.String ACCOUNT_ID = null;
private java.math.BigDecimal BANK_ID = null;
private java.lang.String EMPLOYEE_ID = null;
private java.lang.String ACCOUNT_FIRST_NAME = null;
private java.lang.String ACCOUNT_MIDDLE_NAME = null;
private java.lang.String ACCOUNT_LAST_NAME = null;
private java.lang.String RELATIONSHIP = null;
private java.sql.Timestamp AS_OF_DATE = null;
private java.sql.Timestamp END_DATE = null;
private java.sql.Timestamp CREATE_TIMESTAMP = null;


   /**********************************************************************
    *
    * Setters
    *
    **********************************************************************/   
   public void setMONITOR_ID( java.lang.String value ) {
      this.MONITOR_ID = value;
   }
   public void setACCOUNT_ID( java.lang.String value ) {
      this.ACCOUNT_ID = value;
   }
   public void setBANK_ID( java.math.BigDecimal value ) {
      this.BANK_ID = value;
   }
   public void setEMPLOYEE_ID( java.lang.String value ) {
      this.EMPLOYEE_ID = value;
   }
   public void setACCOUNT_FIRST_NAME( java.lang.String value ) {
      this.ACCOUNT_FIRST_NAME = value;
   }
   public void setACCOUNT_MIDDLE_NAME( java.lang.String value ) {
      this.ACCOUNT_MIDDLE_NAME = value;
   }
   public void setACCOUNT_LAST_NAME( java.lang.String value ) {
      this.ACCOUNT_LAST_NAME = value;
   }
   public void setRELATIONSHIP( java.lang.String value ) {
      this.RELATIONSHIP = value;
   }
   public void setAS_OF_DATE( java.sql.Timestamp value ) {
      this.AS_OF_DATE = value;
   }
   public void setEND_DATE( java.sql.Timestamp value ) {
      this.END_DATE = value;
   }
   public void setCREATE_TIMESTAMP( java.sql.Timestamp value ) {
      this.CREATE_TIMESTAMP = value;
   }

   /**********************************************************************
    *
    * Getters
    *
    **********************************************************************/   
   //@JsonProperty("MONITOR_ID")
   public java.lang.String getMONITOR_ID( ) {
      return this.MONITOR_ID;
   }
   //@JsonProperty("ACCOUNT_ID")
   public java.lang.String getACCOUNT_ID( ) {
      return this.ACCOUNT_ID;
   }
   //@JsonProperty("BANK_ID")
   public java.math.BigDecimal getBANK_ID( ) {
      return this.BANK_ID;
   }
   //@JsonProperty("EMPLOYEE_ID")
   public java.lang.String getEMPLOYEE_ID( ) {
      return this.EMPLOYEE_ID;
   }
   //@JsonProperty("ACCOUNT_FIRST_NAME")
   public java.lang.String getACCOUNT_FIRST_NAME( ) {
      return this.ACCOUNT_FIRST_NAME;
   }
   //@JsonProperty("ACCOUNT_MIDDLE_NAME")
   public java.lang.String getACCOUNT_MIDDLE_NAME( ) {
      return this.ACCOUNT_MIDDLE_NAME;
   }
   //@JsonProperty("ACCOUNT_LAST_NAME")
   public java.lang.String getACCOUNT_LAST_NAME( ) {
      return this.ACCOUNT_LAST_NAME;
   }
   //@JsonProperty("RELATIONSHIP")
   public java.lang.String getRELATIONSHIP( ) {
      return this.RELATIONSHIP;
   }
   //@JsonProperty("AS_OF_DATE")
   public java.sql.Timestamp getAS_OF_DATE( ) {
      return this.AS_OF_DATE;
   }
   //@JsonProperty("END_DATE")
   public java.sql.Timestamp getEND_DATE( ) {
      return this.END_DATE;
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
      content = String.format("1.\t%-30s -> [%s]\n", "MONITOR_ID",  this.getMONITOR_ID());
      log.debug(content);
      content = String.format("2.\t%-30s -> [%s]\n", "ACCOUNT_ID",  this.getACCOUNT_ID());
      log.debug(content);
      content = String.format("3.\t%-30s -> [%s]\n", "BANK_ID",  this.getBANK_ID());
      log.debug(content);
      content = String.format("4.\t%-30s -> [%s]\n", "EMPLOYEE_ID",  this.getEMPLOYEE_ID());
      log.debug(content);
      content = String.format("5.\t%-30s -> [%s]\n", "ACCOUNT_FIRST_NAME",  this.getACCOUNT_FIRST_NAME());
      log.debug(content);
      content = String.format("6.\t%-30s -> [%s]\n", "ACCOUNT_MIDDLE_NAME",  this.getACCOUNT_MIDDLE_NAME());
      log.debug(content);
      content = String.format("7.\t%-30s -> [%s]\n", "ACCOUNT_LAST_NAME",  this.getACCOUNT_LAST_NAME());
      log.debug(content);
      content = String.format("8.\t%-30s -> [%s]\n", "RELATIONSHIP",  this.getRELATIONSHIP());
      log.debug(content);
      content = String.format("9.\t%-30s -> [%s]\n", "AS_OF_DATE",  this.getAS_OF_DATE());
      log.debug(content);
      content = String.format("10.\t%-30s -> [%s]\n", "END_DATE",  this.getEND_DATE());
      log.debug(content);
      content = String.format("11.\t%-30s -> [%s]\n", "CREATE_TIMESTAMP",  this.getCREATE_TIMESTAMP());
      log.debug(content);

      log.debug("Transfer object - Ends.");
   }
}