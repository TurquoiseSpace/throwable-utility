package com.TurquoiseSpace.utility;

import com.TurquoiseSpace.model.GenericException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExceptionLogUtil {

	private static GenericException getGenericException(Exception e, String customMessage) {
		if (null != customMessage && !customMessage.trim().isEmpty()) {
			return new GenericException(e, customMessage);
		} else {
			return new GenericException(e);
		}
	}

	public static String getLocalizedExceptionJson(Exception e, String customMessage) {
		GenericException genericException = getGenericException(e, customMessage);
		return JsonUtil.convertObjectToJson(genericException);
	}

	public static String getLocalizedExceptionJson(Exception e) {
		return getLocalizedExceptionJson(e, null);
	}

	public static void logException(Exception e, String customMessage) {
		String exceptionJson = getLocalizedExceptionJson(e, customMessage);
		log.error(exceptionJson);
	}

	public static void logException(Exception e) {
		logException(e, null);
	}

}
