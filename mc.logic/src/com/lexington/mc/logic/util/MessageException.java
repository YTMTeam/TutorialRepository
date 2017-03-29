package com.lexington.mc.logic.util;

public class MessageException extends Exception {
   public static final int ERROR = 0, FATAL = 1, INFO = 2, WARN = 3;
   private String          subject;
   private String          message;
   private int             severity;
   Object [] args;








 
   
   public MessageException(String subject, int level, String msg, Object... args) {
      super(msg);
      message = msg;
      this.subject = subject;
      this.severity = level;
      this.args = args;
   }


   

   
   
   private MessageException(int level, String msg) {
      super(msg);
      message = msg;
      switch (level) {
         default:
         case ERROR:
            this.subject = "error";
            break;
         case FATAL:
            this.subject = "fatal";
            break;
         case WARN:
            this.subject = "warn";
            break;
         case INFO:
            this.subject = "info";
            break;
      }
      this.severity = level;
   }

   public MessageException(String msg) {
      this(ERROR, msg);
   }

   public String getSubject() {
      return subject;
   }

   public void setSubject(String subject) {
      this.subject = subject;
   }

   public String getMessage() {
      return message;
   }

   public void setMessage(String message) {
      this.message = message;
   }

   public int getSeverity() {
      return severity;
   }

   public void setSeverity(int severity) {
      this.severity = severity;
   }


   public Object[] getArgs() {
	return args;
}






public void setArgs(Object[] args) {
	this.args = args;
}


}
