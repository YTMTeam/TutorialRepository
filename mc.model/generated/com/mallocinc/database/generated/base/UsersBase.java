package com.mallocinc.database.generated.base;

import java.sql.*;
import java.io.*;
import com.mallocinc.codegenerator.superclasses.oracle.*;
import java.util.ArrayList;
import java.util.Arrays;

import com.mallocinc.database.generated.to.UsersTo;
import com.mallocinc.codegenerator.exceptions.*;

/*************************************************************************
 *  <pre>
 *
 *  Generated Class: UsersBase.java
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
public class UsersBase extends BaseOracleDbEntityClass <UsersTo> {

   /**********************************************************************
    *
    *  Database Variables declarations
    *  They represent database columns
    *
    **********************************************************************/
   private java.math.BigDecimal USER_ID = null;
private java.math.BigDecimal BANK_ID = null;
private java.lang.String USER_NAME = null;


   /**********************************************************
    *
    *  Default Constructor
    *
    ***********************************************************/
   public UsersBase( ) {

      if (getDbEntityName() == null) {
         setDbEntityName("USERS");
      }

      columnsCommaDelimitedList = " USER_ID"
   + ",BANK_ID"
   + ",USER_NAME"
   ;

      setSelectAllSQL();

      setDbEntityType("TABLE");

      OracleDbColumn dbColumn = null;

         dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "USER_ID" );
      dbColumn.setORDINAL_POSITION( 1 );
      dbColumn.setTYPE_NAME( "NUMBER" );
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
      dbColumn.setCOLUMN_NAME( "USER_NAME" );
      dbColumn.setORDINAL_POSITION( 3 );
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
   public UsersBase( Connection connection ) {
      this(); //chain default constructor
      this.connection = connection;
   }

   /**********************************************************
    *
    *  Constructor
    *
    ***********************************************************/
   public UsersBase( String underlyingEntityName ) {
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
    
   public void setUSER_ID( java.math.BigDecimal value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.USER_ID == null && value == null) || 
         (this.USER_ID != null && this.USER_ID.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.USER_ID = value;
      if ( this.changedColumns.get( "USER_ID" ) == null )  {
         this.changedColumns.put( "USER_ID", "java.math.BigDecimal" );
         this.setDbColumnChangedFlag("USER_ID", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateBigDecimal(getDbColumn("USER_ID").getORDINAL_POSITION(), value);
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

   public void setUSER_NAME( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.USER_NAME == null && value == null) || 
         (this.USER_NAME != null && this.USER_NAME.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.USER_NAME = value;
      if ( this.changedColumns.get( "USER_NAME" ) == null )  {
         this.changedColumns.put( "USER_NAME", "java.lang.String" );
         this.setDbColumnChangedFlag("USER_NAME", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("USER_NAME").getORDINAL_POSITION(), value);
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
    public java.math.BigDecimal getUSER_ID( ) {
      return this.USER_ID;
   }
   public java.math.BigDecimal getBANK_ID( ) {
      return this.BANK_ID;
   }
   public java.lang.String getUSER_NAME( ) {
      return this.USER_NAME;
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

                     this.USER_ID = this.resultSet.getBigDecimal(1);
            this.BANK_ID = this.resultSet.getBigDecimal(2);
            this.USER_NAME = this.resultSet.getString(3);
   
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

                     this.USER_ID = this.resultSet.getBigDecimal(1);
            this.BANK_ID = this.resultSet.getBigDecimal(2);
            this.USER_NAME = this.resultSet.getString(3);
   
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

                    this.USER_ID = this.resultSet.getBigDecimal(1);
            this.BANK_ID = this.resultSet.getBigDecimal(2);
            this.USER_NAME = this.resultSet.getString(3);
   

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
   public UsersTo getTo() {
      UsersTo usersTo = new UsersTo();

            usersTo.setUSER_ID(this.USER_ID);
      usersTo.setBANK_ID(this.BANK_ID);
      usersTo.setUSER_NAME(this.USER_NAME);


      return usersTo;
   }

   /*************************************************************************
    *
    * Copies data from Transfer Object PK columns to corresponding columns
    * of database object
    *
    *************************************************************************/
    public void setPkValuesFromTo(UsersTo usersTo) throws GDAOException {

            this.setUSER_ID(usersTo.getUSER_ID());


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

      String SQL = "DELETE FROM USERS WHERE ";
      SQL = SQL + "USER_ID = ? ";

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
    public ArrayList<UsersTo> getToArrayEntireResultSet() throws GDAOException {
       ArrayList<UsersTo> toArray = new ArrayList<UsersTo>();
       while (next()) {
          UsersTo usersTo = getTo();
          toArray.add(usersTo);
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
   public ArrayList<UsersTo> getToArray(int arraySize) throws GDAOException {
      int i = 0;
      ArrayList <UsersTo> toArray = new ArrayList<UsersTo>();
      try {
         while (i < arraySize) {
            if (!this.resultSet.isLast() && !this.resultSet.isAfterLast() && this.getResultSetRowCount() > 0) {
               next();
               UsersTo usersTo = getTo();
               toArray.add(usersTo);
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
   public ArrayList <UsersTo> getToArray(String what) throws GDAOException {
      ArrayList <UsersTo> toArray = new ArrayList<UsersTo>();
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
   public void setThisFromTo(UsersTo usersTo) throws GDAOException {

            this.setUSER_ID(usersTo.getUSER_ID());
      this.setBANK_ID(usersTo.getBANK_ID());
      this.setUSER_NAME(usersTo.getUSER_NAME());


      return;
   }

   /*************************************************************************
    *
    * Prints values of This Object
    *
    *************************************************************************/
   public void print(String fieldDelimiter) {
      System.out.println(      this.getUSER_ID()
       + fieldDelimiter + this.getBANK_ID()
       + fieldDelimiter + this.getUSER_NAME()
);
      return;
   }

   /*************************************************************************
    *
    * Prints Transfer Object
    *
    *************************************************************************/
   public static void print(UsersTo usersTo, String fieldDelimiter) {
      System.out.println(      usersTo.getUSER_ID()
       + fieldDelimiter + usersTo.getBANK_ID()
       + fieldDelimiter + usersTo.getUSER_NAME()
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