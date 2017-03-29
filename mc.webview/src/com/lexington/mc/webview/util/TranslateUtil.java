package com.lexington.mc.webview.util;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import com.lexington.mc.logic.util.MiscControl;
import com.lexington.mc.model.util.UtilCodeTypes;
import com.lexington.mc.model.util.UtilPermissions;
import com.lexington.mc.model.util.UtilProperites;
import com.lexington.mc.webview.beans.ManageUser;
import com.mallocinc.shared.util.time.TimestampUtility;

// u faces configu
@ManagedBean(name = "translate")
@SessionScoped
public class TranslateUtil implements Serializable {
   private ManageUser        user             = (ManageUser) FacesUtil.getSessionMapValue("user");
   private static final long serialVersionUID = 1L;
   public UtilCodeTypes      uct              = new UtilCodeTypes();

  
   public UtilPermissions utp      = new UtilPermissions();

   public int getMinQueryLength() {

      return new Integer(UtilProperites.getSettingsProperty("minQueryLength"));
   }

   public int getQueryDelay() {

      return new Integer(UtilProperites.getSettingsProperty("queryDelay"));
   }

   public long getLongFormBigDec(BigDecimal b) {
      return MiscControl.roundDoubleToCloserLong(b.doubleValue());
   }

   public String getTwoDecDouble(BigDecimal b) {
      return MiscControl.doubleTwoDecFormat(b.doubleValue());
   }

   public String getOneDecDouble(BigDecimal b) {
      return MiscControl.doubleOneDecFormat(b.doubleValue());
   }

   public String getEscapedText(String text) {
      return MiscControl.getPlainText(text);

   }

   public String getFunctionNameProperty(String code, String locale) {
      return UtilProperites.getFunctionNameProperty(locale, code);
   }

   public String getFunctionDescriptionProperty(String code, String locale) {
      return UtilProperites.getFunctionDescriptionProperty(locale, code);
   }

   public String getHintNameProperty(String code, String locale) {
      return UtilProperites.getHintNameProperty(locale, code);
   }

   public String getHintDescriptionProperty(String code, String locale) {
      return UtilProperites.getHintDescriptionProperty(locale, code);
   }
   
   public String prepareYoutubeLink(String youtubeId) {

      String newLink = "http://wwww.youtube.com/v/" + youtubeId;

      return "https://www.youtube.com/embed/" + youtubeId;
   }

   public boolean isEmptyString(String str) {
      if (str == null)
         return true;
      if (str.isEmpty())
         return true;
      if (str.equals(""))
         return true;
      return false;

   }
 

   public SelectItem[] filterUserPoolRole() {
      String[] statuses = null;
      String[] codes = new String[2];
      codes[0] = uct.UserPoolRoles.Codes.USER;
      codes[1] = uct.UserPoolRoles.Codes.MANAGER;

      statuses = new String[2];
      statuses[0] = FacesUtil.getMessage("user");
      statuses[1] = FacesUtil.getMessage("manager");
      return createFilterOptions(statuses, codes);
   }
    

   private SelectItem[] createFilterOptions(String[] data, String[] codes) {
      SelectItem[] options = new SelectItem[data.length + 1];

      options[0] = new SelectItem("", FacesUtil.getMessage("select"));
      for (int i = 0; i < data.length; i++) {
         options[i + 1] = new SelectItem(codes[i], data[i]);
      }

      return options;
   }

   private SelectItem[] createFilterOptionsShort(String[] data, String[] codes) {
      SelectItem[] options = new SelectItem[data.length];

      for (int i = 0; i < data.length; i++) {
         options[i] = new SelectItem(codes[i], data[i]);
      }

      return options;
   }

   private SelectItem[] createFilterOptionsNoSelect(String[] data, String[] codes) {
      SelectItem[] options = new SelectItem[data.length];

      for (int i = 0; i < data.length; i++) {
         options[i] = new SelectItem(codes[i], data[i]);
      }

      return options;
   }

   //TODO uncomment after recover
   //	public String getClassesFroVClassCourseQuizTo(ArrayList<VClassCourseQuizTo> array){
   //		String list="";
   //		Iterator i=array.iterator();
   //		while (i.hasNext()){
   //			list+=((VClassCourseQuizTo)i.next()).getCLASS_NAME();
   //			if(i.hasNext()) list+=", ";		
   //		}
   //		return list;
   //	}

   public String descTimeZone(BigDecimal zone) {

      return FacesUtil.getMessage("gmt") + " " + zone;
   }

   public String translateCountry(String country) {
      if (country != null)
         return FacesUtil.getCountry(country);
      return "";
   }

   public String translateState(String state) {
      if (state != null)
         return FacesUtil.getState(state);
      return "";
   }

   //	public HashMap translateCountries(HashMap<String, String> countriesMap){
   //		HashMap newMap=new LinkedHashMap<String, String>();
   //		Iterator it = countriesMap.entrySet().iterator();
   //		while (it.hasNext()) {
   //			Map.Entry pairs = (Map.Entry)it.next();
   //			//  pairs=new AbstractMap.SimpleEntry<String, String>(,(String) pairs.getValue()));
   //			newMap.put(translateCountry((String) pairs.getKey()), (String) pairs.getValue()); //uvek se prikazuje key
   //		}
   //		return newMap;
   //
   //	}

   //	public HashMap translateStates(
   //			HashMap<String, String> statesMap) {
   //		HashMap newMap=new LinkedHashMap<String, String>();
   //		Iterator it = statesMap.entrySet().iterator();
   //		while (it.hasNext()) {
   //			Map.Entry pairs = (Map.Entry)it.next();
   //			//  pairs=new AbstractMap.SimpleEntry<String, String>(,(String) pairs.getValue()));
   //			newMap.put(translateState((String) pairs.getKey()), (String) pairs.getValue()); //uvek se prikazuje key
   //		}
   //		return newMap;
   //	}

   public LinkedHashMap<String, Integer> generateSemesters() {

      LinkedHashMap<String, Integer> semesters = new LinkedHashMap<String, Integer>();
      for (int i = 0; i < 25; i++) {
         if (i < 21)
            semesters.put((i + 1) + "", (i + 1));
      }
      return semesters;

   }

   public LinkedHashMap<String, Integer> generateYears() {
      LinkedHashMap<String, Integer> schoolYears = new LinkedHashMap<String, Integer>();

      for (int i = 0; i < 25; i++) {
         if (i < 11) {
            schoolYears.put((i + 1) + "", i + 1);
         }
      }
      return schoolYears;

   }

   public LinkedHashMap<String, String> generateStatuses() {
      LinkedHashMap<String, String> userStatus = new LinkedHashMap<String, String>();
      userStatus.put(FacesUtil.getMessage("selectOne"), "");
      userStatus.put(FacesUtil.getMessage("active"), uct.UserStatus.Codes.ACTIVE);
      userStatus.put(FacesUtil.getMessage("suspended"), uct.UserStatus.Codes.SUSPENDED);
      userStatus.put(FacesUtil.getMessage("locked"), uct.UserStatus.Codes.LOCKED);
      userStatus.put(FacesUtil.getMessage("deleted"), uct.UserStatus.Codes.DELETED);
      userStatus.put(FacesUtil.getMessage("pending"), uct.UserStatus.Codes.PENDING);
      return userStatus;

   }

   

   
   public LinkedHashMap<String, Integer> generateTimeZones() {
      LinkedHashMap<String, Integer> timeZones = new LinkedHashMap<String, Integer>();
      for (int i = 0; i < 25; i++)
         timeZones.put("GMT " + ((i - 12) >= 0 ? ("+" + (i - 12)) : (i - 12)), i - 12);
      return timeZones;

   }

   public Date getToday() {
      return new Date(System.currentTimeMillis());
   }

   public LinkedHashMap<String, Integer> generateDateYears() {
      LinkedHashMap<String, Integer> years = new LinkedHashMap<String, Integer>();
      TimestampUtility.getCurrentTimestamp();

      int year = Calendar.getInstance().get(Calendar.YEAR);
      for (int i = 0; i < 30; i++)
         years.put((year - i) + "", year - i);
      return years;

   }

  

   public UtilCodeTypes getUct() {
      return uct;
   }

   public void setUct(UtilCodeTypes uct) {
      this.uct = uct;
   }

   private Map sortByComparator(Map unsortMap) {

      List list = new LinkedList(unsortMap.entrySet());

      // sort list based on comparator
      Collections.sort(list, new Comparator() {
         public int compare(Object o1, Object o2) {
            return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());
         }
      });

      // put sorted list into map again
      //LinkedHashMap make sure order in which keys were inserted
      Map sortedMap = new LinkedHashMap();
      for (Iterator it = list.iterator(); it.hasNext();) {
         Map.Entry entry = (Map.Entry) it.next();
         sortedMap.put(entry.getKey(), entry.getValue());
      }
      return sortedMap;
   }

   public UtilPermissions getUtp() {
      return utp;
   }

   public void setUtp(UtilPermissions utp) {
      this.utp = utp;
   }
  
 
}
