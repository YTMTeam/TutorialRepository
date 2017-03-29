package com.lexington.mc.webview.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.lexington.mc.webview.lazytables.SelectBlocksLazy;


@ViewScoped
@ManagedBean(name="blockControl")
public class BlockController {
	
	SelectBlocksLazy lazyBlocksModel= new SelectBlocksLazy();
	
	
	
	
	public SelectBlocksLazy getLazyBlocksModel() {
		return lazyBlocksModel;
	}

	public void setLazyBlocksModel(SelectBlocksLazy lazyBlockModel) {
		this.lazyBlocksModel = lazyBlockModel;
	}
 
	
	
}
