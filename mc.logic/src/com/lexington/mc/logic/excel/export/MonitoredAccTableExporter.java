package com.lexington.mc.logic.excel.export;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.lexington.mc.logic.excel.util.BaseTableExporter;
import com.lexington.mc.logic.excel.util.ExportIgnoreFields;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.views.DataVExcelMonitoredAccount;
import com.mallocinc.codegenerator.exceptions.GDAOException;
import com.mallocinc.database.generated.working.VExcelMonitoredAccountsTab;


public class MonitoredAccTableExporter extends BaseTableExporter {

	DataVExcelMonitoredAccount			 excelVMonitoredAccount	 = new DataVExcelMonitoredAccount();


	public byte[] exportAccounts(Connection conn, BigDecimal bankId) throws MessageException {
       VExcelMonitoredAccountsTab tab = null;
       ResultSet rs = null;
//       Statement statement = null;
       try {
//          statement = conn.createStatement();
          tab = excelVMonitoredAccount.getExcelDataForMonitoredAccountsByBankId(conn, bankId);
          rs = tab.getResultSet();
       } catch (GDAOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
          throw new MessageException("somethingWentWrong");
       }

       ExcelFetchContents efc = fetchData(rs, ExportIgnoreFields.Monitors.MONITORS_IGNORE_LIST);
       return exportDataFromDatabaseIntoByteArray("Permissioned accounts",efc);       
    }
}
