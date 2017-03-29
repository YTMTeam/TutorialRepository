package com.lexington.mc.webview.controllers;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.lexington.mc.logic.entities.EntityEmployeeDeprecated;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.entities.EntityEmployee;
import com.lexington.mc.model.singletons.datasource.EmployeeEntityDatasource;
import com.lexington.mc.webview.beans.ManageUser;
import com.lexington.mc.webview.datatable.impl.EmployeeMonitoredAccountsDatatable;
import com.lexington.mc.webview.util.FacesUtil;
import com.mallocinc.database.generated.to.EmployeeTo;

@ManagedBean(name = "employee")
@ViewScoped
public class EmployeeController {
	private String employeeId=null;
	EntityEmployee curEmployee;
	private boolean shouldInit=true;
	private boolean viewAccounts=true;	
	private EmployeeMonitoredAccountsDatatable accountsDatasource;
	EmployeeTo getEmployee;
	
	public void init(){
		
		if(shouldInit){
			
			
			 ManageUser manageUser=(ManageUser) FacesUtil.getSessionMapValue("user");
			
 
			if(employeeId!=null){
				 
					curEmployee=new EmployeeEntityDatasource().getEmployeeById(employeeId);
					accountsDatasource=new EmployeeMonitoredAccountsDatatable(curEmployee);
			 
					if(!manageUser.getCurUser().getEntityBank().canSeeEmployee(curEmployee)){
						indexRedirect();
						return;
						
					}
					
					
			}
			shouldInit=false;
		}
		
	}
	
	private void indexRedirect() {
		FacesUtil.setSessionMapValue("homeInfo", "notAuthorized");
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
		} catch (IOException e) {
			FacesUtil.throwError("somethingWentWrong");
			return;
		}
		return;
		
	}

	public void refreshFilters(){
		accountsDatasource.refreshFilters();
	}
	
	private void refreshDataSources(){
		accountsDatasource = new EmployeeMonitoredAccountsDatatable(curEmployee);
	}
	
	
	public void resetFlags(){
		
		viewAccounts=false;
	}
	
	public void generateAccounts(){
		
		resetFlags();
		viewAccounts=true;
	}
	

	public boolean isViewAccounts() {
		return viewAccounts;
	}

	public void setViewAccounts(boolean viewAccounts) {
		this.viewAccounts = viewAccounts;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public EntityEmployee getCurEmployee() {
		return curEmployee;
	}

	public boolean isShouldInit() {
		return shouldInit;
	}

	public EmployeeMonitoredAccountsDatatable getAccountsDatasource() {
		return accountsDatasource;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public void setCurEmployee(EntityEmployee  curEmployee) {
		this.curEmployee = curEmployee;
	}

	public void setShouldInit(boolean shouldInit) {
		this.shouldInit = shouldInit;
	}

	public void setAccountsDatasource(EmployeeMonitoredAccountsDatatable accountsDatasource) {
		this.accountsDatasource = accountsDatasource;
	}

	public EmployeeTo getGetEmployee() {
		return getEmployee;
	}

	public void setGetEmployee(EmployeeTo getEmployee) {
		this.getEmployee = getEmployee;
	}
	
	
}
