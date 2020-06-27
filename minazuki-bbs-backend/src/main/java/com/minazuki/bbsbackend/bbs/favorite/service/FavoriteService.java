package com.minazuki.bbsbackend.bbs.favorite.service;

import com.minazuki.bbsbackend.bbs.favorite.dataobject.FavoriteCreateDto;
import com.minazuki.bbsbackend.bbs.favorite.pojo.Favorite;

import java.util.List;

public interface FavoriteService {

    Favorite getByIndex(Integer id);

    void addFavorite(FavoriteCreateDto favoriteCreateDto);

    void deleteFavorite(Integer id);

    void updateLastViewedTime(Integer id);

    List<Favorite> getAllFavoriteByUserId(Integer userId);

    Favorite getByIndexAndUpdate(Integer id);
}
