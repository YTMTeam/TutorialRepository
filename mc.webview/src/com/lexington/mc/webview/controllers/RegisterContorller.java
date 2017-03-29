package com.lexington.mc.webview.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.faces.bean.ManagedBean;

import com.lexington.mc.model.entities.EntityBank;
import com.lexington.mc.model.entities.EntityEmployee;
import com.lexington.mc.model.entities.EntityUser;
import com.lexington.mc.model.singletons.datasource.BankEntityDatasource;
import com.lexington.mc.model.singletons.datasource.EmployeeEntityDatasource;

@ManagedBean(name="register")
public class RegisterContorller {

	EntityBank curBank;
	EntityUser curUser;
	BigDecimal selectedBankId;
	private ArrayList<EntityBank> allBanks = BankEntityDatasource.getAll();
	
	public LinkedHashMap<String, String> getBankHashMap() {
		LinkedHashMap<String, String> employeeMap = new LinkedHashMap<String, String>();
		if(allBanks!=null){
		for (EntityBank t : allBanks) {
			employeeMap.put(t.getBank().getBANK_CODE() , t.getBank().getBANK_ID()+"");
		}
		}
		return employeeMap;
	}
	
	
	public void registerButton(){
		EntityBank selectedBank = BankEntityDatasource.getByBankId(selectedBankId);   
		if (selectedBank == null) {
			return;
		}
		curUser.setEntityBank(selectedBank);
	}

	public EntityBank getCurBank() {
		return curBank;
	}

	public void setCurBank(EntityBank curBank) {
		this.curBank = curBank;
	}

	public EntityUser getCurUser() {
		return curUser;
	}

	public void setCurUser(EntityUser curUser) {
		this.curUser = curUser;
	}

	public ArrayList<EntityBank> getAllBanks() {
		return allBanks;
	}

	public void setAllBanks(ArrayList<EntityBank> allBanks) {
		this.allBanks = allBanks;
	}

	public BigDecimal getSelectedBankId() {
		return selectedBankId;
	}

	public void setSelectedBankId(BigDecimal selectedBankId) {
		this.selectedBankId = selectedBankId;
	}
	
	
	
	
}
