package com.lexington.mc.webview.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.lexington.mc.logic.providers.AccountProvider;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.entities.EntityAccount;
import com.lexington.mc.model.entities.EntityBank;
import com.lexington.mc.model.entities.EntityMonitor;
import com.lexington.mc.model.singletons.datasource.AccountEntityDatasource;
import com.lexington.mc.model.singletons.datasource.BankEntityDatasource;
import com.lexington.mc.webview.beans.ManageUser;
import com.lexington.mc.webview.util.FacesUtil;
import com.mallocinc.database.generated.to.MonitorTo;
import com.mallocinc.shared.util.time.TimestampUtility;

@ViewScoped
@ManagedBean(name="account")
public class AccountController {
	private EntityAccount curAccount;
	private String accountId=null;
	private FamilyController family;
	private TradesController trades;
	private ArrayList<EntityMonitor> monitors;
	private BigDecimal [] selectedMonitors; 
	private boolean shouldInit=true;
	private ArrayList<EntityBank> allBanks=new ArrayList<>();
	
	 AccountEntityDatasource accountProvider= new AccountEntityDatasource();
	 EntityMonitor curBankMonitoringInfo =null; //not null if current account is monitored by bank of the current user
	
	public void init(){
		if(shouldInit){
		 
		 ManageUser manageUser=(ManageUser) FacesUtil.getSessionMapValue("user");
		
		curAccount=AccountEntityDatasource.getAccountByAccountId(accountId);
		
		if(!manageUser.getCurUser().getEntityBank().canSeeAccount(curAccount)){
			indexRedirect();
			return;
			
		}
		
		family=new FamilyController();
		family.setCurUser(curAccount);
		//family.generateFamilyMembers();
		family.setCurFamilyMember(curAccount);
		
  		
		
		/**getting information about monitoring   **/
		curBankMonitoringInfo=manageUser.getCurUser().getEntityBank().getAccountMonitor(curAccount);
		if(curBankMonitoringInfo!=null){
			trades=new TradesController(curAccount, curBankMonitoringInfo.getMonitor().getAS_OF_DATE(), curBankMonitoringInfo.getMonitor().getEND_DATE());
			
		}
		
		else
			trades=new TradesController(curAccount, null, null);
			trades.setViewUserTrades(true);
		
  		refreshMonitoredAccounts();
  		allBanks=BankEntityDatasource.getAll();
		family.setViewFamily(false);
		shouldInit=false;
	 
		}
	}
	
	
	private void indexRedirect() {
		// TODO Auto-generated method stub
		
	}


	private void refreshMonitoredAccounts() {
		 
 
	
	    monitors= curAccount.getEntityMonitor();

		selectedMonitors=new BigDecimal[monitors.size()];
		int i = 0;
 
		for(EntityMonitor m: monitors){
			selectedMonitors[i++]=m.getEntityEmployee().getEmployee().getBANK_ID();
			
		}
		return;
	}


	public LinkedHashMap<String, BigDecimal> getBankHashMap(){
		  LinkedHashMap<String, BigDecimal> bankMap = new LinkedHashMap<String, BigDecimal>();
		  for (EntityBank t : allBanks) {
			  if(!t.getBank().getBANK_ID().equals(curAccount.getEntityBank().getBank().getBANK_ID())){
				  bankMap.put(t.getBank().getBANK_NAME(), t.getBank().getBANK_ID());
				  
			  }
			  
		  }
		  return bankMap;
	}
	
	public void selectNewUserById(String userId){
	 
			curAccount= AccountEntityDatasource.getAccountByAccountId(userId) ;
		 
		
		family=new FamilyController();
		family.setCurUser(curAccount);
//		family.generateFamilyMembers();
		family.setCurFamilyMember(curAccount);
		trades=new TradesController(curAccount, null, null);
//		if(oneButtonSwitchValue!= VIEW_FAMILY && oneButtonSwitchValue != VIEW_TRADES){
//			oneButtonSwitchValue=VIEW_FAMILY;
//			
//		}
//		
//		if(oneButtonSwitchValue == VIEW_FAMILY){
//			family.setCurFamilyMember(curUser);
//			
//			
//		}
		
	}
	
	
	public void updateMonitors(){
		ArrayList<MonitorTo> toUpdate=new ArrayList<>();
		
		for(BigDecimal b: selectedMonitors){
			MonitorTo m = new MonitorTo();
			m.setACCOUNT_ID(accountId);
			m.setBANK_ID(b);
			m.setCREATE_TIMESTAMP(TimestampUtility.getCurrentTimestamp());
			toUpdate.add(m);
		}
		
		try {
			new AccountProvider().updateAccountMonitors(toUpdate,accountId);
		} catch (MessageException e) {
			FacesUtil.throwMessage(e);
			return;
		}
		FacesUtil.throwInfo("updatedMonitors");
	}
	
	
	public void clearFilters(){
 
		family.setListMembers(null);
 
	}
	
	public void selectNewUser(EntityAccount userNew){
		 
			curAccount=userNew;
		 
		
		family=new FamilyController();
		family.setCurUser(curAccount);
//		family.generateFamilyMembers();
		family.setCurFamilyMember(curAccount);
		trades=new TradesController(curAccount, null, null);
		 
//			oneButtonSwitchValue=VIEW_TRADES;	
	}


	public EntityAccount getCurAccount() {
		return curAccount;
	}


	public void setCurAccount(EntityAccount curUser) {
		this.curAccount = curUser;
	}


	public String getAccountId() {
		return accountId;
	}


	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}


	public FamilyController getFamily() {
		return family;
	}


	public void setFamily(FamilyController family) {
		this.family = family;
	}


	public TradesController getTrades() {
		return trades;
	}


	public void setTrades(TradesController trades) {
		this.trades = trades;
	}


 


	public ArrayList<EntityBank > getAllBanks() {
		return allBanks;
	}


	public void setAllBanks(ArrayList<EntityBank > allBanks) {
		this.allBanks = allBanks;
	}


	public BigDecimal [] getSelectedMonitors() {
		return selectedMonitors;
	}


	public void setSelectedMonitors(BigDecimal [] selectedMonitors) {
		this.selectedMonitors = selectedMonitors;
	}


	public EntityMonitor getCurBankMonitoringInfo() {
		return curBankMonitoringInfo;
	}


	public void setCurBankMonitoringInfo(EntityMonitor curBankMonitoringInfo) {
		this.curBankMonitoringInfo = curBankMonitoringInfo;
	}
	
	
}
