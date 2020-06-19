package com.minazuki.bbsbackend.user.util;

import org.junit.jupiter.api.Test;

public class PasswordUtilTest {
    @Test
    public void encryptTest() {
        System.out.println("密码为 987654321的加密结果为" + PasswordUtil.encryptPassword("987654321"));
    }

    @Test
    public void matchTest() {
        System.out.println(PasswordUtil.matchOrNot("987654321", PasswordUtil.encryptPassword("987654321")));
    }
}
