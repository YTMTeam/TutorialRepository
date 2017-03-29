package com.lexington.mc.model.blockchain.common;

import java.math.BigDecimal;

public class BlockchainConstants {

	public class General {
	    public static final int EMPTY_ROW_COUNTER_CUT = 5;
		public static final int TIMEOUT = 60;
		public static final String KEY = "thisisasecretkey";
		public static final String APPENDER = "-";
		public static final String EMPLOYEE_SUFFIX = "EMP";
	}
	public class TransactionTypeConstants {
		public static final String ISSUE = "ISSUE";
		public static final String TRANSFER = "TRANSFER";
		public static final String PERMISSION = "PERMISSION";
		public static final String NULLDATA = "NULLDATA";
	}
	public class GrantTypeConstants {
		public static final String BANK = "WADRTPBANK";
		public static final String USER = "WADRTPUSER";

		public static final String BANK_USER = "WABANKUSER";
		public static final String FAMILY_USER = "WAFAMYUSER";


	}
	public class PermissionTypeConstants {
		public static final String CREATE_FAMILY_USER = "CREATE_WORK_USER";
		public static final String CREATE_BANK_USER = "CREATE_BANK_USER";
		public static final String ADD_GROUP_MEMBER = "ADD_MEMBER";
		public static final String REMOVE_GROUP_MEMBER = "REMOVE_MEMBER";

	}
	public class StockTypeConstants {
		public static final String INIT = "INITIAL";
		public static final String STANDARD = "STANDARD";
	}
	public class StockStatusConstants {
		public static final String FILLED = "EXECUTED";
		public static final String PARTIALLY_FILLED = "PARTIALLY_FILLED";
		public static final String CANCELED = "CANCELED";

	}
	public class DirectionStatus {
		public static final String BUY = "BUY";
		public static final String SELL = "SELL";
		public static final String ISSUE = "ISSUE";
	} 

	public class AssignedTo {
		public static final String SCOTIA = "SCOTIA";
		public static final String TD = "TD";
		public static final String RBC = "RBC";
		public static final String ALL = "ALL";
	}

    public class StreamTypes {
       public static final String CREATE_BANK = "CREATE_BANK";
       public static final String CREATE_EMPLOYEE = "EMPLOYEE";
       public static final String CREATE_ACCOUNT = "CREATE_ACCOUNT";
       public static final String CREATE_REQUEST_FILE = "CREATE_REQUEST_FILE";
       public static final String SEND_ASSET = "SEND_ASSET";
       public static final String CREATE_ASSET = "CREATE_ASSET";
       public static final String CREATE_TRADE = "CREATE_TRADE";
       public static final String NONE = "NONE";
       public static final String ENCRYPTION_KEY = "ENCRYPTION_KEY";
       public static final String HOUSEHOLD = "HOUSEHOLD";
       public static final String MONITOR = "MONITOR";
       public static final String CREATE_POSITION = "CREATE_POSITION";
       public static final String CREATE_USER = "CREATE_USER";
       public static final String LOGIN_CREDENTIALS = "LOGIN_CREDENTIALS";
       public static final String CREATE_KEY_PAIR = "CREATE_KEY_PAIR";
       public static final String CREATE_PERMISSION = "CREATE_PERMISSION";
  
   }

    public class StreamNames {
       public static final String MAIN_STREAM = "MAIN_STREAM";
       public static final String ACCOUNTS = "ACCOUNTS";
       public static final String BANKS = "BANKS";
       public static final String POSITIONS = "POSITIONS";
       public static final String EMPLOYEES = "EMPLOYEES";
       public static final String TRADES = "TRADES";
       public static final String MONITORS = "MONITORS";
       public static final String USERS = "USERS";
       public static final String LOG_IN = "LOGINS";
       public static final String PRIVATE_KEY = "PRIVATE_KEY";
       public static final String PERMISSION = "PERMISSIONS";
   }
	
//    public class NodeConstants {
//        public static final String RPC_HOST = "192.99.24.209";
//        public static final int RPC_PORT = 4338;
//        public static final String RPC_USERNAME = "multichainrpc";
//        public static final String RPC_PASSWORD = "8ujuqv3GtB7cpuBV9KzexGvMX1W95ACK8G6heqUG199P";
//     }
	
    public class NodeConstants {
        public static final String RPC_HOST = "192.168.1.235";
        public static final int RPC_PORT = 8338;
        public static final String RPC_USERNAME = "multichainrpc";
        public static final String RPC_PASSWORD = "6Wd1raZU7kCViBBTSJ2Hzmc5qWxNRfsQJSmbgChBY7UT";
     }
	public class DataProviderStatus {
	   public static final String BUSY = "BUSY";
	   public static final String FINISHED = "FREE";
	}
}
