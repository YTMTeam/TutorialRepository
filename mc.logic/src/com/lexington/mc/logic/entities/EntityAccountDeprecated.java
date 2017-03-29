package com.lexington.mc.logic.entities;

import java.util.ArrayList;

import com.lexington.mc.logic.providers.AccountProvider;
import com.lexington.mc.logic.util.MessageException;
import com.mallocinc.database.generated.to.AccountTo;

public class EntityAccountDeprecated {
	
	AccountTo to = new AccountTo();
	
	ArrayList<EntityVMonitoredAccountDeprecated> monitors = new ArrayList<>();
	ArrayList<EntityMonitorSelectorDeprecated> monits = new  ArrayList<>();
	public EntityAccountDeprecated() {
		// TODO Auto-generated constructor stub
	}
	
	public EntityAccountDeprecated(AccountTo to) {
		super();
		this.to = to;
	}

	public AccountTo getTo() {
		return to;
	}

	public void setTo(AccountTo to) {
		this.to = to;
	}
	
	public boolean isBankUser(){
		
		return to.getTYPE().equals("WABANKUSER");
	}
	
	
	public boolean isFamilyMember(){
		return to.getTYPE().equals("WAFAMYUSER");
		
		
	}
	
	
	public void refreshMonitors() throws MessageException{
		
		
		monitors=new AccountProvider().getAccountMonitors(to.getACCOUNT_ID());
	}

	public ArrayList<EntityVMonitoredAccountDeprecated> getMonitors() {
		return monitors;
	}

	public void setMonitors(ArrayList<EntityVMonitoredAccountDeprecated> monitors) {
		this.monitors = monitors;
	}

	public ArrayList<EntityMonitorSelectorDeprecated> getMonits() {
		return monits;
	}

	public void setMonits(ArrayList<EntityMonitorSelectorDeprecated> monits) {
		this.monits = monits;
	}
	
	 
	
}
