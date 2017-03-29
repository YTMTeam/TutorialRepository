package com.lexington.mc.webview.util;

import org.primefaces.model.SortOrder;

import com.lexington.mc.model.util.UtilData;

public class DbUtil {
   public String translateSortOrder(SortOrder sortOrder) {
      if (sortOrder == null) {
         //just don't sort
      } else if (sortOrder.equals(SortOrder.ASCENDING)) {
         return UtilData.ORDER_ASC;
      } else if (sortOrder.equals(SortOrder.DESCENDING)) {
         return UtilData.ORDER_DESC;
      } else if (sortOrder.equals(SortOrder.UNSORTED)) {
         return "";
      } else {
         return "";
      }
      return "";

   }

}
