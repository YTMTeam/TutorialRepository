package com.lexington.mc.webview.util;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.lexington.mc.logic.util.MessageException;

public class FacesUtil {

	
	public static final int SYSTEM_BUNDLE=0;
	public static final int MESSAGE_BUNDLE=1;
	
   public static FacesMessage.Severity[] Severity = new FacesMessage.Severity[] {
                                                                                  FacesMessage.SEVERITY_ERROR,
                                                                                  FacesMessage.SEVERITY_FATAL,
                                                                                  FacesMessage.SEVERITY_INFO,
                                                                                  FacesMessage.SEVERITY_WARN };

   public static Object getSessionMapValue(String key) {
      return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(key);
   }

   public static void setSessionMapValue(String key, Object value) {
      FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(key, value);
   }

   public static Object removeSessionMapValue(String key) {
      return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(key);
   }

   public static String getMessage(String msg) {
      String locale = ManageLanguage.getLocal();
      return ResourceBundle.getBundle("com.lexington.mc.model.properties.messages" + "_" + locale).getString(msg);

   }

   /*examples
    * ERROR: FacesUtil.throwMessage("error", FacesMessage.SEVERITY_ERROR, "wrongLogin");
    * WARNING: FacesUtil.throwMessage("warning", FacesMessage.SEVERITY_WARN, "bblabla form messages.properties");
    * INFORMATION: FacesUtil.throwMessage("information", FacesMessage.SEVERITY_INFO, "bblabla form messages.properties");
    */
   public static void throwMessage(String subject, FacesMessage.Severity severity, String text) {
      String local = ManageLanguage.getLocal();
      FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(severity,
                             ResourceBundle.getBundle("com.lexington.mc.model.properties.messages" + "_" + local)
                                   .getString(subject),
                             ResourceBundle.getBundle("com.lexington.mc.model.properties.messages" + "_" + local)
                                   .getString(text)));
   }
   
   
 
   public static FacesMessage getFacesMessageFromMessage(MessageException ex){
	   if(ex.getArgs()==null){
		   return getFacesMessageWithoutParameters(ex.getSubject(), FacesUtil.Severity[ex.getSeverity()], ex.getMessage());
	   }
	   else
		  return getMessageWithParameters(ex.getSubject(), FacesUtil.Severity[ex.getSeverity()], ex.getMessage(),ex.getArgs());
 
	   
   }
   
   

   public static FacesMessage getMessageWithParameters(String subject, FacesMessage.Severity warning, String formatKey, Object... args) {
	   // get bundle
	      String local = ManageLanguage.getLocal();
	      String bundleName = "com.lexington.mc.model.properties.messages" + "_" + local;
	      ResourceBundle bundle = ResourceBundle.getBundle(bundleName);

	      // read format from properties file
	      String format = FacesUtil.getMessage(formatKey);

	      // format string
	      String text = String.format(format, args);
 
	      
	      FacesMessage msg = new FacesMessage(warning, bundle.getString(subject), text);
	     return msg;
	
}

public static FacesMessage getFacesMessageWithoutParameters(String subject,
		javax.faces.application.FacesMessage.Severity severity, String message) {
	  String local = ManageLanguage.getLocal();
     
     return  new FacesMessage(severity,
                             ResourceBundle.getBundle("com.lexington.mc.model.properties.messages" + "_" + local)
                                   .getString(subject),
                             ResourceBundle.getBundle("com.lexington.mc.model.properties.messages" + "_" + local)
                                   .getString(message));
	
}

/**
    * Throws formatted message with certain severity
    * @param subject - "error", "warning" or "information"
    * @param severity - FacesMessage.Severity enum
    * @param formatKey - Key of the format in properties file
    * @param args - Args to be used for formatting
    */
   public static void throwMessageFormatted(String subject, FacesMessage.Severity severity, String formatKey, Object... args) {
  
      FacesContext context = FacesContext.getCurrentInstance();
      FacesMessage msg = getMessageWithParameters(subject, severity, formatKey, args);
      context.addMessage(null, msg);
   }

   public static String getFormatedProperty(String formatKey, Object... args) {
      // get bundle
      String local = ManageLanguage.getLocal();
      String bundleName = "com.lexington.mc.model.properties.messages" + "_" + local;
      ResourceBundle bundle = ResourceBundle.getBundle(bundleName);

      // read format from properties file
      String format = FacesUtil.getMessage(formatKey);

      // format string
      String text = String.format(format, args);

      // create message and add it to context

      return text;

   }

   /**
    * Throw message with additional text (more details). 
    * @param subject
    * @param severity
    * @param text
    * @param details
    */
   public static void throwMessage(String subject, FacesMessage.Severity severity, String text, String details) {
      String textFromPropFile = (ResourceBundle
            .getBundle("com.lexington.mc.model.properties.messages" + "_" + ManageLanguage.getLocal()).getString(text));

      FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage(severity,
                                               ResourceBundle.getBundle("com.lexington.mc.model.properties.messages"
                                                                        + "_"
                                                                        + ManageLanguage.getLocal())
                                                     .getString(subject),
                                               textFromPropFile + details));
   }

   public static void throwMessage(MessageException ex) {

	   if(ex.getArgs()==null){
		   throwMessage(ex.getSubject(), FacesUtil.Severity[ex.getSeverity()], ex.getMessage());
	   }
	   else
		   throwMessageFormatted(ex.getSubject(), FacesUtil.Severity[ex.getSeverity()], ex.getMessage(),ex.getArgs());
	   
   }

   public static void throwError(String propertyVar) {
      throwMessage("error", FacesMessage.SEVERITY_ERROR, propertyVar);
   }

   public static void throwError(String propertyVar, String details) {
      throwMessage("error", FacesMessage.SEVERITY_ERROR, propertyVar, details);
   }

   /**
    * Throws error with a formatted message
    * @param formatKey Key of a format in properties file
    * @param args Args to be used in formatting
    */
   public static void throwErrorFormatted(String formatKey, Object... args) {
      throwMessageFormatted("error", FacesMessage.SEVERITY_ERROR, formatKey, args);
   }

   public static void throwWarning(String propertyVar) {
      throwMessage("warning", FacesMessage.SEVERITY_WARN, propertyVar);
   }

   public static void throwInfo(String propertyVar) {
      throwMessage("info", FacesMessage.SEVERITY_INFO, propertyVar);
   }

   public static String getState(String e) {
      if (e == null)
         return "";
      if (e.equals("selectOne"))
         return "";
      if (e.equals(""))
         return "";
      return ResourceBundle.getBundle("com.lexington.mc.model.properties.states" + "_" + ManageLanguage.getLocal())
            .getString(e);
   }

   public static String getCountry(String e) {
      if (e == null)
         return "";
      if (e.equals("selectOne"))
         return "";
      if (e.equals(""))
         return "";
      return ResourceBundle.getBundle("com.lexington.mc.model.properties.countries" + "_" + ManageLanguage.getLocal())
            .getString(e);
   }

   /**
    * set message to be shown to user on redirected page
    * @param value
    */
   public static void setUserInfoMessage(String value) {
      setSessionMapValue("homeInfo", value);

   }

   /**
    * get message on redirected page, and remove it from the session.
    * @return
    */
   public static String getUserInfoMessage() {
      String msg = (String) FacesUtil.getSessionMapValue("homeInfo");
      if (msg != null) {
         FacesUtil.removeSessionMapValue("homeInfo");
      }
      return msg;

   }
   public static void redirect(String string) {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(string);
		} catch (IOException e) {
			e.printStackTrace();
			FacesUtil.throwError("somethingWentWrong");
		}
		
	}
   
//   public static void getBasePageUrl(){
//	   
//	   
//   }
 
}
