package com.lexington.mc.webview.beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import com.lexington.mc.logic.providers.AccountProvider;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.util.UtilCodeTypes;
import com.lexington.mc.model.util.UtilPermissions;
import com.lexington.mc.model.util.UtilPermissions.CourseGroup;
import com.lexington.mc.model.util.UtilPermissions.GradingsGroup;
import com.lexington.mc.model.util.UtilPermissions.PoolsGroup;
import com.lexington.mc.model.util.UtilPermissions.QuizzesGroup;
import com.lexington.mc.model.util.UtilPermissions.UserGroup;
import com.lexington.mc.webview.util.FacesUtil;
import com.mallocinc.database.generated.to.AccountTo;

@SessionScoped
@ManagedBean(name = "globalSearch")
public class ManageGlobalSearch {

	private AccountTo        curSearch    = null;
	 
	AccountProvider            addressProvider           = new AccountProvider();
	 

	UtilCodeTypes uct = new UtilCodeTypes();

	private int minQueryLength = 1;
	private int queryDelay     = 1000;

	 
	ManageUser parentUser;
	
	
	 

	public ManageGlobalSearch() {
		
		 
	}

	
	List<AccountTo> results;
 
	public List<AccountTo> completeUsers(String query) {
		HashMap<String, Object> filters = new HashMap<String, Object>();
//		filters.put("STREET", query);
		filters.put("FIRST_NAME", query);
//		filters.put("LAST_NAME", query);
//		filters.put("CITY", query);
//		filters.put("BANK_NAME", query);
	 results = null;
		try {
			results = addressProvider.getUserWalletAddressesForSearch(0, 3, "FIRST_NAME", "ASC", filters);
		} catch (MessageException e) {
			FacesUtil.throwMessage(e);
		}
		return results;
	}

	public AccountTo getCurSearch() {
		return curSearch;
	}

	public void setCurSearch(AccountTo curSearch) {
		this.curSearch = curSearch;
	}

	public int getMinQueryLength() {
		return minQueryLength;
	}

	public void setMinQueryLength(int minQueryLength) {
		this.minQueryLength = minQueryLength;
	}

	public int getQueryDelay() {
		return queryDelay;
	}

	public void setQueryDelay(int queryDelay) {
		this.queryDelay = queryDelay;
	}

	public List<AccountTo> getResults() {
		return results;
	}

	public void setResults(List<AccountTo> results) {
		this.results = results;
	}

	 




}
