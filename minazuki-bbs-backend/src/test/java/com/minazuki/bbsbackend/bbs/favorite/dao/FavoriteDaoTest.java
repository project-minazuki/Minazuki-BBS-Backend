package com.minazuki.bbsbackend.bbs.favorite.dao;

import com.minazuki.bbsbackend.bbs.favorite.dataobject.FavoriteCreateDto;
import com.minazuki.bbsbackend.bbs.favorite.pojo.Favorite;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.time.LocalDateTime;

@SpringBootTest
class FavoriteDaoTest {

    @Resource
    private FavoriteDao favoriteDao;

    @Test
    void addFavorite() {
        FavoriteCreateDto favoriteCreateDto = new FavoriteCreateDto();
        favoriteCreateDto.setThemeId(1);
        favoriteCreateDto.setOwnerId(1);
        favoriteDao.addFavorite(favoriteCreateDto);
    }

    @Test
    void deleteFavorite() {
        Integer id = 1;
        favoriteDao.deleteFavorite(id);
    }

    @Test
    void findAllFavorites() {
        System.out.println(favoriteDao.findAllFavorites(1));
    }

    @Test
    void updateFavoriteLastViewedTime() {
        favoriteDao.updateFavoriteLastViewedTime(1);
    }
}