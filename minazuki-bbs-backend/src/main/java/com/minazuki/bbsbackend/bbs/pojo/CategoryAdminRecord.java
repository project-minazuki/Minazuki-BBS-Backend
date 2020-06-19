package com.minazuki.bbsbackend.bbs.pojo;

import java.time.LocalDateTime;

public class CategoryAdminRecord {

    private long categoryAdminId;
    private int categoryId;
    private LocalDateTime recordCreatedAt;

    public long getCategoryAdminId() {
        return categoryAdminId;
    }
    public void setCategoryAdminId(long categoryAdminId) {
        this.categoryAdminId = categoryAdminId;
    }
    public int getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    public LocalDateTime getRecordCreatedAt() {
        return recordCreatedAt;
    }
    public void setRecordCreatedAt(LocalDateTime recordCreatedAt) {
        this.recordCreatedAt = recordCreatedAt;
    }
}
