package com.lexington.mc.logic.entities;

import com.mallocinc.database.generated.to.VMonitoredAccountsTo;

public class EntityMonitorSelectorDeprecated extends EntityVMonitoredAccountDeprecated {

	VMonitoredAccountsTo to = new VMonitoredAccountsTo();
	
	boolean isChecked;
	
	public EntityMonitorSelectorDeprecated() {
		super();
	}

	public EntityMonitorSelectorDeprecated(VMonitoredAccountsTo to, boolean isChecked) {
		super();
		this.to = to;
		this.isChecked = isChecked;
	}

	public VMonitoredAccountsTo getTo() {
		return to;
	}

	public void setTo(VMonitoredAccountsTo to) {
		this.to = to;
	}

	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}
	
	
	
	
	
	
	
	
	
}
