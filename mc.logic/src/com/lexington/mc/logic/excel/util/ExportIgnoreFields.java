package com.lexington.mc.logic.excel.util;

import java.util.ArrayList;

public class ExportIgnoreFields {

   public static class Accounts {
      public static final ArrayList<String> ACCOUNTS_IGNORE_LIST = new ArrayList<>();
      
      static {
         ACCOUNTS_IGNORE_LIST.add("ACCOUNT_ID");
         ACCOUNTS_IGNORE_LIST.add("HOUSEHOLD_ID");
         ACCOUNTS_IGNORE_LIST.add("BANK_ID");
         ACCOUNTS_IGNORE_LIST.add("EMPLOYEE_ID");
      }
   }
   public static class Trades {
      public static final ArrayList<String> TRADES_IGNORE_LIST = new ArrayList<>();
      
      static {
         TRADES_IGNORE_LIST.add("TRADE_ID");
         TRADES_IGNORE_LIST.add("ACCOUNT_ID");
         TRADES_IGNORE_LIST.add("BANK_ID");
         TRADES_IGNORE_LIST.add("HOUSEHOLD_ID");
      }
   }
   public static class Monitors {
      public static final ArrayList<String> MONITORS_IGNORE_LIST = new ArrayList<>();
      
      static {
         MONITORS_IGNORE_LIST.add("MONITOR_ID");
         MONITORS_IGNORE_LIST.add("ACCOUNT_ID");
         MONITORS_IGNORE_LIST.add("MONITOR_BANK_ID");
         MONITORS_IGNORE_LIST.add("ACCOUNT_BANK_ID");
         MONITORS_IGNORE_LIST.add("EMPLOYEE_ID");
      }
   }
   public static class Employee {
      public static final ArrayList<String> EMPLOYEE_IGNORE_LIST = new ArrayList<>();
      
      static {
         EMPLOYEE_IGNORE_LIST.add("EMPLOYEE_ID");
      }
   }
   public static class Positions {
      public static final ArrayList<String> POSITIONS_IGNORE_LIST = new ArrayList<>();
      
      static {
         POSITIONS_IGNORE_LIST.add("ACCOUNT_ID");
         POSITIONS_IGNORE_LIST.add("BANK_ID");
      }
   }
   
}
