package com.minazuki.bbsbackend.bbs.theme.service.impl;

import com.minazuki.bbsbackend.bbs.categorymoderator.dao.CategoryModeratorDao;
import com.minazuki.bbsbackend.bbs.tag.dao.TagDao;
import com.minazuki.bbsbackend.bbs.tag.dataobject.ThemeTagLinkDto;
import com.minazuki.bbsbackend.bbs.tag.pojo.Tag;
import com.minazuki.bbsbackend.bbs.theme.dao.ThemeDao;
import com.minazuki.bbsbackend.bbs.theme.dataobject.ThemeCheckDto;
import com.minazuki.bbsbackend.bbs.theme.dataobject.ThemeCreateDto;
import com.minazuki.bbsbackend.bbs.theme.dataobject.ThemeUpdateDto;
import com.minazuki.bbsbackend.bbs.theme.exception.DuplicateThemeInfoException;
import com.minazuki.bbsbackend.bbs.theme.pojo.Theme;
import com.minazuki.bbsbackend.bbs.theme.service.ThemeService;
import com.minazuki.bbsbackend.bbs.themereport.dao.ThemeReportDao;
import com.minazuki.bbsbackend.user.exception.PermissionDeniedException;
import com.minazuki.bbsbackend.user.interceptor.AuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class ThemeServiceImpl implements ThemeService {
    private final ThemeDao themeDao;
    private final ThemeReportDao themeReportDao;
    private final TagDao tagDao;
    private final CategoryModeratorDao categoryModeratorDao;

    @Autowired
    public ThemeServiceImpl(ThemeDao themeDao,ThemeReportDao themeReportDao, TagDao tagDao, CategoryModeratorDao categoryModeratorDao) {
        this.tagDao = tagDao;
        this.themeDao = themeDao;
        this.themeReportDao = themeReportDao;
        this.categoryModeratorDao = categoryModeratorDao;
    }

    //创建一个新主题，同一个板块下不可有标题相同的主题帖，否则抛出DuplicateThemeInfoException异常
    @Override
    public void createTheme(ThemeCreateDto themeCreateDto) throws DuplicateThemeInfoException {
        //新建一个ThemeCheckDto以备检测
        ThemeCheckDto uniqueCheckDto = new ThemeCheckDto();
        uniqueCheckDto.setCategoryId(themeCreateDto.getCategoryId());
        uniqueCheckDto.setTitle(themeCreateDto.getTitle());

        if (themeDao.isThemeUnique(uniqueCheckDto)) {
            themeCreateDto.setCreatorId(AuthenticationInterceptor.getCurrentUserId());
            themeDao.addTheme(themeCreateDto);
            // 处理主题帖的tags
            for (Tag tag: themeCreateDto.getTags()
                 ) {
                ThemeTagLinkDto themeTagLinkDto = new ThemeTagLinkDto();
                themeTagLinkDto.setTagId(tag.getId());
                themeTagLinkDto.setThemeId(themeDao.getThemeByTitleAndCategory(uniqueCheckDto).getId());
                themeDao.addTagToTheme(themeTagLinkDto);
            }
        } else {
            throw new DuplicateThemeInfoException();
        }
    }

    //找版块下的所有主题帖
    @Override
    public List<Theme> getThemeListByCategoryId(Integer categoryId) {

        List<Theme> themes = themeDao.getThemeByCategoryId(categoryId);
        for (Theme theme: themes
             ) {
            packageTheme(theme);
        }
        return themes;
    }

    @Override
    public List<Theme> getHighQualityThemeByCategoryId(Integer categoryId) {
        List<Theme> themes = themeDao.getHighQualityThemeByCategoryId(categoryId);
        for (Theme theme: themes
             ) {
            packageTheme(theme);
        }
        return themes;
    }

    @Override
    public List<Theme> getTopThemeByCategoryId(Integer categoryId) {
        List<Theme> themes = themeDao.getTopThemeByCategoryId(categoryId);
        for (Theme theme : themes) {
            packageTheme(theme);
        }
        return themes;
    }

    //根据Id找主题帖
    @Override
    public Theme getThemeByIndex(Integer id) {
        this.themeDao.increaseVisitsCountById(id);
        Theme theme = themeDao.getThemeById(id);
        packageTheme(theme);
        return theme;
    }

    //设置，取消置顶
    @Override
    public void setTopById(Integer id) throws PermissionDeniedException{
        if(categoryModeratorDao.getModeratorIds(themeDao.getCategoryIdOfThemeById(id))
                .contains(AuthenticationInterceptor.getCurrentUserId())){
            this.themeDao.setTopById(id);
        }else {
            throw new PermissionDeniedException();
        }
    }

    @Override
    public void cancelTopById(Integer id) throws PermissionDeniedException{
        if(categoryModeratorDao.getModeratorIds(themeDao.getCategoryIdOfThemeById(id))
                .contains(AuthenticationInterceptor.getCurrentUserId())){
            this.themeDao.cancelTopById(id);
        }else {
            throw new PermissionDeniedException();
        }
    }

    //设置，取消精品
    @Override
    public void setHighQuality(Integer id) throws PermissionDeniedException {
        if(categoryModeratorDao.getModeratorIds(themeDao.getCategoryIdOfThemeById(id))
                .contains(AuthenticationInterceptor.getCurrentUserId())){
            themeDao.setHighQualityById(id);
        }else {
            throw new PermissionDeniedException();
        }

    }

    @Override
    public void cancelHighQuality(Integer id) throws PermissionDeniedException {
        if(categoryModeratorDao.getModeratorIds(themeDao.getCategoryIdOfThemeById(id))
                .contains(AuthenticationInterceptor.getCurrentUserId())){
            themeDao.cancelHighQualityById(id);
        }else {
            throw new PermissionDeniedException();
        }

    }


    //更新主题帖，同一个板块下不可有标题相同的主题帖，否则抛出DuplicateThemeInfoException异常
    @Override
    public void updateThemeTitle(ThemeUpdateDto themeUpdateDto) throws DuplicateThemeInfoException, PermissionDeniedException {
        //获取该主题所在版块的Id以及主题帖的Id
        Integer categoryId = themeDao.getCategoryIdOfThemeById(themeUpdateDto.getId());
        Integer themeId = themeUpdateDto.getId();
        //新建一个ThemeCheckDto以备检测
        ThemeCheckDto uniqueCheckDto = new ThemeCheckDto();
        uniqueCheckDto.setTitle(themeUpdateDto.getTitle());
        uniqueCheckDto.setCategoryId(categoryId);

        if(themeDao.isUserCreatorOfTheTheme(themeId)){
            if(themeUpdateDto.isNoTitle()) return;

            if (themeDao.isThemeUnique(uniqueCheckDto)) {
                themeDao.updateThemeTitle(themeUpdateDto);
            }
            else {
                throw new DuplicateThemeInfoException();
            }
        }
        else {
            throw new PermissionDeniedException();
        }

    }


    //visitsCount+1
    @Override
    public void increaseVisitsCountById(Integer id) {
        themeDao.increaseVisitsCountById(id);
    }

    //visitsCount-1
    @Override
    public void decreaseVisitsCountById(Integer id) {
        themeDao.decreaseVisitsCountById(id);
    }

    //replyCount+1
    @Override
    public void increaseReplyCountById(Integer id) {
        themeDao.increaseReplyCountById(id);
    }

    //replyCount-1
    @Override
    public void decreaseReplyCountById(Integer id) {
        themeDao.decreaseReplyCountById(id);
    }

    @Override
    public List<Theme> findTop10ByVisitsCount() {
        List<Theme> list = themeDao.getReplyCountTOP10();
        for (Theme theme: list
             ) {
            packageTheme(theme);
        }
        return list;
    }

    @Override
    public List<Theme> findTop10ByReplyCount() {
        List<Theme> list = themeDao.getReplyCountTOP10();
        for (Theme theme: list
        ) {
            packageTheme(theme);
        }
        return list;
    }

    //找所有板块下与该名称类似的主题帖
    @Override
    public List<Theme> searchThemeByTitle(String title) {
        List<Theme> themes = themeDao.searchThemeByTitle(title);
        for (Theme theme: themes
             ) {
            packageTheme(theme);
        }
        return themes;
    }


    @Override
    public List<Theme> getAllThemes() {
        List<Theme> themes = themeDao.selectAll();
        for (Theme theme: themes
             ) {
            packageTheme(theme);
        }
        return themes;
    }

    @Override
    public void deleteThemeById(Integer id) throws PermissionDeniedException{
        if(themeDao.isUserCreatorOfTheTheme(id) || categoryModeratorDao.getModeratorIds(themeDao.getCategoryIdOfThemeById(id))
                .contains(AuthenticationInterceptor.getCurrentUserId())){
            themeDao.deleteTheme(id);
        }
        else {
            throw new PermissionDeniedException();
        }
    }

    @Override
    public void addTagToTheme(ThemeTagLinkDto themeTagLinkDto) throws PermissionDeniedException{
        if(themeDao.isUserCreatorOfTheTheme(themeTagLinkDto.getThemeId())) {
            this.themeDao.addTagToTheme(themeTagLinkDto);
        }
        else {
            throw new PermissionDeniedException();
        }
    }

    @Override
    public void removeTagFromTheme(ThemeTagLinkDto themeTagLinkDto) throws PermissionDeniedException{
        if(themeDao.isUserCreatorOfTheTheme(themeTagLinkDto.getThemeId())) {
            this.themeDao.deleteTagFromTheme(themeTagLinkDto);
        }
        else {
            throw new PermissionDeniedException();
        }
    }

    @Override
    public List<Tag> getTagList() {
        return tagDao.getAllTags();
    }

    public void packageTheme(Theme theme) {
        /**
         * @Description: 组装theme，加入tags
         * @param [theme]
         * @return void
         * @author hlodice
         * @date 2020/6/29 17:27
         */
        theme.setTags(themeDao.getTagsOfTheme(theme.getId()));
    }
}
