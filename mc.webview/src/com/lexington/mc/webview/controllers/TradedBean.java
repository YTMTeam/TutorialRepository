package com.lexington.mc.webview.controllers;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import com.lexington.mc.model.blockchain.pojos.TradePojo;
import com.lexington.mc.model.entities.EntityTrade;


public class TradedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ArrayList<EntityTrade> list;
	TradePojo tradeTo = new TradePojo();

	public TradedBean() {
		list = new ArrayList<>();
		EntityTrade t = new EntityTrade();
		list.add(t);
	}

	public TradePojo getTradeTo() {
		return tradeTo;
	}

	public void setTradeTo(TradePojo tradeTo) {
		this.tradeTo = tradeTo;
	}

	public ArrayList<EntityTrade> getList() {
		return list;
	}

	public void setList(ArrayList<EntityTrade> list) {
		this.list = list;
	}

	
}
