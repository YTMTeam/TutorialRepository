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
import com.lexington.mc.model.blockchain.pojos.TradePojo;
import com.lexington.mc.model.blockchain.pojos.streams.StreamData;
import com.lexington.mc.model.blockchain.pojos.streams.StreamDataWrapper;
import com.lexington.mc.model.blockchain.util.HexConverter;
import com.lexington.mc.model.entities.EntityAccount;
import com.lexington.mc.model.entities.EntityBank;
import com.lexington.mc.model.entities.EntityUser;
import com.lexington.mc.model.singletons.connection.BlockchainConnection;
import com.lexington.mc.model.singletons.datasource.AccountEntityDatasource;
import com.lexington.mc.model.singletons.datasource.BankEntityDatasource;
import com.mallocinc.shared.util.time.TimestampUtility;

public class ExcelTradeLoader extends ExcelCellLoader {

   class TradeExcelEntity {
      private TradePojo trade = new TradePojo();
      private String  accountId;
      private String  bankCode;

      public TradePojo getTrade() {
         return trade;
      }

      public void setTrade(TradePojo trade) {
         this.trade = trade;
      }

      public String getAccountId() {
         return accountId;
      }

      public void setAccountId(String accountId) {
         this.accountId = accountId;
      }

      public String getBankCode() {
         return bankCode;
      }

      public void setBankCode(String bankCode) {
         this.bankCode = bankCode;
      }


   }

   final static Logger                 log             = Logger.getLogger(ExcelAccountLoader.class.getName());

   private ArrayList<TradeExcelEntity> tradeEntityList = new ArrayList<>();
   private ExcelObjectInserter         inserter        = new ExcelObjectInserter();

   public ExcelTradeLoader() {
      errors = new ArrayList<>();
      tradeEntityList = new ArrayList<>();
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

               TradeExcelEntity tee = new TradeExcelEntity();

               //it is assumed that each bank inserts trades for THEIR ACCOUNTS ONLY
               tee.setAccountId(user.getEntityBank().getBank().getBANK_CODE()+BlockchainConstants.General.APPENDER+getString(ColumnFinder.Trade.ACCOUNT_NUMBER));

               tee.setBankCode(getString(ColumnFinder.Trade.BROKER_CODE));


               tee.getTrade().setTRANSACTION_ID(getString(ColumnFinder.Trade.TRANSACTION_ID));

               tee.getTrade().setTRADE_ID(tee.getAccountId()+BlockchainConstants.General.APPENDER+tee.getTrade().getTRANSACTION_ID());


               tee.getTrade().setTRANSACTION_TYPE(getString(ColumnFinder.Trade.TRANSACTION_TYPE));

               /** BANK_ID and ACCOUNT_ID is set upon constraint check**/
               // tee.getTrade().setBANK_ID();
               // tee.getTrade().setACCOUNT_ID();

               tee.getTrade().setQUANTITY(getNumber(ColumnFinder.Trade.QUANTITY));
               
               tee.getTrade().setDATA_AS_OF(getTimestamp(ColumnFinder.Trade.DATA_AS_OF));

               tee.getTrade().setSECURITY_SYMBOL(getString(ColumnFinder.Trade.SECURITY_SYMBOL));

               tee.getTrade().setCURRENCY(getString(ColumnFinder.Trade.CURRENCY));


               tee.getTrade().setSECURITY_NAME(getString(ColumnFinder.Trade.SECURITY_NAME));
               tee.getTrade().setSECURITY_TYPE(getString(ColumnFinder.Trade.SECURITY_TYPE));

               tee.getTrade().setEXECUTION_PRICE(getNumber(ColumnFinder.Trade.EXECUTION_PRICE));

               tee.getTrade().setNET_AMOUNT(getNumber(ColumnFinder.Trade.NET_AMOUNT));

               tee.getTrade().setEXCHANGE(getString(ColumnFinder.Trade.EXCHANGE));

               tee.getTrade().setCUSIP(getString(ColumnFinder.Trade.CUSIP));
               tee.getTrade().setISIN(getString(ColumnFinder.Trade.ISIN));
               tee.getTrade().setSEDOL(getString(ColumnFinder.Trade.SEDOL));

               tee.getTrade().setTRADE_DATE(getTimestamp(ColumnFinder.Trade.TRADE_DATE));

               tee.getTrade().setCREATE_TIMESTAMP(TimestampUtility.getCurrentTimestamp());

               /** if there is something in row error list, store it into global error list **/
               if (!errorsForRow.isEmpty()) {
                  getErrors().addAll(errorsForRow);
               }

               /** Store into global variable **/
               tradeEntityList.add(tee);

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


   /**
    * In this case, this method iterates through bank and account names and finds their ID. If there is no ID for some account - throw error
    */
   @Override
   public boolean constraintErrorCheck() throws MessageException {
      
      for(TradeExcelEntity entity : tradeEntityList) {
         
         boolean accountExists = false;
         boolean bankExists = false;
         boolean securityExists = false;
         EntityAccount account = AccountEntityDatasource.getAccountByAccountId(entity.getAccountId());
         if( account != null) {
            entity.getTrade().setACCOUNT_ID(account.getAccount().getACCOUNT_ID());
            accountExists = true;
         }
         
         EntityBank bank = BankEntityDatasource.getBankByBankCode(entity.getBankCode());
         if(bank != null) {
            entity.getTrade().setBANK_ID(bank.getBank().getBANK_ID());
            bankExists = true;
         }
         
         if(entity.getTrade().getCUSIP() != null || entity.getTrade().getISIN() != null || entity.getTrade().getSEDOL() != null) {
            securityExists = true;
         }
         
         if(!accountExists) {
            errors.add(new ExcelLoaderErrorObj("nonExistingAccountId",entity.getAccountId()));
            return false;
         }
         if(!bankExists) {
            errors.add(new ExcelLoaderErrorObj("nonExistingBankCode",entity.getBankCode()));
            return false;
         }
         if(!securityExists) {
            errors.add(new ExcelLoaderErrorObj("noSecurityIdent","Transaction ID: "+entity.getTrade().getTRANSACTION_ID()));
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
   public ArrayList<TradeExcelEntity> insertInformation(EntityUser user, String privateKey) throws MessageException {
      
      for(TradeExcelEntity entity : tradeEntityList) {

         inserter.insertTrades(entity.getTrade(), user, privateKey);
      }
      return tradeEntityList;
   }

}
