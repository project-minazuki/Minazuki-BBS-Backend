package com.minazuki.bbsbackend.bbs.pojo;

import com.minazuki.bbsbackend.user.pojo.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


public class Category {

    private int id;
    private String categoryName;
    private boolean status;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdatedAt;
    private int visitsCount;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
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
    public LocalDateTime getLastUpdatedAt() {
        return lastUpdatedAt;
    }
    public void setLastUpdatedAt(LocalDateTime lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }
    public int getVisitsCount() {
        return visitsCount;
    }
    public void setVisitsCount(int visitsCount) {
        this.visitsCount = visitsCount;
    }
}
