package com.lexington.mc.model.entities;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.lexington.mc.model.blockchain.pojos.BlockPojo;
import com.lexington.mc.model.blockchain.pojos.PojoApi;

public class EntityBlock  extends EntityApi{
 
private BlockPojo block;
private ArrayList<EntityTransaction> entityTransactions = new ArrayList<>();


public BlockPojo getBlock() {
	return block;
}
public void setBlock(BlockPojo block) {
	this.block = block;
}
public ArrayList<EntityTransaction> getEntityTransactions() {
	return entityTransactions;
}
public void setEntityTransactions(ArrayList<EntityTransaction> entityTransactions) {
	this.entityTransactions = entityTransactions;
}
@Override
public String getRowKey() {
	return block.getBlockId().toString();
}
@Override
public PojoApi getPojo() {
	return block;
}
@Override
public void setPojo(PojoApi p) {
	block = (BlockPojo) p;
	
}
public void addTransactions(EntityTransaction a) {
	// TODO Auto-generated method stub
	EntityTransaction found=null;
	for(EntityTransaction e: getEntityTransactions()){
		if(e.getTransaction().getTxid().equals(a.getTransaction().getTxid()))
		{
			found=e;
			break;	
		}
	}
	if(found==null){
		getEntityTransactions().add(a);			
	}
	
	else
	{
		getEntityTransactions().remove(found);
		getEntityTransactions().add(a);			
	}
	
}




}
