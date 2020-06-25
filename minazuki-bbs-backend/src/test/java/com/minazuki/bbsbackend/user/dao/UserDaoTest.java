package com.minazuki.bbsbackend.user.dao;

import com.minazuki.bbsbackend.user.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@SpringBootTest
public class UserDaoTest {

    @Resource
    private UserDao userDao;

    @Test
    public void addUserTest() {
        /**
         * @Description: 测试前注意修改一下username，nickname，email和phonenumber，这些是unique的！
         * @param []
         * @return void
         * @author hlodice
         * @date 2020/6/20 22:37
         */
       User user = User.builder().isAdmin(false).username("wdnmd").password("nmnsdms").nickname("lalala")
               .avatarUrl("asfkjasnf").createdAt(LocalDateTime.now()).lastSignIn(LocalDateTime.now()).email("safssnbaskjf")
               .phoneNumber("124123ss12").signature("wfasjkddfnas").privacyShow(true).build();
       userDao.addUser(user);
    }

    @Test
    public void deleteUserTest() {
        /**
         * @Description: 这个id传进来一定要检查数据库里是否有这个id对应的user
         * @param []
         * @return void
         * @author hlodice
         * @date 2020/6/20 22:46
         */
        int deleteTestId = 2;
        userDao.deleteUser(deleteTestId);
    }

    @Test
    public void updateUserTest() {
        /**
         * @Description: 更新用户测试，改用Map传参
         * @param []
         * @return void
         * @author hlodice
         * @date 2020/6/21 18:27
         */
    }

    @Test
    public void getUserByUniqueKeyTest() {
        //UserRegistrationDto testArgs = new UserRegistrationDto();
        //System.out.println(userDao.getUserByUniqueKey(testArgs));
    }
}
