package com.lexington.mc.logic.excel.export;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;


import com.lexington.mc.logic.excel.util.BaseTableExporter;
import com.lexington.mc.logic.excel.util.ExportIgnoreFields;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.views.DataVExcelTrade;
import com.mallocinc.codegenerator.exceptions.GDAOException;
import com.mallocinc.database.generated.working.VExcelTradeTab;


public class TradeTableExporter extends BaseTableExporter {

   DataVExcelTrade  			 excelVTrade	 = new DataVExcelTrade();


   public byte[] exportByAccount(String userId, Connection conn) throws MessageException {
         VExcelTradeTab tab = null;
         ResultSet rs = null;
//         Statement statement = null;
         try {
//            statement = conn.createStatement();
            tab = excelVTrade.getExcelDataForAccount(conn, userId);
            rs = tab.getResultSet();
         } catch (GDAOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new MessageException("somethingWentWrong");
         }

         ExcelFetchContents efc = fetchData(rs, ExportIgnoreFields.Trades.TRADES_IGNORE_LIST);
         return exportDataFromDatabaseIntoByteArray("Account Trades",efc);       
      }
   public byte[] exportByGroup(BigDecimal groupId, Connection conn) throws MessageException {
      VExcelTradeTab tab = null;
      ResultSet rs = null;
//      Statement statement = null;
      try {
//         statement = conn.createStatement();
         tab = excelVTrade.getExcelDataForGroup(conn, groupId);
         rs = tab.getResultSet();
      } catch (GDAOException e) {
         e.printStackTrace();
         throw new MessageException("somethingWentWrong");
      }

      ExcelFetchContents efc = fetchData(rs, ExportIgnoreFields.Trades.TRADES_IGNORE_LIST);
      return exportDataFromDatabaseIntoByteArray("Household Trades",efc);       
   }
}
