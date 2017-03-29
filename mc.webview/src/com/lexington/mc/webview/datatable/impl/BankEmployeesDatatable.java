package com.lexington.mc.webview.datatable.impl;

import java.math.BigDecimal;

import com.lexington.mc.logic.entities.EntityEmployeeDeprecated;
import com.lexington.mc.logic.providers.EmployeeProvider;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.entities.EntityBank;
import com.lexington.mc.model.entities.EntityEmployee;
import com.lexington.mc.webview.datatable.api.Datatable;

public class BankEmployeesDatatable  extends Datatable<EntityEmployee> {

	EntityBank bank;
	
	
	



	public BankEmployeesDatatable(EntityBank bank) {
		 
		this.bank = bank;
		refreshDataSource();
	}

	@Override
	public void refreshDataSource()  {
	 if(bank!=null){
          super.setDatasource(bank.getEntityEmployees());
          super.setFilteredEntities(super.getDatasource());
	 }
	   
	}
	
 

	public EntityBank getBank() {
		return bank;
	}

	public void setBank(EntityBank bank) {
		this.bank = bank;
	}

	public EntityEmployee getEmployeeById(BigDecimal selectedEmployeeId) {
		for(EntityEmployee e: getDatasource()){
			if(e.getEmployee().getEMPLOYEE_ID().equals(selectedEmployeeId))
				return e;	
		}
		
		return null;
	}


}