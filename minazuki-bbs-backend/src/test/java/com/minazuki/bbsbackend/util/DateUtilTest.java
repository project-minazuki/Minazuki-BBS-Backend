package com.minazuki.bbsbackend.util;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

/**
 * @author hlodice
 * @date 2020/6/18 1:14
 */
public class DateUtilTest {

    @Test
    public void dateTimeToString() {
        System.out.println("测试LocalDateTime to str " + DateUtil.localDateTimeToString(LocalDateTime.now()));
    }

    @Test
    public void strToDateTime() {
        System.out.println("测试 str to localDateTime " + DateUtil.strToLocalDateTime("2020-06-18 01:26:58"));
    }
}
