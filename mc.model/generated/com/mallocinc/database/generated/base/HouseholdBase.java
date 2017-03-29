package com.mallocinc.database.generated.base;

import java.sql.*;
import java.io.*;
import com.mallocinc.codegenerator.superclasses.oracle.*;
import java.util.ArrayList;
import java.util.Arrays;

import com.mallocinc.database.generated.to.HouseholdTo;
import com.mallocinc.codegenerator.exceptions.*;

/*************************************************************************
 *  <pre>
 *
 *  Generated Class: HouseholdBase.java
 *
 *  This class should NOT be used directly
 *  Instead, use derived class in package:
 *  com.mallocinc.database.generated.working
 *  
 *  Template version: 3.0
 *  Template date:    NLS missing message: template_date in: templates.gdao
 *  Template file:    /templates/Oracle/BaseOracleTemplate.txt
 *  Target database:  Oracle 10g, 11g, 12c
 *
 *  @author Malloc Inc.
 *  
 *  This code is generated on: 2017-February-13 05:34:29 PM CET
 *
 *  Copyright (C) 2015 Malloc Inc.
 *
 *  </pre>
 **************************************************************************/
@SuppressWarnings("unused")
public class HouseholdBase extends BaseOracleDbEntityClass <HouseholdTo> {

   /**********************************************************************
    *
    *  Database Variables declarations
    *  They represent database columns
    *
    **********************************************************************/
   private java.math.BigDecimal HOUSEHOLD_ID = null;
private java.lang.String HOUSEHOLD_NAME = null;


   /**********************************************************
    *
    *  Default Constructor
    *
    ***********************************************************/
   public HouseholdBase( ) {

      if (getDbEntityName() == null) {
         setDbEntityName("HOUSEHOLD");
      }

      columnsCommaDelimitedList = " HOUSEHOLD_ID"
   + ",HOUSEHOLD_NAME"
   ;

      setSelectAllSQL();

      setDbEntityType("TABLE");

      OracleDbColumn dbColumn = null;

         dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "HOUSEHOLD_ID" );
      dbColumn.setORDINAL_POSITION( 1 );
      dbColumn.setTYPE_NAME( "NUMBER" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      dbColumn.setPrimaryKey( true );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "HOUSEHOLD_NAME" );
      dbColumn.setORDINAL_POSITION( 2 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);


   }

   /**********************************************************
    *
    *  Constructor
    *
    ***********************************************************/
   public HouseholdBase( Connection connection ) {
      this(); //chain default constructor
      this.connection = connection;
   }

   /**********************************************************
    *
    *  Constructor
    *
    ***********************************************************/
   public HouseholdBase( String underlyingEntityName ) {
      this(); //chain default constructor
      this.setDbEntityName(underlyingEntityName);
   }

   public void setConnection(Connection connection) {
      this.connection = connection;
   }

   /*************************************************************************
    *
    *  Database fields setters
    *
    *************************************************************************/
    
   public void setHOUSEHOLD_ID( java.math.BigDecimal value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.HOUSEHOLD_ID == null && value == null) || 
         (this.HOUSEHOLD_ID != null && this.HOUSEHOLD_ID.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.HOUSEHOLD_ID = value;
      if ( this.changedColumns.get( "HOUSEHOLD_ID" ) == null )  {
         this.changedColumns.put( "HOUSEHOLD_ID", "java.math.BigDecimal" );
         this.setDbColumnChangedFlag("HOUSEHOLD_ID", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateBigDecimal(getDbColumn("HOUSEHOLD_ID").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setHOUSEHOLD_NAME( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.HOUSEHOLD_NAME == null && value == null) || 
         (this.HOUSEHOLD_NAME != null && this.HOUSEHOLD_NAME.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.HOUSEHOLD_NAME = value;
      if ( this.changedColumns.get( "HOUSEHOLD_NAME" ) == null )  {
         this.changedColumns.put( "HOUSEHOLD_NAME", "java.lang.String" );
         this.setDbColumnChangedFlag("HOUSEHOLD_NAME", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("HOUSEHOLD_NAME").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   /*************************************************************************
    *
    *  Database fields getters
    *
    *************************************************************************/
    public java.math.BigDecimal getHOUSEHOLD_ID( ) {
      return this.HOUSEHOLD_ID;
   }
   public java.lang.String getHOUSEHOLD_NAME( ) {
      return this.HOUSEHOLD_NAME;
   }

   /*************************************************************************
    *
    *  Retrieves next record from record set and returns "true" if record is
    *  found.
    *    
    *  The ResultSet interface provides getter methods (getBoolean, getLong, 
    *  and so on) for retrieving column values from the current row. 
    *  Values can be retrieved using either the index number of the column or 
    *  the name of the column. In general, using the column index will be more 
    *  efficient. Columns are numbered from 1.
    *    
    *************************************************************************/
   public boolean next() throws GDAOException {
      boolean ret = false;
      
      if (this.resultSet == null) {
         log.error("Result set is NULL. Data is probably not selected into result set.");
         log.error("Use methods like \"getAllRecordsRs()\", \"getResultSet()\" or similar to select data into result set.");
         throw new GDAOException("Result set is NULL. Data is probably not selected into result set.");
      }
      
      try {
         if (this.resultSet.next()) {

            setRecordFound(true);

            this.changedColumns.clear();
            ret = true;

                     this.HOUSEHOLD_ID = this.resultSet.getBigDecimal(1);
            this.HOUSEHOLD_NAME = this.resultSet.getString(2);
   
         }
         else {
            //record is not found, set recordFound indicator to false
            //and reset all database related variables
            reset();
         }
      } catch (SQLException e) {
         e.printStackTrace();
         throw new GDAOException(e);
      }
      return ret;
   }

   /*************************************************************************
    *
    *  Retrieves previous record from record set and returns "true" if record
    *  is found.
    *
    *************************************************************************/
   public boolean previous() throws GDAOException {
      boolean ret = false;
      try {
         if (this.resultSet.previous()) {

            setRecordFound(true);

            this.changedColumns.clear();
            ret = true;

                     this.HOUSEHOLD_ID = this.resultSet.getBigDecimal(1);
            this.HOUSEHOLD_NAME = this.resultSet.getString(2);
   
         }
         else {
            //record is not found, set recordFound indicator to false
            //and reset all database related variables
            reset();
         }
      } catch (SQLException e) {
         e.printStackTrace();
         throw new GDAOException(e);
      }
      return ret;
   }

   /*************************************************************************
    *
    * Retrieves current record from record set and returns "true" if record is found
    *
    *************************************************************************/
   public void current() throws GDAOException  {
      try {

          /*************************************************************************
           *
           *  NOTE: Refresh row does not work for Sybase scrollable result set
           *  this.resultSet.refreshRow();
           *
           *************************************************************************/

           setRecordFound(true);

           this.changedColumns.clear();

                    this.HOUSEHOLD_ID = this.resultSet.getBigDecimal(1);
            this.HOUSEHOLD_NAME = this.resultSet.getString(2);
   

      } catch (SQLException e) {
         e.printStackTrace();
         throw new GDAOException(e);
      }
      return;
   }

   /*************************************************************************
    *
    * Copies data from Base to Transfer Object
    * Transfer Object is created.
    *
    *************************************************************************/
   public HouseholdTo getTo() {
      HouseholdTo householdTo = new HouseholdTo();

            householdTo.setHOUSEHOLD_ID(this.HOUSEHOLD_ID);
      householdTo.setHOUSEHOLD_NAME(this.HOUSEHOLD_NAME);


      return householdTo;
   }

   /*************************************************************************
    *
    * Copies data from Transfer Object PK columns to corresponding columns
    * of database object
    *
    *************************************************************************/
    public void setPkValuesFromTo(HouseholdTo householdTo) throws GDAOException {

            this.setHOUSEHOLD_ID(householdTo.getHOUSEHOLD_ID());


      return;
   }
   
   
   /*************************************************************************
    *
    * Returns SQL statement based on PK columns
    * @Deprecated
    * Method is implemented in BaseOracleDbEntityClass 
    *
    *************************************************************************/
    /*
    public String getDeleteSQLUsingPkValues() throws GDAOException {

      String SQL = "DELETE FROM HOUSEHOLD WHERE ";
      SQL = SQL + "HOUSEHOLD_ID = ? ";

      return SQL;
    }
    */
    
   /*************************************************************************
    *
    * Copies all data from Result Set into Transfer Object Array
    * NOTE: 
    * Works from the current position of the cursor to the end of the 
    * any Result Set (does not have to be "Scrollable"). 
    *
    *************************************************************************/
    public ArrayList<HouseholdTo> getToArrayEntireResultSet() throws GDAOException {
       ArrayList<HouseholdTo> toArray = new ArrayList<HouseholdTo>();
       while (next()) {
          HouseholdTo householdTo = getTo();
          toArray.add(householdTo);
       }
       return toArray;
    }
 
   /*************************************************************************
    *
    * Copies data into Transfer Object Array of specified size
    *
    * NOTE: 
    * Result Set has to be "Scrollable"
    *
    *************************************************************************/
   public ArrayList<HouseholdTo> getToArray(int arraySize) throws GDAOException {
      int i = 0;
      ArrayList <HouseholdTo> toArray = new ArrayList<HouseholdTo>();
      try {
         while (i < arraySize) {
            if (!this.resultSet.isLast() && !this.resultSet.isAfterLast() && this.getResultSetRowCount() > 0) {
               next();
               HouseholdTo householdTo = getTo();
               toArray.add(householdTo);
            }
            else {
               break;
            }
            i++;
         }
      } catch (SQLException ex) {
         ex.printStackTrace();
         throw new GDAOException(ex);
      }
      return toArray;
   }

   /*************************************************************************
    *
    * Copies all data into Transfer Object Array
    *
    * NOTE: 
    * Result Set has to be "Scrollable"
    *
    *************************************************************************/
   public ArrayList <HouseholdTo> getToArray(String what) throws GDAOException {
      ArrayList <HouseholdTo> toArray = new ArrayList<HouseholdTo>();
      try {
         if (what.equals(BaseOracleDbEntityClass.FETCH_ALL)) {
            this.resultSet.beforeFirst();
            toArray = getToArray((int)getResultSetRowCount());
         }
         else {
            toArray = getToArray((int)getResultSetRowCount() - this.resultSet.getRow());
         }
      } catch (SQLException ex) {
         ex.printStackTrace();
         throw new GDAOException(ex);
      }
      return toArray;
   }

   /*************************************************************************
    *
    * Copies data from Transfer Object to this object
    *
    *************************************************************************/
   public void setThisFromTo(HouseholdTo householdTo) throws GDAOException {

            this.setHOUSEHOLD_ID(householdTo.getHOUSEHOLD_ID());
      this.setHOUSEHOLD_NAME(householdTo.getHOUSEHOLD_NAME());


      return;
   }

   /*************************************************************************
    *
    * Prints values of This Object
    *
    *************************************************************************/
   public void print(String fieldDelimiter) {
      System.out.println(      this.getHOUSEHOLD_ID()
       + fieldDelimiter + this.getHOUSEHOLD_NAME()
);
      return;
   }

   /*************************************************************************
    *
    * Prints Transfer Object
    *
    *************************************************************************/
   public static void print(HouseholdTo householdTo, String fieldDelimiter) {
      System.out.println(      householdTo.getHOUSEHOLD_ID()
       + fieldDelimiter + householdTo.getHOUSEHOLD_NAME()
);
      return;
   }

   /*************************************************************************
    *
    * Returns current ResultSet
    *
    *************************************************************************/
   public ResultSet getResultSet() {
      return this.resultSet;
   }
}