package com.minazuki.bbsbackend.bbs.favorite.service.impl;

import com.minazuki.bbsbackend.bbs.favorite.dao.FavoriteDao;
import com.minazuki.bbsbackend.bbs.favorite.dataobject.FavoriteCreateDto;
import com.minazuki.bbsbackend.bbs.favorite.pojo.Favorite;
import com.minazuki.bbsbackend.bbs.favorite.service.FavoriteService;
import com.minazuki.bbsbackend.user.interceptor.AuthenticationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FavoriteServiceImpl implements FavoriteService {

    private final FavoriteDao favoriteDao;

    public FavoriteServiceImpl(FavoriteDao favoriteDao)
    {
        this.favoriteDao = favoriteDao;
    }

    @Override
    public Favorite getByIndex(Integer id) {
        return favoriteDao.getFavoriteById(id);
    }

    @Override
    public void addFavorite(FavoriteCreateDto favoriteCreateDto) {
        favoriteCreateDto.setOwnerId(AuthenticationInterceptor.getCurrentUserId());
        favoriteDao.addFavorite(favoriteCreateDto);
    }

    @Override
    public void deleteFavorite(Integer id) {
        favoriteDao.deleteFavorite(id);
    }

    private void updateLastViewedTime(Integer id) {
        favoriteDao.updateFavoriteLastViewedTime(id);
    }

    @Override
    public List<Favorite> getAllFavorite() {
        return favoriteDao.findAllFavorites(AuthenticationInterceptor.getCurrentUserId());
    }

    @Override
    public Favorite getByIndexAndUpdate(Integer id)
    {
        updateLastViewedTime(id);
        return getByIndex(id);
    }
}
