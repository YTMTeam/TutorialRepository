package com.lexington.mc.webview.controllers;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.poi.hslf.record.CurrentUserAtom;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.lexington.mc.logic.providers.ExportViewProvider;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.entities.EntityAccount;
import com.lexington.mc.model.entities.EntityBank;
import com.lexington.mc.model.entities.EntityPosition;
import com.lexington.mc.model.entities.EntityTrade;
import com.lexington.mc.webview.beans.ManageUser;
import com.lexington.mc.webview.datatable.impl.AccountPositionsDatatable;
import com.lexington.mc.webview.datatable.impl.AccountTradesDatatable;
import com.lexington.mc.webview.util.FacesUtil;

import mondrian.util.Format;

@ManagedBean(name = "trades")
public class TradesController {

	private AccountTradesDatatable userTradesLazy;
	// private SelectGroupTradesLazy groupTradesLazy;
	private AccountPositionsDatatable accountPositionsLazy;
	private EntityTrade curTrade;

	private boolean viewUserTrades = true; // if true then it is view of user
											// trades, else view group trades

	private EntityAccount curAccount = new EntityAccount();
	private EntityPosition curPosition;

	private Timestamp asOfDate;
	private Timestamp endDate;
	
	public TradesController() {

	}



	public TradesController(EntityAccount curAccount, Timestamp asOfDate, Timestamp endDate) {
		super();
		this.curAccount = curAccount;
		this.asOfDate = asOfDate;
		this.endDate = endDate;
		refreshTrades();
	
	}



	public void clearCurTrade() {

		curTrade = null;

	}

	public void refreshTrades() {

		userTradesLazy = new AccountTradesDatatable(curAccount, endDate, asOfDate);
		// groupTradesLazy=new
		// SelectGroupTradesLazy(curUser.getTo().getHOUSEHOLD_ID());
		accountPositionsLazy = new AccountPositionsDatatable(curAccount, asOfDate, endDate);
		System.out.println("Data fetched.");
	}

	public void onRowSelect(SelectEvent event) {
		curTrade = ((EntityTrade) event.getObject());
		System.out.println("trade selected");
	}

	public void onPositionSelect(SelectEvent event) {
		setCurPosition(((EntityPosition) event.getObject()));

	}

	public void onRowUnselect(UnselectEvent event) {
		curTrade = null;
	}

	public AccountTradesDatatable getUserTradesLazy() {
		return userTradesLazy;
	}

	public void setUserTradesLazy(AccountTradesDatatable userTradesLazy) {
		this.userTradesLazy = userTradesLazy;
	}

	// public SelectGroupTradesLazy getGroupTradesLazy() {
	// return groupTradesLazy;
	// }
	//
	// public void setGroupTradesLazy(SelectGroupTradesLazy groupTradesLazy) {
	// this.groupTradesLazy = groupTradesLazy;
	// }

	public EntityTrade getCurTrade() {
		return curTrade;
	}

	public void setCurTrade(EntityTrade curTrade) {
		this.curTrade = curTrade;
	}

	public EntityAccount getCurAccount() {
		return curAccount;
	}

	public void setCurAccount(EntityAccount curUser) {
		this.curAccount = curUser;
	}

	public boolean isViewUserTrades() {
		return viewUserTrades;
	}

	public void setViewUserTrades(boolean viewUserTrades) {
		this.viewUserTrades = viewUserTrades;
	}

	public StreamedContent getExportAccount() {

		ExportViewProvider provider = new ExportViewProvider();

       ManageUser user = (ManageUser) FacesUtil.getSessionMapValue("user");
	       
       String bankId = user.getCurUser().getEntityBank().getBank().getBANK_ID().toString();

		StreamedContent file = null;
		InputStream stream = null;
		byte[] excelBlob;
		try {
			excelBlob = provider.generateExcelFileForAccount(curAccount.getAccount().getACCOUNT_ID().toString(), bankId);
			stream = new ByteArrayInputStream(excelBlob);
			file = new DefaultStreamedContent(stream,
					"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "Account info" + ".xlsx");
		} catch (MessageException e) {
			// TODO Auto-generated catch block
			FacesUtil.throwMessage(e);
		}
		return file;
	}

	private Timestamp fechDate;
	private Timestamp fechDate1;
	
	private Timestamp fechDate2;
	private Timestamp fechDate3;

	public StreamedContent getExportAccountSpecialDate() {
		
		
		if(fechDate == null || fechDate1 == null){
			FacesUtil.throwWarning("dateFieldsAreRequired");
			return null;
			
		}
		
		
		 
		
		ManageUser user = (ManageUser) FacesUtil.getSessionMapValue("user");
		ExportViewProvider provider = new ExportViewProvider();

		StreamedContent file = null;
		InputStream stream = null;
		byte[] excelBlob;
		try {
			excelBlob = provider.generateExcelFileForAccountDate(user.getCurUser().getEntityBank().getBank().getBANK_ID().toString(),
					fechDate, fechDate1);
			stream = new ByteArrayInputStream(excelBlob);
			file = new DefaultStreamedContent(stream,
					"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "Account info" + ".xlsx");
		} catch (MessageException e) {
			// TODO Auto-generated catch block
			FacesUtil.throwMessage(e);
		}
		return file;
	}

	 public StreamedContent getExportAccountTrades(){
		 if(fechDate2 == null || fechDate3 == null){
				FacesUtil.throwWarning("dateFieldsAreRequired");
				return null;
				
			}
	ManageUser user = (ManageUser) FacesUtil.getSessionMapValue("user");

	 ExportViewProvider provider=new ExportViewProvider();
	
	 StreamedContent file = null;
	 InputStream stream = null;
	 byte[] excelBlob;
	 try {
	 excelBlob =
	 provider.generateExcelFileForAccountTrades(user.getCurUser().getEntityBank().getBank().getBANK_ID().toString(),
				fechDate2, fechDate3);
	 stream = new ByteArrayInputStream(excelBlob);
	 file = new
	 DefaultStreamedContent(stream,"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
	 "Trade info" + ".xlsx");
	 } catch (MessageException e) {
	 // TODO Auto-generated catch block
	 FacesUtil.throwMessage(e);
	 }
	 return file;
	 }
	//
	//
	// public StreamedContent getExportAccountPositions(){
	//
	// ExportViewProvider provider=new ExportViewProvider();
	//
	// StreamedContent file = null;
	// InputStream stream = null;
	// byte[] excelBlob;
	// try {
	// excelBlob =
	// provider.generateExcelFileForAccountPositions(curAccount.getAccount().getACCOUNT_ID().toString());
	// stream = new ByteArrayInputStream(excelBlob);
	// file = new
	// DefaultStreamedContent(stream,"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
	// "Position info" + ".xlsx");
	// } catch (MessageException e) {
	// // TODO Auto-generated catch block
	// FacesUtil.throwMessage(e);
	// }
	// return file;
	// }
	public void initializeFirstTrade() {
		// TODO Auto-generated method stub

	}

	public AccountPositionsDatatable getAccountPositionsLazy() {
		return accountPositionsLazy;
	}

	public void setAccountPositionsLazy(AccountPositionsDatatable accountPositionsLazy) {
		this.accountPositionsLazy = accountPositionsLazy;
	}

	public EntityPosition getCurPosition() {
		return curPosition;
	}

	public void setCurPosition(EntityPosition curPosition) {
		this.curPosition = curPosition;
	}

	public Timestamp getFechDate() {
		return fechDate;
	}

	public void setFechDate(Timestamp fechDate) {
		this.fechDate = fechDate;
	}

	public Timestamp getFechDate1() {
		return fechDate1;
	}

	public void setFechDate1(Timestamp fechDate1) {
		this.fechDate1 = fechDate1;
	}

	public Timestamp getFechDate2() {
		return fechDate2;
	}

	public void setFechDate2(Timestamp fechDate2) {
		this.fechDate2 = fechDate2;
	}

	public Timestamp getFechDate3() {
		return fechDate3;
	}

	public void setFechDate3(Timestamp fechDate3) {
		this.fechDate3 = fechDate3;
	}

	public Timestamp getAsOfDate() {
		return asOfDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setAsOfDate(Timestamp asOfDate) {
		this.asOfDate = asOfDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

}
