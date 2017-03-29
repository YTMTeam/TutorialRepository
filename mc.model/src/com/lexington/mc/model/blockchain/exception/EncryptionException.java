package com.lexington.mc.model.blockchain.exception;



public class EncryptionException extends Exception {
	public EncryptionException() {
	}

	public EncryptionException(String msg) {
		super(msg);
	}

	public EncryptionException(Throwable cause) {
		super(cause);
	}

	public EncryptionException(String message, Throwable cause) {
		super(message, cause);
	}

}
