package com.minazuki.bbsbackend.bbs.post.service.impl;

import com.minazuki.bbsbackend.bbs.post.dao.PostDao;
import com.minazuki.bbsbackend.bbs.post.dataobject.PostCreateDto;
import com.minazuki.bbsbackend.bbs.post.dataobject.PostUpdateDto;
import com.minazuki.bbsbackend.bbs.post.pojo.Post;
import com.minazuki.bbsbackend.bbs.post.service.PostService;
import com.minazuki.bbsbackend.bbs.postreply.dao.PostReplyDao;
import com.minazuki.bbsbackend.bbs.theme.dao.ThemeDao;
import com.minazuki.bbsbackend.user.exception.PermissionDeniedException;
import com.minazuki.bbsbackend.user.interceptor.AuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final ThemeDao themeDao;
    private final PostDao postDao;
    private final PostReplyDao postReplyDao;

    @Autowired
    public PostServiceImpl(ThemeDao themeDao, PostDao postDao, PostReplyDao postReplyDao) {
        this.themeDao = themeDao;
        this.postDao = postDao;
        this.postReplyDao = postReplyDao;
    }

    @Override
    public void addPost(PostCreateDto postCreateDto) {
        postCreateDto.setCreatorId(AuthenticationInterceptor.getCurrentUserId());
        postCreateDto.setNumber(this.postDao.getNextPostNumber(postCreateDto.getThemeId()));
        this.postDao.addPost(postCreateDto);
    }

    public Post getPostById(Integer postId) {
        Post post = this.postDao.getPostById(postId);
        packagePost(post);
        return post;
    }

    @Override
    public void deletePost(Integer id) throws PermissionDeniedException{
        if(isPostCreator(id) || isThemeCreator(id)){
            this.postDao.deletePost(id);
        }else {
            throw new PermissionDeniedException();
        }
    }

    @Override
    public void updatePost(PostUpdateDto postUpdateDto) throws PermissionDeniedException{
        if(isPostCreator(postUpdateDto.getPostId())){
            this.postDao.updatePost(postUpdateDto);
        }else {
            throw new PermissionDeniedException();
        }

    }

    @Override
    public List<Post> findAllPostsByThemeId(Integer themeId) {
        List<Post> posts = this.postDao.findAllPostsByThemeId(themeId);
        for (Post post: posts
             ) {
            packagePost(post);
        }
        return posts;
    }

    @Override
    public void likePost(Integer id) {
        this.postDao.likePost(id);
    }

    @Override
    public void unlikePost(Integer id) {
        this.postDao.unlikePost(id);
    }

    private boolean isPostCreator(Integer postId) {
        return postDao.getPostById(postId).getCreatorId() == AuthenticationInterceptor.getCurrentUserId();
    }

    private boolean isThemeCreator(Integer postId) {
        return themeDao.isUserCreatorOfTheTheme(getPostById(postId).getThemeId());
    }

    private void packagePost(Post post) {
        post.setPostReplyList(postReplyDao.findAllPostRepliesByPostId(post.getId()));
    }
}
