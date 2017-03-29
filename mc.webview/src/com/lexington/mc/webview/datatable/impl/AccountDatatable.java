package com.lexington.mc.webview.datatable.impl;

import com.lexington.mc.logic.providers.AccountProvider;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.entities.EntityAccount;
import com.lexington.mc.model.singletons.datasource.AccountEntityDatasource;
import com.lexington.mc.webview.datatable.api.Datatable;

 

public class AccountDatatable extends Datatable<EntityAccount> {

	public AccountDatatable(){
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void refreshDataSource() throws MessageException {
		super.setDatasource(AccountEntityDatasource.getAllVisibleAccounts());
		
	}

	
}
