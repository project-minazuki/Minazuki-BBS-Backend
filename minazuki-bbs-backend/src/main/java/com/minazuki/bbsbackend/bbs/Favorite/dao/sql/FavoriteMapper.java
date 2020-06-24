package com.minazuki.bbsbackend.bbs.Favorite.dao.sql;

import com.minazuki.bbsbackend.bbs.Favorite.pojo.Favorite;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FavoriteMapper {
    @Insert("INSERT INTO favorite(favorite_theme_id,collector_id,created_time) " +
            "VALUES (#{themeId},#{OwnerId},#{createdAt})")
    void addFavorite(@Param("favorite") Favorite favorite);

    @Delete("DELETE FROM favorite WHERE id=#{id}")
    void deleteFavorite(@Param("id") Integer id);
}
