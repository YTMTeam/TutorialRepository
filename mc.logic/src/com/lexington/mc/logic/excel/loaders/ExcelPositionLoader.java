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
import com.lexington.mc.logic.excel.util.IExcelCellLoader;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.blockchain.common.BlockchainConstants;
import com.lexington.mc.model.blockchain.common.BlockchainErrorMessages;
import com.lexington.mc.model.blockchain.common.StreamDataCreator;
import com.lexington.mc.model.blockchain.exception.BlockchainClientException;
import com.lexington.mc.model.blockchain.pojos.PositionPojo;
import com.lexington.mc.model.blockchain.pojos.streams.StreamData;
import com.lexington.mc.model.blockchain.pojos.streams.StreamDataWrapper;
import com.lexington.mc.model.blockchain.util.HexConverter;
import com.lexington.mc.model.entities.EntityAccount;
import com.lexington.mc.model.entities.EntityBank;
import com.lexington.mc.model.entities.EntityUser;
import com.lexington.mc.model.singletons.connection.BlockchainConnection;
import com.lexington.mc.model.singletons.datasource.AccountEntityDatasource;
import com.lexington.mc.model.singletons.datasource.BankEntityDatasource;
import com.lexington.mc.model.util.UtilCodeTypes;
import com.mallocinc.shared.util.time.TimestampUtility;

public class ExcelPositionLoader extends ExcelCellLoader implements IExcelCellLoader {

  public class PositionExcelEntity {
      private PositionPojo position = new PositionPojo();
      private String     accountId;
      private String     brokerCode;

      public PositionPojo getPosition() {
         return position;
      }

      public void setPosition(PositionPojo position) {
         this.position = position;
      }

      public String getAccountId() {
         return accountId;
      }

      public void setAccountId(String accountId) {
         this.accountId = accountId;
      }

      public String getBrokerCode() {
         return brokerCode;
      }

      public void setBrokerCode(String brokerCode) {
         this.brokerCode = brokerCode;
      }
      
      
   }

   final static Logger                    log                = Logger.getLogger(ExcelPositionLoader.class.getName());

   private UtilCodeTypes                  uct                = new UtilCodeTypes();
   private ArrayList<PositionExcelEntity> positionEntityList = new ArrayList<>();
   private ExcelObjectInserter            inserter           = new ExcelObjectInserter();

   public ExcelPositionLoader() {
      errors = new ArrayList<>();
      positionEntityList = new ArrayList<>();
   }

   
  
   
   @Override
   public boolean readDataFromExcel(String absoluteFilePath, EntityUser user) {

      String whatWeAreDoing = "\"Start loading excel file on location: " + absoluteFilePath;
      log.debug(whatWeAreDoing);

      if (absoluteFilePath == null || absoluteFilePath.equals("")) {
         return false;
      }

      Workbook workbook = null;
      try {
         workbook = WorkbookFactory.create(new File(absoluteFilePath));

         sheet = workbook.getSheetAt(0); //open first and only sheet in workbook
         int emptyRowCounter = 0;
         int row = 0;

         /*************************************************************************
          * 
          * Load user information
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

               PositionExcelEntity pee = new PositionExcelEntity();

               pee.setAccountId(user.getEntityBank().getBank().getBANK_CODE()+BlockchainConstants.General.APPENDER+getString(ColumnFinder.Position.ACCOUNT_NUMBER));
               
               pee.setBrokerCode(getString(ColumnFinder.Position.BROKER_CODE));

               
               
               /** Will be set upon constraint **/
               //pee.getPosition().setBROKER_CODE(getString(ColumnFinder.Position.BROKER_CODE));
              // pee.getPosition().setACCOUNT_ID();
               
               pee.getPosition().setSECURITY_SYMBOL(getString(ColumnFinder.Position.SECURITY_SYMBOL));
               
               pee.getPosition().setPOSITION_ID(pee.getBrokerCode()+
                     BlockchainConstants.General.APPENDER+
                     pee.getAccountId()+
                     BlockchainConstants.General.APPENDER+
                     pee.getPosition().getSECURITY_SYMBOL());
               
               pee.getPosition().setCUSIP(getString(ColumnFinder.Position.CUSIP));
               pee.getPosition().setISIN(getString(ColumnFinder.Position.ISIN));
               pee.getPosition().setSEDOL(getString(ColumnFinder.Position.SEDOL));

               pee.getPosition().setCURRENCY(getString(ColumnFinder.Position.CURRENCY));
               
               pee.getPosition().setEXPIRATION_DATE(getTimestamp(ColumnFinder.Position.EXPIRATION_DATE));
               pee.getPosition().setEXECUTION_PRICE(getNumber(ColumnFinder.Position.EXECUTION_PRICE));
               pee.getPosition().setMARKET_PRICE(getNumber(ColumnFinder.Position.MARKET_PRICE));
               pee.getPosition().setSECURITY_DATE(getTimestamp(ColumnFinder.Position.SECURITY_DATE));
               
               pee.getPosition().setQUANTITY(getNumber(ColumnFinder.Position.QUANTITY));
               pee.getPosition().setCREATE_TIMESTAMP(TimestampUtility.getCurrentTimestamp());

               /** if there is something in row error list, store it into global error list **/
               if (!errorsForRow.isEmpty()) {
                  getErrors().addAll(errorsForRow);
               }
               
               /** Store into global variable **/
               positionEntityList.add(pee);

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
      
      for(PositionExcelEntity entity : positionEntityList) {
         
         boolean accountExists = false;
         boolean bankExists = false;
         boolean securityExists = false;
         
         EntityAccount account = AccountEntityDatasource.getAccountByAccountId(entity.getAccountId());
         if( account != null) {
            entity.getPosition().setACCOUNT_ID(account.getAccount().getACCOUNT_ID());
            accountExists = true;
         }
         
         EntityBank bank = BankEntityDatasource.getBankByBankCode(entity.getBrokerCode());
         if(bank != null) {
            entity.getPosition().setBROKER_CODE(bank.getBank().getBANK_CODE());
            bankExists = true;
         }
         
         if(entity.getPosition().getCUSIP() != null || entity.getPosition().getISIN() != null || entity.getPosition().getSEDOL() != null) {
            securityExists = true;
         }
         
         if(!accountExists) {
            errors.add(new ExcelLoaderErrorObj("nonExistingAccountId",entity.getAccountId()));
            return false;
         }
         if(!bankExists) {
            errors.add(new ExcelLoaderErrorObj("nonExistingBankCode",entity.getBrokerCode()));
            return false;
         }
         if(!securityExists) {
            errors.add(new ExcelLoaderErrorObj("noSecurityIdent","Account ID: "+entity.getPosition().getACCOUNT_ID()));
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
   public ArrayList<PositionExcelEntity> insertInformation(EntityUser user, String privateKey) throws MessageException {
     
      for(PositionExcelEntity entity : positionEntityList) {
         
      inserter.insertPositions(entity.getPosition(), user, privateKey);
               
         
      }

      return positionEntityList;
   }

}
