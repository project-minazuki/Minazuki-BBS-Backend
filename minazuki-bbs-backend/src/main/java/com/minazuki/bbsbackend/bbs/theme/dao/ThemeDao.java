package com.minazuki.bbsbackend.bbs.theme.dao;

import com.minazuki.bbsbackend.bbs.theme.dataobject.ThemeCheckDto;
import com.minazuki.bbsbackend.bbs.theme.dataobject.ThemeUpdateDto;
import com.minazuki.bbsbackend.bbs.theme.pojo.Theme;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ThemeDao {
    public final SqlSession sqlSession;

    @Autowired
    public ThemeDao(SqlSession sqlSession){this.sqlSession = sqlSession;}

    public void addTheme(Theme theme){this.sqlSession.insert("addTheme",theme);}

    public void deleteTheme(Integer id){this.sqlSession.delete("deleteTheme",id);}

    public void updateTheme(ThemeUpdateDto themeUpdateDto){this.sqlSession.insert("updateThemeById",themeUpdateDto);}

    public List<Theme> getThemeByCategoryId(Integer categoryId){return this.sqlSession.selectList("getThemeByCategoryId",categoryId);}

    public Theme getThemeById(Integer id){return this.sqlSession.selectOne("getThemeById",id);}

    public List<Theme> getThemeByTitle(String title){return this.sqlSession.selectList("getThemeByTitle",title);}

    public boolean isThemeUnique(ThemeCheckDto themeCheckDto){
        if(this.sqlSession.selectOne("getThemeWithTitleAndCategoryId",themeCheckDto)!=null){
            return false;
        }
        else return true;
    }

    public void setTopById(Integer id){this.sqlSession.update("setTopById",id);}

    public void cancelTopById(Integer id){this.sqlSession.update("cancelTopById",id);}

    public void setHighQualityById(Integer id){this.sqlSession.update("setHighQualityById",id);}

    public void cancelHighQualityById(Integer id){this.sqlSession.update("cancelHighQualityById",id);}

    public Integer getCategoryIdOfThemeById(Integer id){return this.sqlSession.selectOne("getCategoryIdOfThemeById",id);}

    public void increaseVisitsCountById(Integer id){this.sqlSession.update("increaseVisitsCountById",id);}

    public void decreaseVisitsCountById(Integer id){this.sqlSession.update("decreaseVisitsCountById",id);}

    public void increaseReplyCountById(Integer id){this.sqlSession.update("increaseReplyCountById",id);}

    public void decreaseReplyCountById(Integer id){this.sqlSession.update("decreaseReplyCountById",id);}

}
