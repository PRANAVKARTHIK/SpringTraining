package com.learning.utilityclasses;

public class ValidResponse {

	String status;
	Object data;
	String message;
	
	public ValidResponse(String string, Object object, String string2) {
		this.status=string;
		this.data=object;
		this.message=string2;
	}
	
	public ValidResponse() {
		super();
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
