package org.worldbuild.project.modal;

public class Response<T> {
	
	
	private int code=200;
	private String message="OK";
	private T data;
	
	public Response(int code,String message) {
		super();
		this.code = code;
		this.message = message;
	}
	public Response(T data) {
		super();
		this.data = data;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	

}
