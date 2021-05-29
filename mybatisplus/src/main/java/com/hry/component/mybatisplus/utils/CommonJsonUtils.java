package com.hry.component.mybatisplus.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CommonJsonUtils {
	private static final ThreadLocal<Gson> gsonThreadLocal = new ThreadLocal<Gson>(){
        @Override
        protected Gson initialValue() {
            Gson gson = new GsonBuilder().create();
            return gson;
        }
    };

	/**
	 * 对象转换json
	 * @param object
	 * @return
	 */
	public static <T> String toJsonString(Object object) {
		if (object == null) {
			return null;
		}
		return gsonThreadLocal.get().toJson(object);
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
		return gsonThreadLocal.get().fromJson(json, clazz);
	}
}
