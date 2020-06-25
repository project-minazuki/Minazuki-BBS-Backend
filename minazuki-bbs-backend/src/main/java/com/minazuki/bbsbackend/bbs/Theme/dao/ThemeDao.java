package com.minazuki.bbsbackend.bbs.Theme.dao;

import com.minazuki.bbsbackend.bbs.Theme.dataObject.ThemeUpdateDto;
import com.minazuki.bbsbackend.bbs.Theme.pojo.Theme;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ThemeDao {
    public final SqlSession sqlSession;

    @Autowired
    public ThemeDao(SqlSession sqlSession){this.sqlSession = sqlSession;}

    public void addTheme(Theme theme){this.sqlSession.insert("addTheme",theme);}

    public void deleteTheme(Integer id){this.sqlSession.delete("deleteTheme",id);}

    public void updateThemeById(ThemeUpdateDto themeUpdateDto){this.sqlSession.insert("updateThemeById",themeUpdateDto);}

}
