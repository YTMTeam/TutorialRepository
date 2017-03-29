package com.lexington.mc.model.entities;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.apache.log4j.chainsaw.Main;

import com.lexington.mc.model.blockchain.pojos.AccountPojo;
import com.lexington.mc.model.blockchain.pojos.BankPojo;
import com.lexington.mc.model.blockchain.pojos.EmployeePojo;
import com.lexington.mc.model.blockchain.pojos.MonitorPojo;
import com.lexington.mc.model.blockchain.pojos.PojoApi;
import com.lexington.mc.model.blockchain.pojos.TradePojo;
import com.lexington.mc.model.blockchain.pojos.UserPojo;
import com.lexington.mc.model.singletons.datasource.BankEntityDatasource;
import com.lexington.mc.model.singletons.datasource.MonitorEntityDatasource;
import com.lexington.mc.model.util.UtilCodeTypes;
import com.mallocinc.shared.util.time.TimestampUtility;

public class EntityBank  extends EntityApi{

   UtilCodeTypes uct = new UtilCodeTypes();
	 
 	private BankPojo bank ;
	private ArrayList<EntityEmployee> entityEmployees=new ArrayList<>();
	private ArrayList<EntityAccount> entityAccounts=new ArrayList<>();
	private ArrayList<EntityMonitor> entityMonitors=new ArrayList<>(); //all internal monitoring
	private ArrayList<EntityTrade> entityTrades=new ArrayList<>();
	private ArrayList<EntityUser> entityUsers=new ArrayList<>();
	
	public BankPojo getBank() {
		return bank;
	}
	public void setBank(BankPojo bank) {
		this.bank = bank;
	}
	public ArrayList<EntityEmployee> getEntityEmployees() {
		return entityEmployees;
	}
	public void setEntityEmployees(ArrayList<EntityEmployee> entityEmployees) {
		this.entityEmployees = entityEmployees;
	}
	public ArrayList<EntityAccount> getEntityAccounts() {
		return entityAccounts;
	}
	public void setEntityAccounts(ArrayList<EntityAccount> entityAccounts) {
		this.entityAccounts = entityAccounts;
	}
	public ArrayList<EntityMonitor> getEntityMonitors() {
		return entityMonitors;
	}
	public void setEntityMonitors(ArrayList<EntityMonitor> entityMonitors) {
		this.entityMonitors = entityMonitors;
	}
	public ArrayList<EntityTrade> getEntityTrades() {
		return entityTrades;
	}
	public void setEntityTrades(ArrayList<EntityTrade> entityTrades) {
		this.entityTrades = entityTrades;
	}
	public ArrayList<EntityUser> getEntityUsers() {
		return entityUsers;
	}
	public void setEntityUsers(ArrayList<EntityUser> entityUsers) {
		this.entityUsers = entityUsers;
	}
	@Override
	public String getRowKey() {
		return bank.getRowKey();
	}
	@Override
	public PojoApi getPojo() {
		return bank;
	}
	@Override
	public void setPojo(PojoApi p) {
		bank=(BankPojo) p;
		
	}
	
	
 /**
  * Entity "query" methods
  */
	/**
	 * 
	 * 
	 * @param status - values : UtilCodeTypes.MonitorStatus
	 * @param type - values : UtilCodeTypes.MonitorType
	 * @return
	 */
	public ArrayList<EntityMonitor> getMonitorsByStatusAndType(String status, String type) {
	  
		return MonitorEntityDatasource.getMonitorsByStatusAndTypeAndBank(status, type, bank.getBANK_ID());
		

	}
	
	public ArrayList<EntityMonitor> filterVisibleMonitors(ArrayList<EntityMonitor> monitors) {
	   
	   ArrayList<EntityMonitor> visibleMonitors = new ArrayList<>();
	   
	   for(EntityMonitor monitor : monitors) {
	      if(monitor.getEntityAccount().getAccount().getTYPE() != null &&
	         uct.YesNoIndicator.Codes.YES.equals(monitor.getMonitor().getEMP_BANK_APPROVED()) &&
	         uct.YesNoIndicator.Codes.YES.equals(monitor.getMonitor().getOUT_BANK_APPROVED())) {
	         visibleMonitors.add(monitor);
	      }
	   }
	   return visibleMonitors;
	}
	public ArrayList<EntityAccount> filterVisibleAccounts(ArrayList<EntityAccount> accounts) {
	   
	   ArrayList<EntityAccount> visibleAccounts = new ArrayList<>();
	   
	   for(EntityAccount account : accounts) {
	      if(account.getAccount().getTYPE() != null) {
	         visibleAccounts.add(account);
	      }
	   }
	   return visibleAccounts;
	}
		
	//TODO Ivan in every other occassion
	public void addAccount(EntityAccount a) {
		EntityAccount found=null;
		for(EntityAccount e: getEntityAccounts()){
			if(e.getAccount().getACCOUNT_ID().equals(a.getAccount().getACCOUNT_ID()))
			{
				found=e;
				break;	
			}
		}
		if(found==null){
			getEntityAccounts().add(a);			
		}
		
		else
		{
			getEntityAccounts().remove(found);
			getEntityAccounts().add(a);			
		}
		
	}
	public void addMonitor(EntityMonitor a) {
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
	public void addEmployee(EntityEmployee a) {
		// TODO Auto-generated method stub
		EntityEmployee found=null;
		for(EntityEmployee e: getEntityEmployees()){
			if(e.getEmployee().getEMPLOYEE_ID().equals(a.getEmployee().getEMPLOYEE_ID()))
			{
				found=e;
				break;	
			}
		}
		if(found==null){
			getEntityEmployees().add(a);			
		}
		
		else
		{
			getEntityEmployees().remove(found);
			getEntityEmployees().add(a);			
		}
	}
	public void addUser(EntityUser a) {
		// TODO Auto-generated method stub
		EntityUser found=null;
		for(EntityUser e: getEntityUsers()){
			if(e.getUser().getUSER_ID().equals(a.getUser().getUSER_ID()))
			{
				found=e;
				break;	
			}
		}
		if(found==null){
			getEntityUsers().add(a);			
		}
		
		else
		{
			getEntityUsers().remove(found);
			getEntityUsers().add(a);			
		}
	}
	
	   public void addTrade(EntityTrade a) {
	        // TODO Auto-generated method stub
	        EntityTrade found=null;
	        for(EntityTrade e: getEntityTrades()){
	            if(e.getTrade().getTRADE_ID().equals(a.getTrade().getTRADE_ID()))
	            {
	                found=e;
	                break;  
	            }
	        }
	        if(found==null){
	            getEntityTrades().add(a);            
	        }
	        
	        else
	        {
	            getEntityTrades().remove(found);
	            getEntityTrades().add(a);            
	        }
	    }
	public boolean canSeeEmployee(EntityEmployee curEmployee) {
		return curEmployee.getEntityBank().getBank().getBANK_ID().equals(bank.getBANK_ID());
	}
	
	
	public boolean canSeeAccount(EntityAccount curAccount) {
		for(EntityAccount a: entityAccounts){
			if(curAccount.getAccount().getACCOUNT_ID().equals(a.getAccount().getACCOUNT_ID())){
				return true;	
			}
		}
		
		for(EntityMonitor a: entityMonitors){
			if(curAccount.getAccount().getACCOUNT_ID().equals(a.getEntityAccount().getAccount().getACCOUNT_ID())){
				return true;	
				
			}
		}
		
		return false;
	}
	
	
	
	public EntityMonitor getAccountMonitor(EntityAccount curAccount){
		
		for(EntityMonitor a: entityMonitors){
			if(curAccount.getAccount().getACCOUNT_ID().equals(a.getEntityAccount().getAccount().getACCOUNT_ID())){
				return a;
				
			}
			
		}
		return null;
	}
	   
}
