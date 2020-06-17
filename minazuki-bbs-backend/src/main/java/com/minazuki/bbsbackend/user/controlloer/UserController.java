package com.minazuki.bbsbackend.user.controlloer;

import com.minazuki.bbsbackend.user.dao.UserDao;
import com.minazuki.bbsbackend.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserDao userDao;

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping("/{userId}")
    public User getUser(@PathVariable Long userId) {
        return userDao.getUser(userId);
    }
}
