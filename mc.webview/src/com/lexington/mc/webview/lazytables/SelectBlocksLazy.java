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
import com.lexington.mc.logic.providers.BlockProvider;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.webview.util.DbUtil;
import com.lexington.mc.webview.util.FacesUtil;

 

public class SelectBlocksLazy extends LazyDataModel<EntityBlockDeprecated>implements SelectableDataModel<EntityBlockDeprecated>{
	 private static final long  serialVersionUID    = -6018436278490045301L;
	   private List<EntityBlockDeprecated>      datasource          = new ArrayList<EntityBlockDeprecated>();
	   private BlockProvider blockProvider= new BlockProvider();
	   private int                tableHeight     = 300;
	   private EntityBlockDeprecated[]          selectedItems;
	   private ArrayList<EntityBlockDeprecated> filteredItems;
	  

	   public SelectBlocksLazy() {

	   }

	   @Override
	   public EntityBlockDeprecated getRowData(String rowKey) {
	      for (EntityBlockDeprecated user : datasource) {
	         if (user.getTo().getBLOCK_ID().toString().equals(rowKey))
	            return user;
	      }

	      return null;
	   }

	   @Override
	   public Object getRowKey(EntityBlockDeprecated item) {
	      return item.getTo().getBLOCK_ID();
	   }
	   DbUtil dbUtil = new DbUtil();
	   @Override
	   public List<EntityBlockDeprecated> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		   filters=convertFilters(filters);
			sortField=convertSort(sortField);
		  if(sortField==null){
			  sortField="CREATE_TIMESTAMP";
			  sortOrder=SortOrder.DESCENDING;
		  }
	   
	      List<EntityBlockDeprecated> result;
	      try {
	    	  
	    	  result = blockProvider.getBlocksForPaging(first, pageSize, sortField, dbUtil.translateSortOrder(sortOrder), filters
	              );
	         
	      } catch (MessageException e) {
	         FacesUtil.throwMessage(e);
	         return null;
	      }
	      try {
	         int rowCnt = (int) blockProvider.getBlocksFilterCount(filters);
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

	public EntityBlockDeprecated[] getSelectedItems() {
		return selectedItems;
	}

	public void setSelectedItems(EntityBlockDeprecated[] selectedItems) {
		this.selectedItems = selectedItems;
	}

	public ArrayList<EntityBlockDeprecated> getFilteredItems() {
		return filteredItems;
	}

	public void setFilteredItems(ArrayList<EntityBlockDeprecated> filteredItems) {
		this.filteredItems = filteredItems;
	}
	
	
}
