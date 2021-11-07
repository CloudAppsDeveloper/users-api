package in.ass.esms.api.users.enums;

import static in.ass.esms.api.users.constants.Constants.TECHNICAL;

public enum ErrorCodes {
	
	TECH_ERROR(TECHNICAL,"2000001","Technical error occured");

	private String type;
	private String code;
	private String message;
	
	private ErrorCodes() {
		
	}
	
	private ErrorCodes(String type, String code, String message) {
		this.type = type;
		this.code = code;
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
	
	
}
