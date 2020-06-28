package com.minazuki.bbsbackend.bbs.theme.dao;

import com.minazuki.bbsbackend.bbs.theme.dataobject.ThemeCheckDto;
import com.minazuki.bbsbackend.bbs.theme.dataobject.ThemeCreateDto;
import com.minazuki.bbsbackend.bbs.theme.dataobject.ThemeUpdateDto;
import com.minazuki.bbsbackend.bbs.theme.pojo.Theme;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

@SpringBootTest
class ThemeDaoTest {
    @Resource
    private ThemeDao themeDao;

    @Test
    void addTheme() {
        ThemeCreateDto themeCreateDto = new ThemeCreateDto();
        themeCreateDto.setCategoryId(2);
        themeCreateDto.setCreatorId(4);
        themeCreateDto.setTitle("12123123");
        themeDao.addTheme(themeCreateDto);
    }

    @Test
    void deleteTheme() {
        Integer id = 1;
        themeDao.deleteTheme(id);
    }

    @Test
    void updateThemeById(){
        ThemeUpdateDto themeUpdateDto = new ThemeUpdateDto();
        themeUpdateDto.setTitle("从现在开始，我要起飞了");
        themeUpdateDto.setId(1);

        themeDao.updateThemeTitle(themeUpdateDto);
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
        Integer id = 17;

        //自定义访问数
        Integer visitsCount = 10;
        int i = 1;
        for(i=1;i<=visitsCount;i++){
            themeDao.increaseVisitsCountById(id);
        }

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

    @Test
    void getVisitsCountTOP10(){
        List<Theme> list = themeDao.getVisitsCountTOP10();
        int i = 0;
        for(i=0;i<=9;i++){
            System.out.println(list.get(i));
        }
    }

    @Test
    void searchThemeByTitle(){
        String title = "测试";
        List<Theme> list = themeDao.searchThemeByTitle(title);
        System.out.println(list);
    }

    @Test
    void getCategoryAdminIdOfTheTheme(){
        Integer themeId = 9;
        List<Integer> list = themeDao.getCategoryAdminIdOfTheTheme(themeId);
        System.out.println(list);
    }

    @Test
    void isUserCreatorOfTheTheme(){
        Integer themeId = 9;
        boolean flag = themeDao.isUserCreatorOfTheTheme(themeId);
        System.out.println(flag);
    }
}