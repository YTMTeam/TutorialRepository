package com.lexington.mc.logic.excel.export;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import com.lexington.mc.logic.util.MessageException;

import com.lexington.mc.model.entities.EntityPosition;

import com.lexington.mc.model.singletons.datasource.PositionEntityDatasource;


public class PositionExporter extends ExcelBasic {
	
	ArrayList<String> positionHeaderList = new ArrayList<>();
	ArrayList<ExcelExportEntity> positionContents = new ArrayList<>();
	String excelName = null;

	public byte[] exportFullPositionInfo(String accountId, Timestamp date1, Timestamp date2) throws MessageException {
		try {
			excelName = "Position info";
			fetchData(accountId,date1,date2);
			return exportDataFromDatabaseIntoByteArray();
		} catch (MessageException e) {
			throw e;
		}
	}

	public void fetchData(String accountId, Timestamp date1, Timestamp date2) throws MessageException {
		

		ArrayList<EntityPosition> entityPositions = PositionEntityDatasource.getPositionBySignutureDate(accountId, date1, date2);
		populatePositionHeaderList(positionHeaderList);
		populatePositionContents(positionContents, entityPositions);

	}

	private byte[] exportDataFromDatabaseIntoByteArray() throws MessageException {

		XSSFWorkbook workbook = new XSSFWorkbook();

		
		insertData(workbook, positionHeaderList, positionContents, "Positions");

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		// write this workbook to an Outputstream.
		try {
			workbook.write(bos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
		} finally {
			try {
				bos.close();
				workbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		byte[] bytes = bos.toByteArray();
		return bytes;
	}

	void populatePositionContents(ArrayList<ExcelExportEntity> contents, ArrayList<EntityPosition> positions) {

		for (EntityPosition position : positions) {

			ExcelExportEntity entity = new ExcelExportEntity();
			ArrayList<String> rowFields = new ArrayList<>();

//			// ACCOUNT FIRST NAME
//	         rowFields.add(
//                   position.getEntityAccount().getAccount().getFIRST_NAME() != null ? position.getEntityAccount().getAccount().getFIRST_NAME() : "");
//	        
//	         // ACCOUNT FIRST NAME
//	         rowFields.add(
//	               position.getEntityAccount().getAccount().getLAST_NAME() != null ? position.getEntityAccount().getAccount().getLAST_NAME() : "");
	        
			// ACCOUNT NUMBER
	         rowFields.add(
	               position.getEntityAccount().getAccount().getACCOUNT_NUMBER() != null ? position.getEntityAccount().getAccount().getACCOUNT_NUMBER() : "");

			// BROKER CODE
			rowFields.add(
					position.getPosition().getBROKER_CODE() != null ? position.getPosition().getBROKER_CODE() : "");

			// SECURITY SYMBOL
			rowFields.add(position.getPosition().getSECURITY_SYMBOL() != null
					? position.getPosition().getSECURITY_SYMBOL() : "");
			
            // CUSIP
            rowFields
                    .add(position.getPosition().getCUSIP() != null ? position.getPosition().getCUSIP().toString() : "");

            // ISIN
            rowFields.add(position.getPosition().getISIN() != null ? position.getPosition().getISIN().toString() : "");

            // SEDOL
            rowFields
                    .add(position.getPosition().getSEDOL() != null ? position.getPosition().getSEDOL().toString() : "");

            
            
			// CURRENCY
			rowFields.add(position.getPosition().getCURRENCY() != null ? position.getPosition().getCURRENCY() : "");

	         // EXPIRATION DATE
            rowFields.add(position.getPosition().getEXPIRATION_DATE() != null
                    ? position.getPosition().getEXPIRATION_DATE().toString() : "");

            
			// EXECUTION PRICE
			rowFields.add(position.getPosition().getEXECUTION_PRICE() != null
					? position.getPosition().getEXECUTION_PRICE().toString() : "");

			// MARKET PRICE
			rowFields.add(position.getPosition().getMARKET_PRICE() != null
			      ? position.getPosition().getMARKET_PRICE().toString() : "");
			
			// QUANTITY
			rowFields.add(position.getPosition().getQUANTITY() != null
			      ? position.getPosition().getQUANTITY().toString() : "");
			
			// SECURITY DATE
			rowFields.add(position.getPosition().getSECURITY_DATE() != null
			      ? position.getPosition().getSECURITY_DATE().toString() : "");
			
			entity.setRowFields(rowFields);

			contents.add(entity);
		}
	}

	public void populatePositionHeaderList(ArrayList<String> positionHeader) {
	   
	    positionHeader.add("ACCOUNT NUMBER");
	    positionHeader.add("BROKER CODE");
		positionHeader.add("SECURITY SYMBOL");
		positionHeader.add("CUSIP");
		positionHeader.add("ISIN");
		positionHeader.add("SEDOL");
		positionHeader.add("CURRENCY");
		positionHeader.add("EXPIRATION DATE");
		positionHeader.add("EXECUTION PRICE");
		positionHeader.add("MARKET PRICE");
		positionHeader.add("QUANTITY");
		positionHeader.add("SECURITY DATE");
	}
}
