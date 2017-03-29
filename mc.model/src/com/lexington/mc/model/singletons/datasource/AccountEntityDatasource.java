package com.lexington.mc.model.singletons.datasource;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.lexington.mc.model.entities.EntityAccount;
import com.lexington.mc.model.entities.EntityBank;
import com.lexington.mc.model.entities.EntityMonitor;
import com.lexington.mc.model.entities.EntityPosition;
import com.lexington.mc.model.entities.EntityTrade;
import com.lexington.mc.model.util.IEntityDatasourceCreator;
import com.mallocinc.database.generated.to.AccountTo;

public class AccountEntityDatasource implements IEntityDatasourceCreator {
  
	private static ArrayList<EntityAccount> accounts = new ArrayList<>();
	
	public static ArrayList<EntityAccount> getAll() {
		return accounts;
	}
	public static ArrayList<EntityAccount> getAllVisibleAccounts() {
	   
	   ArrayList<EntityAccount> visibleAccounts = new ArrayList<>();
	   
	   for(EntityAccount account : accounts) {
	      if(account.getAccount().getTYPE() != null) {
	         visibleAccounts.add(account);
	      }
	   }
	   
	   return visibleAccounts;
	}
	
 
	public static EntityAccount getAccountByAccountId(String account_ID) {
		for(EntityAccount e :accounts){
			if(e.getAccount().getACCOUNT_ID().equals(account_ID)){
				return e;	
			}	
		}
		return null;
	}

		
	    public static ArrayList<EntityAccount> getAccountBySignutureDate(String bankId,java.sql.Timestamp date1, java.sql.Timestamp date2){
//	      long dateLong1 = date1.getTime();
//	      long dateLong2 = date2.getTime();

	        ArrayList<EntityAccount> entityAccount = new ArrayList<>();
	        
	        for(EntityMonitor m : MonitorEntityDatasource.getAll()) {
	           if(m.getEntityEmployee().getEntityBank().getBank().getBANK_ID().toString().equals(bankId)) {
	                 
	                 if(m.getEntityAccount().getAccount().getCREATE_TIMESTAMP().getTime() > date1.getTime()
	                       && m.getEntityAccount().getAccount().getCREATE_TIMESTAMP().getTime() < date2.getTime()) {
	                     entityAccount.add(m.getEntityAccount());
	                 }
	           }
	        }

	        return entityAccount;
	    }
	
	
	//FOR STATS
	public static int getAccountsSize(String account_id){
		ArrayList<EntityAccount> list = new ArrayList<>();
		for(EntityAccount e : accounts){
			if(e.getAccount().getACCOUNT_ID().equals(account_id)){
				list.add(e);
			}
		}
		return list.size();
	}
	
	
	
}
