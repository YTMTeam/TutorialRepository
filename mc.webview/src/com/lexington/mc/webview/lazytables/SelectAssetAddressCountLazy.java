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
//import com.lexington.mc.logic.entities.EntityVAssetAddressCount;
//import com.lexington.mc.logic.providers.AssetProvider;
//import com.lexington.mc.logic.util.MessageException;
//import com.lexington.mc.webview.util.DbUtil;
//import com.lexington.mc.webview.util.FacesUtil;
//import com.mallocinc.database.generated.to.VAssetAddressCountTo;
//
// 
//
//public class SelectAssetAddressCountLazy extends LazyDataModel<EntityVAssetAddressCount>implements SelectableDataModel<EntityVAssetAddressCount>{
//	 private static final long  serialVersionUID    = -6018436278490045301L;
//	   private List<EntityVAssetAddressCount>      datasource          = new ArrayList<EntityVAssetAddressCount>();
//	   private AssetProvider assetProvider= new AssetProvider();
//	   private int                tableHeight     = 300;
//	   private EntityVAssetAddressCount[]          selectedItems;
//	   private ArrayList<EntityVAssetAddressCount> filteredItems;
//	  
//
//	   public SelectAssetAddressCountLazy() {
//
//	   }
//
//	   @Override
//	   public EntityVAssetAddressCount getRowData(String rowKey) {
//	      for (EntityVAssetAddressCount user : datasource) {
//	         if (user.getTo().getASSET_ID().toString().equals(rowKey))
//	            return user;
//	      }
//
//	      return null;
//	   }
//
//	   @Override
//	   public Object getRowKey(EntityVAssetAddressCount item) {
//	      return item.getTo().getASSET_ID();
//	   }
//
//	   @Override
//	   public List<EntityVAssetAddressCount> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
//		   filters=convertFilters(filters);
//			sortField=convertSort(sortField);
//		  
//	      DbUtil dbUtil = new DbUtil();
//	      List<EntityVAssetAddressCount> result;
//	      try {
//	    	  
//	    	  result = assetProvider.getVAssetAddressCountForPaging(first, pageSize, sortField, dbUtil.translateSortOrder(sortOrder), filters
//	              );
//	         
//	      } catch (MessageException e) {
//	         FacesUtil.throwMessage(e);
//	         return null;
//	      }
//	      try {
//	         int rowCnt = (int) assetProvider.getVAssetAddressCountFilterCount(filters);
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
//	public EntityVAssetAddressCount[] getSelectedItems() {
//		return selectedItems;
//	}
//
//	public void setSelectedItems(EntityVAssetAddressCount[] selectedItems) {
//		this.selectedItems = selectedItems;
//	}
//
//	public ArrayList<EntityVAssetAddressCount> getFilteredItems() {
//		return filteredItems;
//	}
//
//	public void setFilteredItems(ArrayList<EntityVAssetAddressCount> filteredItems) {
//		this.filteredItems = filteredItems;
//	}
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
//}
