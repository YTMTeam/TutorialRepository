package com.lexington.mc.logic.providers;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.lexington.mc.logic.entities.EntityEmployeeDeprecated;
import com.lexington.mc.logic.util.Connect;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.tables.DataEmployee;
import com.lexington.mc.model.tables.DataMonitor;
import com.mallocinc.codegenerator.exceptions.GDAOException;
import com.mallocinc.database.generated.to.EmployeeTo;

public class EmployeeProvider {
	final static Logger log = Logger.getLogger(EmployeeProvider.class.getName());
	private DataEmployee dataBank= new DataEmployee();
	
	
    public ArrayList<EntityEmployeeDeprecated> getEmployeesByBankId(BigDecimal bankId) throws MessageException {
       Connection conn = null;
       ArrayList<EntityEmployeeDeprecated> res=new ArrayList<>();
       ArrayList<EmployeeTo> employees;
       try {
          conn = Connect.obtainConn(conn);
           employees  = dataBank.getEmployeeByBankId(conn,bankId);
       } catch (GDAOException e) {

          log.error("GDAO - Problem when getting all banks: " + e.getMessage());
          throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
       } finally {
          Connect.returnConn(conn);
       }
       
       for(EmployeeTo employee : employees){
       res.add(new EntityEmployeeDeprecated(employee));
       }
       
       return res;
 }

    
    

	public EntityEmployeeDeprecated getEmployeeById(String employeeId) throws MessageException {
		  Connection conn = null;
	        EntityEmployeeDeprecated res=null;
	       EmployeeTo employee;
	       try {
	          conn = Connect.obtainConn(conn);
	           employee  = new DataEmployee().getEmployeeById(conn,employeeId);
	       } catch (GDAOException e) {

	          log.error("GDAO - Problem when getting employee: " + e.getMessage());
	          throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
	       } finally {
	          Connect.returnConn(conn);
	       }
	       
	      if(employee==null)
	    	  return null;
	      
	      
	       
	       return new EntityEmployeeDeprecated(employee);
	}




//	public void updateEmployeeMonitors(ArrayList<EmployeeTo> toUpdate, BigDecimal employee_ID) {
//		log.info("started updating monitors");
//		 Connection connection = null;
//	      DataMonitor dataMonitor = new DataMonitor();
//	      try {
//	         connection = Connect.obtainConn(connection);
//	         connection.setAutoCommit(false);
//	         dataMonitor.deleteByAccountId(connection, employee_ID);
//	         dataMonitor.insertMonitorBatch(connection, toUpdate);
//	         
//	         connection.commit();
//	      } catch (SQLException | GDAOException e) {
//	         Connect.rethrowExceptionAndTryRollback(connection, "somethingWentWrong", e);
//	      } finally {
//	         Connect.returnConn(connection);
//	      }
//		
//	}
}
