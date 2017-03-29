package com.lexington.mc.webview.datatable.impl;

import java.math.BigDecimal;

import com.lexington.mc.logic.providers.AccountProvider;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.entities.EntityBank;
import com.lexington.mc.model.entities.EntityMonitor;
import com.lexington.mc.webview.datatable.api.Datatable;

public class BankAllMonitoredAccountsDatatable extends Datatable<EntityMonitor> {

	EntityBank bank;
	//TODO think if we could have filter parameter for status initialy and make all of it from one database, because that changing over time
	
 
	
	
	



	public BankAllMonitoredAccountsDatatable(EntityBank bank) {
		 
		this.bank = bank;
		refreshDataSource();
	}

	@Override
	public void refreshDataSource()  {
		// TODO 
       if(bank!=null){
          super.setDatasource(bank.filterVisibleMonitors(bank.getEntityMonitors()));
       }
		
	}

	public EntityBank getBank() {
		return bank;
	}

	public void setBank(EntityBank bank) {
		this.bank = bank;
	}

 
	
 
}
