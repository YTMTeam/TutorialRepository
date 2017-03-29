package com.lexington.mc.logic.datasource.singleton;

import java.util.ArrayList;

import com.lexington.mc.model.blockchain.pojos.AccountPojo;
import com.lexington.mc.model.blockchain.pojos.PojoApi;
import com.lexington.mc.model.entities.EntityAccount;
import com.lexington.mc.model.entities.EntityApi;
import com.lexington.mc.model.entities.EntityBank;
import com.lexington.mc.model.entities.EntityEmployee;
import com.lexington.mc.model.entities.EntityMonitor;
import com.lexington.mc.model.entities.EntityPosition;
import com.lexington.mc.model.entities.EntityTrade;
import com.lexington.mc.model.singletons.datasource.AccountEntityDatasource;
import com.lexington.mc.model.singletons.datasource.BankEntityDatasource;
import com.lexington.mc.model.singletons.datasource.EmployeeEntityDatasource;
import com.lexington.mc.model.singletons.datasource.MonitorEntityDatasource;
import com.lexington.mc.model.singletons.datasource.PositionEntityDatasource;
import com.lexington.mc.model.singletons.datasource.TradeEntityDatasource;

public class BlockchainData {
//	//static data
//
//	/**represents new batch of data**/
//	ArrayList<PojoApi> accounts= new ArrayList<>();
//	ArrayList<PojoApi> employees = new ArrayList<>();
//	ArrayList<PojoApi> banks = new ArrayList<>();
//	ArrayList<PojoApi> monitors = new ArrayList<>();
//	ArrayList<PojoApi> positions = new ArrayList<>();
//	ArrayList<PojoApi> trades = new ArrayList<>();
//
//
//	/**represents existing datasources**/
//	ArrayList<EntityAccount> eAccounts=AccountEntityDatasource.getInstance();
//	ArrayList<EntityEmployee> eEmployees=EmployeeEntityDatasource.getInstance();
//	ArrayList<EntityBank> eBanks=BankEntityDatasource.getAll();
//	ArrayList<EntityMonitor> eMonitors=MonitorEntityDatasource.getInstance();
//	ArrayList<EntityTrade> eTrades=TradeEntityDatasource.getInstance();
//	ArrayList<EntityPosition> ePositions= PositionEntityDatasource.getInstance();
//
//
//	public BlockchainData() throws InstantiationException, IllegalAccessException{
//
//		/** banks are only being checked with themselves because they are the oldest entites
//	for(PojoApi b:banks){
//		boolean isNew=true;
//
//		for(EntityApi eb:  eBanks){
//			if(eb.getRowKey().equals(b.getRowKey())){
//				eb.setPojo(b);
//				isNew=false;
//				break;
//			}
//
//		} 
//		if(isNew){
//			EntityApi eb=new EntityBank(b);
//			eBanks.add((EntityBank) eb);
//		}
//
//	}
//		 **/
//
//
//		/** first insert or update core data for entities in datasources**/
//		
//		updateDataSource(eBanks, banks, EntityBank.class);
//		updateDataSource(eAccounts, accounts, EntityAccount.class);
//		updateDataSource(eEmployees, employees, EntityEmployee.class);
//		updateDataSource(eMonitors, monitors, EntityMonitor.class);
//		updateDataSource(ePositions, positions, EntityPosition.class);
//		updateDataSource(eTrades, trades, EntityTrade.class);
//
//
//		/** second - update or create new relations **/
//		
//		
//		/**accounts are being checked with banks**/
//
//
//		for(EntityAccount a:eAccounts){
//
//
//			for(EntityBank eb:  eBanks){
//				if(eb.getBank().getBANK_ID().equals(a.getAccount().getBANK_ID())){
//					eb.getEntityAccounts().add(a);
//					a.setEntityBank(eb);
////					eb.addOrUpdateAccount(a);
////					a.addOrUpdateBank(eb);
//					break;
//				}
//
//			} 
//		}
//
//
//		/**monitors are being checked with accounts and banks**/
//
//
//		for(EntityMonitor m :eMonitors){
//
//			for(EntityBank eb:  eBanks){
//				if(eb.getBank().getBANK_ID().equals(m.getMonitor().getBANK_ID())){
//					eb.getEntityMonitors().add(m);
//					m.setEntityBank(eb);
////					eb.addOrUpdateMonitor(m);
////					m.addOrUpdateBank(eb);
//					break;
//				}
//
//			}
//
//
//
//			for(EntityAccount a:  eAccounts){
//				if(a.getAccount().getACCOUNT_ID().equals(m.getMonitor().getACCOUNT_ID())){
//					a.getEntityMonitor().add(m);
//					m.setEntityAccount(a);
////					a.addOrUpdateMonitor(m);
////					m.addOrUpdateAccount(a);
//					break;
//				}
//
//			}
//
//
//
//		}
//
//
//		/**employees are being checked with monitors and banks**/
//
//
//		for(EntityEmployee e :eEmployees){
//
//
//			for(EntityBank eb:  eBanks){
//				if(eb.getBank().getBANK_ID().equals(e.getEmployee().getBANK_ID())){
//					eb.getEntityEmployees().add(e);
//					e.setEntityBank(eb);
//					
////					eb.addOrUpdateEmployee(e);
////					e.addOrUpdateBank(eb);
//					break;
//				}
//
//			}
//
//
//
//			for(EntityMonitor m:  eMonitors){
//				if(m.getMonitor().getEMPLOYEE_ID().equals(e.getEmployee().getEMPLOYEE_ID())){
//					m.setEntityEmployee(e);
//					e.getEntityMonitors().add(m);
//					
////					m.addOrUpdateEmployee(e);
////					e.addOrUpdateMonitor(m);
//					break;
//				}
//
//			}
//
//
//
//		}
//
//
//
//
//		/**positions are checked with account **/
//
//
//		for(EntityPosition p :ePositions){
//
//
//
//
//			for(EntityAccount a:  eAccounts){
//				if(a.getAccount().getACCOUNT_ID().equals(p.getPosition().getACCOUNT_ID())){
//					p.setEntityAccount(a);
//					a.getEntityPositions().add(p);
//					
////					a.addOrUpdatePosition(p);
////					p.addOrUpdateAccount(a);
//					break;
//				}
//
//			}
//
//
//
//		}
//
//
//
//		/**trades are being checked with account only**/
//		for(EntityTrade t :eTrades){
//
//			for(EntityAccount a:  eAccounts){
//				if(a.getAccount().getACCOUNT_ID().equals(t.getTrade().getACCOUNT_ID())){
//					t.setEntityAccount(a);
//					a.getEntityTrade().add(t);
////					a.addOrUpdateTrade(t);
////					t.addOrUpdateAccount(a);
//					break;
//				}
//
//			}
//
//
//
//		}
//
//
//
//	}
//
//	public <T extends EntityApi>void updateDataSource(ArrayList<T> datasource, ArrayList<PojoApi> batch, Class<T> clazz) throws InstantiationException, IllegalAccessException{
//		for(PojoApi b:batch){
//			boolean isNew=true;
//
//			for(EntityApi eb:  datasource){
//				if(eb.getRowKey().equals(b.getRowKey())){
//					eb.setPojo(b);
//					isNew=false;
//					break;
//				}
//
//			} 
//			if(isNew){
//				EntityApi eb=createEntity(clazz);
//				eb.setPojo(b);
//
//				datasource.add((T) eb);
//			}
//
//		}
//
//	}
//
//	public static <T extends EntityApi> T createEntity(Class<T> entityClass) throws InstantiationException, IllegalAccessException {
//		return entityClass.newInstance();
//	};


}
