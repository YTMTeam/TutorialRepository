package com.mallocinc.database.generated.to;

import com.mallocinc.codegenerator.superclasses.oracle.*;
import java.io.*;
import java.sql.*;
import java.util.Arrays;

/****************************************************************
 *  <pre>
 *
 *  Generated Class: HouseholdTo.java
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
 *  This code is generated on: 2017-February-13 05:34:29 PM CET
 *
 *  Copyright (C) 2015 Malloc Inc.
 *
 *  </pre>
 ****************************************************************/
public class HouseholdTo extends BaseOracleToClass implements Serializable {

   private static final long serialVersionUID = 1L;
   public static final String workingClassName ="HouseholdTab";

   /**********************************************************************
    *
    * Database Variables declarations
    *
    **********************************************************************/
   private java.math.BigDecimal HOUSEHOLD_ID = null;
private java.lang.String HOUSEHOLD_NAME = null;


   /**********************************************************************
    *
    * Setters
    *
    **********************************************************************/   
   public void setHOUSEHOLD_ID( java.math.BigDecimal value ) {
      this.HOUSEHOLD_ID = value;
   }
   public void setHOUSEHOLD_NAME( java.lang.String value ) {
      this.HOUSEHOLD_NAME = value;
   }

   /**********************************************************************
    *
    * Getters
    *
    **********************************************************************/   
   //@JsonProperty("HOUSEHOLD_ID")
   public java.math.BigDecimal getHOUSEHOLD_ID( ) {
      return this.HOUSEHOLD_ID;
   }
   //@JsonProperty("HOUSEHOLD_NAME")
   public java.lang.String getHOUSEHOLD_NAME( ) {
      return this.HOUSEHOLD_NAME;
   }
   
   /**********************************************************
    * 
    * This print() method is used for debugging.
    * 
    ***********************************************************/
   public void print() {
      System.out.println("Transfer object - Begins:");
            System.out.printf("1.\t%-30s -> [%s]\n", "HOUSEHOLD_ID",  this.getHOUSEHOLD_ID());
      System.out.printf("2.\t%-30s -> [%s]\n", "HOUSEHOLD_NAME",  this.getHOUSEHOLD_NAME());

      System.out.println("Transfer object - Ends.");
   }
}