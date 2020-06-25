package com.minazuki.bbsbackend.bbs.favorite.dao;

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
        Favorite favorite = Favorite.builder().themeId(2).OwnerId(1)
                .createdAt(LocalDateTime.now()).build();
        favoriteDao.addFavorite(favorite);
    }

    @Test
    void deleteFavorite() {
        Integer id = 1;
        favoriteDao.deleteFavorite(id);
    }
}