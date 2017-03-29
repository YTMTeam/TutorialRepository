package com.lexington.mc.webview.util;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.lexington.mc.logic.util.TimeUtilModel;
import com.mallocinc.shared.util.time.TimestampUtility;

@SessionScoped
@ManagedBean(name = "timeUtil")
public class TimeUtil implements Serializable {
   //private TimeUtilModel timeModel=new TimeUtilModel();
   /**
       * 
       */
   private static final long serialVersionUID = 1L;

   public static void main(String[] args) {
      //		String time="";
      //		Calendar cal = Calendar.getInstance();
      //		Timestamp t=TimestampUtility.getCurrentTimestamp();
      //		cal.setTimeInMillis(t.getTime());
      //		System.out.println(cal.get(Calendar.HOUR));
      //		System.out.println(cal.get(Calendar.MINUTE));
      //		System.out.println(cal.get(Calendar.SECOND));
      //		System.out.println(cal.get(Calendar.YEAR));
      //		System.out.println(cal.get(Calendar.MONTH)+1);
      //		System.out.println(cal.get(Calendar.DAY_OF_MONTH));

      TimeUtil tu = new TimeUtil();
      tu.addSixMonths(TimestampUtility.getCurrentTimestamp());

   }

   
   public Timestamp getCurrentTime(){
	  return TimestampUtility.getCurrentTimestamp();
	   
   }
   private void test(Calendar cal) {
      System.out.println(cal.get(Calendar.HOUR));
      System.out.println(cal.get(Calendar.MINUTE));
      System.out.println(cal.get(Calendar.SECOND));
      System.out.println(cal.get(Calendar.YEAR));
      System.out.println(cal.get(Calendar.MONTH) + 1);
      System.out.println(cal.get(Calendar.DAY_OF_MONTH));

   }

   public String getHrsMinSecFromMili(BigDecimal t) {
      return TimeUtilModel.getHrsMinSecFromMili(t);

   }

   /**
    * Works good with time diference
    * @param time in seconds
    * @return
    */
   public String getHrsMinSecFromSec(long time) {
      return TimeUtilModel.getHrsMinSecFromSec(time);

   }

   public String getHrsMinSecFromSecWithSpaces(long time) {
      return TimeUtilModel.getHrsMinSecFromSecWithSpaces(time);
   }

   /**
    * Doesn't work with time diference. Adds one hour. Works with calendar time only.
    * @param tLong
    * @return
    */

   public String getTimeHMS(long tLong) {
      return TimeUtilModel.getTimeHMS(tLong);

   }

   public String getMonth(int m) {
      return TimeUtilModel.getMonth(m, ManageLanguage.getLocal());

   }

   public String getOnlyDateString(Timestamp t) {
      if(ManageLanguage.getLocal().toUpperCase().equals("EN"))
         return TimeUtilModel.getOnlyDateStringEnglish(t, ManageLanguage.getLocal());
      else
         return TimeUtilModel.getOnlyDateString(t, ManageLanguage.getLocal());


   }

   public Timestamp addSixMonths(Timestamp t) {
      return TimeUtilModel.addSixMonths(t);
   }

   public String getDateTimeString(Timestamp t) {
      if(ManageLanguage.getLocal().toUpperCase().equals("EN"))
         return TimeUtilModel.getDateTimeString(t, ManageLanguage.getLocal());
      else
         return TimeUtilModel.getDateTimeStringOld(t, ManageLanguage.getLocal());
   }
   
   public String getTimeString(Timestamp t) {
      return TimeUtilModel.getTimeString(t, ManageLanguage.getLocal());
   }

   public BigDecimal getDuration(Date time) {
      return TimeUtilModel.getDuration(time);
   }

   public Date getDateFromDuration(BigDecimal default_DURATION) {
      return TimeUtilModel.getDateFromDuration(default_DURATION);
   }

   public int getHrs(Integer integer) {
      return TimeUtilModel.getHrs(integer);
   }

   public int getMin(Integer integer) {
      return TimeUtilModel.getMin(integer);
   }

   public int getSec(Integer integer) {
      return TimeUtilModel.getSec(integer);
   }

   
   
}
