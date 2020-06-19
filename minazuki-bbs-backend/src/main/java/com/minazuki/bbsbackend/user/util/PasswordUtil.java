package com.minazuki.bbsbackend.user.util;

import org.springframework.util.DigestUtils;

public class PasswordUtil {

    public static String encryptPassword(String context) {
        String md5Password = DigestUtils.md5DigestAsHex(context.getBytes());
        return md5Password;
    }

    public static boolean matchOrNot(String passwordInput, String md5Password) {
        return md5Password.equals(encryptPassword(passwordInput));
    }
}
