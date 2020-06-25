package com.minazuki.bbsbackend.bbs.HistoryViewed.pojo;

import lombok.Builder;
import lombok.ToString;
import org.apache.ibatis.type.Alias;
import java.time.LocalDateTime;

@Alias("HistoryViewed")
@ToString
@Builder
public class HistoryViewed {

    private Integer id;
    private Integer ownerId;
    private Integer viewedThemeId;
    private LocalDateTime viewedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getViewedThemeId() {
        return viewedThemeId;
    }

    public void setViewedThemeId(Integer viewedThemeId) {
        this.viewedThemeId = viewedThemeId;
    }

    public LocalDateTime getViewedAt() {
        return viewedAt;
    }

    public void setViewedAt(LocalDateTime viewedAt) {
        this.viewedAt = viewedAt;
    }
}
