package com.mallocinc.database.generated.base;

import java.sql.*;
import java.io.*;
import com.mallocinc.codegenerator.superclasses.oracle.*;
import java.util.ArrayList;
import java.util.Arrays;

import com.mallocinc.database.generated.to.TransactionTo;
import com.mallocinc.codegenerator.exceptions.*;

/*************************************************************************
 *  <pre>
 *
 *  Generated Class: TransactionBase.java
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
public class TransactionBase extends BaseOracleDbEntityClass <TransactionTo> {

   /**********************************************************************
    *
    *  Database Variables declarations
    *  They represent database columns
    *
    **********************************************************************/
   private java.math.BigDecimal TRANSACTION_ID = null;
private java.math.BigDecimal BLOCK_ID = null;
private java.lang.String TRANSACTION_HASH = null;
private java.math.BigDecimal VERSION = null;
private java.math.BigDecimal LOCKTIME = null;
private java.sql.Timestamp CREATE_TIMESTAMP = null;
private java.lang.String TYPE = null;


   /**********************************************************
    *
    *  Default Constructor
    *
    ***********************************************************/
   public TransactionBase( ) {

      if (getDbEntityName() == null) {
         setDbEntityName("TRANSACTION");
      }

      columnsCommaDelimitedList = " TRANSACTION_ID"
   + ",BLOCK_ID"
   + ",TRANSACTION_HASH"
   + ",VERSION"
   + ",LOCKTIME"
   + ",CREATE_TIMESTAMP"
   + ",TYPE"
   ;

      setSelectAllSQL();

      setDbEntityType("TABLE");

      OracleDbColumn dbColumn = null;

         dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "TRANSACTION_ID" );
      dbColumn.setORDINAL_POSITION( 1 );
      dbColumn.setTYPE_NAME( "NUMBER" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      dbColumn.setPrimaryKey( true );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "BLOCK_ID" );
      dbColumn.setORDINAL_POSITION( 2 );
      dbColumn.setTYPE_NAME( "NUMBER" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "TRANSACTION_HASH" );
      dbColumn.setORDINAL_POSITION( 3 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "VERSION" );
      dbColumn.setORDINAL_POSITION( 4 );
      dbColumn.setTYPE_NAME( "NUMBER" );
      dbColumn.setIS_NULLABLE( "YES" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "LOCKTIME" );
      dbColumn.setORDINAL_POSITION( 5 );
      dbColumn.setTYPE_NAME( "NUMBER" );
      dbColumn.setIS_NULLABLE( "YES" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "CREATE_TIMESTAMP" );
      dbColumn.setORDINAL_POSITION( 6 );
      dbColumn.setTYPE_NAME( "TIMESTAMP(6)" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "TYPE" );
      dbColumn.setORDINAL_POSITION( 7 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "YES" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);


   }

   /**********************************************************
    *
    *  Constructor
    *
    ***********************************************************/
   public TransactionBase( Connection connection ) {
      this(); //chain default constructor
      this.connection = connection;
   }

   /**********************************************************
    *
    *  Constructor
    *
    ***********************************************************/
   public TransactionBase( String underlyingEntityName ) {
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

   public void setTRANSACTION_HASH( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.TRANSACTION_HASH == null && value == null) || 
         (this.TRANSACTION_HASH != null && this.TRANSACTION_HASH.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.TRANSACTION_HASH = value;
      if ( this.changedColumns.get( "TRANSACTION_HASH" ) == null )  {
         this.changedColumns.put( "TRANSACTION_HASH", "java.lang.String" );
         this.setDbColumnChangedFlag("TRANSACTION_HASH", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("TRANSACTION_HASH").getORDINAL_POSITION(), value);
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

   public void setLOCKTIME( java.math.BigDecimal value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.LOCKTIME == null && value == null) || 
         (this.LOCKTIME != null && this.LOCKTIME.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.LOCKTIME = value;
      if ( this.changedColumns.get( "LOCKTIME" ) == null )  {
         this.changedColumns.put( "LOCKTIME", "java.math.BigDecimal" );
         this.setDbColumnChangedFlag("LOCKTIME", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateBigDecimal(getDbColumn("LOCKTIME").getORDINAL_POSITION(), value);
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

   public void setTYPE( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.TYPE == null && value == null) || 
         (this.TYPE != null && this.TYPE.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.TYPE = value;
      if ( this.changedColumns.get( "TYPE" ) == null )  {
         this.changedColumns.put( "TYPE", "java.lang.String" );
         this.setDbColumnChangedFlag("TYPE", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("TYPE").getORDINAL_POSITION(), value);
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
    public java.math.BigDecimal getTRANSACTION_ID( ) {
      return this.TRANSACTION_ID;
   }
   public java.math.BigDecimal getBLOCK_ID( ) {
      return this.BLOCK_ID;
   }
   public java.lang.String getTRANSACTION_HASH( ) {
      return this.TRANSACTION_HASH;
   }
   public java.math.BigDecimal getVERSION( ) {
      return this.VERSION;
   }
   public java.math.BigDecimal getLOCKTIME( ) {
      return this.LOCKTIME;
   }
   public java.sql.Timestamp getCREATE_TIMESTAMP( ) {
      return this.CREATE_TIMESTAMP;
   }
   public java.lang.String getTYPE( ) {
      return this.TYPE;
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

                     this.TRANSACTION_ID = this.resultSet.getBigDecimal(1);
            this.BLOCK_ID = this.resultSet.getBigDecimal(2);
            this.TRANSACTION_HASH = this.resultSet.getString(3);
            this.VERSION = this.resultSet.getBigDecimal(4);
            this.LOCKTIME = this.resultSet.getBigDecimal(5);
            this.CREATE_TIMESTAMP = this.resultSet.getTimestamp(6);
            this.TYPE = this.resultSet.getString(7);
   
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

                     this.TRANSACTION_ID = this.resultSet.getBigDecimal(1);
            this.BLOCK_ID = this.resultSet.getBigDecimal(2);
            this.TRANSACTION_HASH = this.resultSet.getString(3);
            this.VERSION = this.resultSet.getBigDecimal(4);
            this.LOCKTIME = this.resultSet.getBigDecimal(5);
            this.CREATE_TIMESTAMP = this.resultSet.getTimestamp(6);
            this.TYPE = this.resultSet.getString(7);
   
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

                    this.TRANSACTION_ID = this.resultSet.getBigDecimal(1);
            this.BLOCK_ID = this.resultSet.getBigDecimal(2);
            this.TRANSACTION_HASH = this.resultSet.getString(3);
            this.VERSION = this.resultSet.getBigDecimal(4);
            this.LOCKTIME = this.resultSet.getBigDecimal(5);
            this.CREATE_TIMESTAMP = this.resultSet.getTimestamp(6);
            this.TYPE = this.resultSet.getString(7);
   

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
   public TransactionTo getTo() {
      TransactionTo transactionTo = new TransactionTo();

            transactionTo.setTRANSACTION_ID(this.TRANSACTION_ID);
      transactionTo.setBLOCK_ID(this.BLOCK_ID);
      transactionTo.setTRANSACTION_HASH(this.TRANSACTION_HASH);
      transactionTo.setVERSION(this.VERSION);
      transactionTo.setLOCKTIME(this.LOCKTIME);
      transactionTo.setCREATE_TIMESTAMP(this.CREATE_TIMESTAMP);
      transactionTo.setTYPE(this.TYPE);


      return transactionTo;
   }

   /*************************************************************************
    *
    * Copies data from Transfer Object PK columns to corresponding columns
    * of database object
    *
    *************************************************************************/
    public void setPkValuesFromTo(TransactionTo transactionTo) throws GDAOException {

            this.setTRANSACTION_ID(transactionTo.getTRANSACTION_ID());


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

      String SQL = "DELETE FROM TRANSACTION WHERE ";
      SQL = SQL + "TRANSACTION_ID = ? ";

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
    public ArrayList<TransactionTo> getToArrayEntireResultSet() throws GDAOException {
       ArrayList<TransactionTo> toArray = new ArrayList<TransactionTo>();
       while (next()) {
          TransactionTo transactionTo = getTo();
          toArray.add(transactionTo);
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
   public ArrayList<TransactionTo> getToArray(int arraySize) throws GDAOException {
      int i = 0;
      ArrayList <TransactionTo> toArray = new ArrayList<TransactionTo>();
      try {
         while (i < arraySize) {
            if (!this.resultSet.isLast() && !this.resultSet.isAfterLast() && this.getResultSetRowCount() > 0) {
               next();
               TransactionTo transactionTo = getTo();
               toArray.add(transactionTo);
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
   public ArrayList <TransactionTo> getToArray(String what) throws GDAOException {
      ArrayList <TransactionTo> toArray = new ArrayList<TransactionTo>();
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
   public void setThisFromTo(TransactionTo transactionTo) throws GDAOException {

            this.setTRANSACTION_ID(transactionTo.getTRANSACTION_ID());
      this.setBLOCK_ID(transactionTo.getBLOCK_ID());
      this.setTRANSACTION_HASH(transactionTo.getTRANSACTION_HASH());
      this.setVERSION(transactionTo.getVERSION());
      this.setLOCKTIME(transactionTo.getLOCKTIME());
      this.setCREATE_TIMESTAMP(transactionTo.getCREATE_TIMESTAMP());
      this.setTYPE(transactionTo.getTYPE());


      return;
   }

   /*************************************************************************
    *
    * Prints values of This Object
    *
    *************************************************************************/
   public void print(String fieldDelimiter) {
      System.out.println(      this.getTRANSACTION_ID()
       + fieldDelimiter + this.getBLOCK_ID()
       + fieldDelimiter + this.getTRANSACTION_HASH()
       + fieldDelimiter + this.getVERSION()
       + fieldDelimiter + this.getLOCKTIME()
       + fieldDelimiter + this.getCREATE_TIMESTAMP()
       + fieldDelimiter + this.getTYPE()
);
      return;
   }

   /*************************************************************************
    *
    * Prints Transfer Object
    *
    *************************************************************************/
   public static void print(TransactionTo transactionTo, String fieldDelimiter) {
      System.out.println(      transactionTo.getTRANSACTION_ID()
       + fieldDelimiter + transactionTo.getBLOCK_ID()
       + fieldDelimiter + transactionTo.getTRANSACTION_HASH()
       + fieldDelimiter + transactionTo.getVERSION()
       + fieldDelimiter + transactionTo.getLOCKTIME()
       + fieldDelimiter + transactionTo.getCREATE_TIMESTAMP()
       + fieldDelimiter + transactionTo.getTYPE()
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