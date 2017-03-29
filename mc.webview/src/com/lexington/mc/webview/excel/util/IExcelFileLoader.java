package com.lexington.mc.webview.excel.util;



import java.util.ArrayList;

import org.primefaces.model.UploadedFile;

import com.lexington.mc.logic.excel.util.ExcelCellLoader;

/**
 * This {@link IExcelFileLoader} interface must implements all classes
 * responsible for loading data form excle. 
 * @author Lazar Trsic
 *
 */
public interface IExcelFileLoader {

   /**
    * Method for process excel file by algorithm: </br> 
    * 0. Check input excel file </br>  
    * 1. Create file name </br> 
    * 2. Store tmp file on disk </br> 
    * 3. Process excel file </br>
    * 4. Write information into user log and store tmp excel file into valid directory on disk </br>
    * 5. Fill up quiz wizard with valid data (EntityQuiz) </br>
    * 6. Move tmp file into success or error folder depending by previous steps </br>  
    * 7. Check for errors during processing </br> 
    * @param event
    * @param quizWizard
    * @return
    */
   abstract boolean processExcelFile(UploadedFile file, ExcelCellLoader excelLoader);

   /**
    * Create excel file name specific for every users by predefined format.
    * @param fileName excel file name
    * @return
    */
   abstract String createFileName(String fileName);

   /**
    * Store quiz excel data for every user inside USER_UPLOAD_DIR_NAME directory.
    * @param fileName specific file name
    * @param file data for storing
    */
   abstract boolean storeFileOnDisk(String fileName, UploadedFile file);

//   abstract void writeUserLogAndMoveFileIntoErrorDir();

//   abstract void writeUserLogAndMoveFileIntoSuccessDir();

   abstract void deleteFile();
   
}
