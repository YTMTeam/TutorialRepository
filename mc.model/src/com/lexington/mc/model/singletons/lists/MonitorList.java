package com.lexington.mc.model.singletons.lists;

import java.util.ArrayList;

import com.lexington.mc.model.blockchain.pojos.PojoApi;


public class MonitorList {
	private ArrayList<PojoApi> monitors = new ArrayList<>();
	
	public ArrayList<PojoApi> getAll() {
		return monitors;
	}
	
	/**
	 * Utility methods will be added below if necessary
	 */
	public void add(PojoApi newMonitor) {
		monitors.add(newMonitor);
	}
}
