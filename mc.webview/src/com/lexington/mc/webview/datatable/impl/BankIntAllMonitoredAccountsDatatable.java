package com.lexington.mc.webview.datatable.impl;

import java.math.BigDecimal;

import com.lexington.mc.logic.providers.AccountProvider;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.entities.EntityBank;
import com.lexington.mc.model.entities.EntityMonitor;
import com.lexington.mc.model.util.UtilCodeTypes;
import com.lexington.mc.webview.datatable.api.Datatable;

public class BankIntAllMonitoredAccountsDatatable  extends Datatable<EntityMonitor> {

	EntityBank curBank;
	
	
	



	public BankIntAllMonitoredAccountsDatatable(EntityBank curBank) {
		 
		this.curBank = curBank;
		refreshDataSource();
	}

	@Override
	public void refreshDataSource()  {
		UtilCodeTypes uct= new UtilCodeTypes(); 
		  super.setDatasource(curBank.getMonitorsByStatusAndType(uct.MonitorStatus.Codes.ACTIVE, uct.MonitorType.Codes.INTERNAL));
		  super.getDatasource().addAll(curBank.getMonitorsByStatusAndType(uct.MonitorStatus.Codes.PASSED, uct.MonitorType.Codes.INTERNAL));
		
	}

	public EntityBank getCurBank() {
		return curBank;
	}

	public void setCurBank(EntityBank curBank) {
		this.curBank = curBank;
	}
	
 

}
