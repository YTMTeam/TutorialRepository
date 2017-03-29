package com.lexington.mc.webview.beans;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@SessionScoped
@ManagedBean(name = "navigator")
public class ManageNavigation implements Serializable {

   /**
    * Eclipse generated serial ID
    */
   private static final long serialVersionUID = 7723837813321622372L;

   private String outcome;

   public void init() {

      HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
      outcome = request.getRequestURI();

   }

   public void navigate() {
      try {
         FacesContext.getCurrentInstance().getExternalContext().redirect(outcome);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public String getOutcome() {
      return outcome;
   }

   public void setOutcome(String outcome) {
      this.outcome = outcome;
   }
}
