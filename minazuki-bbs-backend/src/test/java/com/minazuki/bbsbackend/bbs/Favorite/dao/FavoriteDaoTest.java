package com.minazuki.bbsbackend.bbs.Favorite.dao;

import com.minazuki.bbsbackend.bbs.Favorite.pojo.Favorite;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FavoriteDaoTest {

    @Resource
    private FavoriteDao favoriteDao;

    @Test
    void addFavorite() {
        Favorite favorite = Favorite.builder().themeId(1).OwnerId(1)
                .createdAt(LocalDateTime.now()).lastViewedAt(LocalDateTime.now()).build();
        favoriteDao.addFavorite(favorite);
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