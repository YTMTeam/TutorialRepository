package com.lexington.mc.logic.util;


import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MailJob implements Job {
// 	final Logger log = Logger.getLogger(MailJob.class.getName());
//
	public static final String RECIPIENT = "RECIPIENT";
	public static final String SUBJECT   = "SUBJECT";
	public static final String TEXT      = "TEXT";
//
//	public static int CUR_MAIL_NUM = 0;
//
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
//		UtilCodeTypes uct=new UtilCodeTypes();
//		JobDataMap data = context.getJobDetail().getJobDataMap();
//		String recipient = data.getString(RECIPIENT);
//		String subject = data.getString(SUBJECT);
//		String text = data.getString(TEXT);
//
//		log.info("Starting message sending to: " + recipient);
//
//		/**odavde je relevantno za mail provider **/
//
//		GlobalPreferences gp = new GlobalPreferences();
// 
//		EntityMailServer ms;
//		try {
//			ms = gp.getCurMailServer();
//		} catch (MessageException e1) {
//		e1.printStackTrace();
//		return;
//		}
//
//		final String mailUsername = ms.getTo().getMAIL_USERNAME();
//		final String mailPassword = ms.getTo().getMAIL_PASSWORD();
//		final String mailHost = ms.getTo().getMAIL_HOST();
//		final String mailPort = ms.getTo().getMAIL_PORT();
//		final String systemMail = ms.getTo().getSYSTEM_EMAIL();
//		final boolean authFlag=ms.getTo().getSMTP_AUTH().equals(uct.getYesNoIndicator().getCodes().getYES());
//		final boolean starttlsFlag=ms.getTo().getSMTP_STARTTLS().equals(uct.getYesNoIndicator().getCodes().getYES());
//
//		Properties props = new Properties();
//		if(authFlag)
//			props.put("mail.smtp.auth", "true");
//		if(starttlsFlag)
//			props.put("mail.smtp.starttls.enable", "true");   
// 
//		props.put("mail.smtp.host", mailHost);
//		props.put("mail.smtp.port", mailPort);
//
//		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(mailUsername, mailPassword);
//			}
//		});
//
//		try {
//
//			MimeMessage message = new MimeMessage(session);
//			message.setFrom(new InternetAddress(systemMail));
//			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
//			message.setSubject(subject, "UTF-8");
//
//			message.setText(StringEscapeUtils.unescapeJava(text), "UTF-8");
//			Transport.send(message);
//
//		} catch (MessagingException e) {
//			throw new RuntimeException(e);
//		}
	}

}