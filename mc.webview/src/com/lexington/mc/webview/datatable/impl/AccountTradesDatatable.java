package com.lexington.mc.webview.datatable.impl;

import java.sql.Timestamp;

import org.primefaces.model.SelectableDataModel;

import com.lexington.mc.model.entities.EntityAccount;
import com.lexington.mc.model.entities.EntityTrade;
import com.lexington.mc.webview.datatable.api.Datatable;

 

public class AccountTradesDatatable extends Datatable<EntityTrade> implements SelectableDataModel<EntityTrade> {
	private EntityTrade selectedItem;
	private EntityAccount curAccount;
	private Timestamp endDate=null;
	private Timestamp asOfDate=null;
 



	public AccountTradesDatatable(EntityAccount curAccount, Timestamp endDate,
			Timestamp asOfDate) {
		super();
	 
		this.curAccount = curAccount;
		this.endDate = endDate;
		this.asOfDate = asOfDate;
		
		refreshDataSource();
	}



	public EntityAccount getCurAccount() {
		return curAccount;
	}



	public void setCurAccount(EntityAccount curAccount) {
		this.curAccount = curAccount;
	}



	@Override
	public void refreshDataSource() {
		
		if(endDate==null && asOfDate==null)
			super.setDatasource(curAccount.getEntityTrade());
		else
			super.setDatasource(curAccount.getTradesBeforeEndDate(asOfDate,endDate));
	}



	public EntityTrade getSelectedItem() {
		return selectedItem;
	}



	public void setSelectedItem(EntityTrade selectedItem) {
		this.selectedItem = selectedItem;
	}



	@Override
	public EntityTrade getRowData(String rowKey) {
		  for (EntityTrade payment : super.getDatasource()) {
		         if (payment.getTrade().getTRADE_ID().toString().equals(rowKey))
		            return payment;
		      }

		      return null;
	}



	@Override
	public Object getRowKey(EntityTrade arg0) {
		return arg0.getRowKey();
	}



	public Timestamp getEndDate() {
		return endDate;
	}



	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}



	public Timestamp getAsOfDate() {
		return asOfDate;
	}



	public void setAsOfDate(Timestamp asOfDate) {
		this.asOfDate = asOfDate;
	}

	
}
