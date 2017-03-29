package com.mallocinc.database.generated.base;

import java.sql.*;
import java.io.*;
import com.mallocinc.codegenerator.superclasses.oracle.*;
import java.util.ArrayList;
import java.util.Arrays;

import com.mallocinc.database.generated.to.VExcelTradeTo;
import com.mallocinc.codegenerator.exceptions.*;

/*************************************************************************
 *  <pre>
 *
 *  Generated Class: VExcelTradeBase.java
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
 *  This code is generated on: 2017-February-27 06:45:58 PM CET
 *
 *  Copyright (C) 2015 Malloc Inc.
 *
 *  </pre>
 **************************************************************************/
@SuppressWarnings("unused")
public class VExcelTradeBase extends BaseOracleDbEntityClass <VExcelTradeTo> {

   /**********************************************************************
    *
    *  Database Variables declarations
    *  They represent database columns
    *
    **********************************************************************/
   private java.math.BigDecimal TRADE_ID = null;
private java.math.BigDecimal BANK_ID = null;
private java.lang.String ACCOUNT_ID = null;
private java.lang.String BANK_NAME = null;
private java.lang.String FIRST_NAME = null;
private java.lang.String LAST_NAME = null;
private java.lang.String TRANSACTION_TYPE = null;
private java.lang.String SECURITY_TYPE = null;
private java.math.BigDecimal NET_AMOUNT = null;
private java.lang.String CURRENCY = null;
private java.math.BigDecimal QUANTITY = null;
private java.lang.String EXCHANGE = null;
private java.sql.Timestamp TRADE_DATE = null;


   /**********************************************************
    *
    *  Default Constructor
    *
    ***********************************************************/
   public VExcelTradeBase( ) {

      if (getDbEntityName() == null) {
         setDbEntityName("V_EXCEL_TRADE");
      }

      columnsCommaDelimitedList = " TRADE_ID"
   + ",BANK_ID"
   + ",ACCOUNT_ID"
   + ",BANK_NAME"
   + ",FIRST_NAME"
   + ",LAST_NAME"
   + ",TRANSACTION_TYPE"
   + ",SECURITY_TYPE"
   + ",NET_AMOUNT"
   + ",CURRENCY"
   + ",QUANTITY"
   + ",EXCHANGE"
   + ",TRADE_DATE"
   ;

      setSelectAllSQL();

      setDbEntityType("VIEW");

      OracleDbColumn dbColumn = null;

         dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "TRADE_ID" );
      dbColumn.setORDINAL_POSITION( 1 );
      dbColumn.setTYPE_NAME( "NUMBER" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "BANK_ID" );
      dbColumn.setORDINAL_POSITION( 2 );
      dbColumn.setTYPE_NAME( "NUMBER" );
      dbColumn.setIS_NULLABLE( "YES" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "ACCOUNT_ID" );
      dbColumn.setORDINAL_POSITION( 3 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "YES" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "BANK_NAME" );
      dbColumn.setORDINAL_POSITION( 4 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "YES" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "FIRST_NAME" );
      dbColumn.setORDINAL_POSITION( 5 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "YES" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "LAST_NAME" );
      dbColumn.setORDINAL_POSITION( 6 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "YES" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "TRANSACTION_TYPE" );
      dbColumn.setORDINAL_POSITION( 7 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "SECURITY_TYPE" );
      dbColumn.setORDINAL_POSITION( 8 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "NET_AMOUNT" );
      dbColumn.setORDINAL_POSITION( 9 );
      dbColumn.setTYPE_NAME( "NUMBER" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "CURRENCY" );
      dbColumn.setORDINAL_POSITION( 10 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "QUANTITY" );
      dbColumn.setORDINAL_POSITION( 11 );
      dbColumn.setTYPE_NAME( "NUMBER" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "EXCHANGE" );
      dbColumn.setORDINAL_POSITION( 12 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "TRADE_DATE" );
      dbColumn.setORDINAL_POSITION( 13 );
      dbColumn.setTYPE_NAME( "TIMESTAMP(6)" );
      dbColumn.setIS_NULLABLE( "YES" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);


   }

   /**********************************************************
    *
    *  Constructor
    *
    ***********************************************************/
   public VExcelTradeBase( Connection connection ) {
      this(); //chain default constructor
      this.connection = connection;
   }

   /**********************************************************
    *
    *  Constructor
    *
    ***********************************************************/
   public VExcelTradeBase( String underlyingEntityName ) {
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
    
   public void setTRADE_ID( java.math.BigDecimal value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.TRADE_ID == null && value == null) || 
         (this.TRADE_ID != null && this.TRADE_ID.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.TRADE_ID = value;
      if ( this.changedColumns.get( "TRADE_ID" ) == null )  {
         this.changedColumns.put( "TRADE_ID", "java.math.BigDecimal" );
         this.setDbColumnChangedFlag("TRADE_ID", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateBigDecimal(getDbColumn("TRADE_ID").getORDINAL_POSITION(), value);
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

   public void setTRANSACTION_TYPE( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.TRANSACTION_TYPE == null && value == null) || 
         (this.TRANSACTION_TYPE != null && this.TRANSACTION_TYPE.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.TRANSACTION_TYPE = value;
      if ( this.changedColumns.get( "TRANSACTION_TYPE" ) == null )  {
         this.changedColumns.put( "TRANSACTION_TYPE", "java.lang.String" );
         this.setDbColumnChangedFlag("TRANSACTION_TYPE", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("TRANSACTION_TYPE").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setSECURITY_TYPE( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.SECURITY_TYPE == null && value == null) || 
         (this.SECURITY_TYPE != null && this.SECURITY_TYPE.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.SECURITY_TYPE = value;
      if ( this.changedColumns.get( "SECURITY_TYPE" ) == null )  {
         this.changedColumns.put( "SECURITY_TYPE", "java.lang.String" );
         this.setDbColumnChangedFlag("SECURITY_TYPE", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("SECURITY_TYPE").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setNET_AMOUNT( java.math.BigDecimal value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.NET_AMOUNT == null && value == null) || 
         (this.NET_AMOUNT != null && this.NET_AMOUNT.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.NET_AMOUNT = value;
      if ( this.changedColumns.get( "NET_AMOUNT" ) == null )  {
         this.changedColumns.put( "NET_AMOUNT", "java.math.BigDecimal" );
         this.setDbColumnChangedFlag("NET_AMOUNT", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateBigDecimal(getDbColumn("NET_AMOUNT").getORDINAL_POSITION(), value);
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

   public void setEXCHANGE( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.EXCHANGE == null && value == null) || 
         (this.EXCHANGE != null && this.EXCHANGE.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.EXCHANGE = value;
      if ( this.changedColumns.get( "EXCHANGE" ) == null )  {
         this.changedColumns.put( "EXCHANGE", "java.lang.String" );
         this.setDbColumnChangedFlag("EXCHANGE", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("EXCHANGE").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setTRADE_DATE( java.sql.Timestamp value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.TRADE_DATE == null && value == null) || 
         (this.TRADE_DATE != null && this.TRADE_DATE.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.TRADE_DATE = value;
      if ( this.changedColumns.get( "TRADE_DATE" ) == null )  {
         this.changedColumns.put( "TRADE_DATE", "java.sql.Timestamp" );
         this.setDbColumnChangedFlag("TRADE_DATE", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateTimestamp(getDbColumn("TRADE_DATE").getORDINAL_POSITION(), value);
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
    public java.math.BigDecimal getTRADE_ID( ) {
      return this.TRADE_ID;
   }
   public java.math.BigDecimal getBANK_ID( ) {
      return this.BANK_ID;
   }
   public java.lang.String getACCOUNT_ID( ) {
      return this.ACCOUNT_ID;
   }
   public java.lang.String getBANK_NAME( ) {
      return this.BANK_NAME;
   }
   public java.lang.String getFIRST_NAME( ) {
      return this.FIRST_NAME;
   }
   public java.lang.String getLAST_NAME( ) {
      return this.LAST_NAME;
   }
   public java.lang.String getTRANSACTION_TYPE( ) {
      return this.TRANSACTION_TYPE;
   }
   public java.lang.String getSECURITY_TYPE( ) {
      return this.SECURITY_TYPE;
   }
   public java.math.BigDecimal getNET_AMOUNT( ) {
      return this.NET_AMOUNT;
   }
   public java.lang.String getCURRENCY( ) {
      return this.CURRENCY;
   }
   public java.math.BigDecimal getQUANTITY( ) {
      return this.QUANTITY;
   }
   public java.lang.String getEXCHANGE( ) {
      return this.EXCHANGE;
   }
   public java.sql.Timestamp getTRADE_DATE( ) {
      return this.TRADE_DATE;
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

                     this.TRADE_ID = this.resultSet.getBigDecimal(1);
            this.BANK_ID = this.resultSet.getBigDecimal(2);
            this.ACCOUNT_ID = this.resultSet.getString(3);
            this.BANK_NAME = this.resultSet.getString(4);
            this.FIRST_NAME = this.resultSet.getString(5);
            this.LAST_NAME = this.resultSet.getString(6);
            this.TRANSACTION_TYPE = this.resultSet.getString(7);
            this.SECURITY_TYPE = this.resultSet.getString(8);
            this.NET_AMOUNT = this.resultSet.getBigDecimal(9);
            this.CURRENCY = this.resultSet.getString(10);
            this.QUANTITY = this.resultSet.getBigDecimal(11);
            this.EXCHANGE = this.resultSet.getString(12);
            this.TRADE_DATE = this.resultSet.getTimestamp(13);
   
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

                     this.TRADE_ID = this.resultSet.getBigDecimal(1);
            this.BANK_ID = this.resultSet.getBigDecimal(2);
            this.ACCOUNT_ID = this.resultSet.getString(3);
            this.BANK_NAME = this.resultSet.getString(4);
            this.FIRST_NAME = this.resultSet.getString(5);
            this.LAST_NAME = this.resultSet.getString(6);
            this.TRANSACTION_TYPE = this.resultSet.getString(7);
            this.SECURITY_TYPE = this.resultSet.getString(8);
            this.NET_AMOUNT = this.resultSet.getBigDecimal(9);
            this.CURRENCY = this.resultSet.getString(10);
            this.QUANTITY = this.resultSet.getBigDecimal(11);
            this.EXCHANGE = this.resultSet.getString(12);
            this.TRADE_DATE = this.resultSet.getTimestamp(13);
   
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

                    this.TRADE_ID = this.resultSet.getBigDecimal(1);
            this.BANK_ID = this.resultSet.getBigDecimal(2);
            this.ACCOUNT_ID = this.resultSet.getString(3);
            this.BANK_NAME = this.resultSet.getString(4);
            this.FIRST_NAME = this.resultSet.getString(5);
            this.LAST_NAME = this.resultSet.getString(6);
            this.TRANSACTION_TYPE = this.resultSet.getString(7);
            this.SECURITY_TYPE = this.resultSet.getString(8);
            this.NET_AMOUNT = this.resultSet.getBigDecimal(9);
            this.CURRENCY = this.resultSet.getString(10);
            this.QUANTITY = this.resultSet.getBigDecimal(11);
            this.EXCHANGE = this.resultSet.getString(12);
            this.TRADE_DATE = this.resultSet.getTimestamp(13);
   

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
   public VExcelTradeTo getTo() {
      VExcelTradeTo vExcelTradeTo = new VExcelTradeTo();

            vExcelTradeTo.setTRADE_ID(this.TRADE_ID);
      vExcelTradeTo.setBANK_ID(this.BANK_ID);
      vExcelTradeTo.setACCOUNT_ID(this.ACCOUNT_ID);
      vExcelTradeTo.setBANK_NAME(this.BANK_NAME);
      vExcelTradeTo.setFIRST_NAME(this.FIRST_NAME);
      vExcelTradeTo.setLAST_NAME(this.LAST_NAME);
      vExcelTradeTo.setTRANSACTION_TYPE(this.TRANSACTION_TYPE);
      vExcelTradeTo.setSECURITY_TYPE(this.SECURITY_TYPE);
      vExcelTradeTo.setNET_AMOUNT(this.NET_AMOUNT);
      vExcelTradeTo.setCURRENCY(this.CURRENCY);
      vExcelTradeTo.setQUANTITY(this.QUANTITY);
      vExcelTradeTo.setEXCHANGE(this.EXCHANGE);
      vExcelTradeTo.setTRADE_DATE(this.TRADE_DATE);


      return vExcelTradeTo;
   }

   /*************************************************************************
    *
    * Copies data from Transfer Object PK columns to corresponding columns
    * of database object
    *
    *************************************************************************/
    public void setPkValuesFromTo(VExcelTradeTo vExcelTradeTo) throws GDAOException {

      

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

      String SQL = "DELETE FROM V_EXCEL_TRADE WHERE ";
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
    public ArrayList<VExcelTradeTo> getToArrayEntireResultSet() throws GDAOException {
       ArrayList<VExcelTradeTo> toArray = new ArrayList<VExcelTradeTo>();
       while (next()) {
          VExcelTradeTo vExcelTradeTo = getTo();
          toArray.add(vExcelTradeTo);
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
   public ArrayList<VExcelTradeTo> getToArray(int arraySize) throws GDAOException {
      int i = 0;
      ArrayList <VExcelTradeTo> toArray = new ArrayList<VExcelTradeTo>();
      try {
         while (i < arraySize) {
            if (!this.resultSet.isLast() && !this.resultSet.isAfterLast() && this.getResultSetRowCount() > 0) {
               next();
               VExcelTradeTo vExcelTradeTo = getTo();
               toArray.add(vExcelTradeTo);
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
   public ArrayList <VExcelTradeTo> getToArray(String what) throws GDAOException {
      ArrayList <VExcelTradeTo> toArray = new ArrayList<VExcelTradeTo>();
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
   public void setThisFromTo(VExcelTradeTo vExcelTradeTo) throws GDAOException {

            this.setTRADE_ID(vExcelTradeTo.getTRADE_ID());
      this.setBANK_ID(vExcelTradeTo.getBANK_ID());
      this.setACCOUNT_ID(vExcelTradeTo.getACCOUNT_ID());
      this.setBANK_NAME(vExcelTradeTo.getBANK_NAME());
      this.setFIRST_NAME(vExcelTradeTo.getFIRST_NAME());
      this.setLAST_NAME(vExcelTradeTo.getLAST_NAME());
      this.setTRANSACTION_TYPE(vExcelTradeTo.getTRANSACTION_TYPE());
      this.setSECURITY_TYPE(vExcelTradeTo.getSECURITY_TYPE());
      this.setNET_AMOUNT(vExcelTradeTo.getNET_AMOUNT());
      this.setCURRENCY(vExcelTradeTo.getCURRENCY());
      this.setQUANTITY(vExcelTradeTo.getQUANTITY());
      this.setEXCHANGE(vExcelTradeTo.getEXCHANGE());
      this.setTRADE_DATE(vExcelTradeTo.getTRADE_DATE());


      return;
   }

   /*************************************************************************
    *
    * Prints values of This Object
    *
    *************************************************************************/
   public void print(String fieldDelimiter) {
      System.out.println(      this.getTRADE_ID()
       + fieldDelimiter + this.getBANK_ID()
       + fieldDelimiter + this.getACCOUNT_ID()
       + fieldDelimiter + this.getBANK_NAME()
       + fieldDelimiter + this.getFIRST_NAME()
       + fieldDelimiter + this.getLAST_NAME()
       + fieldDelimiter + this.getTRANSACTION_TYPE()
       + fieldDelimiter + this.getSECURITY_TYPE()
       + fieldDelimiter + this.getNET_AMOUNT()
       + fieldDelimiter + this.getCURRENCY()
       + fieldDelimiter + this.getQUANTITY()
       + fieldDelimiter + this.getEXCHANGE()
       + fieldDelimiter + this.getTRADE_DATE()
);
      return;
   }

   /*************************************************************************
    *
    * Prints Transfer Object
    *
    *************************************************************************/
   public static void print(VExcelTradeTo vExcelTradeTo, String fieldDelimiter) {
      System.out.println(      vExcelTradeTo.getTRADE_ID()
       + fieldDelimiter + vExcelTradeTo.getBANK_ID()
       + fieldDelimiter + vExcelTradeTo.getACCOUNT_ID()
       + fieldDelimiter + vExcelTradeTo.getBANK_NAME()
       + fieldDelimiter + vExcelTradeTo.getFIRST_NAME()
       + fieldDelimiter + vExcelTradeTo.getLAST_NAME()
       + fieldDelimiter + vExcelTradeTo.getTRANSACTION_TYPE()
       + fieldDelimiter + vExcelTradeTo.getSECURITY_TYPE()
       + fieldDelimiter + vExcelTradeTo.getNET_AMOUNT()
       + fieldDelimiter + vExcelTradeTo.getCURRENCY()
       + fieldDelimiter + vExcelTradeTo.getQUANTITY()
       + fieldDelimiter + vExcelTradeTo.getEXCHANGE()
       + fieldDelimiter + vExcelTradeTo.getTRADE_DATE()
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