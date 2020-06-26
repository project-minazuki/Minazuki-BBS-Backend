package com.minazuki.bbsbackend.bbs.theme.dao;

import com.minazuki.bbsbackend.bbs.theme.dataobject.ThemeCheckDto;
import com.minazuki.bbsbackend.bbs.theme.dataobject.ThemeUpdateDto;
import com.minazuki.bbsbackend.bbs.theme.pojo.Theme;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class ThemeDaoTest {
    @Resource
    private ThemeDao themeDao;

    @Test
    void addTheme() {
        Theme theme = Theme.builder().isTop(true).isHighQuality(true).status(true).title("怎么能说脏话呢").categoryId(2)
                .creatorId(1).visitsCount(777).replyCount(777).latestReplyAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now()).createdAt(LocalDateTime.now()).build();
        themeDao.addTheme(theme);
    }

    @Test
    void deleteTheme() {
        Integer id = 1;
        themeDao.deleteTheme(id);
    }

    @Test
    void updateThemeById(){
        ThemeUpdateDto themeUpdateDto = new ThemeUpdateDto();
        themeUpdateDto.setIsTop(true);themeUpdateDto.setIsHighQuality(true);themeUpdateDto.setTitle("从现在开始，我要起飞了");
        themeUpdateDto.setStatus(false);themeUpdateDto.setLatestReplyAt(LocalDateTime.now());
        themeUpdateDto.setUpdatedAt(LocalDateTime.now());themeUpdateDto.setVisitsCount(111);themeUpdateDto.setReplyCount(222);
        themeUpdateDto.setId(1);

        themeDao.updateTheme(themeUpdateDto);
    }


    @Test
    void getThemeByCategoryId() {
        Integer id = 1;
        List<Theme> list = themeDao.getThemeByCategoryId(id);
        System.out.println(list);
    }

    @Test
    void getThemeById() {
        Integer id = 1;
        Theme theme = themeDao.getThemeById(id);
        System.out.println(theme);
    }

    @Test
    void getThemeByTitle() {
        String title = "怎么能说脏话呢";
        List<Theme> list = themeDao.getThemeByTitle(title);
        System.out.println(list);
    }

    @Test
    void isThemeUnique() {
        ThemeCheckDto themeCheckDto = new ThemeCheckDto();
        themeCheckDto.setCategoryId(1);
        themeCheckDto.setTitle("怎么能说脏话呢");
        boolean flag = themeDao.isThemeUnique(themeCheckDto);
        System.out.println(flag);

    }

    @Test
    void setTopById() {
        Integer id = 2;
        themeDao.setTopById(id);
    }

    @Test
    void cancelTopById() {
        Integer id = 2;
        themeDao.cancelTopById(id);
    }

    @Test
    void setHighQualityById() {
        Integer id = 2;
        themeDao.setHighQualityById(id);
    }

    @Test
    void cancelHighQualityById() {
        Integer id = 2;
        themeDao.cancelHighQualityById(id);
    }

    @Test
    void getCategoryIdOfThemeById() {
        Integer id = 5;
        Integer categoryId = themeDao.getCategoryIdOfThemeById(id);
        System.out.println(categoryId);
    }

    @Test
    void increaseVisitsCountById() {
        Integer id = 2;
        themeDao.increaseVisitsCountById(id);

    }

    @Test
    void decreaseVisitsCountById() {
        Integer id = 2;
        themeDao.decreaseVisitsCountById(id);
    }

    @Test
    void increaseReplyCountById() {
        Integer id = 2;
        themeDao.increaseReplyCountById(id);
    }

    @Test
    void decreaseReplyCountById() {
        Integer id = 2;
        themeDao.decreaseReplyCountById(id);
    }
}