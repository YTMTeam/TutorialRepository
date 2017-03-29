package com.lexington.mc.model.singletons.lists;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.mallocinc.database.generated.to.HouseholdTo;


public class HouseholdList {
	private static ArrayList<HouseholdTo> households = new ArrayList<>();
	private static long sequence = 1;
	
	public static ArrayList<HouseholdTo> getAll() {
		return households;
	}
	
	/**
	 * Utility methods will be added below if necessary
	 */
	public static void add(HouseholdTo newHousehold) {
		newHousehold.setHOUSEHOLD_ID(new BigDecimal(sequence));
		households.add(newHousehold);
		sequence++;
	}
}
