package com.TurquoiseSpace.utility;

import com.TurquoiseSpace.constant.ThrowableConstants;
import com.TurquoiseSpace.model.GenericException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExceptionLogUtil {

	private static GenericException makeGenericException(Exception e, String customMessage) {
		if (null == customMessage || customMessage.trim().isEmpty()) {
			return new GenericException(e);
		} else {
			return new GenericException(e, customMessage);
		}
	}

	public static String getExceptionJson(Exception e, String customMessage) {
		GenericException genericException = makeGenericException(e, customMessage);
		String exceptionJson = JsonUtil.convertObjectToJson(genericException);
		log.debug(ThrowableConstants.THROWABLE_PARSED, exceptionJson);
		return exceptionJson;
	}

	public static String getExceptionJson(Exception e) {
		return getExceptionJson(e, null);
	}

	public static void logException(Exception e, String customMessage) {
		String exceptionJson = getExceptionJson(e, customMessage);
		log.error(exceptionJson);
	}

	public static void logException(Exception e) {
		logException(e, null);
	}

}
