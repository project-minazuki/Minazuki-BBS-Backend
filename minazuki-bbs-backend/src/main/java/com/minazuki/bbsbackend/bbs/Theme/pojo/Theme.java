package com.minazuki.bbsbackend.bbs.Theme.pojo;

import lombok.Builder;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import javax.print.DocFlavor;
import java.time.LocalDateTime;

@Alias("Theme")
@ToString
@Builder
public class Theme {

    private Integer id;
    private Boolean isTop;
    private Boolean isHighQuality;
    private Boolean status;
    private String title;
    private Integer creatorId;
    private Integer categoryId;
    private Integer visitsCount;
    private Integer replyCount;
    private Integer latestReplyId;
    private LocalDateTime latestReplyAt;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getTop() {
        return isTop;
    }

    public void setTop(Boolean top) {
        isTop = top;
    }

    public Boolean getHighQuality() {
        return isHighQuality;
    }

    public void setHighQuality(Boolean highQuality) {
        isHighQuality = highQuality;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getVisitsCount() {
        return visitsCount;
    }

    public void setVisitsCount(Integer visitsCount) {
        this.visitsCount = visitsCount;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public Integer getLatestReplyId() {
        return latestReplyId;
    }

    public void setLatestReplyId(Integer latestReplyId) {
        this.latestReplyId = latestReplyId;
    }

    public LocalDateTime getLatestReplyAt() {
        return latestReplyAt;
    }

    public void setLatestReplyAt(LocalDateTime latestReplyAt) {
        this.latestReplyAt = latestReplyAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
