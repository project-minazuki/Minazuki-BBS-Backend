package com.minazuki.bbsbackend.bbs.category.dao.sql;

import com.minazuki.bbsbackend.bbs.category.dataObject.CategoryUpdateDto;
import com.minazuki.bbsbackend.bbs.category.pojo.Category;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CategoryMapper {
    @Insert("INSERT INTO category(category_name,status,description,created_time,updated_time,visits_count,cover_url) " +
            "VALUES (#{name},#{status},#{description},#{createdAt},#{updatedAt},#{visitsCount},#{coverUrl})")
    void addCategory(@Param("category") Category category);

    @Delete("DELETE FROM category WHERE id=#{id}")
    void deleteCategory(@Param("id") Integer id);

    @UpdateProvider(type = CategorySqlProvider.class, method = "updateCategoryById")
    void updateCategoryById(@Param("categoryUpdateDto") CategoryUpdateDto categoryUpdateDto);

    @Update("UPDATE category SET visits_count = visits_count + 1 WHERE id=#{id}")
    void addVisitsCountById(@Param("id") Integer id);


}
