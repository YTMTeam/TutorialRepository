package com.lexington.mc.logic.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.mallocinc.codegenerator.exceptions.GDAOException;
import com.mallocinc.shared.util.time.TimestampUtility;

public class Connect {
   final static Logger log      = Logger.getLogger(Connection.class.getName());
   private static int  connFlag = 0;

   private static Connection connection = null;

   public static DataSource getDataSource(String dataSourceLocation) throws NamingException {
      // Get a context for the JNDI look up
      Context ctx = new InitialContext();
      Context envContext = (Context) ctx.lookup("java:/comp/env");

      // Look up a data source
      javax.sql.DataSource ds = (javax.sql.DataSource) envContext.lookup(dataSourceLocation);

      return ds;
   }

   private static Connection getConnection() throws GDAOException {
      String dataSourceLocation = "jdbc/UCPPool";
      Connection conn = null;

      // Get a connection object
      try {
         DataSource ds = getDataSource(dataSourceLocation);
         conn = ds.getConnection();
      } catch (SQLException e) {
         throw new GDAOException(e);
      } catch (NamingException e) {
         throw new GDAOException(e);
      }

      return conn;
   }

   public static Connection obtainConn(Connection connection) throws MessageException {

      try {
         if (connection == null || connection.isClosed()) {
            connection = Connect.getConnection();
            connection.setAutoCommit(true);
            connFlag++;
            System.out.println(
                  "Connection obtained at " + " " + TimestampUtility.getCurrentTimestamp() + "   Conn flag value:" + connFlag);
         }
      } catch (SQLException e) {
         e.printStackTrace();
         log.error("SQL - Problem while obtaining the connection: ");
         throw new MessageException("db", MessageException.ERROR, "couldNotConnect");
      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("GDAO - Problem when obtaining the connection: " + e.getMessage());
         throw new MessageException("db", MessageException.ERROR, "couldNotConnect");
      }

      return connection;
   }
   
// public static Connection obtainConn(Connection connection) throws MessageException {
// Connection conn = null;
// try {
//     Class.forName("oracle.jdbc.OracleDriver");
// } catch (ClassNotFoundException e) {
//     // TODO Auto-generated catch block
//     e.printStackTrace();
// }
// try {
//     conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","C##lex","C##lex");
//     System.out.println("Connected");
// } catch (SQLException e) {
//     // TODO Auto-generated catch block
//     e.printStackTrace();
// }
// return conn;
//}

   public static Connection obtainConn() throws MessageException {

      try {
         if (connection == null || connection.isClosed()) {
            connection = Connect.getConnection();
            connFlag++;
            System.out.println(
                  "Connection obtained at " + " " + TimestampUtility.getCurrentTimestamp() + "   Conn flag value:" + connFlag);
         }
      } catch (SQLException e) {
         e.printStackTrace();
         log.error("SQL - Problem while obtaining the connection: ");
         throw new MessageException("db", MessageException.ERROR, "couldNotConnect");
      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("GDAO - Problem when obtaining the connection: " + e.getMessage());
         throw new MessageException("db", MessageException.ERROR, "couldNotConnect");
      }
      return connection;
   }

   public static void returnConn(Connection connection) {

      try {
         if (connection != null && !connection.isClosed()) {
            connection.close();
            connFlag--;
            System.out.println(
                  "Connection returned at " + " " + TimestampUtility.getCurrentTimestamp() + "   Conn flag value:" + connFlag);
         }
      } catch (SQLException e) {
         e.printStackTrace();
         log.error("SQL - Problem while closing the connection: " + e.getMessage());
      }
   }

   public static void rethrowExceptionAndTryRollback(Connection conn, String taskName, Throwable e) throws MessageException {
      tryRollback(conn, taskName);
      rethrowException(conn, taskName, e);
   }

   public static void tryRollback(Connection conn, String taskName) {
      try {
         conn.rollback();
      } catch (SQLException ex) {
         log.error("GDAO Error: Unable to rollback '" + taskName + "'", ex);
      }
   }

   public static void rethrowException(Connection conn, String taskName, Throwable e) throws MessageException {
      log.error("GDAO Error: Unable to '" + taskName + "'", e);
      throw new MessageException("somethingWentWrong");
   }

}