package com.minazuki.bbsbackend.bbs.category.pojo;

import com.minazuki.bbsbackend.user.pojo.User;
import lombok.Builder;
import lombok.ToString;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Alias("Category")
@ToString
@Builder
public class Category {

    private Integer id;
    private String name;
    private Boolean status;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer visitsCount;
    private String coverUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getVisitsCount() {
        return visitsCount;
    }

    public void setVisitsCount(Integer visitsCount) {
        this.visitsCount = visitsCount;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }
}
