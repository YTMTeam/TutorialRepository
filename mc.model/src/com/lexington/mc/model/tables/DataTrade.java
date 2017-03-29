package com.lexington.mc.model.tables;

import java.sql.Connection;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.lexington.mc.model.util.UtilCodeTypes;
import com.lexington.mc.model.util.UtilData;
import com.mallocinc.codegenerator.exceptions.GDAOException;
import com.mallocinc.database.generated.to.PositionTo;
import com.mallocinc.database.generated.to.TradeTo;
import com.mallocinc.database.generated.working.TradeTab;

public class DataTrade {
	UtilCodeTypes uct = new UtilCodeTypes();
	final static Logger log = Logger.getLogger(DataTrade.class.getName());

	/**********************************************************************
	 *
	 * TRANSACTION_STRATEGY_TRESHOLD is the number of records that will 
	 * be changed and it is used to determine most optimum strategy
	 * for executing the task. 
	 * In order to get the best results this number should be determined 
	 * by experience or by experimenting.
	 *
	 **********************************************************************/
	final static long TRANSACTION_STRATEGY_TRESHOLD = 100000;

	/**********************************************************************
	 *
	 * TRANSACTION_TRESHOLD identifies number of updates/inserts or deletes
	 * in one database transaction.
	 * In order to get the best results this number should be determined 
	 * by experience or by experimenting.
	 *
	 **********************************************************************/
	final static long TRANSACTION_TRESHOLD = 1000;

	UtilData utilData= new UtilData();

	public ArrayList<TradeTo> insertArrayOfTrades(Connection connection, ArrayList<TradeTo> trades) {

		ArrayList<TradeTo> result = new ArrayList<>();
		String whatWeAreDoing = "\"insertArrayOfUsersTo()\" for TABLE \"TRADE\"";

		log.debug("Starting " + whatWeAreDoing);

		TradeTab position = new TradeTab(connection);
		for (TradeTo tradeForInsert : trades) {

			try {
				position.insert(tradeForInsert);
				result.add(tradeForInsert);
			} catch (GDAOException exception) {
				log.info("Account with POSITION_ID: " + tradeForInsert.getTRADE_ID() + " ,already exists into database.");
			}
		}
		try {
			position.releaseStatement();
		} catch (GDAOException e) {
			log.error("Error on releaseStatement() on accountTab object.", e);
		}
		log.debug("Ending " + whatWeAreDoing);
		return result;
	}
}
