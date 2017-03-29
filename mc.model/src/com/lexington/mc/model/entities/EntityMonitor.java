package com.lexington.mc.model.entities;

import com.lexington.mc.model.blockchain.pojos.MonitorPojo;
import com.lexington.mc.model.blockchain.pojos.PojoApi;
import com.lexington.mc.model.util.UtilCodeTypes;

public class EntityMonitor  extends EntityApi{

    private UtilCodeTypes uct = new UtilCodeTypes();
   
	private MonitorPojo monitor ;
	private EntityAccount entityAccount;
	private EntityBank entityBank;
	private EntityEmployee entityEmployee;
	
	
	public MonitorPojo getMonitor() {
		return monitor;
	}
	public void setMonitor(MonitorPojo monitor) {
		this.monitor = monitor;
	}
	public EntityAccount getEntityAccount() {
		return entityAccount;
	}
	public void setEntityAccount(EntityAccount entityAccount) {
		this.entityAccount = entityAccount;
	}
	public EntityBank getEntityBank() {
		return entityBank;
	}
	public void setEntityBank(EntityBank entityBank) {
		this.entityBank = entityBank;
	}
	public EntityEmployee getEntityEmployee() {
		return entityEmployee;
	}
	public void setEntityEmployee(EntityEmployee entityEmployee) {
		this.entityEmployee = entityEmployee;
	}
	@Override
	public String getRowKey() {
		return monitor.getMONITOR_ID();
	}
	@Override
	public PojoApi getPojo() {
		return monitor;
	}
	@Override
	public void setPojo(PojoApi p) {
		monitor=(MonitorPojo) p;
		
	}

	public boolean isApproved() {
	   return uct.YesNoIndicator.Codes.YES.equals(getMonitor().getOUT_BANK_APPROVED()) && uct.YesNoIndicator.Codes.YES.equals(getMonitor().getEMP_BANK_APPROVED());
	}
	
	
	
}
