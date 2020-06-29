package com.minazuki.bbsbackend.bbs.theme.pojo;

import com.minazuki.bbsbackend.bbs.tag.pojo.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;
import java.util.List;

@Alias("Theme")
@ToString
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
    private LocalDateTime latestReplyAt;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;

    private List<Tag> tags;

    public Theme(Integer id, Boolean isTop, Boolean isHighQuality, Boolean status, String title, Integer creatorId,
                 Integer categoryId, Integer visitsCount, Integer replyCount, LocalDateTime latestReplyAt,
                 LocalDateTime updatedAt, LocalDateTime createdAt) {
        this.id = id;
        this.isTop = isTop;
        this.isHighQuality = isHighQuality;
        this.status = status;
        this.title = title;
        this.creatorId = creatorId;
        this.categoryId = categoryId;
        this.visitsCount = visitsCount;
        this.replyCount = replyCount;
        this.latestReplyAt = latestReplyAt;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }

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

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
