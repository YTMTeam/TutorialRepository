package com.lexington.mc.model.util;

import java.io.Serializable;
import java.util.ResourceBundle;

public class UtilActionCodes implements Serializable {

   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   public final String       LOGIN            = "LGN";
   public final String       CHANGE_PASSWORD  = "CHP";
   public final String       LOGOUT           = "LGO";

   public String getActionText(String code) {

      if (code.equals(LOGIN))
         return ResourceBundle.getBundle("com.mallocinc.ytm.database.properties.messages").getString(code);
      if (code.equals(CHANGE_PASSWORD))
         return ResourceBundle.getBundle("com.mallocinc.ytm.database.properties.messages").getString(code);
      if (code.equals(LOGOUT))
         return ResourceBundle.getBundle("com.mallocinc.ytm.database.properties.messages").getString(code);
      return "";

   }

}
