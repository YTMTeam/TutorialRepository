package com.mallocinc.database.generated.base;

import java.sql.*;
import java.io.*;
import com.mallocinc.codegenerator.superclasses.oracle.*;
import java.util.ArrayList;
import java.util.Arrays;

import com.mallocinc.database.generated.to.VExcelPositionTo;
import com.mallocinc.codegenerator.exceptions.*;

/*************************************************************************
 *  <pre>
 *
 *  Generated Class: VExcelPositionBase.java
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
public class VExcelPositionBase extends BaseOracleDbEntityClass <VExcelPositionTo> {

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
private java.lang.String LAST_NAME = null;
private java.lang.String BANK_NAME = null;
private java.lang.String SECURITY_SYMBOL = null;
private java.math.BigDecimal QUANTITY = null;


   /**********************************************************
    *
    *  Default Constructor
    *
    ***********************************************************/
   public VExcelPositionBase( ) {

      if (getDbEntityName() == null) {
         setDbEntityName("V_EXCEL_POSITION");
      }

      columnsCommaDelimitedList = " ACCOUNT_ID"
   + ",BANK_ID"
   + ",ACCOUNT_NUMBER"
   + ",FIRST_NAME"
   + ",LAST_NAME"
   + ",BANK_NAME"
   + ",SECURITY_SYMBOL"
   + ",QUANTITY"
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

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "SECURITY_SYMBOL" );
      dbColumn.setORDINAL_POSITION( 7 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "QUANTITY" );
      dbColumn.setORDINAL_POSITION( 8 );
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
   public VExcelPositionBase( Connection connection ) {
      this(); //chain default constructor
      this.connection = connection;
   }

   /**********************************************************
    *
    *  Constructor
    *
    ***********************************************************/
   public VExcelPositionBase( String underlyingEntityName ) {
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
   public java.lang.String getLAST_NAME( ) {
      return this.LAST_NAME;
   }
   public java.lang.String getBANK_NAME( ) {
      return this.BANK_NAME;
   }
   public java.lang.String getSECURITY_SYMBOL( ) {
      return this.SECURITY_SYMBOL;
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

                     this.ACCOUNT_ID = this.resultSet.getString(1);
            this.BANK_ID = this.resultSet.getBigDecimal(2);
            this.ACCOUNT_NUMBER = this.resultSet.getBigDecimal(3);
            this.FIRST_NAME = this.resultSet.getString(4);
            this.LAST_NAME = this.resultSet.getString(5);
            this.BANK_NAME = this.resultSet.getString(6);
            this.SECURITY_SYMBOL = this.resultSet.getString(7);
            this.QUANTITY = this.resultSet.getBigDecimal(8);
   
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
            this.LAST_NAME = this.resultSet.getString(5);
            this.BANK_NAME = this.resultSet.getString(6);
            this.SECURITY_SYMBOL = this.resultSet.getString(7);
            this.QUANTITY = this.resultSet.getBigDecimal(8);
   
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
            this.LAST_NAME = this.resultSet.getString(5);
            this.BANK_NAME = this.resultSet.getString(6);
            this.SECURITY_SYMBOL = this.resultSet.getString(7);
            this.QUANTITY = this.resultSet.getBigDecimal(8);
   

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
   public VExcelPositionTo getTo() {
      VExcelPositionTo vExcelPositionTo = new VExcelPositionTo();

            vExcelPositionTo.setACCOUNT_ID(this.ACCOUNT_ID);
      vExcelPositionTo.setBANK_ID(this.BANK_ID);
      vExcelPositionTo.setACCOUNT_NUMBER(this.ACCOUNT_NUMBER);
      vExcelPositionTo.setFIRST_NAME(this.FIRST_NAME);
      vExcelPositionTo.setLAST_NAME(this.LAST_NAME);
      vExcelPositionTo.setBANK_NAME(this.BANK_NAME);
      vExcelPositionTo.setSECURITY_SYMBOL(this.SECURITY_SYMBOL);
      vExcelPositionTo.setQUANTITY(this.QUANTITY);


      return vExcelPositionTo;
   }

   /*************************************************************************
    *
    * Copies data from Transfer Object PK columns to corresponding columns
    * of database object
    *
    *************************************************************************/
    public void setPkValuesFromTo(VExcelPositionTo vExcelPositionTo) throws GDAOException {

      

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

      String SQL = "DELETE FROM V_EXCEL_POSITION WHERE ";
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
    public ArrayList<VExcelPositionTo> getToArrayEntireResultSet() throws GDAOException {
       ArrayList<VExcelPositionTo> toArray = new ArrayList<VExcelPositionTo>();
       while (next()) {
          VExcelPositionTo vExcelPositionTo = getTo();
          toArray.add(vExcelPositionTo);
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
   public ArrayList<VExcelPositionTo> getToArray(int arraySize) throws GDAOException {
      int i = 0;
      ArrayList <VExcelPositionTo> toArray = new ArrayList<VExcelPositionTo>();
      try {
         while (i < arraySize) {
            if (!this.resultSet.isLast() && !this.resultSet.isAfterLast() && this.getResultSetRowCount() > 0) {
               next();
               VExcelPositionTo vExcelPositionTo = getTo();
               toArray.add(vExcelPositionTo);
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
   public ArrayList <VExcelPositionTo> getToArray(String what) throws GDAOException {
      ArrayList <VExcelPositionTo> toArray = new ArrayList<VExcelPositionTo>();
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
   public void setThisFromTo(VExcelPositionTo vExcelPositionTo) throws GDAOException {

            this.setACCOUNT_ID(vExcelPositionTo.getACCOUNT_ID());
      this.setBANK_ID(vExcelPositionTo.getBANK_ID());
      this.setACCOUNT_NUMBER(vExcelPositionTo.getACCOUNT_NUMBER());
      this.setFIRST_NAME(vExcelPositionTo.getFIRST_NAME());
      this.setLAST_NAME(vExcelPositionTo.getLAST_NAME());
      this.setBANK_NAME(vExcelPositionTo.getBANK_NAME());
      this.setSECURITY_SYMBOL(vExcelPositionTo.getSECURITY_SYMBOL());
      this.setQUANTITY(vExcelPositionTo.getQUANTITY());


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
       + fieldDelimiter + this.getLAST_NAME()
       + fieldDelimiter + this.getBANK_NAME()
       + fieldDelimiter + this.getSECURITY_SYMBOL()
       + fieldDelimiter + this.getQUANTITY()
);
      return;
   }

   /*************************************************************************
    *
    * Prints Transfer Object
    *
    *************************************************************************/
   public static void print(VExcelPositionTo vExcelPositionTo, String fieldDelimiter) {
      System.out.println(      vExcelPositionTo.getACCOUNT_ID()
       + fieldDelimiter + vExcelPositionTo.getBANK_ID()
       + fieldDelimiter + vExcelPositionTo.getACCOUNT_NUMBER()
       + fieldDelimiter + vExcelPositionTo.getFIRST_NAME()
       + fieldDelimiter + vExcelPositionTo.getLAST_NAME()
       + fieldDelimiter + vExcelPositionTo.getBANK_NAME()
       + fieldDelimiter + vExcelPositionTo.getSECURITY_SYMBOL()
       + fieldDelimiter + vExcelPositionTo.getQUANTITY()
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