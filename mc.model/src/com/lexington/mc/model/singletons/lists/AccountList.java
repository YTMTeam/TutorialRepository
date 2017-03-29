package com.lexington.mc.model.singletons.lists;

import java.util.ArrayList;

import com.lexington.mc.model.blockchain.pojos.PojoApi;


public class AccountList {
	private ArrayList<PojoApi> accounts = new ArrayList<>();
	
	public ArrayList<PojoApi> getAll() {
		return accounts;
	}
	
	/**
	 * Utility methods will be added below if necessary
	 */
	public void add(PojoApi newAccount) {
		accounts.add(newAccount);
	}
}
