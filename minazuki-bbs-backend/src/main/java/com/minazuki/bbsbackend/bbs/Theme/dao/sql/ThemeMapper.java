package com.minazuki.bbsbackend.bbs.Theme.dao.sql;

import com.minazuki.bbsbackend.bbs.Theme.pojo.Theme;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ThemeMapper {
    @Insert("INSERT INTO theme " +
            "(is_top,is_high_quality,status,theme_title,theme_creator_id,category_id,visits_count," +
            "reply_count,updated_time,latest_reply_time,created_time) " +
            "VALUES (#{isTop},#{isHighQuality},#{status},#{title},#{creatorId},#{categoryId},#{visitsCount}," +
            "#{replyCount},#{updatedAt},#{latestReplyAt},#{createdAt})")
    void addTheme(@Param("theme") Theme theme);

    @Delete("DELETE FROM theme WHERE id=#{id}")
    void deleteTheme(@Param("id") Integer id);

}
