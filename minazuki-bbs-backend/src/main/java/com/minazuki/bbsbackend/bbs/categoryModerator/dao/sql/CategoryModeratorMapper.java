package com.minazuki.bbsbackend.bbs.categoryModerator.dao.sql;

import com.minazuki.bbsbackend.bbs.categoryModerator.dataObject.PrimaryKeyDto;
import com.minazuki.bbsbackend.bbs.categoryModerator.pojo.CategoryModerator;
import java.util.List;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CategoryModeratorMapper {
    @Insert("INSERT INTO category_admin(category_admin_id,managed_category_id,created_time) " +
            "VALUES (#{moderatorId},#{categoryId},#{createdAt})")
    void addCategoryModerator(@Param("categoryModerator") CategoryModerator categoryModerator);

    @Delete("DELETE FROM category_admin WHERE category_admin_id=#{moderatorId} AND managed_category_id=#{categoryId}")
    void deleteCategoryModerator(@Param("primaryKeyDto") PrimaryKeyDto primaryKeyDto);

    @Select("SELECT managed_category_id FROM category_admin WHERE category_admin_id = #{userId}")
    List<Integer> getManagedCategoryIds(@Param("userId") Integer userId);

    @Select("SELECT category_admin_id FROM category_admin WHERE managed_category_id = #{categoryId}")
    List<Integer> getModeratorIds(@Param("categoryId") Integer categoryId);
}
