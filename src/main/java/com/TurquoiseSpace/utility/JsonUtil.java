package com.TurquoiseSpace.utility;

import com.TurquoiseSpace.constant.ExceptionConstants;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonUtil {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	private static void configureObjectMapper() {
		OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		OBJECT_MAPPER.setSerializationInclusion(Include.NON_NULL);
	}

	static {
		configureObjectMapper();
	}

	public static <T> String convertObjectToJson(T object) {
		log.trace("convert object to json -> (className) {} (object) {}", object.getClass().getName(), object);
		try {
			return OBJECT_MAPPER.writeValueAsString(object);
		} catch (Exception exception) {
			log.error(ExceptionConstants.EXCEPTION_ENCOUNTERED, exception.getClass().getName(), exception.getMessage(), exception);
		}
		return null;
	}

	public static <T> T convertJsonToObject(String json, Class<T> clazz) {
		log.trace("convert json to object -> (className) {} (json) {}", clazz.getName(), json);
		try {
			return OBJECT_MAPPER.readValue(json, clazz);
		} catch (Exception exception) {
			log.error(ExceptionConstants.EXCEPTION_ENCOUNTERED, exception.getClass().getName(), exception.getMessage(), exception);
		}
		return null;
	}

	public static <T> T convertJsonToObject(String json, TypeReference<T> typeReference) {
		log.trace("convert json to object -> (typeName) {} (json) {}", typeReference.getType().getTypeName(), json);
		try {
			return OBJECT_MAPPER.readValue(json, typeReference);
		} catch (Exception exception) {
			log.error(ExceptionConstants.EXCEPTION_ENCOUNTERED, exception.getClass().getName(), exception.getMessage(), exception);
		}
		return null;
	}

}
