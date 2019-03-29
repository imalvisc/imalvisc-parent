package com.imalvisc.common.utils;

import cn.hutool.core.date.DateUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName DateTimeUtils
 * @Description 日期时间工具类
 * @motto 学会编程而不是学会编码！
 * @date 2019-03-29 10:44
 */
public class DateTimeUtils {

    /**
     * 当前时间
     * @return
     */
    public static Date date() {
        return DateUtil.date();
    }

    /**
     * 偏移天
     * @param offset 正数向后偏移，负数向前偏移
     * @return
     */
    public static Date offsetDay(int offset) {
        return DateUtil.offsetDay(date(), offset);
    }

    /**
     * 偏移秒
     * @param offset
     * @return
     */
    public static Date offsetSecond(int offset) {
        return DateUtil.offsetSecond(date(), offset);
    }

    /**
     * 偏移毫秒
     * @param offset
     * @return
     */
    public static Date offsetMillisecond(int offset) {
        return DateUtil.offsetMillisecond(date(), offset);
    }

    /**
     * 当前毫秒数
     * @return
     */
    public static long millis() {
        return millis(date());
    }

    /**
     * 计算毫秒数
     * @param date
     * @return
     */
    public static long millis(Date date) {
        return date.getTime();
    }

    /**
     * 格式化当前日期，格式：yyyy-MM-dd
     * @return
     */
    public static String formatDay() {
        return DateUtil.today();
    }

    /**
     * 格式化当前时间，格式：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String formatTime() {
        return DateUtil.now();
    }

    /**
     * 格式化指定时间
     * @param date
     * @param format
     * @return
     */
    public static String format(Date date, String format) {
        return DateUtil.format(date, format);
    }

    /**
     * 格式化当前时间
     * @param pattern
     * @return
     */
    public static String format(String pattern) {
        return format(date(), pattern);
    }

    /**
     * 解析日期或时间字符串
     * 能够自动识别以下格式：
     * 1、yyyy-MM-dd HH:mm:ss
     * 2、yyyy-MM-dd
     * 3、HH:mm:ss
     * 4、yyyy-MM-dd HH:mm
     * 5、yyyy-MM-dd HH:mm:ss.SSS
     * @param source
     * @return
     */
    public static Date parse(String source) {
        return DateUtil.parse(source);
    }

    /**
     * 自定义格式解析日期或时间字符串
     * @param source
     * @param format
     * @return
     */
    public static Date parse(String source, String format) {
        return DateUtil.parse(source, format);
    }

}
