package com.lexington.mc.logic.util;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.lexington.mc.model.util.UtilProperites;
import com.mallocinc.shared.util.time.TimestampUtility;

public class TimeUtilModel implements Serializable {

   /**
       * 
       */
   private static final long serialVersionUID = 1L;

   public static void main(String[] args) {

      TimeUtilModel tu = new TimeUtilModel();
      tu.addSixMonths(TimestampUtility.getCurrentTimestamp());
      test(Calendar.getInstance());

   }

   private static void test(Calendar cal) {
      System.out.println(cal.get(Calendar.HOUR));
      System.out.println(cal.get(Calendar.MINUTE));
      System.out.println(cal.get(Calendar.SECOND));
      System.out.println(cal.get(Calendar.YEAR));
      System.out.println(cal.get(Calendar.MONTH) + 1);
      System.out.println(cal.get(Calendar.DAY_OF_MONTH));

   }

   public static Date getBeginingOfMonth(){
	   Calendar calendar = getCalendarForNow();
       calendar.set(Calendar.DAY_OF_MONTH,
               calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
       setTimeToBeginningOfDay(calendar);
       return calendar.getTime();
	   
   }
   
   public static Date getEndDateOfMonth(){
	   Calendar calendar = getCalendarForNow();
       calendar.set(Calendar.DAY_OF_MONTH,
               calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
       setTimeToEndofDay(calendar);
       return calendar.getTime();
	   
   }
   
   private static Calendar getCalendarForNow() {
	    Calendar calendar = GregorianCalendar.getInstance();
	    calendar.setTime(new Date());
	    return calendar;
	}

	private static void setTimeToBeginningOfDay(Calendar calendar) {
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);
	}

	private static void setTimeToEndofDay(Calendar calendar) {
	    calendar.set(Calendar.HOUR_OF_DAY, 23);
	    calendar.set(Calendar.MINUTE, 59);
	    calendar.set(Calendar.SECOND, 59);
	    calendar.set(Calendar.MILLISECOND, 999);
	}
   public static String getHrsMinSecFromMili(BigDecimal t) {
      long tLong = t.longValue();
      String time = "";
      Calendar cal = Calendar.getInstance();
      cal.setTimeInMillis(tLong);
      int pm = cal.get(Calendar.AM_PM) * 12;
      String hours = "0";
      String minutes = "0";
      String seconds = "0";
      if ((cal.get(Calendar.HOUR) + pm) < 10)
         hours = "0" + (cal.get(Calendar.HOUR) + pm);
      else
         hours = "" + (cal.get(Calendar.HOUR) + pm);
      if ((cal.get(Calendar.MINUTE)) < 10)
         minutes = "0" + (cal.get(Calendar.MINUTE));
      else
         minutes = "" + (cal.get(Calendar.MINUTE));
      if ((cal.get(Calendar.SECOND)) < 10)
         seconds = "0" + (cal.get(Calendar.SECOND));
      else
         seconds = "" + (cal.get(Calendar.SECOND));
      time += hours + ":" + minutes + ":" + seconds;

      //time+=hours+"h:"+minutes+"m:"+seconds+"s";
      //time+=cal.get(Calendar.HOUR)+FacesUtil.getMessage("hrs")+" : "+cal.get(Calendar.MINUTE)+FacesUtil.getMessage("min")+" : "+cal.get(Calendar.SECOND)+FacesUtil.getMessage("sec");
      //time+=(cal.get(Calendar.HOUR)+pm)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND);
      return time;

   }

   /**
    * Works good with time diference
    * @param time in seconds
    * @return
    */
   public static String getHrsMinSecFromSec(long time) {
      int hours = (int) time / 3600;
      int minutes = (int) ((time - hours * 3600) / 60);
      int seconds = (int) (time - minutes * 60 - hours * 3600);
      return (hours < 10 ? ("0" + hours) : hours)
             + ":"
             + (minutes < 10 ? ("0" + minutes) : minutes)
             + ":"
             + (seconds < 10 ? ("0" + seconds) : seconds)
             + "";

   }

   public static String getHrsMinSecFromSecWithSpaces(long time) {
      int hours = (int) time / 3600;
      int minutes = (int) ((time - hours * 3600) / 60);
      int seconds = (int) (time - minutes * 60 - hours * 3600);
      return (hours < 10 ? ("0" + hours) : hours)
             + "h : "
             + (minutes < 10 ? ("0" + minutes) : minutes)
             + "m : "
             + (seconds < 10 ? ("0" + seconds) : seconds)
             + "s";

   }

   /**
    * Doesn't work with time diference. Adds one hour. Works with calendar time only.
    * @param tLong
    * @return
    */

   public static String getTimeHMS(long tLong) {

      String time = "";
      Calendar cal = Calendar.getInstance();
      cal.setTimeInMillis(tLong);
      int pm = cal.get(Calendar.AM_PM) * 12;
      String hours = "0";
      String minutes = "0";
      String seconds = "0";
      if ((cal.get(Calendar.HOUR) + pm) < 10)
         hours = "0" + (cal.get(Calendar.HOUR) + pm);
      else
         hours = "" + (cal.get(Calendar.HOUR) + pm);
      if ((cal.get(Calendar.MINUTE)) < 10)
         minutes = "0" + (cal.get(Calendar.MINUTE));
      else
         minutes = "" + (cal.get(Calendar.MINUTE));
      if ((cal.get(Calendar.SECOND)) < 10)
         seconds = "0" + (cal.get(Calendar.SECOND));
      else
         seconds = "" + (cal.get(Calendar.SECOND));
      time += hours + "h : " + minutes + "m : " + seconds + "s";

      //time+=hours+"h:"+minutes+"m:"+seconds+"s";
      //time+=cal.get(Calendar.HOUR)+FacesUtil.getMessage("hrs")+" : "+cal.get(Calendar.MINUTE)+FacesUtil.getMessage("min")+" : "+cal.get(Calendar.SECOND)+FacesUtil.getMessage("sec");
      //time+=(cal.get(Calendar.HOUR)+pm)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND);
      return time;

   }

   public static String getMonth(int m, String local) {
      switch (m) {
         case 1:
            return UtilProperites.getMessageProperty(local, "january");
         case 2:
            return UtilProperites.getMessageProperty(local, "february");
         case 3:
            return UtilProperites.getMessageProperty(local, "march");
         case 4:
            return UtilProperites.getMessageProperty(local, "april");
         case 5:
            return UtilProperites.getMessageProperty(local, "may");
         case 6:
            return UtilProperites.getMessageProperty(local, "june");
         case 7:
            return UtilProperites.getMessageProperty(local, "july");
         case 8:
            return UtilProperites.getMessageProperty(local, "august");
         case 9:
            return UtilProperites.getMessageProperty(local, "september");
         case 10:
            return UtilProperites.getMessageProperty(local, "october");
         case 11:
            return UtilProperites.getMessageProperty(local, "november");
         case 12:
            return UtilProperites.getMessageProperty(local, "december");
      }
      return "";

   }
   
   public static String getMonthFull(int m, String local) {
	      switch (m) {
	         case 1:
	            return UtilProperites.getMessageProperty(local, "januaryL");
	         case 2:
	            return UtilProperites.getMessageProperty(local, "februaryL");
	         case 3:
	            return UtilProperites.getMessageProperty(local, "marchL");
	         case 4:
	            return UtilProperites.getMessageProperty(local, "aprilL");
	         case 5:
	            return UtilProperites.getMessageProperty(local, "mayL");
	         case 6:
	            return UtilProperites.getMessageProperty(local, "juneL");
	         case 7:
	            return UtilProperites.getMessageProperty(local, "julyL");
	         case 8:
	            return UtilProperites.getMessageProperty(local, "augustL");
	         case 9:
	            return UtilProperites.getMessageProperty(local, "septemberL");
	         case 10:
	            return UtilProperites.getMessageProperty(local, "octoberL");
	         case 11:
	            return UtilProperites.getMessageProperty(local, "novemberL");
	         case 12:
	            return UtilProperites.getMessageProperty(local, "decemberL");
	      }
	      return "";

	   }

   public static String getOnlyDateString(Timestamp t, String local) {
      if (t == null)
         return "";
      Calendar cal = Calendar.getInstance();
      cal.setTimeInMillis(t.getTime());
      String time = "";
      //time+=getMonth(cal.get(cal.MONTH)+1)+" "+cal.get(Calendar.DAY_OF_MONTH)+", "+cal.get(Calendar.YEAR);
      time += cal.get(Calendar.DAY_OF_MONTH) + "-" + getMonth((cal.get(cal.MONTH) + 1), local) + "-" + cal.get(Calendar.YEAR);
      return time;

   }
   
   
   public static String getOnlyDateStringEnglish(Timestamp t, String local) {
      if (t == null)
         return "";
      Calendar cal = Calendar.getInstance();
      cal.setTimeInMillis(t.getTime());
      String time = "";
      //time+=getMonth(cal.get(cal.MONTH)+1)+" "+cal.get(Calendar.DAY_OF_MONTH)+", "+cal.get(Calendar.YEAR);
      time += getMonth((cal.get(cal.MONTH) + 1), local) + "-" + cal.get(Calendar.DAY_OF_MONTH) + "-" + cal.get(Calendar.YEAR);
      return time;

   }
   
   

   public static Timestamp addSixMonths(Timestamp t) {

      System.out.println(t);
      Calendar cal = Calendar.getInstance();
      cal.setTime(new Date(t.getTime()));
      cal.add(Calendar.MONTH, 6);
      t = new Timestamp(cal.getTime().getTime());
      System.out.println(t);
      return t;
   }
/**
 * returns in format FEB-08-2016 12:03 PM
 * @param t
 * @param local
 * @return
 */
   public static String getDateTimeString(Timestamp t, String local) {
	   if (t == null)
	         return "";
	      Calendar cal = Calendar.getInstance();
	      cal.setTimeInMillis(t.getTime());
	      int pm = cal.get(Calendar.AM_PM) * 12;
	      String time = "";
	      String hours = "0";
	      String minutes = "0";
	      String seconds = "0";
//	      if ((cal.get(Calendar.HOUR)) < 10)
//	         hours = "0" + (cal.get(Calendar.HOUR));
//	      else
	         hours = "" + (cal.get(Calendar.HOUR)+pm);
	      if ((cal.get(Calendar.MINUTE)) < 10)
	         minutes = "0" + (cal.get(Calendar.MINUTE));
	      else
	         minutes = "" + (cal.get(Calendar.MINUTE));
	      if ((cal.get(Calendar.SECOND)) < 10)
	         seconds = "0" + (cal.get(Calendar.SECOND));
	      else
	         seconds = "" + (cal.get(Calendar.SECOND));
	      time += getMonth((cal.get(cal.MONTH) + 1), local)
	              + "-"
	              + cal.get(Calendar.DAY_OF_MONTH)
	              + "-"
	              + cal.get(Calendar.YEAR)
	              + " "
	              + hours
	              + ":"
	              + minutes//+":"+seconds;
	               + " " + (cal.get(Calendar.AM_PM) == 0 ? "AM" : "PM");

	      return time;

   }
   
   /**
    * displays is in format 23-Sep-2016 16:28
    * @param t
    * @param local
    * @return
    */
   public static String getDateTimeStringOld(Timestamp t, String local) {
      if (t == null)
         return "";
      Calendar cal = Calendar.getInstance();
      cal.setTimeInMillis(t.getTime());
      int pm = cal.get(Calendar.AM_PM) * 12;
      String time = "";
      String hours = "0";
      String minutes = "0";
      String seconds = "0";
      if ((cal.get(Calendar.HOUR) + pm) < 10)
         hours = "0" + (cal.get(Calendar.HOUR) + pm);
      else
         hours = "" + (cal.get(Calendar.HOUR) + pm);
      if ((cal.get(Calendar.MINUTE)) < 10)
         minutes = "0" + (cal.get(Calendar.MINUTE));
      else
         minutes = "" + (cal.get(Calendar.MINUTE));
      if ((cal.get(Calendar.SECOND)) < 10)
         seconds = "0" + (cal.get(Calendar.SECOND));
      else
         seconds = "" + (cal.get(Calendar.SECOND));
      time += cal.get(Calendar.DAY_OF_MONTH)
              + "-"
              + getMonth((cal.get(cal.MONTH) + 1), local)
              + "-"
              + cal.get(Calendar.YEAR)
              + " "
              + hours
              + ":"
              + minutes;//+":"+seconds;

      return time;

   }
   
   
   public static String getTimeString(Timestamp t, String local) {
      if (t == null)
         return "";
      Calendar cal = Calendar.getInstance();
      cal.setTimeInMillis(t.getTime());
      int pm = cal.get(Calendar.AM_PM) * 12;
      String time = "";
      String hours = "0";
      String minutes = "0";
      if ((cal.get(Calendar.HOUR) + pm) < 10)
         hours = "0" + (cal.get(Calendar.HOUR) + pm);
      else
         hours = "" + (cal.get(Calendar.HOUR) + pm);
      if ((cal.get(Calendar.MINUTE)) < 10)
         minutes = "0" + (cal.get(Calendar.MINUTE));
      else
         minutes = "" + (cal.get(Calendar.MINUTE));
      time += hours
              + ":"
              + minutes;//+":"+seconds;
      return time;
   }

   public static BigDecimal getDuration(Date time) {
      if (time != null)
         return new java.math.BigDecimal(3600 * time.getHours() + 60 * time.getMinutes() + time.getSeconds());
      else
         return null;
   }

   public static Date getDateFromDuration(BigDecimal default_DURATION) {
      if (default_DURATION == null) {
         return new Date(0, 0, 0, 0, 0, 0);
      }
      Date date = new Date(0,
                           0,
                           0,
                           getHrs(Integer.parseInt(default_DURATION.toString())),
                           getMin(Integer.parseInt(default_DURATION.toString())),
                           getSec(Integer.parseInt(default_DURATION.toString())));

      return date;
   }

   public static int getHrs(Integer integer) {
      return (integer / 3600) > 23 ? 23 : integer / 3600;
   }

   public static int getMin(Integer integer) {
      return ((integer - getHrs(integer) * 3600) / 60) > 59 ? 59 : ((integer - getHrs(integer) * 3600) / 60);
   }

   public static int getSec(Integer integer) {
      return ((integer - getHrs(integer) * 3600) - getMin(integer) * 60) > 59
                                                                              ? 59
                                                                              : ((integer - getHrs(integer) * 3600)
                                                                                 - getMin(integer) * 60);
   }

   
   public java.sql.Date getSqlDate(java.util.Date dat){
	   
 
	   return new java.sql.Date(dat.getTime());
   }
   
   
   public Timestamp getTimestamp(java.util.Date dat){
	   
	   return new Timestamp(dat.getTime());
	   
   }
}
