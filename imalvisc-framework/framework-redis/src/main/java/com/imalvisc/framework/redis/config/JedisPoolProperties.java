package com.imalvisc.framework.redis.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName JedisPoolProperties
 * @Description Redis连接池配置信息
 * @motto 学会编程而不是学会编码！
 * @date 2019-04-02 10:36
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JedisPoolProperties {

    /**
     * 最大连接数
     */
    private int maxActive;

    /**
     * 最大阻塞时间, -1表示无限制
     */
    private int maxWait;

    /**
     * 最大空闲时间
     */
    private int maxIdle;

    /**
     * 最小空闲时间
     */
    private int minIdle;

    /**
     * 获取时验证
     */
    private boolean testOnBorrow;

    /**
     * 归还时验证
     */
    private boolean testOnReturn;

    /**
     * 空闲时验证
     */
    private boolean testWhileIdle;

}
