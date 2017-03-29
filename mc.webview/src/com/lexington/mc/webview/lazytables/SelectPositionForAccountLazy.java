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

import com.lexington.mc.logic.entities.EntityAccountDeprecated;
import com.lexington.mc.logic.entities.EntityPositionDeprecated;
import com.lexington.mc.logic.entities.EntityVPaymentDeprecated;
import com.lexington.mc.logic.providers.PositionProvider;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.webview.util.DbUtil;
import com.lexington.mc.webview.util.FacesUtil;

public class SelectPositionForAccountLazy extends LazyDataModel<EntityPositionDeprecated>implements SelectableDataModel<EntityPositionDeprecated>{
	 private static final long  serialVersionUID    = -6018436278490045301L;
	   private List<EntityPositionDeprecated>      datasource          = new ArrayList<EntityPositionDeprecated>();
	   private PositionProvider positionProvider = new PositionProvider();
	   private int                tableHeight     = 300;
	   private EntityPositionDeprecated[]          selectedItems;
	   private ArrayList<EntityPositionDeprecated> filteredItems;
	   private EntityPositionDeprecated        selectedItem;
	   private String accountId;
	  

	   public SelectPositionForAccountLazy(String accountId) {
		   this.accountId = accountId;
	   }

	   @Override
	   public EntityPositionDeprecated getRowData(String rowKey) {
	      for (EntityPositionDeprecated position : datasource) {
	         if (position.getTo().getPOSITION_ID().toString().equals(rowKey))
	            return position;
	      }

	      return null;
	   }

	   @Override
	   public Object getRowKey(EntityPositionDeprecated item) {
	      return item.getTo().getPOSITION_ID();
	   }
	   DbUtil dbUtil = new DbUtil();
	   @Override
	   public List<EntityPositionDeprecated> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		   filters=convertFilters(filters);
			sortField=convertSort(sortField);
		  if(sortField==null){
			  sortField="EQUITY_NAME";
//			  sortField="CREATE_TIMESTAMP";
			  sortOrder=SortOrder.ASCENDING;
		  }
	   		  
	      List<EntityPositionDeprecated> result;
	      try {
	    	  
	    	  result = positionProvider.getPositionFromAccountForPaging(first, pageSize, sortField, dbUtil.translateSortOrder(sortOrder), filters,accountId);
	         
	      } catch (MessageException e) {
	         FacesUtil.throwMessage(e);
	         return null;
	      }
	      try {
	         int rowCnt = (int) positionProvider.getPositionFromAccountFilterCount(filters, accountId);
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

	public EntityPositionDeprecated[] getSelectedItems() {
		return selectedItems;
	}

	public void setSelectedItems(EntityPositionDeprecated[] selectedItems) {
		this.selectedItems = selectedItems;
	}

	public ArrayList<EntityPositionDeprecated> getFilteredItems() {
		return filteredItems;
	}

	public void setFilteredItems(ArrayList<EntityPositionDeprecated> filteredItems) {
		this.filteredItems = filteredItems;
	}

	public EntityPositionDeprecated getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(EntityPositionDeprecated selectedItem) {
		this.selectedItem = selectedItem;
	}

 

}
