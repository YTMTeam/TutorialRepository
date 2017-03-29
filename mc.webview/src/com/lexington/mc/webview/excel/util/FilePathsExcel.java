package com.lexington.mc.webview.excel.util;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;


public class FilePathsExcel {

   private static final String  EXCEL_UPLOAD_PATH_SETTINGS_CODE = "excelUploadFilesPath";
   public static final String[] FILE_TYPES                      = {
                                                                    "application/vnd.ms-excel",
                                                                    "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" };

   public static String       UPLOAD_ROOT_DIR_ABSOLUTE_PATH = "";
   public static final String UPLOAD_ROOT_DIR               = "excel_uploads";

   public void createExcelLoaderFolderStructure() {

	   ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
         UPLOAD_ROOT_DIR_ABSOLUTE_PATH = servletContext.getRealPath("");

      String rootDirFilePath = UPLOAD_ROOT_DIR_ABSOLUTE_PATH + File.separator + UPLOAD_ROOT_DIR;
      /**
       * Check if exists root file directory.
       * If not, create it.
       */
      if (Files.notExists(Paths.get(rootDirFilePath))) {
         try {
            Files.createDirectories(Paths.get(rootDirFilePath));
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }

}
