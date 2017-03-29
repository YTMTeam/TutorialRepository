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
import com.lexington.mc.logic.providers.AccountProvider;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.webview.util.DbUtil;
import com.lexington.mc.webview.util.FacesUtil;

public class SelectBankAccountsLazy extends LazyDataModel<EntityAccountDeprecated>implements SelectableDataModel<EntityAccountDeprecated>{
	private static final long  serialVersionUID    = -6018436278490045301L;
	private List<EntityAccountDeprecated>      datasource          = new ArrayList<EntityAccountDeprecated>();
	private AccountProvider accountProvider= new AccountProvider();
	private int                tableHeight     = 300;
	private EntityAccountDeprecated[]          selectedItems;
	private ArrayList<EntityAccountDeprecated> filteredItems;

	private BigDecimal bankId;


	public SelectBankAccountsLazy(BigDecimal bankId) {
		this.bankId = bankId;
		int rowCnt;
		try {
			rowCnt = (int) accountProvider.getAccountsAssignedToBankFilterCount(null, bankId);
		} catch (MessageException e) {
			FacesUtil.throwMessage(e);
			return;
		}
		this.setRowCount(rowCnt);
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
			sortField="TYPE ASC,ACCOUNT_CODE";
			//			  sortField="CREATE_TIMESTAMP";
			sortOrder=SortOrder.ASCENDING;
		}

		List<EntityAccountDeprecated> result = null;
		try {

			result = accountProvider.getAccountsAssignedToBankForPaging(first, pageSize, sortField, dbUtil.translateSortOrder(sortOrder), filters,bankId);


			int rowCnt = (int) accountProvider.getAccountsAssignedToBankFilterCount(filters, bankId);
			this.setRowCount(rowCnt);

			for(EntityAccountDeprecated e: result){
				e.refreshMonitors();
			}
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
