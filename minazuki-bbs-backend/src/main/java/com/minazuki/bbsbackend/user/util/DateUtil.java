package com.minazuki.bbsbackend.user.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author hlodice
 * @date 2020/6/17 17:07
 */
public class DateUtil {
    /**
     * @Description:将LocalDateTime 转化成Date
     * @return Date
     * @author hlodice
     * @date 2020/6/17 17:09
     */
    public static Date localDateTimeToDate(LocalDateTime dateTime) {
        return Date.from(dateTime.atZone(ZoneId.of("Asia/Shanghai")).toInstant());
    }
}
