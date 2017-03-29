package com.lexington.mc.model.singletons.lists;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.lexington.mc.model.blockchain.pojos.PojoApi;


public class BankList {
	private ArrayList<PojoApi> banks = new ArrayList<>();
	
	public ArrayList<PojoApi> getAll() {
		return banks;
	}
	
	/**
	 * Utility methods will be added below if necessary
	 */
	public void add(PojoApi newBank) {
		banks.add(newBank);
	}
}
