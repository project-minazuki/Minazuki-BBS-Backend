package com.minazuki.bbsbackend.bbs.post.service;

import com.minazuki.bbsbackend.bbs.post.dataobject.PostCreateDto;
import com.minazuki.bbsbackend.bbs.post.dataobject.PostUpdateDto;
import com.minazuki.bbsbackend.bbs.post.pojo.Post;

import java.util.List;

public interface PostService {
    void addPost(PostCreateDto postCreateDto);

    void deletePost(Integer id);

    void updatePost(PostUpdateDto postUpdateDto);

    List<Post> findAllPostsByThemeId(Integer themeId);

    void likePost(Integer id);

    void unlikePost(Integer id);
}
