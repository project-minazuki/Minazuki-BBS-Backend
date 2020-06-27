package com.minazuki.bbsbackend.bbs.theme.service;

import com.minazuki.bbsbackend.bbs.theme.dataobject.ThemeCreateDto;
import com.minazuki.bbsbackend.bbs.theme.dataobject.ThemeUpdateDto;
import com.minazuki.bbsbackend.bbs.theme.exception.DuplicateThemeInfoException;
import com.minazuki.bbsbackend.bbs.theme.pojo.Theme;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ThemeService {


    //新建主题帖
    void createTheme(ThemeCreateDto themeCreateDto) throws DuplicateThemeInfoException;

    //根据版块Id搜索主题帖
    List<Theme> getThemeListByCategoryId(Integer id);

    //根据Id搜索主题帖
    Theme getThemeByIndex(Integer id);

    //设置，取消置顶
    void setTopById(Integer id);
    void cancelTopById(Integer id);

    //设置，取消精品
    void setHighQuality(Integer id);
    void cancelHighQuality(Integer id);

    //更新主题帖
    void updateThemeTitle(ThemeUpdateDto themeUpdateDto) throws DuplicateThemeInfoException;

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


}
