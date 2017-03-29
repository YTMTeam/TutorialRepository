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

import com.lexington.mc.logic.entities.EntityVPaymentDeprecated;
import com.lexington.mc.logic.providers.TradeProvider;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.blockchain.common.BlockchainConstants;
import com.lexington.mc.webview.util.DbUtil;
import com.lexington.mc.webview.util.FacesUtil;

public class SelectGroupTradesLazy extends LazyDataModel<EntityVPaymentDeprecated>implements SelectableDataModel<EntityVPaymentDeprecated>{
	 public List<EntityVPaymentDeprecated> getDatasource() {
		return datasource;
	}

	public void setDatasource(List<EntityVPaymentDeprecated> datasource) {
		this.datasource = datasource;
	}
	private static final long  serialVersionUID    = -6018436278490045301L;
	   private List<EntityVPaymentDeprecated>      datasource          = new ArrayList<EntityVPaymentDeprecated>();
	   private TradeProvider paymentProvider= new TradeProvider();
	   private int                tableHeight     = 300;
	   private EntityVPaymentDeprecated       selectedItem;
	   private ArrayList<EntityVPaymentDeprecated> filteredItems;
	   
	   private BigDecimal groupId;
	   private int rowCntSell=0;
		  private int rowCntBuy=0;

	   public SelectGroupTradesLazy(BigDecimal groupId) {
		   this.groupId = groupId;
	   }

	   @Override
	   public EntityVPaymentDeprecated getRowData(String rowKey) {
	      for (EntityVPaymentDeprecated payment : datasource) {
	         if (payment.getTo().getTRADE_ID().toString().equals(rowKey))
	            return payment;
	      }

	      return null;
	   }

	   @Override
	   public Object getRowKey(EntityVPaymentDeprecated item) {
	      return item.getTo().getTRADE_ID();
	   }
	   DbUtil dbUtil = new DbUtil();
	   @Override
	   public List<EntityVPaymentDeprecated> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		   filters=convertFilters(filters);
			sortField=convertSort(sortField);
		  if(sortField==null){
			  sortField="CREATE_TIMESTAMP";
			  sortOrder=SortOrder.DESCENDING;
		  }
	   
	      List<EntityVPaymentDeprecated> result;
	      try {
	    	  
	    	  result = paymentProvider.getGroupPaymentsForPaging(first, pageSize, sortField, dbUtil.translateSortOrder(sortOrder), filters , groupId);
	         
	      } catch (MessageException e) {
	         FacesUtil.throwMessage(e);
	         return null;
	      }
	      try {
	         int rowCnt = (int) paymentProvider.getGroupPaymentsFilterCount(filters, groupId);
	         filters.put("DIRECTION", BlockchainConstants.DirectionStatus.SELL);
	         rowCntSell = (int) paymentProvider.getGroupPaymentsFilterCount(filters, groupId);
	            rowCntBuy=rowCnt - rowCntSell;
	            filters.remove("DIRECTION");
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



	public EntityVPaymentDeprecated getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(EntityVPaymentDeprecated selectedItem) {
		this.selectedItem = selectedItem;
	}

	public ArrayList<EntityVPaymentDeprecated> getFilteredItems() {
		return filteredItems;
	}

	public void setFilteredItems(ArrayList<EntityVPaymentDeprecated> filteredItems) {
		this.filteredItems = filteredItems;
	}

	public int getRowCntSell() {
		return rowCntSell;
	}

	public void setRowCntSell(int rowCntSell) {
		this.rowCntSell = rowCntSell;
	}

	public int getRowCntBuy() {
		return rowCntBuy;
	}

	public void setRowCntBuy(int rowCntBuy) {
		this.rowCntBuy = rowCntBuy;
	}

 
}
