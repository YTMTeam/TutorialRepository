package com.lexington.mc.logic.excel.loaders;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.google.gson.Gson;
import com.lexington.mc.logic.excel.util.ColumnFinder;
import com.lexington.mc.logic.excel.util.ExcelCellLoader;
import com.lexington.mc.logic.excel.util.ExcelLoaderErrorObj;
import com.lexington.mc.logic.excel.util.ExcelObjectInserter;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.blockchain.common.BlockchainConstants;
import com.lexington.mc.model.blockchain.common.BlockchainErrorMessages;
import com.lexington.mc.model.blockchain.common.StreamDataCreator;
import com.lexington.mc.model.blockchain.exception.BlockchainClientException;
import com.lexington.mc.model.blockchain.pojos.AccountPojo;
import com.lexington.mc.model.blockchain.pojos.EmployeePojo;
import com.lexington.mc.model.blockchain.pojos.MonitorPojo;
import com.lexington.mc.model.blockchain.pojos.streams.StreamData;
import com.lexington.mc.model.blockchain.pojos.streams.StreamDataWrapper;
import com.lexington.mc.model.blockchain.pojos.streams.StreamKeyPojo;
import com.lexington.mc.model.entities.EntityBank;
import com.lexington.mc.model.entities.EntityUser;
import com.lexington.mc.model.singletons.connection.BlockchainConnection;
import com.lexington.mc.model.singletons.datasource.BankEntityDatasource;
import com.lexington.mc.model.util.UtilCodeTypes;
import com.mallocinc.shared.util.time.TimestampUtility;

public class ExcelRequestFileLoader extends ExcelCellLoader {

   public class RequestFileExcelEntity {
      private EmployeePojo employee = new EmployeePojo();
      private MonitorPojo monitor = new MonitorPojo();
      private AccountPojo account = new AccountPojo();
      private String  accountId;
      private String accountBankCode;
      private String  employeeBankCode;

      public EmployeePojo getEmployee() {
         return employee;
      }
      public void setEmployee(EmployeePojo employee) {
         this.employee = employee;
      }
      public MonitorPojo getMonitor() {
         return monitor;
      }
      public void setMonitor(MonitorPojo monitor) {
         this.monitor = monitor;
      }
      public AccountPojo getAccount() {
         return account;
      }
      public void setAccount(AccountPojo account) {
         this.account = account;
      }
      public String getAccountId() {
         return accountId;
      }
      public void setAccountId(String accountId) {
         this.accountId = accountId;
      }
      public String getEmployeeBankCode() {
         return employeeBankCode;
      }
      public void setEmployeeBankCode(String employeeBankCode) {
         this.employeeBankCode = employeeBankCode;
      }
      public String getAccountBankCode() {
         return accountBankCode;
      }
      public void setAccountBankCode(String accountBankCode) {
         this.accountBankCode = accountBankCode;
      }





   }


   final static Logger                       log          = Logger.getLogger(ExcelRequestFileLoader.class.getName());

   private UtilCodeTypes                     uct          = new UtilCodeTypes();
   private Gson                              gson         = new Gson();

   private ArrayList<RequestFileExcelEntity> requestFiles = new ArrayList<>();
   private ExcelObjectInserter               inserter     = new ExcelObjectInserter();

//   private ArrayList<EmployeePojo> employees;
//   private ArrayList<MonitorPojo> monitors;

   public ExcelRequestFileLoader() {
      errors = new ArrayList<>();

   }

   public boolean readDataFromExcel(String absoluteFilePath, EntityUser user) {
      String whatWeAreDoing = "\"Start loading excel file on location: " + absoluteFilePath;
      log.debug(whatWeAreDoing);

      if (absoluteFilePath == null || absoluteFilePath.equals("")) {
         return false;
      }

      Workbook workbook = null;
      try {
         workbook = WorkbookFactory.create(new File(absoluteFilePath));

         sheet = workbook.getSheetAt(0); //open first sheet in workbook
         int emptyRowCounter = 0;

         int row = 0;

         /*************************************************************************
          * 
          * Load Account information
          * 
          *************************************************************************/
         int rows = sheet.getLastRowNum();

         log.info("Spreadsheet has " + rows + " rows and " + sheet.getRow(0).getLastCellNum() + " columns");

         if (rows > 0 && sheet.getRow(0).getLastCellNum() > 0) {

            for (row = 1; row <= rows; row++) {

               currentRow = sheet.getRow(row);
               errorsForRow.clear();

               /*************************
                * Check is row empty.
                *************************/
               if (checkIsRowEmpty()) {
                  if(emptyRowCounter < BlockchainConstants.General.EMPTY_ROW_COUNTER_CUT) {
                     emptyRowCounter++;
                     continue;                     
                  } else {
                     break;
                  }
               }

               EmployeePojo employee = new EmployeePojo();

               employee.setFIRST_NAME(getString(ColumnFinder.Employee.EMPLOYEE_FIRST_NAME));
               employee.setMIDDLE_NAME(getString(ColumnFinder.Employee.EMPLOYEE_MIDDLE_NAME));
               employee.setLAST_NAME(getString(ColumnFinder.Employee.EMPLOYEE_LAST_NAME));
               employee.setEMPLOYING_INSTITUTION(getString(ColumnFinder.Employee.EMPLOYING_INSTITUTION));
               employee.setBANK_ID(user.getEntityBank().getBank().getBANK_ID());

               /** This will be added in constraint method using employing institution**/
               //employee.setBANK_ID();

               /**
                * Since the external bank inserts Employee, ID is the combination of EMPL_INSTITIUTION + EMPL_NUMBER
                */
               employee.setEMPLOYEE_ID(user.getEntityBank().getBank().getBANK_CODE()+
                     BlockchainConstants.General.APPENDER
                     +BlockchainConstants.General.EMPLOYEE_SUFFIX+
                     getNumber(ColumnFinder.Employee.EMPLOYEE_NUMBER));

               MonitorPojo monitor = new MonitorPojo();

               /** This will be added in constraint method **/
               //monitor.setACCOUNT_ID();


               /** Since monitor.BANK_ID = monitor.getAccount.getBANK_ID = ManageUser.getUser.getEntityBank().getBank().getBank_ID() **/
               monitor.setBANK_ID(user.getEntityBank().getBank().getBANK_ID());

               monitor.setEMPLOYEE_ID(employee.getEMPLOYEE_ID());

               monitor.setACCOUNT_ID(getString(ColumnFinder.Monitor.ACCOUNT_BANK_CODE)+
                     BlockchainConstants.General.APPENDER+
                     getString(ColumnFinder.Monitor.ACCOUNT_NUMBER));

               monitor.setACCOUNT_FIRST_NAME(getString(ColumnFinder.Monitor.ACCOUNT_FIRST_NAME));
               monitor.setACCOUNT_MIDDLE_NAME(getString(ColumnFinder.Monitor.ACCOUNT_MIDDLE_NAME));
               monitor.setACCOUNT_LAST_NAME(getString(ColumnFinder.Monitor.ACCOUNT_LAST_NAME));

               monitor.setBROKER_CODE(getString(ColumnFinder.Monitor.BROKER_CODE));
               monitor.setRELATIONSHIP(getString(ColumnFinder.Monitor.RELATIONSHIP));

               monitor.setAS_OF_DATE(getTimestamp(ColumnFinder.Monitor.AS_OF_DATE));
               monitor.setEND_DATE(getTimestamp(ColumnFinder.Monitor.END_DATE));
               monitor.setEMP_BANK_APPROVED(uct.YesNoIndicator.Codes.YES);

               monitor.setCREATE_TIMESTAMP(TimestampUtility.getCurrentTimestamp());

               AccountPojo account = new AccountPojo();

               account.setACCOUNT_ID(monitor.getACCOUNT_ID());
               account.setACCOUNT_NUMBER(getString(ColumnFinder.Monitor.ACCOUNT_NUMBER));
               account.setFIRST_NAME(monitor.getACCOUNT_FIRST_NAME());
               account.setMIDDLE_NAME(monitor.getACCOUNT_MIDDLE_NAME());
               account.setLAST_NAME(monitor.getACCOUNT_LAST_NAME());
               account.setBROKER_CODE(monitor.getBROKER_CODE());
               account.setCREATE_TIMESTAMP(monitor.getCREATE_TIMESTAMP());

               /** if there is something in row error list, store it into global error list **/
               if (!errorsForRow.isEmpty()) {
                  getErrors().addAll(errorsForRow);
               }

               /** Add to entity **/

               RequestFileExcelEntity file = new RequestFileExcelEntity();

               file.setAccountBankCode(getString(ColumnFinder.Monitor.ACCOUNT_BANK_CODE));

               /**!**/ monitor.setMONITOR_ID(monitor.getEMPLOYEE_ID()+BlockchainConstants.General.APPENDER+monitor.getACCOUNT_ID()); /**!**/

               file.setMonitor(monitor);
               file.setEmployee(employee);
               file.setAccount(account);
               requestFiles.add(file);

               /** end adding **/


            }
         }

      } catch (InvalidFormatException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } finally {
         try {
            /************************************************************************
             *
             * Close this Excel file 
             *
             ************************************************************************/
            workbook.close();
            if (!errors.isEmpty()) {
               return false;
            }
         } catch (IOException e) {
            e.printStackTrace();
         }
      }

      if (!errors.isEmpty()) {
         return false;
      }
      return true;
   }

   @Override
   public boolean constraintErrorCheck() throws MessageException {

      for(RequestFileExcelEntity entity : requestFiles) {

         //         boolean accountExists = false;
         boolean bankExists = false;

         //         EntityAccount account = AccountEntityDatasource.getAccountByAccountId(entity.getAccountId());
         //         if( account != null) {
         //            entity.getMonitor().setACCOUNT_ID(account.getAccount().getACCOUNT_ID());
         //            entity.getMonitor().setACCOUNT_FIRST_NAME(account.getAccount().getFIRST_NAME());
         //            entity.getMonitor().setACCOUNT_MIDDLE_NAME(account.getAccount().getMIDDLE_NAME());
         //            entity.getMonitor().setACCOUNT_LAST_NAME(account.getAccount().getLAST_NAME());
         //            accountExists = true;
         //         }

         EntityBank bank = BankEntityDatasource.getBankByBankCode(entity.getAccountBankCode());
         if(bank != null) {
            //            entity.getEmployee().setBANK_ID(bank.getBank().getBANK_ID());
            entity.getAccount().setBANK_ID(bank.getBank().getBANK_ID());
            bankExists = true;
         }

         //         if(!accountExists) {
         //            errors.add(new ExcelLoaderErrorObj("nonExistingAccountId",entity.getAccountId()));
         //            return false;
         //         }
         if(!bankExists) {
            errors.add(new ExcelLoaderErrorObj("nonExistingBankCode",entity.getEmployeeBankCode()));
            return false;
         }

      }

      return true;
   }



   /**
    * Save all loaded data from excel into database.
    * @param user creator
    * @return 
    * @throws MessageException 
    */
   @Override
   public ArrayList<RequestFileExcelEntity> insertInformation(EntityUser user, String privateKey) throws MessageException {

      for(RequestFileExcelEntity entity : requestFiles) {

         inserter.insertEmployees(entity.getEmployee(), user, privateKey);

         String streamName = user.getEntityBank().getBank().getBANK_CODE()+
               BlockchainConstants.General.APPENDER+
               BlockchainConstants.StreamNames.MONITORS;

         ArrayList<StreamKeyPojo> streamKeys  = BlockchainConnection.getClient().listStreamKeys(streamName);

         boolean monitorFound = false;

         /** Try to find if there is already this monitor in the system and update it **/
         for(StreamKeyPojo streamKey : streamKeys) {
            
            /** If monitor is found, update it **/
            if(streamKey.getKey().equals(entity.getMonitor().getMONITOR_ID())) {

               String streamWrapperString;
               try {
                  streamWrapperString = BlockchainConnection.getClient().getLastItemFromStreamKey(streamName, streamKey.getKey());
               } catch(BlockchainClientException e) {
                  throw new MessageException(e.getMessage());
               }
               StreamDataWrapper streamWrapper = gson.fromJson(streamWrapperString, StreamDataWrapper.class);
               StreamData streamData = gson.fromJson(streamWrapper.getJSONData(), StreamData.class);
               
               String decryptedDataJson = gson.toJson(streamData.getData());

               MonitorPojo monitor = gson.fromJson(decryptedDataJson, MonitorPojo.class);

               entity.getMonitor().setOUT_BANK_APPROVED(monitor.getOUT_BANK_APPROVED());
               inserter.insertMonitors(entity.getMonitor(), user, privateKey);

               monitorFound = true;
            }
         }

         /** If monitor is not found, check permissions **/
         if(!monitorFound) {
            
             streamName = 
                   entity.getAccountBankCode()+
                   BlockchainConstants.General.APPENDER+
                   BlockchainConstants.StreamNames.PERMISSION;
             
             streamKeys  = BlockchainConnection.getClient().listStreamKeys(streamName);

             boolean permissionFound = false;
             
             for(StreamKeyPojo streamKey : streamKeys) {
                
                
                String streamKeyName = user.getEntityBank().getBank().getBANK_CODE() +
                      BlockchainConstants.General.APPENDER + 
                      entity.getAccount().getACCOUNT_ID();
                
                
                if (streamKey.getKey().equals(streamKeyName)) {
                   
                   entity.getMonitor().setOUT_BANK_APPROVED(uct.YesNoIndicator.Codes.YES);
                   inserter.insertMonitors(entity.getMonitor(), user, privateKey);
                   permissionFound = true;               
               }
                
             }
             
             if (!permissionFound) {
                inserter.insertMonitors(entity.getMonitor(), user, privateKey);
                
                /** Insert account if the account does not exist **/
                streamName  = entity.getAccountBankCode() + BlockchainConstants.General.APPENDER + BlockchainConstants.StreamNames.ACCOUNTS;
                streamKeys  = BlockchainConnection.getClient().listStreamKeys(streamName);
                boolean accExists = false;
                for(StreamKeyPojo streamKey : streamKeys) {
                   
                   if(streamKey.getKey().equals(entity.getAccount().getACCOUNT_ID())) {
                      accExists = true;
                   }
                }
                
                if(!accExists) {
                inserter.insertAccounts(entity.getAccount(), user, privateKey);
                }
                
             }
         }

      }
      return requestFiles;
   }

}
