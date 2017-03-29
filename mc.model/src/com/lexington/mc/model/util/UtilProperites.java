package com.lexington.mc.model.util;

import java.util.ResourceBundle;

public class UtilProperites {

   private final static String SYSTEM_SETTINGS = "com.lexington.mc.model.properties.system";

   public static String getMessageProperty(String local, String code) {
      if (local == null || local.toUpperCase().equals("EN"))
         return ResourceBundle.getBundle("com.lexington.mc.model.properties.messages_en").getString(code);
      else
         return ResourceBundle.getBundle("com.lexington.mc.model.properties.messages_" + local).getString(code);

   }

   public static String getSettingsProperty(String code) {
      return ResourceBundle.getBundle(SYSTEM_SETTINGS).getString(code);
   }

   public static String getFunctionNameProperty(String local, String code) {
      if (local == null || local.toUpperCase().equals("EN"))
         return ResourceBundle.getBundle("com.lexington.mc.model.properties.functions.func_name_en").getString(code);
      else
         return ResourceBundle.getBundle("com.lexington.mc.model.properties.functions.func_name_" + local).getString(code);

   }

   public static String getFunctionDescriptionProperty(String local, String code) {
      if (local == null || local.toUpperCase().equals("EN"))
         return ResourceBundle.getBundle("com.lexington.mc.model.properties.functions.func_desc_en").getString(code);
      else
         return ResourceBundle.getBundle("com.lexington.mc.model.properties.functions.func_desc_" + local).getString(code);

   }
   
   public static String getHintNameProperty(String local, String code) {
      if (local == null || local.toUpperCase().equals("EN"))
         return ResourceBundle.getBundle("com.lexington.mc.model.properties.hints.hints_name_en").getString(code);
      else
         return ResourceBundle.getBundle("com.lexington.mc.model.properties.hints.hints_name_" + local).getString(code);

   }

   public static String getHintDescriptionProperty(String local, String code) {
      if (local == null || local.toUpperCase().equals("EN"))
         return ResourceBundle.getBundle("com.lexington.mc.model.properties.hints.hints_desc_en").getString(code);
      else
         return ResourceBundle.getBundle("com.lexington.mc.model.properties.hints.hints_desc_" + local).getString(code);

   }
}
