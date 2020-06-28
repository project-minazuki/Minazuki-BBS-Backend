package com.minazuki.bbsbackend.bbs.postreply.service;

import com.minazuki.bbsbackend.bbs.postreply.dataobject.PostReplyCreateDto;
import com.minazuki.bbsbackend.bbs.postreply.pojo.PostReply;
import com.minazuki.bbsbackend.bbs.postreport.dataobject.PostReportCreateDto;

import java.util.List;

public interface PostReplyService {
    void addPostReply(PostReplyCreateDto prcDto);

    void deletePostReply(Integer id);

    PostReply getPostReplyById(Integer id);

    List<PostReply> findAllPostRepliesByPostId(Integer postId);
}
