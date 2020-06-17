package com.minazuki.bbsbackend.user.util;

import com.minazuki.bbsbackend.user.pojo.User;
import org.junit.jupiter.api.Test;

/**
 * @author hlodice
 * @date 2020/6/17 17:50
 */
public class JwtUtilTest {

    @Test
    public void sigh() {
        User user = new User();
        user.setId(1L);
        user.setUserName("testUserName");
        System.out.println("测试jwt:token = " + JwtUtil.sign(user));
    }

    @Test
    public void verify() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJtaW5henVraS1iYnMiLCJleHAiOjE1OTIzOTQ4NjUsInVzZXJJZCI6MSwiaWF0IjoxNTkyMzg3NjY1LCJ1c2VybmFtZSI6InRlc3RVc2VyTmFtZSJ9.fcuacUU7I2r-M_fLn09PhQSYRIzXboHiHBEYAcX4lVM";
        System.out.println("解析token: userId = " + JwtUtil.verify(token));
    }
}
