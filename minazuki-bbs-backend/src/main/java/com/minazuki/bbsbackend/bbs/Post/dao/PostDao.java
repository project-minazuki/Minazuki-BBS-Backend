package com.minazuki.bbsbackend.bbs.Post.dao;

import com.minazuki.bbsbackend.bbs.Post.pojo.Post;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostDao {
    private final SqlSession sqlSession;

    @Autowired
    public PostDao(SqlSession sqlSession){this.sqlSession = sqlSession;}

    public void addPost(Post post){this.sqlSession.insert("addPost",post);}

    public void deletePost(Integer id){this.sqlSession.delete("deletePost",id);}


}
