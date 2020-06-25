package com.minazuki.bbsbackend.bbs.favorite.dao;

import com.minazuki.bbsbackend.bbs.favorite.pojo.Favorite;
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
