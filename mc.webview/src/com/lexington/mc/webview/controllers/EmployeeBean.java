package com.lexington.mc.webview.controllers;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import com.lexington.mc.model.blockchain.pojos.AccountPojo;
import com.lexington.mc.model.blockchain.pojos.BankPojo;
import com.lexington.mc.model.blockchain.pojos.EmployeePojo;
import com.lexington.mc.model.blockchain.pojos.MonitorPojo;
import com.lexington.mc.model.entities.EntityAccount;
import com.lexington.mc.model.entities.EntityEmployee;



@ManagedBean(name="employeeTable")
public class EmployeeBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	EmployeePojo employeeTo = new EmployeePojo();
	EmployeePojo employeeTo2 = new EmployeePojo();
	EmployeePojo employeeTo3 = new EmployeePojo();
	AccountPojo accountTo = new AccountPojo();
	
	private ArrayList<EntityEmployee> list;
		
	public EmployeeBean() {
			list=new ArrayList<>();
			
			EntityEmployee e = new EntityEmployee();
			EntityAccount a = new EntityAccount();
			a.setAccount(accountTo);
			e.setEmployee(employeeTo);
			
			list.add(e);
			
		
			EntityEmployee e2 = new EntityEmployee();
			e2.setEmployee(employeeTo2);
			list.add(e2);	
			
		
			EntityEmployee e3 = new EntityEmployee();
			e3.setEmployee(employeeTo3);
			list.add(e3);	
	}
	

	public AccountPojo getAccountTo() {
		return accountTo;
	}


	public void setAccountTo(AccountPojo accountTo) {
		this.accountTo = accountTo;
	}


	public ArrayList<EntityEmployee> getList() {
		return list;
	}

	public void setList(ArrayList<EntityEmployee> list) {
		this.list = list;
	}

	public EmployeePojo getEmployeeTo() {
		return employeeTo;
	}

	public void setEmployeeTo(EmployeePojo employeeTo) {
		this.employeeTo = employeeTo;
	}



	public EmployeePojo getEmployeeTo2() {
		return employeeTo2;
	}


	public void setEmployeeTo2(EmployeePojo employeeTo2) {
		this.employeeTo2 = employeeTo2;
	}


	public EmployeePojo getEmployeeTo3() {
		return employeeTo3;
	}


	public void setEmployeeTo3(EmployeePojo employeeTo3) {
		this.employeeTo3 = employeeTo3;
	}



	
	
	
	

	
	
	
	
	
	
}
