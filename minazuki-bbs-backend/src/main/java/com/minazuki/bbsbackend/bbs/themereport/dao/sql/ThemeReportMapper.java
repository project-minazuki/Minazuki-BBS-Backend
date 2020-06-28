package com.minazuki.bbsbackend.bbs.themereport.dao.sql;

import com.minazuki.bbsbackend.bbs.theme.pojo.Theme;
import com.minazuki.bbsbackend.bbs.themereport.dataobject.ThemeReportCreateDto;
import com.minazuki.bbsbackend.bbs.themereport.pojo.ThemeReport;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface ThemeReportMapper {
    @Insert("INSERT INTO theme_report(report_theme_id,report_reason,theme_reporter_id,created_time,is_checked,checked_time) " +
            "VALUES (#{themeId},#{reason},#{reporterId},NOW(),false,NOW())")
    void addThemeReport(@Param("themeReport") ThemeReportCreateDto themeReportCreateDto);

    @Delete("DELETE FROM theme_report WHERE id=#{id}")
    void deleteThemeReport(@Param("id") Integer id);

    @Select("SELECT * FROM theme_report WHERE report_theme_id = #{themeId}")
    List<ThemeReport> getAllReportsOfTheme(@Param("themeId") Integer themeId);

    @Select("SELECT * FROM theme_report WHERE report_theme_id = #{themeId} AND is_checked = false")
    List<ThemeReport> getUncheckedReportsOfTheme(@Param("themeId") Integer themeId);

    @Update("UPDATE theme_report SET is_checked = true, checked_time = NOW() WHERE id = #{id}")
    void setThemeReportChecked(@Param("id") Integer id);

    @Delete("DELETE FROM theme_report INNER JOIN theme ON theme_report.report_theme_id = theme.id WHERE theme.category_id = #{categoryId} AND theme_report.is_checked = true")
    void deleteCheckedReports(@Param("themeId") Integer categoryId);

    @Select("SELECT * FROM theme_report INNER JOIN theme ON theme_report.report_theme_id = theme.id WHERE theme.category_id = #{id}")
    List<ThemeReport> findAllThemeReportsByCategoryId(@Param("categoryId") Integer categoryId);

    //找被举报的主题帖的创建者
    @Select("SELECT theme_creator_id FROM theme INNER JOIN theme_report ON theme_report.report_theme_id = theme.id WHERE theme_report.id = #{id}")
    Integer getThemeCreatorIdByReportId(@Param("id") Integer id);

    //找被举报的主题帖的版块的版主
    @Select("SELECT category_admin_id FROM (category_admin INNER JOIN theme ON category_admin.managed_category_id = theme.category_id)" +
            " INNER JOIN theme_report ON theme_report.report_theme_id = theme.id WHERE theme_report.id = #{id} ")
    List<Integer> getCategoryAdministratorList(@Param("id") Integer id);

    @Select("SELECT is_checked FROM theme_report WHERE id = #{id}")
    boolean getCheckedStatus(@Param("id") Integer id);
}
