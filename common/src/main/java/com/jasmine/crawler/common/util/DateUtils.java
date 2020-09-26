package com.jasmine.crawler.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static final int ONE_SECOND_MS = 1000;

    public static final int ONE_MINUTE_MS = 60 * ONE_SECOND_MS;

    public static final int ONE_HOUR_MS = 60 * ONE_MINUTE_MS;

    public static final int ONE_DAY_MS = 24 * ONE_HOUR_MS;


    public static int GetCurrentYear() {
        return getFromCalendar(Calendar.YEAR);
    }

    public static int getCurrentMonth() {
        return getFromCalendar(Calendar.MONTH);
    }

    public static int getCurrentWeekDay() {
        return getFromCalendar(Calendar.DAY_OF_WEEK);
    }

    public static int getCurrentDay() {
        return getFromCalendar(Calendar.DAY_OF_MONTH);
    }

    public static int getCurrentHour() {
        return getFromCalendar(Calendar.HOUR);
    }

    public static int getCurrentMinute() {
        return getFromCalendar(Calendar.MINUTE);
    }

    public static int getCurrentSecond() {
        return getFromCalendar(Calendar.SECOND);
    }

    public static String toString(Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    private static int getFromCalendar(int field) {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(field);
    }
}
