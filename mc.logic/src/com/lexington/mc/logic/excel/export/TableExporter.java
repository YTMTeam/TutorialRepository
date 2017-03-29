package com.lexington.mc.logic.excel.export;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.views.DataVExcelPayment;
import com.mallocinc.codegenerator.exceptions.GDAOException;
import com.mallocinc.database.generated.samples.excel.AccountExcelSample;
import com.mallocinc.database.generated.working.VExcelTradeTab;


public class TableExporter {

	private static Logger        log          = Logger.getLogger(TableExporter.class.getName());

	DataVExcelPayment  			 excelVPayment	 = new DataVExcelPayment();
	ExcelExportUtil 			 excelExportUtil = new ExcelExportUtil();

	String 						 excelName  	 = null;

	ArrayList<String> 			 headerList 	 = new ArrayList<>();
	ArrayList<ExcelExportEntity> contents 		 = new ArrayList<>();


	public byte[] exportByUser(BigDecimal userId, Connection conn) throws MessageException {
		try {
			excelName = "User Trades";
			fetchData(conn, userId, true);
			try {
			return new AccountExcelSample().createExcelFileAsByteArray(conn, excelName);
			} catch (GDAOException e) {
			   throw new MessageException("somethingWentWrong");
			}
		} catch (MessageException e) {
			throw e;
		}
	}
	public byte[] exportByGroup(BigDecimal groupId, Connection conn) throws MessageException {
		try {
			excelName = "Household Trades";
			fetchData(conn, groupId, false);
			return exportDataFromDatabaseIntoByteArray();
		} catch (MessageException e) {
			throw e;
		}
	}

	public void fetchData(Connection conn, BigDecimal id, boolean byUser) throws MessageException {
		VExcelTradeTab tab = null;
		ResultSet rs = null;
		Statement statement = null;
		try {
			statement = conn.createStatement();
			if(byUser) {
				tab = excelVPayment.getExcelDataForAccount(conn, id);
				rs = tab.getResultSet();
			} else {
				tab = excelVPayment.getExcelDataForGroup(conn, id);
				rs = tab.getResultSet();
			}
			ResultSetMetaData metadata = rs.getMetaData();
			int columnCount = metadata.getColumnCount();    
			for (int i = 6; i <= columnCount; i++) {
				headerList.add(metadata.getColumnName(i).replace("_", " "));
				log.debug(metadata.getColumnName(i)+"   ");
			}
			while (rs.next()) {
				ExcelExportEntity excelEntity = new ExcelExportEntity();
				String row = "";
				for (int i = 6; i <= columnCount; i++) {
					try {
						String data = rs.getString(i);

						row += data + ", "; 
						if(data != null) {
							excelEntity.getRowFields().add(data);
						} else {
							excelEntity.getRowFields().add("");
						}		        	
					} catch(SQLException e) {
						excelEntity.getRowFields().add("Unknown data");
					}
				}
				contents.add(excelEntity);
				log.debug(row);
			}
		} catch (GDAOException | SQLException e) {
			// TODO Auto-generated catch block
			throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
		} finally {
			try {
				statement.close();
				if(tab != null) {
					try {
						tab.releaseStatement();
					} catch (GDAOException e) {
						throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private byte[] exportDataFromDatabaseIntoByteArray() throws MessageException {

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet(excelName);


		//First we create header row using headerList
		XSSFRow rowHeader = sheet.createRow(0);
		ArrayList<String> headerList = this.headerList;
		for (int i = 0; i < headerList.size(); i++) {
			XSSFCell cell = rowHeader.createCell(i);
			cell.setCellValue(headerList.get(i));
			cell.setCellStyle(excelExportUtil.getStyle("Header", workbook));
		}

		//Then we add data
		for (int i = 0; i < contents.size(); i++) {
			XSSFRow rowData = sheet.createRow(i+1);
			ExcelExportEntity content = contents.get(i);
			ArrayList<String> rowField = content.getRowFields();
			for (int j = 0; j < rowField.size(); j++) {
				excelExportUtil.exportValueIntoExcel(rowField.get(j), j, workbook , rowData);
			}
		}

		//finally we autosize columns
		for (int i = 0; i < headerList.size(); i++) {
			sheet.autoSizeColumn(i); 
		}


		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		//write this workbook to an Outputstream.
		try {
			workbook.write(bos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
		} finally {
			try {
			    workbook.close();
				bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		byte[] bytes = bos.toByteArray();
		return bytes;
	}
	public Connection createConnection() {
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523/oracle","C##ytmcl2020","C##ytmcl2020");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}
	public static void main(String[] args) throws FileNotFoundException {
		TableExporter te = new TableExporter();
		Connection conn = te.createConnection();
		try {
			//			te.fetchData(conn, "QUESTION");
			//			te.exportDataFromDatabaseIntoByteArray();
			te.getViews(conn);
		} catch (MessageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	class ExcelExportEntity {
		ArrayList<String> rowFields = new ArrayList<>();

		public ArrayList<String> getRowFields() {
			return rowFields;
		}

		public void setRowFields(ArrayList<String> rowFields) {
			this.rowFields = rowFields;
		}

	}
	public  ArrayList<String> getViews(Connection conn) throws MessageException {
		ArrayList<String> viewList = new ArrayList<>();
		String TABLE_NAME = "TABLE_NAME";
		String[] VIEW_TYPES = {"VIEW"};

		try {
			DatabaseMetaData dbmd = conn.getMetaData();
			ResultSet tables;

			tables = dbmd.getTables(null, null, null, VIEW_TYPES);
			while (tables.next()) {
				String viewName = tables.getString(TABLE_NAME);
				if(viewName.startsWith("V_") && !viewName.startsWith("V_$")) {
					viewList.add(viewName);
				}
				//				          System.out.println(tables.getString(TABLE_SCHEMA));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return viewList;
	}
	/**
	 * Used for testing
	 * @return
	 * @throws MessageException
	 */
	public  ArrayList<String> getViews() throws MessageException {
		ArrayList<String> viewList = new ArrayList<>();
		viewList.add("FUNCTION");
		viewList.add("USERS");
		viewList.add("QUESTION");
		viewList.add("V_USER_ROLES");
		viewList.add("V_CODES");
		return viewList;
	}
}
