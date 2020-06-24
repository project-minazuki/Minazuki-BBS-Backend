package com.minazuki.bbsbackend.bbs.ThemeReport.dao.sql;

import com.minazuki.bbsbackend.bbs.ThemeReport.pojo.ThemeReport;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ThemeReportMapper {
    @Insert("INSERT INTO theme_report(report_theme_id,report_reason,theme_reporter_id,created_time,is_checked,checked_time) " +
            "VALUES (#{themeId},#{reason},#{reporterId},#{createdAt},#{checked},#{checkedAt})")
    void addThemeReport(@Param("themeReport") ThemeReport themeReport);

    @Delete("DELETE FROM theme_report WHERE id=#{id}")
    void deleteThemeReport(@Param("id") Integer id);
}
