package com.mallocinc.database.generated.to;

import com.mallocinc.codegenerator.superclasses.oracle.*;
import java.io.*;
import java.sql.*;
import java.util.Arrays;
import org.apache.log4j.Logger;

/****************************************************************
 *  <pre>
 *
 *  Generated Class: VMonitoredAccountsTo.java
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
public class VMonitoredAccountsTo extends BaseOracleToClass implements Serializable {

   final static Logger log = Logger.getLogger(VMonitoredAccountsTo.class.getName());

   private static final long serialVersionUID = 1L;
   public static final String workingClassName ="VMonitoredAccountsTab";

   /**********************************************************************
    *
    * Database Variables declarations
    *
    **********************************************************************/
   private java.lang.String MONITOR_ID = null;
private java.lang.String ACCOUNT_ID = null;
private java.math.BigDecimal MONITOR_BANK_ID = null;
private java.lang.String MONITOR_BANK_NAME = null;
private java.math.BigDecimal ACCOUNT_FIRST_NAME = null;
private java.lang.String ACCOUNT_LAST_NAME = null;
private java.lang.String ACCOUNT_BANK_ID = null;
private java.math.BigDecimal ACCOUNT_BANK_NAME = null;
private java.lang.String EMPLOYEE_ID = null;
private java.lang.String EMPLOYEE_FIRST_NAME = null;
private java.lang.String EMPLOYEE_LAST_NAME = null;
private java.lang.String EMPLOYEE_BANK_NAME = null;
private java.lang.String MONITOR_PERMISSION_DATE = null;
private java.sql.Timestamp MONITOR_AS_OF_DATE = null;
private java.sql.Timestamp MONITOR_END_DATE = null;
private java.sql.Timestamp MONITOR_COMMENT = null;
private java.lang.String MONITOR_STATUS = null;


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
   public void setMONITOR_BANK_ID( java.math.BigDecimal value ) {
      this.MONITOR_BANK_ID = value;
   }
   public void setMONITOR_BANK_NAME( java.lang.String value ) {
      this.MONITOR_BANK_NAME = value;
   }
   public void setACCOUNT_FIRST_NAME( java.math.BigDecimal value ) {
      this.ACCOUNT_FIRST_NAME = value;
   }
   public void setACCOUNT_LAST_NAME( java.lang.String value ) {
      this.ACCOUNT_LAST_NAME = value;
   }
   public void setACCOUNT_BANK_ID( java.lang.String value ) {
      this.ACCOUNT_BANK_ID = value;
   }
   public void setACCOUNT_BANK_NAME( java.math.BigDecimal value ) {
      this.ACCOUNT_BANK_NAME = value;
   }
   public void setEMPLOYEE_ID( java.lang.String value ) {
      this.EMPLOYEE_ID = value;
   }
   public void setEMPLOYEE_FIRST_NAME( java.lang.String value ) {
      this.EMPLOYEE_FIRST_NAME = value;
   }
   public void setEMPLOYEE_LAST_NAME( java.lang.String value ) {
      this.EMPLOYEE_LAST_NAME = value;
   }
   public void setEMPLOYEE_BANK_NAME( java.lang.String value ) {
      this.EMPLOYEE_BANK_NAME = value;
   }
   public void setMONITOR_PERMISSION_DATE( java.lang.String value ) {
      this.MONITOR_PERMISSION_DATE = value;
   }
   public void setMONITOR_AS_OF_DATE( java.sql.Timestamp value ) {
      this.MONITOR_AS_OF_DATE = value;
   }
   public void setMONITOR_END_DATE( java.sql.Timestamp value ) {
      this.MONITOR_END_DATE = value;
   }
   public void setMONITOR_COMMENT( java.sql.Timestamp value ) {
      this.MONITOR_COMMENT = value;
   }
   public void setMONITOR_STATUS( java.lang.String value ) {
      this.MONITOR_STATUS = value;
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
   //@JsonProperty("MONITOR_BANK_ID")
   public java.math.BigDecimal getMONITOR_BANK_ID( ) {
      return this.MONITOR_BANK_ID;
   }
   //@JsonProperty("MONITOR_BANK_NAME")
   public java.lang.String getMONITOR_BANK_NAME( ) {
      return this.MONITOR_BANK_NAME;
   }
   //@JsonProperty("ACCOUNT_FIRST_NAME")
   public java.math.BigDecimal getACCOUNT_FIRST_NAME( ) {
      return this.ACCOUNT_FIRST_NAME;
   }
   //@JsonProperty("ACCOUNT_LAST_NAME")
   public java.lang.String getACCOUNT_LAST_NAME( ) {
      return this.ACCOUNT_LAST_NAME;
   }
   //@JsonProperty("ACCOUNT_BANK_ID")
   public java.lang.String getACCOUNT_BANK_ID( ) {
      return this.ACCOUNT_BANK_ID;
   }
   //@JsonProperty("ACCOUNT_BANK_NAME")
   public java.math.BigDecimal getACCOUNT_BANK_NAME( ) {
      return this.ACCOUNT_BANK_NAME;
   }
   //@JsonProperty("EMPLOYEE_ID")
   public java.lang.String getEMPLOYEE_ID( ) {
      return this.EMPLOYEE_ID;
   }
   //@JsonProperty("EMPLOYEE_FIRST_NAME")
   public java.lang.String getEMPLOYEE_FIRST_NAME( ) {
      return this.EMPLOYEE_FIRST_NAME;
   }
   //@JsonProperty("EMPLOYEE_LAST_NAME")
   public java.lang.String getEMPLOYEE_LAST_NAME( ) {
      return this.EMPLOYEE_LAST_NAME;
   }
   //@JsonProperty("EMPLOYEE_BANK_NAME")
   public java.lang.String getEMPLOYEE_BANK_NAME( ) {
      return this.EMPLOYEE_BANK_NAME;
   }
   //@JsonProperty("MONITOR_PERMISSION_DATE")
   public java.lang.String getMONITOR_PERMISSION_DATE( ) {
      return this.MONITOR_PERMISSION_DATE;
   }
   //@JsonProperty("MONITOR_AS_OF_DATE")
   public java.sql.Timestamp getMONITOR_AS_OF_DATE( ) {
      return this.MONITOR_AS_OF_DATE;
   }
   //@JsonProperty("MONITOR_END_DATE")
   public java.sql.Timestamp getMONITOR_END_DATE( ) {
      return this.MONITOR_END_DATE;
   }
   //@JsonProperty("MONITOR_COMMENT")
   public java.sql.Timestamp getMONITOR_COMMENT( ) {
      return this.MONITOR_COMMENT;
   }
   //@JsonProperty("MONITOR_STATUS")
   public java.lang.String getMONITOR_STATUS( ) {
      return this.MONITOR_STATUS;
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
      content = String.format("3.\t%-30s -> [%s]\n", "MONITOR_BANK_ID",  this.getMONITOR_BANK_ID());
      log.debug(content);
      content = String.format("4.\t%-30s -> [%s]\n", "MONITOR_BANK_NAME",  this.getMONITOR_BANK_NAME());
      log.debug(content);
      content = String.format("5.\t%-30s -> [%s]\n", "ACCOUNT_FIRST_NAME",  this.getACCOUNT_FIRST_NAME());
      log.debug(content);
      content = String.format("6.\t%-30s -> [%s]\n", "ACCOUNT_LAST_NAME",  this.getACCOUNT_LAST_NAME());
      log.debug(content);
      content = String.format("7.\t%-30s -> [%s]\n", "ACCOUNT_BANK_ID",  this.getACCOUNT_BANK_ID());
      log.debug(content);
      content = String.format("8.\t%-30s -> [%s]\n", "ACCOUNT_BANK_NAME",  this.getACCOUNT_BANK_NAME());
      log.debug(content);
      content = String.format("9.\t%-30s -> [%s]\n", "EMPLOYEE_ID",  this.getEMPLOYEE_ID());
      log.debug(content);
      content = String.format("10.\t%-30s -> [%s]\n", "EMPLOYEE_FIRST_NAME",  this.getEMPLOYEE_FIRST_NAME());
      log.debug(content);
      content = String.format("11.\t%-30s -> [%s]\n", "EMPLOYEE_LAST_NAME",  this.getEMPLOYEE_LAST_NAME());
      log.debug(content);
      content = String.format("12.\t%-30s -> [%s]\n", "EMPLOYEE_BANK_NAME",  this.getEMPLOYEE_BANK_NAME());
      log.debug(content);
      content = String.format("13.\t%-30s -> [%s]\n", "MONITOR_PERMISSION_DATE",  this.getMONITOR_PERMISSION_DATE());
      log.debug(content);
      content = String.format("14.\t%-30s -> [%s]\n", "MONITOR_AS_OF_DATE",  this.getMONITOR_AS_OF_DATE());
      log.debug(content);
      content = String.format("15.\t%-30s -> [%s]\n", "MONITOR_END_DATE",  this.getMONITOR_END_DATE());
      log.debug(content);
      content = String.format("16.\t%-30s -> [%s]\n", "MONITOR_COMMENT",  this.getMONITOR_COMMENT());
      log.debug(content);
      content = String.format("17.\t%-30s -> [%s]\n", "MONITOR_STATUS",  this.getMONITOR_STATUS());
      log.debug(content);

      log.debug("Transfer object - Ends.");
   }
}