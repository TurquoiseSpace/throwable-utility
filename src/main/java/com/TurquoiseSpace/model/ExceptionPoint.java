package com.TurquoiseSpace.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class ExceptionPoint implements Serializable {

	private static final long serialVersionUID = 1;

	private String fileName;
	private String className;
	private String methodName;
	private int lineNumber;
	private boolean nativeMethod;

	public ExceptionPoint() {

	}

	public ExceptionPoint(StackTraceElement stackTraceElement) throws RuntimeException {
		if (null == stackTraceElement) {
			throw new RuntimeException("StackTraceElement cannot be null");
		}
		this.fileName = stackTraceElement.getFileName();
		this.className = stackTraceElement.getClassName();
		this.methodName = stackTraceElement.getMethodName();
		this.lineNumber = stackTraceElement.getLineNumber();
		this.nativeMethod = stackTraceElement.isNativeMethod();
	}

}
