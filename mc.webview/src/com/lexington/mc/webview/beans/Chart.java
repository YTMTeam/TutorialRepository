package com.lexington.mc.webview.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

@ManagedBean(name = "chartDemoView")
public class Chart implements Serializable {
	private LineChartModel lineModel1;
	private LineChartModel lineModel2;
	private LineChartModel zoomModel;

	@PostConstruct
	public void init() {
		createLineModels();
	}

	private void createLineModels() {
		lineModel1 = initLinearModel();
		lineModel1.setTitle("Zoom for Details");
		lineModel1.setZoom(true);
		lineModel1.getAxis(AxisType.Y).setLabel(" ");
		lineModel1.getAxis(AxisType.Y).setMin(0);
	        DateAxis axis = new DateAxis("Dates");
	        axis.setTickAngle(-50);
	        axis.setMax("2017-02-01");
	        axis.setTickFormat("%b %#d, %y");
	        lineModel1.setLegendPosition("e");
	        lineModel1.getAxes().put(AxisType.X, axis);
 	    	lineModel1.setExtender("skinChart");
	    	lineModel1.setShowPointLabels(true);
		/*		lineModel1.setTitle("Linear Chart");
		lineModel1.setLegendPosition("e");
		lineModel1.setAnimate(true);
		lineModel1.setZoom(true);
		Axis yAxis = lineModel1.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(10);
	

		lineModel2 = initCategoryModel();
		lineModel2.setTitle("Category Chart");
		lineModel2.setLegendPosition("e");
		lineModel2.setShowPointLabels(true);
		lineModel2.getAxes().put(AxisType.X, new CategoryAxis("Years"));
		yAxis = lineModel2.getAxis(AxisType.Y);
		yAxis.setLabel("Births");
		yAxis.setMin(0);
		yAxis.setMax(200);

		zoomModel = initLinearModel();
		zoomModel.setTitle("Zoom");
		zoomModel.setZoom(true);
		zoomModel.setLegendPosition("e");
		yAxis = zoomModel.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(10);
		*/
	}

	private LineChartModel initLinearModel() {
		LineChartModel model = new LineChartModel();

		LineChartSeries series1 = new LineChartSeries();
		series1.setLabel("Trades");

		series1.set("2017-01-01", 2);
 
	        series1.set("2017-01-06", 22);
	        series1.set("2017-01-12", 65);
	        series1.set("2017-01-18", 74);
	        series1.set("2017-01-24", 24);
	        series1.set("2017-01-30", 51);
	 
	        LineChartSeries series2 = new LineChartSeries();
	        series2.setLabel("Accounts");
	 
	        series2.set("2017-01-01", 32);
	        series2.set("2017-01-06", 73);
	        series2.set("2017-01-12", 24);
	        series2.set("2017-01-18", 12);
	        series2.set("2017-01-24", 74);
	        series2.set("2017-01-30", 62);
	        LineChartSeries series3= new LineChartSeries();
	        series3.setLabel("Positions");
	   	 
	        series3.set("2017-01-01", 23);
	        series3.set("2017-01-06", 44);
	        series3.set("2017-01-12", 23);
	        series3.set("2017-01-18", 19);
	        series3.set("2017-01-24", 60);
	        series3.set("2017-01-30", 54);
		model.addSeries(series1);
		model.addSeries(series2);
		model.addSeries(series3);

		return model;
	}

	private LineChartModel initCategoryModel() {
		LineChartModel model = new LineChartModel();

		ChartSeries boys = new ChartSeries();
		boys.setLabel("Boys");
		boys.set("2004", 120);
		boys.set("2005", 100);
		boys.set("2006", 44);
		boys.set("2007", 150);
		boys.set("2008", 25);

		ChartSeries girls = new ChartSeries();
		girls.setLabel("Girls");
		girls.set("2004", 52);
		girls.set("2005", 60);
		girls.set("2006", 110);
		girls.set("2007", 90);
		girls.set("2008", 120);

		model.addSeries(boys);
		model.addSeries(girls);

		return model;
	}

	public LineChartModel getLineModel1() {
		return lineModel1;
	}
}
