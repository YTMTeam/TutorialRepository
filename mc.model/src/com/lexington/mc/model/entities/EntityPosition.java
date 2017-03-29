package com.lexington.mc.model.entities;

import java.math.BigDecimal;

import com.lexington.mc.model.blockchain.pojos.AccountPojo;
import com.lexington.mc.model.blockchain.pojos.PojoApi;
import com.lexington.mc.model.blockchain.pojos.PositionPojo;

public class EntityPosition  extends EntityApi{

 
	private PositionPojo position;
	private EntityAccount entityAccount;
	
	
	public PositionPojo getPosition() {
		return position;
	}
	public void setPosition(PositionPojo position) {
		this.position = position;
	}
	public EntityAccount getEntityAccount() {
		return entityAccount;
	}
	public void setEntityAccount(EntityAccount entityAccount) {
		this.entityAccount = entityAccount;
	}
	@Override
	public String getRowKey() {
		return position.getPOSITION_ID();
	}
	@Override
	public PojoApi getPojo() {
		return position;
	}
	@Override
	public void setPojo(PojoApi p) {
		position=(PositionPojo) p;
		
	}


	
	

	
}
