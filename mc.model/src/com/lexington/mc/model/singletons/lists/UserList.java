package com.lexington.mc.model.singletons.lists;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.lexington.mc.model.blockchain.pojos.PojoApi;


public class UserList {
	private ArrayList<PojoApi> users = new ArrayList<>();
	private long sequence = 1;
	
	public ArrayList<PojoApi> getAll() {
		return users;
	}
	
	/**
	 * Utility methods will be added below if necessary
	 */
	public void add(PojoApi newUser) {
		users.add(newUser);
	}
}
