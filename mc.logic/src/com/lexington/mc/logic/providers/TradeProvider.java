package com.lexington.mc.logic.providers;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.lexington.mc.logic.entities.EntityVPaymentDeprecated;
import com.lexington.mc.logic.util.Connect;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.views.DataVTrade;
import com.mallocinc.codegenerator.exceptions.GDAOException;
import com.mallocinc.database.generated.to.VTradeTo;

public class TradeProvider {
	final static Logger log = Logger.getLogger(BlockProvider.class.getName());
	DataVTrade dataVPayment = new DataVTrade();
	
	/**
	 * DIRECTION CAN BE BUY OR SELL
	 * @param userId
	 * @param direction
	 * @return
	 * @throws MessageException
	 */
	public long getDirectionCountForUserId(BigDecimal userId, String direction) throws MessageException {
		long count = 0;
		Connection conn = null;
		try {
			conn = Connect.obtainConn(conn);
			count  = dataVPayment.getDirectionCountForUser(conn, userId, direction);
			Connect.returnConn(conn);
		} catch (GDAOException e) {
			
			log.error("GDAO - Problem when getting payment: " + e.getMessage());
			throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
		} finally {
			Connect.returnConn(conn);
		}
		return count;
	}
	/**
	 * DIRECTION CAN BE BUY OR SELL
	 * @param userId
	 * @param direction
	 * @return
	 * @throws MessageException
	 */
	public long getDirectionCountForGroupId(BigDecimal groupId, String direction) throws MessageException {
		long count = 0;
		Connection conn = null;
		try {
			conn = Connect.obtainConn(conn);
			count  = dataVPayment.getDirectionCountForGroup(conn, groupId, direction);
			Connect.returnConn(conn);
		} catch (GDAOException e) {
			
			log.error("GDAO - Problem when getting payment: " + e.getMessage());
			throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
		} finally {
			Connect.returnConn(conn);
		}
		return count;
	}
	public VTradeTo getPaymentByPaymentId(BigDecimal paymentId) throws MessageException {
		VTradeTo users = new VTradeTo();
		Connection conn = null;
		try {
			conn = Connect.obtainConn(conn);
			users  = dataVPayment.getPaymentById(conn, paymentId);
			Connect.returnConn(conn);
		} catch (GDAOException e) {
			
			log.error("GDAO - Problem when getting payment: " + e.getMessage());
			throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
		} finally {
			Connect.returnConn(conn);
		}
		return users;
	}
	
	public long getAddressAssetPaymentsFilterCount(Map<String, Object> filters, BigDecimal addressId, BigDecimal assetId) throws MessageException {
		   Connection conn = null;
		      long count = 0;
		      try {
		         conn = Connect.obtainConn(conn);
		         count = dataVPayment.getAddressAssetPaymentsFilterCount(conn, filters,addressId,assetId);
		         Connect.returnConn(conn);
		      } catch (GDAOException e) {

		         log.error("GDAO - Problem when counting rows in address payments view: " + e.getMessage());
		         throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
		      } finally {
		         Connect.returnConn(conn);
		      }
		      return count;
	}

	public List<EntityVPaymentDeprecated> getAddressAssetPaymentsForPaging(int first, int pageSize, String sortField,
			String sortOrder, Map<String, Object> filters, BigDecimal addressId, BigDecimal assetId) throws MessageException {

	      Connection conn = null;
	      List<VTradeTo> tos = new ArrayList<>();
	      try {
	         conn = Connect.obtainConn(conn);
	         tos = dataVPayment.getAddressAssetPaymentsForPaging(conn, first, pageSize, sortField, sortOrder, filters, addressId, assetId);
	         Connect.returnConn(conn);
	      } catch (GDAOException e) {

	         log.error("GDAO - Problem when getting assets: " + e.getMessage());
	         throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
	      } finally {
	         Connect.returnConn(conn);
	      }
	      
	      
	      ArrayList<EntityVPaymentDeprecated> res= new ArrayList<>();
	      for(VTradeTo to: tos)
	    	  res.add(new EntityVPaymentDeprecated(to));
	      return res;
	}
	public long getUserPaymentsPaymentsFilterCount(Map<String, Object> filters, String addressId) throws MessageException {
		Connection conn = null;
		long count = 0;
		try {
			conn = Connect.obtainConn(conn);
			count = dataVPayment.getUserPaymentsFilterCount(conn, filters,addressId);
			Connect.returnConn(conn);
		} catch (GDAOException e) {
			
			log.error("GDAO - Problem when counting rows in address payments view: " + e.getMessage());
			throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
		} finally {
			Connect.returnConn(conn);
		}
		return count;
	}
	
	public List<EntityVPaymentDeprecated> getUserPaymentsForPaging(int first, int pageSize, String sortField,
			String sortOrder, Map<String, Object> filters, String addressId) throws MessageException {
		
		Connection conn = null;
		List<VTradeTo> tos = new ArrayList<>();
		try {
			conn = Connect.obtainConn(conn);
			tos = dataVPayment.getUserPaymentsForPaging(conn, first, pageSize, sortField, sortOrder, filters, addressId);
			Connect.returnConn(conn);
		} catch (GDAOException e) {
			
			log.error("GDAO - Problem when getting assets: " + e.getMessage());
			throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
		} finally {
			Connect.returnConn(conn);
		}
		
		
		ArrayList<EntityVPaymentDeprecated> res= new ArrayList<>();
		for(VTradeTo to: tos)
			res.add(new EntityVPaymentDeprecated(to));
		return res;
	}
	public long getGroupPaymentsFilterCount(Map<String, Object> filters, BigDecimal groupId) throws MessageException {
		Connection conn = null;
		long count = 0;
		try {
			conn = Connect.obtainConn(conn);
			count = dataVPayment.getGroupPaymentsFilterCount(conn, filters,groupId);
			Connect.returnConn(conn);
		} catch (GDAOException e) {
			
			log.error("GDAO - Problem when counting rows in address payments view: " + e.getMessage());
			throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
		} finally {
			Connect.returnConn(conn);
		}
		return count;
	}
	
	public List<EntityVPaymentDeprecated> getGroupPaymentsForPaging(int first, int pageSize, String sortField,
			String sortOrder, Map<String, Object> filters, BigDecimal groupId) throws MessageException {
		
		Connection conn = null;
		List<VTradeTo> tos = new ArrayList<>();
		try {
			conn = Connect.obtainConn(conn);
			tos = dataVPayment.getGroupPaymentsForPaging(conn, first, pageSize, sortField, sortOrder, filters, groupId);
			Connect.returnConn(conn);
		} catch (GDAOException e) {
			
			log.error("GDAO - Problem when getting assets: " + e.getMessage());
			throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
		} finally {
			Connect.returnConn(conn);
		}
		
		
		ArrayList<EntityVPaymentDeprecated> res= new ArrayList<>();
		for(VTradeTo to: tos)
			res.add(new EntityVPaymentDeprecated(to));
		return res;
	}
}
