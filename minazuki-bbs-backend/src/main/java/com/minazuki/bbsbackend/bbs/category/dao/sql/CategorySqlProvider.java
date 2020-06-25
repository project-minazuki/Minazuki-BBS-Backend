package com.minazuki.bbsbackend.bbs.category.dao.sql;

import com.minazuki.bbsbackend.bbs.category.dataObject.CategoryUpdateDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.SQL;

@Slf4j
public class CategorySqlProvider {
    public String updateCategoryById(final CategoryUpdateDto categoryUpdateDto){
        return new SQL(){
            {
                UPDATE("category");
                SET("category_name = #{name}" );
                SET("status = #{status}");
                SET("description = #{description}");
                SET("updated_time = #{updatedAt}");
                if(categoryUpdateDto.getCoverUrl() != null){
                    SET("cover_url = #{coverUrl}");
                }
                WHERE("id=#{id}");
            }
        }.toString();
    }
}
