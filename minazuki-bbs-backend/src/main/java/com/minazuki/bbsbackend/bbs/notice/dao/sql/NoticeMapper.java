package com.minazuki.bbsbackend.bbs.notice.dao.sql;

import com.minazuki.bbsbackend.bbs.notice.dataobject.NoticeCreateDto;
import com.minazuki.bbsbackend.bbs.notice.dataobject.NoticeUpdateDto;
import com.minazuki.bbsbackend.bbs.notice.pojo.Notice;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Mapper
public interface NoticeMapper {
    @Insert("INSERT INTO notice(notice_title,notice_content,notice_category_id,notice_creator_id,created_time,updated_time) " +
            "VALUES (#{title},#{content},#{categoryId},#{creatorId},NOW(),NOW())")
    void addNotice(@Param("notice")NoticeCreateDto noticeCreateDto);

    @Delete("DELETE FROM notice WHERE id=#{id}")
    void deleteNotice(@Param("id") Integer id);

    @Select("SELECT * FROM notice WHERE id = #{id}")
    Notice getNoticeById(@Param("id") Integer id);


    /*
    @Select("SELECT * FROM notice WHERE notice_category_id = #{categoryId}")
    Notice findAllNotices(@Param("categoryId") Integer categoryId);
     */

    //updated:返回一个按照更新时间排序的List，更新时间越晚排位越靠前
    @Select("SELECT * FROM notice WHERE notice_category_id = #{categoryId} ORDER BY updated_time DESC ")
    List<Notice> findAllNotices (@Param("categoryId") Integer categoryId);


    @UpdateProvider(type = NoticeSqlProvider.class, method = "updateById")
    void updateNotice(NoticeUpdateDto noticeUpdateDto);

    @Select("SELECT category_admin_id FROM category_admin INNER JOIN notice " +
            "ON notice.notice_category_id = category_admin.managed_category_id WHERE notice.id=#{id}")
    List<Integer> getCategoryAdministrators(@Param("id") Integer id);

    @Select("SELECT notice_creator_id FROM notice WHERE id = #{id}")
    Integer getCreatorIdByNoticeId(@Param("id") Integer id);


}
