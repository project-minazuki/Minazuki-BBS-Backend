package com.minazuki.bbsbackend.bbs.notice.dao.sql;

import com.minazuki.bbsbackend.bbs.notice.dataobject.NoticeUpdateDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.SQL;

@Slf4j
public class NoticeSqlProvider {

    public String updateById(final NoticeUpdateDto noticeUpdateDto){
        return new SQL(){
            {
                UPDATE("notice");
                if(noticeUpdateDto.getContent()!=null){
                    SET("notice_content = #{content}");
                }
                if (noticeUpdateDto.getTitle()!=null){
                    SET("notice_title = #{title}");
                }
                SET("updated_time = NOW()");
                WHERE("id = #{id}");
            }
        }.toString();
    }
}
