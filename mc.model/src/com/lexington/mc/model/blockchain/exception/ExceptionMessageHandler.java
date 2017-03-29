package com.lexington.mc.model.blockchain.exception;

public class ExceptionMessageHandler {

	public static String handleBlockchainClientMessage(String clientMessage) {

		if(clientMessage.contains("refused")) {
			return "blockchainConnRefused";
		}
		if(clientMessage.contains("Stream with this name not found")) {
			return "invalidBankname";
		}
		return "somethingWentWrong";
	}
}
