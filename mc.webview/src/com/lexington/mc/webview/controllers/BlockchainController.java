package com.lexington.mc.webview.controllers;

import java.math.BigDecimal;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.lexington.mc.model.blockchain.common.BlockchainConstants;
import com.lexington.mc.webview.quartz.schedulers.BlockchainDataScheduler;
import com.lexington.mc.webview.util.BlockchainDataCaller;

@ManagedBean(name="blockchainController", eager=true)
@ApplicationScoped
public class BlockchainController {

	private static boolean busy 			= false;
	private static BigDecimal timeOut	    = new BigDecimal(BlockchainConstants.General.TIMEOUT);
	private static String lastUpdateTime    = "Unknown";

	
	
	public BlockchainController() {
	
		if(!isBusy()) {
			new BlockchainDataScheduler().startScheduledDataProvider(timeOut);
		} 
	}
	
	public void runDataProviderOnDemand() {
	   
	   new BlockchainDataCaller().execute();
	}
	 
	 
	public static boolean isBusy() {
		return busy;
	}

	public static void setBusy(boolean busy) {
		BlockchainController.busy = busy;
	}


	public static BigDecimal getTimeOut() {
		return timeOut;
	}


	public static void setTimeOut(BigDecimal timeOut) {
		BlockchainController.timeOut = timeOut;
	}

   public static String getLastUpdateTime() {
      return lastUpdateTime;
   }

   public static void setLastUpdateTime(String lastUpdateTime) {
      BlockchainController.lastUpdateTime = lastUpdateTime;
   }	
	
}
