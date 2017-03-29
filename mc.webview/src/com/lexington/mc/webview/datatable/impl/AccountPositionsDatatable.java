package com.lexington.mc.webview.datatable.impl;

import java.sql.Timestamp;

import org.primefaces.model.SelectableDataModel;

import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.entities.EntityAccount;
import com.lexington.mc.model.entities.EntityPosition;
import com.lexington.mc.model.entities.EntityTrade;
import com.lexington.mc.webview.datatable.api.Datatable;

 

public class AccountPositionsDatatable extends Datatable<EntityPosition> implements SelectableDataModel<EntityPosition> {

	private EntityAccount curAccount;
	private Timestamp endDate=null;
	private Timestamp asOfDate=null;
 private EntityPosition selectedItem;

	public AccountPositionsDatatable(EntityAccount curAccount,Timestamp asOfDate, Timestamp endDate) {
		super();
		this.curAccount = curAccount;
		this.asOfDate = asOfDate;
		this.endDate = endDate;
		refreshDataSource();
	}



	public EntityAccount getCurAccount() {
		return curAccount;
	}



	public void setCurAccount(EntityAccount curAccount) {
		this.curAccount = curAccount;
	}



	@Override
	public void refreshDataSource()  {
		super.setDatasource(curAccount.getEntityPositions());
		
		
		
		if(endDate==null && asOfDate==null)
			super.setDatasource(curAccount.getEntityPositions());
		else
			super.setDatasource(curAccount.getPositionsBeforeEndDate(asOfDate, endDate));
		
	}
	@Override
	public EntityPosition getRowData(String rowKey) {
		  for (EntityPosition payment : super.getDatasource()) {
		         if (payment.getPosition().getPOSITION_ID().toString().equals(rowKey))
		            return payment;
		      }

		      return null;
	}



	@Override
	public Object getRowKey(EntityPosition arg0) {
		return arg0.getRowKey();
	}



	public EntityPosition getSelectedItem() {
		return selectedItem;
	}



	public void setSelectedItem(EntityPosition selectedItem) {
		this.selectedItem = selectedItem;
	}



	public Timestamp getEndDate() {
		return endDate;
	}



	public Timestamp getAsOfDate() {
		return asOfDate;
	}



	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}



	public void setAsOfDate(Timestamp asOfDate) {
		this.asOfDate = asOfDate;
	}
	
}
