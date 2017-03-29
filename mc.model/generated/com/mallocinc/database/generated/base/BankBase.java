package com.mallocinc.database.generated.base;

import java.sql.*;
import java.io.*;
import com.mallocinc.codegenerator.superclasses.oracle.*;
import java.util.ArrayList;
import java.util.Arrays;

import com.mallocinc.database.generated.to.BankTo;
import com.mallocinc.codegenerator.exceptions.*;

/*************************************************************************
 *  <pre>
 *
 *  Generated Class: BankBase.java
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
public class BankBase extends BaseOracleDbEntityClass <BankTo> {

   /**********************************************************************
    *
    *  Database Variables declarations
    *  They represent database columns
    *
    **********************************************************************/
   private java.math.BigDecimal BANK_ID = null;
private java.lang.String BANK_CODE = null;
private java.lang.String BANK_NAME = null;
private byte[] BANK_LOGO = null;
private java.lang.String KEY_CODE = null;


   /**********************************************************
    *
    *  Default Constructor
    *
    ***********************************************************/
   public BankBase( ) {

      if (getDbEntityName() == null) {
         setDbEntityName("BANK");
      }

      columnsCommaDelimitedList = " BANK_ID"
   + ",BANK_CODE"
   + ",BANK_NAME"
   + ",BANK_LOGO"
   + ",KEY_CODE"
   ;

      setSelectAllSQL();

      setDbEntityType("TABLE");

      OracleDbColumn dbColumn = null;

         dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "BANK_ID" );
      dbColumn.setORDINAL_POSITION( 1 );
      dbColumn.setTYPE_NAME( "NUMBER" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      dbColumn.setPrimaryKey( true );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "BANK_CODE" );
      dbColumn.setORDINAL_POSITION( 2 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "BANK_NAME" );
      dbColumn.setORDINAL_POSITION( 3 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "BANK_LOGO" );
      dbColumn.setORDINAL_POSITION( 4 );
      dbColumn.setTYPE_NAME( "BLOB" );
      dbColumn.setIS_NULLABLE( "YES" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "KEY_CODE" );
      dbColumn.setORDINAL_POSITION( 5 );
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
   public BankBase( Connection connection ) {
      this(); //chain default constructor
      this.connection = connection;
   }

   /**********************************************************
    *
    *  Constructor
    *
    ***********************************************************/
   public BankBase( String underlyingEntityName ) {
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

   public void setBANK_CODE( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.BANK_CODE == null && value == null) || 
         (this.BANK_CODE != null && this.BANK_CODE.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.BANK_CODE = value;
      if ( this.changedColumns.get( "BANK_CODE" ) == null )  {
         this.changedColumns.put( "BANK_CODE", "java.lang.String" );
         this.setDbColumnChangedFlag("BANK_CODE", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("BANK_CODE").getORDINAL_POSITION(), value);
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

   public void setBANK_LOGO( byte[] value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.BANK_LOGO == null && value == null) || 
         (this.BANK_LOGO != null && 
            Arrays.equals(this.BANK_LOGO, value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      if (value != null) {   this.BANK_LOGO = Arrays.copyOf(value, value.length);
      } else {  this.BANK_LOGO = null;}   if ( this.changedColumns.get( "BANK_LOGO" ) == null )  {
         this.changedColumns.put( "BANK_LOGO", "byte[]" );
         this.setDbColumnChangedFlag("BANK_LOGO", true);
      }
   }

   public void setKEY_CODE( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.KEY_CODE == null && value == null) || 
         (this.KEY_CODE != null && this.KEY_CODE.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.KEY_CODE = value;
      if ( this.changedColumns.get( "KEY_CODE" ) == null )  {
         this.changedColumns.put( "KEY_CODE", "java.lang.String" );
         this.setDbColumnChangedFlag("KEY_CODE", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("KEY_CODE").getORDINAL_POSITION(), value);
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
    public java.math.BigDecimal getBANK_ID( ) {
      return this.BANK_ID;
   }
   public java.lang.String getBANK_CODE( ) {
      return this.BANK_CODE;
   }
   public java.lang.String getBANK_NAME( ) {
      return this.BANK_NAME;
   }
   public byte[] getBANK_LOGO( ) {
      return this.BANK_LOGO;
   }
   public java.lang.String getKEY_CODE( ) {
      return this.KEY_CODE;
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

                     this.BANK_ID = this.resultSet.getBigDecimal(1);
            this.BANK_CODE = this.resultSet.getString(2);
            this.BANK_NAME = this.resultSet.getString(3);
            this.BANK_LOGO = (this.resultSet.getBlob(4) == null)? null :this.resultSet.getBlob(4).getBytes(1,(int)this.resultSet.getBlob(4).length());
            this.KEY_CODE = this.resultSet.getString(5);
   
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

                     this.BANK_ID = this.resultSet.getBigDecimal(1);
            this.BANK_CODE = this.resultSet.getString(2);
            this.BANK_NAME = this.resultSet.getString(3);
            this.BANK_LOGO = (this.resultSet.getBlob(4) == null)? null :this.resultSet.getBlob(4).getBytes(1,(int)this.resultSet.getBlob(4).length());
            this.KEY_CODE = this.resultSet.getString(5);
   
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

                    this.BANK_ID = this.resultSet.getBigDecimal(1);
            this.BANK_CODE = this.resultSet.getString(2);
            this.BANK_NAME = this.resultSet.getString(3);
            this.BANK_LOGO = (this.resultSet.getBlob(4) == null)? null :this.resultSet.getBlob(4).getBytes(1,(int)this.resultSet.getBlob(4).length());
            this.KEY_CODE = this.resultSet.getString(5);
   

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
   public BankTo getTo() {
      BankTo bankTo = new BankTo();

            bankTo.setBANK_ID(this.BANK_ID);
      bankTo.setBANK_CODE(this.BANK_CODE);
      bankTo.setBANK_NAME(this.BANK_NAME);
      bankTo.setBANK_LOGO(this.BANK_LOGO);
      bankTo.setKEY_CODE(this.KEY_CODE);


      return bankTo;
   }

   /*************************************************************************
    *
    * Copies data from Transfer Object PK columns to corresponding columns
    * of database object
    *
    *************************************************************************/
    public void setPkValuesFromTo(BankTo bankTo) throws GDAOException {

            this.setBANK_ID(bankTo.getBANK_ID());


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

      String SQL = "DELETE FROM BANK WHERE ";
      SQL = SQL + "BANK_ID = ? ";

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
    public ArrayList<BankTo> getToArrayEntireResultSet() throws GDAOException {
       ArrayList<BankTo> toArray = new ArrayList<BankTo>();
       while (next()) {
          BankTo bankTo = getTo();
          toArray.add(bankTo);
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
   public ArrayList<BankTo> getToArray(int arraySize) throws GDAOException {
      int i = 0;
      ArrayList <BankTo> toArray = new ArrayList<BankTo>();
      try {
         while (i < arraySize) {
            if (!this.resultSet.isLast() && !this.resultSet.isAfterLast() && this.getResultSetRowCount() > 0) {
               next();
               BankTo bankTo = getTo();
               toArray.add(bankTo);
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
   public ArrayList <BankTo> getToArray(String what) throws GDAOException {
      ArrayList <BankTo> toArray = new ArrayList<BankTo>();
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
   public void setThisFromTo(BankTo bankTo) throws GDAOException {

            this.setBANK_ID(bankTo.getBANK_ID());
      this.setBANK_CODE(bankTo.getBANK_CODE());
      this.setBANK_NAME(bankTo.getBANK_NAME());
      this.setBANK_LOGO(bankTo.getBANK_LOGO());
      this.setKEY_CODE(bankTo.getKEY_CODE());


      return;
   }

   /*************************************************************************
    *
    * Prints values of This Object
    *
    *************************************************************************/
   public void print(String fieldDelimiter) {
      System.out.println(      this.getBANK_ID()
       + fieldDelimiter + this.getBANK_CODE()
       + fieldDelimiter + this.getBANK_NAME()
       + fieldDelimiter + this.getBANK_LOGO()
       + fieldDelimiter + this.getKEY_CODE()
);
      return;
   }

   /*************************************************************************
    *
    * Prints Transfer Object
    *
    *************************************************************************/
   public static void print(BankTo bankTo, String fieldDelimiter) {
      System.out.println(      bankTo.getBANK_ID()
       + fieldDelimiter + bankTo.getBANK_CODE()
       + fieldDelimiter + bankTo.getBANK_NAME()
       + fieldDelimiter + bankTo.getBANK_LOGO()
       + fieldDelimiter + bankTo.getKEY_CODE()
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