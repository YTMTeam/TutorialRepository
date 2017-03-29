package com.lexington.mc.model.singletons.lists;

import java.util.ArrayList;

import com.lexington.mc.model.blockchain.pojos.PojoApi;
import com.lexington.mc.model.blockchain.pojos.PositionPojo;


public class PositionList {
	private ArrayList<PojoApi> positions = new ArrayList<>();
	
	public ArrayList<PojoApi> getAll() {
		return positions;
	}
	
	/**
	 * Utility methods will be added below if necessary
	 */
	public void add(PojoApi newPosition) {
		positions.add(newPosition);
	}
}
