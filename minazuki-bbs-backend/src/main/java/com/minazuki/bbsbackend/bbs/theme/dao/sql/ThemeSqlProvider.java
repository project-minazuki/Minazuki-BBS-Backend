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
                if(themeUpdateDto.getIsTop()!=null){
                    SET("is_top = #{isTop}");
                }
                if (themeUpdateDto.getIsHighQuality()!=null){
                    SET("is_high_quality = #{isHighQuality}");
                }
                if (themeUpdateDto.getStatus()!=null){
                    SET("status = #{status}");
                }
                if (themeUpdateDto.getTitle()!=null){
                    SET("theme_title = #{title}");
                }
                if(themeUpdateDto.getVisitsCount()!=null){
                    SET("visits_count = #{visitsCount}");
                }
                if (themeUpdateDto.getReplyCount()!=null){
                    SET("reply_count = #{replyCount}");
                }
                if (themeUpdateDto.getLatestReplyAt()!=null){
                    SET("latest_reply_time = #{latestReplyAt}");
                }
                if (themeUpdateDto.getUpdatedAt()!=null){
                    SET("updated_time = #{updatedAt}");
                }
                WHERE("id = #{id}");
            }
        }.toString();
    }
}
