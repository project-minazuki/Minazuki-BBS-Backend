package com.minazuki.bbsbackend.user.util;

import com.minazuki.bbsbackend.user.pojo.User;
import org.junit.jupiter.api.Test;

/**
 * @author hlodice
 * @date 2020/6/17 17:50
 */
public class JwtUtilTest {

    @Test
    public void sign() {
        User user = new User();
        user.setId(1L);
        user.setUsername("testUserName");
        System.out.println("测试jwt:token = " + JwtUtil.sign(user));
    }

    @Test
    public void verify() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJtaW5henVraS1iYnMiLCJleHAiOjE1OTI1OTgyMjIsInVzZXJJZCI6MSwiaWF0IjoxNTkyNTkxMDIyLCJ1c2VybmFtZSI6InRlc3RVc2VyTmFtZSJ9.kr3SJwxarKJSlkLj5rwd95EsQ5Cd21jzTaWMSn32psQ";
        System.out.println("解析token: userId = " + JwtUtil.verify(token));
    }
}
