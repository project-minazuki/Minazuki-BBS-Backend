package com.minazuki.bbsbackend.bbs.ThemeReport.dao;

import com.minazuki.bbsbackend.bbs.ThemeReport.pojo.ThemeReport;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ThemeReportDao {
    private final SqlSession sqlSession;

    @Autowired
    public ThemeReportDao(SqlSession sqlSession){this.sqlSession = sqlSession;}

    public void addThemeReport(ThemeReport themeReport){this.sqlSession.insert("addThemeReport",themeReport);}

    public void deleteThemeReport(Integer id){this.sqlSession.delete("deleteThemeReport",id);}
}
