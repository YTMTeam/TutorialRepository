package com.lexington.mc.logic.providers;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.lexington.mc.logic.entities.EntityAccountDeprecated;
import com.lexington.mc.logic.entities.EntityPositionDeprecated;
import com.lexington.mc.logic.util.Connect;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.tables.DataPosition;
import com.mallocinc.codegenerator.exceptions.GDAOException;
import com.mallocinc.database.generated.to.AccountTo;
import com.mallocinc.database.generated.to.PositionTo;

public class PositionProvider {
	final static Logger log = Logger.getLogger(PositionProvider.class.getName());
	private DataPosition dataPosition= new DataPosition();
	
	public List<EntityPositionDeprecated> getPositionFromAccountForPaging(int first, int pageSize, String sortField, String sortOrder,
			Map<String, Object> filters, String accountId) throws MessageException {

	      Connection conn = null;
	      List<PositionTo> tos = new ArrayList<>();
	      try {
	         conn = Connect.obtainConn(conn);
	         tos = dataPosition.getPositionByAccountIdForPaging(conn, first, pageSize, sortField, sortOrder, filters, accountId);
	         Connect.returnConn(conn);
	      } catch (GDAOException e) {

	         log.error("GDAO - Problem when getting position: " + e.getMessage());
	         throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
	      } finally {
	         Connect.returnConn(conn);
	      }
	      
	      
	      ArrayList<EntityPositionDeprecated> res= new ArrayList<>();
	      for(PositionTo to: tos) {
	    	  res.add(new EntityPositionDeprecated(to));
	      }
	      return res;
	}
	
	public long getPositionFromAccountFilterCount(Map<String, Object> filters, String accountId) throws MessageException {
		   Connection conn = null;
		      long count = 0;
		      try {
		         conn = Connect.obtainConn(conn);
		         count = dataPosition.getPositionByAccountIdFilterCount(conn, filters, accountId);
		         Connect.returnConn(conn);
		      } catch (GDAOException e) {

		         log.error("GDAO - Problem when counting rows in address position: " + e.getMessage());
		         throw new MessageException("error", MessageException.ERROR, "somethingWentWrong");
		      } finally {
		         Connect.returnConn(conn);
		      }
		      return count;
	}
}
