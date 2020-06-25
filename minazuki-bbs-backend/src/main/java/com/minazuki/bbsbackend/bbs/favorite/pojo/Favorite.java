package com.minazuki.bbsbackend.bbs.favorite.pojo;

import lombok.Builder;
import lombok.ToString;
import org.apache.ibatis.type.Alias;
import java.time.LocalDateTime;

@Alias("Favorite")
@ToString
@Builder
public class Favorite {

    private Integer id;
    private Integer themeId;
    private Integer OwnerId;
    private LocalDateTime createdAt;
    private LocalDateTime lastViewedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getThemeId() {
        return themeId;
    }

    public void setThemeId(Integer themeId) {
        this.themeId = themeId;
    }

    public Integer getOwnerId() {
        return OwnerId;
    }

    public void setOwnerId(Integer ownerId) {
        OwnerId = ownerId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLastViewedAt() {
        return lastViewedAt;
    }

    public void setLastViewedAt(LocalDateTime lastViewedAt) {
        this.lastViewedAt = lastViewedAt;
    }
}
