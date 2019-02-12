package com.imalvisc.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JsonUtils {

    public static String toJsonString(Object obj) {
        return JSON.toJSONString(obj);
    }

    public static JSONObject parseToObject(String text) {
        return JSON.parseObject(text);
    }

    public static JSONArray parseToArray(String text) {
        return JSON.parseArray(text);
    }

    public static <T> T parseToObject(Object obj, Class<T> clazz) {
        if (obj instanceof String) {
            return JSON.parseObject(obj.toString(), clazz);
        }
        return JSON.parseObject(toJsonString(obj), clazz);
    }

}
