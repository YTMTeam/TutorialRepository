package com.lexington.mc.model.singletons.datasource;

import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.lexington.mc.model.entities.EntityAccount;
import com.lexington.mc.model.entities.EntityBank;
import com.lexington.mc.model.entities.EntityMonitor;
import com.lexington.mc.model.entities.EntityTrade;
import com.lexington.mc.model.entities.EntityTransaction;
import com.lexington.mc.model.util.IEntityDatasourceCreator;

public class TradeEntityDatasource implements IEntityDatasourceCreator {
  
	private static ArrayList<EntityTrade> trades = new ArrayList<>();
	
	public static ArrayList<EntityTrade> getAll() {
		return trades;
	}

	public static ArrayList<EntityTrade> getTradesByAccountId(String accountId) {
	   ArrayList<EntityTrade> entityTrades = new ArrayList<>();
	   
	   for(EntityTrade trade : trades) {
	      if(trade.getTrade().getACCOUNT_ID().equals(accountId)) {
	         entityTrades.add(trade);
	      }
	   }
	   
	   return entityTrades;
	}
	
	/**
	 * This method gets trades that are able to be seen by particular bank
	 * @param accountId
	 * @param bankId - current bank that is fetching available trades (required for monitoring check)
	 * @return
	 */
	public static ArrayList<EntityTrade> getAvailableTradesByAccountId(String accountId, String bankId) {
	   ArrayList<EntityTrade> entityTrades = new ArrayList<>();
	   
	   for(EntityTrade trade : trades) {
	      if(trade.getTrade().getACCOUNT_ID().equals(accountId)) {
	         boolean monitored = false;
	         
	         for(EntityMonitor m : trade.getEntityAccount().getEntityMonitor()) {
	            
	            
	            if(m.getEntityEmployee().getEntityBank().getBank().getBANK_ID().toString().equals(bankId)) {
	               
	               monitored = true;
	               
	               if(m.getMonitor().getAS_OF_DATE().getTime() < trade.getTrade().getTRADE_DATE().getTime() &&
	                     (m.getMonitor().getEND_DATE() == null || m.getMonitor().getEND_DATE().getTime() < trade.getTrade().getTRADE_DATE().getTime())) {
	                  entityTrades.add(trade);
	               }
	               
	            }
	         }
	         
	         if(!monitored) {
	            entityTrades.add(trade);
	         }
	         
	      }
	   }
	   
	   return entityTrades;
	}
	
	
	

	
	public static ArrayList<EntityTrade> getTradesBySignutureDate(String bankId,java.sql.Timestamp date1, java.sql.Timestamp date2){
//		long dateLong1 = date1.getTime();
//		long dateLong2 = date2.getTime();

		ArrayList<EntityTrade> entityTrade = new ArrayList<>();
		
		for(EntityMonitor m : MonitorEntityDatasource.getAll()) {
		   if(m.getEntityEmployee().getEntityBank().getBank().getBANK_ID().toString().equals(bankId)) {
		      for(EntityTrade t : m.getEntityAccount().getEntityTrade()) {
		         
		         if(t.getTrade().getTRADE_DATE().getTime() > date1.getTime()
		               && t.getTrade().getTRADE_DATE().getTime() < date2.getTime() 
		               && t.getTrade().getTRADE_DATE().getTime() > m.getMonitor().getAS_OF_DATE().getTime()
		               && 
		               (m.getMonitor().getEND_DATE() == null
		               || t.getTrade().getTRADE_DATE().before(m.getMonitor().getEND_DATE()))) {
		            entityTrade.add(t);
		         }
		      } 
		   }
		}

		return entityTrade;
	}
	
}
