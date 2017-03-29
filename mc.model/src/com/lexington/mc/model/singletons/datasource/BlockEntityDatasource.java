package com.lexington.mc.model.singletons.datasource;

import java.util.ArrayList;

import com.lexington.mc.model.entities.EntityAccount;
import com.lexington.mc.model.entities.EntityBlock;
import com.lexington.mc.model.util.IEntityDatasourceCreator;

public class BlockEntityDatasource implements IEntityDatasourceCreator {
  
	private static ArrayList<EntityBlock> blocks = new ArrayList<>();
	
	public static ArrayList<EntityBlock> getAll() {
		return blocks;
	}

 
	
	
}
