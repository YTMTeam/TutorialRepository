package com.lexington.mc.webview.datatable.impl;

import java.math.BigDecimal;

import com.lexington.mc.logic.providers.AccountProvider;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.entities.EntityBank;
import com.lexington.mc.model.entities.EntityMonitor;
import com.lexington.mc.model.util.UtilCodeTypes;
import com.lexington.mc.webview.datatable.api.Datatable;

public class BankExtInaMonitoredAccountsDatatable  extends Datatable<EntityMonitor>{

	EntityBank curBank;
	
	
	



	public BankExtInaMonitoredAccountsDatatable(EntityBank curBank) {
		 
		this.curBank = curBank;
		refreshDataSource();
		
	}

	@Override
	public void refreshDataSource()  {
		UtilCodeTypes uct= new UtilCodeTypes(); 
		if(curBank!=null){
		  super.setDatasource(curBank.filterVisibleMonitors(curBank.getMonitorsByStatusAndType(uct.MonitorStatus.Codes.PASSED, uct.MonitorType.Codes.EXTERNAL)));
		}
	}
	
 
}
