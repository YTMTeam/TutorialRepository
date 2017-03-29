package com.lexington.mc.webview.controllers.deprecated;
//package com.lexington.mc.webview.controllers;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.LinkedHashMap;
//
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ViewScoped;
//
//import org.primefaces.model.chart.CartesianChartModel;
//import org.primefaces.model.chart.ChartSeries;
//
//import com.lexington.mc.logic.entities.EntityVAddressAssetBalance;
//import com.lexington.mc.logic.entities.EntityAccount;
//import com.lexington.mc.logic.providers.AddressProvider;
//import com.lexington.mc.logic.providers.BalanceProvider;
//import com.lexington.mc.logic.util.MessageException;
//import com.lexington.mc.model.util.UtilCodeTypes;
//import com.lexington.mc.webview.lazytables.SelectAddressLazy;
//import com.lexington.mc.webview.util.FacesUtil;
//
//@ViewScoped
//@ManagedBean(name="addrControl")
//public class AddressController {
//	UtilCodeTypes uct = new UtilCodeTypes();
//	SelectAddressLazy lazyAddressesModel = new SelectAddressLazy();
//
//	EntityAccount curAddress;
//	ArrayList<EntityVAddressAssetBalance> allAddressBalances;
//
//	AddressAssetController addressAssetCon;
//	BalanceProvider balanceProvider= new BalanceProvider();
//
//	BigDecimal selectedBalanceId;
//	
//	CartesianChartModel allBalances;
//	EntityAccount bankAddress;
//     
//	AddressProvider addressProvider = new AddressProvider();
//	
//	public AddressController() {
//		try {
//			curAddress=addressProvider.getBank();
//		} catch (MessageException e) {
//		FacesUtil.throwMessage(e);
//		return;
//		}
//		handleAddressSelect();
//		
//	}
//	
////	private void createDummyBalances() {
////		allBalances = new CartesianChartModel();
////	      ChartSeries quantities = new ChartSeries();
////	   
////	    	 quantities.set("DOLLAR", 555);
////	    	 quantities.set("EURO", 123);
////	    	 quantities.set("DINAR", 434);
////	     allBalances.addSeries(quantities);
////		
////	}
//	 
//
//	
//	
//	public void handleAddressSelect(){
//		if(curAddress==null)
//			return;
//		if(curAddress.getTo() == null)
//			return;
//		if(curAddress.getTo().getWALLET_ADDRESS_ID() == null)
//			return;
//		try {
//			allAddressBalances=balanceProvider.getAllAddressBalances(curAddress.getTo().getWALLET_ADDRESS_ID());
//			generateChartBalances();
//		if(!allAddressBalances.isEmpty()){
//			addressAssetCon=new AddressAssetController(allAddressBalances.get(0));
//		selectedBalanceId=allAddressBalances.get(0).getTo().getASSET_ID();
//		}
//		//		balanceProvider.getBalanceByAddressAsset(address_Id, asset_Id);
//		//		balanceProvider.getLastAddressAsssetBalances(address_id, asset_id, 12);
//		
//		
//		} catch (MessageException e) {
//			FacesUtil.throwMessage(e);
//			return;
//		}
//	}
//
//	public void handleCurrencyChange(){
//		for(EntityVAddressAssetBalance e  :allAddressBalances){
//			
//			if(e.getTo().getASSET_ID().equals(selectedBalanceId)){
//				addressAssetCon=new AddressAssetController(e);
//				return;
//			}
//		}
//		
//		
//	}
//	
//public LinkedHashMap<String, BigDecimal> getBalancesMap(){
//	
//	  LinkedHashMap<String, BigDecimal>       balancesMap = new LinkedHashMap<String, BigDecimal>();	
//	  if (allAddressBalances==null) return balancesMap;
//	  for(EntityVAddressAssetBalance e: allAddressBalances) 
//		  balancesMap.put(e.getTo().getASSET_NAME() + " " + e.getTo().getASSET_BALANCE() , e.getTo().getASSET_ID());
//	  return balancesMap;
//}
//
//	private void generateChartBalances() {
//		allBalances = new CartesianChartModel();
//	      ChartSeries quantities = new ChartSeries();
//	     for(EntityVAddressAssetBalance e: allAddressBalances)
//	    	 quantities.set(e.getTo().getASSET_NAME(), e.getTo().getASSET_BALANCE());
//	     allBalances.addSeries(quantities);
//	       
//		
//	}
//	public boolean isCurAddress(String addressName){
//		return getCurAddress().getTo().getADDRESS_NAME().equals(addressName);
//		
//		
//	}
//public boolean isShowAddressBalances(){
//	
//	if(allAddressBalances==null)
//		return false;
//	return !allAddressBalances.isEmpty();
//}
//
//
//	public SelectAddressLazy getLazyAddressesModel() {
//		return lazyAddressesModel;
//	}
//	public void setLazyAddressesModel(SelectAddressLazy lazyAddressesModel) {
//		this.lazyAddressesModel = lazyAddressesModel;
//	}
//	public EntityAccount getCurAddress() {
//		return curAddress;
//	}
//	public void setCurAddress(EntityAccount curAddress) {
//		this.curAddress = curAddress;
//	}
//
//
//
//	public ArrayList<EntityVAddressAssetBalance> getAllAddressBalances() {
//		return allAddressBalances;
//	}
//
//
//
//	public void setAllAddressBalances(ArrayList<EntityVAddressAssetBalance> allAddressBalances) {
//		this.allAddressBalances = allAddressBalances;
//	}
//
//
//
//	public AddressAssetController getAddressAssetCon() {
//		return addressAssetCon;
//	}
//
//
//
//	public void setAddressAssetCon(AddressAssetController addressAssetCon) {
//		this.addressAssetCon = addressAssetCon;
//	}
//
//
//
//	public CartesianChartModel getAllBalances() {
//		return allBalances;
//	}
//
//
//
//	public void setAllBalances(CartesianChartModel allBalances) {
//		this.allBalances = allBalances;
//	}
//
//	public BigDecimal getSelectedBalanceId() {
//		return selectedBalanceId;
//	}
//
//	public void setSelectedBalanceId(BigDecimal selectedBalanceId) {
//		this.selectedBalanceId = selectedBalanceId;
//	}
// 
//
//
//
//
//}
