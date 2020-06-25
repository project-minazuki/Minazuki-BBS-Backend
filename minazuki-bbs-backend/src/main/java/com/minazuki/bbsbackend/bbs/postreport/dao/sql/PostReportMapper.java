package com.minazuki.bbsbackend.bbs.postreport.dao.sql;

import com.minazuki.bbsbackend.bbs.postreport.pojo.PostReport;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PostReportMapper {
    @Insert("INSERT INTO post_report(report_post_id,report_reason,post_reporter_id,created_time,is_checked,checked_time)" +
            " VALUES (#{postId},#{reason},#{reporterId},#{createdAt},#{checked},#{checkedAt})")
    void addPostReport(@Param("postReport") PostReport postReport);

    @Delete("DELETE FROM post_report WHERE id=#{id}")
    void deletePostReport(@Param("id") Integer id);
}
