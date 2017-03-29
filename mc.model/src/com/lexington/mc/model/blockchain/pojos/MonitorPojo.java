package com.lexington.mc.model.blockchain.pojos;


import com.mallocinc.codegenerator.superclasses.oracle.*;
import com.mallocinc.database.generated.to.MonitorTo;

import java.io.*;
import java.math.BigDecimal;
import java.sql.*;
import java.util.Arrays;

import org.apache.log4j.Logger;


public class MonitorPojo  extends PojoApi{

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
private java.lang.String BROKER_CODE = null;
private java.lang.String RELATIONSHIP = null;
private java.lang.String EMP_BANK_APPROVED = null;
private java.lang.String OUT_BANK_APPROVED = null;
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

   public void setBROKER_CODE(java.lang.String bROKER_CODE) {
      BROKER_CODE = bROKER_CODE;
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

   public void setEMP_BANK_APPROVED(java.lang.String eMP_BANK_APPROVED) {
      EMP_BANK_APPROVED = eMP_BANK_APPROVED;
   }

   public void setOUT_BANK_APPROVED(java.lang.String oUT_BANK_APPROVED) {
      OUT_BANK_APPROVED = oUT_BANK_APPROVED;
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
   
   //@JsonProperty("BROKER_CODE")
   public java.lang.String getBROKER_CODE() {
      return BROKER_CODE;
   }
   
   //@JsonProperty("RELATIONSHIP")
   public java.lang.String getRELATIONSHIP( ) {
      return this.RELATIONSHIP;
   }
   
   //@JsonProperty("EMP_BANK_APPROVED")
   public java.lang.String getEMP_BANK_APPROVED() {
      return EMP_BANK_APPROVED;
   }
   
   //@JsonProperty("OUT_BANK_APPROVED")
   public java.lang.String getOUT_BANK_APPROVED() {
      return OUT_BANK_APPROVED;
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
   
   public String getRowKey() {
      return MONITOR_ID.toString();
   }
}