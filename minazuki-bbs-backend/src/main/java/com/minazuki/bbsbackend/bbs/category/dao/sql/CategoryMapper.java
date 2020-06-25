package com.minazuki.bbsbackend.bbs.category.dao.sql;

import com.minazuki.bbsbackend.bbs.category.dataobject.CategoryUpdateDto;
import com.minazuki.bbsbackend.bbs.category.pojo.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {
    @Insert("INSERT INTO category(category_name,status,description,created_time,updated_time,visits_count,cover_url) " +
            "VALUES (#{name},#{status},#{description},#{createdAt},#{updatedAt},#{visitsCount},#{coverUrl})")
    void addCategory(@Param("category") Category category);

    @Select("SELECT * FROM category WHERE id = #{id}")
    @Results({
            @Result(property = "createdAt", column = "created_time"),
            @Result(property = "updatedAt", column = "updated_time"),
            @Result(property = "visitsCount", column = "visits_count"),
            @Result(property = "coverUrl", column = "cover_url")
    })
    Category getCategoryById(@Param("id") Integer id);

    @Select("SELECT * FROM category WHERE category_name like #{categoryName}")
    @Results({
            @Result(property = "createdAt", column = "created_time"),
            @Result(property = "updatedAt", column = "updated_time"),
            @Result(property = "visitsCount", column = "visits_count"),
            @Result(property = "coverUrl", column = "cover_url")
    })
    Category getCategoryByName(@Param("categoryName") String categoryName);

    @Select("SELECT * FROM category")
    @Results({
            @Result(property = "createdAt", column = "created_time"),
            @Result(property = "updatedAt", column = "updated_time"),
            @Result(property = "visitsCount", column = "visits_count"),
            @Result(property = "coverUrl", column = "cover_url")
    })
    List<Category> findAllCategories();

    @Select("SELECT * FROM category WHERE status = 1")
    @Results({
            @Result(property = "createdAt", column = "created_time"),
            @Result(property = "updatedAt", column = "updated_time"),
            @Result(property = "visitsCount", column = "visits_count"),
            @Result(property = "coverUrl", column = "cover_url")
    })
    List<Category> findAllOpenCategories();

    @Delete("DELETE FROM category WHERE id=#{id}")
    void deleteCategory(@Param("id") Integer id);

    @UpdateProvider(type = CategorySqlProvider.class, method = "updateCategoryById")
    void updateCategoryById(@Param("categoryUpdateDto") CategoryUpdateDto categoryUpdateDto);

    @Update("UPDATE category SET visits_count = visits_count + 1 WHERE id=#{id}")
    void addVisitsCountById(@Param("id") Integer id);


}
