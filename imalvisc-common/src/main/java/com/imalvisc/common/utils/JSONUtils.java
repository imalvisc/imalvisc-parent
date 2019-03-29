package com.imalvisc.common.utils;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName JSONUtils
 * @Description JSON工具类
 * @motto 学会编程而不是学会编码！
 * @date 2019-03-29 10:44
 */
public class JSONUtils {

    /**
     * 转换为JSON字符串
     * @param obj
     * @return
     */
    public static String toJsonStr(Object obj) {
        return JSONUtil.toJsonStr(obj);
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
        return JSON.parseObject(toJsonStr(obj), clazz);
    }

}
