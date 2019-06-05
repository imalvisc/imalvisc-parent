package com.imalvisc.framework.redis.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName CustomRedisSerializer
 * @Description 自定义Redis序列化
 * @motto 学会编程而不是学会编码！
 * @date 2019-04-02 10:36
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
@Slf4j
public class CustomRedisSerializer implements org.springframework.data.redis.serializer.RedisSerializer<Object> {

    private static final Converter<Object, byte[]> serializer = new SerializingConverter();
    private static final Converter<byte[], Object> deserializer = new DeserializingConverter();

    @Override
    public byte[] serialize(Object o) throws SerializationException {
        if (o == null) return new byte[0];
        try {
            return serializer.convert(o);
        } catch (Exception e) {
            log.error("Redis序列化异常: ", e);
            return new byte[0];
        }
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length == 0) return null;
        try {
            return deserializer.convert(bytes);
        } catch (Exception e) {
            log.error("Redis反序列化异常: ", e);
            return null;
        }
    }

}
