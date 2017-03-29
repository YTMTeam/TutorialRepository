//package com.lexington.mc.webview.lazytables;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//import org.primefaces.model.LazyDataModel;
//import org.primefaces.model.SelectableDataModel;
//import org.primefaces.model.SortOrder;
//
//import com.lexington.mc.logic.entities.EntityBlock;
//import com.lexington.mc.logic.entities.EntityVTransactionBlock;
//import com.lexington.mc.logic.providers.BlockProvider;
//import com.lexington.mc.logic.providers.TransactionProvider;
//import com.lexington.mc.logic.util.MessageException;
//import com.lexington.mc.webview.util.DbUtil;
//import com.lexington.mc.webview.util.FacesUtil;
//
//public class SelectTxBlockLazy extends LazyDataModel<EntityVTransactionBlock>implements SelectableDataModel<EntityVTransactionBlock>{
//	 private static final long  serialVersionUID    = -6018436278490045301L;
//	   private List<EntityVTransactionBlock>      datasource          = new ArrayList<EntityVTransactionBlock>();
//	   private TransactionProvider txProvider= new TransactionProvider();
//	   private int                tableHeight     = 300;
//	   private EntityVTransactionBlock[]          selectedItems;
//	   private ArrayList<EntityVTransactionBlock> filteredItems;
//	  
//
//	   public SelectTxBlockLazy() {
//
//	   }
//
//	   @Override
//	   public EntityVTransactionBlock getRowData(String rowKey) {
//	      for (EntityVTransactionBlock user : datasource) {
//	         if (user.getTo().getTRANSACTION_ID().toString().equals(rowKey))
//	            return user;
//	      }
//
//	      return null;
//	   }
//
//	   @Override
//	   public Object getRowKey(EntityVTransactionBlock item) {
//	      return item.getTo().getTRANSACTION_ID();
//	   }
//	   DbUtil dbUtil = new DbUtil();
//	   @Override
//	   public List<EntityVTransactionBlock> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
//		   filters=convertFilters(filters);
//			sortField=convertSort(sortField);
//		  if(sortField==null){
//			  sortField="CREATE_TIMESTAMP";
//			  sortOrder=SortOrder.DESCENDING;
//		  }
//	   
//	      List<EntityVTransactionBlock> result;
//	      try {
//	    	  
//	    	  result = txProvider.getTxBlocksForPaging(first, pageSize, sortField, dbUtil.translateSortOrder(sortOrder), filters
//	              );
//	         
//	      } catch (MessageException e) {
//	         FacesUtil.throwMessage(e);
//	         return null;
//	      }
//	      try {
//	         int rowCnt = (int) txProvider.getTxBlocksFilterCount(filters);
//	         this.setRowCount(rowCnt);
//	      } catch (MessageException e) {
//	         FacesUtil.throwMessage(e);
//	      }
//	      datasource.addAll(result);
//
//	      return result;
//
//	   }
//
//	public int getTableHeight() {
//		return tableHeight;
//	}
//
//	public void setTableHeight(int tableHeight) {
//		this.tableHeight = tableHeight;
//	}
//
//
//	   
//	private Map<String, Object> convertFilters(Map<String, Object> filters) {
//		 Map<String, Object> dbFilters = new HashMap<String, Object>();
//		if(filters!=null){
//			Iterator it = filters.entrySet().iterator();
//			while (it.hasNext()) {
//				
//				
//				Map.Entry pair = (Map.Entry)it.next();
//				dbFilters.put(((String)pair.getKey()).replaceFirst("to.", ""), (String) pair.getValue());
//				
//				System.out.println("key, value : " +pair.getKey()+ "," +pair.getValue());
//	 
//			}
//
//		}
//		return dbFilters;
//
//
//	}
//
//	public String convertSort(String sortField) {
//		if (sortField != null)
//			sortField=sortField.replaceFirst("to.", "");
//		return sortField;
//	}
//
//	public EntityVTransactionBlock[] getSelectedItems() {
//		return selectedItems;
//	}
//
//	public void setSelectedItems(EntityVTransactionBlock[] selectedItems) {
//		this.selectedItems = selectedItems;
//	}
//
//	public ArrayList<EntityVTransactionBlock> getFilteredItems() {
//		return filteredItems;
//	}
//
//	public void setFilteredItems(ArrayList<EntityVTransactionBlock> filteredItems) {
//		this.filteredItems = filteredItems;
//	}
//
// 
//}
