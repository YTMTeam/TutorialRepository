package com.lexington.mc.webview.util;

import java.util.Enumeration;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class HttpRequestUtil 
{
	public static HttpServletRequest getRequest()
	{
		HttpServletRequest request = 
			(HttpServletRequest)FacesContext
				.getCurrentInstance()
					.getExternalContext()
						.getRequest();
		if (request == null)
		{
			throw new RuntimeException("Sorry. Got a null request from faces context");
		}
		return request;
	}
	public static void setAttribute(String name, Object value)
	{
		HttpServletRequest request = getRequest();
		request.setAttribute(name,value);
	}
	
	public static Object getAttribute(String name)
	{
		HttpServletRequest request = getRequest();
		return request.getAttribute(name);
		
	}
	
	public static String getHostName(){
		return HttpRequestUtil.getRequest().getHeader("Host");	
	}
	
//	public static Object locateObject(String name)
//	{
//		System.out.println("Trying to locate object:" + name);
//		HttpServletRequest request = getRequest();
//		Object o = request.getAttribute(name);
//		if(o != null) return o;
//		
//		HttpSession session = SWJSFSession.getSession();
//		o = session.getAttribute(name);
//		if(o != null) return o;
//
//		FacesContext facescontext = FacesContext.getCurrentInstance();
//		String address = "#{requestScope." + name + "}";
//		System.out.println("Trying to locate object:" + address);
//		
//		o = facescontext.getApplication().createValueBinding(address).getValue(facescontext);
//		if(o != null) return o;
//		
//		return null;
//	}
	
	public static void dumpAttributes()
	{
		HttpServletRequest request = getRequest();
		Enumeration e = request.getAttributeNames();
		while(e.hasMoreElements())
		{
			String name = (String)e.nextElement();
			System.out.println(name);
		}
	}
}
