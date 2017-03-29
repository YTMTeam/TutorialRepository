package com.lexington.mc.model.singletons.datasource;

import java.util.ArrayList;

import com.lexington.mc.model.entities.EntityEmployee;
import com.lexington.mc.model.util.IEntityDatasourceCreator;

public class EmployeeEntityDatasource implements IEntityDatasourceCreator {
  
	private static ArrayList<EntityEmployee> employees = new ArrayList<>();
	
	public static ArrayList<EntityEmployee> getAll() {
		return employees;
	}

 

	public static EntityEmployee getEmployeeById(String selectedEmployeeId) {
		for(EntityEmployee e :employees){
			if(e.getEmployee().getEMPLOYEE_ID().toString().equals(selectedEmployeeId)){
				return e;	
			}	
		}
		return null;
	}
	
	
}
