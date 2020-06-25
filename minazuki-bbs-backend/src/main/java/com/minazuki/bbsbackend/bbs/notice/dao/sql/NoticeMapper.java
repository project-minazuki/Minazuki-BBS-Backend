package com.minazuki.bbsbackend.bbs.notice.dao.sql;

import com.minazuki.bbsbackend.bbs.notice.dataobject.NoticeUpdateDto;
import com.minazuki.bbsbackend.bbs.notice.pojo.Notice;
import org.apache.ibatis.annotations.*;

@Mapper
public interface NoticeMapper {
    @Insert("INSERT INTO notice(notice_title,notice_content,notice_category_id,notice_creator_id,created_time,updated_time) " +
            "VALUES (#{title},#{content},#{categoryId},#{creatorId},#{createdAt},#{updateAt})")
    void addNotice(@Param("notice") Notice notice);

    @Delete("DELETE FROM notice WHERE id=#{id}")
    void deleteNotice(@Param("id") Integer id);

    @UpdateProvider(type = NoticeSqlProvider.class, method = "updateById")
    void updateNoticeById(NoticeUpdateDto noticeUpdateDto);
}
