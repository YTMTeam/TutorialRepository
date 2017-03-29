package com.lexington.mc.webview.controllers.deprecated;
//package com.lexington.mc.webview.controllers;
//
//import java.util.ArrayList;
//import java.util.Collections;
//
//import org.primefaces.model.chart.CartesianChartModel;
//import org.primefaces.model.chart.ChartSeries;
//
//import com.lexington.mc.logic.entities.EntityVAddressAssetBalance;
//import com.lexington.mc.logic.entities.EntityVAddressAssetSubbalance;
//import com.lexington.mc.logic.providers.BalanceProvider;
//import com.lexington.mc.logic.util.MessageException;
//import com.lexington.mc.webview.lazytables.SelectAddressAssetPaymentsLazy;
//import com.lexington.mc.webview.util.FacesUtil;
//import com.lexington.mc.webview.util.TimeUtil;
//
//public class AddressAssetController {
//	
//	EntityVAddressAssetBalance curAddressBalance;
//	ArrayList<EntityVAddressAssetSubbalance> addressSubbalances;
//	//last payments, last transactions, etc.
//	BalanceProvider balanceProvider= new BalanceProvider();
//	
//	SelectAddressAssetPaymentsLazy lazyAddressAssetPayments;
//	
//
//	private CartesianChartModel latestBalances;
//
//	    
//	
//	
//	
//	public AddressAssetController(EntityVAddressAssetBalance entityVAddressAssetBalance) {
//		this.curAddressBalance=entityVAddressAssetBalance;
//		try {
//			addressSubbalances= balanceProvider.getLastAddressAsssetBalances(curAddressBalance.getTo().getADDRESS_ID(), curAddressBalance.getTo().getASSET_ID(), 12);
//			createLatestBalancesModel();
// 			lazyAddressAssetPayments= new SelectAddressAssetPaymentsLazy(curAddressBalance.getTo().getADDRESS_ID(), curAddressBalance.getTo().getASSET_ID());
//		} catch (MessageException e) {
//			FacesUtil.throwMessage(e);
//			return;
//		}
//		
//	}
//
//	 
//    private void createLatestBalancesModel() {  
//        latestBalances = new CartesianChartModel();  
//        Collections.reverse(addressSubbalances);
//        ChartSeries data = new ChartSeries();  
//        data.setLabel("Balances");  
//        TimeUtil timeUtil=new TimeUtil();
//        for(EntityVAddressAssetSubbalance e: addressSubbalances){
//        
//        data.set(e.getTo().getCREATE_TIMESTAMP(), e.getTo().getASSET_BALANCE().doubleValue());  
//       
//        }
//        latestBalances.addSeries(data);  
//
//    }  
//	
//
//    public String getDatatipFormat() {
//  	  return "<span style=\"display:none;\">%s</span><span>%s</span>";
//  	}
//    public String getDatatipFormatBarChart() {
//    	 return "<span>%s</span><span style=\"display:none;\">%s</span>";
//    }
//    
//	public EntityVAddressAssetBalance getCurAddressBalance() {
//		return curAddressBalance;
//	}
//
//
//	public void setCurAddressBalance(EntityVAddressAssetBalance curAddressBalance) {
//		this.curAddressBalance = curAddressBalance;
//	}
//
//
//	public ArrayList<EntityVAddressAssetSubbalance> getAddressSubbalances() {
//		return addressSubbalances;
//	}
//
//
//	public void setAddressSubbalances(ArrayList<EntityVAddressAssetSubbalance> addressSubbalances) {
//		this.addressSubbalances = addressSubbalances;
//	}
//
//
//
//	public CartesianChartModel getLatestBalances() {
//		return latestBalances;
//	}
//
//
//
//	public void setLatestBalances(CartesianChartModel latestBalances) {
//		this.latestBalances = latestBalances;
//	}
//
//
//
//	public SelectAddressAssetPaymentsLazy getLazyAddressAssetPayments() {
//		return lazyAddressAssetPayments;
//	}
//
//
//
//	public void setLazyAddressAssetPayments(SelectAddressAssetPaymentsLazy lazyAddressAssetPayments) {
//		this.lazyAddressAssetPayments = lazyAddressAssetPayments;
//	}
//	
//
//	
// 
//
//
//}
