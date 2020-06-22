package com.minazuki.bbsbackend.user.service;

import com.minazuki.bbsbackend.user.dao.UserDao;
import com.minazuki.bbsbackend.user.exception.DuplicateRegistrationInfoException;
import com.minazuki.bbsbackend.user.exception.NoUserMatchException;
import com.minazuki.bbsbackend.user.pojo.User;
import com.minazuki.bbsbackend.user.util.JwtUtil;
import com.minazuki.bbsbackend.user.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> search(Map<String, Object> args) {
        return userDao.searchUser(args);
    }

    public User index(int id) {
        Map<String, Object> args = new HashMap<>();
        args.put("id", id);
        return userDao.searchUser(args).get(0);
    }

    public boolean signUp(Map<String, Object> signUpArgs) throws DuplicateRegistrationInfoException {
        List<User> users = userDao.getUserByUniqueKey(signUpArgs);
        if (users.size() == 0) {
            User newUser = User.builder().isAdmin(false).username((String) signUpArgs.get("username"))
                    .password(PasswordUtil.encryptPassword((String) signUpArgs.get("password")))
                    .nickname((String) signUpArgs.get("nickname")).privacyShow(true)
                    .createdAt(LocalDateTime.now()).lastSignIn(LocalDateTime.now())
                    .email((String) signUpArgs.get("email")).phoneNumber((String) signUpArgs.get("phoneNumber"))
                    .build();
            userDao.addUser(newUser);
            return true;
        } else {
            DuplicateRegistrationInfoException e = new DuplicateRegistrationInfoException();
            for (User user: users
                 ) {
                if (user.getUsername().equals(signUpArgs.get("username")))
                    e.addDuplicateInfo("username");
                if (user.getNickname().equals(signUpArgs.get("nickname")))
                    e.addDuplicateInfo("nickname");
                if (user.getPhoneNumber().equals(signUpArgs.get("phoneNumber")))
                    e.addDuplicateInfo("phoneNumber");
                if (user.getEmail().equals(signUpArgs.get("email")))
                    e.addDuplicateInfo("email");
            }
            throw e;
        }
    }

    public String signIn(Map<String, Object> signInInfo) throws NoUserMatchException {
        signInInfo.replace("password", PasswordUtil.encryptPassword((String) signInInfo.get("password")));
        User user = userDao.signInCheck(signInInfo);
        return JwtUtil.sign(user);
    }
}
