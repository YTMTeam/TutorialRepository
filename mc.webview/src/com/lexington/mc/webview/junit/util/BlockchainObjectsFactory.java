package com.lexington.mc.webview.junit.util;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.lexington.mc.model.blockchain.pojos.AccountPojo;
import com.lexington.mc.model.blockchain.pojos.EmployeePojo;
import com.lexington.mc.model.blockchain.pojos.LoginPojo;
import com.lexington.mc.model.blockchain.pojos.MonitorPojo;
import com.lexington.mc.model.blockchain.pojos.PojoApi;
import com.lexington.mc.model.blockchain.pojos.PositionPojo;
import com.lexington.mc.model.blockchain.pojos.TradePojo;
import com.lexington.mc.model.entities.EntityUser;
import com.mallocinc.shared.util.time.TimestampUtility;

public class BlockchainObjectsFactory {
   
   public PojoApi getObject(String object){
      if(object == null){
         return null;
      }     
      
      switch(object) {
         case "ACCOUNT": {
            AccountPojo account = new AccountPojo();
            
            account.setACCOUNT_ID("SCOTIA-123");
            account.setBANK_ID(new BigDecimal(1));
            account.setACCOUNT_NUMBER("123");
            account.setFIRST_NAME("John");
            account.setMIDDLE_NAME("Markus");
            account.setLAST_NAME("Smith");
            account.setTYPE("Managed");
            account.setBROKER_CODE("007");
            account.setMANAGED_ACCOUNT("M");
            account.setACCOUNT_STATUS("A");
            
            return account;
         }
         case "TRADE":{
        	 TradePojo trade = new TradePojo();
        	 
        	 trade.setTRADE_ID("SCOTIA-123-11");
        	 trade.setACCOUNT_ID("SCOTIA-11");
        	 trade.setBANK_ID(new BigDecimal(1));
        	 trade.setCURRENCY("11");
        	 trade.setTRANSACTION_ID("12");
        	 trade.setTRANSACTION_TYPE("BUY");
        	 trade.setQUANTITY(new BigDecimal(36));
        	 trade.setEXCHANGE("TSX");
        	 trade.setEXECUTION_PRICE(new BigDecimal(112));
        	 trade.setSECURITY_NAME("a");
        	 trade.setSECURITY_TYPE("b");
        	 trade.setSECURITY_SYMBOL("COKE");
        	 trade.setNET_AMOUNT(new BigDecimal(100));
        	 trade.setISIN("");
        	 trade.setSEDOL("");
        	 trade.setISIN("");
        	 trade.setTRADE_DATE(new Timestamp(0));
        	 
        	 return trade;
         }
         case "POSITION":{
        	 PositionPojo position = new PositionPojo();
        	 
        	 position.setPOSITION_ID("S");
        	 position.setACCOUNT_ID("SCOTIA-5");
        	 position.setBROKER_CODE("SCOTIA");
        	 position.setSECURITY_SYMBOL("GM");
        	 position.setCUSIP("");
        	 position.setISIN("");
        	 position.setSEDOL("");
        	 position.setCURRENCY("USD");
        	 position.setEXPIRATION_DATE(new Timestamp(0));
        	 position.setEXECUTION_PRICE(new BigDecimal(48));
        	 position.setMARKET_PRICE(new BigDecimal(25));
        	 position.setQUANTITY(new BigDecimal(29));
        	 
        	 return position;
         }
         case "EMPLOYEE":{
        	 EmployeePojo employee = new EmployeePojo();
        	 
        	 employee.setEMPLOYEE_ID("SC-113");
        	 employee.setBANK_ID(new BigDecimal(1));
        	 employee.setEMPLOYING_INSTITUTION("");
        	 employee.setFIRST_NAME("John");
        	 employee.setLAST_NAME("Morgan");
        	 employee.setMIDDLE_NAME("V");
        
        	 
        	 return employee;
         }
         case "MONITOR":{
        	 MonitorPojo monitor = new MonitorPojo();
        	 monitor.setACCOUNT_FIRST_NAME("Alison");
        	 monitor.setACCOUNT_ID("SCOTIA-136");
        	 monitor.setACCOUNT_LAST_NAME("Smith");
        	 monitor.setACCOUNT_MIDDLE_NAME("M");
        	 monitor.setAS_OF_DATE(new Timestamp(0));
        	 monitor.setBANK_ID(new BigDecimal(1));
        	 monitor.setBROKER_CODE("SCOTIA");
        	 monitor.setCREATE_TIMESTAMP(new Timestamp(0));
        	 monitor.setEMPLOYEE_ID("SC-113");
        	 monitor.setEND_DATE(new Timestamp(0));
        	 monitor.setMONITOR_ID("SCOTIA-1-a3");
        	 monitor.setRELATIONSHIP("Sister");
        	 
        
        	 
        	 return monitor;
         }
         case "LOGIN":{
        	 LoginPojo login = new LoginPojo();
        	 EntityUser user = new EntityUser();
        	 
        	 user.getEntityBank().getBank().setBANK_CODE("SCOTIA");
        	 user.getUser().setUSER_NAME("scotia_admin");
			 
        	 login.setLOGIN_ID(user.getEntityBank().getBank().getBANK_CODE()+user.getUser().getUSER_NAME());
        	 login.setUSER_NAME(user.getUser().getUSER_NAME());
        	 login.setBANK_CODE(user.getEntityBank().getBank().getBANK_CODE());
        	 login.setCREATE_TIMESTAMP(TimestampUtility.getCurrentTimestamp());
        	 
        	 return login;
         }
      }
      
      return null;
   }
}
