package com.mallocinc.database.generated.base;

import java.sql.*;
import java.io.*;
import com.mallocinc.codegenerator.superclasses.oracle.*;
import java.util.ArrayList;
import java.util.Arrays;

import com.mallocinc.database.generated.to.MonitorTo;
import com.mallocinc.codegenerator.exceptions.*;

/*************************************************************************
 *  <pre>
 *
 *  Generated Class: MonitorBase.java
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
public class MonitorBase extends BaseOracleDbEntityClass <MonitorTo> {

   /**********************************************************************
    *
    *  Database Variables declarations
    *  They represent database columns
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


   /**********************************************************
    *
    *  Default Constructor
    *
    ***********************************************************/
   public MonitorBase( ) {

      if (getDbEntityName() == null) {
         setDbEntityName("MONITOR");
      }

      columnsCommaDelimitedList = " MONITOR_ID"
   + ",ACCOUNT_ID"
   + ",BANK_ID"
   + ",EMPLOYEE_ID"
   + ",ACCOUNT_FIRST_NAME"
   + ",ACCOUNT_MIDDLE_NAME"
   + ",ACCOUNT_LAST_NAME"
   + ",RELATIONSHIP"
   + ",AS_OF_DATE"
   + ",END_DATE"
   + ",CREATE_TIMESTAMP"
   ;

      setSelectAllSQL();

      setDbEntityType("TABLE");

      OracleDbColumn dbColumn = null;

         dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "MONITOR_ID" );
      dbColumn.setORDINAL_POSITION( 1 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      dbColumn.setPrimaryKey( true );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "ACCOUNT_ID" );
      dbColumn.setORDINAL_POSITION( 2 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "BANK_ID" );
      dbColumn.setORDINAL_POSITION( 3 );
      dbColumn.setTYPE_NAME( "NUMBER" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "EMPLOYEE_ID" );
      dbColumn.setORDINAL_POSITION( 4 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "ACCOUNT_FIRST_NAME" );
      dbColumn.setORDINAL_POSITION( 5 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "ACCOUNT_MIDDLE_NAME" );
      dbColumn.setORDINAL_POSITION( 6 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "YES" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "ACCOUNT_LAST_NAME" );
      dbColumn.setORDINAL_POSITION( 7 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "RELATIONSHIP" );
      dbColumn.setORDINAL_POSITION( 8 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "AS_OF_DATE" );
      dbColumn.setORDINAL_POSITION( 9 );
      dbColumn.setTYPE_NAME( "DATE" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "END_DATE" );
      dbColumn.setORDINAL_POSITION( 10 );
      dbColumn.setTYPE_NAME( "DATE" );
      dbColumn.setIS_NULLABLE( "YES" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "CREATE_TIMESTAMP" );
      dbColumn.setORDINAL_POSITION( 11 );
      dbColumn.setTYPE_NAME( "TIMESTAMP(6)" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);


   }

   /**********************************************************
    *
    *  Constructor
    *
    ***********************************************************/
   public MonitorBase( Connection connection ) {
      this(); //chain default constructor
      this.connection = connection;
   }

   /**********************************************************
    *
    *  Constructor
    *
    ***********************************************************/
   public MonitorBase( String underlyingEntityName ) {
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
    
   public void setMONITOR_ID( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.MONITOR_ID == null && value == null) || 
         (this.MONITOR_ID != null && this.MONITOR_ID.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.MONITOR_ID = value;
      if ( this.changedColumns.get( "MONITOR_ID" ) == null )  {
         this.changedColumns.put( "MONITOR_ID", "java.lang.String" );
         this.setDbColumnChangedFlag("MONITOR_ID", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("MONITOR_ID").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

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

   public void setACCOUNT_FIRST_NAME( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.ACCOUNT_FIRST_NAME == null && value == null) || 
         (this.ACCOUNT_FIRST_NAME != null && this.ACCOUNT_FIRST_NAME.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.ACCOUNT_FIRST_NAME = value;
      if ( this.changedColumns.get( "ACCOUNT_FIRST_NAME" ) == null )  {
         this.changedColumns.put( "ACCOUNT_FIRST_NAME", "java.lang.String" );
         this.setDbColumnChangedFlag("ACCOUNT_FIRST_NAME", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("ACCOUNT_FIRST_NAME").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setACCOUNT_MIDDLE_NAME( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.ACCOUNT_MIDDLE_NAME == null && value == null) || 
         (this.ACCOUNT_MIDDLE_NAME != null && this.ACCOUNT_MIDDLE_NAME.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.ACCOUNT_MIDDLE_NAME = value;
      if ( this.changedColumns.get( "ACCOUNT_MIDDLE_NAME" ) == null )  {
         this.changedColumns.put( "ACCOUNT_MIDDLE_NAME", "java.lang.String" );
         this.setDbColumnChangedFlag("ACCOUNT_MIDDLE_NAME", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("ACCOUNT_MIDDLE_NAME").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setACCOUNT_LAST_NAME( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.ACCOUNT_LAST_NAME == null && value == null) || 
         (this.ACCOUNT_LAST_NAME != null && this.ACCOUNT_LAST_NAME.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.ACCOUNT_LAST_NAME = value;
      if ( this.changedColumns.get( "ACCOUNT_LAST_NAME" ) == null )  {
         this.changedColumns.put( "ACCOUNT_LAST_NAME", "java.lang.String" );
         this.setDbColumnChangedFlag("ACCOUNT_LAST_NAME", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("ACCOUNT_LAST_NAME").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setRELATIONSHIP( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.RELATIONSHIP == null && value == null) || 
         (this.RELATIONSHIP != null && this.RELATIONSHIP.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.RELATIONSHIP = value;
      if ( this.changedColumns.get( "RELATIONSHIP" ) == null )  {
         this.changedColumns.put( "RELATIONSHIP", "java.lang.String" );
         this.setDbColumnChangedFlag("RELATIONSHIP", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("RELATIONSHIP").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setAS_OF_DATE( java.sql.Timestamp value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.AS_OF_DATE == null && value == null) || 
         (this.AS_OF_DATE != null && this.AS_OF_DATE.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.AS_OF_DATE = value;
      if ( this.changedColumns.get( "AS_OF_DATE" ) == null )  {
         this.changedColumns.put( "AS_OF_DATE", "java.sql.Timestamp" );
         this.setDbColumnChangedFlag("AS_OF_DATE", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateTimestamp(getDbColumn("AS_OF_DATE").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setEND_DATE( java.sql.Timestamp value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.END_DATE == null && value == null) || 
         (this.END_DATE != null && this.END_DATE.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.END_DATE = value;
      if ( this.changedColumns.get( "END_DATE" ) == null )  {
         this.changedColumns.put( "END_DATE", "java.sql.Timestamp" );
         this.setDbColumnChangedFlag("END_DATE", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateTimestamp(getDbColumn("END_DATE").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setCREATE_TIMESTAMP( java.sql.Timestamp value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.CREATE_TIMESTAMP == null && value == null) || 
         (this.CREATE_TIMESTAMP != null && this.CREATE_TIMESTAMP.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.CREATE_TIMESTAMP = value;
      if ( this.changedColumns.get( "CREATE_TIMESTAMP" ) == null )  {
         this.changedColumns.put( "CREATE_TIMESTAMP", "java.sql.Timestamp" );
         this.setDbColumnChangedFlag("CREATE_TIMESTAMP", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateTimestamp(getDbColumn("CREATE_TIMESTAMP").getORDINAL_POSITION(), value);
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
    public java.lang.String getMONITOR_ID( ) {
      return this.MONITOR_ID;
   }
   public java.lang.String getACCOUNT_ID( ) {
      return this.ACCOUNT_ID;
   }
   public java.math.BigDecimal getBANK_ID( ) {
      return this.BANK_ID;
   }
   public java.lang.String getEMPLOYEE_ID( ) {
      return this.EMPLOYEE_ID;
   }
   public java.lang.String getACCOUNT_FIRST_NAME( ) {
      return this.ACCOUNT_FIRST_NAME;
   }
   public java.lang.String getACCOUNT_MIDDLE_NAME( ) {
      return this.ACCOUNT_MIDDLE_NAME;
   }
   public java.lang.String getACCOUNT_LAST_NAME( ) {
      return this.ACCOUNT_LAST_NAME;
   }
   public java.lang.String getRELATIONSHIP( ) {
      return this.RELATIONSHIP;
   }
   public java.sql.Timestamp getAS_OF_DATE( ) {
      return this.AS_OF_DATE;
   }
   public java.sql.Timestamp getEND_DATE( ) {
      return this.END_DATE;
   }
   public java.sql.Timestamp getCREATE_TIMESTAMP( ) {
      return this.CREATE_TIMESTAMP;
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

                     this.MONITOR_ID = this.resultSet.getString(1);
            this.ACCOUNT_ID = this.resultSet.getString(2);
            this.BANK_ID = this.resultSet.getBigDecimal(3);
            this.EMPLOYEE_ID = this.resultSet.getString(4);
            this.ACCOUNT_FIRST_NAME = this.resultSet.getString(5);
            this.ACCOUNT_MIDDLE_NAME = this.resultSet.getString(6);
            this.ACCOUNT_LAST_NAME = this.resultSet.getString(7);
            this.RELATIONSHIP = this.resultSet.getString(8);
            this.AS_OF_DATE = this.resultSet.getTimestamp(9);
            this.END_DATE = this.resultSet.getTimestamp(10);
            this.CREATE_TIMESTAMP = this.resultSet.getTimestamp(11);
   
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

                     this.MONITOR_ID = this.resultSet.getString(1);
            this.ACCOUNT_ID = this.resultSet.getString(2);
            this.BANK_ID = this.resultSet.getBigDecimal(3);
            this.EMPLOYEE_ID = this.resultSet.getString(4);
            this.ACCOUNT_FIRST_NAME = this.resultSet.getString(5);
            this.ACCOUNT_MIDDLE_NAME = this.resultSet.getString(6);
            this.ACCOUNT_LAST_NAME = this.resultSet.getString(7);
            this.RELATIONSHIP = this.resultSet.getString(8);
            this.AS_OF_DATE = this.resultSet.getTimestamp(9);
            this.END_DATE = this.resultSet.getTimestamp(10);
            this.CREATE_TIMESTAMP = this.resultSet.getTimestamp(11);
   
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

                    this.MONITOR_ID = this.resultSet.getString(1);
            this.ACCOUNT_ID = this.resultSet.getString(2);
            this.BANK_ID = this.resultSet.getBigDecimal(3);
            this.EMPLOYEE_ID = this.resultSet.getString(4);
            this.ACCOUNT_FIRST_NAME = this.resultSet.getString(5);
            this.ACCOUNT_MIDDLE_NAME = this.resultSet.getString(6);
            this.ACCOUNT_LAST_NAME = this.resultSet.getString(7);
            this.RELATIONSHIP = this.resultSet.getString(8);
            this.AS_OF_DATE = this.resultSet.getTimestamp(9);
            this.END_DATE = this.resultSet.getTimestamp(10);
            this.CREATE_TIMESTAMP = this.resultSet.getTimestamp(11);
   

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
   public MonitorTo getTo() {
      MonitorTo monitorTo = new MonitorTo();

            monitorTo.setMONITOR_ID(this.MONITOR_ID);
      monitorTo.setACCOUNT_ID(this.ACCOUNT_ID);
      monitorTo.setBANK_ID(this.BANK_ID);
      monitorTo.setEMPLOYEE_ID(this.EMPLOYEE_ID);
      monitorTo.setACCOUNT_FIRST_NAME(this.ACCOUNT_FIRST_NAME);
      monitorTo.setACCOUNT_MIDDLE_NAME(this.ACCOUNT_MIDDLE_NAME);
      monitorTo.setACCOUNT_LAST_NAME(this.ACCOUNT_LAST_NAME);
      monitorTo.setRELATIONSHIP(this.RELATIONSHIP);
      monitorTo.setAS_OF_DATE(this.AS_OF_DATE);
      monitorTo.setEND_DATE(this.END_DATE);
      monitorTo.setCREATE_TIMESTAMP(this.CREATE_TIMESTAMP);


      return monitorTo;
   }

   /*************************************************************************
    *
    * Copies data from Transfer Object PK columns to corresponding columns
    * of database object
    *
    *************************************************************************/
    public void setPkValuesFromTo(MonitorTo monitorTo) throws GDAOException {

            this.setMONITOR_ID(monitorTo.getMONITOR_ID());


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

      String SQL = "DELETE FROM MONITOR WHERE ";
      SQL = SQL + "MONITOR_ID = ? ";

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
    public ArrayList<MonitorTo> getToArrayEntireResultSet() throws GDAOException {
       ArrayList<MonitorTo> toArray = new ArrayList<MonitorTo>();
       while (next()) {
          MonitorTo monitorTo = getTo();
          toArray.add(monitorTo);
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
   public ArrayList<MonitorTo> getToArray(int arraySize) throws GDAOException {
      int i = 0;
      ArrayList <MonitorTo> toArray = new ArrayList<MonitorTo>();
      try {
         while (i < arraySize) {
            if (!this.resultSet.isLast() && !this.resultSet.isAfterLast() && this.getResultSetRowCount() > 0) {
               next();
               MonitorTo monitorTo = getTo();
               toArray.add(monitorTo);
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
   public ArrayList <MonitorTo> getToArray(String what) throws GDAOException {
      ArrayList <MonitorTo> toArray = new ArrayList<MonitorTo>();
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
   public void setThisFromTo(MonitorTo monitorTo) throws GDAOException {

            this.setMONITOR_ID(monitorTo.getMONITOR_ID());
      this.setACCOUNT_ID(monitorTo.getACCOUNT_ID());
      this.setBANK_ID(monitorTo.getBANK_ID());
      this.setEMPLOYEE_ID(monitorTo.getEMPLOYEE_ID());
      this.setACCOUNT_FIRST_NAME(monitorTo.getACCOUNT_FIRST_NAME());
      this.setACCOUNT_MIDDLE_NAME(monitorTo.getACCOUNT_MIDDLE_NAME());
      this.setACCOUNT_LAST_NAME(monitorTo.getACCOUNT_LAST_NAME());
      this.setRELATIONSHIP(monitorTo.getRELATIONSHIP());
      this.setAS_OF_DATE(monitorTo.getAS_OF_DATE());
      this.setEND_DATE(monitorTo.getEND_DATE());
      this.setCREATE_TIMESTAMP(monitorTo.getCREATE_TIMESTAMP());


      return;
   }

   /*************************************************************************
    *
    * Prints values of This Object
    *
    *************************************************************************/
   public void print(String fieldDelimiter) {
      System.out.println(      this.getMONITOR_ID()
       + fieldDelimiter + this.getACCOUNT_ID()
       + fieldDelimiter + this.getBANK_ID()
       + fieldDelimiter + this.getEMPLOYEE_ID()
       + fieldDelimiter + this.getACCOUNT_FIRST_NAME()
       + fieldDelimiter + this.getACCOUNT_MIDDLE_NAME()
       + fieldDelimiter + this.getACCOUNT_LAST_NAME()
       + fieldDelimiter + this.getRELATIONSHIP()
       + fieldDelimiter + this.getAS_OF_DATE()
       + fieldDelimiter + this.getEND_DATE()
       + fieldDelimiter + this.getCREATE_TIMESTAMP()
);
      return;
   }

   /*************************************************************************
    *
    * Prints Transfer Object
    *
    *************************************************************************/
   public static void print(MonitorTo monitorTo, String fieldDelimiter) {
      System.out.println(      monitorTo.getMONITOR_ID()
       + fieldDelimiter + monitorTo.getACCOUNT_ID()
       + fieldDelimiter + monitorTo.getBANK_ID()
       + fieldDelimiter + monitorTo.getEMPLOYEE_ID()
       + fieldDelimiter + monitorTo.getACCOUNT_FIRST_NAME()
       + fieldDelimiter + monitorTo.getACCOUNT_MIDDLE_NAME()
       + fieldDelimiter + monitorTo.getACCOUNT_LAST_NAME()
       + fieldDelimiter + monitorTo.getRELATIONSHIP()
       + fieldDelimiter + monitorTo.getAS_OF_DATE()
       + fieldDelimiter + monitorTo.getEND_DATE()
       + fieldDelimiter + monitorTo.getCREATE_TIMESTAMP()
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