package com.minazuki.bbsbackend.bbs.post.dao;

import com.minazuki.bbsbackend.bbs.post.pojo.Post;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.time.LocalDateTime;

@SpringBootTest
class PostDaoTest {

    @Resource
    private PostDao postDao;

    @Test
    void addPost() {
        Post post = Post.builder().creatorId(1).createdAt(LocalDateTime.now()).content("我的帖子")
                .number(1).likesCount(666).unlikesCount(222).themeId(2).build();
        postDao.addPost(post);
    }

    @Test
    void deletePost() {
        Integer id = 1;
        postDao.deletePost(id);
    }
}