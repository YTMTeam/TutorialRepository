package com.lexington.mc.model.singletons.datasource;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.lexington.mc.model.entities.EntityMonitor;
import com.lexington.mc.model.entities.EntityPosition;
import com.lexington.mc.model.entities.EntityTrade;
import com.lexington.mc.model.util.IEntityDatasourceCreator;

public class PositionEntityDatasource implements IEntityDatasourceCreator {
  
	private static ArrayList<EntityPosition> positions = new ArrayList<>();
	
	public static ArrayList<EntityPosition> getAll() {
		return positions;
	}

	   public static ArrayList<EntityPosition> getPositionsByAccountId(String accountId) {
	       ArrayList<EntityPosition> entityPositions = new ArrayList<>();
	       
	       for(EntityPosition position : positions) {
	          if(position.getPosition().getACCOUNT_ID().equals(accountId)) {
	             entityPositions.add(position);
	          }
	       }
	       
	       return entityPositions;
	    }
	   
	    /**
	     * This method gets positions that are able to be seen by particular bank
	     * @param accountId
	     * @param bankId - current bank that is fetching available trades (required for monitoring check)
	     * @return
	     */
	   	    public static ArrayList<EntityPosition> getAvailablePositionsByAccountId(String accountId, String bankId) {
	       ArrayList<EntityPosition> entityPosition = new ArrayList<>();
	       
	       for(EntityPosition position : positions) {
	          if(position.getPosition().getACCOUNT_ID().equals(accountId)) {
	             boolean monitored = false;
	             
	             for(EntityMonitor m : position.getEntityAccount().getEntityMonitor()) {
	                
	                
	                if(m.getEntityEmployee().getEntityBank().getBank().getBANK_ID().toString().equals(bankId)) {
	                   
	                   monitored = true;
	                   
	                   if(m.getMonitor().getAS_OF_DATE().getTime() < position.getPosition().getSECURITY_DATE().getTime() &&
	                         (m.getMonitor().getEND_DATE() == null || m.getMonitor().getEND_DATE().getTime() < position.getPosition().getSECURITY_DATE().getTime())) {
	                      entityPosition.add(position);
	                   }
	                   
	                }
	             }
	             
	             if(!monitored) {
	                entityPosition.add(position);
	             }
	             
	          }
	       }
	       
	       return entityPosition;
	    }
	
	   public static ArrayList<EntityPosition> getPositionBySignutureDate(String bankId,java.sql.Timestamp date1, java.sql.Timestamp date2){
//	      long dateLong1 = date1.getTime();
//	      long dateLong2 = date2.getTime();

	        ArrayList<EntityPosition> entityPosition = new ArrayList<>();
	        
	        for(EntityMonitor m : MonitorEntityDatasource.getAll()) {
	           if(m.getEntityEmployee().getEntityBank().getBank().getBANK_ID().toString().equals(bankId)) {
	              for(EntityPosition p : m.getEntityAccount().getEntityPositions()) {
	                 
	                 if(p.getPosition().getSECURITY_DATE().getTime() > date1.getTime()
	                       && p.getPosition().getSECURITY_DATE().getTime() < date2.getTime() 
	                       && p.getPosition().getSECURITY_DATE().getTime() > m.getMonitor().getAS_OF_DATE().getTime()
	                       && 
	                       (m.getMonitor().getEND_DATE() == null
	                       || p.getPosition().getSECURITY_DATE().before(m.getMonitor().getEND_DATE()))) {
	                    entityPosition.add(p);
	                 }
	              } 
	           }
	        }

	        return entityPosition;
	    }
}
