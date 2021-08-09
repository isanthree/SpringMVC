package org.example.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

public class JsonUtils {

	public static String getJson(Object object) {
		return getJson(object, "yyyy-MM-dd HH:mm:ss");
	}

	public static String getJson(Object object, String dataFormat) {
		ObjectMapper objectMapper = new ObjectMapper();
		// 不使用时间戳方式
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		// 自定义日期格式 yyyy-MM-dd HH:mm:ss
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dataFormat);
		objectMapper.setDateFormat(simpleDateFormat);

		try {
			return objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return null;
	}
}
