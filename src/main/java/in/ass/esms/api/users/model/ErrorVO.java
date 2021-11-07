package in.ass.esms.api.users.model;

public class ErrorVO {
	
	private String type=null;
	private String code=null;
	private String message=null;
	

	public ErrorVO() {
		super();
	}

	public ErrorVO(String type, String code, String message) {
	}
	
	public ErrorVO( String code, String message) {
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
