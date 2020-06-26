package com.minazuki.bbsbackend.bbs.notice.dao.sql;

import com.minazuki.bbsbackend.bbs.notice.dataobject.NoticeCreateDto;
import com.minazuki.bbsbackend.bbs.notice.dataobject.NoticeUpdateDto;
import com.minazuki.bbsbackend.bbs.notice.pojo.Notice;
import org.apache.ibatis.annotations.*;

@Mapper
public interface NoticeMapper {
    @Insert("INSERT INTO notice(notice_title,notice_content,notice_category_id,notice_creator_id,created_time,updated_time) " +
            "VALUES (#{title},#{content},#{categoryId},#{creatorId},NOW(),NOW())")
    void addNotice(@Param("notice")NoticeCreateDto noticeCreateDto);

    @Delete("DELETE FROM notice WHERE id=#{id}")
    void deleteNotice(@Param("id") Integer id);

    @Select("SELECT * FROM notice WHERE id = #{id}")
    Notice getNoticeById(@Param("id") Integer id);

    @Select("SELECT * FROM notice WHERE notice_category_id = #{categoryId}")
    Notice findAllNotices(@Param("categoryId") Integer categoryId);

    @UpdateProvider(type = NoticeSqlProvider.class, method = "updateById")
    void updateNoticeById(NoticeUpdateDto noticeUpdateDto);
}
