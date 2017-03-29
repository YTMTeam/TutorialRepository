package com.lexington.mc.model.singletons.datasource;

import java.util.ArrayList;

import com.lexington.mc.model.entities.EntityTrade;
import com.lexington.mc.model.entities.EntityTransaction;
import com.lexington.mc.model.util.IEntityDatasourceCreator;

public class TransactionEntityDatasource implements IEntityDatasourceCreator {
  
	private static ArrayList<EntityTransaction> trades = new ArrayList<>();
	
	public static ArrayList<EntityTransaction> getAll() {
		return trades;
	}

 

	
}
