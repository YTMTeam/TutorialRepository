package com.lexington.mc.logic.excel.export;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.lexington.mc.logic.excel.util.BaseTableExporter;
import com.lexington.mc.logic.excel.util.ExportIgnoreFields;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.views.DataVExcelPosition;
import com.mallocinc.codegenerator.exceptions.GDAOException;
import com.mallocinc.database.generated.working.VExcelPositionTab;


public class PositionTableExporter extends BaseTableExporter {

	private static Logger        log          = Logger.getLogger(PositionTableExporter.class.getName());

	DataVExcelPosition  			 excelVPosition	 = new DataVExcelPosition();

	 public byte[] exportByAccount(String userId, Connection conn) throws MessageException {
        VExcelPositionTab tab = null;
        ResultSet rs = null;
//        Statement statement = null;
        try {
//           statement = conn.createStatement();
           tab = excelVPosition.getExcelDataForPositionbyAccountId(conn, userId);
           rs = tab.getResultSet();
        } catch (GDAOException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
           throw new MessageException("somethingWentWrong");
        }

        ExcelFetchContents efc = fetchData(rs, ExportIgnoreFields.Positions.POSITIONS_IGNORE_LIST);
        return exportDataFromDatabaseIntoByteArray("Positions",efc);       
     }
}