package com.minazuki.bbsbackend.user.controlloer;

import com.minazuki.bbsbackend.http.StandardResponse;
import com.minazuki.bbsbackend.user.dao.UserDao;
import com.minazuki.bbsbackend.user.pojo.User;
import com.minazuki.bbsbackend.user.pojo.User.UserBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserDao userDao;

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/{userId}")
    @ResponseBody
    public StandardResponse<User> searchUserById(@PathVariable Long userId) {
        List<User> users = userDao.searchUser(User.builder().id(userId).build());
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE, "success", users.get(0));
    }

    @PostMapping("/signUp")
    public void signUp(HttpServletRequest request) {
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setNickname(request.getParameter("nickname"));
        user.setEmail(request.getParameter("email"));
        user.setPhoneNumber(request.getParameter("phoneNumber"));
        user.setCreatedAt(LocalDateTime.now());
        user.setLastSignIn(LocalDateTime.now());
        user.setAdmin(false);
        userDao.addUser(user);
    }
    @PostMapping("/signIn")
    public void signIn(HttpServletRequest request) {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
    }
}
