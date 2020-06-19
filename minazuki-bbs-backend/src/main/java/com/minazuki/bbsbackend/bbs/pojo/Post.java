package com.minazuki.bbsbackend.bbs.pojo;

import java.time.LocalDateTime;

public class Post {
    private long id;
    private long targetPostId;
    private long creatorId;
    private LocalDateTime createdAt;
    private String content;
    private int order;
    private int likesCount;
    private int unlikesCount;
    private long themeId;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getTargetPostId() {
        return targetPostId;
    }
    public void setTargetPostId(long targetPostId) {
        this.targetPostId = targetPostId;
    }
    public long getCreatorId() {
        return creatorId;
    }
    public void setCreatorId(long creatorId) {
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
    public long getThemeId() {
        return themeId;
    }
    public void setThemeId(long themeId) {
        this.themeId = themeId;
    }
}
