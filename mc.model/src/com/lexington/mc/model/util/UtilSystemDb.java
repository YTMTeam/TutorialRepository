package com.lexington.mc.model.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class UtilSystemDb {

   public void rebuildSystem(Connection connection, String query) throws SQLException {

      CallableStatement cs = connection.prepareCall(query);
      cs.execute();
      cs.close();

   }
}
