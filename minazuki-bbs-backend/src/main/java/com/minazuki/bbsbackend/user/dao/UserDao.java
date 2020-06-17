package com.minazuki.bbsbackend.user.dao;

import com.minazuki.bbsbackend.user.pojo.User;
import org.springframework.stereotype.Component;

@Component
public interface UserDao {

    public User getUser(Long id);

    public int addUser(User user);
}
