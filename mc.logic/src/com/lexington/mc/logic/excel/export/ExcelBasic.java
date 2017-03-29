package com.lexington.mc.logic.excel.export;

import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.lexington.mc.logic.excel.export.AccountFullExporter.ExcelExportEntity;
import com.lexington.mc.logic.excel.util.ExcelExportUtil;

public class ExcelBasic {

	 ExcelExportUtil 			 excelExportUtil = new ExcelExportUtil();
	
	 class ExcelExportEntity {
	      ArrayList<String> rowFields = new ArrayList<>();

	      public ArrayList<String> getRowFields() {
	         return rowFields;
	      }

	      public void setRowFields(ArrayList<String> rowFields) {
	         this.rowFields = rowFields;
	      }

	   }
	 XSSFWorkbook insertData(XSSFWorkbook workbook, ArrayList<String> headerList, ArrayList<ExcelExportEntity> contents, String sheetName) {
	      XSSFSheet sheet = workbook.createSheet(sheetName);

	      //First we create header row using headerList
	      XSSFRow rowHeader = sheet.createRow(0);
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
	      return workbook;
	   }
}
