package com.lexington.mc.logic.providers;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

import com.lexington.mc.logic.entities.EntityBlockDeprecated;
import com.lexington.mc.logic.util.Connect;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.tables.DataBlock;
import com.mallocinc.codegenerator.exceptions.GDAOException;
import com.mallocinc.database.generated.to.BlockTo;

public class BlockProvider {
	final static Logger log = Logger.getLogger(BlockProvider.class.getName());
	DataBlock dataBlock = new DataBlock();
	
	
	public List<EntityBlockDeprecated> getBlocksForPaging(int first, int pageSize, String sortField, String sortOrder,
			Map<String, Object> filters) throws MessageException {

	      Connection conn = null;
	      List<BlockTo> tos = new ArrayList<>();
	      try {
	         conn = Connect.obtainConn(conn);
	         tos = dataBlock.getBlocksForPaging(conn, first, pageSize, sortField, sortOrder, filters);
	         Connect.returnConn(conn);
	      } catch (GDAOException e) {

	         log.error("GDAO - Problem when getting assets: " + e.getMessage());
	         throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
	      } finally {
	         Connect.returnConn(conn);
	      }
	      
	      
	      ArrayList<EntityBlockDeprecated> res= new ArrayList<>();
	      for(BlockTo to: tos)
	    	  res.add(new EntityBlockDeprecated(to));
	      return res;
	}


	public long getBlocksFilterCount(Map<String, Object> filters) throws MessageException {
		   Connection conn = null;
		      long count = 0;
		      try {
		         conn = Connect.obtainConn(conn);
		         count = dataBlock.getBlocksFilterCount(conn, filters);
		         Connect.returnConn(conn);
		      } catch (GDAOException e) {

		         log.error("GDAO - Problem when counting rows in block table: " + e.getMessage());
		         throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
		      } finally {
		         Connect.returnConn(conn);
		      }
		      return count;
	}


	public List<EntityBlockDeprecated> getLatestBlocks(int numberOfBlocks) throws MessageException {
		   Connection conn = null;
		      List<BlockTo> tos = new ArrayList<>();
		      try {
		         conn = Connect.obtainConn(conn);
		         tos = dataBlock.getLatestBlocks(conn, numberOfBlocks);
		         Connect.returnConn(conn);
		      } catch (GDAOException e) {

		         log.error("GDAO - Problem when getting assets: " + e.getMessage());
		         throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
		      } finally {
		         Connect.returnConn(conn);
		      }
		      
		      
		      ArrayList<EntityBlockDeprecated> res= new ArrayList<>();
		      for(BlockTo to: tos)
		    	  res.add(new EntityBlockDeprecated(to));
		      return res;
	}
}