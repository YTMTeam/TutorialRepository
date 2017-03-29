package com.mallocinc.database.generated.base;

import java.sql.*;
import java.io.*;
import com.mallocinc.codegenerator.superclasses.oracle.*;
import java.util.ArrayList;
import java.util.Arrays;

import com.mallocinc.database.generated.to.TradeTo;
import com.mallocinc.codegenerator.exceptions.*;

/*************************************************************************
 *  <pre>
 *
 *  Generated Class: TradeBase.java
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
 *  This code is generated on: 2017-February-28 02:45:09 PM CET
 *
 *  Copyright (C) 2015 Malloc Inc.
 *
 *  </pre>
 **************************************************************************/
@SuppressWarnings("unused")
public class TradeBase extends BaseOracleDbEntityClass <TradeTo> {

   /**********************************************************************
    *
    *  Database Variables declarations
    *  They represent database columns
    *
    **********************************************************************/
   private java.lang.String TRADE_ID = null;
private java.math.BigDecimal TRANSACTION_ID = null;
private java.lang.String TRANSACTION_TYPE = null;
private java.lang.String ACCOUNT_ID = null;
private java.math.BigDecimal BANK_ID = null;
private java.math.BigDecimal QUANTITY = null;
private java.lang.String SECURITY_SYMBOL = null;
private java.lang.String CURRENCY = null;
private java.lang.String SECURITY_TYPE = null;
private java.lang.String SECURITY_NAME = null;
private java.math.BigDecimal EXECUTION_PRICE = null;
private java.math.BigDecimal NET_AMOUNT = null;
private java.lang.String EXCHANGE = null;
private java.lang.String CUSIP = null;
private java.lang.String ISIN = null;
private java.lang.String SEDOL = null;
private java.sql.Timestamp TRADE_DATE = null;
private java.sql.Timestamp CREATE_TIMESTAMP = null;


   /**********************************************************
    *
    *  Default Constructor
    *
    ***********************************************************/
   public TradeBase( ) {

      if (getDbEntityName() == null) {
         setDbEntityName("TRADE");
      }

      columnsCommaDelimitedList = " TRADE_ID"
   + ",TRANSACTION_ID"
   + ",TRANSACTION_TYPE"
   + ",ACCOUNT_ID"
   + ",BANK_ID"
   + ",QUANTITY"
   + ",SECURITY_SYMBOL"
   + ",CURRENCY"
   + ",SECURITY_TYPE"
   + ",SECURITY_NAME"
   + ",EXECUTION_PRICE"
   + ",NET_AMOUNT"
   + ",EXCHANGE"
   + ",CUSIP"
   + ",ISIN"
   + ",SEDOL"
   + ",TRADE_DATE"
   + ",CREATE_TIMESTAMP"
   ;

      setSelectAllSQL();

      setDbEntityType("TABLE");

      OracleDbColumn dbColumn = null;

         dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "TRADE_ID" );
      dbColumn.setORDINAL_POSITION( 1 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      dbColumn.setPrimaryKey( true );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "TRANSACTION_ID" );
      dbColumn.setORDINAL_POSITION( 2 );
      dbColumn.setTYPE_NAME( "NUMBER" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "TRANSACTION_TYPE" );
      dbColumn.setORDINAL_POSITION( 3 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "ACCOUNT_ID" );
      dbColumn.setORDINAL_POSITION( 4 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "BANK_ID" );
      dbColumn.setORDINAL_POSITION( 5 );
      dbColumn.setTYPE_NAME( "NUMBER" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "QUANTITY" );
      dbColumn.setORDINAL_POSITION( 6 );
      dbColumn.setTYPE_NAME( "NUMBER" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "SECURITY_SYMBOL" );
      dbColumn.setORDINAL_POSITION( 7 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
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
      dbColumn.setCOLUMN_NAME( "SECURITY_TYPE" );
      dbColumn.setORDINAL_POSITION( 9 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "SECURITY_NAME" );
      dbColumn.setORDINAL_POSITION( 10 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "EXECUTION_PRICE" );
      dbColumn.setORDINAL_POSITION( 11 );
      dbColumn.setTYPE_NAME( "NUMBER" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "NET_AMOUNT" );
      dbColumn.setORDINAL_POSITION( 12 );
      dbColumn.setTYPE_NAME( "NUMBER" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "EXCHANGE" );
      dbColumn.setORDINAL_POSITION( 13 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "CUSIP" );
      dbColumn.setORDINAL_POSITION( 14 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "ISIN" );
      dbColumn.setORDINAL_POSITION( 15 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "YES" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "SEDOL" );
      dbColumn.setORDINAL_POSITION( 16 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "YES" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "TRADE_DATE" );
      dbColumn.setORDINAL_POSITION( 17 );
      dbColumn.setTYPE_NAME( "TIMESTAMP(6)" );
      dbColumn.setIS_NULLABLE( "YES" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "CREATE_TIMESTAMP" );
      dbColumn.setORDINAL_POSITION( 18 );
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
   public TradeBase( Connection connection ) {
      this(); //chain default constructor
      this.connection = connection;
   }

   /**********************************************************
    *
    *  Constructor
    *
    ***********************************************************/
   public TradeBase( String underlyingEntityName ) {
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
    
   public void setTRADE_ID( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.TRADE_ID == null && value == null) || 
         (this.TRADE_ID != null && this.TRADE_ID.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.TRADE_ID = value;
      if ( this.changedColumns.get( "TRADE_ID" ) == null )  {
         this.changedColumns.put( "TRADE_ID", "java.lang.String" );
         this.setDbColumnChangedFlag("TRADE_ID", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("TRADE_ID").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setTRANSACTION_ID( java.math.BigDecimal value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.TRANSACTION_ID == null && value == null) || 
         (this.TRANSACTION_ID != null && this.TRANSACTION_ID.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.TRANSACTION_ID = value;
      if ( this.changedColumns.get( "TRANSACTION_ID" ) == null )  {
         this.changedColumns.put( "TRANSACTION_ID", "java.math.BigDecimal" );
         this.setDbColumnChangedFlag("TRANSACTION_ID", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateBigDecimal(getDbColumn("TRANSACTION_ID").getORDINAL_POSITION(), value);
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

   public void setSECURITY_NAME( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.SECURITY_NAME == null && value == null) || 
         (this.SECURITY_NAME != null && this.SECURITY_NAME.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.SECURITY_NAME = value;
      if ( this.changedColumns.get( "SECURITY_NAME" ) == null )  {
         this.changedColumns.put( "SECURITY_NAME", "java.lang.String" );
         this.setDbColumnChangedFlag("SECURITY_NAME", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("SECURITY_NAME").getORDINAL_POSITION(), value);
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
    public java.lang.String getTRADE_ID( ) {
      return this.TRADE_ID;
   }
   public java.math.BigDecimal getTRANSACTION_ID( ) {
      return this.TRANSACTION_ID;
   }
   public java.lang.String getTRANSACTION_TYPE( ) {
      return this.TRANSACTION_TYPE;
   }
   public java.lang.String getACCOUNT_ID( ) {
      return this.ACCOUNT_ID;
   }
   public java.math.BigDecimal getBANK_ID( ) {
      return this.BANK_ID;
   }
   public java.math.BigDecimal getQUANTITY( ) {
      return this.QUANTITY;
   }
   public java.lang.String getSECURITY_SYMBOL( ) {
      return this.SECURITY_SYMBOL;
   }
   public java.lang.String getCURRENCY( ) {
      return this.CURRENCY;
   }
   public java.lang.String getSECURITY_TYPE( ) {
      return this.SECURITY_TYPE;
   }
   public java.lang.String getSECURITY_NAME( ) {
      return this.SECURITY_NAME;
   }
   public java.math.BigDecimal getEXECUTION_PRICE( ) {
      return this.EXECUTION_PRICE;
   }
   public java.math.BigDecimal getNET_AMOUNT( ) {
      return this.NET_AMOUNT;
   }
   public java.lang.String getEXCHANGE( ) {
      return this.EXCHANGE;
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
   public java.sql.Timestamp getTRADE_DATE( ) {
      return this.TRADE_DATE;
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

                     this.TRADE_ID = this.resultSet.getString(1);
            this.TRANSACTION_ID = this.resultSet.getBigDecimal(2);
            this.TRANSACTION_TYPE = this.resultSet.getString(3);
            this.ACCOUNT_ID = this.resultSet.getString(4);
            this.BANK_ID = this.resultSet.getBigDecimal(5);
            this.QUANTITY = this.resultSet.getBigDecimal(6);
            this.SECURITY_SYMBOL = this.resultSet.getString(7);
            this.CURRENCY = this.resultSet.getString(8);
            this.SECURITY_TYPE = this.resultSet.getString(9);
            this.SECURITY_NAME = this.resultSet.getString(10);
            this.EXECUTION_PRICE = this.resultSet.getBigDecimal(11);
            this.NET_AMOUNT = this.resultSet.getBigDecimal(12);
            this.EXCHANGE = this.resultSet.getString(13);
            this.CUSIP = this.resultSet.getString(14);
            this.ISIN = this.resultSet.getString(15);
            this.SEDOL = this.resultSet.getString(16);
            this.TRADE_DATE = this.resultSet.getTimestamp(17);
            this.CREATE_TIMESTAMP = this.resultSet.getTimestamp(18);
   
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

                     this.TRADE_ID = this.resultSet.getString(1);
            this.TRANSACTION_ID = this.resultSet.getBigDecimal(2);
            this.TRANSACTION_TYPE = this.resultSet.getString(3);
            this.ACCOUNT_ID = this.resultSet.getString(4);
            this.BANK_ID = this.resultSet.getBigDecimal(5);
            this.QUANTITY = this.resultSet.getBigDecimal(6);
            this.SECURITY_SYMBOL = this.resultSet.getString(7);
            this.CURRENCY = this.resultSet.getString(8);
            this.SECURITY_TYPE = this.resultSet.getString(9);
            this.SECURITY_NAME = this.resultSet.getString(10);
            this.EXECUTION_PRICE = this.resultSet.getBigDecimal(11);
            this.NET_AMOUNT = this.resultSet.getBigDecimal(12);
            this.EXCHANGE = this.resultSet.getString(13);
            this.CUSIP = this.resultSet.getString(14);
            this.ISIN = this.resultSet.getString(15);
            this.SEDOL = this.resultSet.getString(16);
            this.TRADE_DATE = this.resultSet.getTimestamp(17);
            this.CREATE_TIMESTAMP = this.resultSet.getTimestamp(18);
   
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

                    this.TRADE_ID = this.resultSet.getString(1);
            this.TRANSACTION_ID = this.resultSet.getBigDecimal(2);
            this.TRANSACTION_TYPE = this.resultSet.getString(3);
            this.ACCOUNT_ID = this.resultSet.getString(4);
            this.BANK_ID = this.resultSet.getBigDecimal(5);
            this.QUANTITY = this.resultSet.getBigDecimal(6);
            this.SECURITY_SYMBOL = this.resultSet.getString(7);
            this.CURRENCY = this.resultSet.getString(8);
            this.SECURITY_TYPE = this.resultSet.getString(9);
            this.SECURITY_NAME = this.resultSet.getString(10);
            this.EXECUTION_PRICE = this.resultSet.getBigDecimal(11);
            this.NET_AMOUNT = this.resultSet.getBigDecimal(12);
            this.EXCHANGE = this.resultSet.getString(13);
            this.CUSIP = this.resultSet.getString(14);
            this.ISIN = this.resultSet.getString(15);
            this.SEDOL = this.resultSet.getString(16);
            this.TRADE_DATE = this.resultSet.getTimestamp(17);
            this.CREATE_TIMESTAMP = this.resultSet.getTimestamp(18);
   

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
   public TradeTo getTo() {
      TradeTo tradeTo = new TradeTo();

            tradeTo.setTRADE_ID(this.TRADE_ID);
      tradeTo.setTRANSACTION_ID(this.TRANSACTION_ID);
      tradeTo.setTRANSACTION_TYPE(this.TRANSACTION_TYPE);
      tradeTo.setACCOUNT_ID(this.ACCOUNT_ID);
      tradeTo.setBANK_ID(this.BANK_ID);
      tradeTo.setQUANTITY(this.QUANTITY);
      tradeTo.setSECURITY_SYMBOL(this.SECURITY_SYMBOL);
      tradeTo.setCURRENCY(this.CURRENCY);
      tradeTo.setSECURITY_TYPE(this.SECURITY_TYPE);
      tradeTo.setSECURITY_NAME(this.SECURITY_NAME);
      tradeTo.setEXECUTION_PRICE(this.EXECUTION_PRICE);
      tradeTo.setNET_AMOUNT(this.NET_AMOUNT);
      tradeTo.setEXCHANGE(this.EXCHANGE);
      tradeTo.setCUSIP(this.CUSIP);
      tradeTo.setISIN(this.ISIN);
      tradeTo.setSEDOL(this.SEDOL);
      tradeTo.setTRADE_DATE(this.TRADE_DATE);
      tradeTo.setCREATE_TIMESTAMP(this.CREATE_TIMESTAMP);


      return tradeTo;
   }

   /*************************************************************************
    *
    * Copies data from Transfer Object PK columns to corresponding columns
    * of database object
    *
    *************************************************************************/
    public void setPkValuesFromTo(TradeTo tradeTo) throws GDAOException {

            this.setTRADE_ID(tradeTo.getTRADE_ID());


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

      String SQL = "DELETE FROM TRADE WHERE ";
      SQL = SQL + "TRADE_ID = ? ";

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
    public ArrayList<TradeTo> getToArrayEntireResultSet() throws GDAOException {
       ArrayList<TradeTo> toArray = new ArrayList<TradeTo>();
       while (next()) {
          TradeTo tradeTo = getTo();
          toArray.add(tradeTo);
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
   public ArrayList<TradeTo> getToArray(int arraySize) throws GDAOException {
      int i = 0;
      ArrayList <TradeTo> toArray = new ArrayList<TradeTo>();
      try {
         while (i < arraySize) {
            if (!this.resultSet.isLast() && !this.resultSet.isAfterLast() && this.getResultSetRowCount() > 0) {
               next();
               TradeTo tradeTo = getTo();
               toArray.add(tradeTo);
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
   public ArrayList <TradeTo> getToArray(String what) throws GDAOException {
      ArrayList <TradeTo> toArray = new ArrayList<TradeTo>();
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
   public void setThisFromTo(TradeTo tradeTo) throws GDAOException {

            this.setTRADE_ID(tradeTo.getTRADE_ID());
      this.setTRANSACTION_ID(tradeTo.getTRANSACTION_ID());
      this.setTRANSACTION_TYPE(tradeTo.getTRANSACTION_TYPE());
      this.setACCOUNT_ID(tradeTo.getACCOUNT_ID());
      this.setBANK_ID(tradeTo.getBANK_ID());
      this.setQUANTITY(tradeTo.getQUANTITY());
      this.setSECURITY_SYMBOL(tradeTo.getSECURITY_SYMBOL());
      this.setCURRENCY(tradeTo.getCURRENCY());
      this.setSECURITY_TYPE(tradeTo.getSECURITY_TYPE());
      this.setSECURITY_NAME(tradeTo.getSECURITY_NAME());
      this.setEXECUTION_PRICE(tradeTo.getEXECUTION_PRICE());
      this.setNET_AMOUNT(tradeTo.getNET_AMOUNT());
      this.setEXCHANGE(tradeTo.getEXCHANGE());
      this.setCUSIP(tradeTo.getCUSIP());
      this.setISIN(tradeTo.getISIN());
      this.setSEDOL(tradeTo.getSEDOL());
      this.setTRADE_DATE(tradeTo.getTRADE_DATE());
      this.setCREATE_TIMESTAMP(tradeTo.getCREATE_TIMESTAMP());


      return;
   }

   /*************************************************************************
    *
    * Prints values of This Object
    *
    *************************************************************************/
   public void print(String fieldDelimiter) {
      System.out.println(      this.getTRADE_ID()
       + fieldDelimiter + this.getTRANSACTION_ID()
       + fieldDelimiter + this.getTRANSACTION_TYPE()
       + fieldDelimiter + this.getACCOUNT_ID()
       + fieldDelimiter + this.getBANK_ID()
       + fieldDelimiter + this.getQUANTITY()
       + fieldDelimiter + this.getSECURITY_SYMBOL()
       + fieldDelimiter + this.getCURRENCY()
       + fieldDelimiter + this.getSECURITY_TYPE()
       + fieldDelimiter + this.getSECURITY_NAME()
       + fieldDelimiter + this.getEXECUTION_PRICE()
       + fieldDelimiter + this.getNET_AMOUNT()
       + fieldDelimiter + this.getEXCHANGE()
       + fieldDelimiter + this.getCUSIP()
       + fieldDelimiter + this.getISIN()
       + fieldDelimiter + this.getSEDOL()
       + fieldDelimiter + this.getTRADE_DATE()
       + fieldDelimiter + this.getCREATE_TIMESTAMP()
);
      return;
   }

   /*************************************************************************
    *
    * Prints Transfer Object
    *
    *************************************************************************/
   public static void print(TradeTo tradeTo, String fieldDelimiter) {
      System.out.println(      tradeTo.getTRADE_ID()
       + fieldDelimiter + tradeTo.getTRANSACTION_ID()
       + fieldDelimiter + tradeTo.getTRANSACTION_TYPE()
       + fieldDelimiter + tradeTo.getACCOUNT_ID()
       + fieldDelimiter + tradeTo.getBANK_ID()
       + fieldDelimiter + tradeTo.getQUANTITY()
       + fieldDelimiter + tradeTo.getSECURITY_SYMBOL()
       + fieldDelimiter + tradeTo.getCURRENCY()
       + fieldDelimiter + tradeTo.getSECURITY_TYPE()
       + fieldDelimiter + tradeTo.getSECURITY_NAME()
       + fieldDelimiter + tradeTo.getEXECUTION_PRICE()
       + fieldDelimiter + tradeTo.getNET_AMOUNT()
       + fieldDelimiter + tradeTo.getEXCHANGE()
       + fieldDelimiter + tradeTo.getCUSIP()
       + fieldDelimiter + tradeTo.getISIN()
       + fieldDelimiter + tradeTo.getSEDOL()
       + fieldDelimiter + tradeTo.getTRADE_DATE()
       + fieldDelimiter + tradeTo.getCREATE_TIMESTAMP()
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