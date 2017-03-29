package com.lexington.mc.model.blockchain.pojos;


import com.mallocinc.codegenerator.superclasses.oracle.*;
import com.mallocinc.database.generated.to.EmployeeTo;

import java.io.*;
import java.math.BigDecimal;
import java.sql.*;
import java.util.Arrays;

import org.apache.log4j.Logger;

/****************************************************************
 *  <pre>
 *
 *  Generated Class: EmployeeTo.java
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
 *  This code is generated on: 2017-February-14 12:11:12 PM CET
 *
 *  Copyright (C) 2015 Malloc Inc.
 *
 *  </pre>
 ****************************************************************/
public class EmployeePojo extends PojoApi{
   
      final static Logger log = Logger.getLogger(EmployeeTo.class.getName());

      private static final long serialVersionUID = 1L;
      public static final String workingClassName ="EmployeeTab";

      /**********************************************************************
       *
       * Database Variables declarations
       *
       **********************************************************************/
      private java.lang.String EMPLOYEE_ID = null;
      private java.math.BigDecimal BANK_ID = null;
      private java.lang.String FIRST_NAME = null;
      private java.lang.String MIDDLE_NAME = null;
      private java.lang.String LAST_NAME = null;
      private java.lang.String EMPLOYING_INSTITUTION = null;


      /**********************************************************************
       *
       * Setters
       *
       **********************************************************************/   
      public void setEMPLOYEE_ID( java.lang.String value ) {
         this.EMPLOYEE_ID = value;
      }
      public void setBANK_ID( java.math.BigDecimal value ) {
         this.BANK_ID = value;
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
      public void setEMPLOYING_INSTITUTION( java.lang.String value ) {
         this.EMPLOYING_INSTITUTION = value;
      }

      /**********************************************************************
       *
       * Getters
       *
       **********************************************************************/   
      //@JsonProperty("EMPLOYEE_ID")
      public java.lang.String getEMPLOYEE_ID( ) {
         return this.EMPLOYEE_ID;
      }
      //@JsonProperty("BANK_ID")
      public java.math.BigDecimal getBANK_ID( ) {
         return this.BANK_ID;
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
      //@JsonProperty("EMPLOYING_INSTITUTION")
      public java.lang.String getEMPLOYING_INSTITUTION( ) {
         return this.EMPLOYING_INSTITUTION;
      }

      /**********************************************************
       * 
       * This print() method is used for debugging.
       * 
       ***********************************************************/
      public void print() {
         log.debug("Transfer object - Begins:");
         String content;
         content = String.format("1.\t%-30s -> [%s]\n", "EMPLOYEE_ID",  this.getEMPLOYEE_ID());
         log.debug(content);
         content = String.format("2.\t%-30s -> [%s]\n", "BANK_ID",  this.getBANK_ID());
         log.debug(content);
         content = String.format("3.\t%-30s -> [%s]\n", "FIRST_NAME",  this.getFIRST_NAME());
         log.debug(content);
         content = String.format("4.\t%-30s -> [%s]\n", "MIDDLE_NAME",  this.getMIDDLE_NAME());
         log.debug(content);
         content = String.format("5.\t%-30s -> [%s]\n", "LAST_NAME",  this.getLAST_NAME());
         log.debug(content);
         content = String.format("6.\t%-30s -> [%s]\n", "EMPLOYING_INSTITUTION",  this.getEMPLOYING_INSTITUTION());
         log.debug(content);

         log.debug("Transfer object - Ends.");
      }
      
      public String getRowKey() {
         return EMPLOYEE_ID.toString();
      }
   }