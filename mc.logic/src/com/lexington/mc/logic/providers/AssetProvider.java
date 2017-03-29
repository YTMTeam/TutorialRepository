//package com.lexington.mc.logic.providers;
//
//import java.sql.Connection;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.log4j.Logger;
//
//import com.lexington.mc.logic.entities.EntityVAssetAddressCount;
//import com.lexington.mc.logic.util.Connect;
//import com.lexington.mc.logic.util.MessageException;
//import com.lexington.mc.model.views.DataVAssetAddressCount;
//import com.mallocinc.codegenerator.exceptions.GDAOException;
//import com.mallocinc.database.generated.to.VAssetAddressCountTo;
//
//public class AssetProvider {
//DataVAssetAddressCount dataVAssetAddressCount = new DataVAssetAddressCount();
//final static Logger log = Logger.getLogger(AssetProvider.class.getName());
//
//
//	public long getVAssetAddressCountFilterCount(Map<String, Object> filters) throws MessageException {
//	 
//	      Connection conn = null;
//	      long count = 0;
//	      try {
//	         conn = Connect.obtainConn(conn);
//	         count = dataVAssetAddressCount.getVAssetAddressCountFilterCount(conn, filters);
//	         Connect.returnConn(conn);
//	      } catch (GDAOException e) {
//
//	         log.error("GDAO - Problem when counting rows in assets table: " + e.getMessage());
//	         throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
//	      } finally {
//	         Connect.returnConn(conn);
//	      }
//	      return count;
//	}
//
//	public List<EntityVAssetAddressCount> getVAssetAddressCountForPaging(int first, int pageSize, String sortField,
//			String sortOrder, Map<String, Object> filters) throws MessageException {
//		 
//	      Connection conn = null;
//	      List<VAssetAddressCountTo> tos = new ArrayList<>();
//	      try {
//	         conn = Connect.obtainConn(conn);
//	         tos = dataVAssetAddressCount.getVAssetAddressCountForPaging(conn, first, pageSize, sortField, sortOrder, filters);
//	         Connect.returnConn(conn);
//	      } catch (GDAOException e) {
//
//	         log.error("GDAO - Problem when getting assets: " + e.getMessage());
//	         throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
//	      } finally {
//	         Connect.returnConn(conn);
//	      }
//	      
//	      
//	      ArrayList<EntityVAssetAddressCount> res= new ArrayList<>();
//	      for(VAssetAddressCountTo to: tos)
//	    	  res.add(new EntityVAssetAddressCount(to));
//	      return res;
//	}
//
//	public List<EntityVAssetAddressCount> getNewestAssets(int numberOfAssets) throws MessageException {
//		 Connection conn = null;
//	      List<VAssetAddressCountTo> tos = new ArrayList<>();
//	      try {
//	         conn = Connect.obtainConn(conn);
//	         tos = dataVAssetAddressCount.getNewestAssets(conn,numberOfAssets);
//	         Connect.returnConn(conn);
//	      } catch (GDAOException e) {
//
//	         log.error("GDAO - Problem when getting assets: " + e.getMessage());
//	         throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
//	      } finally {
//	         Connect.returnConn(conn);
//	      }
//	      
//	      
//	      ArrayList<EntityVAssetAddressCount> res= new ArrayList<>();
//	      for(VAssetAddressCountTo to: tos)
//	    	  res.add(new EntityVAssetAddressCount(to));
//	      return res;
//	}
//
//}
