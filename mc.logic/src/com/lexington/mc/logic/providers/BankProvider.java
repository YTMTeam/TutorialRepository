package com.lexington.mc.logic.providers;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.lexington.mc.logic.entities.EntityBankDeprecated;
import com.lexington.mc.logic.util.Connect;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.tables.DataBank;
import com.mallocinc.codegenerator.exceptions.GDAOException;
import com.mallocinc.database.generated.to.BankTo;

public class BankProvider {
	final static Logger log = Logger.getLogger(BankProvider.class.getName());
	private DataBank dataBank= new DataBank();
	
	
	public EntityBankDeprecated getBankByBankId(BigDecimal bankId) throws MessageException {
		  Connection conn = null;
	       BankTo  to;
	      try {
	         conn = Connect.obtainConn(conn);
	         to  = dataBank.getBankByBankId(conn, bankId);
	      } catch (GDAOException e) {

	         log.error("GDAO - Problem when getting bank: " + e.getMessage());
	         throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
	      } finally {
	         Connect.returnConn(conn);
	      }
	      
	      if(to==null)  { 
	    	  return null;
	    	  }
	      
	      return new EntityBankDeprecated(to);
	}


	public ArrayList<EntityBankDeprecated> getAllBanks() throws MessageException {
		  Connection conn = null;
		  ArrayList<EntityBankDeprecated> res=new ArrayList<>();
		  ArrayList<BankTo> bankTos;
	      try {
	         conn = Connect.obtainConn(conn);
	          bankTos  = dataBank.getAllBanks(conn);
	      } catch (GDAOException e) {

	         log.error("GDAO - Problem when getting all banks: " + e.getMessage());
	         throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
	      } finally {
	         Connect.returnConn(conn);
	      }
	      for(BankTo bankTo : bankTos){
	      res.add(new EntityBankDeprecated(bankTo));
	      }
	      return res;
	}
}
