package com.lexington.mc.logic.excel.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.lexington.mc.logic.util.MessageException;

public class BaseTableExporter {

   private static Logger        log          = Logger.getLogger(BaseTableExporter.class.getName());

   public ExcelFetchContents fetchData(ResultSet rs, ArrayList<String> ignoreList) throws MessageException {
      ExcelFetchContents efc = new ExcelFetchContents();
      
      ArrayList<Integer> ignorePositions = new ArrayList<>();
      ArrayList<String> headerList = new ArrayList<>();
      ArrayList<ExcelExportEntity> contents = new ArrayList<>();
      
      try {
      
      ResultSetMetaData metadata = rs.getMetaData();
      int columnCount = metadata.getColumnCount();    
      for (int i = 1; i <= columnCount; i++) {
         
         if(!ignoreList.contains(metadata.getColumnName(i))){
            
         headerList.add(metadata.getColumnName(i).replace("_", " "));
         log.debug(metadata.getColumnName(i)+"   ");
         
         } else {
            
            ignorePositions.add(i);
            continue;
            
         }
      }
      
      efc.setHeaderList(headerList);
      
      while (rs.next()) {
         ExcelExportEntity excelEntity = new ExcelExportEntity();
         String row = "";
         for (int i = 1; i <= columnCount; i++) {
            
            if(ignorePositions.contains(i)) {
               continue;
            }
            
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
      } catch(SQLException e) {
         throw new MessageException("somethingWentWrong");
      } finally {
         try {
            rs.close();
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new MessageException("somethingWentWrong");

         }
      }
      efc.setContents(contents);
      return efc;
   }

  public byte[] exportDataFromDatabaseIntoByteArray(String excelName, ExcelFetchContents efc) throws MessageException {
   ExcelExportUtil excelExportUtil = new ExcelExportUtil();
   XSSFWorkbook workbook = new XSSFWorkbook();
   XSSFSheet sheet = workbook.createSheet(excelName);


   //First we create header row using headerList
   XSSFRow rowHeader = sheet.createRow(0);
   ArrayList<String> headerList = efc.getHeaderList();
   for (int i = 0; i < headerList.size(); i++) {
      XSSFCell cell = rowHeader.createCell(i);
      cell.setCellValue(headerList.get(i));
      cell.setCellStyle(excelExportUtil.getStyle("Header", workbook));
   }

   //Then we add data
   for (int i = 0; i < efc.getContents().size(); i++) {
      XSSFRow rowData = sheet.createRow(i+1);
      ExcelExportEntity content = efc.getContents().get(i);
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
         bos.close();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
         throw new MessageException("somethingWentWrong");
      }
   }
   byte[] bytes = bos.toByteArray();
   return bytes;
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
public class ExcelFetchContents {
   ArrayList<String> headerList = new ArrayList<>();
   ArrayList<ExcelExportEntity> contents = new ArrayList<>();
   
   public ArrayList<String> getHeaderList() {
      return headerList;
   }
   public void setHeaderList(ArrayList<String> headerList) {
      this.headerList = headerList;
   }
   public ArrayList<ExcelExportEntity> getContents() {
      return contents;
   }
   public void setContents(ArrayList<ExcelExportEntity> contents) {
      this.contents = contents;
   }
   
   
}
}
