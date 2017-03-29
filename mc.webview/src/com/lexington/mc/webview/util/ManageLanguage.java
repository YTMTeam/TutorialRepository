package com.lexington.mc.webview.util;

import java.io.Serializable;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "language")
@SessionScoped
public class ManageLanguage implements Serializable {
   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   private Locale            localeCode       = FacesContext.getCurrentInstance().getApplication().getDefaultLocale();;
   private boolean           croatian         = false;
 
   public String serbianAction() {
      croatian = false;
      FacesContext context = FacesContext.getCurrentInstance();
      context.getViewRoot().setLocale(new Locale("sr"));
      setLocaleCode(context.getViewRoot().getLocale());
      return "";
   }

   public String englishAction() {
//	 log.info("INFO: changing language to english..");
      croatian = false;
      FacesContext context = FacesContext.getCurrentInstance();
      context.getViewRoot().setLocale(Locale.ENGLISH);
      setLocaleCode(context.getViewRoot().getLocale());
      return "";
   }

   public String croatianAction() {
//	   log.info("INFO: changing language to croatian..");
      croatian = true;
      FacesContext context = FacesContext.getCurrentInstance();
      context.getViewRoot().setLocale(new Locale("sr"));
      setLocaleCode(context.getViewRoot().getLocale());
      return "";
   }

   public static String getLocal() {
      //	   if(FacesContext.getCurrentInstance().getViewRoot().getLocale().toString().toUpperCase().equals("HR"))
      //		   return "sr";
      return FacesContext.getCurrentInstance().getViewRoot().getLocale().toString();

   }

   public Locale getLocaleCodeForFlag() {
      if (croatian)
         return new Locale("hr");
      else
         return localeCode;
   }

   public Locale getLocaleCode() {
      //	   if(FacesContext.getCurrentInstance().getViewRoot().getLocale().toString().toUpperCase().equals("HR"))
      //		   return new Locale("sr");
      return localeCode;
   }

   public void setLocaleCode(Locale localCode) {
      this.localeCode = localCode;
   }

}
