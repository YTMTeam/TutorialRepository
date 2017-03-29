package com.lexington.mc.model.util;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class UtilData {

	public static final String ORDER_ASC  = "ASC";
	public static final String ORDER_DESC = "DESC";
	public static final String ORDER_NONE = "";

	public static final String EXACT_FILTER= "#E$X%F*@*^";

	public static void main (String [] args) {

		String filterValue= "#E$X%F*@*^1234";

		filterValue=filterValue.substring(EXACT_FILTER.length());


		//	   UtilData ud= new UtilData();
		//	  String result= ud.getAllPathsUnion("|PATH1|22|33|44|55", "|");
		System.out.println(filterValue);

	}



	/**
   public String preparePagingStatementString(Connection conn, String tableName, int first,
   		int pageSize, String sortField, String sortOrder,
   		Map<String, Object> filters) throws SQLException{

   	String selectSQL = "SELECT * FROM " + tableName+ " WHERE ";

   	if (filters != null) {
   		for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {

   			String columnName = it.next();
   			String filterValue = filters.get(columnName);
   			if(filterValue!=null) {
   				selectSQL+=columnName+" LIKE '%"+filterValue+"%' ";

   			}
   		}
   	}
   		if(!sortField.isEmpty()){
   			selectSQL+="ORDER BY "+sortField+" ";
   			if(!sortOrder.equals(this.ORDER_NONE))
   				selectSQL+=sortOrder;

   		}

   		selectSQL+="OFFSET "+first+" ROWS FETCH NEXT "+pageSize+" ROWS ONLY;";


    return selectSQL;
   }
	 **/
	public String preparePagingStatementString(int first,
			int pageSize,
			String sortField,
			String sortOrder,
			Map<String, Object> filters,
			boolean includeWhereClause) {

		String selectSQL = "";
		int filterCount = 0;
		if (filters != null)
			if (!filters.isEmpty()) {
				if (includeWhereClause)
					selectSQL = "WHERE ";
				else
					selectSQL = "";
				for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {

					String columnName = it.next();
					String filterValue = (String)filters.get(columnName);
					if (filterValue != null) {
						if (filterCount > 0)
							selectSQL += " AND ";
						filterCount++;
						if(filterValue.startsWith(EXACT_FILTER)){
							filterValue=filterValue.substring(EXACT_FILTER.length());
							selectSQL +="UPPER("+columnName +") = UPPER('" + filterValue + "') ";


						}
						else{

							if(columnName.equals("LAST_NAME"))
							{

								selectSQL +="((UPPER("+columnName +") LIKE UPPER('%" + filterValue + "%')) OR (UPPER(FIRST_NAME) LIKE UPPER('%" + filterValue + "%'))) ";

							}
							else  if(columnName.equals("USER_LAST_NAME"))
							{

								selectSQL +="((UPPER("+columnName +") LIKE UPPER('%" + filterValue + "%')) OR (UPPER(USER_FIRST_NAME) LIKE UPPER('%" + filterValue + "%'))) ";

							}
							else{
								selectSQL +="UPPER("+columnName +") LIKE UPPER('%" + filterValue + "%') ";//// selectSQL += "UPPER(" + columnName + ") LIKE UPPER('%" + filterValue + "%') ";

							}

						}
					}
				}
			}
		if (sortField != null)
			if (!sortField.isEmpty()) {
				selectSQL += "ORDER BY " + sortField + " ";
				if (!sortOrder.equals(UtilData.ORDER_NONE))
					selectSQL += sortOrder + " ";

			}

		selectSQL += "OFFSET " + first + " ROWS FETCH NEXT " + pageSize + " ROWS ONLY"; 

		return selectSQL;
	}

	public String prepareSearchStatementString(int first,
			int pageSize,
			String sortField,
			String sortOrder,
			Map<String, Object> filters,
			boolean includeWhereClause) {

		String selectSQL = "";
		int filterCount = 0;
		if (filters != null)
			if (!filters.isEmpty()) {
				if (includeWhereClause)
					selectSQL = "WHERE (";
				else
					selectSQL = " ( ";
				for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {

					String columnName = it.next();
					String filterValue = (String)filters.get(columnName);
					if (filterValue != null) {
						if (filterCount > 0)
							selectSQL += " OR ";
						filterCount++;
						selectSQL += "UPPER(" + columnName + ") LIKE UPPER('%" + filterValue + "%') ";

					}
				}
				selectSQL += " ) ";
			}
		if (sortField != null)
			if (!sortField.isEmpty()) {
				selectSQL += "ORDER BY " + sortField + " ";
				if (!sortOrder.equals(UtilData.ORDER_NONE))
					selectSQL += sortOrder + " ";

			}

		selectSQL += "OFFSET " + first + " ROWS FETCH NEXT " + pageSize + " ROWS ONLY";

		return selectSQL;
	}
	/*
   public int getFilteredCountFromTable(Connection conn, Map<String, Object> filters, String tableName) throws SQLException {
      int count = 0;
      String query = "SELECT COUNT(*) AS TOTAL FROM " + tableName;
      int filterCount = 0;
      Statement stmt = conn.createStatement();
      if (filters != null)
         if (!filters.isEmpty()) {
            query += " WHERE ";
            for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {

               String columnName = it.next();
               String filterValue = filters.get(columnName);
               if (filterValue != null) {
                  if (filterCount > 0)
                     query += " AND ";
                  filterCount++;
                  query += columnName + " LIKE '%" + filterValue + "%' ";

               }
            }
         }

      ResultSet rs = stmt.executeQuery(query);
      while (rs.next()) {
         count = rs.getInt("TOTAL");
      }
      return count;
   }
	 */
	public String prepareCountString(Map<String, Object> filters, boolean includeWhereClause) {

		String query = "";
		int filterCount = 0;

		if (filters != null)
			if (!filters.isEmpty()) {
				if (includeWhereClause)
					query = "WHERE ";
				else
					query = "";
				for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {

					String columnName = it.next();
					String filterValue = (String)filters.get(columnName);
					if (filterValue != null) {
						if (filterCount > 0)
							query += " AND ";
						filterCount++;


						if(filterValue.startsWith(EXACT_FILTER)){
							filterValue=filterValue.substring(EXACT_FILTER.length());
							query +="UPPER("+columnName +") = UPPER('" + filterValue + "') ";
						}
						else
							//                  query +="UPPER("+columnName +") LIKE UPPER('%" + filterValue + "%') ";//// selectSQL += "UPPER(" + columnName + ") LIKE UPPER('%" + filterValue + "%') ";

							if(columnName.equals("LAST_NAME"))
							{

								query +="((UPPER("+columnName +") LIKE UPPER('%" + filterValue + "%')) OR (UPPER(FIRST_NAME) LIKE UPPER('%" + filterValue + "%'))) ";

							}
							else  if(columnName.equals("USER_LAST_NAME"))
							{

								query +="((UPPER("+columnName +") LIKE UPPER('%" + filterValue + "%')) OR (UPPER(USER_FIRST_NAME) LIKE UPPER('%" + filterValue + "%'))) ";

							}
							else{
								query +="UPPER("+columnName +") LIKE UPPER('%" + filterValue + "%') ";//// selectSQL += "UPPER(" + columnName + ") LIKE UPPER('%" + filterValue + "%') ";

							}


					}
				}
			}
		return query;
	}

	/**
	 * Can be used when we have additional filter checks beyond the ones inside the filters map, and we don't know if the filters is empty or we shoud put AND before filters.
	 * @param filters
	 * @return
	 */
	public String checkAndClause(Map<String, Object> filters) {
		String andCheck = "";
		if (filters != null)
			if (!filters.isEmpty())
				andCheck = " AND ";
		return andCheck;
	}

	public String makeIdsUnionStringFromArray(List<BigDecimal> list) {
		if (list.isEmpty())
			return "(-666)";
		int i = 0;
		String union = "(";
		for (BigDecimal v : list) {
			if (i != 0)
				union += ",";
			i++;
			union += v;
		}
		union += ")";
		return union;
	}
	
	public String makeStringsUnionStringFromArray(ArrayList<String> list) {
	   if (list.isEmpty())
	      return "('-666')";
	   int i = 0;
	   String union = "(";
	   for (String v : list) {
	      if (i != 0)
	         union += ",";
	      i++;
	      union += "'"+v+"'";
	   }
	   union += ")";
	   return union;
	}



	public String getParentPathUnion(String path, String delimiter){

		String union= "(";
		int i = 0;
		if(path!=null && path.length() > 0){
			while(true){
				int endIndex=path.lastIndexOf(delimiter);
				if(endIndex>0){
					if (i != 0)
						union += ",";

					i++;
					String newPath=path.substring(0,endIndex);
					union+="'"+newPath+"'";
					path=path.substring(0, endIndex-1);
				}
				else
				{
					union += ")";
					System.out.println(union);
					return union;
				}

			}
		}

		return "('')";
	}


	public String getAllPathsUnion(String unionpath, String delimiter){

		String union= "(" + "'"+unionpath+"'";
		int i = 0;
		if(unionpath!=null && unionpath.length() > 0){
			while(true){
				int endIndex=unionpath.lastIndexOf(delimiter);
				if(endIndex>0){				 
					union += ",";
					String newPath=unionpath.substring(0,endIndex);
					union+="'"+newPath+"'";
					unionpath=unionpath.substring(0, endIndex-1);
				}
				else
				{
					union += ")";
					System.out.println(union);
					return union;
				}

			}
		}

		return "('')";
	}



}
