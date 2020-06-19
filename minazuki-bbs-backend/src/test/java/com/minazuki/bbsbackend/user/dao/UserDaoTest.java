package com.minazuki.bbsbackend.user.dao;

import com.minazuki.bbsbackend.user.dao.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class UserDaoTest {

    @Resource
    private UserDao userDao;

    @Test
    public void findUserByIdTest() {
        System.out.println(userDao.getUser(1));
    }

    @Test
    public void addUserTest() {
        //
    }
}
