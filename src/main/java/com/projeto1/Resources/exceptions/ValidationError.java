package com.projeto1.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> errors = new ArrayList<>();
	
	public ValidationError(Integer status, String msg, long timeStamp) {
		super(status, msg, timeStamp);
		
	}

	public List<FieldMessage> getErors() {
		return errors;
	}

	public void addError(String fieldName, String message) {
		errors.add(new FieldMessage(fieldName, message ));
	}


	
	

}
