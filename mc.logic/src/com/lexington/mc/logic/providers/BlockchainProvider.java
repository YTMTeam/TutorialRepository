//package com.lexington.mc.logic.providers;
//
//import java.util.ArrayList;
//
//import org.apache.log4j.Logger;
//
//import com.google.gson.Gson;
//import com.lexington.mc.logic.blockchain.common.BlockchainConnection;
//import com.lexington.mc.logic.blockchain.common.Constants;
//import com.lexington.mc.logic.blockchain.exception.BlockchainClientException;
//import com.lexington.mc.logic.blockchain.pojos.StreamKeyItemsPojo;
//import com.lexington.mc.logic.blockchain.streamPojos.StreamDataWrapper;
//import com.lexington.mc.logic.blockchain.util.EncryptionManager;
//import com.lexington.mc.logic.blockchain.util.HexConverter;
//import com.lexington.mc.logic.util.MessageException;
//import com.lexington.mc.model.tables.DataAsset;
//import com.lexington.mc.model.tables.DataAccount;
//
//public class BlockchainProvider extends BlockchainConnection {
//	
//	
//
//	public BlockchainProvider() throws MessageException {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//
//	final static Logger log = Logger.getLogger(DataAsset.class.getName());
//	DataAccount dataWalletAddress = new DataAccount();
//	DataAsset  		  dataAsset 		= new DataAsset();
//
//
//	/**
//	 * This method fetches all keys from stream named as a bank that is logging in. Then, it tries to decrypt contents of a stream using private key.
//	 * If it succeeds, then validation is ok, in other case it is not.
//	 * @param bankName
//	 * @param privateKey
//	 * @return
//	 */
//	public boolean validateLoginCredentials(String bankName, String privateKey) throws MessageException {
//		
//		try {
//		ArrayList<StreamKeyItemsPojo> keys = blockchainClient.listStreamKeyItems(bankName, Constants.StreamKeys.ENCRYPTION_KEY);
//		
//		//when we fetch all keys, we try to decrypt first key with bank's inserted key
//		if(!keys.isEmpty()) {
//			//get Json String from Hex
//			String fromHex = new HexConverter().convertFromHex(keys.get(0).getData());
//			//convert Wrapper class from Hex
//			StreamDataWrapper sData = new Gson().fromJson(fromHex, StreamDataWrapper.class);
//			
//			String jsonString;
//
//			/** Decrypting StreamKeyItem with private key **/
//			try {
//				jsonString = EncryptionManager.decrypt(sData.getData(), privateKey);
//			} catch(Exception e) {
//			throw new MessageException("privateKeyError");
//			}
//		} else {
//		 throw new MessageException("noKeyAttachedToBank");
//		}
//		
//		} catch(BlockchainClientException e) {
//		throw new MessageException(e.getMessage());
//		}
//		log.info("Login successful.");
//		System.out.println("Login successful.");
//		return true;
//	}
//	
//	public static void main(String[] args) throws MessageException {
//		BlockchainProvider bProv = new BlockchainProvider();
//		bProv.validateLoginCredentials("SCOTIA", "thisisasecretsco" );
//	}
//}
