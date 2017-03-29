package com.mallocinc.database.generated.base;

import java.sql.*;
import java.io.*;
import com.mallocinc.codegenerator.superclasses.oracle.*;
import java.util.ArrayList;
import java.util.Arrays;

import com.mallocinc.database.generated.to.VExcelMonitoredAccountsTo;
import com.mallocinc.codegenerator.exceptions.*;

/*************************************************************************
 *  <pre>
 *
 *  Generated Class: VExcelMonitoredAccountsBase.java
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
 *  This code is generated on: 2017-February-27 06:45:57 PM CET
 *
 *  Copyright (C) 2015 Malloc Inc.
 *
 *  </pre>
 **************************************************************************/
@SuppressWarnings("unused")
public class VExcelMonitoredAccountsBase extends BaseOracleDbEntityClass <VExcelMonitoredAccountsTo> {

   /**********************************************************************
    *
    *  Database Variables declarations
    *  They represent database columns
    *
    **********************************************************************/
   private java.lang.String ACCOUNT_ID = null;
private java.math.BigDecimal MONITOR_BANK_ID = null;
private java.math.BigDecimal ACCOUNT_NUMBER = null;
private java.lang.String FIRST_NAME = null;
private java.lang.String LAST_NAME = null;
private java.lang.String BANK_NAME = null;


   /**********************************************************
    *
    *  Default Constructor
    *
    ***********************************************************/
   public VExcelMonitoredAccountsBase( ) {

      if (getDbEntityName() == null) {
         setDbEntityName("V_EXCEL_MONITORED_ACCOUNTS");
      }

      columnsCommaDelimitedList = " ACCOUNT_ID"
   + ",MONITOR_BANK_ID"
   + ",ACCOUNT_NUMBER"
   + ",FIRST_NAME"
   + ",LAST_NAME"
   + ",BANK_NAME"
   ;

      setSelectAllSQL();

      setDbEntityType("VIEW");

      OracleDbColumn dbColumn = null;

         dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "ACCOUNT_ID" );
      dbColumn.setORDINAL_POSITION( 1 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "MONITOR_BANK_ID" );
      dbColumn.setORDINAL_POSITION( 2 );
      dbColumn.setTYPE_NAME( "NUMBER" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "ACCOUNT_NUMBER" );
      dbColumn.setORDINAL_POSITION( 3 );
      dbColumn.setTYPE_NAME( "NUMBER" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "FIRST_NAME" );
      dbColumn.setORDINAL_POSITION( 4 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
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
      dbColumn.setCOLUMN_NAME( "BANK_NAME" );
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
   public VExcelMonitoredAccountsBase( Connection connection ) {
      this(); //chain default constructor
      this.connection = connection;
   }

   /**********************************************************
    *
    *  Constructor
    *
    ***********************************************************/
   public VExcelMonitoredAccountsBase( String underlyingEntityName ) {
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
    
   public void setACCOUNT_ID( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.ACCOUNT_ID == null && value == null) || 
         (this.ACCOUNT_ID != null && this.ACCOUNT_ID.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.ACCOUNT_ID = value;
      if ( this.changedColumns.get( "ACCOUNT_ID" ) == null )  {
         this.changedColumns.put( "ACCOUNT_ID", "java.lang.String" );
         this.setDbColumnChangedFlag("ACCOUNT_ID", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("ACCOUNT_ID").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setMONITOR_BANK_ID( java.math.BigDecimal value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.MONITOR_BANK_ID == null && value == null) || 
         (this.MONITOR_BANK_ID != null && this.MONITOR_BANK_ID.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.MONITOR_BANK_ID = value;
      if ( this.changedColumns.get( "MONITOR_BANK_ID" ) == null )  {
         this.changedColumns.put( "MONITOR_BANK_ID", "java.math.BigDecimal" );
         this.setDbColumnChangedFlag("MONITOR_BANK_ID", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateBigDecimal(getDbColumn("MONITOR_BANK_ID").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setACCOUNT_NUMBER( java.math.BigDecimal value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.ACCOUNT_NUMBER == null && value == null) || 
         (this.ACCOUNT_NUMBER != null && this.ACCOUNT_NUMBER.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.ACCOUNT_NUMBER = value;
      if ( this.changedColumns.get( "ACCOUNT_NUMBER" ) == null )  {
         this.changedColumns.put( "ACCOUNT_NUMBER", "java.math.BigDecimal" );
         this.setDbColumnChangedFlag("ACCOUNT_NUMBER", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateBigDecimal(getDbColumn("ACCOUNT_NUMBER").getORDINAL_POSITION(), value);
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

   public void setBANK_NAME( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.BANK_NAME == null && value == null) || 
         (this.BANK_NAME != null && this.BANK_NAME.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.BANK_NAME = value;
      if ( this.changedColumns.get( "BANK_NAME" ) == null )  {
         this.changedColumns.put( "BANK_NAME", "java.lang.String" );
         this.setDbColumnChangedFlag("BANK_NAME", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("BANK_NAME").getORDINAL_POSITION(), value);
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
    public java.lang.String getACCOUNT_ID( ) {
      return this.ACCOUNT_ID;
   }
   public java.math.BigDecimal getMONITOR_BANK_ID( ) {
      return this.MONITOR_BANK_ID;
   }
   public java.math.BigDecimal getACCOUNT_NUMBER( ) {
      return this.ACCOUNT_NUMBER;
   }
   public java.lang.String getFIRST_NAME( ) {
      return this.FIRST_NAME;
   }
   public java.lang.String getLAST_NAME( ) {
      return this.LAST_NAME;
   }
   public java.lang.String getBANK_NAME( ) {
      return this.BANK_NAME;
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

                     this.ACCOUNT_ID = this.resultSet.getString(1);
            this.MONITOR_BANK_ID = this.resultSet.getBigDecimal(2);
            this.ACCOUNT_NUMBER = this.resultSet.getBigDecimal(3);
            this.FIRST_NAME = this.resultSet.getString(4);
            this.LAST_NAME = this.resultSet.getString(5);
            this.BANK_NAME = this.resultSet.getString(6);
   
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

                     this.ACCOUNT_ID = this.resultSet.getString(1);
            this.MONITOR_BANK_ID = this.resultSet.getBigDecimal(2);
            this.ACCOUNT_NUMBER = this.resultSet.getBigDecimal(3);
            this.FIRST_NAME = this.resultSet.getString(4);
            this.LAST_NAME = this.resultSet.getString(5);
            this.BANK_NAME = this.resultSet.getString(6);
   
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

                    this.ACCOUNT_ID = this.resultSet.getString(1);
            this.MONITOR_BANK_ID = this.resultSet.getBigDecimal(2);
            this.ACCOUNT_NUMBER = this.resultSet.getBigDecimal(3);
            this.FIRST_NAME = this.resultSet.getString(4);
            this.LAST_NAME = this.resultSet.getString(5);
            this.BANK_NAME = this.resultSet.getString(6);
   

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
   public VExcelMonitoredAccountsTo getTo() {
      VExcelMonitoredAccountsTo vExcelMonitoredAccountsTo = new VExcelMonitoredAccountsTo();

            vExcelMonitoredAccountsTo.setACCOUNT_ID(this.ACCOUNT_ID);
      vExcelMonitoredAccountsTo.setMONITOR_BANK_ID(this.MONITOR_BANK_ID);
      vExcelMonitoredAccountsTo.setACCOUNT_NUMBER(this.ACCOUNT_NUMBER);
      vExcelMonitoredAccountsTo.setFIRST_NAME(this.FIRST_NAME);
      vExcelMonitoredAccountsTo.setLAST_NAME(this.LAST_NAME);
      vExcelMonitoredAccountsTo.setBANK_NAME(this.BANK_NAME);


      return vExcelMonitoredAccountsTo;
   }

   /*************************************************************************
    *
    * Copies data from Transfer Object PK columns to corresponding columns
    * of database object
    *
    *************************************************************************/
    public void setPkValuesFromTo(VExcelMonitoredAccountsTo vExcelMonitoredAccountsTo) throws GDAOException {

      

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

      String SQL = "DELETE FROM V_EXCEL_MONITORED_ACCOUNTS WHERE ";
      SQL = SQL + "";

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
    public ArrayList<VExcelMonitoredAccountsTo> getToArrayEntireResultSet() throws GDAOException {
       ArrayList<VExcelMonitoredAccountsTo> toArray = new ArrayList<VExcelMonitoredAccountsTo>();
       while (next()) {
          VExcelMonitoredAccountsTo vExcelMonitoredAccountsTo = getTo();
          toArray.add(vExcelMonitoredAccountsTo);
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
   public ArrayList<VExcelMonitoredAccountsTo> getToArray(int arraySize) throws GDAOException {
      int i = 0;
      ArrayList <VExcelMonitoredAccountsTo> toArray = new ArrayList<VExcelMonitoredAccountsTo>();
      try {
         while (i < arraySize) {
            if (!this.resultSet.isLast() && !this.resultSet.isAfterLast() && this.getResultSetRowCount() > 0) {
               next();
               VExcelMonitoredAccountsTo vExcelMonitoredAccountsTo = getTo();
               toArray.add(vExcelMonitoredAccountsTo);
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
   public ArrayList <VExcelMonitoredAccountsTo> getToArray(String what) throws GDAOException {
      ArrayList <VExcelMonitoredAccountsTo> toArray = new ArrayList<VExcelMonitoredAccountsTo>();
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
   public void setThisFromTo(VExcelMonitoredAccountsTo vExcelMonitoredAccountsTo) throws GDAOException {

            this.setACCOUNT_ID(vExcelMonitoredAccountsTo.getACCOUNT_ID());
      this.setMONITOR_BANK_ID(vExcelMonitoredAccountsTo.getMONITOR_BANK_ID());
      this.setACCOUNT_NUMBER(vExcelMonitoredAccountsTo.getACCOUNT_NUMBER());
      this.setFIRST_NAME(vExcelMonitoredAccountsTo.getFIRST_NAME());
      this.setLAST_NAME(vExcelMonitoredAccountsTo.getLAST_NAME());
      this.setBANK_NAME(vExcelMonitoredAccountsTo.getBANK_NAME());


      return;
   }

   /*************************************************************************
    *
    * Prints values of This Object
    *
    *************************************************************************/
   public void print(String fieldDelimiter) {
      System.out.println(      this.getACCOUNT_ID()
       + fieldDelimiter + this.getMONITOR_BANK_ID()
       + fieldDelimiter + this.getACCOUNT_NUMBER()
       + fieldDelimiter + this.getFIRST_NAME()
       + fieldDelimiter + this.getLAST_NAME()
       + fieldDelimiter + this.getBANK_NAME()
);
      return;
   }

   /*************************************************************************
    *
    * Prints Transfer Object
    *
    *************************************************************************/
   public static void print(VExcelMonitoredAccountsTo vExcelMonitoredAccountsTo, String fieldDelimiter) {
      System.out.println(      vExcelMonitoredAccountsTo.getACCOUNT_ID()
       + fieldDelimiter + vExcelMonitoredAccountsTo.getMONITOR_BANK_ID()
       + fieldDelimiter + vExcelMonitoredAccountsTo.getACCOUNT_NUMBER()
       + fieldDelimiter + vExcelMonitoredAccountsTo.getFIRST_NAME()
       + fieldDelimiter + vExcelMonitoredAccountsTo.getLAST_NAME()
       + fieldDelimiter + vExcelMonitoredAccountsTo.getBANK_NAME()
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