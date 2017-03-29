package com.lexington.mc.webview.lazytables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SelectableDataModel;
import org.primefaces.model.SortOrder;

import com.lexington.mc.logic.entities.EntityBlockDeprecated;
import com.lexington.mc.logic.entities.EntityAccountDeprecated;
import com.lexington.mc.logic.providers.AccountProvider;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.webview.util.DbUtil;
import com.lexington.mc.webview.util.FacesUtil;

public class SelectAddressLazy extends LazyDataModel<EntityAccountDeprecated>implements SelectableDataModel<EntityAccountDeprecated>{
	 private static final long  serialVersionUID    = -6018436278490045301L;
	   private List<EntityAccountDeprecated>      datasource          = new ArrayList<EntityAccountDeprecated>();
	   private AccountProvider addressProvider= new AccountProvider();
	   private int                tableHeight     = 300;
	   private EntityAccountDeprecated[]          selectedItems;
	   private ArrayList<EntityAccountDeprecated> filteredItems;
	  

	   public SelectAddressLazy() {

	   }

	   @Override
	   public EntityAccountDeprecated getRowData(String rowKey) {
	      for (EntityAccountDeprecated user : datasource) {
	         if (user.getTo().getACCOUNT_ID().toString().equals(rowKey))
	            return user;
	      }

	      return null;
	   }

	   @Override
	   public Object getRowKey(EntityAccountDeprecated item) {
	      return item.getTo().getACCOUNT_ID();
	   }
	   DbUtil dbUtil = new DbUtil();
	   @Override
	   public List<EntityAccountDeprecated> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		   filters=convertFilters(filters);
			sortField=convertSort(sortField);
		  if(sortField==null){
			  sortField="TYPE ASC,ACCOUNT_NAME";
//			  sortField="CREATE_TIMESTAMP";
			  sortOrder=SortOrder.ASCENDING;
		  }
	   
	      List<EntityAccountDeprecated> result;
	      try {
	    	  
	    	  result = addressProvider.getAddressesForPaging(first, pageSize, sortField, dbUtil.translateSortOrder(sortOrder), filters);
	         
	      } catch (MessageException e) {
	         FacesUtil.throwMessage(e);
	         return null;
	      }
	      try {
	         int rowCnt = (int) addressProvider.getAddressesFilterCount(filters);
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

	public EntityAccountDeprecated[] getSelectedItems() {
		return selectedItems;
	}

	public void setSelectedItems(EntityAccountDeprecated[] selectedItems) {
		this.selectedItems = selectedItems;
	}

	public ArrayList<EntityAccountDeprecated> getFilteredItems() {
		return filteredItems;
	}

	public void setFilteredItems(ArrayList<EntityAccountDeprecated> filteredItems) {
		this.filteredItems = filteredItems;
	}

 

}
