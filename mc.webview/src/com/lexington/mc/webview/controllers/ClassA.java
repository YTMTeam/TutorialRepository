package com.lexington.mc.webview.controllers;

import java.math.BigDecimal;

import com.mallocinc.shared.util.time.TimestampUtility;

public class ClassA {
	private String someString;
	private BigDecimal someId;
	private ClassB b;
	
	public ClassA() {
		someString=TimestampUtility.getCurrentTimestamp()+"A";
		someId=new BigDecimal(Math.random());
		b=new ClassB();
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
	public ClassB getB() {
		return b;
	}
	public void setB(ClassB b) {
		this.b = b;
	}
}
