package com.lexington.mc.model.entities;

import java.math.BigDecimal;

import com.lexington.mc.model.blockchain.pojos.PojoApi;
import com.lexington.mc.model.blockchain.pojos.UserPojo;

public class EntityUser  extends EntityApi{

 
	private UserPojo user;
	private EntityBank entityBank;
	
	public UserPojo getUser() {
		return user;
	}
	public void setUser(UserPojo user) {
		this.user = user;
	}
	public EntityBank getEntityBank() {
		return entityBank;
	}
	public void setEntityBank(EntityBank entityBank) {
		this.entityBank = entityBank;
	}
	@Override
	public String getRowKey() {
		return user.getUSER_ID().toString();
	}
	@Override
	public PojoApi getPojo() {
		return user;
	}
	@Override
	public void setPojo(PojoApi p) {
		user=(UserPojo) p;
		
	}


	
	
	
}
