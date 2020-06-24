package com.minazuki.bbsbackend.bbs.Favorite.dao;

import com.minazuki.bbsbackend.bbs.Favorite.pojo.Favorite;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FavoriteDao {
    private final SqlSession sqlSession;
    @Autowired
    public FavoriteDao(SqlSession sqlSession){this.sqlSession = sqlSession;}

    public void addFavorite(Favorite favorite){this.sqlSession.insert("addFavorite",favorite);}

    public void deleteFavorite(Integer id){this.sqlSession.delete("deleteFavorite", id);}
}
