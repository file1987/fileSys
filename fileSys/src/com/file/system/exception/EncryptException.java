package com.file.system.exception;

public class EncryptException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EncryptException(){
		super();
	}
	
	public EncryptException(String message) {
			super(message);
	}
	
	public EncryptException(String message, Throwable cause) {
	     super(message, cause);
	 }
	 
	public EncryptException(Throwable cause) {
	        super(cause);
	 }

}
