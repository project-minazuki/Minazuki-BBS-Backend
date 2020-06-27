package com.minazuki.bbsbackend.bbs.post.dao.sql;

import com.minazuki.bbsbackend.bbs.post.dataobject.PostCreateDto;
import com.minazuki.bbsbackend.bbs.post.dataobject.PostUpdateDto;
import com.minazuki.bbsbackend.bbs.post.pojo.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostMapper {

    @Insert("INSERT INTO post(post_creator_id,created_time,content,number,likes_count,unlikes_count,theme_id) " +
            "VALUES (#{creatorId},NOW(),#{content},#{number},0,0,#{themeId})")

    void addPost(@Param("post") PostCreateDto postCreateDto);

    @Select("SELECT * FROM post WHERE id = #{id}")
    @Results({
            @Result(property = "creatorId", column = "post_creator_id"),
            @Result(property = "createdAt", column = "created_time"),
            @Result(property = "likesCount", column = "likes_count"),
            @Result(property = "unlikesCount", column = "unlikes_count"),
            @Result(property = "themeId", column = "theme_id")
    })
    Post getPostById(@Param("id") Integer id);

    @Select("SELECT * FROM post WHERE theme_id = #{themeId}")
    List<Post> findAllPostsByThemeId(@Param("themeId") Integer themeId);

    @Select("SELECT MAX(number) FROM post WHERE theme_id = #{themeId}")
    Integer getMaxPostNumber(@Param("themeId") Integer themeId);

    @Delete("DELETE FROM post WHERE id=#{id}")
    void deletePost(@Param("id")Integer id);

    @Update("UPDATE post SET content = #{content} WHERE id = #{postId}")
    void updatePost(@Param("postUpdateDto")PostUpdateDto postUpdateDto);

    @Update("UPDATE post SET likes_count = likes_count + 1 WHERE id = #{id}")
    void likePost(@Param("id")Integer id);

    @Update("UPDATE post SET unlikes_count = unlikes_count + 1 WHERE id = #{id}")
    void unlikePost(@Param("id")Integer id);
}
