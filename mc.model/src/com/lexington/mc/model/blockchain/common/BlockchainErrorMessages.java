package com.lexington.mc.model.blockchain.common;

public class BlockchainErrorMessages {

   public class Streams {
      public static final String STREAM_NOT_FOUND = "Stream with this name not found";
      public static final String UNSPENT_OUTPUTS = "No unspent outputs are available. Please send a transaction, with zero amount, to this node or address first and wait for its confirmation.";
   }
   public class PrivateKeys {
      public static final String INVALID_PRIVATE_KEY = "Invalid private key";
      public static final String NON_STANDARD_TRANSACTION = "Nonstandard transaction input";
   }

}
