package com.TurquoiseSpace.utility;

import com.TurquoiseSpace.constant.ExceptionConstants;
import com.TurquoiseSpace.model.GenericException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExceptionLogUtil {

	private static GenericException makeGenericException(Exception exception, String customMessage) {
		if (null == customMessage || customMessage.trim().isEmpty()) {
			return new GenericException(exception);
		} else {
			return new GenericException(exception, customMessage);
		}
	}

	public static String getExceptionJson(Exception exception, String customMessage) {
		log.debug(ExceptionConstants.EXCEPTION_ENCOUNTERED, exception.getClass().getName(), exception.getMessage(), exception);
		GenericException genericException = makeGenericException(exception, customMessage);
		return JsonUtil.convertObjectToJson(genericException);
	}

	public static String getExceptionJson(Exception exception) {
		return getExceptionJson(exception, null);
	}

	public static void logException(Exception exception, String customMessage) {
		String exceptionJson = getExceptionJson(exception, customMessage);
		log.error(ExceptionConstants.EXCEPTION_PARSED, exceptionJson);
	}

	public static void logException(Exception exception) {
		logException(exception, null);
	}

}
