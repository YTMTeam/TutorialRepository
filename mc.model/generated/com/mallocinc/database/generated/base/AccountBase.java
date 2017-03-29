package com.mallocinc.database.generated.base;

import java.sql.*;
import java.io.*;
import com.mallocinc.codegenerator.superclasses.oracle.*;
import java.util.ArrayList;
import java.util.Arrays;

import com.mallocinc.database.generated.to.AccountTo;
import com.mallocinc.codegenerator.exceptions.*;

/*************************************************************************
 *  <pre>
 *
 *  Generated Class: AccountBase.java
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
 *  This code is generated on: 2017-February-27 06:45:54 PM CET
 *
 *  Copyright (C) 2015 Malloc Inc.
 *
 *  </pre>
 **************************************************************************/
@SuppressWarnings("unused")
public class AccountBase extends BaseOracleDbEntityClass <AccountTo> {

   /**********************************************************************
    *
    *  Database Variables declarations
    *  They represent database columns
    *
    **********************************************************************/
   private java.lang.String ACCOUNT_ID = null;
private java.math.BigDecimal BANK_ID = null;
private java.math.BigDecimal ACCOUNT_NUMBER = null;
private java.lang.String FIRST_NAME = null;
private java.lang.String MIDDLE_NAME = null;
private java.lang.String LAST_NAME = null;
private java.lang.String TYPE = null;
private java.lang.String BROKER_CODE = null;
private java.lang.String MANAGED_ACCOUNT = null;
private java.lang.String ACCOUNT_STATUS = null;


   /**********************************************************
    *
    *  Default Constructor
    *
    ***********************************************************/
   public AccountBase( ) {

      if (getDbEntityName() == null) {
         setDbEntityName("ACCOUNT");
      }

      columnsCommaDelimitedList = " ACCOUNT_ID"
   + ",BANK_ID"
   + ",ACCOUNT_NUMBER"
   + ",FIRST_NAME"
   + ",MIDDLE_NAME"
   + ",LAST_NAME"
   + ",TYPE"
   + ",BROKER_CODE"
   + ",MANAGED_ACCOUNT"
   + ",ACCOUNT_STATUS"
   ;

      setSelectAllSQL();

      setDbEntityType("TABLE");

      OracleDbColumn dbColumn = null;

         dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "ACCOUNT_ID" );
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
      dbColumn.setCOLUMN_NAME( "MIDDLE_NAME" );
      dbColumn.setORDINAL_POSITION( 5 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "YES" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "LAST_NAME" );
      dbColumn.setORDINAL_POSITION( 6 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "TYPE" );
      dbColumn.setORDINAL_POSITION( 7 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "BROKER_CODE" );
      dbColumn.setORDINAL_POSITION( 8 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "MANAGED_ACCOUNT" );
      dbColumn.setORDINAL_POSITION( 9 );
      dbColumn.setTYPE_NAME( "CHAR" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "ACCOUNT_STATUS" );
      dbColumn.setORDINAL_POSITION( 10 );
      dbColumn.setTYPE_NAME( "CHAR" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);


   }

   /**********************************************************
    *
    *  Constructor
    *
    ***********************************************************/
   public AccountBase( Connection connection ) {
      this(); //chain default constructor
      this.connection = connection;
   }

   /**********************************************************
    *
    *  Constructor
    *
    ***********************************************************/
   public AccountBase( String underlyingEntityName ) {
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

   public void setMANAGED_ACCOUNT( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.MANAGED_ACCOUNT == null && value == null) || 
         (this.MANAGED_ACCOUNT != null && this.MANAGED_ACCOUNT.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.MANAGED_ACCOUNT = value;
      if ( this.changedColumns.get( "MANAGED_ACCOUNT" ) == null )  {
         this.changedColumns.put( "MANAGED_ACCOUNT", "java.lang.String" );
         this.setDbColumnChangedFlag("MANAGED_ACCOUNT", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("MANAGED_ACCOUNT").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setACCOUNT_STATUS( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.ACCOUNT_STATUS == null && value == null) || 
         (this.ACCOUNT_STATUS != null && this.ACCOUNT_STATUS.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.ACCOUNT_STATUS = value;
      if ( this.changedColumns.get( "ACCOUNT_STATUS" ) == null )  {
         this.changedColumns.put( "ACCOUNT_STATUS", "java.lang.String" );
         this.setDbColumnChangedFlag("ACCOUNT_STATUS", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("ACCOUNT_STATUS").getORDINAL_POSITION(), value);
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
   public java.math.BigDecimal getBANK_ID( ) {
      return this.BANK_ID;
   }
   public java.math.BigDecimal getACCOUNT_NUMBER( ) {
      return this.ACCOUNT_NUMBER;
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
   public java.lang.String getTYPE( ) {
      return this.TYPE;
   }
   public java.lang.String getBROKER_CODE( ) {
      return this.BROKER_CODE;
   }
   public java.lang.String getMANAGED_ACCOUNT( ) {
      return this.MANAGED_ACCOUNT;
   }
   public java.lang.String getACCOUNT_STATUS( ) {
      return this.ACCOUNT_STATUS;
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
            this.BANK_ID = this.resultSet.getBigDecimal(2);
            this.ACCOUNT_NUMBER = this.resultSet.getBigDecimal(3);
            this.FIRST_NAME = this.resultSet.getString(4);
            this.MIDDLE_NAME = this.resultSet.getString(5);
            this.LAST_NAME = this.resultSet.getString(6);
            this.TYPE = this.resultSet.getString(7);
            this.BROKER_CODE = this.resultSet.getString(8);
            this.MANAGED_ACCOUNT = this.resultSet.getString(9);
            this.ACCOUNT_STATUS = this.resultSet.getString(10);
   
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
            this.BANK_ID = this.resultSet.getBigDecimal(2);
            this.ACCOUNT_NUMBER = this.resultSet.getBigDecimal(3);
            this.FIRST_NAME = this.resultSet.getString(4);
            this.MIDDLE_NAME = this.resultSet.getString(5);
            this.LAST_NAME = this.resultSet.getString(6);
            this.TYPE = this.resultSet.getString(7);
            this.BROKER_CODE = this.resultSet.getString(8);
            this.MANAGED_ACCOUNT = this.resultSet.getString(9);
            this.ACCOUNT_STATUS = this.resultSet.getString(10);
   
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
            this.BANK_ID = this.resultSet.getBigDecimal(2);
            this.ACCOUNT_NUMBER = this.resultSet.getBigDecimal(3);
            this.FIRST_NAME = this.resultSet.getString(4);
            this.MIDDLE_NAME = this.resultSet.getString(5);
            this.LAST_NAME = this.resultSet.getString(6);
            this.TYPE = this.resultSet.getString(7);
            this.BROKER_CODE = this.resultSet.getString(8);
            this.MANAGED_ACCOUNT = this.resultSet.getString(9);
            this.ACCOUNT_STATUS = this.resultSet.getString(10);
   

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
   public AccountTo getTo() {
      AccountTo accountTo = new AccountTo();

            accountTo.setACCOUNT_ID(this.ACCOUNT_ID);
      accountTo.setBANK_ID(this.BANK_ID);
      accountTo.setACCOUNT_NUMBER(this.ACCOUNT_NUMBER);
      accountTo.setFIRST_NAME(this.FIRST_NAME);
      accountTo.setMIDDLE_NAME(this.MIDDLE_NAME);
      accountTo.setLAST_NAME(this.LAST_NAME);
      accountTo.setTYPE(this.TYPE);
      accountTo.setBROKER_CODE(this.BROKER_CODE);
      accountTo.setMANAGED_ACCOUNT(this.MANAGED_ACCOUNT);
      accountTo.setACCOUNT_STATUS(this.ACCOUNT_STATUS);


      return accountTo;
   }

   /*************************************************************************
    *
    * Copies data from Transfer Object PK columns to corresponding columns
    * of database object
    *
    *************************************************************************/
    public void setPkValuesFromTo(AccountTo accountTo) throws GDAOException {

            this.setACCOUNT_ID(accountTo.getACCOUNT_ID());


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

      String SQL = "DELETE FROM ACCOUNT WHERE ";
      SQL = SQL + "ACCOUNT_ID = ? ";

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
    public ArrayList<AccountTo> getToArrayEntireResultSet() throws GDAOException {
       ArrayList<AccountTo> toArray = new ArrayList<AccountTo>();
       while (next()) {
          AccountTo accountTo = getTo();
          toArray.add(accountTo);
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
   public ArrayList<AccountTo> getToArray(int arraySize) throws GDAOException {
      int i = 0;
      ArrayList <AccountTo> toArray = new ArrayList<AccountTo>();
      try {
         while (i < arraySize) {
            if (!this.resultSet.isLast() && !this.resultSet.isAfterLast() && this.getResultSetRowCount() > 0) {
               next();
               AccountTo accountTo = getTo();
               toArray.add(accountTo);
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
   public ArrayList <AccountTo> getToArray(String what) throws GDAOException {
      ArrayList <AccountTo> toArray = new ArrayList<AccountTo>();
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
   public void setThisFromTo(AccountTo accountTo) throws GDAOException {

            this.setACCOUNT_ID(accountTo.getACCOUNT_ID());
      this.setBANK_ID(accountTo.getBANK_ID());
      this.setACCOUNT_NUMBER(accountTo.getACCOUNT_NUMBER());
      this.setFIRST_NAME(accountTo.getFIRST_NAME());
      this.setMIDDLE_NAME(accountTo.getMIDDLE_NAME());
      this.setLAST_NAME(accountTo.getLAST_NAME());
      this.setTYPE(accountTo.getTYPE());
      this.setBROKER_CODE(accountTo.getBROKER_CODE());
      this.setMANAGED_ACCOUNT(accountTo.getMANAGED_ACCOUNT());
      this.setACCOUNT_STATUS(accountTo.getACCOUNT_STATUS());


      return;
   }

   /*************************************************************************
    *
    * Prints values of This Object
    *
    *************************************************************************/
   public void print(String fieldDelimiter) {
      System.out.println(      this.getACCOUNT_ID()
       + fieldDelimiter + this.getBANK_ID()
       + fieldDelimiter + this.getACCOUNT_NUMBER()
       + fieldDelimiter + this.getFIRST_NAME()
       + fieldDelimiter + this.getMIDDLE_NAME()
       + fieldDelimiter + this.getLAST_NAME()
       + fieldDelimiter + this.getTYPE()
       + fieldDelimiter + this.getBROKER_CODE()
       + fieldDelimiter + this.getMANAGED_ACCOUNT()
       + fieldDelimiter + this.getACCOUNT_STATUS()
);
      return;
   }

   /*************************************************************************
    *
    * Prints Transfer Object
    *
    *************************************************************************/
   public static void print(AccountTo accountTo, String fieldDelimiter) {
      System.out.println(      accountTo.getACCOUNT_ID()
       + fieldDelimiter + accountTo.getBANK_ID()
       + fieldDelimiter + accountTo.getACCOUNT_NUMBER()
       + fieldDelimiter + accountTo.getFIRST_NAME()
       + fieldDelimiter + accountTo.getMIDDLE_NAME()
       + fieldDelimiter + accountTo.getLAST_NAME()
       + fieldDelimiter + accountTo.getTYPE()
       + fieldDelimiter + accountTo.getBROKER_CODE()
       + fieldDelimiter + accountTo.getMANAGED_ACCOUNT()
       + fieldDelimiter + accountTo.getACCOUNT_STATUS()
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