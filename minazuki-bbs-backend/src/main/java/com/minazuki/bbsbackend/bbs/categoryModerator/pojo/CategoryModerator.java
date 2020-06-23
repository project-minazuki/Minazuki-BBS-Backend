package com.minazuki.bbsbackend.bbs.categoryModerator.pojo;

import lombok.Builder;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;

@Alias("CategoryModerator")
@ToString
@Builder
public class CategoryModerator {//即数据库中的category_admin

    private Long moderatorId;
    private Integer categoryId;
    private LocalDateTime CreatedAt;

    public Long getModeratorId() {
        return moderatorId;
    }

    public void setModeratorId(Long moderatorId) {
        this.moderatorId = moderatorId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public LocalDateTime getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        CreatedAt = createdAt;
    }
}
