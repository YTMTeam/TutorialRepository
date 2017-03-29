package com.lexington.mc.model.singletons.lists;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.lexington.mc.model.blockchain.pojos.PojoApi;
import com.mallocinc.database.generated.to.TradeTo;


public class TradeList {
	private ArrayList<PojoApi> trades = new ArrayList<>();
	
	public ArrayList<PojoApi> getAll() {
		return trades;
	}
	
	/**
	 * Utility methods will be added below if necessary
	 */
	public void add(PojoApi newTrade) {
		trades.add(newTrade);
	}
}
