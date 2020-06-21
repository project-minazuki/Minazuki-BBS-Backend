package com.minazuki.bbsbackend.user.dao;

import com.minazuki.bbsbackend.user.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class UserDao {

    private final SqlSession sqlSession;

    @Autowired
    public UserDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public void addUser(User user) {
        this.sqlSession.insert("addUser", user);
    }

    public void deleteUser(Integer id) {
        this.sqlSession.delete("deleteUser", id);
    }

    public List<User> searchUser(Map<String, Object> args) {
        return this.sqlSession.selectList("selectUser", args);
    }

    public void updateUser(Map<String, Object > args) {
        this.sqlSession.update("updateUser", args);
    }

    public User getUserByUniqueKey(Map<String, Object> args) {
        return this.sqlSession.selectOne("getUserByUniqueKey", args);
    }
}
