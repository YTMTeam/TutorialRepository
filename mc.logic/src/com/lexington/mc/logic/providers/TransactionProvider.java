//package com.lexington.mc.logic.providers;
//
//import java.sql.Connection;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.log4j.Logger;
//
//import com.lexington.mc.logic.entities.EntityVTransactionBlock;
//import com.lexington.mc.logic.util.Connect;
//import com.lexington.mc.logic.util.MessageException;
//import com.lexington.mc.model.views.DataVTransactionBlock;
//import com.mallocinc.codegenerator.exceptions.GDAOException;
//import com.mallocinc.database.generated.to.VTransactionBlockTo;
//
//public class TransactionProvider {
//	final static Logger log = Logger.getLogger(TransactionProvider.class.getName());
//DataVTransactionBlock dataVTransactionBlock = new DataVTransactionBlock();
//	
//	
//	public List<EntityVTransactionBlock> getTxBlocksForPaging(int first, int pageSize, String sortField, String sortOrder,
//			Map<String, Object> filters) throws MessageException {
//
//	      Connection conn = null;
//	      List<VTransactionBlockTo> tos = new ArrayList<>();
//	      try {
//	         conn = Connect.obtainConn(conn);
//	         tos = dataVTransactionBlock.getTxBlocksForPaging(conn, first, pageSize, sortField, sortOrder, filters);
//	         Connect.returnConn(conn);
//	      } catch (GDAOException e) {
//
//	         log.error("GDAO - Problem when getting transactions : " + e.getMessage());
//	         throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
//	      } finally {
//	         Connect.returnConn(conn);
//	      }
//	      
//	      
//	      ArrayList<EntityVTransactionBlock> res= new ArrayList<>();
//	      for(VTransactionBlockTo to: tos)
//	    	  res.add(new EntityVTransactionBlock(to));
//	      return res;
//	}
//
//
//	public long getTxBlocksFilterCount(Map<String, Object> filters) throws MessageException {
//		   Connection conn = null;
//		      long count = 0;
//		      try {
//		         conn = Connect.obtainConn(conn);
//		         count = dataVTransactionBlock.getTxBlocksFilterCount(conn, filters);
//		         Connect.returnConn(conn);
//		      } catch (GDAOException e) {
//
//		         log.error("GDAO - Problem when counting rows in view V_TRANSACTION_BLOCK: " + e.getMessage());
//		         throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
//		      } finally {
//		         Connect.returnConn(conn);
//		      }
//		      return count;
//	}
//
//
//	public List<EntityVTransactionBlock> getNewestTransactions(int numberOfTxs) throws MessageException {
//		 Connection conn = null;
//	      List<VTransactionBlockTo> tos = new ArrayList<>();
//	      try {
//	         conn = Connect.obtainConn(conn);
//	         tos = dataVTransactionBlock.getNewestTransactions(conn,numberOfTxs);
//	         Connect.returnConn(conn);
//	      } catch (GDAOException e) {
//
//	         log.error("GDAO - Problem when getting txs: " + e.getMessage());
//	         throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
//	      } finally {
//	         Connect.returnConn(conn);
//	      }
//	      
//	      
//	      ArrayList<EntityVTransactionBlock> res= new ArrayList<>();
//	      for(VTransactionBlockTo to: tos)
//	    	  res.add(new EntityVTransactionBlock(to));
//	      return res;
//	}
//}
