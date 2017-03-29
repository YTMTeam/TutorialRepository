package com.lexington.mc.webview.controllers;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.poi.hssf.record.formula.functions.T;

import com.lexington.mc.logic.entities.EntityAccountDeprecated;
import com.lexington.mc.logic.entities.EntityVMonitoredAccountDeprecated;
import com.lexington.mc.logic.providers.AccountProvider;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.entities.EntityAccount;
import com.lexington.mc.model.entities.EntityBank;
import com.lexington.mc.model.entities.EntityEmployee;
import com.lexington.mc.model.entities.EntityMonitor;
import com.lexington.mc.model.entities.EntityTrade;
import com.lexington.mc.model.entities.EntityUser;
import com.lexington.mc.model.singletons.datasource.AccountEntityDatasource;
import com.lexington.mc.model.singletons.datasource.BankEntityDatasource;
import com.lexington.mc.model.singletons.datasource.EmployeeEntityDatasource;
import com.lexington.mc.model.singletons.datasource.MonitorEntityDatasource;
import com.lexington.mc.model.singletons.datasource.TradeEntityDatasource;
import com.lexington.mc.model.singletons.datasource.UserEntityDatasource;
import com.lexington.mc.model.util.UtilCodeTypes;
import com.lexington.mc.webview.beans.ManageUser;
import com.lexington.mc.webview.datatable.impl.BankAllMonitoredAccountsDatatable;
import com.lexington.mc.webview.datatable.impl.BankEmployeesDatatable;
import com.lexington.mc.webview.datatable.impl.BankExtActMonitoredAccountsDatatable;
import com.lexington.mc.webview.datatable.impl.BankExtInaMonitoredAccountsDatatable;
import com.lexington.mc.webview.datatable.impl.BankIntActMonitoredAccountsDatatable;
import com.lexington.mc.webview.datatable.impl.BankIntInaMonitoredAccountsDatatable;
import com.lexington.mc.webview.datatable.impl.BankInternalAccountsDatatable;
import com.lexington.mc.webview.lazytables.SelectBankAccountsLazy;
import com.lexington.mc.webview.lazytables.SelectMonitoredAccountsLazy;
import com.lexington.mc.webview.util.FacesUtil;
import com.mallocinc.database.generated.to.AccountTo;
import com.mallocinc.database.generated.to.MonitorTo;
import com.mallocinc.shared.util.time.TimestampUtility;

@ManagedBean(name = "bank")
@ViewScoped
public class BankController {

	/** TABLE DISPLAY **/

	private static final int DISPLAY_ALL_EXT_MONITORED = 0;
	private static final int DISPLAY_ACT_EXT_MONITORED = 1;
	private static final int DISPLAY_INA_EXT_MONITORED = 2;

	private static final int DISPLAY_ALL_INT_ACCOUNTS = 0;
	private static final int DISPLAY_ACT_INT_MONITORED = 1;
	private static final int DISPLAY_INA_INT_MONITORED = 2;

	private static final int DISPLAY_ALL_EMPOYEES = 0;

	/** int values of table **/
	private int curModeInternal = 1;
	private int curModeExternal = 1;

	EntityEmployee selectedEmployee;
	
	BigDecimal[] selectedEmployeesId;
	EntityBank curBank;
	ManageUser user;
	SelectBankAccountsLazy allIntAccountsLazy;
	SelectMonitoredAccountsLazy allExtAccountsLazy;
	private ArrayList<EntityBank> allBanks = BankEntityDatasource.getAll();
	private ArrayList<EntityAccount> allAccounts = AccountEntityDatasource.getAll();
	private ArrayList<EntityTrade> allTrades = TradeEntityDatasource.getAll();
	private ArrayList<EntityEmployee> allEmployee = EmployeeEntityDatasource.getAll();
	private ArrayList<EntityMonitor> allMonitor = MonitorEntityDatasource.getAll();
// 	private BankProvider bankProvider = new BankProvider();
	private EntityAccountDeprecated curAccount;

	/** new datatables used for db-less development **/
	BankEmployeesDatatable employees;
	BankInternalAccountsDatatable allIntAccounts;
	BankExtActMonitoredAccountsDatatable extActiveMonitored;
	BankExtInaMonitoredAccountsDatatable extInactiveMonitored;
	BankAllMonitoredAccountsDatatable extAllMonitored;
	BankIntActMonitoredAccountsDatatable intActiveMonitored;
	BankIntInaMonitoredAccountsDatatable intInactiveMonitored;
	
	
	/**datasources**/
	
	private boolean viewInside = false;
	private boolean viewOutside = false;
	private boolean viewEmployees = true;

	private boolean visible = false;
	private boolean value1;
	
	
	

	
	public BankController() {
		
		user = (ManageUser) FacesUtil.getSessionMapValue("user");
//		allIntAccountsLazy = new SelectBankAccountsLazy(user.getCurUser().getEntityBank().getBank().getBANK_ID());
//		allExtAccountsLazy = new SelectMonitoredAccountsLazy(user.getCurUser().getEntityBank().getBank().getBANK_ID());
		if(user.getCurUser()!=null){
			curBank = BankEntityDatasource.getByBankId(user.getCurUser().getEntityBank().getBank().getBANK_ID());
		}
		allBanks = BankEntityDatasource.getAll();
	    refreshDataSources();
	   
	}

	private void resetSelectModes() {
		curModeInternal = DISPLAY_ACT_INT_MONITORED;
		curModeExternal = DISPLAY_ACT_EXT_MONITORED;

	}

	
	
	public LinkedHashMap<String, BigDecimal> getBankHashMap() {
		LinkedHashMap<String, BigDecimal> bankMap = new LinkedHashMap<String, BigDecimal>();
		for (EntityBank t : allBanks) {
			if (!t.getBank().getBANK_ID().equals(curBank.getBank().getBANK_ID())) {
				bankMap.put(t.getBank().getBANK_NAME(), t.getBank().getBANK_ID());
			}
		}
		return bankMap;
	}

	public ArrayList<EntityBank> getOtherBanks() {
		ArrayList<EntityBank> otherBanks = new ArrayList<>();

		for (EntityBank t : allBanks) {
			if (!t.getBank().getBANK_ID().equals(curBank.getBank().getBANK_ID())) {
				otherBanks.add(t);
			}
		}
		return otherBanks;
	}
	
	
	
	//STATS ACCOUNT TOTAL
	public int getNumberOfAccounts(String bankCode){
		ArrayList<EntityAccount> list = new ArrayList<>();
		for(EntityAccount a : allAccounts ){
			if(!a.getEntityBank().getBank().getBANK_ID().equals(curBank.getBank().getBANK_ID()) && a.getEntityBank().getBank().getBANK_CODE().equals(bankCode)){
				list.add(a);
			}
			
		}
		return list.size();
	}
	//methods for account total
	public int getRBCAccount(){
		return getNumberOfAccounts("RBC");
	}
	public int getTDAccount(){
		return getNumberOfAccounts("TD");
	}
	public int getScotiaAccount(){
		return getNumberOfAccounts("SCOTIA");
	}

	//methods for account daily
	public int getRBCDailyAccount(){
		return getNumberOfDailyAccounts("RBC");
	}
	public int getTDDailyAccount(){
		return getNumberOfDailyAccounts("TD");
	}
	public int getScotiaCDailyAccount(){
		return getNumberOfDailyAccounts("SCOTIA");
	}
	
	//STATS NEW ACCOUNTS DAILY
	public int getNumberOfDailyAccounts(String bankCode){
		ArrayList<EntityAccount> list = new ArrayList<>();
		for(EntityAccount a : allAccounts){
			if(!a.getEntityBank().getBank().getBANK_ID().equals(curBank.getBank().getBANK_ID()) 
					&& a.getEntityBank().getBank().getBANK_CODE().equals(bankCode) && sameDay(a.getAccount().getCREATE_TIMESTAMP())){
				list.add(a);
			}
		}
		return list.size();
	}
	
	public int getRBCDeletedAccounts(){
		return getNumberOfEmployeeWithEndDate("RBC");
	}
	public int getTDDeletedAccounts(){
		return getNumberOfEmployeeWithEndDate("TD");
	}
	public int getScotiaDeletedAccounts(){
		return getNumberOfEmployeeWithEndDate("SCOTIA");
	}
	
	
	//STATS DELETED ACCOUNT WITH END DATE
	public int getNumberOfEmployeeWithEndDate(String bankCode){
		ArrayList<EntityMonitor> list = new ArrayList<>();
		
		for(EntityMonitor a : allMonitor){
			if(!a.getEntityEmployee().getEntityBank().getBank().getBANK_ID().equals(curBank.getBank().getBANK_ID()) 
					&& a.getEntityEmployee().getEntityBank().getBank().getBANK_CODE().equals(bankCode)
					&& a.getMonitor().getEND_DATE()!=null 
					&& a.getMonitor().getEND_DATE().before(a.getMonitor().getCREATE_TIMESTAMP())){
				list.add(a);
			}
		}
		return list.size();
	}
	
		public Boolean validate(final Integer primeNumber) {
		      for (int i = 2; i < (primeNumber / 2); i++) {
		         if (primeNumber % i == 0) {
		            return false;
		         }
		      }
		      return true;
		   }
	
	//STATS DAILY STATS TRADES
	private boolean sameDay(java.sql.Timestamp tradeTime){
		
		 Timestamp ts = new Timestamp(new java.util.Date().getTime());
		 SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		 Date fechDate = new Date(ts.getTime());
		 format.format(fechDate);
	
		
		 Calendar cal1 = Calendar.getInstance();
		 Calendar cal2 = Calendar.getInstance();
		
		 tradeTime = new Timestamp(cal1.getTimeInMillis());
		 cal2.setTime(fechDate);
		 
		 
		 if(cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1.get(Calendar.MONTH)==cal2.get(Calendar.MONTH)
				 && cal1.get(Calendar.DAY_OF_YEAR)==cal2.get(Calendar.DAY_OF_YEAR)){
			 
			 return true;
		 }
		return false;
				
	}
	
	private boolean sameMonth(java.sql.Timestamp tradeTime){
		 Timestamp ts = new Timestamp(new java.util.Date().getTime());
		 SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		 Date fechDate = new Date(ts.getTime());
		 format.format(fechDate);
		 
		 Calendar cal1 = Calendar.getInstance();
		 Calendar cal2 = Calendar.getInstance();
		 
		 tradeTime = new Timestamp(cal1.getTimeInMillis());
		 cal2.setTime(fechDate);
		 
		 if(cal1.get(Calendar.MONTH)==cal2.get(Calendar.MONTH)  && cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)){
			 
			 return true;
		 }
		return false;
	
	}
	//methods for daily trades
	public int getRBCDailyTrades(){
		return getAllTradeDailySize("RBC");
	}
	public int getTDDailyTrades(){
		return getAllTradeDailySize("TD");
	}
	public int getScotiaCDailyTrades(){
		return getAllTradeDailySize("SCOTIA");
	}
	//STATS for Daily Trades
	public int getAllTradeDailySize(String bankCode){
		ArrayList<EntityTrade> list = new ArrayList<>();
		for(EntityTrade t : allTrades ){
			if(!t.getEntityBank().getBank().getBANK_ID().equals(curBank.getBank().getBANK_ID()) && t.getEntityBank().getBank().getBANK_CODE().equals(bankCode) && sameDay(t.getTrade().getCREATE_TIMESTAMP())){
				list.add(t);
			}
		}
		return list.size();
	}
	

	//STATS for Month to day Trades
	public  int getAllTradeMonthtoDaily(String bankCode){
		ArrayList<EntityTrade> list = new ArrayList<>();
		for(EntityTrade t : allTrades ){
			if(!t.getEntityBank().getBank().getBANK_ID().equals(curBank.getBank().getBANK_ID()) && t.getEntityBank().getBank().getBANK_CODE().equals(bankCode) && sameMonth(t.getTrade().getCREATE_TIMESTAMP())){
				list.add(t);
			}
		}
		return list.size();
		}
	
	public int getRBCMonthToDayTrades(){
		return getAllTradeDailySize("RBC");
	}
	public int getTDMonthToDayTrades(){
		return getAllTradeDailySize("TD");
	}
	public int getScotiaMonthToDayTrades(){
		return getAllTradeDailySize("SCOTIA");
	}
	
	
	
	
	
	BigDecimal[] selectedBankIds;

	public void refreshFilters() {
		employees.refreshFilters();

		allIntAccounts.refreshFilters();
		intActiveMonitored.refreshFilters();
		intInactiveMonitored.refreshFilters();

		extActiveMonitored.refreshFilters();
		extInactiveMonitored.refreshFilters();
		extAllMonitored.refreshFilters();

		// if(isActiveExternal() && viewOutside)
		// Ajax.oncomplete("PF('extActVar').clearFilters()");
		// if(isInactiveExternal() && viewOutside)
		// Ajax.oncomplete("PF('extInaVar').clearFilters()");
		// if(isAllExternal() && viewOutside)
		// System.out.println("renderuj all external");
		// Ajax.oncomplete("PF('extAllVar').clearFilters()");
		// if(isActiveInternal() && viewInside)
		// Ajax.oncomplete("PF('intActVar').clearFilters()");
		// if(isInactiveInternal() && viewInside)
		// Ajax.oncomplete("PF('intInaVar').clearFilters()");
		// if(isAllInternal() && viewInside)
		// Ajax.oncomplete("PF('intAllVar').clearFilters()");
		// if(viewEmployees)
		// Ajax.oncomplete("PF('emplTabVar').clearFilters()");

	}

	public void prepareMonitors(EntityAccountDeprecated e) {
		curAccount = e;
		selectedBankIds = new BigDecimal[e.getMonitors().size()];
		int i = 0;

		for (EntityVMonitoredAccountDeprecated b : e.getMonitors())
			selectedBankIds[i++] = b.getTo().getMONITOR_BANK_ID();

	}



	
	public void confirmMonitoring() {
		ArrayList<MonitorTo> toUpdate = new ArrayList<>();

		for (BigDecimal b : selectedBankIds) {
			MonitorTo m = new MonitorTo();
			m.setACCOUNT_ID(curAccount.getTo().getACCOUNT_ID());
			m.setBANK_ID(b);
			m.setAS_OF_DATE(TimestampUtility.getCurrentTimestamp());
			m.setCREATE_TIMESTAMP(TimestampUtility.getCurrentTimestamp());
			toUpdate.add(m);
		}

		try {
			new AccountProvider().updateAccountMonitors(toUpdate, curAccount.getTo().getACCOUNT_ID());
			curAccount.refreshMonitors();
		} catch (MessageException e) {
			FacesUtil.throwMessage(e);
			return;
		}
		refreshDataSources();

	}

	private void refreshDataSources() {

		employees = new BankEmployeesDatatable(curBank);
		allIntAccounts = new BankInternalAccountsDatatable(curBank);
		extActiveMonitored = new BankExtActMonitoredAccountsDatatable(curBank);
		extInactiveMonitored = new BankExtInaMonitoredAccountsDatatable(curBank);
		extAllMonitored = new BankAllMonitoredAccountsDatatable(curBank);
		intActiveMonitored = new BankIntActMonitoredAccountsDatatable(curBank);
		intInactiveMonitored = new BankIntInaMonitoredAccountsDatatable(curBank);

	}

	private void resetFlags() {

		viewInside = false;
		viewOutside = false;
		viewEmployees = false;
		resetSelectModes();
	}

	public void generateEmployees() {
		resetFlags();
		viewEmployees = true;
		refreshFilters();
	}

	public void generateInside() {
		resetFlags();
		viewInside = true;
		refreshFilters();

	}

	public void generateOutside() {

		resetFlags();
		viewOutside = true;
		refreshFilters();
	}

	public boolean isAllInternal() {
		return curModeInternal == DISPLAY_ALL_INT_ACCOUNTS;

	}

	public boolean isActiveInternal() {
		return curModeInternal == DISPLAY_ACT_INT_MONITORED;

	}

	public boolean isInactiveInternal() {
		return curModeInternal == DISPLAY_INA_INT_MONITORED;

	}

	public boolean isAllExternal() {
		return curModeExternal == DISPLAY_ALL_EXT_MONITORED;

	}

	public boolean isActiveExternal() {
		return curModeExternal == DISPLAY_ACT_EXT_MONITORED;

	}

	public boolean isInactiveExternal() {
		return curModeExternal == DISPLAY_INA_EXT_MONITORED;

	}

	public Map<String, Integer> getInternalTablesHash() {

		Map<String, Integer> interHash = new HashMap<String, Integer>();
		interHash.put(FacesUtil.getMessage("permissionedAccounts"), DISPLAY_ACT_INT_MONITORED);
		interHash.put(FacesUtil.getMessage("previouslyPermissionedAccounts"), DISPLAY_INA_INT_MONITORED);
		interHash.put(FacesUtil.getMessage("allAccounts"), DISPLAY_ALL_INT_ACCOUNTS);

		return interHash;

	}

	public Map<String, Integer> getExternalTablesHash() {

		Map<String, Integer> externHash = new HashMap<String, Integer>();
		externHash.put(FacesUtil.getMessage("activeMonitoredAccounts"), DISPLAY_ACT_EXT_MONITORED);
		externHash.put(FacesUtil.getMessage("inactiveMonitoredAccounts"), DISPLAY_INA_EXT_MONITORED);
		externHash.put(FacesUtil.getMessage("everMonitoredAccounts"), DISPLAY_ALL_EXT_MONITORED);

		return externHash;

	}

	public LinkedHashMap<String, String> getEmployeeHashMap() {
		LinkedHashMap<String, String> employeeMap = new LinkedHashMap<String, String>();
		if(this.getEmployees().getDatasource()!=null){
		for (EntityEmployee t : this.getEmployees().getDatasource()) {
			employeeMap.put(t.getEmployee().getFIRST_NAME() + " " + t.getEmployee().getLAST_NAME(), t.getEmployee().getEMPLOYEE_ID()+"");
		}
		}
		return employeeMap;
	}

	
	
	
//	
//	public void getAccountsSize(){
//		curMonitored = 
//	}
//	public void getAllCurrentAccountTotal(){
//		String account_id;
//		int account_number = AccountEntityDatasource.getAccountsSize(account_id);
//		
//	}
	
	
	
	
	
	/**
	 * update monitor inside the db update curMonitored with employee info
	 * 
	 */
	String selectedEmployeeId;
	EntityMonitor curMonitored;

	public void updateMonitorByEmployee() {
	   
	   AccountProvider accountProvider = new AccountProvider();
	   
	   EntityEmployee selectedEmployee = EmployeeEntityDatasource.getEmployeeById(selectedEmployeeId);
	   
		if (selectedEmployee == null) {
			return;
		}
		
		 
//		EntityAccount account = AccountEntityDatasource.getAccountByAccountId(curMonitored.getEntityAccount().getAccount().getACCOUNT_ID());

//		account.setEMPLOYEE_ID(selectedEmployeeId);
		
//		AccountEntityDatasource.updateAccount(account);
	 
		
		curMonitored.setEntityEmployee(selectedEmployee);
		
	}

	public BigDecimal[] getSelectedBankIds() {
		return selectedBankIds;
	}

	public void setSelectedBankIds(BigDecimal[] selectedBankIds) {
		this.selectedBankIds = selectedBankIds;
	}

	public ArrayList<EntityBank> getAllBanks() {
		return allBanks;
	}

	public void setAllBanks(ArrayList<EntityBank> allBanks) {
		this.allBanks = allBanks;
	}

	public EntityBank getCurBank() {
		return curBank;
	}

	public void setCurBank(EntityBank curBank) {
		this.curBank = curBank;
	}

	public boolean isViewInside() {
		return viewInside;
	}

	public boolean isViewOutside() {
		return viewOutside;
	}

	public void setViewInside(boolean viewInside) {
		this.viewInside = viewInside;
	}

	public void setViewOutside(boolean viewOutside) {
		this.viewOutside = viewOutside;
	}

	public int getCurModeInternal() {
		return curModeInternal;
	}

	public int getCurModeExternal() {
		return curModeExternal;
	}

	public EntityAccountDeprecated getCurAccount() {
		return curAccount;
	}

	public BankExtActMonitoredAccountsDatatable getActiveMonitored() {
		return extActiveMonitored;
	}

	public void setCurModeInternal(int curModeInternal) {
		this.curModeInternal = curModeInternal;
	}

	public void setCurModeExternal(int curModeExternal) {
		this.curModeExternal = curModeExternal;
	}

	public void setCurAccount(EntityAccountDeprecated curAccount) {
		this.curAccount = curAccount;
	}

	public BankEmployeesDatatable getEmployees() {
		return employees;
	}

	public void setViewEmployees(boolean viewEmployees) {
		this.viewEmployees = viewEmployees;
	}

	public SelectBankAccountsLazy getAllIntAccountsLazy() {
		return allIntAccountsLazy;
	}

	public SelectMonitoredAccountsLazy getAllExtAccountsLazy() {
		return allExtAccountsLazy;
	}

	public BankInternalAccountsDatatable getAllIntAccounts() {
		return allIntAccounts;
	}

	public BankExtActMonitoredAccountsDatatable getExtActiveMonitored() {
		return extActiveMonitored;
	}

	public BankExtInaMonitoredAccountsDatatable getExtInactiveMonitored() {
		return extInactiveMonitored;
	}

	public void setExtActiveMonitored(BankExtActMonitoredAccountsDatatable extActiveMonitored) {
		this.extActiveMonitored = extActiveMonitored;
	}

	public void setExtInactiveMonitored(BankExtInaMonitoredAccountsDatatable extInactiveMonitored) {
		this.extInactiveMonitored = extInactiveMonitored;
	}

	public BankAllMonitoredAccountsDatatable getExtAllMonitored() {
		return extAllMonitored;
	}

	public void setAllIntAccountsLazy(SelectBankAccountsLazy allIntAccountsLazy) {
		this.allIntAccountsLazy = allIntAccountsLazy;
	}

	public void setAllExtAccountsLazy(SelectMonitoredAccountsLazy allExtAccountsLazy) {
		this.allExtAccountsLazy = allExtAccountsLazy;
	}

	public void setEmployees(BankEmployeesDatatable employees) {
		this.employees = employees;
	}

	public void setAllIntAccounts(BankInternalAccountsDatatable allIntAccounts) {
		this.allIntAccounts = allIntAccounts;
	}

	public void setExtAllMonitored(BankAllMonitoredAccountsDatatable extAllMonitored) {
		this.extAllMonitored = extAllMonitored;
	}

	public boolean isViewEmployees() {
		return viewEmployees;
	}

	public BankIntActMonitoredAccountsDatatable getIntActiveMonitored() {
		return intActiveMonitored;
	}

	public BankIntInaMonitoredAccountsDatatable getIntInactiveMonitored() {
		return intInactiveMonitored;
	}

	public void setIntActiveMonitored(BankIntActMonitoredAccountsDatatable intActiveMonitored) {
		this.intActiveMonitored = intActiveMonitored;
	}

	public void setIntInactiveMonitored(BankIntInaMonitoredAccountsDatatable intInactiveMonitored) {
		this.intInactiveMonitored = intInactiveMonitored;
	}

	public EntityEmployee getSelectedEmployee() {
		return selectedEmployee;
	}

	public void setSelectedEmployee(EntityEmployee selectedEmployee) {
		this.selectedEmployee = selectedEmployee;
	}

	public String getSelectedEmployeeId() {
		return selectedEmployeeId;
	}

	public void setSelectedEmployeeId(String selectedEmployeeId) {
		this.selectedEmployeeId = selectedEmployeeId;
	}

	public EntityMonitor getCurMonitored() {
		return curMonitored;
	}

	public void setCurMonitored(EntityMonitor curMonitored) {
		this.curMonitored = curMonitored;
	}

	public BigDecimal[] getSelectedEmployeesId() {
		return selectedEmployeesId;
	}

	public void setSelectedEmployeesId(BigDecimal[] selectedEmployeesId) {
		this.selectedEmployeesId = selectedEmployeesId;
	}

	public boolean isValue1() {
		return value1;
	}

	public void setValue1(boolean value1) {
		this.value1 = value1;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}



	

	
	
}

