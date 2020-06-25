package com.minazuki.bbsbackend.bbs.post.dao.sql;

import com.minazuki.bbsbackend.bbs.post.pojo.Post;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PostMapper {

    @Insert("INSERT INTO post(post_creator_id,created_time,content,number,likes_count,unlikes_count,theme_id) " +
            "VALUES (#{creatorId},#{createdAt},#{content},#{number},#{likesCount},#{unlikesCount},#{themeId})")

    void addPost(@Param("post") Post post);

    @Delete("DELETE FROM post WHERE id=#{id}")
    void deletePost(@Param("id")Integer id);



}
