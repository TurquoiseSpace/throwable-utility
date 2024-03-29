package com.TurquoiseSpace.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class ExceptionMeta implements Serializable {

	private static final long serialVersionUID = 1;

	private String classType;
	private String message;
	private String customMessage;
	private GenericException cause;

	public ExceptionMeta() {

	}

	public ExceptionMeta(String classType, String message, Throwable cause) {
		this.classType = classType;
		this.message = message;
		if (null != cause) {
			this.cause = new GenericException(cause);
		}
	}

}
