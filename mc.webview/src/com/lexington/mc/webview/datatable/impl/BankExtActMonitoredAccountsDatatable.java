package com.lexington.mc.webview.datatable.impl;

import java.math.BigDecimal;

import com.lexington.mc.logic.providers.AccountProvider;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.entities.EntityBank;
import com.lexington.mc.model.entities.EntityMonitor;
import com.lexington.mc.model.util.UtilCodeTypes;
import com.lexington.mc.webview.datatable.api.Datatable;

public class BankExtActMonitoredAccountsDatatable  extends Datatable<EntityMonitor> {

	EntityBank curBank;
	
	
	



	public BankExtActMonitoredAccountsDatatable(EntityBank curBank) {
		 
		this.curBank = curBank;
		refreshDataSource();
	}

	@Override
	public void refreshDataSource()  {
	   UtilCodeTypes utc= new UtilCodeTypes();
	   if(curBank!=null){
	         super.setDatasource(curBank.filterVisibleMonitors(curBank.getMonitorsByStatusAndType(utc.MonitorStatus.Codes.ACTIVE, utc.MonitorType.Codes.EXTERNAL)));
	   }
	}

	public EntityBank getCurBank() {
		return curBank;
	}

	public void setCurBank(EntityBank curBank) {
		this.curBank = curBank;
	}
	
	 

}
