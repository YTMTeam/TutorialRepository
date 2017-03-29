package com.lexington.mc.model.singletons.lists;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.lexington.mc.model.blockchain.pojos.PojoApi;

public class BlockList {
	private ArrayList<PojoApi> blocks = new ArrayList<>();
	
	public ArrayList<PojoApi> getAll() {
		return blocks;
	}
	
	/**
	 * Utility methods will be added below if necessary
	 */
	public void add(PojoApi newBlock) {
		blocks.add(newBlock);
	}
}
