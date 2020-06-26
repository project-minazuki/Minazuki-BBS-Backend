package com.minazuki.bbsbackend.bbs.theme.service;

import com.minazuki.bbsbackend.bbs.category.service.impl.CategoryServiceImpl;
import com.minazuki.bbsbackend.bbs.theme.dao.ThemeDao;
import com.minazuki.bbsbackend.bbs.theme.dataobject.ThemeCheckDto;
import com.minazuki.bbsbackend.bbs.theme.dataobject.ThemeCreateDto;
import com.minazuki.bbsbackend.bbs.theme.dataobject.ThemeUpdateDto;
import com.minazuki.bbsbackend.bbs.theme.exception.DuplicateThemeInfoException;
import com.minazuki.bbsbackend.bbs.theme.pojo.Theme;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

@Service
@Transactional
public class ThemeServiceImpl implements ThemeService {
    private final ThemeDao themeDao;

    @Autowired
    public ThemeServiceImpl(ThemeDao themeDao) {
        this.themeDao = themeDao;
    }

    //创建一个新主题，同一个板块下不可有标题相同的主题帖，否则抛出DuplicateThemeInfoException异常
    @Override
    public void createTheme(ThemeCreateDto themeCreateDto) throws DuplicateThemeInfoException {
        //新建一个ThemeCheckDto以备检测
        ThemeCheckDto uniqueCheckDto = new ThemeCheckDto();
        uniqueCheckDto.setCategoryId(themeCreateDto.getCategoryId());
        uniqueCheckDto.setTitle(themeCreateDto.getTitle());

        if (themeDao.isThemeUnique(uniqueCheckDto)) {
            Theme newTheme = Theme.builder().title(themeCreateDto.getTitle()).categoryId(themeCreateDto.getCategoryId())
                    .creatorId(themeCreateDto.getCreatorId()).status(true).isHighQuality(false).isTop(false)
                    .visitsCount(0).replyCount(0).updatedAt(LocalDateTime.now()).createdAt(LocalDateTime.now())
                    .latestReplyAt(null).build();
            themeDao.addTheme(newTheme);
        } else {
            throw new DuplicateThemeInfoException();
        }
    }

    //找版块下的所有主题帖
    @Override
    public List<Theme> getThemeListByCategoryId(Integer id) {
        return themeDao.getThemeByCategoryId(id);
    }

    //找所有为该标题的主题贴
    @Override
    public List<Theme> getThemeListByTitle(String title) {
        return themeDao.getThemeByTitle(title);
    }

    //根据Id找主题帖
    @Override
    public Theme getThemeByIndex(Integer id) {
        return themeDao.getThemeById(id);
    }

    //设置，取消置顶
    @Override
    public void setTopById(Integer id) {
        themeDao.setTopById(id);
    }

    @Override
    public void cancelTopById(Integer id) {
        themeDao.cancelTopById(id);
    }

    //设置，取消精品
    @Override
    public void setHighQuality(Integer id) {
        themeDao.setHighQualityById(id);
    }

    @Override
    public void cancelHighQuality(Integer id) {
        themeDao.cancelHighQualityById(id);
    }


    //更新主题帖，同一个板块下不可有标题相同的主题帖，否则抛出DuplicateThemeInfoException异常
    @Override
    public void updateTheme(ThemeUpdateDto themeUpdateDto) throws DuplicateThemeInfoException {
        //获取该主题所在版块的Id
        Integer categoryId = themeDao.getCategoryIdOfThemeById(themeUpdateDto.getId());
        //新建一个ThemeCheckDto以备检测
        ThemeCheckDto uniqueCheckDto = new ThemeCheckDto();
        uniqueCheckDto.setTitle(themeUpdateDto.getTitle());
        uniqueCheckDto.setCategoryId(categoryId);

        if (themeDao.isThemeUnique(uniqueCheckDto)) {
            themeUpdateDto.setUpdatedAt(LocalDateTime.now());
            themeDao.updateTheme(themeUpdateDto);
        }
        else {
            throw new DuplicateThemeInfoException();
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
        List<Theme> list = themeDao.selectAll();
        List<Theme> resList = new ArrayList<Theme>();
        Theme defaultTheme = Theme.builder().id(-1).visitsCount(-1).build();
        int i = 0;
        for(i=0;i<=9;i++){
            resList.add(defaultTheme);
        }
        for(i=0;i<=list.size();i++){
            if(list.get(i).getVisitsCount() >= resList.get(9).getVisitsCount()){
                resList.add(9,list.get(i));
                rankListByVisitsCount(resList);
            }
        }
        return resList;
    }

    public void rankListByVisitsCount(List<Theme> listOf10){
        int i = 0;
        int j = 0;
        for(i=1;i<=9;i++){
            for(j=i;j>=1;j--){
                if (listOf10.get(j).getVisitsCount()>listOf10.get(j-1).getVisitsCount()){
                    Theme tempTheme = listOf10.get(j);
                    listOf10.add(j,listOf10.get(j-1));
                    listOf10.add(j-1,tempTheme);
                }
            }
        }
    }

    @Override
    public List<Theme> findTop10ByReplyCount() {
        List<Theme> list = themeDao.selectAll();
        List<Theme> resList = new ArrayList<Theme>();
        Theme defaultTheme = Theme.builder().id(-1).replyCount(-1).build();
        int i = 0;
        for(i=0;i<=9;i++){
            resList.add(defaultTheme);
        }
        for(i=0;i<=list.size();i++){
            if(list.get(i).getReplyCount() >= resList.get(9).getReplyCount()){
                resList.add(9,list.get(i));
                rankListByReplyCount(resList);
            }
        }
        return resList;
    }

    public void rankListByReplyCount(List<Theme> listOf10){
        int i = 0;
        int j = 0;
        for(i=1;i<=9;i++){
            for(j=i;j>=1;j--){
                if (listOf10.get(j).getReplyCount()>listOf10.get(j-1).getReplyCount()){
                    Theme tempTheme = listOf10.get(j);
                    listOf10.add(j,listOf10.get(j-1));
                    listOf10.add(j-1,tempTheme);
                }
            }
        }
    }


}
