package com.TurquoiseSpace.model;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class GenericException implements Serializable {

	private static final long serialVersionUID = 1;

	private Map<Integer, ExceptionPoint> exceptionTraceHeirarchy;

	private ExceptionMeta exceptionMeta;

	private void addTraceHeirarchy(int index, StackTraceElement stackTraceElement) {
		ExceptionPoint exceptionPoint = null;
		try {
			exceptionPoint = new ExceptionPoint(stackTraceElement);
		} catch (RuntimeException runtimeException) {
			log.error("encountered RuntimeException", runtimeException);
		}
		this.exceptionTraceHeirarchy.put(index, exceptionPoint);
	}

	protected void setTraceHeirarchy(StackTraceElement[] stackTraceElements) {
		this.exceptionTraceHeirarchy = new TreeMap<Integer, ExceptionPoint>();
		if (null == stackTraceElements) {
			return;
		}
		for (int index = 0; index < stackTraceElements.length; index++) {
			StackTraceElement stackTraceElement = stackTraceElements[index];
			this.addTraceHeirarchy(index, stackTraceElement);
		}
	}

	protected void setMeta(String classType, String message, Throwable cause) {
		this.exceptionMeta = new ExceptionMeta(classType, message, cause);
	}

	public GenericException() {

	}

	public GenericException(Throwable throwable) throws RuntimeException {
		if (null == throwable) {
			throw new RuntimeException("Throwable cannot be null");
		}
		this.setMeta(throwable.getClass().getName(), throwable.getMessage(), throwable.getCause());
		this.setTraceHeirarchy(throwable.getStackTrace());
	}

	public GenericException(Throwable throwable, String customMessage) throws RuntimeException {
		this(throwable);
		this.exceptionMeta.setCustomMessage(customMessage);
	}

}
