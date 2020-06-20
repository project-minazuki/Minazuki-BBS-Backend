package com.minazuki.bbsbackend.user.dao;

import com.minazuki.bbsbackend.user.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

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
       User user = new User(false, "username2", "password", "nickname2",
                        "wdnmd", true, null, LocalDateTime.now(), LocalDateTime.now(),
                        "12345", "12345");
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
        long deleteTestId = 2;
        userDao.deleteUser(deleteTestId);
    }

    @Test
    public void selectUserTest() {
        /**
         * @Description: 建议开debug一个字段的选择语句一个字段的检查
         * @param []
         * @return void
         * @author hlodice
         * @date 2020/6/21 0:13
         */
        User user = new User();
        user.setId(3);
        System.out.println(userDao.searchUser(user));
        user = new User();
        user.setAdmin(true);
        System.out.println(userDao.searchUser(user));
        user = new User();
        user.setNickname("e2");
        System.out.println(userDao.searchUser(user));
        user = new User();
        user.setEmail("123");
        System.out.println(userDao.searchUser(user));
        user = new User();
        user.setPhoneNumber("666");
        System.out.println(userDao.searchUser(user));
    }

    @Test
    public void updateUserTest() {
        /**
         * @Description: 这里打好了断电，可以debug，每次只修改一个字段，检查是否均正常修改
         * @param []
         * @return void
         * @author hlodice
         * @date 2020/6/20 23:09
         */
        User user = new User();
        user.setId(1);
        user.setAdmin(true);
        userDao.updateUser(user);
        user = new User();
        user.setId(1);
        user.setNickname("new nickname");
        userDao.updateUser(user);
        user = new User();
        user.setId(1);
        user.setSignature("new Signature");
        userDao.updateUser(user);
        user = new User();
        user.setId(1);
        user.setPrivacyShow(false);
        userDao.updateUser(user);
        user = new User();
        user.setId(1);
        user.setAvatarUrl("new avatar url");
        userDao.updateUser(user);
        user = new User();
        user.setId(1);
        user.setPhoneNumber("6666666");
        userDao.updateUser(user);
        user = new User();
        user.setId(1);
        user.setEmail("sjkfansjkfnbaskj@newemail.com");
        userDao.updateUser(user);
    }


}
