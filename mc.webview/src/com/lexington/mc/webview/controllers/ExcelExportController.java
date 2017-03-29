package com.lexington.mc.webview.controllers;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.lexington.mc.logic.providers.ExportViewProvider;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.webview.beans.ManageUser;
import com.lexington.mc.webview.util.FacesUtil;

@ManagedBean(name="manageExportView")
@ViewScoped
public class ExcelExportController {
	ExportViewProvider exportViewProvider = new ExportViewProvider();


	public StreamedContent getExcelForUserTrades(String userId) {
		StreamedContent file = null;
		InputStream stream = null;
		byte[] excelBlob;
		try {
			excelBlob = exportViewProvider.generateExcelFileForUserTrades(userId);
			stream = new ByteArrayInputStream(excelBlob);
			file = new DefaultStreamedContent(stream,"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "User Trades" + ".xlsx");
		} catch (MessageException e) {
			// TODO Auto-generated catch block
	         FacesUtil.throwMessage(e);
		}
		return file;
	}
	public StreamedContent getAccountFullInfo(String accountId) {
	   
       ManageUser user = (ManageUser) FacesUtil.getSessionMapValue("user");
       
       String bankId = user.getCurUser().getEntityBank().getBank().getBANK_ID().toString();
	      
	   StreamedContent file = null;
	   InputStream stream = null;
	   byte[] excelBlob;
	   try {
	      excelBlob = exportViewProvider.generateExcelFileForAccount(accountId, bankId);
	      stream = new ByteArrayInputStream(excelBlob);
	      file = new DefaultStreamedContent(stream,"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "Account Info" + ".xlsx");
	   } catch (MessageException e) {
	      // TODO Auto-generated catch block
	      FacesUtil.throwMessage(e);
	   }
	   return file;
	}
//	public StreamedContent getExcelForGroupTrades(BigDecimal groupId) {
//		StreamedContent file = null;
//		InputStream stream = null;
//		byte[] excelBlob;
//		try {
//			excelBlob = exportViewProvider.generateExcelFileForGroupTrades(groupId);
//			stream = new ByteArrayInputStream(excelBlob);
//			file = new DefaultStreamedContent(stream,"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "Household Trades" + ".xlsx");
//		} catch (MessageException e) {
//			// TODO Auto-generated catch block
//			FacesUtil.throwMessage(e);
//		}
//		return file;
//	}	
//	public StreamedContent getExcelForAccountPositions(String accountId) {
//		StreamedContent file = null;
//		InputStream stream = null;
//		byte[] excelBlob;
//		try {
//			excelBlob = exportViewProvider.generateExcelFileForAccountPositions(accountId);
//			stream = new ByteArrayInputStream(excelBlob);
//			file = new DefaultStreamedContent(stream,"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "Account Positions" + ".xlsx");
//		} catch (MessageException e) {
//			// TODO Auto-generated catch block
//			FacesUtil.throwMessage(e);
//		}
//		return file;
//	}	
	public StreamedContent getExcelForBankAccountList(BigDecimal bankId) {
		StreamedContent file = null;
		InputStream stream = null;
		byte[] excelBlob;
		try {
			excelBlob = exportViewProvider.generateExcelFileForBankAccountList(bankId);
			stream = new ByteArrayInputStream(excelBlob);
			file = new DefaultStreamedContent(stream,"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "Bank Accounts" + ".xlsx");
		} catch (MessageException e) {
			// TODO Auto-generated catch block
			FacesUtil.throwMessage(e);
		}
		return file;
	}	
//	public StreamedContent getExcelForMonitoredAccountList(BigDecimal bankId) {
//		StreamedContent file = null;
//		InputStream stream = null;
//		byte[] excelBlob;
//		try {
//			excelBlob = exportViewProvider.generateExcelFileForMonitoredAccountList(bankId);
//			stream = new ByteArrayInputStream(excelBlob);
//			file = new DefaultStreamedContent(stream,"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "Bank Accounts" + ".xlsx");
//		} catch (MessageException e) {
//			// TODO Auto-generated catch block
//			FacesUtil.throwMessage(e);
//		}
//		return file;
//	}	
	
	public StreamedContent getExcelForCurBankAccountList() {
		ManageUser user= (ManageUser) FacesUtil.getSessionMapValue("user");
		return getExcelForBankAccountList(user.getCurUser().getEntityBank().getBank().getBANK_ID());
 
	}
//	public StreamedContent getExcelForCurBankMonitoredAccountList() {
//		ManageUser user= (ManageUser) FacesUtil.getSessionMapValue("user");
//		return getExcelForMonitoredAccountList(user.getCurUser().getEntityBank().getBank().getBANK_ID());
// 
//	}
	
}
