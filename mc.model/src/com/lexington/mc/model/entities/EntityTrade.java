package com.lexington.mc.model.entities;

import java.math.BigDecimal;

import com.lexington.mc.model.blockchain.common.BlockchainConstants;
import com.lexington.mc.model.blockchain.pojos.AccountPojo;
import com.lexington.mc.model.blockchain.pojos.BankPojo;
import com.lexington.mc.model.blockchain.pojos.PojoApi;
import com.lexington.mc.model.blockchain.pojos.TradePojo;

public class EntityTrade  extends EntityApi{
 
private TradePojo trade;
private EntityAccount entityAccount;
private EntityBank entityBank;



public TradePojo getTrade() {
	return trade;
}
public void setTrade(TradePojo trade) {
	this.trade = trade;
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
@Override
public String getRowKey() {
	return trade.getTRADE_ID();
}
@Override
public PojoApi getPojo() {
	return trade;
}
@Override
public void setPojo(PojoApi p) {
	 trade=(TradePojo) p;
	
}

public boolean isBuyDirection(){
	return BlockchainConstants.DirectionStatus.BUY.equals(trade.getTRANSACTION_TYPE()); 
	
}

public boolean isSellDirection(){
	return BlockchainConstants.DirectionStatus.SELL.equals(trade.getTRANSACTION_TYPE()); 
	
}


}
