package com.TurquoiseSpace.utility;

import org.springframework.stereotype.Component;

import com.TurquoiseSpace.GenericException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ExceptionLogUtil {

	JsonUtil<GenericException> jsonUtil = new JsonUtil<GenericException>();

	public ExceptionLogUtil() {

	}

	private GenericException getGenericException(Exception e, String customMessage) {
		if (null != customMessage && !customMessage.trim().isEmpty()) {
			return new GenericException(e, customMessage);
		} else {
			return new GenericException(e);
		}
	}

	public void logException(Exception e, String customMessage) {
		log.error(jsonUtil.convertObjectToJson(getGenericException(e, customMessage)));
	}

	public void logException(Exception e) {
		logException(e, null);
	}

	public String getLocalizedExceptionJson(Exception e, String customMessage) {
		return jsonUtil.convertObjectToJson(getGenericException(e, customMessage));
	}

	public String getLocalizedExceptionJson(Exception e) {
		return getLocalizedExceptionJson(e, null);
	}

}
