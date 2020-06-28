package com.minazuki.bbsbackend.bbs.themereport.dao;

import com.minazuki.bbsbackend.bbs.themereport.dataobject.ThemeReportCreateDto;
import com.minazuki.bbsbackend.bbs.themereport.pojo.ThemeReport;
import com.minazuki.bbsbackend.user.interceptor.AuthenticationInterceptor;
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

    //Only for category_administrator
    public void deleteThemeReport(Integer id){this.sqlSession.delete("deleteThemeReport",id);}

    //For theme_creator and category_administrator
    public List<ThemeReport> getAllReportsOfTheme(Integer themeId){return this.sqlSession.selectList("getAllReportsOfTheme",themeId);}

    //For theme_creator and category_administrator
    public List<ThemeReport> getUncheckedReportsOfTheme(Integer themeId){return this.sqlSession.selectList("getUncheckedReportsOfTheme",themeId);}

    //Only for category_administrator
    public void setThemeReportChecked(Integer id){this.sqlSession.update("setThemeReportChecked",id);}

    //Only for category_administrator
    public void deleteCheckedReports(Integer categoryId){this.sqlSession.delete("deleteCheckedReports",categoryId);}

    //Only for category_administrator
    public List<ThemeReport> findAllThemeReportsByCategoryId(Integer categoryId){return this.sqlSession.selectList("findAllThemeReportsByCategoryId", categoryId);}

    public Integer getThemeCreatorIdByReportId(Integer id){return this.sqlSession.selectOne("getThemeCreatorIdByReportId",id);}

    public List<Integer> getCategoryAdministratorList(Integer id){return this.sqlSession.selectList("getCategoryAdministratorList",id);}

    public boolean isUserThemeCreator(Integer reportId){
        Integer currentUserId = AuthenticationInterceptor.getCurrentUserId();

        //用于测试
        //currentUserId = 2;

        Integer themeCreatorId = getThemeCreatorIdByReportId(reportId);
        if(currentUserId == themeCreatorId){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isUserCategoryAdministrator(Integer reportId){
        Integer currentUserId = AuthenticationInterceptor.getCurrentUserId();

        //用于测试
        //currentUserId = 3;

        List<Integer> categoryAdministrator = getCategoryAdministratorList(reportId);
        int i = 0;
        for (i=0;i<categoryAdministrator.size();i++){
            if(currentUserId == categoryAdministrator.get(i))
                return true;
        }
        return false;
    }

    public boolean isChecked(Integer id){return this.sqlSession.selectOne("getCheckedStatus",id);}
}
