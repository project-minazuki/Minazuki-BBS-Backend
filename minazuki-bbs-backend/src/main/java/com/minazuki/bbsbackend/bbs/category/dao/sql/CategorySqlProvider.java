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
                if(categoryUpdateDto.getName()!=null){
                    SET("category_name = #{name}" );
                }
                if(categoryUpdateDto.getStatus()!=null){
                    SET("status = #{status}");
                }
                if (categoryUpdateDto.getDescription()!=null) {
                    SET("description = #{description}");
                }
                if(categoryUpdateDto.getUpdatedAt()!=null) {
                    SET("updated_time = #{updatedAt}");
                }
                if(categoryUpdateDto.getCoverUrl() != null){
                    SET("cover_url = #{coverUrl}");
                }
                if (categoryUpdateDto.getVisitsCount()!=null){
                    SET("visits_count = #{visitsCount}");
                }
                WHERE("id=#{id}");
            }
        }.toString();
    }
}
