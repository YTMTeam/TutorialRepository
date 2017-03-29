package com.mallocinc.database.generated.base;

import java.sql.*;
import java.io.*;
import com.mallocinc.codegenerator.superclasses.oracle.*;
import java.util.ArrayList;
import java.util.Arrays;

import com.mallocinc.database.generated.to.BlockTo;
import com.mallocinc.codegenerator.exceptions.*;

/*************************************************************************
 *  <pre>
 *
 *  Generated Class: BlockBase.java
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
public class BlockBase extends BaseOracleDbEntityClass <BlockTo> {

   /**********************************************************************
    *
    *  Database Variables declarations
    *  They represent database columns
    *
    **********************************************************************/
   private java.math.BigDecimal BLOCK_ID = null;
private java.lang.String MINER = null;
private java.math.BigDecimal NONCE = null;
private java.math.BigDecimal DIFFICULTY = null;
private java.lang.String CHAINWORK = null;
private java.math.BigDecimal CONFIRMATIONS = null;
private java.math.BigDecimal VERSION = null;
private java.lang.String BITS = null;
private java.lang.String MERKLEROOT = null;
private java.math.BigDecimal TIME = null;
private java.lang.String BLOCK_HASH = null;
private java.lang.String PREVIOUS_BLOCK_HASH = null;
private java.lang.String NEXT_BLOCK_HASH = null;
private java.math.BigDecimal HEIGHT = null;
private java.math.BigDecimal BLOCK_SIZE = null;
private java.sql.Timestamp CREATE_TIMESTAMP = null;


   /**********************************************************
    *
    *  Default Constructor
    *
    ***********************************************************/
   public BlockBase( ) {

      if (getDbEntityName() == null) {
         setDbEntityName("BLOCK");
      }

      columnsCommaDelimitedList = " BLOCK_ID"
   + ",MINER"
   + ",NONCE"
   + ",DIFFICULTY"
   + ",CHAINWORK"
   + ",CONFIRMATIONS"
   + ",VERSION"
   + ",BITS"
   + ",MERKLEROOT"
   + ",TIME"
   + ",BLOCK_HASH"
   + ",PREVIOUS_BLOCK_HASH"
   + ",NEXT_BLOCK_HASH"
   + ",HEIGHT"
   + ",BLOCK_SIZE"
   + ",CREATE_TIMESTAMP"
   ;

      setSelectAllSQL();

      setDbEntityType("TABLE");

      OracleDbColumn dbColumn = null;

         dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "BLOCK_ID" );
      dbColumn.setORDINAL_POSITION( 1 );
      dbColumn.setTYPE_NAME( "NUMBER" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      dbColumn.setPrimaryKey( true );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "MINER" );
      dbColumn.setORDINAL_POSITION( 2 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "YES" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "NONCE" );
      dbColumn.setORDINAL_POSITION( 3 );
      dbColumn.setTYPE_NAME( "NUMBER" );
      dbColumn.setIS_NULLABLE( "YES" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "DIFFICULTY" );
      dbColumn.setORDINAL_POSITION( 4 );
      dbColumn.setTYPE_NAME( "NUMBER" );
      dbColumn.setIS_NULLABLE( "YES" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "CHAINWORK" );
      dbColumn.setORDINAL_POSITION( 5 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "YES" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "CONFIRMATIONS" );
      dbColumn.setORDINAL_POSITION( 6 );
      dbColumn.setTYPE_NAME( "NUMBER" );
      dbColumn.setIS_NULLABLE( "YES" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "VERSION" );
      dbColumn.setORDINAL_POSITION( 7 );
      dbColumn.setTYPE_NAME( "NUMBER" );
      dbColumn.setIS_NULLABLE( "YES" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "BITS" );
      dbColumn.setORDINAL_POSITION( 8 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "YES" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "MERKLEROOT" );
      dbColumn.setORDINAL_POSITION( 9 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "YES" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "TIME" );
      dbColumn.setORDINAL_POSITION( 10 );
      dbColumn.setTYPE_NAME( "NUMBER" );
      dbColumn.setIS_NULLABLE( "YES" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "BLOCK_HASH" );
      dbColumn.setORDINAL_POSITION( 11 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "YES" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "PREVIOUS_BLOCK_HASH" );
      dbColumn.setORDINAL_POSITION( 12 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "YES" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "NEXT_BLOCK_HASH" );
      dbColumn.setORDINAL_POSITION( 13 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "YES" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "HEIGHT" );
      dbColumn.setORDINAL_POSITION( 14 );
      dbColumn.setTYPE_NAME( "NUMBER" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "BLOCK_SIZE" );
      dbColumn.setORDINAL_POSITION( 15 );
      dbColumn.setTYPE_NAME( "NUMBER" );
      dbColumn.setIS_NULLABLE( "YES" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "CREATE_TIMESTAMP" );
      dbColumn.setORDINAL_POSITION( 16 );
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
   public BlockBase( Connection connection ) {
      this(); //chain default constructor
      this.connection = connection;
   }

   /**********************************************************
    *
    *  Constructor
    *
    ***********************************************************/
   public BlockBase( String underlyingEntityName ) {
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
    
   public void setBLOCK_ID( java.math.BigDecimal value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.BLOCK_ID == null && value == null) || 
         (this.BLOCK_ID != null && this.BLOCK_ID.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.BLOCK_ID = value;
      if ( this.changedColumns.get( "BLOCK_ID" ) == null )  {
         this.changedColumns.put( "BLOCK_ID", "java.math.BigDecimal" );
         this.setDbColumnChangedFlag("BLOCK_ID", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateBigDecimal(getDbColumn("BLOCK_ID").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setMINER( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.MINER == null && value == null) || 
         (this.MINER != null && this.MINER.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.MINER = value;
      if ( this.changedColumns.get( "MINER" ) == null )  {
         this.changedColumns.put( "MINER", "java.lang.String" );
         this.setDbColumnChangedFlag("MINER", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("MINER").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setNONCE( java.math.BigDecimal value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.NONCE == null && value == null) || 
         (this.NONCE != null && this.NONCE.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.NONCE = value;
      if ( this.changedColumns.get( "NONCE" ) == null )  {
         this.changedColumns.put( "NONCE", "java.math.BigDecimal" );
         this.setDbColumnChangedFlag("NONCE", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateBigDecimal(getDbColumn("NONCE").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setDIFFICULTY( java.math.BigDecimal value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.DIFFICULTY == null && value == null) || 
         (this.DIFFICULTY != null && this.DIFFICULTY.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.DIFFICULTY = value;
      if ( this.changedColumns.get( "DIFFICULTY" ) == null )  {
         this.changedColumns.put( "DIFFICULTY", "java.math.BigDecimal" );
         this.setDbColumnChangedFlag("DIFFICULTY", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateBigDecimal(getDbColumn("DIFFICULTY").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setCHAINWORK( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.CHAINWORK == null && value == null) || 
         (this.CHAINWORK != null && this.CHAINWORK.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.CHAINWORK = value;
      if ( this.changedColumns.get( "CHAINWORK" ) == null )  {
         this.changedColumns.put( "CHAINWORK", "java.lang.String" );
         this.setDbColumnChangedFlag("CHAINWORK", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("CHAINWORK").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setCONFIRMATIONS( java.math.BigDecimal value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.CONFIRMATIONS == null && value == null) || 
         (this.CONFIRMATIONS != null && this.CONFIRMATIONS.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.CONFIRMATIONS = value;
      if ( this.changedColumns.get( "CONFIRMATIONS" ) == null )  {
         this.changedColumns.put( "CONFIRMATIONS", "java.math.BigDecimal" );
         this.setDbColumnChangedFlag("CONFIRMATIONS", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateBigDecimal(getDbColumn("CONFIRMATIONS").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setVERSION( java.math.BigDecimal value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.VERSION == null && value == null) || 
         (this.VERSION != null && this.VERSION.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.VERSION = value;
      if ( this.changedColumns.get( "VERSION" ) == null )  {
         this.changedColumns.put( "VERSION", "java.math.BigDecimal" );
         this.setDbColumnChangedFlag("VERSION", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateBigDecimal(getDbColumn("VERSION").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setBITS( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.BITS == null && value == null) || 
         (this.BITS != null && this.BITS.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.BITS = value;
      if ( this.changedColumns.get( "BITS" ) == null )  {
         this.changedColumns.put( "BITS", "java.lang.String" );
         this.setDbColumnChangedFlag("BITS", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("BITS").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setMERKLEROOT( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.MERKLEROOT == null && value == null) || 
         (this.MERKLEROOT != null && this.MERKLEROOT.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.MERKLEROOT = value;
      if ( this.changedColumns.get( "MERKLEROOT" ) == null )  {
         this.changedColumns.put( "MERKLEROOT", "java.lang.String" );
         this.setDbColumnChangedFlag("MERKLEROOT", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("MERKLEROOT").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setTIME( java.math.BigDecimal value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.TIME == null && value == null) || 
         (this.TIME != null && this.TIME.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.TIME = value;
      if ( this.changedColumns.get( "TIME" ) == null )  {
         this.changedColumns.put( "TIME", "java.math.BigDecimal" );
         this.setDbColumnChangedFlag("TIME", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateBigDecimal(getDbColumn("TIME").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setBLOCK_HASH( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.BLOCK_HASH == null && value == null) || 
         (this.BLOCK_HASH != null && this.BLOCK_HASH.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.BLOCK_HASH = value;
      if ( this.changedColumns.get( "BLOCK_HASH" ) == null )  {
         this.changedColumns.put( "BLOCK_HASH", "java.lang.String" );
         this.setDbColumnChangedFlag("BLOCK_HASH", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("BLOCK_HASH").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setPREVIOUS_BLOCK_HASH( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.PREVIOUS_BLOCK_HASH == null && value == null) || 
         (this.PREVIOUS_BLOCK_HASH != null && this.PREVIOUS_BLOCK_HASH.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.PREVIOUS_BLOCK_HASH = value;
      if ( this.changedColumns.get( "PREVIOUS_BLOCK_HASH" ) == null )  {
         this.changedColumns.put( "PREVIOUS_BLOCK_HASH", "java.lang.String" );
         this.setDbColumnChangedFlag("PREVIOUS_BLOCK_HASH", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("PREVIOUS_BLOCK_HASH").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setNEXT_BLOCK_HASH( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.NEXT_BLOCK_HASH == null && value == null) || 
         (this.NEXT_BLOCK_HASH != null && this.NEXT_BLOCK_HASH.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.NEXT_BLOCK_HASH = value;
      if ( this.changedColumns.get( "NEXT_BLOCK_HASH" ) == null )  {
         this.changedColumns.put( "NEXT_BLOCK_HASH", "java.lang.String" );
         this.setDbColumnChangedFlag("NEXT_BLOCK_HASH", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("NEXT_BLOCK_HASH").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setHEIGHT( java.math.BigDecimal value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.HEIGHT == null && value == null) || 
         (this.HEIGHT != null && this.HEIGHT.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.HEIGHT = value;
      if ( this.changedColumns.get( "HEIGHT" ) == null )  {
         this.changedColumns.put( "HEIGHT", "java.math.BigDecimal" );
         this.setDbColumnChangedFlag("HEIGHT", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateBigDecimal(getDbColumn("HEIGHT").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setBLOCK_SIZE( java.math.BigDecimal value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.BLOCK_SIZE == null && value == null) || 
         (this.BLOCK_SIZE != null && this.BLOCK_SIZE.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.BLOCK_SIZE = value;
      if ( this.changedColumns.get( "BLOCK_SIZE" ) == null )  {
         this.changedColumns.put( "BLOCK_SIZE", "java.math.BigDecimal" );
         this.setDbColumnChangedFlag("BLOCK_SIZE", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateBigDecimal(getDbColumn("BLOCK_SIZE").getORDINAL_POSITION(), value);
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
    public java.math.BigDecimal getBLOCK_ID( ) {
      return this.BLOCK_ID;
   }
   public java.lang.String getMINER( ) {
      return this.MINER;
   }
   public java.math.BigDecimal getNONCE( ) {
      return this.NONCE;
   }
   public java.math.BigDecimal getDIFFICULTY( ) {
      return this.DIFFICULTY;
   }
   public java.lang.String getCHAINWORK( ) {
      return this.CHAINWORK;
   }
   public java.math.BigDecimal getCONFIRMATIONS( ) {
      return this.CONFIRMATIONS;
   }
   public java.math.BigDecimal getVERSION( ) {
      return this.VERSION;
   }
   public java.lang.String getBITS( ) {
      return this.BITS;
   }
   public java.lang.String getMERKLEROOT( ) {
      return this.MERKLEROOT;
   }
   public java.math.BigDecimal getTIME( ) {
      return this.TIME;
   }
   public java.lang.String getBLOCK_HASH( ) {
      return this.BLOCK_HASH;
   }
   public java.lang.String getPREVIOUS_BLOCK_HASH( ) {
      return this.PREVIOUS_BLOCK_HASH;
   }
   public java.lang.String getNEXT_BLOCK_HASH( ) {
      return this.NEXT_BLOCK_HASH;
   }
   public java.math.BigDecimal getHEIGHT( ) {
      return this.HEIGHT;
   }
   public java.math.BigDecimal getBLOCK_SIZE( ) {
      return this.BLOCK_SIZE;
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

                     this.BLOCK_ID = this.resultSet.getBigDecimal(1);
            this.MINER = this.resultSet.getString(2);
            this.NONCE = this.resultSet.getBigDecimal(3);
            this.DIFFICULTY = this.resultSet.getBigDecimal(4);
            this.CHAINWORK = this.resultSet.getString(5);
            this.CONFIRMATIONS = this.resultSet.getBigDecimal(6);
            this.VERSION = this.resultSet.getBigDecimal(7);
            this.BITS = this.resultSet.getString(8);
            this.MERKLEROOT = this.resultSet.getString(9);
            this.TIME = this.resultSet.getBigDecimal(10);
            this.BLOCK_HASH = this.resultSet.getString(11);
            this.PREVIOUS_BLOCK_HASH = this.resultSet.getString(12);
            this.NEXT_BLOCK_HASH = this.resultSet.getString(13);
            this.HEIGHT = this.resultSet.getBigDecimal(14);
            this.BLOCK_SIZE = this.resultSet.getBigDecimal(15);
            this.CREATE_TIMESTAMP = this.resultSet.getTimestamp(16);
   
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

                     this.BLOCK_ID = this.resultSet.getBigDecimal(1);
            this.MINER = this.resultSet.getString(2);
            this.NONCE = this.resultSet.getBigDecimal(3);
            this.DIFFICULTY = this.resultSet.getBigDecimal(4);
            this.CHAINWORK = this.resultSet.getString(5);
            this.CONFIRMATIONS = this.resultSet.getBigDecimal(6);
            this.VERSION = this.resultSet.getBigDecimal(7);
            this.BITS = this.resultSet.getString(8);
            this.MERKLEROOT = this.resultSet.getString(9);
            this.TIME = this.resultSet.getBigDecimal(10);
            this.BLOCK_HASH = this.resultSet.getString(11);
            this.PREVIOUS_BLOCK_HASH = this.resultSet.getString(12);
            this.NEXT_BLOCK_HASH = this.resultSet.getString(13);
            this.HEIGHT = this.resultSet.getBigDecimal(14);
            this.BLOCK_SIZE = this.resultSet.getBigDecimal(15);
            this.CREATE_TIMESTAMP = this.resultSet.getTimestamp(16);
   
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

                    this.BLOCK_ID = this.resultSet.getBigDecimal(1);
            this.MINER = this.resultSet.getString(2);
            this.NONCE = this.resultSet.getBigDecimal(3);
            this.DIFFICULTY = this.resultSet.getBigDecimal(4);
            this.CHAINWORK = this.resultSet.getString(5);
            this.CONFIRMATIONS = this.resultSet.getBigDecimal(6);
            this.VERSION = this.resultSet.getBigDecimal(7);
            this.BITS = this.resultSet.getString(8);
            this.MERKLEROOT = this.resultSet.getString(9);
            this.TIME = this.resultSet.getBigDecimal(10);
            this.BLOCK_HASH = this.resultSet.getString(11);
            this.PREVIOUS_BLOCK_HASH = this.resultSet.getString(12);
            this.NEXT_BLOCK_HASH = this.resultSet.getString(13);
            this.HEIGHT = this.resultSet.getBigDecimal(14);
            this.BLOCK_SIZE = this.resultSet.getBigDecimal(15);
            this.CREATE_TIMESTAMP = this.resultSet.getTimestamp(16);
   

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
   public BlockTo getTo() {
      BlockTo blockTo = new BlockTo();

            blockTo.setBLOCK_ID(this.BLOCK_ID);
      blockTo.setMINER(this.MINER);
      blockTo.setNONCE(this.NONCE);
      blockTo.setDIFFICULTY(this.DIFFICULTY);
      blockTo.setCHAINWORK(this.CHAINWORK);
      blockTo.setCONFIRMATIONS(this.CONFIRMATIONS);
      blockTo.setVERSION(this.VERSION);
      blockTo.setBITS(this.BITS);
      blockTo.setMERKLEROOT(this.MERKLEROOT);
      blockTo.setTIME(this.TIME);
      blockTo.setBLOCK_HASH(this.BLOCK_HASH);
      blockTo.setPREVIOUS_BLOCK_HASH(this.PREVIOUS_BLOCK_HASH);
      blockTo.setNEXT_BLOCK_HASH(this.NEXT_BLOCK_HASH);
      blockTo.setHEIGHT(this.HEIGHT);
      blockTo.setBLOCK_SIZE(this.BLOCK_SIZE);
      blockTo.setCREATE_TIMESTAMP(this.CREATE_TIMESTAMP);


      return blockTo;
   }

   /*************************************************************************
    *
    * Copies data from Transfer Object PK columns to corresponding columns
    * of database object
    *
    *************************************************************************/
    public void setPkValuesFromTo(BlockTo blockTo) throws GDAOException {

            this.setBLOCK_ID(blockTo.getBLOCK_ID());


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

      String SQL = "DELETE FROM BLOCK WHERE ";
      SQL = SQL + "BLOCK_ID = ? ";

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
    public ArrayList<BlockTo> getToArrayEntireResultSet() throws GDAOException {
       ArrayList<BlockTo> toArray = new ArrayList<BlockTo>();
       while (next()) {
          BlockTo blockTo = getTo();
          toArray.add(blockTo);
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
   public ArrayList<BlockTo> getToArray(int arraySize) throws GDAOException {
      int i = 0;
      ArrayList <BlockTo> toArray = new ArrayList<BlockTo>();
      try {
         while (i < arraySize) {
            if (!this.resultSet.isLast() && !this.resultSet.isAfterLast() && this.getResultSetRowCount() > 0) {
               next();
               BlockTo blockTo = getTo();
               toArray.add(blockTo);
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
   public ArrayList <BlockTo> getToArray(String what) throws GDAOException {
      ArrayList <BlockTo> toArray = new ArrayList<BlockTo>();
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
   public void setThisFromTo(BlockTo blockTo) throws GDAOException {

            this.setBLOCK_ID(blockTo.getBLOCK_ID());
      this.setMINER(blockTo.getMINER());
      this.setNONCE(blockTo.getNONCE());
      this.setDIFFICULTY(blockTo.getDIFFICULTY());
      this.setCHAINWORK(blockTo.getCHAINWORK());
      this.setCONFIRMATIONS(blockTo.getCONFIRMATIONS());
      this.setVERSION(blockTo.getVERSION());
      this.setBITS(blockTo.getBITS());
      this.setMERKLEROOT(blockTo.getMERKLEROOT());
      this.setTIME(blockTo.getTIME());
      this.setBLOCK_HASH(blockTo.getBLOCK_HASH());
      this.setPREVIOUS_BLOCK_HASH(blockTo.getPREVIOUS_BLOCK_HASH());
      this.setNEXT_BLOCK_HASH(blockTo.getNEXT_BLOCK_HASH());
      this.setHEIGHT(blockTo.getHEIGHT());
      this.setBLOCK_SIZE(blockTo.getBLOCK_SIZE());
      this.setCREATE_TIMESTAMP(blockTo.getCREATE_TIMESTAMP());


      return;
   }

   /*************************************************************************
    *
    * Prints values of This Object
    *
    *************************************************************************/
   public void print(String fieldDelimiter) {
      System.out.println(      this.getBLOCK_ID()
       + fieldDelimiter + this.getMINER()
       + fieldDelimiter + this.getNONCE()
       + fieldDelimiter + this.getDIFFICULTY()
       + fieldDelimiter + this.getCHAINWORK()
       + fieldDelimiter + this.getCONFIRMATIONS()
       + fieldDelimiter + this.getVERSION()
       + fieldDelimiter + this.getBITS()
       + fieldDelimiter + this.getMERKLEROOT()
       + fieldDelimiter + this.getTIME()
       + fieldDelimiter + this.getBLOCK_HASH()
       + fieldDelimiter + this.getPREVIOUS_BLOCK_HASH()
       + fieldDelimiter + this.getNEXT_BLOCK_HASH()
       + fieldDelimiter + this.getHEIGHT()
       + fieldDelimiter + this.getBLOCK_SIZE()
       + fieldDelimiter + this.getCREATE_TIMESTAMP()
);
      return;
   }

   /*************************************************************************
    *
    * Prints Transfer Object
    *
    *************************************************************************/
   public static void print(BlockTo blockTo, String fieldDelimiter) {
      System.out.println(      blockTo.getBLOCK_ID()
       + fieldDelimiter + blockTo.getMINER()
       + fieldDelimiter + blockTo.getNONCE()
       + fieldDelimiter + blockTo.getDIFFICULTY()
       + fieldDelimiter + blockTo.getCHAINWORK()
       + fieldDelimiter + blockTo.getCONFIRMATIONS()
       + fieldDelimiter + blockTo.getVERSION()
       + fieldDelimiter + blockTo.getBITS()
       + fieldDelimiter + blockTo.getMERKLEROOT()
       + fieldDelimiter + blockTo.getTIME()
       + fieldDelimiter + blockTo.getBLOCK_HASH()
       + fieldDelimiter + blockTo.getPREVIOUS_BLOCK_HASH()
       + fieldDelimiter + blockTo.getNEXT_BLOCK_HASH()
       + fieldDelimiter + blockTo.getHEIGHT()
       + fieldDelimiter + blockTo.getBLOCK_SIZE()
       + fieldDelimiter + blockTo.getCREATE_TIMESTAMP()
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