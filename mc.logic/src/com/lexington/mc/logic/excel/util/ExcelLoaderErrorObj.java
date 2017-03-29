package com.lexington.mc.logic.excel.util;


public class ExcelLoaderErrorObj {

   private String errorMsg;
   private String errorDetails;

   public ExcelLoaderErrorObj(String errorMsg) {
      setErrorMsg(errorMsg);
      setErrorDetails("");
   }

   public ExcelLoaderErrorObj(String errorMsg, String errorDetails) {
      setErrorMsg(errorMsg);
      setErrorDetails(errorDetails);
   }

   public String getErrorMsg() {
      return errorMsg;
   }

   public void setErrorMsg(String errorMsg) {
      this.errorMsg = errorMsg;
   }

   public String getErrorDetails() {
      return errorDetails;
   }

   public void setErrorDetails(String errorDetails) {
      this.errorDetails = errorDetails;
   }

}