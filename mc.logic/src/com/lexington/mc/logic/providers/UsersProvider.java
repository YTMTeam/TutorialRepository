package com.lexington.mc.logic.providers;

import java.sql.Connection;

import com.lexington.mc.logic.entities.EntityUserDeprecated;
import com.lexington.mc.logic.util.Connect;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.tables.DataUser;
import com.mallocinc.codegenerator.exceptions.GDAOException;
import com.mallocinc.database.generated.to.UsersTo;

public class UsersProvider {

	DataUser dataUser = new DataUser();
	
	public EntityUserDeprecated getUserByUsernameForLogin(String userName) throws MessageException {
		
		Connection conn = null;
		UsersTo user = new UsersTo();
		
		try {
			conn = Connect.obtainConn(conn);
			user = dataUser.getUserByUsername(conn, userName);
		} catch (GDAOException e) {
			throw new MessageException("somethingWentWrong");
		} finally {
		   Connect.returnConn(conn);
		}
		
		if(user==null){
			throw new MessageException("loginFailed");
		}
		return new EntityUserDeprecated(user);
	}
}
