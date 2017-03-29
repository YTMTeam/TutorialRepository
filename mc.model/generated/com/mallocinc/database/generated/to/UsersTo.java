package com.mallocinc.database.generated.to;

import com.mallocinc.codegenerator.superclasses.oracle.*;
import java.io.*;
import java.sql.*;
import java.util.Arrays;
import org.apache.log4j.Logger;

/****************************************************************
 *  <pre>
 *
 *  Generated Class: UsersTo.java
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
 *  This code is generated on: 2017-February-27 06:45:57 PM CET
 *
 *  Copyright (C) 2015 Malloc Inc.
 *
 *  </pre>
 ****************************************************************/
public class UsersTo extends BaseOracleToClass implements Serializable {

   final static Logger log = Logger.getLogger(UsersTo.class.getName());

   private static final long serialVersionUID = 1L;
   public static final String workingClassName ="UsersTab";

   /**********************************************************************
    *
    * Database Variables declarations
    *
    **********************************************************************/
   private java.math.BigDecimal USER_ID = null;
private java.math.BigDecimal BANK_ID = null;
private java.lang.String USER_NAME = null;


   /**********************************************************************
    *
    * Setters
    *
    **********************************************************************/   
   public void setUSER_ID( java.math.BigDecimal value ) {
      this.USER_ID = value;
   }
   public void setBANK_ID( java.math.BigDecimal value ) {
      this.BANK_ID = value;
   }
   public void setUSER_NAME( java.lang.String value ) {
      this.USER_NAME = value;
   }

   /**********************************************************************
    *
    * Getters
    *
    **********************************************************************/   
   //@JsonProperty("USER_ID")
   public java.math.BigDecimal getUSER_ID( ) {
      return this.USER_ID;
   }
   //@JsonProperty("BANK_ID")
   public java.math.BigDecimal getBANK_ID( ) {
      return this.BANK_ID;
   }
   //@JsonProperty("USER_NAME")
   public java.lang.String getUSER_NAME( ) {
      return this.USER_NAME;
   }
   
   /**********************************************************
    * 
    * This print() method is used for debugging.
    * 
    ***********************************************************/
   public void print() {
      log.debug("Transfer object - Begins:");
            String content;
      content = String.format("1.\t%-30s -> [%s]\n", "USER_ID",  this.getUSER_ID());
      log.debug(content);
      content = String.format("2.\t%-30s -> [%s]\n", "BANK_ID",  this.getBANK_ID());
      log.debug(content);
      content = String.format("3.\t%-30s -> [%s]\n", "USER_NAME",  this.getUSER_NAME());
      log.debug(content);

      log.debug("Transfer object - Ends.");
   }
}