package com.minazuki.bbsbackend.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author hlodice
 * @date 2020/6/17 17:07
 */
public class DateUtil {
    /**
     * @Description: 将LocalDateTime转化成Date
     * @return Date
     * @author hlodice
     * @date 2020/6/17 17:09
     */
    public static Date localDateTimeToDate(LocalDateTime dateTime) {
        return Date.from(dateTime.atZone(ZoneId.of("Asia/Shanghai")).toInstant());
    }

    public static String localDateTimeToString(LocalDateTime dateTime) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(localDateTimeToDate(dateTime));
    }

    public static LocalDateTime strToLocalDateTime(String dateTimeStr) {
        return LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
