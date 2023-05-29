package com.TurquoiseSpace.utility;

import com.TurquoiseSpace.constant.ThrowableConstants;
import com.TurquoiseSpace.model.GenericException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThrowableLogUtil {

	private static GenericException makeGenericException(Throwable throwable, String customMessage) {
		if (null == customMessage || customMessage.trim().isEmpty()) {
			return new GenericException(throwable);
		} else {
			return new GenericException(throwable, customMessage);
		}
	}

	public static String getThrowableJson(Throwable throwable, String customMessage) {
		log.debug(ThrowableConstants.THROWABLE_ENCOUNTERED, throwable.getClass().getName(), throwable.getMessage(), throwable);
		GenericException genericException = makeGenericException(throwable, customMessage);
		return JsonUtil.convertObjectToJson(genericException);
	}

	public static String getThrowableJson(Throwable throwable) {
		return getThrowableJson(throwable, null);
	}

	public static void logThrowable(Throwable throwable, String customMessage) {
		String throwableJson = getThrowableJson(throwable, customMessage);
		log.error(ThrowableConstants.THROWABLE_PARSED, throwableJson);
	}

	public static void logThrowable(Throwable throwable) {
		logThrowable(throwable, null);
	}

}
