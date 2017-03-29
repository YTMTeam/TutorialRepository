package com.mallocinc.database.generated.base;

import java.sql.*;
import java.io.*;
import com.mallocinc.codegenerator.superclasses.oracle.*;
import java.util.ArrayList;
import java.util.Arrays;

import com.mallocinc.database.generated.to.PositionTo;
import com.mallocinc.codegenerator.exceptions.*;

/*************************************************************************
 *  <pre>
 *
 *  Generated Class: PositionBase.java
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
 *  This code is generated on: 2017-February-27 06:45:56 PM CET
 *
 *  Copyright (C) 2015 Malloc Inc.
 *
 *  </pre>
 **************************************************************************/
@SuppressWarnings("unused")
public class PositionBase extends BaseOracleDbEntityClass <PositionTo> {

   /**********************************************************************
    *
    *  Database Variables declarations
    *  They represent database columns
    *
    **********************************************************************/
   private java.lang.String POSITION_ID = null;
private java.lang.String ACCOUNT_ID = null;
private java.lang.String BROKER_CODE = null;
private java.lang.String SECURITY_SYMBOL = null;
private java.lang.String CUSIP = null;
private java.lang.String ISIN = null;
private java.lang.String SEDOL = null;
private java.lang.String CURRENCY = null;
private java.sql.Timestamp EXPIRATION_DATE = null;
private java.math.BigDecimal EXECUTION_PRICE = null;
private java.math.BigDecimal MARKET_PRICE = null;
private java.math.BigDecimal QUANTITY = null;


   /**********************************************************
    *
    *  Default Constructor
    *
    ***********************************************************/
   public PositionBase( ) {

      if (getDbEntityName() == null) {
         setDbEntityName("POSITION");
      }

      columnsCommaDelimitedList = " POSITION_ID"
   + ",ACCOUNT_ID"
   + ",BROKER_CODE"
   + ",SECURITY_SYMBOL"
   + ",CUSIP"
   + ",ISIN"
   + ",SEDOL"
   + ",CURRENCY"
   + ",EXPIRATION_DATE"
   + ",EXECUTION_PRICE"
   + ",MARKET_PRICE"
   + ",QUANTITY"
   ;

      setSelectAllSQL();

      setDbEntityType("TABLE");

      OracleDbColumn dbColumn = null;

         dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "POSITION_ID" );
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
      dbColumn.setCOLUMN_NAME( "BROKER_CODE" );
      dbColumn.setORDINAL_POSITION( 3 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "SECURITY_SYMBOL" );
      dbColumn.setORDINAL_POSITION( 4 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "CUSIP" );
      dbColumn.setORDINAL_POSITION( 5 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "YES" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "ISIN" );
      dbColumn.setORDINAL_POSITION( 6 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "YES" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "SEDOL" );
      dbColumn.setORDINAL_POSITION( 7 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "YES" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "CURRENCY" );
      dbColumn.setORDINAL_POSITION( 8 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "EXPIRATION_DATE" );
      dbColumn.setORDINAL_POSITION( 9 );
      dbColumn.setTYPE_NAME( "DATE" );
      dbColumn.setIS_NULLABLE( "YES" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "EXECUTION_PRICE" );
      dbColumn.setORDINAL_POSITION( 10 );
      dbColumn.setTYPE_NAME( "NUMBER" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "MARKET_PRICE" );
      dbColumn.setORDINAL_POSITION( 11 );
      dbColumn.setTYPE_NAME( "NUMBER" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "QUANTITY" );
      dbColumn.setORDINAL_POSITION( 12 );
      dbColumn.setTYPE_NAME( "NUMBER" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);


   }

   /**********************************************************
    *
    *  Constructor
    *
    ***********************************************************/
   public PositionBase( Connection connection ) {
      this(); //chain default constructor
      this.connection = connection;
   }

   /**********************************************************
    *
    *  Constructor
    *
    ***********************************************************/
   public PositionBase( String underlyingEntityName ) {
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
    
   public void setPOSITION_ID( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.POSITION_ID == null && value == null) || 
         (this.POSITION_ID != null && this.POSITION_ID.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.POSITION_ID = value;
      if ( this.changedColumns.get( "POSITION_ID" ) == null )  {
         this.changedColumns.put( "POSITION_ID", "java.lang.String" );
         this.setDbColumnChangedFlag("POSITION_ID", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("POSITION_ID").getORDINAL_POSITION(), value);
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

   public void setBROKER_CODE( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.BROKER_CODE == null && value == null) || 
         (this.BROKER_CODE != null && this.BROKER_CODE.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.BROKER_CODE = value;
      if ( this.changedColumns.get( "BROKER_CODE" ) == null )  {
         this.changedColumns.put( "BROKER_CODE", "java.lang.String" );
         this.setDbColumnChangedFlag("BROKER_CODE", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("BROKER_CODE").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setSECURITY_SYMBOL( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.SECURITY_SYMBOL == null && value == null) || 
         (this.SECURITY_SYMBOL != null && this.SECURITY_SYMBOL.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.SECURITY_SYMBOL = value;
      if ( this.changedColumns.get( "SECURITY_SYMBOL" ) == null )  {
         this.changedColumns.put( "SECURITY_SYMBOL", "java.lang.String" );
         this.setDbColumnChangedFlag("SECURITY_SYMBOL", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("SECURITY_SYMBOL").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setCUSIP( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.CUSIP == null && value == null) || 
         (this.CUSIP != null && this.CUSIP.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.CUSIP = value;
      if ( this.changedColumns.get( "CUSIP" ) == null )  {
         this.changedColumns.put( "CUSIP", "java.lang.String" );
         this.setDbColumnChangedFlag("CUSIP", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("CUSIP").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setISIN( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.ISIN == null && value == null) || 
         (this.ISIN != null && this.ISIN.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.ISIN = value;
      if ( this.changedColumns.get( "ISIN" ) == null )  {
         this.changedColumns.put( "ISIN", "java.lang.String" );
         this.setDbColumnChangedFlag("ISIN", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("ISIN").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setSEDOL( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.SEDOL == null && value == null) || 
         (this.SEDOL != null && this.SEDOL.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.SEDOL = value;
      if ( this.changedColumns.get( "SEDOL" ) == null )  {
         this.changedColumns.put( "SEDOL", "java.lang.String" );
         this.setDbColumnChangedFlag("SEDOL", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("SEDOL").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setCURRENCY( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.CURRENCY == null && value == null) || 
         (this.CURRENCY != null && this.CURRENCY.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.CURRENCY = value;
      if ( this.changedColumns.get( "CURRENCY" ) == null )  {
         this.changedColumns.put( "CURRENCY", "java.lang.String" );
         this.setDbColumnChangedFlag("CURRENCY", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("CURRENCY").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setEXPIRATION_DATE( java.sql.Timestamp value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.EXPIRATION_DATE == null && value == null) || 
         (this.EXPIRATION_DATE != null && this.EXPIRATION_DATE.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.EXPIRATION_DATE = value;
      if ( this.changedColumns.get( "EXPIRATION_DATE" ) == null )  {
         this.changedColumns.put( "EXPIRATION_DATE", "java.sql.Timestamp" );
         this.setDbColumnChangedFlag("EXPIRATION_DATE", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateTimestamp(getDbColumn("EXPIRATION_DATE").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setEXECUTION_PRICE( java.math.BigDecimal value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.EXECUTION_PRICE == null && value == null) || 
         (this.EXECUTION_PRICE != null && this.EXECUTION_PRICE.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.EXECUTION_PRICE = value;
      if ( this.changedColumns.get( "EXECUTION_PRICE" ) == null )  {
         this.changedColumns.put( "EXECUTION_PRICE", "java.math.BigDecimal" );
         this.setDbColumnChangedFlag("EXECUTION_PRICE", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateBigDecimal(getDbColumn("EXECUTION_PRICE").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setMARKET_PRICE( java.math.BigDecimal value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.MARKET_PRICE == null && value == null) || 
         (this.MARKET_PRICE != null && this.MARKET_PRICE.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.MARKET_PRICE = value;
      if ( this.changedColumns.get( "MARKET_PRICE" ) == null )  {
         this.changedColumns.put( "MARKET_PRICE", "java.math.BigDecimal" );
         this.setDbColumnChangedFlag("MARKET_PRICE", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateBigDecimal(getDbColumn("MARKET_PRICE").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setQUANTITY( java.math.BigDecimal value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.QUANTITY == null && value == null) || 
         (this.QUANTITY != null && this.QUANTITY.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.QUANTITY = value;
      if ( this.changedColumns.get( "QUANTITY" ) == null )  {
         this.changedColumns.put( "QUANTITY", "java.math.BigDecimal" );
         this.setDbColumnChangedFlag("QUANTITY", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateBigDecimal(getDbColumn("QUANTITY").getORDINAL_POSITION(), value);
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
    public java.lang.String getPOSITION_ID( ) {
      return this.POSITION_ID;
   }
   public java.lang.String getACCOUNT_ID( ) {
      return this.ACCOUNT_ID;
   }
   public java.lang.String getBROKER_CODE( ) {
      return this.BROKER_CODE;
   }
   public java.lang.String getSECURITY_SYMBOL( ) {
      return this.SECURITY_SYMBOL;
   }
   public java.lang.String getCUSIP( ) {
      return this.CUSIP;
   }
   public java.lang.String getISIN( ) {
      return this.ISIN;
   }
   public java.lang.String getSEDOL( ) {
      return this.SEDOL;
   }
   public java.lang.String getCURRENCY( ) {
      return this.CURRENCY;
   }
   public java.sql.Timestamp getEXPIRATION_DATE( ) {
      return this.EXPIRATION_DATE;
   }
   public java.math.BigDecimal getEXECUTION_PRICE( ) {
      return this.EXECUTION_PRICE;
   }
   public java.math.BigDecimal getMARKET_PRICE( ) {
      return this.MARKET_PRICE;
   }
   public java.math.BigDecimal getQUANTITY( ) {
      return this.QUANTITY;
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

                     this.POSITION_ID = this.resultSet.getString(1);
            this.ACCOUNT_ID = this.resultSet.getString(2);
            this.BROKER_CODE = this.resultSet.getString(3);
            this.SECURITY_SYMBOL = this.resultSet.getString(4);
            this.CUSIP = this.resultSet.getString(5);
            this.ISIN = this.resultSet.getString(6);
            this.SEDOL = this.resultSet.getString(7);
            this.CURRENCY = this.resultSet.getString(8);
            this.EXPIRATION_DATE = this.resultSet.getTimestamp(9);
            this.EXECUTION_PRICE = this.resultSet.getBigDecimal(10);
            this.MARKET_PRICE = this.resultSet.getBigDecimal(11);
            this.QUANTITY = this.resultSet.getBigDecimal(12);
   
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

                     this.POSITION_ID = this.resultSet.getString(1);
            this.ACCOUNT_ID = this.resultSet.getString(2);
            this.BROKER_CODE = this.resultSet.getString(3);
            this.SECURITY_SYMBOL = this.resultSet.getString(4);
            this.CUSIP = this.resultSet.getString(5);
            this.ISIN = this.resultSet.getString(6);
            this.SEDOL = this.resultSet.getString(7);
            this.CURRENCY = this.resultSet.getString(8);
            this.EXPIRATION_DATE = this.resultSet.getTimestamp(9);
            this.EXECUTION_PRICE = this.resultSet.getBigDecimal(10);
            this.MARKET_PRICE = this.resultSet.getBigDecimal(11);
            this.QUANTITY = this.resultSet.getBigDecimal(12);
   
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

                    this.POSITION_ID = this.resultSet.getString(1);
            this.ACCOUNT_ID = this.resultSet.getString(2);
            this.BROKER_CODE = this.resultSet.getString(3);
            this.SECURITY_SYMBOL = this.resultSet.getString(4);
            this.CUSIP = this.resultSet.getString(5);
            this.ISIN = this.resultSet.getString(6);
            this.SEDOL = this.resultSet.getString(7);
            this.CURRENCY = this.resultSet.getString(8);
            this.EXPIRATION_DATE = this.resultSet.getTimestamp(9);
            this.EXECUTION_PRICE = this.resultSet.getBigDecimal(10);
            this.MARKET_PRICE = this.resultSet.getBigDecimal(11);
            this.QUANTITY = this.resultSet.getBigDecimal(12);
   

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
   public PositionTo getTo() {
      PositionTo positionTo = new PositionTo();

            positionTo.setPOSITION_ID(this.POSITION_ID);
      positionTo.setACCOUNT_ID(this.ACCOUNT_ID);
      positionTo.setBROKER_CODE(this.BROKER_CODE);
      positionTo.setSECURITY_SYMBOL(this.SECURITY_SYMBOL);
      positionTo.setCUSIP(this.CUSIP);
      positionTo.setISIN(this.ISIN);
      positionTo.setSEDOL(this.SEDOL);
      positionTo.setCURRENCY(this.CURRENCY);
      positionTo.setEXPIRATION_DATE(this.EXPIRATION_DATE);
      positionTo.setEXECUTION_PRICE(this.EXECUTION_PRICE);
      positionTo.setMARKET_PRICE(this.MARKET_PRICE);
      positionTo.setQUANTITY(this.QUANTITY);


      return positionTo;
   }

   /*************************************************************************
    *
    * Copies data from Transfer Object PK columns to corresponding columns
    * of database object
    *
    *************************************************************************/
    public void setPkValuesFromTo(PositionTo positionTo) throws GDAOException {

            this.setPOSITION_ID(positionTo.getPOSITION_ID());


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

      String SQL = "DELETE FROM POSITION WHERE ";
      SQL = SQL + "POSITION_ID = ? ";

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
    public ArrayList<PositionTo> getToArrayEntireResultSet() throws GDAOException {
       ArrayList<PositionTo> toArray = new ArrayList<PositionTo>();
       while (next()) {
          PositionTo positionTo = getTo();
          toArray.add(positionTo);
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
   public ArrayList<PositionTo> getToArray(int arraySize) throws GDAOException {
      int i = 0;
      ArrayList <PositionTo> toArray = new ArrayList<PositionTo>();
      try {
         while (i < arraySize) {
            if (!this.resultSet.isLast() && !this.resultSet.isAfterLast() && this.getResultSetRowCount() > 0) {
               next();
               PositionTo positionTo = getTo();
               toArray.add(positionTo);
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
   public ArrayList <PositionTo> getToArray(String what) throws GDAOException {
      ArrayList <PositionTo> toArray = new ArrayList<PositionTo>();
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
   public void setThisFromTo(PositionTo positionTo) throws GDAOException {

            this.setPOSITION_ID(positionTo.getPOSITION_ID());
      this.setACCOUNT_ID(positionTo.getACCOUNT_ID());
      this.setBROKER_CODE(positionTo.getBROKER_CODE());
      this.setSECURITY_SYMBOL(positionTo.getSECURITY_SYMBOL());
      this.setCUSIP(positionTo.getCUSIP());
      this.setISIN(positionTo.getISIN());
      this.setSEDOL(positionTo.getSEDOL());
      this.setCURRENCY(positionTo.getCURRENCY());
      this.setEXPIRATION_DATE(positionTo.getEXPIRATION_DATE());
      this.setEXECUTION_PRICE(positionTo.getEXECUTION_PRICE());
      this.setMARKET_PRICE(positionTo.getMARKET_PRICE());
      this.setQUANTITY(positionTo.getQUANTITY());


      return;
   }

   /*************************************************************************
    *
    * Prints values of This Object
    *
    *************************************************************************/
   public void print(String fieldDelimiter) {
      System.out.println(      this.getPOSITION_ID()
       + fieldDelimiter + this.getACCOUNT_ID()
       + fieldDelimiter + this.getBROKER_CODE()
       + fieldDelimiter + this.getSECURITY_SYMBOL()
       + fieldDelimiter + this.getCUSIP()
       + fieldDelimiter + this.getISIN()
       + fieldDelimiter + this.getSEDOL()
       + fieldDelimiter + this.getCURRENCY()
       + fieldDelimiter + this.getEXPIRATION_DATE()
       + fieldDelimiter + this.getEXECUTION_PRICE()
       + fieldDelimiter + this.getMARKET_PRICE()
       + fieldDelimiter + this.getQUANTITY()
);
      return;
   }

   /*************************************************************************
    *
    * Prints Transfer Object
    *
    *************************************************************************/
   public static void print(PositionTo positionTo, String fieldDelimiter) {
      System.out.println(      positionTo.getPOSITION_ID()
       + fieldDelimiter + positionTo.getACCOUNT_ID()
       + fieldDelimiter + positionTo.getBROKER_CODE()
       + fieldDelimiter + positionTo.getSECURITY_SYMBOL()
       + fieldDelimiter + positionTo.getCUSIP()
       + fieldDelimiter + positionTo.getISIN()
       + fieldDelimiter + positionTo.getSEDOL()
       + fieldDelimiter + positionTo.getCURRENCY()
       + fieldDelimiter + positionTo.getEXPIRATION_DATE()
       + fieldDelimiter + positionTo.getEXECUTION_PRICE()
       + fieldDelimiter + positionTo.getMARKET_PRICE()
       + fieldDelimiter + positionTo.getQUANTITY()
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