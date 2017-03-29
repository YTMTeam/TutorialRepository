package com.lexington.mc.logic.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.lexington.mc.model.util.UtilSystemDb;

public class UtilSystemModel {

   final static Logger log = Logger.getLogger(UtilSystemModel.class.getName());

   public void rebuildSystem(String query) throws SQLException, MessageException {

      Connection connection = null;

      try {
         connection = Connect.obtainConn(connection);
         new UtilSystemDb().rebuildSystem(connection, query);
         Connect.returnConn(connection);
      } catch (SQLException e) {
         e.printStackTrace();
         throw e;
      } finally {
         Connect.returnConn(connection);
      }

   }
}
