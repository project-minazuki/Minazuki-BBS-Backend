package com.minazuki.bbsbackend.bbs.category.dao.sql;

import com.minazuki.bbsbackend.bbs.category.dataobject.CategoryUpdateDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.SQL;

@Slf4j
public class CategorySqlProvider {
    public String updateCategoryById(final CategoryUpdateDto categoryUpdateDto){
        return new SQL(){
            {
                UPDATE("category");
                if(categoryUpdateDto.getName()!=null){
                    SET("category_name = #{name}" );
                }
                if (categoryUpdateDto.getDescription()!=null) {
                    SET("description = #{description}");
                }
                if(categoryUpdateDto.getCoverUrl() != null){
                    SET("cover_url = #{coverUrl}");
                }
                SET("updated_time = NOW()");
                WHERE("id=#{id}");
            }
        }.toString();
    }
}
