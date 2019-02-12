package com.imalvisc.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtils {

    public static Date date() {
        return Calendar.getInstance().getTime();
    }

    public static Date dateWithDayPlus(int day) {
        return dateWithDayPlus(date(), day);
    }

    public static Date dateWithDayPlus(Date source, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(source);
        calendar.add(Calendar.DAY_OF_YEAR, day);
        return calendar.getTime();
    }

    public static Date dateWithSecondPlus(int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, second);
        return calendar.getTime();
    }

    public static Date dateWithMillsPlus(int mills) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MILLISECOND, mills);
        return calendar.getTime();
    }

    public static long millis() {
        return Calendar.getInstance().getTimeInMillis();
    }

    public static long millis(Date date) {
        return date.getTime();
    }

    public static String format() {
        return format("yyyy-MM-dd");
    }

    public static String format(String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date());
    }

    public static Date parse(String source, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            return dateFormat.parse(source);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date parseDate(String source) {
        return parse(source, "yyyy-MM-dd");
    }

    public static Date parseDateTime(String source) {
        return parse(source, "yyyy-MM-dd HH:mm:ss");
    }

    public static Date parseTime(String source) {
        return parse(source, "HH:mm:ss");
    }

}
