package com.learn.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class EmailIdAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String resource;
	private String field;
	private Object value;
	public EmailIdAlreadyExistsException(String resource, String field, Object value) {
		super(String.format("%s with %s :'%s' already exists", resource,field,value));
		this.resource = resource;
		this.field = field;
		this.value = value;
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
	
	
}
