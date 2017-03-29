package com.lexington.mc.webview.datatable.api;

import java.util.ArrayList;
import java.util.List;

import org.primefaces.model.SelectableDataModel;

import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.webview.util.FacesUtil;



public abstract class Datatable<Entity> {
	private ArrayList<Entity> datasource;
	private List<Entity> selectedEntities;
	private List<Entity> filteredEntities;
	
	public abstract void refreshDataSource() throws MessageException; //get the data either from blockchain, from hashmap, or from hibernate 
	
	
	public void refreshFilters(){
		if(datasource!=null)
		filteredEntities=datasource;
	}
	
	public ArrayList<Entity> getDatasource() {
		return datasource;
	}
	public List<Entity> getSelectedEntities() {
		return selectedEntities;
	}
	public List<Entity> getFilteredEntities() {
		return filteredEntities;
	}
	public void setDatasource(ArrayList<Entity> datasource) {
		this.datasource = datasource;
	}
	public void setSelectedEntities(List<Entity> selectedEntities) {
		this.selectedEntities = selectedEntities;
	}
	public void setFilteredEntities(List<Entity> filteredEntities) {
		this.filteredEntities = filteredEntities;
	}
	
	public int getRowCount(){
		return datasource.size();
	}
	
	
}
