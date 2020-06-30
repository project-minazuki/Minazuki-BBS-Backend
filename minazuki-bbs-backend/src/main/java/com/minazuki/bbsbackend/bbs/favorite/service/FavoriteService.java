package com.minazuki.bbsbackend.bbs.favorite.service;

import com.minazuki.bbsbackend.bbs.favorite.dataobject.FavoriteCreateDto;
import com.minazuki.bbsbackend.bbs.favorite.pojo.Favorite;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FavoriteService {

    void addFavorite(FavoriteCreateDto favoriteCreateDto);

    void deleteFavorite(Integer id);

    //考虑删除
    Favorite getByIndex(Integer id);

    List<Favorite> getAllFavorite();

    Favorite getByIndexAndUpdate(Integer id);
}
