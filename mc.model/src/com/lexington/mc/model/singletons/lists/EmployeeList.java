package com.lexington.mc.model.singletons.lists;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.lexington.mc.model.blockchain.pojos.PojoApi;
import com.mallocinc.database.generated.to.EmployeeTo;

public class EmployeeList {
	private ArrayList<PojoApi> employees = new ArrayList<>();
	
	public ArrayList<PojoApi> getAll() {
		return employees;
	}
	
	/**
	 * Utility methods will be added below if necessary
	 */
	public void add(PojoApi newEmployee) {
		employees.add(newEmployee);
	}
}
