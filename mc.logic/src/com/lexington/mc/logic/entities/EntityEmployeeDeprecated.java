package com.lexington.mc.logic.entities;

import com.mallocinc.database.generated.to.EmployeeTo;

public class EntityEmployeeDeprecated {
	EmployeeTo to;

	public EntityEmployeeDeprecated(EmployeeTo to) {
	   this.to = to;
	}
	
	public EmployeeTo getTo() {
		return to;
	}

	public void setTo(EmployeeTo to) {
		this.to = to;
	}
	
	
}
