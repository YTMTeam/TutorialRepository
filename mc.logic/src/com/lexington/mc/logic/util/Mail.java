package com.lexington.mc.logic.util;

import java.io.File;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.apache.log4j.Logger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

 

public class Mail {
   final Logger            log       = Logger.getLogger(Mail.class.getName());
   public static long      counter   = 0;
   public static Scheduler scheduler = null;

   Mail() {
	   
   }

   public static Mail getInstance() {
      return new Mail();
   }

   private String getProperty(String property, String local) {
      return ResourceBundle.getBundle("com.mallocinc.ytm.database.properties.messages_" + local).getString(property);

   }

   public boolean isBulkEmail() {
      boolean res = ResourceBundle.getBundle("com.mallocinc.ytm.database.properties.system").getString("mailBulk").equals("Y");
      return res;
   }

   public void sendMailFromSystem(String recipient, String subject, String text) {
      counter = (counter + 1) % 1000000;
      JobKey mailJobKey = new JobKey("mailJob" + counter, "group" + counter);
      JobDetail mailJobDetail = JobBuilder.newJob(MailJob.class).withIdentity(mailJobKey).build();
      mailJobDetail.getJobDataMap().put(MailJob.SUBJECT, subject);
      mailJobDetail.getJobDataMap().put(MailJob.TEXT, text);
      mailJobDetail.getJobDataMap().put(MailJob.RECIPIENT, recipient);

      Trigger trigger = TriggerBuilder.newTrigger().withIdentity("triggerName" + counter, "group" + counter)
            .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).withRepeatCount(0)).build();

      Scheduler scheduler;

      try {

         scheduler = getScheduler();
         scheduler.start();
         scheduler.scheduleJob(mailJobDetail, trigger);
         System.out.println();
         //			scheduler.shutdown(true);
      } catch (SchedulerException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

   }

   Scheduler getScheduler() {
      if (scheduler == null) {
         try {
            scheduler = new StdSchedulerFactory().getScheduler();

         } catch (SchedulerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
      return scheduler;

   }

   /* old method
   public void sendMailFromSystemDeprecated(String recipient, String subject, String text){
   			if (recipient == null || recipient == "")
   	         return;
   	      final String username = "system@youtestme.com";
   	      final String password = "338ytm339!";
   	
   	      Properties props = new Properties();
   	      props.put("mail.smtp.auth", "true");
   	      props.put("mail.smtp.starttls.enable", "true");
   	      props.put("mail.smtp.host", "smtp.1and1.com");
   	      props.put("mail.smtp.port", "587");
   	
   	      Session session = Session.getInstance(props, new javax.mail.Authenticator() {
   	         protected PasswordAuthentication getPasswordAuthentication() {
   	            return new PasswordAuthentication(username, password);
   	         }
   	      });
   	
   	      try {
   	
   	         MimeMessage message = new MimeMessage(session);
   	         message.setFrom(new InternetAddress("system@youtestme.com"));
   	         message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
   	         message.setSubject(subject, "UTF-8");
   	
   	         message.setText(StringEscapeUtils.unescapeJava(text), "UTF-8");
   	         Transport.send(message);
   	
   	         log.info("Message sent.");
   	
   	      } catch (MessagingException e) {
   	         throw new RuntimeException(e);
   	      }
   	
   	
   }
   */

   public void sendMailFromUser(String sender, String recipient, String subject, String text) {
      sendMailWithAttachmentFromUser(sender, recipient, subject, text, null);
   }
   
   public void sendMailWithAttachmentFromUser(String sender, String recipient, String subject, String text, File file) {
      final String username = "system@youtestme.com";
      final String password = "338ytm339!";

      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", "smtp.1and1.com");
      props.put("mail.smtp.port", "587");

      Session session = Session.getInstance(props, new javax.mail.Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
         }
      });

      try {

         MimeMessage message = new MimeMessage(session);
         message.setFrom(new InternetAddress(sender));
         message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
         message.setSubject(subject);
         message.setText(text, "UTF-8", "html");

         if (file != null) {
            MimeBodyPart messageBodyPart = new MimeBodyPart();
   
            Multipart multipart = new MimeMultipart();
   
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(file);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(file.getName());
            multipart.addBodyPart(messageBodyPart);
   
            message.setContent(multipart);
         }
         Transport.send(message);

         System.out.println("Done");

      } catch (MessagingException e) {
         throw new RuntimeException(e);
      }
   }

   public void sendBulkEmails(Address[] recipients, String subject, String text) {
      if (recipients == null)
         return;
      if (recipients.length == 0)
         return;
      if (recipients[0] == null)
         return;
      final String username = "system@youtestme.com";
      final String password = "338ytm339!";

      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", "smtp.1and1.com");
      props.put("mail.smtp.port", "587");

      //new code
      //    
      //      props.put("mail.smtp.socketFactory.port", 587);
      //      props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
      //      props.put("mail.smtp.socketFactory.fallback", "false");

      Session session = Session.getInstance(props, new javax.mail.Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
         }
      });

      try {

         Message message = new MimeMessage(session);
         message.setFrom(new InternetAddress(username));
         //   message.setRecipients(Message.RecipientType.BCC, recipients);
         message.setSubject(subject);
         message.setText(text);

         Transport.send(message, recipients);
         Transport.send(message);
         System.out.println("Bulk messages sent.");

      } catch (MessagingException e) {
         throw new RuntimeException(e);
      }
   }

   private StringTemplate getMailTemplate(String templateName, String local) {
      StringTemplateGroup templateGroup = new StringTemplateGroup("template group");
      templateGroup.setFileCharEncoding("UTF-8");
      StringTemplate template = null;
      template = templateGroup.getInstanceOf("mailTemplates/" + templateName + "_" + local);
      return template;

   }
 


}