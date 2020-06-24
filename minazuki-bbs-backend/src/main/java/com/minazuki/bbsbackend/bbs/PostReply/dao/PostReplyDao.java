package com.minazuki.bbsbackend.bbs.PostReply.dao;

import com.minazuki.bbsbackend.bbs.Post.pojo.Post;
import com.minazuki.bbsbackend.bbs.PostReply.pojo.PostReply;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostReplyDao {
    private final SqlSession sqlSession;

    @Autowired
    public PostReplyDao(SqlSession sqlSession){this.sqlSession = sqlSession; }

    public void addPostReply(PostReply postReply){this.sqlSession.insert("addPostReply",postReply);}

    public void deletePostReply(Integer id){this.sqlSession.delete("deletePostReply",id);}

}
