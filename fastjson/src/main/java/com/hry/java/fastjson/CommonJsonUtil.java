package com.hry.java.fastjson;

import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;

public class CommonJsonUtil {
	public static SerializeConfig mapping = new SerializeConfig();
	static {
		mapping.put(Date.class, new SimpleDateFormatSerializer(
				"yyyy-MM-dd HH:mm:ss"));
	}
	
	/**
	 * 对象转换json
	 * @param object
	 * @return
	 */
	public static <T> String toJsonString(Object object) {
		if (object == null) {
			return null;
		}
		return JSON.toJSONString(object, mapping);
	}

	/**
	 * json转对象
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T> T parseObject(String json, Class<T> clazz) {
		if (json == null || json.trim().length() == 0) {
			return null;
		}
		return JSON.parseObject(json, clazz);
	}
}
