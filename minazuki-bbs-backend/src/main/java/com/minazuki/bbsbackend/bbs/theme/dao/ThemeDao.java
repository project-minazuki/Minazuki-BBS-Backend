package com.minazuki.bbsbackend.bbs.theme.dao;

import com.minazuki.bbsbackend.bbs.theme.dataobject.ThemeCheckDto;
import com.minazuki.bbsbackend.bbs.theme.dataobject.ThemeCreateDto;
import com.minazuki.bbsbackend.bbs.theme.dataobject.ThemeUpdateDto;
import com.minazuki.bbsbackend.bbs.theme.pojo.Theme;
import com.minazuki.bbsbackend.user.interceptor.AuthenticationInterceptor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ThemeDao {
    public final SqlSession sqlSession;

    @Autowired
    public ThemeDao(SqlSession sqlSession){this.sqlSession = sqlSession;}

    public void addTheme(ThemeCreateDto themeCreateDto){this.sqlSession.insert("addTheme",themeCreateDto);}

    public void deleteTheme(Integer id){this.sqlSession.delete("deleteTheme",id);}

    public void updateThemeTitle(ThemeUpdateDto themeUpdateDto){this.sqlSession.insert("updateThemeTitle",themeUpdateDto);}

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

    public List<Theme> selectAll(){return this.sqlSession.selectList("selectAll");}

    public List<Theme> searchThemeByTitle(String title){return this.sqlSession.selectList("searchThemeByTitle",title);}

    public List<Theme> getVisitsCountTOP10(){return this.sqlSession.selectList("getVisitsCountTOP10");}

    public List<Theme> getReplyCountTOP10(){return this.sqlSession.selectList("getReplyCountTOP10");}

    public Integer getCreatorIdByThemeId(Integer id){return this.sqlSession.selectOne("getCreatorIdByThemeId",id);}

    public List<Integer> getCategoryAdminIdOfTheTheme(Integer id){return this.sqlSession.selectList("getCategoryAdminIdOfTheTheme",id);}

    public boolean isUserCreatorOfTheTheme(Integer themeId){
        Integer currentUserId = AuthenticationInterceptor.getCurrentUserId();

        //用于测试
        //currentUserId = 2;

        Integer themeCreatorId = getCreatorIdByThemeId(themeId);
        if(themeCreatorId == currentUserId){
            return true;
        }
        else
            return false;
    }

    public boolean isUserAdministratorOfTheCategoryOfTheTheme(Integer themeId){
        Integer currentUserId = AuthenticationInterceptor.getCurrentUserId();

        //用于测试
        //currentUserId = 3;

        List<Integer> categoryAdministratorIdList = getCategoryAdminIdOfTheTheme(themeId);
        int i = 0;

        for (i = 0;i<categoryAdministratorIdList.size();i++){
            if (currentUserId == categoryAdministratorIdList.get(i))
                return true;
        }

        return false;

    }

}
