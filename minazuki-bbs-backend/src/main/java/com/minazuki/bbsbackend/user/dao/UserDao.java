package com.minazuki.bbsbackend.user.dao;

import com.minazuki.bbsbackend.user.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

    private final SqlSession sqlSession;

    @Autowired
    public UserDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public User getUser(long id) {
        return this.sqlSession.selectOne("findUserById", id);
    }

    public void addUser(User user) {
        this.sqlSession.insert("addUser", user);
    }
}
