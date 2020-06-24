package com.minazuki.bbsbackend.bbs.PostReply.dao;

import com.minazuki.bbsbackend.bbs.PostReply.pojo.PostReply;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostReplyDaoTest {

    @Resource
    private PostReplyDao postReplyDao;

    @Test
    void addPostReply() {
        PostReply postReply = PostReply.builder().targetPostId(2).content("9折？").postReplyCreatorId(1).build();
        postReplyDao.addPostReply(postReply);
    }

    @Test
    void deletePostReply() {
        Integer id = 1;
        postReplyDao.deletePostReply(id);
    }
}