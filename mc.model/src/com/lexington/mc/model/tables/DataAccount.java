package com.lexington.mc.model.tables;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.lexington.mc.model.util.UtilCodeTypes;
import com.lexington.mc.model.util.UtilData;
import com.mallocinc.codegenerator.exceptions.GDAOException;
import com.mallocinc.database.generated.to.AccountTo;
import com.mallocinc.database.generated.working.AccountTab;

public class DataAccount {
   UtilCodeTypes uct = new UtilCodeTypes();
   final static Logger log = Logger.getLogger(DataAccount.class.getName());

   /**********************************************************************
    *
    * TRANSACTION_STRATEGY_TRESHOLD is the number of records that will 
    * be changed and it is used to determine most optimum strategy
    * for executing the task. 
    * In order to get the best results this number should be determined 
    * by experience or by experimenting.
    *
    **********************************************************************/
   final static long TRANSACTION_STRATEGY_TRESHOLD = 100000;

   /**********************************************************************
    *
    * TRANSACTION_TRESHOLD identifies number of updates/inserts or deletes
    * in one database transaction.
    * In order to get the best results this number should be determined 
    * by experience or by experimenting.
    *
    **********************************************************************/
   final static long TRANSACTION_TRESHOLD = 1000;

   UtilData utilData= new UtilData();

   public long getAddressesFilterCount(Connection conn, Map<String, Object> filters) throws GDAOException {
      long rowCount=0;
      AccountTab accountTab = new AccountTab(conn);

      try {

         accountTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         accountTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

         rowCount = accountTab.getRowCount(utilData.prepareCountString(filters, true));

      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot select from TABLE \"ACCOUNT\".");
         throw new GDAOException(e);
      } finally {
         accountTab.releaseStatement();
      }

      log.debug("Finished count from VIEW \"ACCOUNT\".");
      return rowCount;
   }

   public List<AccountTo> getAddressesForPaging(Connection conn, int first, int pageSize, String sortField,
         String sortOrder, Map<String, Object> filters) throws GDAOException {
      List<AccountTo> res= new ArrayList<AccountTo>();
      log.debug("Starting select from TABLE \"ACCOUNT\".");

      AccountTab AccountTab = new AccountTab(conn);

      try {

         /**********************************************************************
          *
          * !IMPORTANT!:
          * Use the following parameters in order to speed up SELECT
          * and to prevent program from failing because of EXAUSTED MEMORY error:
          * java.lang.OutOfMemoryError: Java heap space
          *
          **********************************************************************/
         AccountTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         AccountTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

         /**********************************************************************
          *
          * Selects specific records from the table:
          * Limit number of rows selected to "100" (just an example)
          * Change "WHERE" condition to meet your needs.
          *
          **********************************************************************/
         AccountTab.getResultSet(utilData.preparePagingStatementString(first, pageSize, sortField, sortOrder, filters, true));

         /**********************************************************************
          *
          * Selects all records from the table - no "WHERE" condition.
          * Both methods below are equal:
          *
          **********************************************************************/
         //AccountTab.getResultSet(null, (Object[])null);
         //AccountTab.getAllRecordsRs();

         /**********************************************************************
          *
          * Loop through database result set:
          *
          **********************************************************************/
         while (AccountTab.next()) {
            res.add(AccountTab.getTo());
            /**********************************************************************
             *
             * Print all values from the row in one line delimited by "; "
             *
             **********************************************************************/
            AccountTab.print("; ");

            /**********************************************************************
             *
             * Fetch data from the database into local variables:
             *
             **********************************************************************/


            log.debug("---------------^^^^^^^^^-----------------");
         }

      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot select from TABLE \"ACCOUNT\".");
         throw new GDAOException(e);
      } finally {
         AccountTab.releaseStatement();
      }

      log.debug("Finished select from TABLE \"ACCOUNT\".");
      return res;
   }

   public List<AccountTo> getAccountsByBankIdForPaging(Connection conn, int first, int pageSize, String sortField,
         String sortOrder, Map<String, Object> filters, BigDecimal bankId) throws GDAOException {
      List<AccountTo> res= new ArrayList<AccountTo>();
      log.debug("Starting select from TABLE \"ACCOUNT\".");

      AccountTab accountTab = new AccountTab(conn);

      try {

         /**********************************************************************
          *
          * !IMPORTANT!:
          * Use the following parameters in order to speed up SELECT
          * and to prevent program from failing because of EXAUSTED MEMORY error:
          * java.lang.OutOfMemoryError: Java heap space
          *
          **********************************************************************/
         accountTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         accountTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

         /**********************************************************************
          *
          * Selects specific records from the table:
          * Limit number of rows selected to "100" (just an example)
          * Change "WHERE" condition to meet your needs.
          *
          **********************************************************************/
         String andCheck = utilData.checkAndClause(filters);
         String queryString = "WHERE BANK_ID = ? ";

         queryString += ""
               + andCheck
               + utilData.preparePagingStatementString(first, pageSize, sortField, sortOrder, filters, false);

         accountTab.getResultSet(queryString, bankId);

         /**********************************************************************
          *
          * Selects all records from the table - no "WHERE" condition.
          * Both methods below are equal:
          *
          **********************************************************************/
         //AccountTab.getResultSet(null, (Object[])null);
         //AccountTab.getAllRecordsRs();

         /**********************************************************************
          *
          * Loop through database result set:
          *
          **********************************************************************/
         while (accountTab.next()) {
            res.add(accountTab.getTo());
            /**********************************************************************
             *
             * Print all values from the row in one line delimited by "; "
             *
             **********************************************************************/
            accountTab.print("; ");

            /**********************************************************************
             *
             * Fetch data from the database into local variables:
             *
             **********************************************************************/


            log.debug("---------------^^^^^^^^^-----------------");
         }

      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot select from TABLE \"ACCOUNT\".");
         throw new GDAOException(e);
      } finally {
         accountTab.releaseStatement();
      }

      log.debug("Finished select from TABLE \"ACCOUNT\".");
      return res;
   }

   public long getAccountsByBankIdFilterCount(Connection conn, Map<String, Object> filters, BigDecimal bankId) throws GDAOException {
      long rowCount=0;
      AccountTab accountTab = new AccountTab(conn);

      try {

         accountTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         accountTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

         String andCheck = utilData.checkAndClause(filters);
         String queryString = "WHERE BANK_ID =? ";
         queryString += "" + andCheck + utilData.prepareCountString(filters, false);

         rowCount = accountTab.getRowCount(queryString, bankId);

      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot select from TABLE \"ACCOUNT\".");
         throw new GDAOException(e);
      } finally {
         accountTab.releaseStatement();
      }

      log.debug("Finished count from VIEW \"ACCOUNT\".");
      return rowCount;
   }
   public AccountTo getBank(Connection conn) throws GDAOException {
      AccountTo  res= null;
      log.debug("Starting select from TABLE \"ACCOUNT\".");


      AccountTab accountTab = new AccountTab(conn);

      try {

         /**********************************************************************
          *
          * !IMPORTANT!:
          * Use the following parameters in order to speed up SELECT
          * and to prevent program from failing because of EXAUSTED MEMORY error:
          * java.lang.OutOfMemoryError: Java heap space
          *
          **********************************************************************/
         accountTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         accountTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

         /**********************************************************************
          *
          * Selects specific records from the table:
          * Limit number of rows selected to "100" (just an example)
          * Change "WHERE" condition to meet your needs.
          *
          **********************************************************************/
         accountTab.getResultSet("WHERE TYPE = ? ", uct.getUserType().getCodes().getBANK());

         /**********************************************************************
          *
          * Selects all records from the table - no "WHERE" condition.
          * Both methods below are equal:
          *
          **********************************************************************/
         //AccountTab.getResultSet(null, (Object[])null);
         //AccountTab.getAllRecordsRs();

         /**********************************************************************
          *
          * Loop through database result set:
          *
          **********************************************************************/
         if (accountTab.next()) {
            res = accountTab.getTo();
            /**********************************************************************
             *
             * Print all values from the row in one line delimited by "; "
             *
             **********************************************************************/
            accountTab.print("; ");

            /**********************************************************************
             *
             * Fetch data from the database into local variables:
             *
             **********************************************************************/


            /**********************************************************************
             *
             * Print all values from the row - one line per column:
             *
             **********************************************************************/

         }

      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot select from TABLE \"ACCOUNT\".");
         throw new GDAOException(e);
      } finally {
         accountTab.releaseStatement();
      }

      log.debug("Finished select from TABLE \"ACCOUNT\".");
      return res;
   }
   public ArrayList<AccountTo> getUsersByGroupId(Connection conn, BigDecimal groupId) throws GDAOException {
      ArrayList<AccountTo>  res= new ArrayList<>();
      log.debug("Starting select from TABLE \"ACCOUNT\".");


      AccountTab AccountTab = new AccountTab(conn);

      try {

         /**********************************************************************
          *
          * !IMPORTANT!:
          * Use the following parameters in order to speed up SELECT
          * and to prevent program from failing because of EXAUSTED MEMORY error:
          * java.lang.OutOfMemoryError: Java heap space
          *
          **********************************************************************/
         AccountTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         AccountTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

         /**********************************************************************
          *
          * Selects specific records from the table:
          * Limit number of rows selected to "100" (just an example)
          * Change "WHERE" condition to meet your needs.
          *
          **********************************************************************/
         AccountTab.getResultSet("WHERE HOUSEHOLD_ID = ? ", groupId);

         /**********************************************************************
          *
          * Selects all records from the table - no "WHERE" condition.
          * Both methods below are equal:
          *
          **********************************************************************/
         //AccountTab.getResultSet(null, (Object[])null);
         //AccountTab.getAllRecordsRs();

         /**********************************************************************
          *
          * Loop through database result set:
          *
          **********************************************************************/
         while (AccountTab.next()) {
            res.add(AccountTab.getTo());
            /**********************************************************************
             *
             * Print all values from the row in one line delimited by "; "
             *
             **********************************************************************/
            AccountTab.print("; ");

            /**********************************************************************
             *
             * Fetch data from the database into local variables:
             *
             **********************************************************************/

         }

      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot select from TABLE \"ACCOUNT\".");
         throw new GDAOException(e);
      } finally {
         AccountTab.releaseStatement();
      }

      log.debug("Finished select from TABLE \"ACCOUNT\".");
      return res;
   }
   public AccountTo getAccountByAccountId(Connection conn, String accountId) throws GDAOException {
      AccountTo  res= new AccountTo();
      log.debug("Starting select from TABLE \"ACCOUNT\".");

      java.math.BigDecimal walletAddressId = null;
      java.math.BigDecimal transactionId = null;
      java.lang.String addressName = null;
      java.lang.String isValid = null;
      java.lang.String pubkey = null;
      java.lang.String isCompressed = null;
      java.lang.String isScript = null;
      java.lang.String type = null;


      AccountTab AccountTab = new AccountTab(conn);

      try {

         /**********************************************************************
          *
          * !IMPORTANT!:
          * Use the following parameters in order to speed up SELECT
          * and to prevent program from failing because of EXAUSTED MEMORY error:
          * java.lang.OutOfMemoryError: Java heap space
          *
          **********************************************************************/
         AccountTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         AccountTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

         /**********************************************************************
          *
          * Selects specific records from the table:
          * Limit number of rows selected to "100" (just an example)
          * Change "WHERE" condition to meet your needs.
          *
          **********************************************************************/
         AccountTab.getResultSet("WHERE ACCOUNT_ID = ? ", accountId);

         /**********************************************************************
          *
          * Selects all records from the table - no "WHERE" condition.
          * Both methods below are equal:
          *
          **********************************************************************/
         //AccountTab.getResultSet(null, (Object[])null);
         //AccountTab.getAllRecordsRs();

         /**********************************************************************
          *
          * Loop through database result set:
          *
          **********************************************************************/
         if (AccountTab.next()) {
            res = AccountTab.getTo();
            /**********************************************************************
             *
             * Print all values from the row in one line delimited by "; "
             *
             **********************************************************************/
            AccountTab.print("; ");

            /**********************************************************************
             *
             * Fetch data from the database into local variables:
             *
             **********************************************************************/

         }

      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot select from TABLE \"ACCOUNT\".");
         throw new GDAOException(e);
      } finally {
         AccountTab.releaseStatement();
      }

      log.debug("Finished select from TABLE \"ACCOUNT\".");
      return res;
   }

   public List<AccountTo> getUserWalletAddressesForSearch(Connection conn, int first, int pageSize,
         String sortField, String sortOrder, HashMap<String, Object> filters) throws GDAOException {
      List<AccountTo>  res= new ArrayList<AccountTo>();
      log.debug("Starting select from TABLE \"ACCOUNT\".");

      java.math.BigDecimal walletAddressId = null;
      java.math.BigDecimal transactionId = null;
      java.lang.String addressName = null;
      java.lang.String isValid = null;
      java.lang.String pubkey = null;
      java.lang.String isCompressed = null;
      java.lang.String isScript = null;
      java.lang.String type = null;


      AccountTab AccountTab = new AccountTab(conn);

      try {

         /**********************************************************************
          *
          * !IMPORTANT!:
          * Use the following parameters in order to speed up SELECT
          * and to prevent program from failing because of EXAUSTED MEMORY error:
          * java.lang.OutOfMemoryError: Java heap space
          *
          **********************************************************************/
         AccountTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         AccountTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

         /**********************************************************************
          *
          * Selects specific records from the table:
          * Limit number of rows selected to "100" (just an example)
          * Change "WHERE" condition to meet your needs.
          *
          **********************************************************************/
         String andCheck = utilData.checkAndClause(filters);
         String queryString = "WHERE TYPE !=?"
               + andCheck
               + utilData.prepareSearchStatementString(first, pageSize, sortField, sortOrder, filters, false);
         AccountTab.getResultSet(queryString, "WADRTPBANK");

         /**********************************************************************
          *
          * Selects all records from the table - no "WHERE" condition.
          * Both methods below are equal:
          *
          **********************************************************************/
         //AccountTab.getResultSet(null, (Object[])null);
         //AccountTab.getAllRecordsRs();

         /**********************************************************************
          *
          * Loop through database result set:
          *
          **********************************************************************/
         while (AccountTab.next()) {
            res.add(AccountTab.getTo());
            /**********************************************************************
             *
             * Print all values from the row in one line delimited by "; "
             *
             **********************************************************************/
            AccountTab.print("; ");

            /**********************************************************************
             *
             * Fetch data from the database into local variables:
             *
             **********************************************************************/

         }

      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot select from TABLE \"ACCOUNT\".");
         throw new GDAOException(e);
      } finally {
         AccountTab.releaseStatement();
      }

      log.debug("Finished select from TABLE \"ACCOUNT\".");
      return res;
   }
   public ArrayList<String> getUserList(Connection conn) throws GDAOException {
      ArrayList<String>  res= new ArrayList<>();
      log.debug("Starting select from TABLE \"ACCOUNT\".");

      java.math.BigDecimal walletAddressId = null;
      java.math.BigDecimal transactionId = null;
      java.lang.String addressName = null;
      java.lang.String isValid = null;
      java.lang.String pubkey = null;
      java.lang.String isCompressed = null;
      java.lang.String isScript = null;
      java.lang.String type = null;


      AccountTab accountTab = new AccountTab(conn);

      try {

         /**********************************************************************
          *
          * !IMPORTANT!:
          * Use the following parameters in order to speed up SELECT
          * and to prevent program from failing because of EXAUSTED MEMORY error:
          * java.lang.OutOfMemoryError: Java heap space
          *
          **********************************************************************/
         accountTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         accountTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

         /**********************************************************************
          *
          * Selects specific records from the table:
          * Limit number of rows selected to "100" (just an example)
          * Change "WHERE" condition to meet your needs.
          *
          **********************************************************************/
         accountTab.getResultSet("WHERE TYPE = ? OR TYPE = ? ", "WABANKUSER","WAFAMYUSER");

         /**********************************************************************
          *
          * Selects all records from the table - no "WHERE" condition.
          * Both methods below are equal:
          *
          **********************************************************************/
         //AccountTab.getResultSet(null, (Object[])null);
         //AccountTab.getAllRecordsRs();

         /**********************************************************************
          *
          * Loop through database result set:
          *
          **********************************************************************/
         while (accountTab.next()) {
            res.add(accountTab.getTo().getACCOUNT_ID());
            /**********************************************************************
             *
             * Print all values from the row in one line delimited by "; "
             *
             **********************************************************************/
            accountTab.print("; ");

            /**********************************************************************
             *
             * Fetch data from the database into local variables:
             *
             **********************************************************************/

         }

      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot select from TABLE \"ACCOUNT\".");
         throw new GDAOException(e);
      } finally {
         accountTab.releaseStatement();
      }

      log.debug("Finished select from TABLE \"ACCOUNT\".");
      return res;
   }

   public ArrayList<AccountTo> insertArrayOfAccounts(Connection connection, ArrayList<AccountTo> accounts) {

      ArrayList<AccountTo> result = new ArrayList<>();
      String whatWeAreDoing = "\"insertArrayOfUsersTo()\" for TABLE \"USERS\"";

      log.debug("Starting " + whatWeAreDoing);

      AccountTab accountTab = new AccountTab(connection);
      for (AccountTo accountForInsert : accounts) {
         try {
            accountTab.insert(accountForInsert);
            result.add(accountForInsert);
         } catch (GDAOException exception) {
            log.info("Account with ACCOUNT_ID: " + accountForInsert.getACCOUNT_ID() + " ,already exists into database.");
         }
      }
      try {
         accountTab.releaseStatement();
      } catch (GDAOException e) {
         log.error("Error on releaseStatement() on accountTab object.", e);
      }
      log.debug("Ending " + whatWeAreDoing);
      return result;
   }
   public AccountTo getAccountByAccountCode(Connection conn, String accountCode) throws GDAOException {
      AccountTo  res= null;
      log.debug("Starting select from TABLE \"ACCOUNT\".");

      java.math.BigDecimal walletAddressId = null;
      java.math.BigDecimal transactionId = null;
      java.lang.String addressName = null;
      java.lang.String isValid = null;
      java.lang.String pubkey = null;
      java.lang.String isCompressed = null;
      java.lang.String isScript = null;
      java.lang.String type = null;


      AccountTab AccountTab = new AccountTab(conn);

      try {

         /**********************************************************************
          *
          * !IMPORTANT!:
          * Use the following parameters in order to speed up SELECT
          * and to prevent program from failing because of EXAUSTED MEMORY error:
          * java.lang.OutOfMemoryError: Java heap space
          *
          **********************************************************************/
         AccountTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         AccountTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

         /**********************************************************************
          *
          * Selects specific records from the table:
          * Limit number of rows selected to "100" (just an example)
          * Change "WHERE" condition to meet your needs.
          *
          **********************************************************************/
         AccountTab.getResultSet("WHERE ACCOUNT_CODE = ? ", accountCode);

         /**********************************************************************
          *
          * Selects all records from the table - no "WHERE" condition.
          * Both methods below are equal:
          *
          **********************************************************************/
         //AccountTab.getResultSet(null, (Object[])null);
         //AccountTab.getAllRecordsRs();

         /**********************************************************************
          *
          * Loop through database result set:
          *
          **********************************************************************/
         if (AccountTab.next()) {
            res = AccountTab.getTo();
            /**********************************************************************
             *
             * Print all values from the row in one line delimited by "; "
             *
             **********************************************************************/
            AccountTab.print("; ");

            /**********************************************************************
             *
             * Fetch data from the database into local variables:
             *
             **********************************************************************/

         }

      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot select from TABLE \"ACCOUNT\".");
         throw new GDAOException(e);
      } finally {
         AccountTab.releaseStatement();
      }

      log.debug("Finished select from TABLE \"ACCOUNT\".");
      return res;
   }
   public ArrayList<AccountTo> getAccountListByAccountCodes(Connection conn, String unionString) throws GDAOException {
      ArrayList<AccountTo>  res=  new ArrayList<>();
      log.debug("Starting select from TABLE \"ACCOUNT\".");


      AccountTab accountTab = new AccountTab(conn);

      try {

         /**********************************************************************
          *
          * !IMPORTANT!:
          * Use the following parameters in order to speed up SELECT
          * and to prevent program from failing because of EXAUSTED MEMORY error:
          * java.lang.OutOfMemoryError: Java heap space
          *
          **********************************************************************/
         accountTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         accountTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

         /**********************************************************************
          *
          * Selects specific records from the table:
          * Limit number of rows selected to "100" (just an example)
          * Change "WHERE" condition to meet your needs.
          *
          **********************************************************************/
         accountTab.getResultSet("WHERE ACCOUNT_CODE IN "+unionString);

         /**********************************************************************
          *
          * Selects all records from the table - no "WHERE" condition.
          * Both methods below are equal:
          *
          **********************************************************************/
         //AccountTab.getResultSet(null, (Object[])null);
         //AccountTab.getAllRecordsRs();

         /**********************************************************************
          *
          * Loop through database result set:
          *
          **********************************************************************/
         while (accountTab.next()) {
            res.add(accountTab.getTo());
            /**********************************************************************
             *
             * Print all values from the row in one line delimited by "; "
             *
             **********************************************************************/
            accountTab.print("; ");

            /**********************************************************************
             *
             * Fetch data from the database into local variables:
             *
             **********************************************************************/

         }

      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot select from TABLE \"ACCOUNT\".");
         throw new GDAOException(e);
      } finally {
         accountTab.releaseStatement();
      }

      log.debug("Finished select from TABLE \"ACCOUNT\".");
      return res;
   }

   public List<AccountTo> getAllAccounts(Connection conn) throws GDAOException {
      ArrayList<AccountTo>  res=  new ArrayList<>();
      log.debug("Starting select from TABLE \"ACCOUNT\".");


      AccountTab accountTab = new AccountTab(conn);

      try {

         /**********************************************************************
          *
          * !IMPORTANT!:
          * Use the following parameters in order to speed up SELECT
          * and to prevent program from failing because of EXAUSTED MEMORY error:
          * java.lang.OutOfMemoryError: Java heap space
          *
          **********************************************************************/
         accountTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         accountTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

         /**********************************************************************
          *
          * Selects specific records from the table:
          * Limit number of rows selected to "100" (just an example)
          * Change "WHERE" condition to meet your needs.
          *
          **********************************************************************/
         accountTab.getAllRecordsRs();

         /**********************************************************************
          *
          * Selects all records from the table - no "WHERE" condition.
          * Both methods below are equal:
          *
          **********************************************************************/
         //AccountTab.getResultSet(null, (Object[])null);
         //AccountTab.getAllRecordsRs();

         /**********************************************************************
          *
          * Loop through database result set:
          *
          **********************************************************************/
         while (accountTab.next()) {
            res.add(accountTab.getTo());
            /**********************************************************************
             *
             * Print all values from the row in one line delimited by "; "
             *
             **********************************************************************/
            accountTab.print("; ");

            /**********************************************************************
             *
             * Fetch data from the database into local variables:
             *
             **********************************************************************/

         }

      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot select from TABLE \"ACCOUNT\".");
         throw new GDAOException(e);
      } finally {
         accountTab.releaseStatement();
      }

      log.debug("Finished select from TABLE \"ACCOUNT\".");
      return res;
   }

   public List<AccountTo> getBankAccounts(Connection conn, BigDecimal bankId) throws GDAOException {
      ArrayList<AccountTo>  res=  new ArrayList<>();
      log.debug("Starting select from TABLE \"ACCOUNT\".");


      AccountTab accountTab = new AccountTab(conn);

      try {

         /**********************************************************************
          *
          * !IMPORTANT!:
          * Use the following parameters in order to speed up SELECT
          * and to prevent program from failing because of EXAUSTED MEMORY error:
          * java.lang.OutOfMemoryError: Java heap space
          *
          **********************************************************************/
         accountTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         accountTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

         /**********************************************************************
          *
          * Selects specific records from the table:
          * Limit number of rows selected to "100" (just an example)
          * Change "WHERE" condition to meet your needs.
          *
          **********************************************************************/
         accountTab.getResultSet("WHERE BANK_ID = ? ", bankId);

         /**********************************************************************
          *
          * Selects all records from the table - no "WHERE" condition.
          * Both methods below are equal:
          *
          **********************************************************************/
         //AccountTab.getResultSet(null, (Object[])null);
         //AccountTab.getAllRecordsRs();

         /**********************************************************************
          *
          * Loop through database result set:
          *
          **********************************************************************/
         while (accountTab.next()) {
            res.add(accountTab.getTo());
            /**********************************************************************
             *
             * Print all values from the row in one line delimited by "; "
             *
             **********************************************************************/
            accountTab.print("; ");

            /**********************************************************************
             *
             * Fetch data from the database into local variables:
             *
             **********************************************************************/

         }

      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot select from TABLE \"ACCOUNT\".");
         throw new GDAOException(e);
      } finally {
         accountTab.releaseStatement();
      }

      log.debug("Finished select from TABLE \"ACCOUNT\".");
      return res;
   }
   public void updateByTo(Connection conn, AccountTo account) throws GDAOException {
      log.debug("Starting update from TABLE \"ACCOUNT\".");


      AccountTab accountTab = new AccountTab(conn);

      try {

         /**********************************************************************
          *
          * !IMPORTANT!:
          * Use the following parameters in order to speed up SELECT
          * and to prevent program from failing because of EXAUSTED MEMORY error:
          * java.lang.OutOfMemoryError: Java heap space
          *
          **********************************************************************/
         accountTab.setResultSetConcurrency(ResultSet.CONCUR_READ_ONLY);
         accountTab.setResultSetType(ResultSet.TYPE_FORWARD_ONLY);

         /**********************************************************************
          *
          * Selects specific records from the table:
          * Limit number of rows selected to "100" (just an example)
          * Change "WHERE" condition to meet your needs.
          *
          **********************************************************************/
         accountTab.updateRecordUsingTo(account);


      } catch (GDAOException e) {
         e.printStackTrace();
         log.error("Cannot update TABLE \"ACCOUNT\".");
         throw new GDAOException(e);
      } finally {
         accountTab.releaseStatement();
      }	       
      log.debug("Finished update TABLE \"ACCOUNT\".");
   }
}
