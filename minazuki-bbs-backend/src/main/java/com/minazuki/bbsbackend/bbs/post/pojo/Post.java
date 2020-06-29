package com.minazuki.bbsbackend.bbs.post.pojo;

import com.minazuki.bbsbackend.bbs.postreply.pojo.PostReply;
import lombok.Builder;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;
import java.util.List;

@Alias("Post")
@ToString
public class Post {

    private Integer id;
    private Integer creatorId;
    private LocalDateTime createdAt;
    private String content;
    private Integer number;
    private Integer likesCount;
    private Integer unlikesCount;
    private Integer themeId;
    private List<PostReply> postReplyList;

    public Post(Integer id, Integer creatorId, LocalDateTime createdAt, String content, Integer number,
                Integer likesCount, Integer unlikesCount, Integer themeId) {
        this.id = id;
        this.creatorId = creatorId;
        this.createdAt = createdAt;
        this.content = content;
        this.number = number;
        this.likesCount = likesCount;
        this.unlikesCount = unlikesCount;
        this.themeId = themeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(Integer likesCount) {
        this.likesCount = likesCount;
    }

    public Integer getUnlikesCount() {
        return unlikesCount;
    }

    public void setUnlikesCount(Integer unlikesCount) {
        this.unlikesCount = unlikesCount;
    }

    public Integer getThemeId() {
        return themeId;
    }

    public void setThemeId(Integer themeId) {
        this.themeId = themeId;
    }

    public List<PostReply> getPostReplyList() {
        return postReplyList;
    }

    public void setPostReplyList(List<PostReply> postReplyList) {
        this.postReplyList = postReplyList;
    }
}
