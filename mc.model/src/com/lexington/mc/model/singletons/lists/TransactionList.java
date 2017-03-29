package com.lexington.mc.model.singletons.lists;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.lexington.mc.model.blockchain.pojos.PojoApi;

public class TransactionList {
	private  ArrayList<PojoApi> transactions = new ArrayList<>();
	
	public ArrayList<PojoApi> getAll() {
		return transactions;
	}
	
	/**
	 * Utility methods will be added below if necessary
	 */
	public void add(PojoApi newTransaction) {
		transactions.add(newTransaction);
	}
}
