package com.minazuki.bbsbackend.bbs.theme.dao.sql;

import com.minazuki.bbsbackend.bbs.theme.dataobject.ThemeCheckDto;
import com.minazuki.bbsbackend.bbs.theme.dataobject.ThemeUpdateDto;
import com.minazuki.bbsbackend.bbs.theme.pojo.Theme;
import org.apache.ibatis.annotations.*;

import java.util.List;

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

    @UpdateProvider(type = ThemeSqlProvider.class, method = "updateById")
    void updateTheme(ThemeUpdateDto themeUpdateDto);

    @Select("SELECT * FROM theme WHERE id = #{id}")
    Theme getThemeById(@Param("id") Integer id);

    @Select("SELECT * FROM theme WHERE category_id = #{categoryId}")
    List<Theme> getThemeByCategoryId(@Param("categoryId") Integer id);

    @Select("SELECT * FROM theme WHERE theme_title = #{title} AND category_id = #{categoryId}")
    Theme getThemeWithTitleAndCategoryId(@Param("title")ThemeCheckDto themeCheckDto);

    @Select("SELECT * FROM theme WHERE theme_title = #{title}")
    List<Theme> getThemeByTitle(@Param("title") String title);

    @Update("UPDATE theme SET is_top = true WHERE id = #{id}")
    void setTopById(@Param("id") Integer id);

    @Update("UPDATE theme SET is_top = false WHERE id = #{id}")
    void cancelTopById(@Param("id") Integer id);

    @Update("UPDATE theme SET is_high_quality = true WHERE id = #{id}")
    void setHighQualityById(@Param("id") Integer id);

    @Update("UPDATE theme SET is_high_quality = false WHERE id = #{id}")
    void cancelHighQualityById(@Param("id") Integer id);

    @Select("SELECT category_id FROM theme WHERE id = #{id}")
    Integer getCategoryIdOfThemeById(@Param("id") Integer id);

    @Update("UPDATE theme SET visits_count = visits_count + 1 WHERE id =#{id}")
    void increaseVisitsCountById(@Param("id") Integer id);

    @Update("UPDATE theme SET visits_count = visits_count - 1 WHERE id =#{id}")
    void decreaseVisitsCountById(@Param("id") Integer id);

    @Update("UPDATE theme SET reply_count = reply_count + 1 WHERE id =#{id}")
    void increaseReplyCountById(@Param("id") Integer id);

    @Update("UPDATE theme SET reply_count = reply_count - 1 WHERE id =#{id}")
    void decreaseReplyCountById(@Param("id") Integer id);

    @Select("SELECT * FROM theme")
    List<Theme> selectAll();
}
