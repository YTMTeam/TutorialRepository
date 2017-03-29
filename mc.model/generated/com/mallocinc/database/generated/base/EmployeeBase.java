package com.mallocinc.database.generated.base;

import java.sql.*;
import java.io.*;
import com.mallocinc.codegenerator.superclasses.oracle.*;
import java.util.ArrayList;
import java.util.Arrays;

import com.mallocinc.database.generated.to.EmployeeTo;
import com.mallocinc.codegenerator.exceptions.*;

/*************************************************************************
 *  <pre>
 *
 *  Generated Class: EmployeeBase.java
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
 *  This code is generated on: 2017-February-27 06:45:55 PM CET
 *
 *  Copyright (C) 2015 Malloc Inc.
 *
 *  </pre>
 **************************************************************************/
@SuppressWarnings("unused")
public class EmployeeBase extends BaseOracleDbEntityClass <EmployeeTo> {

   /**********************************************************************
    *
    *  Database Variables declarations
    *  They represent database columns
    *
    **********************************************************************/
   private java.lang.String EMPLOYEE_ID = null;
private java.math.BigDecimal BANK_ID = null;
private java.lang.String FIRST_NAME = null;
private java.lang.String MIDDLE_NAME = null;
private java.lang.String LAST_NAME = null;
private java.lang.String EMPLOYING_INSTITUTION = null;


   /**********************************************************
    *
    *  Default Constructor
    *
    ***********************************************************/
   public EmployeeBase( ) {

      if (getDbEntityName() == null) {
         setDbEntityName("EMPLOYEE");
      }

      columnsCommaDelimitedList = " EMPLOYEE_ID"
   + ",BANK_ID"
   + ",FIRST_NAME"
   + ",MIDDLE_NAME"
   + ",LAST_NAME"
   + ",EMPLOYING_INSTITUTION"
   ;

      setSelectAllSQL();

      setDbEntityType("TABLE");

      OracleDbColumn dbColumn = null;

         dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "EMPLOYEE_ID" );
      dbColumn.setORDINAL_POSITION( 1 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      dbColumn.setPrimaryKey( true );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "BANK_ID" );
      dbColumn.setORDINAL_POSITION( 2 );
      dbColumn.setTYPE_NAME( "NUMBER" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "FIRST_NAME" );
      dbColumn.setORDINAL_POSITION( 3 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "MIDDLE_NAME" );
      dbColumn.setORDINAL_POSITION( 4 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "YES" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "LAST_NAME" );
      dbColumn.setORDINAL_POSITION( 5 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "EMPLOYING_INSTITUTION" );
      dbColumn.setORDINAL_POSITION( 6 );
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
   public EmployeeBase( Connection connection ) {
      this(); //chain default constructor
      this.connection = connection;
   }

   /**********************************************************
    *
    *  Constructor
    *
    ***********************************************************/
   public EmployeeBase( String underlyingEntityName ) {
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
    
   public void setEMPLOYEE_ID( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.EMPLOYEE_ID == null && value == null) || 
         (this.EMPLOYEE_ID != null && this.EMPLOYEE_ID.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.EMPLOYEE_ID = value;
      if ( this.changedColumns.get( "EMPLOYEE_ID" ) == null )  {
         this.changedColumns.put( "EMPLOYEE_ID", "java.lang.String" );
         this.setDbColumnChangedFlag("EMPLOYEE_ID", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("EMPLOYEE_ID").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setBANK_ID( java.math.BigDecimal value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.BANK_ID == null && value == null) || 
         (this.BANK_ID != null && this.BANK_ID.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.BANK_ID = value;
      if ( this.changedColumns.get( "BANK_ID" ) == null )  {
         this.changedColumns.put( "BANK_ID", "java.math.BigDecimal" );
         this.setDbColumnChangedFlag("BANK_ID", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateBigDecimal(getDbColumn("BANK_ID").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setFIRST_NAME( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.FIRST_NAME == null && value == null) || 
         (this.FIRST_NAME != null && this.FIRST_NAME.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.FIRST_NAME = value;
      if ( this.changedColumns.get( "FIRST_NAME" ) == null )  {
         this.changedColumns.put( "FIRST_NAME", "java.lang.String" );
         this.setDbColumnChangedFlag("FIRST_NAME", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("FIRST_NAME").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setMIDDLE_NAME( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.MIDDLE_NAME == null && value == null) || 
         (this.MIDDLE_NAME != null && this.MIDDLE_NAME.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.MIDDLE_NAME = value;
      if ( this.changedColumns.get( "MIDDLE_NAME" ) == null )  {
         this.changedColumns.put( "MIDDLE_NAME", "java.lang.String" );
         this.setDbColumnChangedFlag("MIDDLE_NAME", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("MIDDLE_NAME").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setLAST_NAME( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.LAST_NAME == null && value == null) || 
         (this.LAST_NAME != null && this.LAST_NAME.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.LAST_NAME = value;
      if ( this.changedColumns.get( "LAST_NAME" ) == null )  {
         this.changedColumns.put( "LAST_NAME", "java.lang.String" );
         this.setDbColumnChangedFlag("LAST_NAME", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("LAST_NAME").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setEMPLOYING_INSTITUTION( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.EMPLOYING_INSTITUTION == null && value == null) || 
         (this.EMPLOYING_INSTITUTION != null && this.EMPLOYING_INSTITUTION.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.EMPLOYING_INSTITUTION = value;
      if ( this.changedColumns.get( "EMPLOYING_INSTITUTION" ) == null )  {
         this.changedColumns.put( "EMPLOYING_INSTITUTION", "java.lang.String" );
         this.setDbColumnChangedFlag("EMPLOYING_INSTITUTION", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("EMPLOYING_INSTITUTION").getORDINAL_POSITION(), value);
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
    public java.lang.String getEMPLOYEE_ID( ) {
      return this.EMPLOYEE_ID;
   }
   public java.math.BigDecimal getBANK_ID( ) {
      return this.BANK_ID;
   }
   public java.lang.String getFIRST_NAME( ) {
      return this.FIRST_NAME;
   }
   public java.lang.String getMIDDLE_NAME( ) {
      return this.MIDDLE_NAME;
   }
   public java.lang.String getLAST_NAME( ) {
      return this.LAST_NAME;
   }
   public java.lang.String getEMPLOYING_INSTITUTION( ) {
      return this.EMPLOYING_INSTITUTION;
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

                     this.EMPLOYEE_ID = this.resultSet.getString(1);
            this.BANK_ID = this.resultSet.getBigDecimal(2);
            this.FIRST_NAME = this.resultSet.getString(3);
            this.MIDDLE_NAME = this.resultSet.getString(4);
            this.LAST_NAME = this.resultSet.getString(5);
            this.EMPLOYING_INSTITUTION = this.resultSet.getString(6);
   
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

                     this.EMPLOYEE_ID = this.resultSet.getString(1);
            this.BANK_ID = this.resultSet.getBigDecimal(2);
            this.FIRST_NAME = this.resultSet.getString(3);
            this.MIDDLE_NAME = this.resultSet.getString(4);
            this.LAST_NAME = this.resultSet.getString(5);
            this.EMPLOYING_INSTITUTION = this.resultSet.getString(6);
   
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

                    this.EMPLOYEE_ID = this.resultSet.getString(1);
            this.BANK_ID = this.resultSet.getBigDecimal(2);
            this.FIRST_NAME = this.resultSet.getString(3);
            this.MIDDLE_NAME = this.resultSet.getString(4);
            this.LAST_NAME = this.resultSet.getString(5);
            this.EMPLOYING_INSTITUTION = this.resultSet.getString(6);
   

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
   public EmployeeTo getTo() {
      EmployeeTo employeeTo = new EmployeeTo();

            employeeTo.setEMPLOYEE_ID(this.EMPLOYEE_ID);
      employeeTo.setBANK_ID(this.BANK_ID);
      employeeTo.setFIRST_NAME(this.FIRST_NAME);
      employeeTo.setMIDDLE_NAME(this.MIDDLE_NAME);
      employeeTo.setLAST_NAME(this.LAST_NAME);
      employeeTo.setEMPLOYING_INSTITUTION(this.EMPLOYING_INSTITUTION);


      return employeeTo;
   }

   /*************************************************************************
    *
    * Copies data from Transfer Object PK columns to corresponding columns
    * of database object
    *
    *************************************************************************/
    public void setPkValuesFromTo(EmployeeTo employeeTo) throws GDAOException {

            this.setEMPLOYEE_ID(employeeTo.getEMPLOYEE_ID());


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

      String SQL = "DELETE FROM EMPLOYEE WHERE ";
      SQL = SQL + "EMPLOYEE_ID = ? ";

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
    public ArrayList<EmployeeTo> getToArrayEntireResultSet() throws GDAOException {
       ArrayList<EmployeeTo> toArray = new ArrayList<EmployeeTo>();
       while (next()) {
          EmployeeTo employeeTo = getTo();
          toArray.add(employeeTo);
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
   public ArrayList<EmployeeTo> getToArray(int arraySize) throws GDAOException {
      int i = 0;
      ArrayList <EmployeeTo> toArray = new ArrayList<EmployeeTo>();
      try {
         while (i < arraySize) {
            if (!this.resultSet.isLast() && !this.resultSet.isAfterLast() && this.getResultSetRowCount() > 0) {
               next();
               EmployeeTo employeeTo = getTo();
               toArray.add(employeeTo);
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
   public ArrayList <EmployeeTo> getToArray(String what) throws GDAOException {
      ArrayList <EmployeeTo> toArray = new ArrayList<EmployeeTo>();
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
   public void setThisFromTo(EmployeeTo employeeTo) throws GDAOException {

            this.setEMPLOYEE_ID(employeeTo.getEMPLOYEE_ID());
      this.setBANK_ID(employeeTo.getBANK_ID());
      this.setFIRST_NAME(employeeTo.getFIRST_NAME());
      this.setMIDDLE_NAME(employeeTo.getMIDDLE_NAME());
      this.setLAST_NAME(employeeTo.getLAST_NAME());
      this.setEMPLOYING_INSTITUTION(employeeTo.getEMPLOYING_INSTITUTION());


      return;
   }

   /*************************************************************************
    *
    * Prints values of This Object
    *
    *************************************************************************/
   public void print(String fieldDelimiter) {
      System.out.println(      this.getEMPLOYEE_ID()
       + fieldDelimiter + this.getBANK_ID()
       + fieldDelimiter + this.getFIRST_NAME()
       + fieldDelimiter + this.getMIDDLE_NAME()
       + fieldDelimiter + this.getLAST_NAME()
       + fieldDelimiter + this.getEMPLOYING_INSTITUTION()
);
      return;
   }

   /*************************************************************************
    *
    * Prints Transfer Object
    *
    *************************************************************************/
   public static void print(EmployeeTo employeeTo, String fieldDelimiter) {
      System.out.println(      employeeTo.getEMPLOYEE_ID()
       + fieldDelimiter + employeeTo.getBANK_ID()
       + fieldDelimiter + employeeTo.getFIRST_NAME()
       + fieldDelimiter + employeeTo.getMIDDLE_NAME()
       + fieldDelimiter + employeeTo.getLAST_NAME()
       + fieldDelimiter + employeeTo.getEMPLOYING_INSTITUTION()
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