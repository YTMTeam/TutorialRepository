package com.lexington.mc.model.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.lexington.mc.model.blockchain.pojos.AccountPojo;
import com.lexington.mc.model.blockchain.pojos.PojoApi;
import com.lexington.mc.model.singletons.datasource.AccountEntityDatasource;

public class EntityAccount extends EntityApi{


	private AccountPojo account ;
	private EntityBank entityBank;
	private EntityEmployee entityEmployee;
	private ArrayList<EntityTrade> entityTrade=new ArrayList<>();
	private ArrayList<EntityMonitor> entityMonitor=new ArrayList<>();

	private ArrayList<EntityPosition> entityPositions = new ArrayList<>();


	public AccountPojo getAccount() {
		return account;
	}
	public void setAccount(AccountPojo account) {
		this.account = account;
	}
	public EntityBank getEntityBank() {
		return entityBank;
	}
	public void setEntityBank(EntityBank entityBank) {
		this.entityBank = entityBank;
	}
	public EntityEmployee getEntityEmployee() {
		return entityEmployee;
	}
	public void setEntityEmployee(EntityEmployee entityEmployee) {
		this.entityEmployee = entityEmployee;
	}
	public ArrayList<EntityTrade> getEntityTrade() {
		return entityTrade;
	}
	public void setEntityTrade(ArrayList<EntityTrade> entityTrade) {
		this.entityTrade = entityTrade;
	}
	public ArrayList<EntityMonitor> getEntityMonitor() {
		return entityMonitor;
	}
	public void setEntityMonitor(ArrayList<EntityMonitor> entityMonitor) {
		this.entityMonitor = entityMonitor;
	}
	@Override
	public String getRowKey() {
		return account.getRowKey();
	}
	@Override
	public PojoApi getPojo() {
		return account;
	}
	@Override
	public void setPojo(PojoApi p) {
		account=(AccountPojo) p;

	}
	public ArrayList<EntityPosition> getEntityPositions() {
		return entityPositions;
	}
	public void setEntityPositions(ArrayList<EntityPosition> entityPositions) {
		this.entityPositions = entityPositions;
	}

	public void addMonitor(EntityMonitor a) {
		EntityMonitor found=null;
		for(EntityMonitor e: getEntityMonitor()){
			if(e.getMonitor().getMONITOR_ID().equals(a.getMonitor().getMONITOR_ID()))
			{
				found=e;
				break;	
			}
		}
		if(found==null){
			getEntityMonitor().add(a);			
		}

		else
		{
			getEntityMonitor().remove(found);
			getEntityMonitor().add(a);			
		}

	}
	public void addPosition(EntityPosition a) {
		// TODO Auto-generated method stub
		EntityPosition found=null;
		for(EntityPosition e: getEntityPositions()){
			if(e.getPosition().getPOSITION_ID().equals(a.getPosition().getPOSITION_ID()))
			{
				found=e;
				break;	
			}
		}
		if(found==null){
			getEntityPositions().add(a);			
		}

		else
		{
			getEntityPositions().remove(found);
			getEntityPositions().add(a);			
		}
	}
	public void addTrade(EntityTrade a) {
		// TODO Auto-generated method stub
		EntityTrade found=null;
		for(EntityTrade e: getEntityTrade()){
			if(e.getTrade().getTRADE_ID().equals(a.getTrade().getTRADE_ID()))
			{
				found=e;
				break;	
			}
		}
		if(found==null){
			getEntityTrade().add(a);			
		}

		else
		{
			getEntityTrade().remove(found);
			getEntityTrade().add(a);			
		}
	}
	public ArrayList<EntityTrade> getTradesBeforeEndDate(Timestamp asOfDate, Timestamp endDate) {
		ArrayList<EntityTrade> lista=new ArrayList<>();

		for(EntityTrade t: getEntityTrade()){
			if(t.getTrade().getTRADE_DATE().after(asOfDate)){
				if(endDate==null || t.getTrade().getTRADE_DATE().before(endDate))
					lista.add(t);
			}

		}
		return lista;
	}

	public ArrayList<EntityPosition> getPositionsBeforeEndDate(Timestamp asOfDate, Timestamp endDate) {
		ArrayList<EntityPosition> lista=new ArrayList<>();
	 
		for(EntityPosition t: getEntityPositions()){
			if(t.getPosition().getSECURITY_DATE().after(asOfDate)){
				if(endDate==null || t.getPosition().getSECURITY_DATE().before(endDate))
					lista.add(t);
			}

		}
		return lista;
	}



}
