package com.lexington.mc.logic.excel.util;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;

import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.entities.EntityUser;
import com.mallocinc.database.generated.to.UsersTo;

public class ExcelCellLoader implements IExcelCellLoader {
	
	public ArrayList<ExcelLoaderErrorObj> errors;
	
	public static Sheet                          sheet;
    public static Row                            currentRow;
    public ArrayList<ExcelLoaderErrorObj>        errorsForRow = new ArrayList<>();

  




    
	/**
	 * Get string value from cell. Row and column value is only needed for error log build.
	 * @param cell for getting value.
	 * @param sheetName Name of sheet.
	 * @param row number
	 * @param column number
	 * @param errors
	 * @return string value form cell.
	 */
	public String getStringWithErrorCheck(Cell cell,
			String sheetName,
			int row,
			int column,
			ArrayList<ExcelLoaderErrorObj> errors) {
		if (cell != null) {
			cell.setCellType(XSSFCell.CELL_TYPE_STRING);
			if (!cell.getStringCellValue().isEmpty() || !cell.getStringCellValue().trim().equals("")) {
				return cell.getStringCellValue().trim();
			}
		}
		errors.add(new ExcelLoaderErrorObj("emptyCellData", sheetName + " [" + (row + 1) + "][" + column + "]"));
		return null;
	}
	
	
	   
	/**********************************************************************
	 * 
	 * Utility method for getting numeric value from the spreadheet cell.
	 *
	 * @param cell for getting value
	 * @param sheetName
	 * @param row number
	 * @param colum number
	 * @param emptyOk check is it ok that value from cell is empty
	 * @param errors 
	 * @return BigDecimal
	 *
	 **********************************************************************/
	   public BigDecimal getNumber(Cell cell,
		         String sheetName,
		         int row,
		         int column,
		         boolean emptyOk,
		         ArrayList<ExcelLoaderErrorObj> errors) {
			   
		      if (cell != null) {
		         if (cell.getCellType() != XSSFCell.CELL_TYPE_NUMERIC) {
		            cell.setCellType(XSSFCell.CELL_TYPE_STRING);
		            if (cell.getStringCellValue().isEmpty() && emptyOk) {
		               return null;
		            } else if (cell.getStringCellValue().isEmpty() && !emptyOk) {
		               errors.add(new ExcelLoaderErrorObj("emptyCellData", sheetName + " [" + (row + 1) + "][" + column + "]"));
		               return null;
		            }
		            try {
		            double val = Double.parseDouble(cell.getStringCellValue());
		            return new BigDecimal(val);
		            } catch (NumberFormatException e) {
		            errors.add(new ExcelLoaderErrorObj("wrongDataForNumber", sheetName + " [" + (row + 1) + "][" + column + "]"));
		            return null;
		            }
		         }
		      } else if (cell == null) {
		         if (!emptyOk) {
		            errors.add(new ExcelLoaderErrorObj("emptyCellData", sheetName + " [" + (row + 1) + "][" + column + "]"));
		         }
		         return null;
		      }
		      double val = cell.getNumericCellValue();
		      return new BigDecimal(val);
		   }

	/**********************************************************************
	 * 
	 * Utility method for getting Timestamp value from the spreadsheet cell
	 *
	 * @param  cell worksheet cell
	 * @return Timestamp
	 *
	 **********************************************************************/
	public Timestamp getTimestamp(Cell cell, String sheetName, int row, int column, ArrayList<ExcelLoaderErrorObj> errors) {
		if (cell != null) {
			if (cell.getCellType() ==Cell.CELL_TYPE_NUMERIC && DateUtil.isCellDateFormatted(cell)) {
				java.util.Date cellDateValue = cell.getDateCellValue();
				Timestamp timestamp = new java.sql.Timestamp(cellDateValue.getTime());
				return timestamp;
			}
			if(cell.getCellType() == Cell.CELL_TYPE_STRING) {
				String cellStringValue = cell.getStringCellValue();
				DateFormat formatter;
				formatter = new SimpleDateFormat("dd/MM/yyyy");
				java.util.Date date;
				try {
					date = (java.util.Date) formatter.parse(cellStringValue);
					Timestamp timeStampDate = new java.sql.Timestamp(date.getTime());
					return timeStampDate;
				} catch (ParseException e) {
					errors.add(new ExcelLoaderErrorObj("wrongDataForTimecell", sheetName + " [" + (row + 1) + "][" + column + "]"));
					return null;
				}
			}
		}
		else
		{
			return null;
		}
		errors.add(new ExcelLoaderErrorObj("wrongDataForTimecell", sheetName + " [" + (row + 1) + "][" + column + "]"));
		return null;
	}

	/*********************************************************************
	 * Returns true if is all cells in row empty or null, otherwise
	 * return false. 
	 * @param row
	 * @param size
	 * @return boolean
	 * 
	 *********************************************************************/
	   /*********************************************************************
	    * Returns true if is all cells in row empty or null, otherwise
	    * return false. 
	    * @param row
	    * @param size
	    * @return boolean
	    * 
	    *********************************************************************/
	   public boolean checkIsRowEmpty() {
	      Row row = currentRow;

	      if(row == null) {
	         return true;
	      }

	      int size =  sheet.getRow(0).getLastCellNum();
	      for (int rowIndex = 0; rowIndex < size; rowIndex++) {
	         if (row.getCell(rowIndex) != null && row.getCell(rowIndex).getCellType() != Cell.CELL_TYPE_BLANK) {
	            Cell cell = row.getCell(rowIndex);
	            String stingValue = null;
	            try {
	               cell.setCellType(XSSFCell.CELL_TYPE_STRING);
	               stingValue = cell.getStringCellValue();
	            } catch(NullPointerException e) {
	               continue;
	            }
	            if (stingValue.isEmpty() || stingValue.replace(" ", "").length() == 0) {
	               continue;
	            }
	            return false;
	         }
	      }
	      return true;
	   }

	public ArrayList<ExcelLoaderErrorObj> getErrors() {
		return errors;
	}

	public void setErrors(ArrayList<ExcelLoaderErrorObj> errors) {
		this.errors = errors;
	}

	public boolean constraintErrorCheck() throws MessageException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean readDataFromExcel(String absoluteFilePath, EntityUser to) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<?> insertInformation(EntityUser to, String privateKey) throws MessageException {
		// TODO Auto-generated method stub
		return null;
	}

/**
 *       ***************************                   NEW METHODS                  **************************
 */
    /**********************************************************************
     * 
     * Utility method for getting String value from the spreadheet cell
     *
     * @param cell worksheet cell
     * @return String
     *
     **********************************************************************/
    public String getString(String columnName) {

       int columnInt = findColumnByColumnName(columnName, sheet.getRow(0).getLastCellNum());

       boolean emptyOk = !columnName.contains("*");

       if(columnInt == -1) {
          //Column was not found, return null
          return null;
       }
       Cell cell = currentRow.getCell(columnInt);       
             
       if(!emptyOk) {
          return getStringWithErrorCheck(cell, columnName);
       }

       if (cell == null) {
          return null;
       }
       cell.setCellType(XSSFCell.CELL_TYPE_STRING);

       return (cell.getStringCellValue().isEmpty()) ? null : cell.getStringCellValue().trim();
    }
    
    /**********************************************************************
     * Utility method that finds column position by its name
     * @param columnName
     * @param size
     * @return
     **********************************************************************/
    public int findColumnByColumnName(String columnName,int size) {
       Row row = sheet.getRow(0);

       for (int i = 0; i < size ; i++) {
          try {
             String currentName = row.getCell(i).getStringCellValue();
             if(columnName.equalsIgnoreCase(currentName)) {
                return i;
             }   
          } catch (NullPointerException e) {
             continue;
          }

       }
       errorsForRow.add(new ExcelLoaderErrorObj("unknownColumnHeader","[Row: " + (currentRow.getRowNum() + 1) + "] [Header should be named: " + columnName  + "]"));
       return -1;
    }

    /**********************************************************************
     * Get string value from cell with error if value is empty or null
     **********************************************************************/
    String getStringWithErrorCheck(Cell cell, String columnName) {

       if (cell != null) {

          cell.setCellType(XSSFCell.CELL_TYPE_STRING);

          if (!cell.getStringCellValue().isEmpty() || !cell.getStringCellValue().trim().equals("")) {
             
             String value = cell.getStringCellValue().trim();

             return value;
          }
       }
       
       errorsForRow.add(new ExcelLoaderErrorObj("emptyCellData", sheet.getSheetName() + "[Row: " + (currentRow.getRowNum() + 1) + "] [Column name: " + columnName  + "]"));

       return null;
    }
    
    /**********************************************************************
     * 
     * Utility method for getting numeric value from the spreadheet cell.
     *
     * @param cell for getting value
     * @param sheetName
     * @param row number
     * @param colum number
     * @param emptyOk check is it ok that value from cell is empty
     * @param errors 
     * @return BigDecimal
     *
     **********************************************************************/
    public BigDecimal getNumber(String columnName) {
       int columnInt = findColumnByColumnName(columnName, sheet.getRow(0).getLastCellNum());

       boolean emptyOk = !columnName.contains("*");

       if(columnInt == -1) {
          //Column was not found, return null
          return null;
       }
       Cell cell = currentRow.getCell(columnInt);

       if (cell != null) {

          if (cell.getCellType() != XSSFCell.CELL_TYPE_NUMERIC) {
             try {
                cell.setCellType(XSSFCell.CELL_TYPE_STRING);
             } catch (NullPointerException e) {
                return null;
             }

             if (cell.getStringCellValue().isEmpty() && emptyOk) {
                return null;
             }

             else if (cell.getStringCellValue().isEmpty() || cell.getStringCellValue().trim().equals("") && !emptyOk) {
                errorsForRow.add(new ExcelLoaderErrorObj("emptyCellData", sheet.getSheetName() + "[Row: " + (currentRow.getRowNum() + 1) + "] [Column name: " + columnName  + "]"));
                return null;
             }
             //If Cell is recognized as String, try to put it into BigDecimal, if NF exception occurs - throw an error
             try {
                BigDecimal number = new BigDecimal(cell.getStringCellValue());

                return number;
             } catch(NumberFormatException e) {  
                errorsForRow.add(new ExcelLoaderErrorObj("wrongDataForNumber", sheet.getSheetName() + "[Row: " + (currentRow.getRowNum() + 1) + "] [Column name: " + columnName  + "]"));

                return null;
             }
          }
       } else if (cell == null) {
          if (!emptyOk) {
             errorsForRow.add(new ExcelLoaderErrorObj("emptyCellData", sheet.getSheetName() + "[Row: " + (currentRow.getRowNum() + 1) + "] [Column name: " + columnName  + "]"));

          }
          return null;
       }

       double val = cell.getNumericCellValue();
      
       BigDecimal number = new BigDecimal(val);

       return number;
    }
//    /**********************************************************************
//     * 
//     * Utility method for getting Timestamp value from the spreadsheet cell
//     *
//     * @param  cell worksheet cell
//     * @return Timestamp
//     *
//     **********************************************************************/
//    public Timestamp getTimestamp(String columnName) {
//
//       Timestamp timeStamp = null;
//
//       int columnInt = findColumnByColumnName(columnName, sheet.getRow(0).getLastCellNum());
//       boolean emptyOk = !columnName.contains("*");
//       
//       if(columnInt == -1) {
//          //Column was not found, return null
//          return null;
//       }
//       
//       
//       Cell cell = currentRow.getCell(columnInt);
//       if(cell == null && !emptyOk) {
//          errorsForRow.add(new ExcelLoaderErrorObj("emptyCellData", sheet.getSheetName() + "[Row: " + (currentRow.getRowNum() + 1) + "] [Column name: " + columnName  + "]"));
//          return null;
//       }
//       if(cell == null && emptyOk) {
//          return null;
//       }
//
//       if (cell != null) {
//          try {
//             if (DateUtil.isCellDateFormatted(cell)) {
//                timeStamp = (cell.getDateCellValue() == null ? null : new Timestamp(cell.getDateCellValue().getTime()));
//             }
//          } catch (IllegalStateException e) {
//             errorsForRow.add(new ExcelLoaderErrorObj("wrongDataForTimecell", sheet.getSheetName() + "[Row: " + (currentRow.getRowNum() + 1) + "] [Column name: " + columnName  + "]"));
//
//          }
//       }
//       if(timeStamp == null && !emptyOk) {
//          errorsForRow.add(new ExcelLoaderErrorObj("emptyCellData", sheet.getSheetName() + "[Row: " + (currentRow.getRowNum() + 1) + "] [Column name: " + columnName  + "]"));
//       }
//       return timeStamp;
//    }
    /**********************************************************************
     * 
     * Utility method for getting Timestamp value from the spreadsheet cell
     *
     * @param  cell worksheet cell
     * @return Timestamp
     *
     **********************************************************************/
     public Timestamp getTimestamp(String columnName) {
        
        Timestamp timeStamp = null;

        int columnInt = findColumnByColumnName(columnName, sheet.getRow(0).getLastCellNum());
        boolean emptyOk = !columnName.contains("*");
        
        if(columnInt == -1) {
           //Column was not found, return null
           return null;
        }
        
        
        Cell cell = currentRow.getCell(columnInt);
        if(cell == null && !emptyOk) {
           errorsForRow.add(new ExcelLoaderErrorObj("emptyCellData", sheet.getSheetName() + "[Row: " + (currentRow.getRowNum() + 1) + "] [Column name: " + columnName  + "]"));
           return null;
        }
        if(cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK && emptyOk) {
           return null;
        }
        
         if (cell != null) {
             if (cell.getCellType() ==Cell.CELL_TYPE_NUMERIC && DateUtil.isCellDateFormatted(cell)) {
                 java.util.Date cellDateValue = cell.getDateCellValue();
                 Timestamp timestamp = new java.sql.Timestamp(cellDateValue.getTime());
                 return timestamp;
             }
             if(cell.getCellType() == Cell.CELL_TYPE_STRING) {
                 String cellStringValue = cell.getStringCellValue();
                 
                 if(cellStringValue.equals("") && emptyOk) {
                    return null;
                 }
                 
                 DateFormat formatter;
                 formatter = new SimpleDateFormat("dd/MM/yyyy");
                 java.util.Date date;
                 try {
                     date = (java.util.Date) formatter.parse(cellStringValue);
                     Timestamp timeStampDate = new java.sql.Timestamp(date.getTime());
                     return timeStampDate;
                 } catch (ParseException e) {
                    errorsForRow.add(new ExcelLoaderErrorObj("wrongDataForTimecell", sheet.getSheetName() + "[Row: " + (currentRow.getRowNum() + 1) + "] [Column name: " + columnName  + "]"));
                     return null;
                 }
             }
         }
         else
         {
             return null;
         }
         errorsForRow.add(new ExcelLoaderErrorObj("wrongDataForTimecell", sheet.getSheetName() + "[Row: " + (currentRow.getRowNum() + 1) + "] [Column name: " + columnName  + "]"));
         return null;
     }
}
