package com.minazuki.bbsbackend.bbs.theme.service;

import com.minazuki.bbsbackend.bbs.theme.dataobject.ThemeCreateDto;
import com.minazuki.bbsbackend.bbs.theme.dataobject.ThemeUpdateDto;
import com.minazuki.bbsbackend.bbs.theme.exception.DuplicateThemeInfoException;
import com.minazuki.bbsbackend.bbs.theme.pojo.Theme;
import com.minazuki.bbsbackend.bbs.themereport.dataobject.ThemeReportCreateDto;
import com.minazuki.bbsbackend.bbs.themereport.pojo.ThemeReport;
import com.minazuki.bbsbackend.user.exception.PermissionDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ThemeService {


    //新建主题帖
    void createTheme(ThemeCreateDto themeCreateDto) throws DuplicateThemeInfoException;

    //根据版块Id搜索主题帖
    List<Theme> getThemeListByCategoryId(Integer categoryId);
    List<Theme> getHighQualityThemeByCategoryId(Integer categoryId);
    List<Theme> getTopThemeByCategoryId(Integer categoryId);

    //根据Id搜索主题帖
    Theme getThemeByIndex(Integer id);

    //设置，取消置顶
    void setTopById(Integer id) throws PermissionDeniedException;
    void cancelTopById(Integer id) throws PermissionDeniedException;

    //设置，取消精品
    void setHighQuality(Integer id) throws PermissionDeniedException;
    void cancelHighQuality(Integer id) throws PermissionDeniedException;

    //更新主题帖
    void updateThemeTitle(ThemeUpdateDto themeUpdateDto) throws DuplicateThemeInfoException,PermissionDeniedException;

    //添加，减少访问数或回复数(+1,-1)
    void increaseVisitsCountById(Integer id);
    void decreaseVisitsCountById(Integer id);
    void increaseReplyCountById(Integer id);
    void decreaseReplyCountById(Integer id);

    //找到访问数的Top10
    List<Theme> findTop10ByVisitsCount();

    //找到回复数的Top10
    List<Theme> findTop10ByReplyCount();

    //搜索与主题帖名称类似的主题帖
    List<Theme> searchThemeByTitle(String title);

    //寻找所有的主题帖
    List<Theme> getAllThemes();

    //根据Id删除主题帖
    void deleteThemeById(Integer id) throws PermissionDeniedException;


}
