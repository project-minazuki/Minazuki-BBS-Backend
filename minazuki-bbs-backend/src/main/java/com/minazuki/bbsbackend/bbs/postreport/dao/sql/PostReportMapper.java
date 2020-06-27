package com.minazuki.bbsbackend.bbs.postreport.dao.sql;

import com.minazuki.bbsbackend.bbs.postreport.dataobject.PostReportCreateDto;
import com.minazuki.bbsbackend.bbs.postreport.pojo.PostReport;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostReportMapper {
    @Insert("INSERT INTO post_report(report_post_id,report_reason,post_reporter_id,created_time,is_checked)" +
            " VALUES (#{postId},#{reason},#{reporterId},NOW(),0)")
    void addPostReport(@Param("postReportCreateDto") PostReportCreateDto postReportCreateDto);

    @Select("SELECT * FROM post_report WHERE id = #{id}")
    @Results({
            @Result(property = "postId", column = "report_post_id"),
            @Result(property = "reporterId", column = "post_reporter_id"),
            @Result(property = "reason", column = "report_reason"),
            @Result(property = "createdAt", column = "created_time"),
            @Result(property = "checked", column = "is_checked"),
            @Result(property = "checkedAt", column = "checked_time")
    })
    PostReport getPostReportById(@Param("id") Integer id);

    @Select("SELECT * FROM post_report")
    @Results({
            @Result(property = "postId", column = "report_post_id"),
            @Result(property = "reporterId", column = "post_reporter_id"),
            @Result(property = "reason", column = "report_reason"),
            @Result(property = "createdAt", column = "created_time"),
            @Result(property = "checked", column = "is_checked"),
            @Result(property = "checkedAt", column = "checked_time")
    })
    List<PostReport> findAllPostReports();

    @Select("SELECT * FROM (post_report INNER JOIN post ON post_report.report_post_id = post.id) " +
            "INNER JOIN theme ON post.theme_id=theme.id WHERE theme.category_id = #{categoryId}")
    @Results({
            @Result(property = "postId", column = "report_post_id"),
            @Result(property = "reporterId", column = "post_reporter_id"),
            @Result(property = "reason", column = "report_reason"),
            @Result(property = "createdAt", column = "created_time"),
            @Result(property = "checked", column = "is_checked"),
            @Result(property = "checkedAt", column = "checked_time")
    })
    List<PostReport> findAllPostReportsByCategoryId(@Param("categoryId") Integer categoryId);

    @Update("UPDATE post_report SET is_checked = 1, checked_time = NOW() WHERE id = #{id}")
    void checkPostReport(@Param("id") Integer id);

    @Delete("DELETE FROM post_report WHERE id=#{id}")
    void deletePostReport(@Param("id") Integer id);
}
