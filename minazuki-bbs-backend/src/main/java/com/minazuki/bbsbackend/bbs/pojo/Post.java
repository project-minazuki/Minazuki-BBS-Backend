package com.minazuki.bbsbackend.bbs.pojo;

import java.time.LocalDateTime;

public class Post {
    private Long id;
    private Long targetPostId;
    private int creatorId;
    private LocalDateTime createdAt;
    private String content;
    private int order;
    private int likesCount;
    private int unlikesCount;
    private int themeId;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getTargetPostId() {
        return targetPostId;
    }
    public void setTargetPostId(Long targetPostId) {
        this.targetPostId = targetPostId;
    }
    public int getCreatorId() {
        return creatorId;
    }
    public void setCreatorId(int creatorId) {
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
    public int getOrder() {
        return order;
    }
    public void setOrder(int order) {
        this.order = order;
    }
    public int getLikesCount() {
        return likesCount;
    }
    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }
    public int getUnlikesCount() {
        return unlikesCount;
    }
    public void setUnlikesCount(int unlikesCount) {
        this.unlikesCount = unlikesCount;
    }
    public int getThemeId() {
        return themeId;
    }
    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }
}
