package com.minazuki.bbsbackend.bbs.PostReply.pojo;

import lombok.Builder;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Alias("PostReply")
@ToString
@Builder
public class PostReply {

    private Integer id;
    private Integer targetPostId;
    private String content;
    private Integer postReplyCreatorId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTargetPostId() {
        return targetPostId;
    }

    public void setTargetPostId(Integer targetPostId) {
        this.targetPostId = targetPostId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPostReplyCreatorId() {
        return postReplyCreatorId;
    }

    public void setPostReplyCreatorId(Integer postReplyCreatorId) {
        this.postReplyCreatorId = postReplyCreatorId;
    }
}
