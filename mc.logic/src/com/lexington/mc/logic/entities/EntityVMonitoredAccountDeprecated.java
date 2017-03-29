package com.lexington.mc.logic.entities;

import com.mallocinc.database.generated.to.VMonitoredAccountsTo;

public class EntityVMonitoredAccountDeprecated {
	VMonitoredAccountsTo to = new VMonitoredAccountsTo();

	public EntityVMonitoredAccountDeprecated() {
		// TODO Auto-generated constructor stub
	}
	
	public EntityVMonitoredAccountDeprecated(VMonitoredAccountsTo to) {
		super();
		this.to = to;
	}

	public VMonitoredAccountsTo getTo() {
		return to;
	}

	public void setTo(VMonitoredAccountsTo to) {
		this.to = to;
	}
}
