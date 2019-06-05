package com.imalvisc.framework.apollo.utils;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName ApolloUtils
 * @Description Apollo工具类
 * @motto 学会编程而不是学会编码！
 * @date 2019-06-04 23:30
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
public class ApolloUtils {

    /**
     * 默认命名空间
     */
    private static final String DEFAULT_NAMESPACE = "application";

    /**
     * 获取配置属性, 指定命名空间和默认值
     *
     * @param namespace
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getProperty(String namespace, String key, String defaultValue) {
        Config config = ConfigService.getConfig(namespace);
        return config.getProperty(key, defaultValue);
    }

    /**
     * 获取配置属性, 指定默认值
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getProperty(String key, String defaultValue) {
        return getProperty(DEFAULT_NAMESPACE, key, defaultValue);
    }

}
