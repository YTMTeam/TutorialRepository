package com.lexington.mc.model.blockchain.exception;



public class HttpSessionException extends RuntimeException {
	public HttpSessionException() {
	}

	public HttpSessionException(String msg) {
		super(msg);
	}

	public HttpSessionException(Throwable cause) {
		super(cause);
	}

	public HttpSessionException(String message, Throwable cause) {
		super(message, cause);
	}
}
