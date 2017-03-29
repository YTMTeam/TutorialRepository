package com.lexington.mc.webview.controllers;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name="innerTable")
public class ManegedInnerTable {
private ArrayList<ClassA> a;

	
	public ManegedInnerTable(){
		
		a=new ArrayList<>();
		for(int i =0; i<5; i++){
			ClassA aentity=new ClassA();
			a.add(aentity);
		}
		
		
	}
	
	public ArrayList<ClassA> getA() {
		return a;
	}

	public void setA(ArrayList<ClassA> a) {
		this.a = a;
	}
}
