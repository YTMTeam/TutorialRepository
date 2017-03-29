package com.lexington.mc.webview.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;

import org.apache.log4j.Logger;

import com.lexington.mc.logic.providers.BlockchainDataProvider;
import com.lexington.mc.logic.util.IDataProviderNotifier;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.blockchain.common.BlockchainConstants;
import com.lexington.mc.webview.controllers.BlockchainController;
import com.mallocinc.shared.util.time.TimestampUtility;

public class BlockchainDataCaller implements  IDataProviderNotifier {

   final static Logger log = Logger.getLogger(BlockchainDataCaller.class.getName());

   public BlockchainDataCaller() {
    dataProvider = new BlockchainDataProvider(this);         
   }
   
    BlockchainDataProvider dataProvider;

    public void execute() {

        if(BlockchainController.isBusy()) {
           FacesUtil.throwMessage("info", FacesMessage.SEVERITY_INFO, "dataProviderBusy");

        //   FacesUtil.throwInfo("dataProviderBusy");
           return;
        }


        try {
        dataProvider.run();
        } catch(MessageException e) {
           FacesUtil.throwMessage(e);
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
         FacesUtil.throwMessage("info", FacesMessage.SEVERITY_INFO, "dataFetchingFinished");
      } 
      
   }

}