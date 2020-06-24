package com.minazuki.bbsbackend.bbs.category.dao.sql;

import com.minazuki.bbsbackend.bbs.category.pojo.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CategoryMapper {
    @Insert("INSERT INTO category(category_name,status,description,created_time,updated_time,visits_count,cover_url) " +
            "VALUES (#{name},#{status},#{description},#{createdAt},#{updatedAt},#{visitsCount},#{coverUrl})")
    void addCategory(@Param("category") Category category);

    @Delete("DELETE FROM category WHERE id=#{id}")
    void deleteCategory(@Param("id") Integer id);
}
