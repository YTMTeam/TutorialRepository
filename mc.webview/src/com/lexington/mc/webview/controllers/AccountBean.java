package com.lexington.mc.webview.controllers;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.lexington.mc.model.blockchain.pojos.AccountPojo;
import com.lexington.mc.model.blockchain.pojos.BankPojo;
import com.lexington.mc.model.blockchain.pojos.EmployeePojo;
import com.lexington.mc.model.blockchain.pojos.MonitorPojo;
import com.lexington.mc.model.entities.EntityAccount;
import com.lexington.mc.model.entities.EntityBank;
import com.lexington.mc.model.entities.EntityEmployee;
import com.lexington.mc.model.entities.EntityMonitor;

@ManagedBean(name = "accountTable")
@SessionScoped
public class AccountBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<EntityMonitor> lista;
	AccountPojo accountTo = new AccountPojo();
	MonitorPojo monitorTo = new MonitorPojo();
	BankPojo bankTo = new BankPojo();
	EmployeePojo employeeTo = new EmployeePojo();

	public AccountBean() {
		
		
		lista = new ArrayList<>();
		EntityMonitor emf = new EntityMonitor();
		EntityAccount a = new EntityAccount();
		EntityBank b = new  EntityBank();
		EntityEmployee e = new EntityEmployee();
		emf.setMonitor(monitorTo);
		a.setAccount(accountTo);
		b.setBank(bankTo);
		e.setEmployee(employeeTo);
		
		emf.setEntityAccount(a);
		emf.setEntityEmployee(e);
		emf.setEntityBank(b);
		
		lista.add(emf);

	}

	public ArrayList<EntityMonitor> getLista() {
		return lista;
	}

	public void setLista(ArrayList<EntityMonitor> lista) {
		this.lista = lista;
	}

	public AccountPojo getAccountTo() {
		return accountTo;
	}

	public void setAccountTo(AccountPojo accountTo) {
		this.accountTo = accountTo;
	}

	public MonitorPojo getMonitorTo() {
		return monitorTo;
	}

	public void setMonitorTo(MonitorPojo monitorTo) {
		this.monitorTo = monitorTo;
	}

	public BankPojo getBankTo() {
		return bankTo;
	}

	public void setBankTo(BankPojo bankTo) {
		this.bankTo = bankTo;
	}

	
	
	public EmployeePojo getEmployeeTo() {
		return employeeTo;
	}

	public void setEmployeeTo(EmployeePojo employeeTo) {
		this.employeeTo = employeeTo;
	}



}
