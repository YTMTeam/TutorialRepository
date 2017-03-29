package com.lexington.mc.model.singletons.connection;

import com.lexington.mc.model.blockchain.common.BlockchainClient;

public class BlockchainConnection {

	private static BlockchainClient blockchainClient;
	
	public static BlockchainClient getClient() {
		
		if(blockchainClient == null) {
			blockchainClient = new BlockchainClient();
		}
		
		return blockchainClient;
	}
	

}
