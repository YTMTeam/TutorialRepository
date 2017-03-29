package com.lexington.mc.webview.datatable.impl;

import com.lexington.mc.model.entities.EntityAccount;
import com.lexington.mc.model.entities.EntityBank;
import com.lexington.mc.webview.datatable.api.Datatable;

public class BankInternalAccountsDatatable extends Datatable<EntityAccount> {

	EntityBank bank;


	public BankInternalAccountsDatatable(EntityBank bank) {
		 
		this.bank = bank;
		refreshDataSource();
		
	}

	@Override
	public void refreshDataSource()   {
	   
		if(bank!=null){
         super.setDatasource(bank.filterVisibleAccounts(bank.getEntityAccounts()));
		}
		
	}

	public EntityBank getBank() {
		return bank;
	}

	public void setBank(EntityBank bank) {
		this.bank = bank;
	}
	
	 

}
