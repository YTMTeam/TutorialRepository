package com.lexington.mc.webview.converters;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("dateConverter")
public class DateConverter implements Converter, Serializable {
   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   @Override
   public Object getAsObject(FacesContext context, UIComponent component, String value) {
      Timestamp sqlDate = null;
      Calendar cal = null;

      if (value != null && value.length() > 0) {
         DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

         try {
            Date utilDate = df.parse(value);
            sqlDate = new java.sql.Timestamp(utilDate.getTime());
         } catch (ParseException e) {
            throw new ConverterException(e);
         }
      }
      return sqlDate;
   }

   @Override
   public String getAsString(FacesContext context, UIComponent component, Object value) {
      String dateString = null;
      if (value != null) {
         if (value instanceof String) {
            dateString = (String) value;
         } else {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            if (value instanceof java.sql.Timestamp) {
               Date date = new Date(((java.sql.Timestamp) value).getTime());

               dateString = df.format(date);
            }
         }
      }
      return dateString;
   }
   
//   public Object getAsObject(FacesContext context, UIComponent component, String value) {
//      Timestamp sqlDate = null;
//      Calendar cal = null;
//
//     if (value != null && value.length() > 0) {
//         DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//
//        try {
//            Date utilDate = df.parse(value);
//            sqlDate = new java.sql.Timestamp(utilDate.getTime());
//         } catch (ParseException e) {
//            throw new ConverterException(e);
//         }
//      }
//
//     System.out.println("Into the database goes: " + sqlDate);
//      return sqlDate;
//   }
//
// 
//   public String getAsString(FacesContext context, UIComponent component, Object value) {
//      String dateString = null;
//      if (value != null) {
//         if (value instanceof String) {
//            dateString = (String) value;
//         } else {
//            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//            if (value instanceof java.sql.Timestamp) {
//               Date date = new Date(((java.sql.Timestamp) value).getTime());
//               dateString = df.format(date);
//            }
//         }
//      }
//
//     System.out.println("On the screen goes: " + dateString);
//      return dateString;
//   }

}