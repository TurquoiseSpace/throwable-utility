package com.TurquoiseSpace.utility;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import com.TurquoiseSpace.constant.ThrowableConstants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonUtil {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	private static void configureObjectMapper() {
		OBJECT_MAPPER.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		OBJECT_MAPPER.configure(SerializationConfig.Feature.WRITE_NULL_PROPERTIES, false);
	}

	static {
		configureObjectMapper();
	}

	public static <T> String convertObjectToJson(T object) {
		log.trace("convert object to json -> (className) {} (object) {}", object.getClass().getName(), object);
		try {
			return OBJECT_MAPPER.writeValueAsString(object);
		} catch (Exception exception) {
			log.error(ThrowableConstants.THROWABLE_ENCOUNTERED, exception.getClass().getName(), exception.getMessage(), exception);
		}
		return null;
	}

	public static <T> T convertJsonToObject(String json, Class<T> clazz) {
		log.trace("convert json to object -> (className) {} (json) {}", clazz.getName(), json);
		try {
			return OBJECT_MAPPER.readValue(json, clazz);
		} catch (Exception exception) {
			log.error(ThrowableConstants.THROWABLE_ENCOUNTERED, exception.getClass().getName(), exception.getMessage(), exception);
		}
		return null;
	}

}
