package com.lexington.mc.webview.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import com.lexington.mc.logic.util.Generator;
import com.lexington.mc.logic.util.Mail;
import com.lexington.mc.webview.util.FacesUtil;
 
@ManagedBean(name = "contactForm")
@SessionScoped
public class ContactForm implements Serializable {
    final static Logger log = Logger.getLogger(ContactForm.class.getName());
   private String      email;
   private String      subject;
   private String      body;
   private boolean     viewContact;
   private String captchaUserInput;
   private String captchaCode;
   private Generator generator= new Generator();
   
   
   public ContactForm(){
	   captchaCode=generator.generateCaptcha();	   
}

public void refreshCaptcha(){
   captchaCode=new Generator().generateCaptcha();
}

   
   
   public void sendEmail() {
      Mail.getInstance().sendMailFromUser(email, "danilosretenovic@gmail.com", subject, body);
      email = subject = body = null;

   }

   public void initContact() {
      setViewContact(true);
      email = subject = body = null;
   }

   public void sendEmailFromUser() {
      ManageUser user = (ManageUser) FacesUtil.getSessionMapValue("user");
       email = "danilosretenovic@gmail.com";
      Mail.getInstance().sendMailFromUser(email, "danilosretenovic@gmail.com", subject, body);
      email = subject = body = null;
      setViewContact(false);

   }

   
   
   public String getCaptchaUserInput() {
	return captchaUserInput;
}

public void setCaptchaUserInput(String captchaUserInput) {
	this.captchaUserInput = captchaUserInput;
}

public String getCaptchaCode() {
	return captchaCode;
}

public void setCaptchaCode(String captchaCode) {
	this.captchaCode = captchaCode;
}

public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getSubject() {
      return subject;
   }

   public void setSubject(String subject) {
      this.subject = subject;
   }

   public String getBody() {
      return body;
   }

   public void setBody(String body) {
      this.body = body;
   }

   public boolean isViewContact() {
      return viewContact;
   }

   public void setViewContact(boolean viewContact) {
      this.viewContact = viewContact;
   }

}
