package com.lexington.mc.webview.beans;

import java.awt.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
//temporary bean for line Graph
@RequestScoped
@ManagedBean(name = "chartBean")
public class Bean {
	
    private CartesianChartModel categoryModel;

    public Bean() {  
        createCategoryModel(); 
    }  

    private void createCategoryModel() {  
        categoryModel = new CartesianChartModel();  

        ChartSeries data = new ChartSeries();  
        data.setLabel("Boys");  
        
        data.set("jan", 0);  
        data.set("feb", 8);  
        data.set("mar", 5);  
        data.set("apr", 8);  
        data.set("may", 11);  
        data.set("jun", 14); 
        data.set("jul", 6); 
        data.set("aug", 8); 
        data.set("sep", 5);
        data.set("oct", 9); 
        data.set("nov", 16);
        data.set("dec", 11); 

        categoryModel.addSeries(data);  

    }  

    public String getDatatipFormat() {
    	  return "<span style=\"display:none;\">%s</span><span>%s</span>";
    	}
    public CartesianChartModel getCategoryModel() {
        return categoryModel;
    }
}