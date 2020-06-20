package com.minazuki.bbsbackend.user.dao;

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

    public void deleteUser(long id) {
        this.sqlSession.delete("deleteUser", id);
    }

    public List<User> searchUser(User user) {
        /**
         * @Description: 搜索，将需要搜索的字段在传入的User对象中置为想要搜索的值，不需要搜索的置空
         * @param [user]
         * @return java.util.List<com.minazuki.bbsbackend.user.pojo.User>
         * @author hlodice
         * @date 2020/6/21 0:17
         */
        return this.sqlSession.selectList("selectUser", user);
    }

    public void updateUser(User user) {
        /**
         * @Description: 修改，将需要更新的字段在传入的User对象中置为更新后的值，不需要更新的置空
         * @param [user]
         * @return void
         * @author hlodice
         * @date 2020/6/21 0:18
         */
        this.sqlSession.update("updateUser", user);
    }
}
