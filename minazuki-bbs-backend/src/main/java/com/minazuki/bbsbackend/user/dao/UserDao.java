package com.minazuki.bbsbackend.user.dao;

import com.minazuki.bbsbackend.user.dataobject.UserRegistrationDto;
import com.minazuki.bbsbackend.user.dataobject.UserSignInDto;
import com.minazuki.bbsbackend.user.dataobject.UserUpdateDto;
import com.minazuki.bbsbackend.user.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public User getUserById(Integer id) {
        return this.sqlSession.selectOne("getUserById", id);
    }

    public List<User> searchUser(String keyword) {
        return this.sqlSession.selectList("searchUsers", "%" + keyword + "%");
    }

    public User getUserByNickname(String nickname) {
        return this.sqlSession.selectOne("getUserByNickname", nickname);
    }

    public void updateUser(UserUpdateDto userUpdateDto) {
        this.sqlSession.update("updateUser", userUpdateDto);
    }

    public List<User> getUserByUniqueKey(UserRegistrationDto userRegistrationDto) {
        return this.sqlSession.selectList("getUserByUniqueKey", userRegistrationDto);
    }

    public User signInCheck(UserSignInDto userSignInDto) {
        return this.sqlSession.selectOne("signInCheck", userSignInDto);
    }
}
