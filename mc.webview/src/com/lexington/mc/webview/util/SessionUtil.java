package com.lexington.mc.webview.util;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.mallocinc.shared.util.time.TimestampUtility;
import com.lexington.mc.model.util.UtilCodeTypes;

@ManagedBean(name = "sessionUtil")
@SessionScoped
public class SessionUtil implements Serializable {
   /**
    * 
    */
   private static final long   serialVersionUID = 1L;
   private Map<String, String> courseStatusMap;
   private Map<String, String> classStatusMap;
   private Map<String, String> courseStatusMapShort;
   private Map<String, String> classStatusMapShort;

   public SessionUtil() {
      UtilCodeTypes UtilCodeTypes = new UtilCodeTypes();
      courseStatusMap = new LinkedHashMap<String, String>();
      courseStatusMap.put(FacesUtil.getMessage("active"), UtilCodeTypes.CourseStatus.Codes.ACTIVE);
      courseStatusMap.put(FacesUtil.getMessage("inactive"), UtilCodeTypes.CourseStatus.Codes.INACTIVE);
      courseStatusMap.put(FacesUtil.getMessage("deleted"), UtilCodeTypes.CourseStatus.Codes.DELETED);

      classStatusMap = new LinkedHashMap<String, String>();
      classStatusMap.put(FacesUtil.getMessage("active"), UtilCodeTypes.ClassStatus.Codes.ACTIVE);
      classStatusMap.put(FacesUtil.getMessage("inactive"), UtilCodeTypes.ClassStatus.Codes.INACTIVE);
      classStatusMap.put(FacesUtil.getMessage("deleted"), UtilCodeTypes.ClassStatus.Codes.DELETED);

      courseStatusMapShort = new LinkedHashMap<String, String>();
      courseStatusMapShort.put(FacesUtil.getMessage("active"), UtilCodeTypes.CourseStatus.Codes.ACTIVE);
      courseStatusMapShort.put(FacesUtil.getMessage("inactive"), UtilCodeTypes.CourseStatus.Codes.INACTIVE);
      //	courseStatusMapShort.put(FacesUtil.getMessage("deleted"), UtilCodeTypes.CourseStatus.Codes.DELETED);

      classStatusMapShort = new LinkedHashMap<String, String>();
      classStatusMapShort.put(FacesUtil.getMessage("active"), UtilCodeTypes.ClassStatus.Codes.ACTIVE);
      classStatusMapShort.put(FacesUtil.getMessage("inactive"), UtilCodeTypes.ClassStatus.Codes.INACTIVE);
      //classStatusMapShort.put(FacesUtil.getMessage("deleted"), UtilCodeTypes.ClassStatus.Codes.DELETED);

   }

   public Map<String, String> generateStepMap(int step, int iterations) {
      int value = step;
      LinkedHashMap<String, String> listMap = new LinkedHashMap<String, String>();
      for (int i = 0; i < iterations; i++) {
         listMap.put((value + i * step) + "", (value + i * step) + "");

      }
      return listMap;
   }

   
   public Timestamp getCurrentTimestamp(){
	   return TimestampUtility.getCurrentTimestamp();
	   
   }
   
   public Map<String, String> getCourseStatusMapShort() {
      return courseStatusMapShort;
   }

   public void setCourseStatusMapShort(Map<String, String> courseStatusMapShort) {
      this.courseStatusMapShort = courseStatusMapShort;
   }

   public Map<String, String> getClassStatusMapShort() {
      return classStatusMapShort;
   }

   public void setClassStatusMapShort(Map<String, String> classStatusMapShort) {
      this.classStatusMapShort = classStatusMapShort;
   }

   public Map<String, String> getCourseStatusMap() {
      return courseStatusMap;
   }

   public void setCourseStatusMap(Map<String, String> courseStatusMap) {
      this.courseStatusMap = courseStatusMap;
   }

   public Map<String, String> getClassStatusMap() {
      return classStatusMap;
   }

   public void setClassStatusMap(Map<String, String> classStatusMap) {
      this.classStatusMap = classStatusMap;
   }

}
