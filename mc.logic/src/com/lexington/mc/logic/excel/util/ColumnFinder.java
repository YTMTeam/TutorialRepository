package com.lexington.mc.logic.excel.util;

public class ColumnFinder {

   public class Account {
      public static final String ACCOUNT_NUMBER = "ACCOUNT NUMBER*";
      public static final String BROKER_CODE   = "BROKER CODE*";
      public static final String FIRST_NAME   = "FIRST NAME*";
      public static final String MIDDLE_NAME   = "MIDDLE NAME";
      public static final String LAST_NAME    = "LAST NAME*";
      public static final String MANAGED_ACCOUNT = "MANAGED ACCOUNT*";
      public static final String ACCOUNT_TYPE = "ACCOUNT TYPE*";
      public static final String ACCOUNT_STATUS = "ACCOUNT STATUS*";
      public static final String REQUESTING_INSTITUTION = "REQUESTING INSTITUTION";
   }

   public class Trade {
      public static final String TRANSACTION_ID      = "TRANSACTION ID*";
      public static final String TRANSACTION_TYPE      = "TRANSACTION TYPE*";
      public static final String QUANTITY          = "QUANTITY*";
      public static final String BROKER_CODE          = "BROKER CODE*";      
      public static final String SECURITY_SYMBOL      = "SECURITY SYMBOL*";
      public static final String SECURITY_NAME      = "SECURITY NAME*";
      public static final String SECURITY_TYPE      = "SECURITY TYPE*";
      public static final String EXCHANGE           = "EXCHANGE*";
      public static final String BROKER_ID         = "BROKER ID*";
      public static final String ACCOUNT_NUMBER      = "ACCOUNT NUMBER*";
      public static final String ACCOUNT_FIRST_NAME      = "ACCOUNT FIRST NAME*";
      public static final String ACCOUNT_MIDDLE_NAME      = "ACCOUNT MIDDLE NAME";
      public static final String ACCOUNT_LAST_NAME      = "ACCOUNT LAST NAME*";
      public static final String TRADE_DATE        = "TRADE DATE*";
      public static final String EXECUTION_PRICE        = "EXECUTION PRICE*";
      public static final String DATA_AS_OF        = "DATA AS OF*";
      public static final String CUSIP            = "CUSIP";
      public static final String ISIN       = "ISIN";
      public static final String SEDOL       = "SEDOL";
      public static final String NET_AMOUNT = "NET AMOUNT*";
      public static final String CURRENCY          = "CURRENCY*";
   }

   public class Position {
      public static final String ACCOUNT_NUMBER  = "ACCOUNT NUMBER*";
      public static final String BANK_ID  = "BANK ID*";
      public static final String BROKER_CODE  = "BROKER CODE*";
      public static final String SECURITY_SYMBOL  = "SECURITY SYMBOL*";
      public static final String CUSIP  = "CUSIP";
      public static final String ISIN  = "ISIN";
      public static final String SEDOL   = "SEDOL";
      public static final String CURRENCY = "CURRENCY*";
      public static final String EXPIRATION_DATE = "EXPIRATION DATE";
      public static final String EXECUTION_PRICE = "EXECUTION PRICE*";
      public static final String MARKET_PRICE = "MARKET PRICE*";
      public static final String QUANTITY = "QUANTITY*";
      public static final String SECURITY_DATE = "SECURITY DATE*";

   }

   public class Employee {
      public static final String EMPLOYEE_NUMBER  = "EMPLOYEE NUMBER*";
      public static final String EMPLOYEE_FIRST_NAME   = "EMPLOYEE FIRST NAME*";
      public static final String EMPLOYEE_MIDDLE_NAME   = "EMPLOYEE MIDDLE NAME";
      public static final String EMPLOYEE_LAST_NAME   = "EMPLOYEE LAST NAME*";      
      public static final String EMPLOYING_INSTITUTION   = "EMPLOYING INSTITUTION*";      
   }

   public class Monitor {
      public static final String ACCOUNT_NUMBER   = "ACCOUNT NUMBER*";      
      public static final String ACCOUNT_FIRST_NAME   = "ACCOUNT FIRST NAME*";      
      public static final String ACCOUNT_MIDDLE_NAME   = "ACCOUNT MIDDLE NAME";      
      public static final String ACCOUNT_LAST_NAME   = "ACCOUNT LAST NAME*";      
      public static final String RELATIONSHIP   = "RELATIONSHIP*";      
      public static final String ACCOUNT_BANK_CODE   = "ACCOUNT BANK CODE*";      
      public static final String BROKER_DEALER   = "BROKER DEALER*";      
      public static final String AS_OF_DATE   = "AS OF DATE*";      
      public static final String END_DATE   = "END DATE";      
      public static final String BROKER_CODE   = "BROKER CODE*";      

   }
}
