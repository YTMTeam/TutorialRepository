package com.lexington.mc.logic.entities;

import com.mallocinc.database.generated.to.BankTo;

public class EntityBankDeprecated {
	
	BankTo bankTo;
	
	public EntityBankDeprecated(BankTo bankTo) {
		this.bankTo = bankTo;
	}

	public BankTo getBankTo() {
		return bankTo;
	}

	public void setBankTo(BankTo bankTo) {
		this.bankTo = bankTo;
	}
	
	
	
	

}
