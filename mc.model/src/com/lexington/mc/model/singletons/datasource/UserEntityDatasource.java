package com.lexington.mc.model.singletons.datasource;

import java.util.ArrayList;

import com.lexington.mc.model.entities.EntityBank;
import com.lexington.mc.model.entities.EntityEmployee;
import com.lexington.mc.model.entities.EntityUser;
import com.lexington.mc.model.util.IEntityDatasourceCreator;

public class UserEntityDatasource implements IEntityDatasourceCreator {
  
	private static ArrayList<EntityUser> users = new ArrayList<>();
	
	public static ArrayList<EntityUser> getAll() {
		return users;
	}

 

	public EntityUser getUserByUsernameForLogin(String username) {
		for(EntityUser e :users){
			if(e.getUser().getUSER_NAME().equals(username)){
				return e;	
			}	
		}
		return null;
	}
	
	
}
