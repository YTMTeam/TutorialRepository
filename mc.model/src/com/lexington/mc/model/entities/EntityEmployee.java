package com.lexington.mc.model.entities;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.lexington.mc.model.blockchain.pojos.BankPojo;
import com.lexington.mc.model.blockchain.pojos.EmployeePojo;
import com.lexington.mc.model.blockchain.pojos.PojoApi;

public class EntityEmployee  extends EntityApi{

 
	private EmployeePojo employee ;
	private EntityBank entityBank;
//	private ArrayList<EntityAccount> entityAccounts=new ArrayList<>();
	private ArrayList<EntityMonitor> entityMonitors=new ArrayList<>();
	
	
	

	public EmployeePojo getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeePojo employee) {
		this.employee = employee;
	}

	public EntityBank getEntityBank() {
		return entityBank;
	}
	public void setEntityBank(EntityBank entityBank) {
		this.entityBank = entityBank;
	}
//	public ArrayList<EntityAccount> getEntityAccounts() {
//		return entityAccounts;
//	}
//	public void setEntityAccounts(ArrayList<EntityAccount> entityAccounts) {
//		this.entityAccounts = entityAccounts;
//	}
	public ArrayList<EntityMonitor> getEntityMonitors() {
		return entityMonitors;
	}
	public void setEntityMonitors(ArrayList<EntityMonitor> entityMonitors) {
		this.entityMonitors = entityMonitors;
	}
	@Override
	public String getRowKey() {
		return employee.getEMPLOYEE_ID();
	}
	@Override
	public PojoApi getPojo() {
		return employee;
	}
	@Override
	public void setPojo(PojoApi p) {
		employee=(EmployeePojo) p;
	}
	
	
	public void addMonitor(EntityMonitor a) {
		// TODO Auto-generated method stub
		EntityMonitor found=null;
		for(EntityMonitor e: getEntityMonitors()){
			if(e.getMonitor().getMONITOR_ID().equals(a.getMonitor().getMONITOR_ID()))
			{
				found=e;
				break;	
			}
		}
		if(found==null){
			getEntityMonitors().add(a);			
		}
		
		else
		{
			getEntityMonitors().remove(found);
			getEntityMonitors().add(a);			
		}
	}


	
	
}
