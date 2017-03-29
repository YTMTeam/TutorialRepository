package com.lexington.mc.webview.lazytables;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SelectableDataModel;
import org.primefaces.model.SortOrder;

import com.lexington.mc.logic.entities.EntityVMonitoredAccountDeprecated;
import com.lexington.mc.logic.providers.AccountProvider;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.webview.util.DbUtil;
import com.lexington.mc.webview.util.FacesUtil;

public class SelectMonitoredAccountsByStatusLazy extends LazyDataModel<EntityVMonitoredAccountDeprecated>implements SelectableDataModel<EntityVMonitoredAccountDeprecated>{
	 private static final long  serialVersionUID    = -6018436278490045301L;
	   private List<EntityVMonitoredAccountDeprecated>      datasource          = new ArrayList<EntityVMonitoredAccountDeprecated>();
	   private AccountProvider accountProvider= new AccountProvider();
	   private int                tableHeight     = 300;
	   private EntityVMonitoredAccountDeprecated[]          selectedItems;
	   private ArrayList<EntityVMonitoredAccountDeprecated> filteredItems;
	   
	   private BigDecimal bankId;
	   private String status;
	  

	   public SelectMonitoredAccountsByStatusLazy(BigDecimal bankId, String status) {
		   this.bankId = bankId;
		   this.status = status;
	   }

	   @Override
	   public EntityVMonitoredAccountDeprecated getRowData(String rowKey) {
	      for (EntityVMonitoredAccountDeprecated account : datasource) {
	         if (account.getTo().getMONITOR_ID().toString().equals(rowKey))
	            return account;
	      }

	      return null;
	   }

	   @Override
	   public Object getRowKey(EntityVMonitoredAccountDeprecated item) {
	      return item.getTo().getMONITOR_ID();
	   }
	   DbUtil dbUtil = new DbUtil();
	   @Override
	   public List<EntityVMonitoredAccountDeprecated> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		   filters=convertFilters(filters);
			sortField=convertSort(sortField);
		  if(sortField==null){
			  sortField="ACCOUNT_CODE";
//			  sortField="CREATE_TIMESTAMP";
			  sortOrder=SortOrder.ASCENDING;
		  }
	   		  
	      List<EntityVMonitoredAccountDeprecated> result;
	      try {
	    	  
	    	  result = accountProvider.getMonitoredAccountsByStatusForPaging(first, pageSize, sortField, dbUtil.translateSortOrder(sortOrder), filters,bankId, status);
	         
	      } catch (MessageException e) {
	         FacesUtil.throwMessage(e);
	         return null;
	      }
	      try {
	         int rowCnt = (int) accountProvider.getMonitoredAccountsByStatusFilterCount(filters, bankId, status);
	         this.setRowCount(rowCnt);
	      } catch (MessageException e) {
	         FacesUtil.throwMessage(e);
	      }
	      datasource.addAll(result);

	      return result;

	   }

	public int getTableHeight() {
		return tableHeight;
	}

	public void setTableHeight(int tableHeight) {
		this.tableHeight = tableHeight;
	}


	   
	private Map<String, Object> convertFilters(Map<String, Object> filters) {
		 Map<String, Object> dbFilters = new HashMap<String, Object>();
		if(filters!=null){
			Iterator it = filters.entrySet().iterator();
			while (it.hasNext()) {
				
				
				Map.Entry pair = (Map.Entry)it.next();
				dbFilters.put(((String)pair.getKey()).replaceFirst("to.", ""), (String) pair.getValue());
				
				System.out.println("key, value : " +pair.getKey()+ "," +pair.getValue());
	 
			}

		}
		return dbFilters;


	}

	public String convertSort(String sortField) {
		if (sortField != null)
			sortField=sortField.replaceFirst("to.", "");
		return sortField;
	}

	public EntityVMonitoredAccountDeprecated[] getSelectedItems() {
		return selectedItems;
	}

	public void setSelectedItems(EntityVMonitoredAccountDeprecated[] selectedItems) {
		this.selectedItems = selectedItems;
	}

	public ArrayList<EntityVMonitoredAccountDeprecated> getFilteredItems() {
		return filteredItems;
	}

	public void setFilteredItems(ArrayList<EntityVMonitoredAccountDeprecated> filteredItems) {
		this.filteredItems = filteredItems;
	}

 

}
