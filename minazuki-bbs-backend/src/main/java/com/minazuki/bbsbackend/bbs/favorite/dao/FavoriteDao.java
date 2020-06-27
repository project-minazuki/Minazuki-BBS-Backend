package com.minazuki.bbsbackend.bbs.favorite.dao;

import com.minazuki.bbsbackend.bbs.favorite.dataobject.FavoriteCreateDto;
import com.minazuki.bbsbackend.bbs.favorite.pojo.Favorite;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class FavoriteDao {
    private final SqlSession sqlSession;
    @Autowired
    public FavoriteDao(SqlSession sqlSession){this.sqlSession = sqlSession;}

    public void addFavorite(FavoriteCreateDto favoriteCreateDto){this.sqlSession.insert("addFavorite",favoriteCreateDto);}

    public void deleteFavorite(Integer id){this.sqlSession.delete("deleteFavorite", id);}

    public Favorite getFavoriteById(Integer id) {
        return this.sqlSession.selectOne("getFavoriteById", id);
    }

    public List<Favorite> findAllFavorites(Integer userId) {
        return sqlSession.selectList("findAllThemes", userId);
    }

    public void updateFavoriteLastViewedTime(Integer id) {
        this.sqlSession.update("updateFavoriteLastViewedTime", id);
    }
}
