package com.mallocinc.database.generated.base;

import java.sql.*;
import java.io.*;
import com.mallocinc.codegenerator.superclasses.oracle.*;
import java.util.ArrayList;
import java.util.Arrays;

import com.mallocinc.database.generated.to.VMonitoredAccountsTo;
import com.mallocinc.codegenerator.exceptions.*;

/*************************************************************************
 *  <pre>
 *
 *  Generated Class: VMonitoredAccountsBase.java
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
public class VMonitoredAccountsBase extends BaseOracleDbEntityClass <VMonitoredAccountsTo> {

   /**********************************************************************
    *
    *  Database Variables declarations
    *  They represent database columns
    *
    **********************************************************************/
   private java.lang.String MONITOR_ID = null;
private java.lang.String ACCOUNT_ID = null;
private java.math.BigDecimal MONITOR_BANK_ID = null;
private java.lang.String MONITOR_BANK_NAME = null;
private java.math.BigDecimal ACCOUNT_FIRST_NAME = null;
private java.lang.String ACCOUNT_LAST_NAME = null;
private java.lang.String ACCOUNT_BANK_ID = null;
private java.math.BigDecimal ACCOUNT_BANK_NAME = null;
private java.lang.String EMPLOYEE_ID = null;
private java.lang.String EMPLOYEE_FIRST_NAME = null;
private java.lang.String EMPLOYEE_LAST_NAME = null;
private java.lang.String EMPLOYEE_BANK_NAME = null;
private java.lang.String MONITOR_PERMISSION_DATE = null;
private java.sql.Timestamp MONITOR_AS_OF_DATE = null;
private java.sql.Timestamp MONITOR_END_DATE = null;
private java.sql.Timestamp MONITOR_COMMENT = null;
private java.lang.String MONITOR_STATUS = null;


   /**********************************************************
    *
    *  Default Constructor
    *
    ***********************************************************/
   public VMonitoredAccountsBase( ) {

      if (getDbEntityName() == null) {
         setDbEntityName("V_MONITORED_ACCOUNTS");
      }

      columnsCommaDelimitedList = " MONITOR_ID"
   + ",ACCOUNT_ID"
   + ",MONITOR_BANK_ID"
   + ",MONITOR_BANK_NAME"
   + ",ACCOUNT_FIRST_NAME"
   + ",ACCOUNT_LAST_NAME"
   + ",ACCOUNT_BANK_ID"
   + ",ACCOUNT_BANK_NAME"
   + ",EMPLOYEE_ID"
   + ",EMPLOYEE_FIRST_NAME"
   + ",EMPLOYEE_LAST_NAME"
   + ",EMPLOYEE_BANK_NAME"
   + ",MONITOR_PERMISSION_DATE"
   + ",MONITOR_AS_OF_DATE"
   + ",MONITOR_END_DATE"
   + ",MONITOR_COMMENT"
   + ",MONITOR_STATUS"
   ;

      setSelectAllSQL();

      setDbEntityType("VIEW");

      OracleDbColumn dbColumn = null;

         dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "MONITOR_ID" );
      dbColumn.setORDINAL_POSITION( 1 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "ACCOUNT_ID" );
      dbColumn.setORDINAL_POSITION( 2 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "MONITOR_BANK_ID" );
      dbColumn.setORDINAL_POSITION( 3 );
      dbColumn.setTYPE_NAME( "NUMBER" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "MONITOR_BANK_NAME" );
      dbColumn.setORDINAL_POSITION( 4 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "YES" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "ACCOUNT_FIRST_NAME" );
      dbColumn.setORDINAL_POSITION( 5 );
      dbColumn.setTYPE_NAME( "NUMBER" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "ACCOUNT_LAST_NAME" );
      dbColumn.setORDINAL_POSITION( 6 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "ACCOUNT_BANK_ID" );
      dbColumn.setORDINAL_POSITION( 7 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "ACCOUNT_BANK_NAME" );
      dbColumn.setORDINAL_POSITION( 8 );
      dbColumn.setTYPE_NAME( "NUMBER" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "EMPLOYEE_ID" );
      dbColumn.setORDINAL_POSITION( 9 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "EMPLOYEE_FIRST_NAME" );
      dbColumn.setORDINAL_POSITION( 10 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "EMPLOYEE_LAST_NAME" );
      dbColumn.setORDINAL_POSITION( 11 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "EMPLOYEE_BANK_NAME" );
      dbColumn.setORDINAL_POSITION( 12 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "MONITOR_PERMISSION_DATE" );
      dbColumn.setORDINAL_POSITION( 13 );
      dbColumn.setTYPE_NAME( "VARCHAR2" );
      dbColumn.setIS_NULLABLE( "YES" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "MONITOR_AS_OF_DATE" );
      dbColumn.setORDINAL_POSITION( 14 );
      dbColumn.setTYPE_NAME( "TIMESTAMP(6)" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "MONITOR_END_DATE" );
      dbColumn.setORDINAL_POSITION( 15 );
      dbColumn.setTYPE_NAME( "DATE" );
      dbColumn.setIS_NULLABLE( "NO" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "MONITOR_COMMENT" );
      dbColumn.setORDINAL_POSITION( 16 );
      dbColumn.setTYPE_NAME( "DATE" );
      dbColumn.setIS_NULLABLE( "YES" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);

   dbColumn = new OracleDbColumn();
      dbColumn.setCOLUMN_NAME( "MONITOR_STATUS" );
      dbColumn.setORDINAL_POSITION( 17 );
      dbColumn.setTYPE_NAME( "CHAR" );
      dbColumn.setIS_NULLABLE( "YES" );
      dbColumn.setREMARKS( null );
      this.addDbColumn(dbColumn);


   }

   /**********************************************************
    *
    *  Constructor
    *
    ***********************************************************/
   public VMonitoredAccountsBase( Connection connection ) {
      this(); //chain default constructor
      this.connection = connection;
   }

   /**********************************************************
    *
    *  Constructor
    *
    ***********************************************************/
   public VMonitoredAccountsBase( String underlyingEntityName ) {
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

   public void setMONITOR_BANK_ID( java.math.BigDecimal value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.MONITOR_BANK_ID == null && value == null) || 
         (this.MONITOR_BANK_ID != null && this.MONITOR_BANK_ID.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.MONITOR_BANK_ID = value;
      if ( this.changedColumns.get( "MONITOR_BANK_ID" ) == null )  {
         this.changedColumns.put( "MONITOR_BANK_ID", "java.math.BigDecimal" );
         this.setDbColumnChangedFlag("MONITOR_BANK_ID", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateBigDecimal(getDbColumn("MONITOR_BANK_ID").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setMONITOR_BANK_NAME( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.MONITOR_BANK_NAME == null && value == null) || 
         (this.MONITOR_BANK_NAME != null && this.MONITOR_BANK_NAME.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.MONITOR_BANK_NAME = value;
      if ( this.changedColumns.get( "MONITOR_BANK_NAME" ) == null )  {
         this.changedColumns.put( "MONITOR_BANK_NAME", "java.lang.String" );
         this.setDbColumnChangedFlag("MONITOR_BANK_NAME", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("MONITOR_BANK_NAME").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setACCOUNT_FIRST_NAME( java.math.BigDecimal value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.ACCOUNT_FIRST_NAME == null && value == null) || 
         (this.ACCOUNT_FIRST_NAME != null && this.ACCOUNT_FIRST_NAME.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.ACCOUNT_FIRST_NAME = value;
      if ( this.changedColumns.get( "ACCOUNT_FIRST_NAME" ) == null )  {
         this.changedColumns.put( "ACCOUNT_FIRST_NAME", "java.math.BigDecimal" );
         this.setDbColumnChangedFlag("ACCOUNT_FIRST_NAME", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateBigDecimal(getDbColumn("ACCOUNT_FIRST_NAME").getORDINAL_POSITION(), value);
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

   public void setACCOUNT_BANK_ID( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.ACCOUNT_BANK_ID == null && value == null) || 
         (this.ACCOUNT_BANK_ID != null && this.ACCOUNT_BANK_ID.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.ACCOUNT_BANK_ID = value;
      if ( this.changedColumns.get( "ACCOUNT_BANK_ID" ) == null )  {
         this.changedColumns.put( "ACCOUNT_BANK_ID", "java.lang.String" );
         this.setDbColumnChangedFlag("ACCOUNT_BANK_ID", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("ACCOUNT_BANK_ID").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setACCOUNT_BANK_NAME( java.math.BigDecimal value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.ACCOUNT_BANK_NAME == null && value == null) || 
         (this.ACCOUNT_BANK_NAME != null && this.ACCOUNT_BANK_NAME.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.ACCOUNT_BANK_NAME = value;
      if ( this.changedColumns.get( "ACCOUNT_BANK_NAME" ) == null )  {
         this.changedColumns.put( "ACCOUNT_BANK_NAME", "java.math.BigDecimal" );
         this.setDbColumnChangedFlag("ACCOUNT_BANK_NAME", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateBigDecimal(getDbColumn("ACCOUNT_BANK_NAME").getORDINAL_POSITION(), value);
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

   public void setEMPLOYEE_FIRST_NAME( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.EMPLOYEE_FIRST_NAME == null && value == null) || 
         (this.EMPLOYEE_FIRST_NAME != null && this.EMPLOYEE_FIRST_NAME.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.EMPLOYEE_FIRST_NAME = value;
      if ( this.changedColumns.get( "EMPLOYEE_FIRST_NAME" ) == null )  {
         this.changedColumns.put( "EMPLOYEE_FIRST_NAME", "java.lang.String" );
         this.setDbColumnChangedFlag("EMPLOYEE_FIRST_NAME", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("EMPLOYEE_FIRST_NAME").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setEMPLOYEE_LAST_NAME( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.EMPLOYEE_LAST_NAME == null && value == null) || 
         (this.EMPLOYEE_LAST_NAME != null && this.EMPLOYEE_LAST_NAME.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.EMPLOYEE_LAST_NAME = value;
      if ( this.changedColumns.get( "EMPLOYEE_LAST_NAME" ) == null )  {
         this.changedColumns.put( "EMPLOYEE_LAST_NAME", "java.lang.String" );
         this.setDbColumnChangedFlag("EMPLOYEE_LAST_NAME", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("EMPLOYEE_LAST_NAME").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setEMPLOYEE_BANK_NAME( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.EMPLOYEE_BANK_NAME == null && value == null) || 
         (this.EMPLOYEE_BANK_NAME != null && this.EMPLOYEE_BANK_NAME.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.EMPLOYEE_BANK_NAME = value;
      if ( this.changedColumns.get( "EMPLOYEE_BANK_NAME" ) == null )  {
         this.changedColumns.put( "EMPLOYEE_BANK_NAME", "java.lang.String" );
         this.setDbColumnChangedFlag("EMPLOYEE_BANK_NAME", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("EMPLOYEE_BANK_NAME").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setMONITOR_PERMISSION_DATE( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.MONITOR_PERMISSION_DATE == null && value == null) || 
         (this.MONITOR_PERMISSION_DATE != null && this.MONITOR_PERMISSION_DATE.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.MONITOR_PERMISSION_DATE = value;
      if ( this.changedColumns.get( "MONITOR_PERMISSION_DATE" ) == null )  {
         this.changedColumns.put( "MONITOR_PERMISSION_DATE", "java.lang.String" );
         this.setDbColumnChangedFlag("MONITOR_PERMISSION_DATE", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("MONITOR_PERMISSION_DATE").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setMONITOR_AS_OF_DATE( java.sql.Timestamp value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.MONITOR_AS_OF_DATE == null && value == null) || 
         (this.MONITOR_AS_OF_DATE != null && this.MONITOR_AS_OF_DATE.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.MONITOR_AS_OF_DATE = value;
      if ( this.changedColumns.get( "MONITOR_AS_OF_DATE" ) == null )  {
         this.changedColumns.put( "MONITOR_AS_OF_DATE", "java.sql.Timestamp" );
         this.setDbColumnChangedFlag("MONITOR_AS_OF_DATE", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateTimestamp(getDbColumn("MONITOR_AS_OF_DATE").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setMONITOR_END_DATE( java.sql.Timestamp value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.MONITOR_END_DATE == null && value == null) || 
         (this.MONITOR_END_DATE != null && this.MONITOR_END_DATE.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.MONITOR_END_DATE = value;
      if ( this.changedColumns.get( "MONITOR_END_DATE" ) == null )  {
         this.changedColumns.put( "MONITOR_END_DATE", "java.sql.Timestamp" );
         this.setDbColumnChangedFlag("MONITOR_END_DATE", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateTimestamp(getDbColumn("MONITOR_END_DATE").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setMONITOR_COMMENT( java.sql.Timestamp value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.MONITOR_COMMENT == null && value == null) || 
         (this.MONITOR_COMMENT != null && this.MONITOR_COMMENT.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.MONITOR_COMMENT = value;
      if ( this.changedColumns.get( "MONITOR_COMMENT" ) == null )  {
         this.changedColumns.put( "MONITOR_COMMENT", "java.sql.Timestamp" );
         this.setDbColumnChangedFlag("MONITOR_COMMENT", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateTimestamp(getDbColumn("MONITOR_COMMENT").getORDINAL_POSITION(), value);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }

   public void setMONITOR_STATUS( java.lang.String value ) throws GDAOException {
      if (!isForceChange() && 
         ((this.MONITOR_STATUS == null && value == null) || 
         (this.MONITOR_STATUS != null && this.MONITOR_STATUS.equals(value)))) {
            /* Value did not change so nothing will be done. */
            return;
      }

      /* Value is changed and column variable will be set: */
      this.MONITOR_STATUS = value;
      if ( this.changedColumns.get( "MONITOR_STATUS" ) == null )  {
         this.changedColumns.put( "MONITOR_STATUS", "java.lang.String" );
         this.setDbColumnChangedFlag("MONITOR_STATUS", true);
      }
      if (isSelectForUpdate() && this.resultSet != null) {
         try {
            this.resultSet.updateString(getDbColumn("MONITOR_STATUS").getORDINAL_POSITION(), value);
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
   public java.math.BigDecimal getMONITOR_BANK_ID( ) {
      return this.MONITOR_BANK_ID;
   }
   public java.lang.String getMONITOR_BANK_NAME( ) {
      return this.MONITOR_BANK_NAME;
   }
   public java.math.BigDecimal getACCOUNT_FIRST_NAME( ) {
      return this.ACCOUNT_FIRST_NAME;
   }
   public java.lang.String getACCOUNT_LAST_NAME( ) {
      return this.ACCOUNT_LAST_NAME;
   }
   public java.lang.String getACCOUNT_BANK_ID( ) {
      return this.ACCOUNT_BANK_ID;
   }
   public java.math.BigDecimal getACCOUNT_BANK_NAME( ) {
      return this.ACCOUNT_BANK_NAME;
   }
   public java.lang.String getEMPLOYEE_ID( ) {
      return this.EMPLOYEE_ID;
   }
   public java.lang.String getEMPLOYEE_FIRST_NAME( ) {
      return this.EMPLOYEE_FIRST_NAME;
   }
   public java.lang.String getEMPLOYEE_LAST_NAME( ) {
      return this.EMPLOYEE_LAST_NAME;
   }
   public java.lang.String getEMPLOYEE_BANK_NAME( ) {
      return this.EMPLOYEE_BANK_NAME;
   }
   public java.lang.String getMONITOR_PERMISSION_DATE( ) {
      return this.MONITOR_PERMISSION_DATE;
   }
   public java.sql.Timestamp getMONITOR_AS_OF_DATE( ) {
      return this.MONITOR_AS_OF_DATE;
   }
   public java.sql.Timestamp getMONITOR_END_DATE( ) {
      return this.MONITOR_END_DATE;
   }
   public java.sql.Timestamp getMONITOR_COMMENT( ) {
      return this.MONITOR_COMMENT;
   }
   public java.lang.String getMONITOR_STATUS( ) {
      return this.MONITOR_STATUS;
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
            this.MONITOR_BANK_ID = this.resultSet.getBigDecimal(3);
            this.MONITOR_BANK_NAME = this.resultSet.getString(4);
            this.ACCOUNT_FIRST_NAME = this.resultSet.getBigDecimal(5);
            this.ACCOUNT_LAST_NAME = this.resultSet.getString(6);
            this.ACCOUNT_BANK_ID = this.resultSet.getString(7);
            this.ACCOUNT_BANK_NAME = this.resultSet.getBigDecimal(8);
            this.EMPLOYEE_ID = this.resultSet.getString(9);
            this.EMPLOYEE_FIRST_NAME = this.resultSet.getString(10);
            this.EMPLOYEE_LAST_NAME = this.resultSet.getString(11);
            this.EMPLOYEE_BANK_NAME = this.resultSet.getString(12);
            this.MONITOR_PERMISSION_DATE = this.resultSet.getString(13);
            this.MONITOR_AS_OF_DATE = this.resultSet.getTimestamp(14);
            this.MONITOR_END_DATE = this.resultSet.getTimestamp(15);
            this.MONITOR_COMMENT = this.resultSet.getTimestamp(16);
            this.MONITOR_STATUS = this.resultSet.getString(17);
   
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
            this.MONITOR_BANK_ID = this.resultSet.getBigDecimal(3);
            this.MONITOR_BANK_NAME = this.resultSet.getString(4);
            this.ACCOUNT_FIRST_NAME = this.resultSet.getBigDecimal(5);
            this.ACCOUNT_LAST_NAME = this.resultSet.getString(6);
            this.ACCOUNT_BANK_ID = this.resultSet.getString(7);
            this.ACCOUNT_BANK_NAME = this.resultSet.getBigDecimal(8);
            this.EMPLOYEE_ID = this.resultSet.getString(9);
            this.EMPLOYEE_FIRST_NAME = this.resultSet.getString(10);
            this.EMPLOYEE_LAST_NAME = this.resultSet.getString(11);
            this.EMPLOYEE_BANK_NAME = this.resultSet.getString(12);
            this.MONITOR_PERMISSION_DATE = this.resultSet.getString(13);
            this.MONITOR_AS_OF_DATE = this.resultSet.getTimestamp(14);
            this.MONITOR_END_DATE = this.resultSet.getTimestamp(15);
            this.MONITOR_COMMENT = this.resultSet.getTimestamp(16);
            this.MONITOR_STATUS = this.resultSet.getString(17);
   
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
            this.MONITOR_BANK_ID = this.resultSet.getBigDecimal(3);
            this.MONITOR_BANK_NAME = this.resultSet.getString(4);
            this.ACCOUNT_FIRST_NAME = this.resultSet.getBigDecimal(5);
            this.ACCOUNT_LAST_NAME = this.resultSet.getString(6);
            this.ACCOUNT_BANK_ID = this.resultSet.getString(7);
            this.ACCOUNT_BANK_NAME = this.resultSet.getBigDecimal(8);
            this.EMPLOYEE_ID = this.resultSet.getString(9);
            this.EMPLOYEE_FIRST_NAME = this.resultSet.getString(10);
            this.EMPLOYEE_LAST_NAME = this.resultSet.getString(11);
            this.EMPLOYEE_BANK_NAME = this.resultSet.getString(12);
            this.MONITOR_PERMISSION_DATE = this.resultSet.getString(13);
            this.MONITOR_AS_OF_DATE = this.resultSet.getTimestamp(14);
            this.MONITOR_END_DATE = this.resultSet.getTimestamp(15);
            this.MONITOR_COMMENT = this.resultSet.getTimestamp(16);
            this.MONITOR_STATUS = this.resultSet.getString(17);
   

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
   public VMonitoredAccountsTo getTo() {
      VMonitoredAccountsTo vMonitoredAccountsTo = new VMonitoredAccountsTo();

            vMonitoredAccountsTo.setMONITOR_ID(this.MONITOR_ID);
      vMonitoredAccountsTo.setACCOUNT_ID(this.ACCOUNT_ID);
      vMonitoredAccountsTo.setMONITOR_BANK_ID(this.MONITOR_BANK_ID);
      vMonitoredAccountsTo.setMONITOR_BANK_NAME(this.MONITOR_BANK_NAME);
      vMonitoredAccountsTo.setACCOUNT_FIRST_NAME(this.ACCOUNT_FIRST_NAME);
      vMonitoredAccountsTo.setACCOUNT_LAST_NAME(this.ACCOUNT_LAST_NAME);
      vMonitoredAccountsTo.setACCOUNT_BANK_ID(this.ACCOUNT_BANK_ID);
      vMonitoredAccountsTo.setACCOUNT_BANK_NAME(this.ACCOUNT_BANK_NAME);
      vMonitoredAccountsTo.setEMPLOYEE_ID(this.EMPLOYEE_ID);
      vMonitoredAccountsTo.setEMPLOYEE_FIRST_NAME(this.EMPLOYEE_FIRST_NAME);
      vMonitoredAccountsTo.setEMPLOYEE_LAST_NAME(this.EMPLOYEE_LAST_NAME);
      vMonitoredAccountsTo.setEMPLOYEE_BANK_NAME(this.EMPLOYEE_BANK_NAME);
      vMonitoredAccountsTo.setMONITOR_PERMISSION_DATE(this.MONITOR_PERMISSION_DATE);
      vMonitoredAccountsTo.setMONITOR_AS_OF_DATE(this.MONITOR_AS_OF_DATE);
      vMonitoredAccountsTo.setMONITOR_END_DATE(this.MONITOR_END_DATE);
      vMonitoredAccountsTo.setMONITOR_COMMENT(this.MONITOR_COMMENT);
      vMonitoredAccountsTo.setMONITOR_STATUS(this.MONITOR_STATUS);


      return vMonitoredAccountsTo;
   }

   /*************************************************************************
    *
    * Copies data from Transfer Object PK columns to corresponding columns
    * of database object
    *
    *************************************************************************/
    public void setPkValuesFromTo(VMonitoredAccountsTo vMonitoredAccountsTo) throws GDAOException {

      

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

      String SQL = "DELETE FROM V_MONITORED_ACCOUNTS WHERE ";
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
    public ArrayList<VMonitoredAccountsTo> getToArrayEntireResultSet() throws GDAOException {
       ArrayList<VMonitoredAccountsTo> toArray = new ArrayList<VMonitoredAccountsTo>();
       while (next()) {
          VMonitoredAccountsTo vMonitoredAccountsTo = getTo();
          toArray.add(vMonitoredAccountsTo);
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
   public ArrayList<VMonitoredAccountsTo> getToArray(int arraySize) throws GDAOException {
      int i = 0;
      ArrayList <VMonitoredAccountsTo> toArray = new ArrayList<VMonitoredAccountsTo>();
      try {
         while (i < arraySize) {
            if (!this.resultSet.isLast() && !this.resultSet.isAfterLast() && this.getResultSetRowCount() > 0) {
               next();
               VMonitoredAccountsTo vMonitoredAccountsTo = getTo();
               toArray.add(vMonitoredAccountsTo);
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
   public ArrayList <VMonitoredAccountsTo> getToArray(String what) throws GDAOException {
      ArrayList <VMonitoredAccountsTo> toArray = new ArrayList<VMonitoredAccountsTo>();
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
   public void setThisFromTo(VMonitoredAccountsTo vMonitoredAccountsTo) throws GDAOException {

            this.setMONITOR_ID(vMonitoredAccountsTo.getMONITOR_ID());
      this.setACCOUNT_ID(vMonitoredAccountsTo.getACCOUNT_ID());
      this.setMONITOR_BANK_ID(vMonitoredAccountsTo.getMONITOR_BANK_ID());
      this.setMONITOR_BANK_NAME(vMonitoredAccountsTo.getMONITOR_BANK_NAME());
      this.setACCOUNT_FIRST_NAME(vMonitoredAccountsTo.getACCOUNT_FIRST_NAME());
      this.setACCOUNT_LAST_NAME(vMonitoredAccountsTo.getACCOUNT_LAST_NAME());
      this.setACCOUNT_BANK_ID(vMonitoredAccountsTo.getACCOUNT_BANK_ID());
      this.setACCOUNT_BANK_NAME(vMonitoredAccountsTo.getACCOUNT_BANK_NAME());
      this.setEMPLOYEE_ID(vMonitoredAccountsTo.getEMPLOYEE_ID());
      this.setEMPLOYEE_FIRST_NAME(vMonitoredAccountsTo.getEMPLOYEE_FIRST_NAME());
      this.setEMPLOYEE_LAST_NAME(vMonitoredAccountsTo.getEMPLOYEE_LAST_NAME());
      this.setEMPLOYEE_BANK_NAME(vMonitoredAccountsTo.getEMPLOYEE_BANK_NAME());
      this.setMONITOR_PERMISSION_DATE(vMonitoredAccountsTo.getMONITOR_PERMISSION_DATE());
      this.setMONITOR_AS_OF_DATE(vMonitoredAccountsTo.getMONITOR_AS_OF_DATE());
      this.setMONITOR_END_DATE(vMonitoredAccountsTo.getMONITOR_END_DATE());
      this.setMONITOR_COMMENT(vMonitoredAccountsTo.getMONITOR_COMMENT());
      this.setMONITOR_STATUS(vMonitoredAccountsTo.getMONITOR_STATUS());


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
       + fieldDelimiter + this.getMONITOR_BANK_ID()
       + fieldDelimiter + this.getMONITOR_BANK_NAME()
       + fieldDelimiter + this.getACCOUNT_FIRST_NAME()
       + fieldDelimiter + this.getACCOUNT_LAST_NAME()
       + fieldDelimiter + this.getACCOUNT_BANK_ID()
       + fieldDelimiter + this.getACCOUNT_BANK_NAME()
       + fieldDelimiter + this.getEMPLOYEE_ID()
       + fieldDelimiter + this.getEMPLOYEE_FIRST_NAME()
       + fieldDelimiter + this.getEMPLOYEE_LAST_NAME()
       + fieldDelimiter + this.getEMPLOYEE_BANK_NAME()
       + fieldDelimiter + this.getMONITOR_PERMISSION_DATE()
       + fieldDelimiter + this.getMONITOR_AS_OF_DATE()
       + fieldDelimiter + this.getMONITOR_END_DATE()
       + fieldDelimiter + this.getMONITOR_COMMENT()
       + fieldDelimiter + this.getMONITOR_STATUS()
);
      return;
   }

   /*************************************************************************
    *
    * Prints Transfer Object
    *
    *************************************************************************/
   public static void print(VMonitoredAccountsTo vMonitoredAccountsTo, String fieldDelimiter) {
      System.out.println(      vMonitoredAccountsTo.getMONITOR_ID()
       + fieldDelimiter + vMonitoredAccountsTo.getACCOUNT_ID()
       + fieldDelimiter + vMonitoredAccountsTo.getMONITOR_BANK_ID()
       + fieldDelimiter + vMonitoredAccountsTo.getMONITOR_BANK_NAME()
       + fieldDelimiter + vMonitoredAccountsTo.getACCOUNT_FIRST_NAME()
       + fieldDelimiter + vMonitoredAccountsTo.getACCOUNT_LAST_NAME()
       + fieldDelimiter + vMonitoredAccountsTo.getACCOUNT_BANK_ID()
       + fieldDelimiter + vMonitoredAccountsTo.getACCOUNT_BANK_NAME()
       + fieldDelimiter + vMonitoredAccountsTo.getEMPLOYEE_ID()
       + fieldDelimiter + vMonitoredAccountsTo.getEMPLOYEE_FIRST_NAME()
       + fieldDelimiter + vMonitoredAccountsTo.getEMPLOYEE_LAST_NAME()
       + fieldDelimiter + vMonitoredAccountsTo.getEMPLOYEE_BANK_NAME()
       + fieldDelimiter + vMonitoredAccountsTo.getMONITOR_PERMISSION_DATE()
       + fieldDelimiter + vMonitoredAccountsTo.getMONITOR_AS_OF_DATE()
       + fieldDelimiter + vMonitoredAccountsTo.getMONITOR_END_DATE()
       + fieldDelimiter + vMonitoredAccountsTo.getMONITOR_COMMENT()
       + fieldDelimiter + vMonitoredAccountsTo.getMONITOR_STATUS()
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