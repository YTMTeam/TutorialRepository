//package com.lexington.mc.logic.providers;
//
//import java.math.BigDecimal;
//import java.sql.Connection;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.log4j.Logger;
//
//import com.lexington.mc.logic.entities.EntityVAddressAssetBalance;
//import com.lexington.mc.logic.entities.EntityVAddressAssetSubbalance;
//import com.lexington.mc.logic.util.Connect;
//import com.lexington.mc.logic.util.MessageException;
//import com.lexington.mc.model.views.DataVAddressAssetBalance;
//import com.lexington.mc.model.views.DataVAddressAssetSubbalance;
//import com.mallocinc.codegenerator.exceptions.GDAOException;
//import com.mallocinc.database.generated.to.VAddressAssetBalanceTo;
//import com.mallocinc.database.generated.to.VAddressAssetSubbalanceTo;
//
//public class BalanceProvider {
//	final static Logger log = Logger.getLogger(BalanceProvider.class.getName());
//	
//	private DataVAddressAssetSubbalance dataVAddressAssetSubbalance=new DataVAddressAssetSubbalance();  
//	private DataVAddressAssetBalance dataVAddressAssetBalance = new DataVAddressAssetBalance();
//	
//	public ArrayList<EntityVAddressAssetSubbalance> getLastAddressAsssetBalances(BigDecimal address_id, BigDecimal asset_id, int numberOfChanges)throws MessageException {
//		 Connection conn = null;
//	      List<VAddressAssetSubbalanceTo> tos = new ArrayList<>();
//	      try {
//	         conn = Connect.obtainConn(conn);
//	         tos = dataVAddressAssetSubbalance.getLastAddressAsssetBalances(conn, address_id, asset_id, numberOfChanges);
//	         Connect.returnConn(conn);
//	      } catch (GDAOException e) {
//
//	         log.error("GDAO - Problem when getting EntityVAddressAssetSubbalance: " + e.getMessage());
//	         throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
//	      } finally {
//	         Connect.returnConn(conn);
//	      }
//	      
//	      
//	      ArrayList<EntityVAddressAssetSubbalance> res= new ArrayList<>();
//	      for(VAddressAssetSubbalanceTo to: tos)
//	    	  res.add(new EntityVAddressAssetSubbalance(to));
//	      return res;  
//	  }
//	
//	public  EntityVAddressAssetBalance getBalanceByAddressAsset(BigDecimal address_Id, BigDecimal asset_Id) throws MessageException{
//		 Connection conn = null;
//	       VAddressAssetBalanceTo to = null;
//	      try {
//	         conn = Connect.obtainConn(conn);
//	         to = dataVAddressAssetBalance.getBalanceByAddressAsset(address_Id, asset_Id, conn);
//	         Connect.returnConn(conn);
//	      } catch (GDAOException e) {
//
//	         log.error("GDAO - Problem when getting EntityVAddressAssetBalance: " + e.getMessage());
//	         throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
//	      } finally {
//	         Connect.returnConn(conn);
//	         
//	      }
//	      
//	      
//	      
//	      return to== null ? null : new EntityVAddressAssetBalance(to);  
//		
//	}
//
//	public ArrayList<EntityVAddressAssetBalance> getAllAddressBalances(BigDecimal address_id) throws MessageException {
//		 Connection conn = null;
//	      List<VAddressAssetBalanceTo> tos = new ArrayList<>();
//	      try {
//	         conn = Connect.obtainConn(conn);
//	         tos = dataVAddressAssetBalance.getAllAddressBalances(conn, address_id);
//	         Connect.returnConn(conn);
//	      } catch (GDAOException e) {
//
//	         log.error("GDAO - Problem when getting address balances: " + e.getMessage());
//	         throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
//	      } finally {
//	         Connect.returnConn(conn);
//	      }
//	      
//	      
//	      ArrayList<EntityVAddressAssetBalance> res= new ArrayList<>();
//	      for(VAddressAssetBalanceTo to: tos)
//	    	  res.add(new EntityVAddressAssetBalance(to));
//	      return res;  
//	}
//}
