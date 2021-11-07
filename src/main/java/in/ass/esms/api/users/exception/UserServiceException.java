package in.ass.esms.api.users.exception;

import in.ass.esms.api.users.enums.ErrorCodes;

public class UserServiceException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private ErrorCodes errorCode;
	
	
	public UserServiceException(String message) {
		this.message = message;
	}
	public UserServiceException( ErrorCodes errorCode) {
		this.errorCode = errorCode;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ErrorCodes getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(ErrorCodes errorCode) {
		this.errorCode = errorCode;
	}
	
	

}
