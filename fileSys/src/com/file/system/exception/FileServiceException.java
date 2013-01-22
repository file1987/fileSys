package com.file.system.exception;

public class FileServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FileServiceException(){
		super();
	}
	
	public FileServiceException(String message) {
			super(message);
	}
	
	public FileServiceException(String message, Throwable cause) {
	     super(message, cause);
	 }
	 
	public FileServiceException(Throwable cause) {
	        super(cause);
	 }

}
