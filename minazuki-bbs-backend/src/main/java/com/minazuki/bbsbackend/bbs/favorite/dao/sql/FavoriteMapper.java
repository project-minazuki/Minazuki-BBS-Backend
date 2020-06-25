package com.minazuki.bbsbackend.bbs.favorite.dao.sql;

import com.minazuki.bbsbackend.bbs.favorite.pojo.Favorite;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FavoriteMapper {
    @Insert("INSERT INTO favorite(favorite_theme_id,collector_id,created_time,last_viewed_time) " +
            "VALUES (#{themeId},#{OwnerId},#{createdAt},#{lastViewedAt})")
    void addFavorite(@Param("favorite") Favorite favorite);

    @Delete("DELETE FROM favorite WHERE id=#{id}")
    void deleteFavorite(@Param("id") Integer id);

    @Select("SELECT * FROM favorite WHERE collector_id = #{userId}")
    @Results({
            @Result(property = "themeId", column = "favorite_theme_id"),
            @Result(property = "OwnerId", column = "collector_id"),
            @Result(property = "createdAt", column = "created_time"),
            @Result(property = "lastViewedAt", column = "last_viewed_time")
    })
    List<Favorite> findAllThemes(@Param("userId") Integer userId);

    @Update("UPDATE favorite SET last_viewed_time = NOW() WHERE id = #{id}")
    void updateFavoriteLastViewedTime(@Param("id")Integer id);
}
