package com.lexington.mc.model.blockchain.exception;



public class BlockchainClientException extends RuntimeException {
	public BlockchainClientException() {
	}

	public BlockchainClientException(String msg) {
		super(msg);
	}

	public BlockchainClientException(Throwable cause) {
		super(cause);
	}

	public BlockchainClientException(String message, Throwable cause) {
		super(message, cause);
	}

}
