package com.lexington.mc.logic.providers;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.lexington.mc.logic.excel.loaders.ExcelAccountLoader;
import com.lexington.mc.logic.util.IDataProviderNotifier;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.blockchain.common.BlockchainConstants;
import com.lexington.mc.model.blockchain.pojos.AccountPojo;
import com.lexington.mc.model.blockchain.pojos.BankPojo;
import com.lexington.mc.model.blockchain.pojos.BlockPojo;
import com.lexington.mc.model.blockchain.pojos.EmployeePojo;
import com.lexington.mc.model.blockchain.pojos.MonitorPojo;
import com.lexington.mc.model.blockchain.pojos.PojoApi;
import com.lexington.mc.model.blockchain.pojos.PositionPojo;
import com.lexington.mc.model.blockchain.pojos.TradePojo;
import com.lexington.mc.model.blockchain.pojos.TransactionPojo;
import com.lexington.mc.model.blockchain.pojos.UserPojo;
import com.lexington.mc.model.entities.EntityAccount;
import com.lexington.mc.model.entities.EntityApi;
import com.lexington.mc.model.entities.EntityBank;
import com.lexington.mc.model.entities.EntityBlock;
import com.lexington.mc.model.entities.EntityEmployee;
import com.lexington.mc.model.entities.EntityMonitor;
import com.lexington.mc.model.entities.EntityPosition;
import com.lexington.mc.model.entities.EntityTrade;
import com.lexington.mc.model.entities.EntityTransaction;
import com.lexington.mc.model.entities.EntityUser;
import com.lexington.mc.model.singletons.connection.BlockchainConnection;
import com.lexington.mc.model.singletons.datasource.AccountEntityDatasource;
import com.lexington.mc.model.singletons.datasource.BankEntityDatasource;
import com.lexington.mc.model.singletons.datasource.BlockEntityDatasource;
import com.lexington.mc.model.singletons.datasource.EmployeeEntityDatasource;
import com.lexington.mc.model.singletons.datasource.MonitorEntityDatasource;
import com.lexington.mc.model.singletons.datasource.PositionEntityDatasource;
import com.lexington.mc.model.singletons.datasource.TradeEntityDatasource;
import com.lexington.mc.model.singletons.datasource.TransactionEntityDatasource;
import com.lexington.mc.model.singletons.datasource.UserEntityDatasource;
import com.lexington.mc.model.singletons.lists.AccountList;
import com.lexington.mc.model.singletons.lists.BankList;
import com.lexington.mc.model.singletons.lists.BlockList;
import com.lexington.mc.model.singletons.lists.EmployeeList;
import com.lexington.mc.model.singletons.lists.MonitorList;
import com.lexington.mc.model.singletons.lists.PositionList;
import com.lexington.mc.model.singletons.lists.TradeList;
import com.lexington.mc.model.singletons.lists.TransactionList;
import com.lexington.mc.model.singletons.lists.UserList;

public class BlockchainDataProvider {
   
   final static Logger                    log = Logger.getLogger(BlockchainDataProvider.class.getName());

   
   public BlockchainDataProvider(IDataProviderNotifier notifier) {
      this.notifier = notifier;
    }
   
   
   
   IDataProviderNotifier notifier;
   BlockchainUtilProvider blockchainProvider = new BlockchainUtilProvider();

   public void run() throws MessageException {

	   try {
      
      notifier.setStatus(BlockchainConstants.DataProviderStatus.BUSY);
      
      /**
       * The following lists will be fed by data provider during this iteration
       */
      TransactionList tList = new TransactionList();
      BlockList blockList = new BlockList();

      BankList bankList = new BankList();
      AccountList accList = new AccountList();
      TradeList tradeList = new TradeList();
      MonitorList monitorList = new MonitorList();
      PositionList positionList = new PositionList();
      UserList userList = new UserList();
      EmployeeList employeeList = new EmployeeList();

      while(true) {
         //increase current block value
        BigDecimal currentBlockHeight = BlockchainConnection.getClient().getCurrentBlockHeight();
        
        currentBlockHeight = currentBlockHeight.add(new BigDecimal(1));
        
      log.info("Starting from height:" +currentBlockHeight);
         
         EntityBlock lastBlock = null;
         try {
            lastBlock = BlockEntityDatasource.getAll().get(BlockEntityDatasource.getAll().size()-1);
         } catch(IndexOutOfBoundsException e) {
            //go on
         }

         BlockPojo newBlock = BlockchainConnection.getClient().getBlock(currentBlockHeight.toString());

         if(newBlock == null) {
            break;
         }
         
         BlockchainConnection.getClient().setCurrentBlockHeight(currentBlockHeight);

         /**!**/ blockList.add(newBlock); /**!**/

         if(lastBlock != null) {
            lastBlock.getBlock().setNextblockhash(newBlock.getHash());
         }

         ArrayList<TransactionPojo> decodedTransactions = blockchainProvider.getDecodedTransactions(newBlock);

         for(TransactionPojo decodedTransaction : decodedTransactions) {

            String streamType = blockchainProvider.getStreamType(decodedTransaction);
            decodedTransaction.setStreamType(streamType);
            decodedTransaction.setBlockhash(newBlock.getHash());

            /**!**/ tList.add(decodedTransaction); /**!**/

            switch(streamType) {
               case BlockchainConstants.StreamTypes.CREATE_BANK: {
                  BankPojo bank = (BankPojo) blockchainProvider.convertDataFromTransaction(decodedTransaction, new BankPojo());
                  bankList.add(bank);

                  break;
               }
               case BlockchainConstants.StreamTypes.CREATE_ACCOUNT: {
                  AccountPojo account = (AccountPojo) blockchainProvider.convertDataFromTransaction(decodedTransaction, new AccountPojo());
                  accList.add(account);

                  break;
               }
               case BlockchainConstants.StreamTypes.CREATE_TRADE: {
                  TradePojo trade = (TradePojo) blockchainProvider.convertDataFromTransaction(decodedTransaction, new TradePojo());
                  tradeList.add(trade);

                  break;
               }
               case BlockchainConstants.StreamTypes.MONITOR: {
                  MonitorPojo monitor = (MonitorPojo) blockchainProvider.convertDataFromTransaction(decodedTransaction, new MonitorPojo());
                  monitorList.add(monitor);

                  break;
               }
               case BlockchainConstants.StreamTypes.CREATE_POSITION: {
                  PositionPojo position = (PositionPojo) blockchainProvider.convertDataFromTransaction(decodedTransaction, new PositionPojo());
                  positionList.add(position);

                  break;
               }
               case BlockchainConstants.StreamTypes.CREATE_USER: {
                  UserPojo user = (UserPojo) blockchainProvider.convertDataFromTransaction(decodedTransaction, new UserPojo());
                  userList.add(user);

                  break;
               }
               case BlockchainConstants.StreamTypes.CREATE_EMPLOYEE: {
                  EmployeePojo employee = (EmployeePojo) blockchainProvider.convertDataFromTransaction(decodedTransaction, new EmployeePojo());
                  employeeList.add(employee);

                  break;
               }
            }
         }

      }

    	  
         updateDatasources(
               bankList.getAll(),
               accList.getAll(),
               employeeList.getAll(),
               monitorList.getAll(),
               tradeList.getAll(),
               positionList.getAll(),
               userList.getAll(),
               tList.getAll(),
               blockList.getAll());
         
         
        log.info("Finished adding into memory.");

         printInfoForCurrentIteration(
               bankList.getAll(),
               accList.getAll(),
               employeeList.getAll(),
               monitorList.getAll(),
               tradeList.getAll(),
               positionList.getAll(),
               userList.getAll(),
               tList.getAll(),
               blockList.getAll());    
         
         printInformation();
         
      } catch (Exception e) {
    	  //This is temporary solution until we fix exception handling
         // TODO Auto-generated catch block
         e.printStackTrace();
                  
         throw new MessageException("somethingWentWrong");

      } finally {
    	  
          notifier.setStatus(BlockchainConstants.DataProviderStatus.FINISHED);

      }
           

   }

   private void updateDatasources(ArrayList<PojoApi> banks,
         ArrayList<PojoApi> accounts,
         ArrayList<PojoApi> employees,
         ArrayList<PojoApi> monitors, 
         ArrayList<PojoApi> trades,
         ArrayList<PojoApi> positions, 
         ArrayList<PojoApi> users, 
         ArrayList<PojoApi> transactions, 
         ArrayList<PojoApi> blocks ) throws InstantiationException, IllegalAccessException {
    
      /**represents existing datasources**/
      ArrayList<EntityAccount> eAccounts=AccountEntityDatasource.getAll();
      ArrayList<EntityEmployee> eEmployees=EmployeeEntityDatasource.getAll();
      ArrayList<EntityBank> eBanks=BankEntityDatasource.getAll();
      ArrayList<EntityMonitor> eMonitors=MonitorEntityDatasource.getAll();
      ArrayList<EntityTrade> eTrades=TradeEntityDatasource.getAll();
      ArrayList<EntityPosition> ePositions= PositionEntityDatasource.getAll();
      ArrayList<EntityUser> eUsers= UserEntityDatasource.getAll();
      ArrayList<EntityTransaction> eTransactions= TransactionEntityDatasource.getAll();
      ArrayList<EntityBlock> eBlocks = BlockEntityDatasource.getAll();
      
      
      /** first insert or update core data for entities in datasources**/
      
      insertIntoDataSource(eTransactions, transactions, EntityTransaction.class);
      insertIntoDataSource(eBlocks, blocks, EntityBlock.class);

      updateDataSource(eBanks, banks, EntityBank.class);
      updateDataSource(eAccounts, accounts, EntityAccount.class);
      updateDataSource(eEmployees, employees, EntityEmployee.class);
      updateDataSource(eMonitors, monitors, EntityMonitor.class);
      updateDataSource(ePositions, positions, EntityPosition.class);
      updateDataSource(eTrades, trades, EntityTrade.class);
      updateDataSource(eUsers, users, EntityUser.class);


      /** second - update or create new relations **/


      /**accounts are being checked with banks**/


      for(EntityAccount a:eAccounts){


         for(EntityBank eb:  eBanks){
            if(eb.getBank().getBANK_ID().equals(a.getAccount().getBANK_ID())){
               eb.addAccount(a);
               a.setEntityBank(eb);
               //					eb.addOrUpdateAccount(a);
               //					a.addOrUpdateBank(eb);
//               break;
            }

         } 
      }
      
      /** users are being checked with banks **/
      for(EntityUser u : eUsers) {
         
         for(EntityBank b : eBanks) {
            if(u.getUser().getBANK_ID().equals(b.getBank().getBANK_ID())) {
               u.setEntityBank(b);
               b.addUser(u);
//               break;
            }
         }  
      }
      /**employees are being checked with monitors and banks**/ 
      /** Note: Employees have to be loaded before monitors because link between banks and monitors are via entity employee **/


      for(EntityEmployee e :eEmployees){


         for(EntityBank eb:  eBanks){
            if(eb.getBank().getBANK_ID().equals(e.getEmployee().getBANK_ID())){
               eb.addEmployee(e);
                //eb.getEntityEmployees().add(e);
               e.setEntityBank(eb);

               //                   eb.addOrUpdateEmployee(e);
               //                   e.addOrUpdateBank(eb);
//               break;
            }
         }
         
         for(EntityMonitor m:  eMonitors){

            if(m.getMonitor().getEMPLOYEE_ID().equals(e.getEmployee().getEMPLOYEE_ID())){
               m.setEntityEmployee(e);
               e.addMonitor(m);

               //                   m.addOrUpdateEmployee(e);
               //                   e.addOrUpdateMonitor(m);
//               break;
            }

         }
      }
      
      /**monitors are being checked with accounts and banks**/

      for(EntityMonitor m :eMonitors){

         for(EntityBank eb:  eBanks){

            if(eb.getBank().getBANK_ID().equals(m.getEntityEmployee().getEmployee().getBANK_ID())){
            	eb.addMonitor(m);
              // eb.getEntityMonitors().add(m);
               m.setEntityBank(eb);
               //					eb.addOrUpdateMonitor(m);
               //					m.addOrUpdateBank(eb);
//               break;
            }

         }



         for(EntityAccount a:  eAccounts){

            if(a.getAccount().getACCOUNT_ID().equals(m.getMonitor().getACCOUNT_ID())){
               a.addMonitor(m);
               m.setEntityAccount(a);
               //					a.addOrUpdateMonitor(m);
               //					m.addOrUpdateAccount(a);
//               break;
            }

         }



      }







      /**positions are checked with account **/


      for(EntityPosition p :ePositions){

         for(EntityAccount a:  eAccounts){
            if(a.getAccount().getACCOUNT_ID().equals(p.getPosition().getACCOUNT_ID())){
               p.setEntityAccount(a);
               a.addPosition(p);

               //					a.addOrUpdatePosition(p);
               //					p.addOrUpdateAccount(a);
//               break;
            }

         }
      }



      /**trades are being checked with account only**/
      for(EntityTrade t :eTrades){

         for(EntityAccount a:  eAccounts){
            if(a.getAccount().getACCOUNT_ID().equals(t.getTrade().getACCOUNT_ID())){
               t.setEntityAccount(a);
               a.addTrade(t);
               //					a.addOrUpdateTrade(t);
               //					t.addOrUpdateAccount(a);
//               break;
            }

         }
         
         for(EntityBank b :  eBanks){
            if(b.getBank().getBANK_ID().equals(t.getTrade().getBANK_ID())){
               t.setEntityBank(b);
               b.addTrade(t);
               //					a.addOrUpdateTrade(t);
               //					t.addOrUpdateAccount(a);
//               break;
            }
            
         }
      }

      

      
      
      /** transactions are being checked with blocks **/
      for(EntityTransaction t : eTransactions) {
         
         for(EntityBlock b : eBlocks) {
            if(b.getBlock().getHash().equals(t.getTransaction().getBlockhash())) {
               t.setEntityBlock(b);
               b.addTransactions(t);
//               break;
            }
         }
      }


   }

   public <T extends EntityApi>void updateDataSource(ArrayList<T> datasource, ArrayList<PojoApi> batch, Class<T> clazz) throws InstantiationException, IllegalAccessException{
      for(PojoApi b:batch){
         boolean isNew=true;

         for(EntityApi eb:  datasource){
            if(eb.getRowKey().equals(b.getRowKey())){
               eb.setPojo(b);
               isNew=false;
               break;
            }

         } 
         if(isNew){
            EntityApi eb=createEntity(clazz);
            eb.setPojo(b);

            datasource.add((T) eb);
         }

      }

   }
   public <T extends EntityApi>void insertIntoDataSource(ArrayList<T> datasource, ArrayList<PojoApi> batch, Class<T> clazz) throws InstantiationException, IllegalAccessException{
      for(PojoApi b:batch){

         EntityApi eb=createEntity(clazz);
         eb.setPojo(b);

         datasource.add((T) eb);   

      }

   }

   public static <T extends EntityApi> T createEntity(Class<T> entityClass) throws InstantiationException, IllegalAccessException {
      return entityClass.newInstance();
   };
   
   private void printInformation() {

     log.info("************");
     log.info("Total data:");
      
     log.info("Banks: "+BankEntityDatasource.getAll().size());
     log.info("Account: "+AccountEntityDatasource.getAll().size());
     log.info("Employees: "+EmployeeEntityDatasource.getAll().size());
     log.info("Monitors: "+MonitorEntityDatasource.getAll().size());
     log.info("Trades: "+TradeEntityDatasource.getAll().size());
     log.info("Positions: "+PositionEntityDatasource.getAll().size());
     log.info("Users: "+UserEntityDatasource.getAll().size());
     log.info("Transactions: "+TransactionEntityDatasource.getAll().size());
     log.info("Blocks: "+BlockEntityDatasource.getAll().size());

   }
   private void printInfoForCurrentIteration(ArrayList<PojoApi> banks,
         ArrayList<PojoApi> accounts,
         ArrayList<PojoApi> employees,
         ArrayList<PojoApi> monitors, 
         ArrayList<PojoApi> trades,
         ArrayList<PojoApi> positions, 
         ArrayList<PojoApi> users, 
         ArrayList<PojoApi> transactions, 
         ArrayList<PojoApi> blocks ) {
      
      log.info("************");
      log.info("Data for this iteration:");

      
     log.info("Banks: "+banks.size());
     log.info("Account: "+accounts.size());
     log.info("Employees: "+employees.size());
     log.info("Monitors: "+monitors.size());
     log.info("Trades: "+trades.size());
     log.info("Positions: "+positions.size());
     log.info("Users: "+users.size());
     log.info("Transactions: "+transactions.size());
     log.info("Blocks: "+blocks.size());
      
   }
}
