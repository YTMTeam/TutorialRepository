package com.lexington.mc.webview.controllers;

import java.math.BigDecimal;

import com.mallocinc.shared.util.time.TimestampUtility;

public class ClassB {
	private String someString;
	private BigDecimal someId;
	
	public ClassB () {
		someString=TimestampUtility.getCurrentTimestamp()+"B";
		someId=new BigDecimal(Math.random());
		
		
	}
	
	
	public String getSomeString() {
		return someString;
	}
	public void setSomeString(String someString) {
		this.someString = someString;
	}
	public BigDecimal getSomeId() {
		return someId;
	}
	public void setSomeId(BigDecimal someId) {
		this.someId = someId;
	}
}
