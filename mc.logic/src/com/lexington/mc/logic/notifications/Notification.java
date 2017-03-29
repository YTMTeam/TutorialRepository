package com.lexington.mc.logic.notifications;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public abstract class Notification implements Serializable {

   /**
    * Eclipse generated serial ID
    */
   private static final long serialVersionUID = 3618864300771693811L;

   public static int    totalId   = 0;
   protected String     type      = null;
   protected int        notId     = ++totalId;
   protected BigDecimal dbId      = null;
   protected Timestamp  notifTime = null;

   public Timestamp getNotifTime() {
      return notifTime;
   }

   public void setNotifTime(Timestamp notifTime) {
      this.notifTime = notifTime;
   }

   public static final String TYPE_REGISTER     = "REGISTER";
   public static final String START_QUIZ        = "START_QUIZ";
   public static final String UNRESOLVED_REPORT = "UNRESOLVED_REPORT";
   public static final String SHOW_REPORT       = "SHOW_REPORT";

   public Notification(String type, BigDecimal dbId, Timestamp notifTime) {
      super();
      this.type = type;
      this.dbId = dbId;
      this.notifTime = notifTime;
   }

   public abstract String view();

   public abstract String approve();

   public abstract String close();

   public abstract String decline();

   public boolean isTypeRegister() {
      return type.equals(TYPE_REGISTER);
   }

   public boolean isTypeStartQuiz() {
      return type.equals(START_QUIZ);
   }

   public boolean isTypeUnresolvedReport() {
      return type.equals(UNRESOLVED_REPORT);
   }

   public boolean isTypeShowReport() {
      return type.equals(SHOW_REPORT);
   }

   public static String getTypeRegister() {
      return TYPE_REGISTER;
   }

   public static String getStartQuiz() {
      return START_QUIZ;
   }

   public static String getUnresolvedReport() {
      return UNRESOLVED_REPORT;
   }

   public static String getShowReport() {
      return SHOW_REPORT;
   }

   public void setType(String type) {
      this.type = type;
   }

   public BigDecimal getDbId() {
      return dbId;
   }

   public void setDbId(BigDecimal dbId) {
      this.dbId = dbId;
   }

   public int getNotId() {
      return notId;
   }

   public void setNotId(int notId) {
      this.notId = notId;
   }

   public String getType() {
      return type;
   }

}
