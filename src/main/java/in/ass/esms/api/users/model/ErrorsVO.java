package in.ass.esms.api.users.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ErrorsVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ErrorVO> errors;
	
	public ErrorsVO() {
		
	}

	public ErrorsVO(String functional, String code, String description) {
		
		this.errors = new ArrayList<>();
		this.errors . add(new ErrorVO(functional,code,description));
	}

	public List<ErrorVO> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorVO> errors) {
		this.errors = errors;
	}

	
}
