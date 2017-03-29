package com.lexington.mc.model.entities;

import java.math.BigDecimal;

import com.lexington.mc.model.blockchain.pojos.PojoApi;
import com.lexington.mc.model.blockchain.pojos.TransactionPojo;

public class EntityTransaction  extends EntityApi{

 
	private TransactionPojo transaction;
 private EntityBlock entityBlock;
 
 
public TransactionPojo getTransaction() {
	return transaction;
}
public void setTransaction(TransactionPojo transaction) {
	this.transaction = transaction;
}
public EntityBlock getEntityBlock() {
	return entityBlock;
}
public void setEntityBlock(EntityBlock entityBlock) {
	this.entityBlock = entityBlock;
}
@Override
public String getRowKey() {
	return transaction.getTxid().toString();
}
@Override
public PojoApi getPojo() {
	return transaction;
}
@Override
public void setPojo(PojoApi p) {
	transaction=(TransactionPojo)p;
	
}


 
 
}
