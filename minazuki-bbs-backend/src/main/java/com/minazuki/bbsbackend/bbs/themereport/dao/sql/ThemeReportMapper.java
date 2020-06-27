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

    @Delete("DELETE FROM theme_report WHERE report_theme_id = #{themeId} AND is_checked = true")
    void deleteCheckedReports(@Param("themeId") Integer themeId);
}
