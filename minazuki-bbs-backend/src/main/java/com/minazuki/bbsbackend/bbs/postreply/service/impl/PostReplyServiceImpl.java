package com.minazuki.bbsbackend.bbs.postreply.service.impl;

import com.minazuki.bbsbackend.bbs.postreply.dao.PostReplyDao;
import com.minazuki.bbsbackend.bbs.postreply.dataobject.PostReplyCreateDto;
import com.minazuki.bbsbackend.bbs.postreply.pojo.PostReply;
import com.minazuki.bbsbackend.bbs.postreply.service.PostReplyService;
import com.minazuki.bbsbackend.user.interceptor.AuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostReplyServiceImpl implements PostReplyService {

    private final PostReplyDao postReplyDao;

    @Autowired
    public PostReplyServiceImpl(PostReplyDao postReplyDao) {
        this.postReplyDao = postReplyDao;
    }

    @Override
    public void addPostReply(PostReplyCreateDto prcDto) {
        prcDto.setPostReplyCreatorId(AuthenticationInterceptor.getCurrentUserId());
        this.postReplyDao.addPostReply(prcDto);
    }

    @Override
    public void deletePostReply(Integer id) {
        this.postReplyDao.deletePostReply(id);
    }

    @Override
    public PostReply getPostReplyById(Integer id) {
        return this.postReplyDao.getPostReplyById(id);
    }

    @Override
    public List<PostReply> findAllPostRepliesByPostId(Integer postId) {
        return this.postReplyDao.findAllPostRepliesByPostId(postId);
    }
}
