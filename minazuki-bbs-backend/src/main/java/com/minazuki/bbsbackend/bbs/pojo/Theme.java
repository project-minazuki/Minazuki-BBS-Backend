package com.minazuki.bbsbackend.bbs.pojo;

import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;

@Alias("theme")
public class Theme {
    private Long id;
    private boolean isHighQuality;
    private boolean status;
    private String themeTitle;
    private Long createdUserId;
    private int categoryId;
    private int visitsCount;
    private LocalDateTime lastUpdatedTime;
    private int replyCount;
    private int latestReplyId;
    private LocalDateTime latestReplyTime;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public boolean isHighQuality() {
        return isHighQuality;
    }
    public void setHighQuality(boolean highQuality) {
        isHighQuality = highQuality;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public String getThemeTitle() { return themeTitle; }
    public void setThemeTitle(String themeTitle) {
        this.themeTitle = themeTitle;
    }
    public Long getCreatedUserId() {
        return createdUserId;
    }
    public void setCreatedUserId(Long createdUserId) {
        this.createdUserId = createdUserId;
    }
    public int getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    public int getVisitsCount() {
        return visitsCount;
    }
    public void setVisitsCount(int visitsCount) {
        this.visitsCount = visitsCount;
    }
    public LocalDateTime getLastUpdatedTime() {
        return lastUpdatedTime;
    }
    public void setLastUpdatedTime(LocalDateTime lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }
    public int getReplyCount() {
        return replyCount;
    }
    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }
    public int getLatestReplyId() {
        return latestReplyId;
    }
    public void setLatestReplyId(int latestReplyId) {
        this.latestReplyId = latestReplyId;
    }
    public LocalDateTime getLatestReplyTime() {
        return latestReplyTime;
    }
    public void setLatestReplyTime(LocalDateTime latestReplyTime) {
        this.latestReplyTime = latestReplyTime;
    }
}
