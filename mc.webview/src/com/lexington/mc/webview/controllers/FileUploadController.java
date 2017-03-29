package com.lexington.mc.webview.controllers;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.UploadedFile;

import com.lexington.mc.logic.excel.loaders.ExcelAccountLoader;
import com.lexington.mc.logic.excel.loaders.ExcelPositionLoader;
import com.lexington.mc.logic.excel.loaders.ExcelRequestFileLoader;
import com.lexington.mc.logic.excel.loaders.ExcelTradeLoader;
import com.lexington.mc.logic.excel.util.ExcelLoaderErrorObj;
import com.lexington.mc.model.util.UtilProperites;
import com.lexington.mc.webview.excel.main.ExcelFileLoader;
import com.lexington.mc.webview.util.ManageLanguage;


@ViewScoped
@ManagedBean(name = "fileUpload")
public class FileUploadController {

   private UploadedFile      uploadFile;
   private ExcelFileLoader   excelDataLoader = new ExcelFileLoader();
   private ArrayList<String> messages        = new ArrayList<>();
   
   private boolean           loaded          = false;

   public void handleAccountsUpload() {
      
      if(!initializeAndCheck()) {
         return;
      }

      boolean isSuccess = excelDataLoader.processExcelFile(uploadFile, new ExcelAccountLoader());
      uploadFile = null;

      if (!isSuccess) {
         createErrorListMessage();
      } else {
         if (excelDataLoader.getNumberOfInsertedObjects() == 0) {
            createNothingLoadedMessage("noAccountsLoaded");
         } else if (excelDataLoader.getNumberOfInsertedObjects() > 0) {
            handleLoadedMessage("accountsLoadedNumber");
            setLoaded(true);
         }
      }
   }
   
   public void handleRequestFileUpload() {
      
      if(!initializeAndCheck()) {
         return;
      }
      
      boolean isSuccess = excelDataLoader.processExcelFile(uploadFile, new ExcelRequestFileLoader());
      uploadFile = null;
      
      if (!isSuccess) {
         createErrorListMessage();
      } else {
         if (excelDataLoader.getNumberOfInsertedObjects() == 0) {
            createNothingLoadedMessage("noRequestFileLoaded");
         } else if (excelDataLoader.getNumberOfInsertedObjects() > 0) {
            handleLoadedMessage("requestsLoadedNumber");
            setLoaded(true);
         }
      }
   }

   public void handleTradesUpload() {
      
      if(!initializeAndCheck()) {
         return;
      }

      boolean isSuccess = excelDataLoader.processExcelFile(uploadFile, new ExcelTradeLoader());
      uploadFile = null;

      if (!isSuccess) {
         createErrorListMessage();
      } else {
         if (excelDataLoader.getNumberOfInsertedObjects() == 0) {
            createNothingLoadedMessage("noTradesLoaded");

         } else if (excelDataLoader.getNumberOfInsertedObjects() > 0) {
            handleLoadedMessage("tradesLoadedNumber");
            setLoaded(true);
         }
      }

   }

   public void handlePositionsUpload() {
      
      if(!initializeAndCheck()) {
         return;
      }

      boolean isSuccess = excelDataLoader.processExcelFile(uploadFile, new ExcelPositionLoader());
      uploadFile = null;

      if (!isSuccess) {
         createErrorListMessage();
      } else {
         if (excelDataLoader.getNumberOfInsertedObjects() == 0) {
            createNothingLoadedMessage("noPositionsLoaded");
         } else if (excelDataLoader.getNumberOfInsertedObjects() > 0) {
            handleLoadedMessage("positionsLoadedNumber");
            setLoaded(true);
         }
      }

   }

   void createErrorListMessage() {
      for (ExcelLoaderErrorObj errorName : excelDataLoader.getErrors()) {
    	  if(errorName.getErrorDetails() != null) {
         messages.add(
               UtilProperites.getMessageProperty(ManageLanguage.getLocal(), errorName.getErrorMsg()) + "- Details: " + errorName.getErrorDetails());
    	  }
    	  else {
    	         messages.add(
    	                 UtilProperites.getMessageProperty(ManageLanguage.getLocal(), errorName.getErrorMsg()));
  
    	  }
      }
      excelDataLoader.getErrors().clear();
   }

   void createNothingLoadedMessage(String message) {
      messages.add(UtilProperites.getMessageProperty(ManageLanguage.getLocal(), message));

   }

   void handleLoadedMessage(String message) {
      String messageToAdd = UtilProperites.getMessageProperty(ManageLanguage.getLocal(), message)
                            + " "
                            + excelDataLoader.getNumberOfInsertedObjects();
      messages.add(messageToAdd);
   }

   /**
    * This method is being called in any excel upload handler - it resets global variables returns false if uploaded file is not set
    * @return
    */
   boolean initializeAndCheck() {
      excelDataLoader = new ExcelFileLoader();
      messages = new ArrayList<>();
      loaded = false;
      
      if (uploadFile == null) {
         messages.add(UtilProperites.getMessageProperty("en", "excelFileNotSelected"));
         return false;
      }
      return true;
   }

   /**
    * Probably used from xhtml file to display messages
    * @return
    */
   public boolean hasMessages() {
      if (messages == null) {
         return false;
      }
      if (messages.isEmpty()) {
         return false;
      }
         return true;

   }

   /**
    * Setters and getters
    * @return
    */
   public UploadedFile getUploadFile() {
      return uploadFile;
   }

   public void setUploadFile(UploadedFile uploadFile) {
      this.uploadFile = uploadFile;
   }

   public ArrayList<String> getMessages() {
      return messages;
   }

   public void setMessages(ArrayList<String> message) {
      this.messages = message;
   }

   public boolean isLoaded() {
      return loaded;
   }

   public void setLoaded(boolean isSuccess) {
      this.loaded = isSuccess;
   }

}
