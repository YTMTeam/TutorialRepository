package com.lexington.mc.webview.datatable.impl;

import com.lexington.mc.logic.providers.AccountProvider;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.entities.EntityEmployee;
import com.lexington.mc.model.entities.EntityMonitor;
import com.lexington.mc.webview.datatable.api.Datatable;

public class EmployeeMonitoredAccountsDatatable extends Datatable<EntityMonitor>{

	EntityEmployee employee;

	public EmployeeMonitoredAccountsDatatable(EntityEmployee employee) {
		 
		this.employee = employee;
		refreshDataSource();
	}

	@Override
	public void refreshDataSource()  {
		// TODO 
      
          super.setDatasource(employee.getEntityMonitors());
          super.setFilteredEntities(getDatasource());
     
       
	}

	public EntityEmployee getEmployee() {
		return employee;
	}

	public void setEmployee(EntityEmployee employee) {
		this.employee = employee;
	}
	
	 

}
