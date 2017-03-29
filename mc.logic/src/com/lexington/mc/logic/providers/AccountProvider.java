package com.lexington.mc.logic.providers;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.lexington.mc.logic.entities.EntityAccountDeprecated;
import com.lexington.mc.logic.entities.EntityEmployeeDeprecated;
import com.lexington.mc.logic.entities.EntityVMonitoredAccountDeprecated;
import com.lexington.mc.logic.util.Connect;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.tables.DataAccount;
import com.lexington.mc.model.tables.DataMonitor;
import com.lexington.mc.model.util.UtilCodeTypes;
import com.lexington.mc.model.views.DataVMonitoredAccounts;
import com.mallocinc.codegenerator.exceptions.GDAOException;
import com.mallocinc.database.generated.to.AccountTo;
import com.mallocinc.database.generated.to.MonitorTo;
import com.mallocinc.database.generated.to.VMonitoredAccountsTo;

public class AccountProvider {
	final static Logger log = Logger.getLogger(AccountProvider.class.getName());
	private DataAccount dataAddress= new DataAccount();
	private UtilCodeTypes uct= new UtilCodeTypes();
	private DataVMonitoredAccounts dataMonitoredAccs = new DataVMonitoredAccounts();
	
	public List<EntityAccountDeprecated> getAddressesForPaging(int first, int pageSize, String sortField, String sortOrder,
			Map<String, Object> filters) throws MessageException {

	      Connection conn = null;
	      List<AccountTo> tos = new ArrayList<>();
	      try {
	         conn = Connect.obtainConn(conn);
	         tos = dataAddress.getAddressesForPaging(conn, first, pageSize, sortField, sortOrder, filters);
	         Connect.returnConn(conn);
	      } catch (GDAOException e) {

	         log.error("GDAO - Problem when getting addresses: " + e.getMessage());
	         throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
	      } finally {
	         Connect.returnConn(conn);
	      }
	      
	      
	      ArrayList<EntityAccountDeprecated> res= new ArrayList<>();
	      for(AccountTo to: tos)
	    	  res.add(new EntityAccountDeprecated(to));
	      return res;
	}
	
	public long getAddressesFilterCount(Map<String, Object> filters) throws MessageException {
		   Connection conn = null;
		      long count = 0;
		      try {
		         conn = Connect.obtainConn(conn);
		         count = dataAddress.getAddressesFilterCount(conn, filters);
		         Connect.returnConn(conn);
		      } catch (GDAOException e) {

		         log.error("GDAO - Problem when counting rows in address table: " + e.getMessage());
		         throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
		      } finally {
		         Connect.returnConn(conn);
		      }
		      return count;
	}

	public List<EntityAccountDeprecated> getAccountsAssignedToBankForPaging(int first, int pageSize, String sortField, String sortOrder,
			Map<String, Object> filters, BigDecimal bankId) throws MessageException {
		
		Connection conn = null;
		List<AccountTo> tos = new ArrayList<>();
		try {
			conn = Connect.obtainConn(conn);
			tos = dataAddress.getAccountsByBankIdForPaging(conn, first, pageSize, sortField, sortOrder, filters, bankId);
			Connect.returnConn(conn);
		} catch (GDAOException e) {
			
			log.error("GDAO - Problem when getting accounts: " + e.getMessage());
			throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
		} finally {
			Connect.returnConn(conn);
		}
		
		
		ArrayList<EntityAccountDeprecated> res= new ArrayList<>();
		for(AccountTo to: tos)
			res.add(new EntityAccountDeprecated(to));
		return res;
	}
	
	public long getAccountsAssignedToBankFilterCount(Map<String, Object> filters, BigDecimal bankId) throws MessageException {
		   Connection conn = null;
		      long count = 0;
		      try {
		         conn = Connect.obtainConn(conn);
		         count = dataAddress.getAccountsByBankIdFilterCount(conn, filters, bankId);
		         Connect.returnConn(conn);
		      } catch (GDAOException e) {

		         log.error("GDAO - Problem when counting rows in account table: " + e.getMessage());
		         throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
		      } finally {
		         Connect.returnConn(conn);
		      }
		      return count;
	}
	public List<EntityVMonitoredAccountDeprecated> getMonitoredAccountsForPaging(int first, int pageSize, String sortField, String sortOrder,
			Map<String, Object> filters, BigDecimal bankId) throws MessageException {
		
		Connection conn = null;
		List<VMonitoredAccountsTo> tos = new ArrayList<>();
		try {
			conn = Connect.obtainConn(conn);
			tos = dataMonitoredAccs.getMonitoredAccsByBankIdForPaging(conn, first, pageSize, sortField, sortOrder, filters, bankId);
		} catch (GDAOException e) {
			
			log.error("GDAO - Problem when getting monitored accounts: " + e.getMessage());
			throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
		} finally {
			Connect.returnConn(conn);
		}
	
		ArrayList<EntityVMonitoredAccountDeprecated> res= new ArrayList<>();
		
		for(VMonitoredAccountsTo to: tos) {
			res.add(new EntityVMonitoredAccountDeprecated(to));
		}
		
		return res;
	}
	
	public long getMonitoredAccountsFilterCount(Map<String, Object> filters, BigDecimal bankId) throws MessageException {
		   Connection conn = null;
		      long count = 0;
		      try {
		         conn = Connect.obtainConn(conn);
		         count = dataMonitoredAccs.getAccountsByBankIdFilterCount(conn, filters, bankId);
		      } catch (GDAOException e) {

		         log.error("GDAO - Problem when counting rows in V_MONITORED_ACCOUNTS view: " + e.getMessage());
		         throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
		      } finally {
		         Connect.returnConn(conn);
		      }
		      return count;
	}
	public List<EntityVMonitoredAccountDeprecated> getMonitoredAccountsByStatusForPaging(int first, int pageSize, String sortField, String sortOrder,
	      Map<String, Object> filters, BigDecimal bankId, String status) throws MessageException {
	   
	   Connection conn = null;
	   List<VMonitoredAccountsTo> tos = new ArrayList<>();
	   try {
	      conn = Connect.obtainConn(conn);
	      tos = dataMonitoredAccs.getMonitoredAccsByBankIdAndStatusForPaging(conn, first, pageSize, sortField, sortOrder, filters, bankId, status);
	   } catch (GDAOException e) {
	      
	      log.error("GDAO - Problem when getting monitored accounts: " + e.getMessage());
	      throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
	   } finally {
	      Connect.returnConn(conn);
	   }
	   
	   ArrayList<EntityVMonitoredAccountDeprecated> res= new ArrayList<>();
	   
	   for(VMonitoredAccountsTo to: tos) {
	      res.add(new EntityVMonitoredAccountDeprecated(to));
	   }
	   
	   return res;
	}
	
	public long getMonitoredAccountsByStatusFilterCount(Map<String, Object> filters, BigDecimal bankId, String status) throws MessageException {
	   Connection conn = null;
	   long count = 0;
	   try {
	      conn = Connect.obtainConn(conn);
	      count = dataMonitoredAccs.getAccountsByBankIdAndStatusFilterCount(conn, filters, bankId,status);
	   } catch (GDAOException e) {
	      
	      log.error("GDAO - Problem when counting rows in V_MONITORED_ACCOUNTS view: " + e.getMessage());
	      throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
	   } finally {
	      Connect.returnConn(conn);
	   }
	   return count;
	}
	
	public EntityAccountDeprecated getBank() throws MessageException {
		  Connection conn = null;
	       AccountTo  to;
	      try {
	         conn = Connect.obtainConn(conn);
	         to  = dataAddress.getBank(conn);
	      } catch (GDAOException e) {

	         log.error("GDAO - Problem when getting bank: " + e.getMessage());
	         throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
	      } finally {
	         Connect.returnConn(conn);
	      }
	      if(to==null) return null;
	      return new EntityAccountDeprecated(to);
	}
	
	public ArrayList<AccountTo> getUsersByGroupId(BigDecimal groupId) throws MessageException {
		ArrayList<AccountTo> users = new ArrayList<>();
		Connection conn = null;
		try {
			conn = Connect.obtainConn(conn);
			users  = dataAddress.getUsersByGroupId(conn, groupId);
		} catch (GDAOException e) {
			
			log.error("GDAO - Problem when getting bank: " + e.getMessage());
			throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
		} finally {
			Connect.returnConn(conn);
		}
		return users;
	}
	
	public AccountTo getAccountByAccountId(String accountId) throws MessageException {
		AccountTo users = new AccountTo();
		Connection conn = null;
		try {
			conn = Connect.obtainConn(conn);
			users  = dataAddress.getAccountByAccountId(conn, accountId);
		} catch (GDAOException e) {
			
			log.error("GDAO - Problem when getting bank: " + e.getMessage());
			throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
		} finally {
			Connect.returnConn(conn);
		}
		return users;
	}


	public List<AccountTo> getUserWalletAddressesForSearch(int first, int pageSize, String sortField, String sortOrder,
			HashMap<String, Object> filters) throws MessageException {
	 
		Connection conn = null;
		List<AccountTo> users = new ArrayList<>();
		try {
			conn = Connect.obtainConn(conn);
			users = dataAddress.getUserWalletAddressesForSearch(conn, first, pageSize, sortField, sortOrder, filters);
		} catch (GDAOException e) {

			log.error("GDAO - Problem when getting users or couldn't find users: " + e.getMessage());
			throw new MessageException("error", MessageException.ERROR, "couldNotRetreiveUsers");
		} finally {
			Connect.returnConn(conn);
		}
		return users;
	}

	public ArrayList<EntityVMonitoredAccountDeprecated> getAccountMonitors(String accountId) throws MessageException {
		Connection conn = null;
		List<VMonitoredAccountsTo> monitors = new ArrayList<>();
		try {
			conn = Connect.obtainConn(conn);
			monitors = new DataVMonitoredAccounts().getAccountMonitors(conn, accountId);
		} catch (GDAOException e) {

			log.error("GDAO - Problem when account monitors: " + e.getMessage());
			throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
		} finally {
			Connect.returnConn(conn);
		}
		
		ArrayList<EntityVMonitoredAccountDeprecated> emonitors = new ArrayList<EntityVMonitoredAccountDeprecated> ();
		for(VMonitoredAccountsTo m: monitors)
			emonitors.add(new EntityVMonitoredAccountDeprecated(m));
		return emonitors;
	}

	public void updateAccountMonitors(ArrayList<MonitorTo> toUpdate, String accountId) throws MessageException {
		log.info("started updating monitors");
		 Connection connection = null;
	      DataMonitor dataMonitor = new DataMonitor();
	      try {
	         connection = Connect.obtainConn(connection);
	         connection.setAutoCommit(false);
	         dataMonitor.deleteByAccountId(connection, accountId);
	         dataMonitor.insertMonitorBatch(connection, toUpdate);
	         
	         connection.commit();
	      } catch (SQLException | GDAOException e) {
	         Connect.rethrowExceptionAndTryRollback(connection, "somethingWentWrong", e);
	      } finally {
	         Connect.returnConn(connection);
	      }
		
	}

	public ArrayList<EntityAccountDeprecated> getAllAccounts() throws MessageException {
		Connection conn = null;
		List<EntityAccountDeprecated> accounts = new ArrayList<>();
		List<AccountTo> accTos = new ArrayList<>();
		try {
			conn = Connect.obtainConn(conn);
			accTos = new DataAccount().getAllAccounts(conn);
		} catch (GDAOException e) {

			log.error("GDAO - Problem when getting all accounts: " + e.getMessage());
			throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
		} finally {
			Connect.returnConn(conn);
		}
		for(AccountTo m: accTos)
			accounts.add(new EntityAccountDeprecated(m));
		return (ArrayList<EntityAccountDeprecated>) accounts;
	}
	public ArrayList<EntityAccountDeprecated> getBankAccounts(BigDecimal bankId) throws MessageException {
	   Connection conn = null;
	   List<EntityAccountDeprecated> accounts = new ArrayList<>();
	   List<AccountTo> accTos = new ArrayList<>();
	   try {
	      conn = Connect.obtainConn(conn);
	      accTos = new DataAccount().getBankAccounts(conn, bankId);
	   } catch (GDAOException e) {
	      
	      log.error("GDAO - Problem when getting all accounts: " + e.getMessage());
	      throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
	   } finally {
	      Connect.returnConn(conn);
	   }
	   for(AccountTo m: accTos)
	      accounts.add(new EntityAccountDeprecated(m));
	   return (ArrayList<EntityAccountDeprecated>) accounts;
	}
	
    public ArrayList<EntityVMonitoredAccountDeprecated> getMonitoredAccountsByStatus(BigDecimal bankId, String status) throws MessageException {
       
       Connection conn = null;
       List<VMonitoredAccountsTo> tos = new ArrayList<>();
       try {
          conn = Connect.obtainConn(conn);
          tos = dataMonitoredAccs.getMonitoredAccsByBankIdAndStatus(conn, bankId, status);
       } catch (GDAOException e) {
          
          log.error("GDAO - Problem when getting monitored accounts: " + e.getMessage());
          throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
       } finally {
          Connect.returnConn(conn);
       }
       
       ArrayList<EntityVMonitoredAccountDeprecated> res= new ArrayList<>();
       
       for(VMonitoredAccountsTo to: tos) {
          res.add(new EntityVMonitoredAccountDeprecated(to));
       }
       
       return res;
    }
    
    public ArrayList<EntityVMonitoredAccountDeprecated> getBankMonitors(BigDecimal bankId) throws MessageException {
      
      Connection conn = null;
      List<VMonitoredAccountsTo> tos = new ArrayList<>();
      try {
          conn = Connect.obtainConn(conn);
          tos = dataMonitoredAccs.getBankMonitors(conn, bankId);
      } catch (GDAOException e) {
          
          log.error("GDAO - Problem when getting monitored accounts: " + e.getMessage());
          throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
      } finally {
          Connect.returnConn(conn);
      }
  
      ArrayList<EntityVMonitoredAccountDeprecated> res= new ArrayList<>();
      
      for(VMonitoredAccountsTo to: tos) {
          res.add(new EntityVMonitoredAccountDeprecated(to));
      }
      
      return res;
  }
    public ArrayList<EntityVMonitoredAccountDeprecated> getMonitoredAccsByEmployee(String employeeId) throws MessageException {
       
       Connection conn = null;
       List<VMonitoredAccountsTo> tos = new ArrayList<>();
       try {
          conn = Connect.obtainConn(conn);
          tos = dataMonitoredAccs.getMonitoredAccountsByEmployeeId(conn, employeeId);
       } catch (GDAOException e) {
          
          log.error("GDAO - Problem when getting monitored accounts: " + e.getMessage());
          throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
       } finally {
          Connect.returnConn(conn);
       }
       
       ArrayList<EntityVMonitoredAccountDeprecated> res= new ArrayList<>();
       
       for(VMonitoredAccountsTo to: tos) {
          res.add(new EntityVMonitoredAccountDeprecated(to));
       }
       
       return res;
    }
    public ArrayList<EntityVMonitoredAccountDeprecated> getMonitorsByAccountBankId(BigDecimal accountBankId) throws MessageException {
       
       Connection conn = null;
       List<VMonitoredAccountsTo> tos = new ArrayList<>();
       try {
          conn = Connect.obtainConn(conn);
          tos = dataMonitoredAccs.getMonitorsByAccountBankId(conn, accountBankId);
       } catch (GDAOException e) {
          
          log.error("GDAO - Problem when getting monitored accounts: " + e.getMessage());
          throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
       } finally {
          Connect.returnConn(conn);
       }
       
       ArrayList<EntityVMonitoredAccountDeprecated> res= new ArrayList<>();
       
       for(VMonitoredAccountsTo to: tos) {
          res.add(new EntityVMonitoredAccountDeprecated(to));
       }
       
       return res;
    }
    public ArrayList<EntityVMonitoredAccountDeprecated> getMonitorsByAccountBankIdAndStatus(BigDecimal accountBankId, String status) throws MessageException {
       
       Connection conn = null;
       List<VMonitoredAccountsTo> tos = new ArrayList<>();
       try {
          conn = Connect.obtainConn(conn);
          tos = dataMonitoredAccs.getMonitorsByAccountBankIdAndStatus(conn, accountBankId, status);
       } catch (GDAOException e) {
          
          log.error("GDAO - Problem when getting monitored accounts: " + e.getMessage());
          throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
       } finally {
          Connect.returnConn(conn);
       }
       
       ArrayList<EntityVMonitoredAccountDeprecated> res= new ArrayList<>();
       
       for(VMonitoredAccountsTo to: tos) {
          res.add(new EntityVMonitoredAccountDeprecated(to));
       }
       
       return res;
    }
    
    public void updateAccount(AccountTo account) throws MessageException {
       Connection conn = null;
       try {
          conn = Connect.obtainConn(conn);
          dataAddress.updateByTo(conn, account);
       } catch(GDAOException e) {
          throw new MessageException("somethingWentWrong");
       } finally {
          Connect.returnConn(conn);
       }
    }

    
    /**
     * This main method is for testing purposes to test if queries work *Note, use another method from Connect class that is commented out
     * that requires DriverManager to connect to db
     * @param args
     * @throws MessageException
     */
    public static void main(String[] args) throws MessageException {
      AccountProvider ap = new AccountProvider();
      EmployeeProvider ep = new EmployeeProvider();
      
      ArrayList<EntityAccountDeprecated> allAccounts = ap.getAllAccounts();
      System.out.println("***All accounts list: ");
      for(EntityAccountDeprecated acc : allAccounts) {
         System.out.println(acc.getTo().getFIRST_NAME()+" "+acc.getTo().getLAST_NAME());
      }
      
      ArrayList<EntityAccountDeprecated> bankAccounts = ap.getBankAccounts(new BigDecimal(1));
      System.out.println("***Bank accounts list: ");
      for(EntityAccountDeprecated acc : bankAccounts) {
         System.out.println(acc.getTo().getFIRST_NAME()+" "+acc.getTo().getLAST_NAME());
      }
      
      ArrayList<EntityVMonitoredAccountDeprecated> actMonitoredAcc= ap.getMonitoredAccountsByStatus(new BigDecimal(1), new UtilCodeTypes().MonitorStatus.Codes.ACTIVE);
      System.out.println("***Active monitored accounts: ");
      for(EntityVMonitoredAccountDeprecated acc : actMonitoredAcc){
         System.out.println(acc.getTo().getACCOUNT_FIRST_NAME()+" "+acc.getTo().getACCOUNT_LAST_NAME());
      }
      
      ArrayList<EntityEmployeeDeprecated> employees = ep.getEmployeesByBankId(new BigDecimal(1));
      System.out.println("***Employees: ");
      for(EntityEmployeeDeprecated employee : employees){
         System.out.println(employee.getTo().getFIRST_NAME()+" "+employee.getTo().getLAST_NAME());
      }
      
      ArrayList<EntityVMonitoredAccountDeprecated> bankMonitors= ap.getBankMonitors(new BigDecimal(1));
      System.out.println("***All accounts monitored: ");
      for(EntityVMonitoredAccountDeprecated bankMonitor : bankMonitors){
         System.out.println(bankMonitor.getTo().getACCOUNT_FIRST_NAME()+" "+bankMonitor.getTo().getACCOUNT_LAST_NAME());
      }
      
      ArrayList<EntityVMonitoredAccountDeprecated> passed= ap.getMonitoredAccountsByStatus(new BigDecimal(1), new UtilCodeTypes().MonitorStatus.Codes.PASSED);
      System.out.println("***Active monitored accounts: ");
      for(EntityVMonitoredAccountDeprecated acc : passed){
         System.out.println(acc.getTo().getACCOUNT_FIRST_NAME()+" "+acc.getTo().getACCOUNT_LAST_NAME());
      } 
      
//      ArrayList<EntityVMonitoredAccountDeprecated> monitorsByEmployee= ap.getMonitoredAccsByEmployee(new BigDecimal(1));
//      System.out.println("***Monitored accounts by employee: ");
//      for(EntityVMonitoredAccountDeprecated bankMonitor : monitorsByEmployee){
//         System.out.println(bankMonitor.getTo().getACCOUNT_FIRST_NAME()+" "+bankMonitor.getTo().getACCOUNT_LAST_NAME());
//      }
      
      ArrayList<EntityVMonitoredAccountDeprecated> monitorsByAccountBank= ap.getMonitorsByAccountBankId(new BigDecimal(1));
      System.out.println("***Monitored accounts by account bank: ");
      for(EntityVMonitoredAccountDeprecated bankMonitor : monitorsByAccountBank){
         System.out.println(bankMonitor.getTo().getACCOUNT_FIRST_NAME()+" "+bankMonitor.getTo().getACCOUNT_LAST_NAME());
      }
      
      ArrayList<EntityVMonitoredAccountDeprecated> monitorsByAccountBankActive= ap.getMonitorsByAccountBankIdAndStatus(new BigDecimal(1), new UtilCodeTypes().MonitorStatus.Codes.ACTIVE);
      System.out.println("***Monitored ACTIVE accounts by account bank: ");
      for(EntityVMonitoredAccountDeprecated bankMonitor : monitorsByAccountBankActive){
         System.out.println(bankMonitor.getTo().getACCOUNT_FIRST_NAME()+" "+bankMonitor.getTo().getACCOUNT_LAST_NAME());
      }
      
      ArrayList<EntityVMonitoredAccountDeprecated> monitorsByAccountBankpassed= ap.getMonitorsByAccountBankIdAndStatus(new BigDecimal(1), new UtilCodeTypes().MonitorStatus.Codes.PASSED);
      System.out.println("***Monitored PASSED accounts by account bank: ");
      for(EntityVMonitoredAccountDeprecated bankMonitor : monitorsByAccountBankpassed){
         System.out.println(bankMonitor.getTo().getACCOUNT_FIRST_NAME()+" "+bankMonitor.getTo().getACCOUNT_LAST_NAME());
      }

   }


}

