package com.minazuki.bbsbackend.bbs.postreply.dao;

import com.minazuki.bbsbackend.bbs.postreply.dataobject.PostReplyCreateDto;
import com.minazuki.bbsbackend.bbs.postreply.pojo.PostReply;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class PostReplyDaoTest {

    @Resource
    private PostReplyDao postReplyDao;

    @Test
    void addPostReply() {
        PostReplyCreateDto postReplyCreateDto = new PostReplyCreateDto();
        postReplyCreateDto.setContent("顶");
        postReplyCreateDto.setTargetPostId(2);
        postReplyCreateDto.setPostReplyCreatorId(4);
        postReplyDao.addPostReply(postReplyCreateDto);
    }

    @Test
    void deletePostReply() {
        Integer id = 1;
        postReplyDao.deletePostReply(id);
    }

    @Test
    void getPostReplyByIdTest() {
        System.out.println(postReplyDao.getPostReplyById(1));
    }

    @Test
    void findAllPostRepliesByPostIdTest() {
        System.out.println(postReplyDao.findAllPostRepliesByPostId(2));
    }
}