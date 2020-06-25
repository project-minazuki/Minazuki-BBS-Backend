package com.minazuki.bbsbackend.bbs.favorite.service.impl;

import com.minazuki.bbsbackend.bbs.favorite.dao.FavoriteDao;
import com.minazuki.bbsbackend.bbs.favorite.dataobject.FavoriteCreateDto;
import com.minazuki.bbsbackend.bbs.favorite.pojo.Favorite;
import com.minazuki.bbsbackend.bbs.favorite.service.FavoriteService;

import java.util.List;

public class FavoriteServiceImpl implements FavoriteService {

    FavoriteDao favoriteDao;

    public FavoriteServiceImpl(FavoriteDao favoriteDao)
    {
        this.favoriteDao = favoriteDao;
    }

    @Override
    public Favorite getByIndex(Integer id) {
        return null;
    }

    @Override
    public void addFavorite(FavoriteCreateDto favoriteCreateDto) {

    }

    @Override
    public void deleteFavorite(Integer id) {

    }

    @Override
    public void updateLastViewedTime(Integer id) {

    }

    @Override
    public List<Favorite> getAllFavoriteByUserId(Integer userId) {
        return null;
    }
}
