//package com.lexington.mc.webview.controllers;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ViewScoped;
//
//import com.lexington.mc.logic.entities.EntityReadBlockInfo;
//import com.lexington.mc.logic.entities.EntityVAssetAddressCount;
//import com.lexington.mc.logic.providers.AssetProvider;
//import com.lexington.mc.logic.providers.ReadBlockInfoProvider;
//import com.lexington.mc.logic.util.MessageException;
//import com.lexington.mc.webview.lazytables.SelectAssetAddressCountLazy;
//import com.lexington.mc.webview.util.FacesUtil;
//
//@ViewScoped
//@ManagedBean(name="assetControl")
//public class AssetController {
//	private AssetProvider assetProvider= new AssetProvider();
//	private ReadBlockInfoProvider readBlockInfoProvider=new ReadBlockInfoProvider();
//	private SelectAssetAddressCountLazy lazyAssetsModel=new SelectAssetAddressCountLazy();
//	private EntityReadBlockInfo latestBlockInfo;
//	private List<EntityVAssetAddressCount> lastAssets=new ArrayList<EntityVAssetAddressCount>();
//	
//	
//	public AssetController() {
//		updateLastAssets();
//	}
//	
//	public SelectAssetAddressCountLazy getLazyAssetsModel() {
//		return lazyAssetsModel;
//	}
//
//	public void setLazyAssetsModel(SelectAssetAddressCountLazy lazyAssetsModel) {
//		this.lazyAssetsModel = lazyAssetsModel;
//	}
//
//	public List<EntityVAssetAddressCount> getLastAssets() {
//		return lastAssets;
//	}
//
//	public void setLastAssets(List<EntityVAssetAddressCount> lastAssets) {
//		this.lastAssets = lastAssets;
//	}
//
//
//	public EntityReadBlockInfo getLatestBlockInfo() {
//		return latestBlockInfo;
//	}
//
//	public void setLatestBlockInfo(EntityReadBlockInfo latestBlockInfo) {
//		this.latestBlockInfo = latestBlockInfo;
//	}
//	
//
//	public void updateLastAssets(){
//		
//		System.out.println("Polling");
//		
//		try {
//			lastAssets=assetProvider.getNewestAssets(15);
//			latestBlockInfo=readBlockInfoProvider.getNewestBlockInfo();
//		} catch (MessageException e) {
//			FacesUtil.throwMessage(e);
//			return;
//		}
//		
//	}
//
//	public ReadBlockInfoProvider getReadBlockInfoProvider() {
//		return readBlockInfoProvider;
//	}
//
//	public void setReadBlockInfoProvider(ReadBlockInfoProvider readBlockInfoProvider) {
//		this.readBlockInfoProvider = readBlockInfoProvider;
//	}
//	
//	
//}
