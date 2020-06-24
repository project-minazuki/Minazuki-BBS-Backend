package com.minazuki.bbsbackend.bbs.Notice.dao.sql;

import com.minazuki.bbsbackend.bbs.Notice.pojo.Notice;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public interface NoticeMapper {
    @Insert("INSERT INTO notice(notice_title,notice_content,notice_category_id,notice_creator_id,created_time,updated_time) " +
            "VALUES (#{title},#{content},#{categoryId},#{creatorId},#{createdAt},#{updateAt})")
    void addNotice(@Param("notice") Notice notice);

    @Delete("DELETE FROM notice WHERE id=#{id}")
    void deleteNotice(@Param("id") Integer id);

}
