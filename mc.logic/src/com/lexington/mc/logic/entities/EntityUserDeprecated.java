package com.lexington.mc.logic.entities;

import com.mallocinc.database.generated.to.UsersTo;

public class EntityUserDeprecated {
	UsersTo to;

	public EntityUserDeprecated(UsersTo user) {
		to=user;
	}

	public UsersTo getTo() {
		return to;
	}

	public void setTo(UsersTo to) {
		this.to = to;
	}
	
}
