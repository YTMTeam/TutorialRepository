package com.lexington.mc.webview.filters;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lexington.mc.webview.beans.ManageUser;

 

@WebFilter("/pages/*")
public class LoginFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		ManageUser manageUser = (ManageUser) req.getSession().getAttribute("user");
		StringBuffer originalUrl = req.getRequestURL();
		 
	if(manageUser!=null)
		 manageUser.setRedirectedFromFilter(false);



		if(req.getQueryString()!=null){
			if(req.getQueryString().length() >= 0)
			{
				originalUrl.append('?').append(req.getQueryString()).append("&faces-redirect=true");
			}else
				originalUrl.append("?faces-redirect=true");
		}
		else
			originalUrl.append("?faces-redirect=true");



		if (manageUser == null || !manageUser.isLoggedIn()) {
			if(manageUser!=null){
				manageUser.setOriginalUrl(originalUrl);
			}

			res.sendRedirect(req.getContextPath() + "/login.xhtml");
		} else {
		 
//				if(!originalUrl.toString().contains("/pages/subscription.xhtml") && !originalUrl.toString().contains("/pages/profile.xhtml") && !originalUrl.toString().contains("/pages/take_quiz.xhtml") && !originalUrl.toString().contains("/pages/personal_report.xhtml")){
//				 if(manageUser.isPayDueDatePassed()){
//					 manageUser.setRedirectedFromFilter(true);
//					 res.sendRedirect(req.getContextPath() + "/pages/subscription.xhtml?faces-redirect=true");  
//				 }
//				}
			 
					//the ones that are logged in and trying to approach to host address only
					if(!originalUrl.toString().contains("/pages/")){
					manageUser.setRedirectedFromFilter(true);
						res.sendRedirect(req.getContextPath() + "/pages/index.xhtml?faces-redirect=true"); 

					}
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	// You need to override init() and destroy() as well, but they can be kept empty.
}
