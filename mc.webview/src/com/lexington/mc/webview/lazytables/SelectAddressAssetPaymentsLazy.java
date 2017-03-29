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
import com.lexington.mc.logic.entities.EntityAccountDeprecated;
import com.lexington.mc.logic.providers.TradeProvider;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.webview.util.DbUtil;
import com.lexington.mc.webview.util.FacesUtil;

public class SelectAddressAssetPaymentsLazy  extends LazyDataModel<EntityVPaymentDeprecated>implements SelectableDataModel<EntityVPaymentDeprecated> {
	 private static final long  serialVersionUID    = -6018436278490045301L;
	   private List<EntityVPaymentDeprecated>      datasource          = new ArrayList<EntityVPaymentDeprecated>();
	   private TradeProvider paymentProvider= new TradeProvider();
	   private int                tableHeight     = 300;
	   private EntityVPaymentDeprecated[]          selectedItems;
	   private ArrayList<EntityVPaymentDeprecated> filteredItems;
	  private BigDecimal addressId;
	  private BigDecimal assetId;

	   public SelectAddressAssetPaymentsLazy(BigDecimal addressid, BigDecimal assetId) {
		   this.addressId=addressid;
		   this.setAssetId(assetId);
	   }

	   @Override
	   public EntityVPaymentDeprecated getRowData(String rowKey) {
	      for (EntityVPaymentDeprecated user : datasource) {
	         if (user.getTo().getTRADE_ID().toString().equals(rowKey))
	            return user;
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
			  sortField="PAYMENT_ID DESC, CREATE_TIMESTAMP";
//			  sortField="CREATE_TIMESTAMP";
			  sortOrder=SortOrder.DESCENDING;
		  }
	   
	      List<EntityVPaymentDeprecated> result;
	      try {
	    	  
	    	  result = paymentProvider.getAddressAssetPaymentsForPaging(first, pageSize, sortField, dbUtil.translateSortOrder(sortOrder), filters, addressId,assetId);
	         
	      } catch (MessageException e) {
	         FacesUtil.throwMessage(e);
	         return null;
	      }
	      try {
	         int rowCnt = (int) paymentProvider.getAddressAssetPaymentsFilterCount(filters,addressId,assetId);
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

	public EntityVPaymentDeprecated[] getSelectedItems() {
		return selectedItems;
	}

	public void setSelectedItems(EntityVPaymentDeprecated[] selectedItems) {
		this.selectedItems = selectedItems;
	}

	public ArrayList<EntityVPaymentDeprecated> getFilteredItems() {
		return filteredItems;
	}

	public void setFilteredItems(ArrayList<EntityVPaymentDeprecated> filteredItems) {
		this.filteredItems = filteredItems;
	}

	public BigDecimal getAddressId() {
		return addressId;
	}

	public void setAddressId(BigDecimal addressId) {
		this.addressId = addressId;
	}

	public BigDecimal getAssetId() {
		return assetId;
	}

	public void setAssetId(BigDecimal assetId) {
		this.assetId = assetId;
	}
 
}
