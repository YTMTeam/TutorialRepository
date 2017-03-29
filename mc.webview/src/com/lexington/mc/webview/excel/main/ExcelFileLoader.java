package com.lexington.mc.webview.excel.main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.primefaces.model.UploadedFile;

import com.lexington.mc.logic.excel.util.ExcelCellLoader;
import com.lexington.mc.logic.excel.util.ExcelLoaderErrorObj;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.webview.beans.ManageUser;
import com.lexington.mc.webview.excel.util.FilePathsExcel;
import com.lexington.mc.webview.excel.util.IExcelFileLoader;
import com.lexington.mc.webview.util.FacesUtil;

public class ExcelFileLoader implements IExcelFileLoader {

   protected ManageUser                     user = (ManageUser) FacesUtil.getSessionMapValue("user");

   protected String                         fileName;
   protected String                         absoluteFilePath;
   protected ArrayList<ExcelLoaderErrorObj> errors;
   ArrayList<?>                             insertedObjects;
   int                                      numberOfInsertedObjects;

   public ExcelFileLoader() {
      errors = new ArrayList<>();
      new FilePathsExcel().createExcelLoaderFolderStructure();
   }

   @Override
   public boolean processExcelFile(UploadedFile uploadedFile, ExcelCellLoader excelLoader) {

      // TODO Auto-generated method stub
      //0. Check file type.
      if (!(uploadedFile.getContentType().equals(FilePathsExcel.FILE_TYPES[0])
            || uploadedFile.getContentType().equals(FilePathsExcel.FILE_TYPES[1]))) {
         errors.add(new ExcelLoaderErrorObj("invalidFileType"));
         return false;
      }

      System.out.println("Excel file name " + uploadedFile.getFileName() + "." + uploadedFile.getContentType());

      //1. Create file name
      setFileName(createFileName(uploadedFile.getFileName()));

      //2. Store tmp file on disk
      if (!storeFileOnDisk(fileName, uploadedFile)) {
         errors.add(new ExcelLoaderErrorObj("errorStoringFileOnDisk"));
         return false;
      }

      //3. Process excel file and store into global variable of a loader
      if (!excelLoader.readDataFromExcel(this.absoluteFilePath, user.getCurUser())) {
         errors.addAll(excelLoader.getErrors());
         return false;
      }

      //4. Check for constraint errors for stored variable from step 3.
      try {
      if (!excelLoader.constraintErrorCheck()) {
         errors.addAll(excelLoader.getErrors());
         return false;
      } 
      } catch (MessageException e) {
         errors.add(new ExcelLoaderErrorObj("somethingWentWrong"));
         return false;
      }

      //5. If everything went fine, store information into database
      try {
         String privateKey = (String) FacesUtil.getSessionMapValue("privateKey");
         insertedObjects = excelLoader.insertInformation(user.getCurUser(), privateKey);
         if (insertedObjects == null) {
            errors.addAll(excelLoader.getErrors());
            return false;
         }
         setNumberOfInsertedObjects(insertedObjects.size());
      } catch (MessageException e) {
         errors.add(new ExcelLoaderErrorObj(e.getMessage()));
      }
      //6. Finally, delete stored file
      deleteFile();
      if (errors.isEmpty()) {
         return true;
      } else {
         return false;
      }
   }

   public String createFileName(String fileName) {
      // char '\' has int value of 92
      int indexOfReverseSolidus = fileName.lastIndexOf(92);
      if (indexOfReverseSolidus >= 0) {
         fileName = fileName.substring(indexOfReverseSolidus + 1, fileName.length());
      }
      String createdFileName = new String();
      DateFormat dateFormat = new SimpleDateFormat("yyyMMdd-HHmmss ");
      Calendar cal = Calendar.getInstance();
      createdFileName = dateFormat.format(cal.getTime()) + fileName;

      return createdFileName;
   }

   @Override
   public boolean storeFileOnDisk(String fileName, UploadedFile file) {
      UploadedFile uploadFile = file;
      absoluteFilePath = FilePathsExcel.UPLOAD_ROOT_DIR_ABSOLUTE_PATH
                         + File.separator
                         + FilePathsExcel.UPLOAD_ROOT_DIR

                         + File.separator
                         + fileName;
      File destFile = new File(absoluteFilePath);
      Path filePath = Paths.get(destFile.getAbsolutePath());
      try {
         Files.write(filePath, uploadFile.getContents());
      } catch (IOException e) {
         e.printStackTrace();
         return false;
      }
      return true;
   }

   //@Override
   //public void writeUserLogAndMoveFileIntoErrorDir() {
   //
   //	String targetLocation = FilePathsExcel.UPLOAD_ROOT_DIR_ABSOLUTE_PATH
   //			+ File.separator
   //			+ FilePathsExcel.UPLOAD_ROOT_DIR
   //			+ File.separator
   //			+ FilePathsExcel.USER_DATA_DIR
   //			+ File.separator
   //			+ FilePathsExcel.ERROR_DIR
   //			+ File.separator
   //			+ fileName;
   //	try {
   //		Files.move(Paths.get(absoluteFilePath), Paths.get(targetLocation), StandardCopyOption.REPLACE_EXISTING);
   //	} catch (IOException e) {
   //		e.printStackTrace();
   //	}
   //}
   //
   //@Override
   //public void writeUserLogAndMoveFileIntoSuccessDir() {
   //	String targetLocation = FilePathsExcel.UPLOAD_ROOT_DIR_ABSOLUTE_PATH
   //			+ File.separator
   //			+ FilePathsExcel.UPLOAD_ROOT_DIR
   //			+ File.separator
   //			+ FilePathsExcel.USER_DATA_DIR
   //			+ File.separator
   //			+ FilePathsExcel.SUCCESS_DIR
   //			+ File.separator
   //			+ fileName;
   //	try {
   //		Files.move(Paths.get(absoluteFilePath), Paths.get(targetLocation), StandardCopyOption.REPLACE_EXISTING);
   //	} catch (IOException e) {
   //		e.printStackTrace();
   //	}
   //}

   @Override
   public void deleteFile() {
      try {
         Files.delete(Paths.get(absoluteFilePath));
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

   }

   public String getFileName() {
      return fileName;
   }

   public void setFileName(String fileName) {
      this.fileName = fileName;
   }

   public String getAbsoluteFilePath() {
      return absoluteFilePath;
   }

   public void setAbsoluteFilePath(String absoluteFilePath) {
      this.absoluteFilePath = absoluteFilePath;
   }

   public ArrayList<ExcelLoaderErrorObj> getErrors() {
      return errors;
   }

   public void setErrors(ArrayList<ExcelLoaderErrorObj> errors) {
      this.errors = errors;
   }

   public int getNumberOfInsertedObjects() {
      return numberOfInsertedObjects;
   }

   public void setNumberOfInsertedObjects(int numberOfInsertedAccounts) {
      this.numberOfInsertedObjects = numberOfInsertedAccounts;
   }

}