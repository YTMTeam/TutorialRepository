package com.lexington.mc.logic.entities;

import com.mallocinc.database.generated.to.AccountTo;
import com.mallocinc.database.generated.to.PositionTo;

public class EntityPositionDeprecated {
	
	PositionTo to = new PositionTo();

	public EntityPositionDeprecated() {
		// TODO Auto-generated constructor stub
	}
	
	public EntityPositionDeprecated(PositionTo to) {
		super();
		this.to = to;
	}

	public PositionTo getTo() {
		return to;
	}

	public void setTo(PositionTo to) {
		this.to = to;
	}
		
}
