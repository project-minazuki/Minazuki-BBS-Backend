package com.minazuki.bbsbackend.bbs.post.dao;

import com.minazuki.bbsbackend.bbs.post.dataobject.PostCreateDto;
import com.minazuki.bbsbackend.bbs.post.dataobject.PostUpdateDto;
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
        PostCreateDto postCreateDto = new PostCreateDto();
        postCreateDto.setThemeId(7);
        postCreateDto.setCreatorId(4);
        postCreateDto.setNumber(postDao.getNextPostNumber(2));
        postCreateDto.setContent("宁太强了");
        postDao.addPost(postCreateDto);
    }

    @Test
    void deletePost() {
        Integer id = 1;
        postDao.deletePost(id);
    }

    @Test
    void updatePostTest() {
        PostUpdateDto postUpdateDto = new PostUpdateDto();
        postUpdateDto.setContent("tmctql");
        postUpdateDto.setPostId(2);
        postDao.updatePost(postUpdateDto);
    }

    @Test
    void findAllPostsByThemeId() {
        System.out.println(postDao.findAllPostsByThemeId(2));
    }

    @Test
    void likeOrUnlikePostTest() {
        postDao.likePost(2);
        postDao.unlikePost(2);
    }
}