package com.minazuki.bbsbackend.bbs.categoryModerator.dao.sql;

import com.minazuki.bbsbackend.bbs.categoryModerator.dataObject.PrimaryKeyDto;
import com.minazuki.bbsbackend.bbs.categoryModerator.pojo.CategoryModerator;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CategoryModeratorMapper {
    @Insert("INSERT INTO category_admin(category_admin_id,managed_category_id,created_time) " +
            "VALUES (#{moderatorId},#{categoryId},#{createdAt})")
    void addCategoryModerator(@Param("categoryModerator") CategoryModerator categoryModerator);

    @Delete("DELETE FROM category_admin WHERE category_admin_id=#{moderatorId} AND managed_category_id=#{categoryId}")
    void deleteCategoryModerator(@Param("primaryKeyDto") PrimaryKeyDto primaryKeyDto);
}
