package com.minazuki.bbsbackend.bbs.post.service.impl;

import com.minazuki.bbsbackend.bbs.post.dao.PostDao;
import com.minazuki.bbsbackend.bbs.post.dataobject.PostCreateDto;
import com.minazuki.bbsbackend.bbs.post.dataobject.PostUpdateDto;
import com.minazuki.bbsbackend.bbs.post.pojo.Post;
import com.minazuki.bbsbackend.bbs.post.service.PostService;
import com.minazuki.bbsbackend.user.interceptor.AuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostDao postDao;

    @Autowired
    public PostServiceImpl(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public void addPost(PostCreateDto postCreateDto) {
        postCreateDto.setCreatorId(AuthenticationInterceptor.getCurrentUserId());
        this.postDao.addPost(postCreateDto);
    }

    @Override
    public void deletePost(Integer id) {
        this.postDao.deletePost(id);
    }

    @Override
    public void updatePost(PostUpdateDto postUpdateDto) {
        this.postDao.updatePost(postUpdateDto);
    }

    @Override
    public List<Post> findAllPostsByThemeId(Integer themeId) {
        return this.postDao.findAllPostsByThemeId(themeId);
    }

    @Override
    public void likePost(Integer id) {
        this.postDao.likePost(id);
    }

    @Override
    public void unlikePost(Integer id) {
        this.postDao.unlikePost(id);
    }
}
