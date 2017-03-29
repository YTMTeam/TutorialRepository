package com.lexington.mc.logic.excel.util;

import java.util.ArrayList;

import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.entities.EntityUser;

/**
 * This interface is used for every ExcelDataLoader, it has a predefined set of methods that has to be used in order to load excel data.
 * @author Dev
 *
 */
public interface IExcelCellLoader {

	/**
	 * This method should check if there are any constraint errors that are related to excel files.
	 * For example, if we insert Account information - this method should initially check if all account codes exist and store their IDs that can be later used.
	 * @return - true if there are no errors, otherwise false.
	 */
public boolean constraintErrorCheck() throws MessageException;
/**
 * This method is used to read excel file row by row and check for errors, it should store objects into global variable of a class
 * For example: If this method is being called inside AccountDataLoader, it should store account list that will be further inserted in insertInformation() method.
 * @param absoluteFilePath
 * @param user
 * @return - true if there are no errors, otherwise false
 */
public boolean readDataFromExcel(String absoluteFilePath, EntityUser user);
/**
 * This method is used to insert information into database that is previously read from excel file.
 * @param user
 * @param privateKey - privateKey for this bank that is stored in session
 * @return - a list of inserted objects.
 */
public ArrayList<?> insertInformation(EntityUser user, String privateKey) throws MessageException;
}
