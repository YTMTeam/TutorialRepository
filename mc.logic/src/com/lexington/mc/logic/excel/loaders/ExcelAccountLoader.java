package com.lexington.mc.logic.excel.loaders;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.lexington.mc.logic.excel.util.ColumnFinder;
import com.lexington.mc.logic.excel.util.ExcelCellLoader;
import com.lexington.mc.logic.excel.util.ExcelObjectInserter;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.blockchain.common.BlockchainConstants;
import com.lexington.mc.model.blockchain.exception.BlockchainClientException;
import com.lexington.mc.model.blockchain.pojos.AccountPojo;
import com.lexington.mc.model.blockchain.pojos.MonitorPojo;
import com.lexington.mc.model.blockchain.pojos.PermissionPojo;
import com.lexington.mc.model.blockchain.pojos.streams.StreamData;
import com.lexington.mc.model.blockchain.pojos.streams.StreamDataWrapper;
import com.lexington.mc.model.blockchain.pojos.streams.StreamKeyPojo;
import com.lexington.mc.model.entities.EntityUser;
import com.lexington.mc.model.singletons.connection.BlockchainConnection;
import com.lexington.mc.model.singletons.datasource.BankEntityDatasource;
import com.lexington.mc.model.util.UtilCodeTypes;
import com.mallocinc.shared.util.time.TimestampUtility;

public class ExcelAccountLoader extends ExcelCellLoader {

   final static Logger                       log        = Logger.getLogger(ExcelTradeLoader.class.getName());

   private Gson                              gson       = new Gson();
   private UtilCodeTypes                     uct        = new UtilCodeTypes();
   private ArrayList<AccountFileExcelEntity> entityList = new ArrayList<>();
   private ExcelObjectInserter inserter = new ExcelObjectInserter();
   

   public ExcelAccountLoader() {
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

               AccountPojo account = new AccountPojo();

               account.setBANK_ID(user.getEntityBank().getBank().getBANK_ID());

               account.setACCOUNT_NUMBER(getString(ColumnFinder.Account.ACCOUNT_NUMBER));

               account.setFIRST_NAME(getString(ColumnFinder.Account.FIRST_NAME));

               account.setMIDDLE_NAME(getString(ColumnFinder.Account.MIDDLE_NAME));

               account.setLAST_NAME(getString(ColumnFinder.Account.LAST_NAME));

               account.setTYPE(getString(ColumnFinder.Account.ACCOUNT_TYPE));

               account.setBROKER_CODE(getString(ColumnFinder.Account.BROKER_CODE));

               account.setMANAGED_ACCOUNT(getString(ColumnFinder.Account.MANAGED_ACCOUNT));

               account.setACCOUNT_STATUS(getString(ColumnFinder.Account.ACCOUNT_STATUS));
               
               account.setREQUESTING_INSTITUTION(getString(ColumnFinder.Account.REQUESTING_INSTITUTION));

               account.setACCOUNT_ID(user.getEntityBank().getBank().getBANK_CODE()+BlockchainConstants.General.APPENDER+account.getACCOUNT_NUMBER());

               account.setCREATE_TIMESTAMP(TimestampUtility.getCurrentTimestamp());

               
               
               PermissionPojo permission = new PermissionPojo();
               
               permission.setPERMISSION_ID(account.getREQUESTING_INSTITUTION() + BlockchainConstants.General.APPENDER + account.getACCOUNT_ID());
               permission.setACCOUNT_ID(account.getACCOUNT_ID());
               permission.setREQUESTING_INSTITUTION(account.getREQUESTING_INSTITUTION());
               permission.setCREATE_TIMESTAMP(TimestampUtility.getCurrentTimestamp());
               
               /** if there is something in row error list, store it into global error list **/
               if (!errorsForRow.isEmpty()) {
                  getErrors().addAll(errorsForRow);
               }

               /** Store into global variable **/
               AccountFileExcelEntity entity = new AccountFileExcelEntity();
               
               entity.setAccount(account);
               entity.setPermission(permission);

               entityList.add(entity);
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
      /**
       * There will be no constraints here.
       */
      return true;
   }



   /**
    * Save all loaded data from excel into database.
    * @param user creator
    * @return 
    * @throws MessageException 
    */
   //TODO -Milos OPTIMIZE EXCEPTION HANDLING!
   @Override
   public ArrayList<AccountFileExcelEntity> insertInformation(EntityUser user, String privateKey) throws MessageException {    
      
      /** First insert account into chain **/
      for(AccountFileExcelEntity entity : entityList) {
         
         inserter.insertAccounts(entity.getAccount(), user, privateKey);
         
         /** See if there is a monitor that is for each account and check if its bank code = requesting institution **/
         
         if(entity.getAccount().getREQUESTING_INSTITUTION() != null) {
         ArrayList<StreamKeyPojo> streamKeyList = BlockchainConnection.getClient().listStreamKeys(entity.getAccount().getREQUESTING_INSTITUTION()+
         BlockchainConstants.General.APPENDER+BlockchainConstants.StreamNames.MONITORS);
         
         
         /** If monitor for this account is found, set OUT_BANK_APPROVED = "Y" **/
//         boolean foundInMonitor = false;
         
         for (StreamKeyPojo streamkey : streamKeyList) {
            if (streamkey.getKey().contains(entity.getAccount().getACCOUNT_ID())) {
               
               String streamDataWrapperString;
               try {
               streamDataWrapperString = BlockchainConnection.getClient().getLastItemFromStreamKey(entity.getAccount().getREQUESTING_INSTITUTION()+
               BlockchainConstants.General.APPENDER+BlockchainConstants.StreamNames.MONITORS, streamkey.getKey());
               } catch (BlockchainClientException e) {
                  throw new MessageException(e.getMessage());
               }
               
               StreamDataWrapper streamDataWrapper = gson.fromJson(streamDataWrapperString, StreamDataWrapper.class);
               
               StreamData streamData = gson.fromJson(streamDataWrapper.getJSONData(), StreamData.class);
               
               String decryptedDataJson = gson.toJson(streamData.getData());

               MonitorPojo monitor = gson.fromJson(decryptedDataJson, MonitorPojo.class);

               BigDecimal reqBankId = BankEntityDatasource.getBankByBankCode(entity.getPermission().getREQUESTING_INSTITUTION()).getBank().getBANK_ID();
               
               if(monitor.getBANK_ID().equals(reqBankId)) {
               monitor.setOUT_BANK_APPROVED(uct.YesNoIndicator.Codes.YES); 
//               foundInMonitor = true;
               inserter.insertMonitors(monitor, user, privateKey);
               }
            }
         }
         
            /** If there is defined requesting institution, add permission for this account **/
             inserter.insertPermissions(entity.getPermission(), user, privateKey);
      }

   }
      return entityList;
 }

   
  public class AccountFileExcelEntity {
      
      AccountPojo account;
      PermissionPojo permission;
      
      
      public AccountPojo getAccount() {
         return account;
      }
      public void setAccount(AccountPojo account) {
         this.account = account;
      }
      public PermissionPojo getPermission() {
         return permission;
      }
      public void setPermission(PermissionPojo permission) {
         this.permission = permission;
      }
       
   }
}
