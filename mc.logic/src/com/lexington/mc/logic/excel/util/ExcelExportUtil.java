package com.lexington.mc.logic.excel.util;


import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class ExcelExportUtil {
	public CellStyle getStyle(String styleName, Workbook workbook) {
		Map<String, CellStyle> styles = new HashMap<String, CellStyle>();

		CellStyle headerStyle;
		Font headerFont = workbook.createFont();
		headerStyle = createBorderedStyle(workbook);
		headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
		headerStyle.setAlignment(CellStyle.ALIGN_CENTER);
		headerStyle.setFont(headerFont);
		headerStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		headerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);	
		styles.put("Header", headerStyle);

		CellStyle dataStyle;
		dataStyle = createBorderedStyle(workbook);
		dataStyle.setAlignment(CellStyle.ALIGN_CENTER);

		styles.put("Data", dataStyle);

		switch (styleName) {
		case "Header": {
			return styles.get("Header");
		}
		case "Data": {
			return styles.get("Data");
		}
		default: {
			return styles.get("Data");
		}
		}
	}

	private static CellStyle createBorderedStyle(Workbook wb) {
		CellStyle style = wb.createCellStyle();
		style.setBorderRight(CellStyle.BORDER_THIN);
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderLeft(CellStyle.BORDER_THIN);
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderTop(CellStyle.BORDER_THIN);
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		return style;
	}
	public void exportValueIntoExcel(String value,int columnInt, Workbook workbook, XSSFRow currentRow) {

		XSSFCell cell = currentRow.createCell(columnInt);
		if(value!=null) {
		cell.setCellValue(value);
		}
		
		cell.setCellStyle(getStyle("Data", workbook));
	}
}
