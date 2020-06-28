package com.minazuki.bbsbackend.bbs.themereport.dao;

import com.minazuki.bbsbackend.bbs.themereport.dataobject.ThemeReportCreateDto;
import com.minazuki.bbsbackend.bbs.themereport.pojo.ThemeReport;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ThemeReportDao {
    private final SqlSession sqlSession;

    @Autowired
    public ThemeReportDao(SqlSession sqlSession){this.sqlSession = sqlSession;}

    public void addThemeReport(ThemeReportCreateDto themeReportCreateDto){this.sqlSession.insert("addThemeReport",themeReportCreateDto);}

    public void deleteThemeReport(Integer id){this.sqlSession.delete("deleteThemeReport",id);}

    public List<ThemeReport> getAllReportsOfTheme(Integer themeId){return this.sqlSession.selectList("getAllReportsOfTheme",themeId);}

    public List<ThemeReport> getUncheckedReportsOfTheme(Integer themeId){return this.sqlSession.selectList("getUncheckedReportsOfTheme",themeId);}

    public void setThemeReportChecked(Integer id){this.sqlSession.update("setThemeReportChecked",id);}

    public void deleteCheckedReports(Integer themeId){this.sqlSession.delete("deleteCheckedReports",themeId);}

    public List<ThemeReport> findAllThemeReportsByCategoryId(Integer categoryId){return this.sqlSession.selectList("findAllThemeReportsByCategoryId", categoryId);}

}
