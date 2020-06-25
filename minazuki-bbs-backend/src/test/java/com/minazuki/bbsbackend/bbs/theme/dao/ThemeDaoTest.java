package com.minazuki.bbsbackend.bbs.theme.dao;

import com.minazuki.bbsbackend.bbs.theme.dataobject.ThemeUpdateDto;
import com.minazuki.bbsbackend.bbs.theme.pojo.Theme;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.time.LocalDateTime;

@SpringBootTest
class ThemeDaoTest {
    @Resource
    private ThemeDao themeDao;

    @Test
    void addTheme() {
        Theme theme = Theme.builder().isTop(true).isHighQuality(true).status(true).title("nmsl").categoryId(1)
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

        themeDao.updateThemeById(themeUpdateDto);

    }
}