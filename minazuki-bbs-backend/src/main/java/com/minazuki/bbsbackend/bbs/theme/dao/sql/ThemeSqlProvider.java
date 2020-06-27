package com.minazuki.bbsbackend.bbs.theme.dao.sql;

import com.minazuki.bbsbackend.bbs.theme.dataobject.ThemeUpdateDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.SQL;

@Slf4j
public class ThemeSqlProvider {


    public String updateById(ThemeUpdateDto themeUpdateDto){
        return new SQL(){
            {
                UPDATE("theme");
                if (themeUpdateDto.getTitle()!=null){
                    SET("theme_title = #{title}");
                }
                SET("updated_time = NOW()");
                WHERE("id = #{id}");
            }
        }.toString();
    }

}
