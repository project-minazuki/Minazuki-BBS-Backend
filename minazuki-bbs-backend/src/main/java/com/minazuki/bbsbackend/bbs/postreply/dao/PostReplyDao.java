package com.minazuki.bbsbackend.bbs.postreply.dao;

import com.minazuki.bbsbackend.bbs.postreply.dataobject.PostReplyCreateDto;
import com.minazuki.bbsbackend.bbs.postreply.pojo.PostReply;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostReplyDao {
    private final SqlSession sqlSession;

    @Autowired
    public PostReplyDao(SqlSession sqlSession){this.sqlSession = sqlSession; }

    public void addPostReply(PostReplyCreateDto prcDto){this.sqlSession.insert("addPostReply",prcDto);}

    public void deletePostReply(Integer id){this.sqlSession.delete("deletePostReply",id);}

    public PostReply getPostReplyById(Integer id){
        return this.sqlSession.selectOne("getPostReplyById", id);
    }

    public List<PostReply> findAllPostRepliesByPostId(Integer targetPostId) {
        return this.sqlSession.selectList("findAllPostRepliesByPostId", targetPostId);
    }

}
