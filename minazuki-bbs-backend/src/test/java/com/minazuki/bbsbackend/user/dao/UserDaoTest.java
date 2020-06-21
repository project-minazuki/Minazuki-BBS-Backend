package com.minazuki.bbsbackend.user.dao;

import com.minazuki.bbsbackend.user.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

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
       User user = User.builder().isAdmin(false).username("user name balabala").password("nmnsdms").nickname("tfeqwem")
               .avatarUrl("asfkjasnf").createdAt(LocalDateTime.now()).lastSignIn(LocalDateTime.now()).email("safnbaskjf")
               .phoneNumber("12412312").signature("wfasjkfnas").privacyShow(true).build();
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
    public void selectUserTest() {
        /**
         * @Description: 搜索功能测试，使用map传参
         * @param []
         * @return void
         * @author hlodice
         * @date 2020/6/21 19:55
         */
        Map<String, Object> testArgs = new HashMap<>();
        testArgs.put("id", 4);
        System.out.println(userDao.searchUser(testArgs));
        testArgs.remove("id");
        testArgs.put("isAdmin", true);
        System.out.println(userDao.searchUser(testArgs));
        testArgs.remove("isAdmin");
        testArgs.put("username", "new");
        System.out.println(userDao.searchUser(testArgs));
        testArgs.remove("username");
        testArgs.put("nickname", "kna");
        System.out.println(userDao.searchUser(testArgs));
        testArgs.remove("nickname");
        testArgs.put("signature", "si");
        System.out.println(userDao.searchUser(testArgs));
        testArgs.remove("signature");
        testArgs.put("privacyShow", true);
        System.out.println(userDao.searchUser(testArgs));
        testArgs.remove("privacyShow");
        testArgs.put("email", "43");
        System.out.println(userDao.searchUser(testArgs));
        testArgs.remove("email");
        testArgs.put("phoneNumber", "66");
        System.out.println(userDao.searchUser(testArgs));
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
        Map<String, Object> testArgs = new HashMap<>();
        testArgs.put("id", 4);
        testArgs.put("isAdmin", true);
        userDao.updateUser(testArgs);
        testArgs.remove("isAdmin");
        testArgs.put("username", "new username bsioasd");
        userDao.updateUser(testArgs);
        testArgs.remove("username");
        testArgs.put("password", "new password bsioasd");
        userDao.updateUser(testArgs);
        testArgs.remove("password");
        testArgs.put("nickname", "new nickname bsioasd");
        userDao.updateUser(testArgs);
        testArgs.remove("nickname");
        testArgs.put("avatarUrl", "new url bsioasd");
        userDao.updateUser(testArgs);
        testArgs.remove("avatarUrl");
        testArgs.put("createdAt", LocalDateTime.now());
        userDao.updateUser(testArgs);
        testArgs.remove("createdAt");
        testArgs.put("lastSignIn", LocalDateTime.now());
        userDao.updateUser(testArgs);
        testArgs.remove("lastSignIn");
        testArgs.put("email", "new email");
        userDao.updateUser(testArgs);
        testArgs.remove("email");
        testArgs.put("phoneNumber", "124124");
        userDao.updateUser(testArgs);
        testArgs.remove("phoneNumber");
        testArgs.put("signature", "new signature");
        userDao.updateUser(testArgs);
        testArgs.remove("signature");
        testArgs.put("privacyShow", false);
        userDao.updateUser(testArgs);
    }

    @Test
    public void getUserByUniqueKeyTest() {
        Map<String, Object> testArgs = new HashMap<>();
        testArgs.put("username", "username1");
        testArgs.put("nickname", "niiiii");
        System.out.println(userDao.getUserByUniqueKey(testArgs));
    }
}
