package com.lexington.mc.webview.controllers.deprecated;
//package com.lexington.mc.webview.controllers;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ViewScoped;
//
//import com.lexington.mc.logic.entities.EntityBlock;
//import com.lexington.mc.logic.entities.EntityVAssetAddressCount;
//import com.lexington.mc.logic.entities.EntityVTransactionBlock;
//import com.lexington.mc.logic.providers.BlockProvider;
//import com.lexington.mc.logic.providers.TransactionProvider;
//import com.lexington.mc.logic.util.MessageException;
//import com.lexington.mc.webview.lazytables.SelectBlocksLazy;
//import com.lexington.mc.webview.lazytables.SelectTxBlockLazy;
//import com.lexington.mc.webview.util.FacesUtil;
//
//@ViewScoped
//@ManagedBean(name="txControl")
//public class TxController {
//	
//	List<EntityVTransactionBlock> lastTxs=new ArrayList<EntityVTransactionBlock>();
//	List<EntityBlock> lastBlocks=new ArrayList<EntityBlock>();
//	
//	SelectTxBlockLazy lazyTxBlocksModel= new SelectTxBlockLazy();
//
//	TransactionProvider transactionProvider= new TransactionProvider();
//	BlockProvider blockProvider= new BlockProvider();
//	public TxController() {
//		updateLastTxs();
//	}
//	
//	
//	
//	public void updateLastTxs() {
//	 
//			
//			System.out.println("Polling");
//			
//			try {
//				 
//				lastTxs=transactionProvider.getNewestTransactions(15);
//				lastBlocks=blockProvider.getLatestBlocks(10);
//			} catch (MessageException e) {
//				FacesUtil.throwMessage(e);
//				return;
//			}
//			
//	 
//		
//	}
//
//
//
//	public SelectTxBlockLazy getLazyTxBlocksModel() {
//		return lazyTxBlocksModel;
//	}
//
//	public void setLazyTxBlocksModel(SelectTxBlockLazy lazyTxBlocksModel) {
//		this.lazyTxBlocksModel = lazyTxBlocksModel;
//	}
//
//
//
//	public List<EntityVTransactionBlock> getLastTxs() {
//		return lastTxs;
//	}
//
//
//
//	public void setLastTxs(List<EntityVTransactionBlock> lastTxs) {
//		this.lastTxs = lastTxs;
//	}
//
//
//
//	public List<EntityBlock> getLastBlocks() {
//		return lastBlocks;
//	}
//
//
//
//	public void setLastBlocks(List<EntityBlock> lastBlocks) {
//		this.lastBlocks = lastBlocks;
//	}
//	
//	
//}
