package com.lexington.mc.webview.quartz.jobs;


import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.lexington.mc.logic.providers.BlockchainDataProvider;
import com.lexington.mc.logic.util.IDataProviderNotifier;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.blockchain.common.BlockchainConstants;
import com.lexington.mc.webview.controllers.BlockchainController;
import com.lexington.mc.webview.util.FacesUtil;
import com.mallocinc.shared.util.time.TimestampUtility;

public class BlockchainJob implements Job, IDataProviderNotifier {

   final static Logger log = Logger.getLogger(BlockchainJob.class.getName());

   public BlockchainJob() {
    dataProvider = new BlockchainDataProvider(this);         
   }
   
	BlockchainDataProvider dataProvider;

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {

       if(BlockchainController.isBusy()) {
          FacesUtil.throwMessage("info", FacesMessage.SEVERITY_INFO, "dataProviderBusy");

       //   FacesUtil.throwInfo("dataProviderBusy");
          return;
       }


		try {
		dataProvider.run();
		} catch(MessageException e) {
			 FacesContext.getCurrentInstance().addMessage(null,
			            new FacesMessage(FacesMessage.SEVERITY_WARN,
			                            "Data provider is busy",
			                            "Data provider is busy"));
		}
	}

   @Override
   public void setStatus(String status) {
      if(status.equals(BlockchainConstants.DataProviderStatus.BUSY)) {
         BlockchainController.setBusy(true);
      } 
      if(status.equals(BlockchainConstants.DataProviderStatus.FINISHED)) {
         BlockchainController.setBusy(false);
         BlockchainController.setLastUpdateTime(TimestampUtility.getCurrentTimestampString());
      } 
      
   }

}
