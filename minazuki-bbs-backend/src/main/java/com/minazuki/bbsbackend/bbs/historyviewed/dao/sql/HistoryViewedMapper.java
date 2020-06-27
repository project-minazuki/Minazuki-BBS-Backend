package com.minazuki.bbsbackend.bbs.historyviewed.dao.sql;

import com.minazuki.bbsbackend.bbs.historyviewed.dataobject.HistoryViewedCreateDto;
import com.minazuki.bbsbackend.bbs.historyviewed.pojo.HistoryViewed;
import java.util.List;
import org.apache.ibatis.annotations.*;

@Mapper
public interface HistoryViewedMapper {

    @Insert("INSERT INTO history_viewed (view_user_id,viewed_theme_id,viewed_time) " +
            "VALUES (#{ownerId}, #{viewedThemeId}, NOW())")
    void addHistoryViewed(@Param("hvcDto") HistoryViewedCreateDto hvcDto);

    @Delete("DELETE FROM history_viewed WHERE id = #{id}")
    void deleteHistoryViewed(@Param("id") Integer id);

    @Select("SELECT * FROM history_viewed WHERE id = #{id}")
    @Results({
            @Result(property = "ownerId", column = "view_user_id"),
            @Result(property = "viewedThemeId", column = "viewed_theme_id"),
            @Result(property = "viewedAt", column = "viewed_time")
    })
    HistoryViewed getHistoryViewedById(@Param("id") Integer id);

    @Select("SELECT * FROM history_viewed WHERE view_user_id = #{ownerId}")
    @Results({
            @Result(property = "ownerId", column = "view_user_id"),
            @Result(property = "viewedThemeId", column = "viewed_theme_id"),
            @Result(property = "viewedAt", column = "viewed_time")
    })
    List<HistoryViewed> findAllHistoryViewed(@Param("ownerId") Integer ownerId);
}
