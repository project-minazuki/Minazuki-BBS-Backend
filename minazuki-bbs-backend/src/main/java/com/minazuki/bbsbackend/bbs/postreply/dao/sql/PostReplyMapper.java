package com.minazuki.bbsbackend.bbs.postreply.dao.sql;

import com.minazuki.bbsbackend.bbs.postreply.dataobject.PostReplyCreateDto;
import com.minazuki.bbsbackend.bbs.postreply.pojo.PostReply;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostReplyMapper {
    @Insert("INSERT INTO post_reply(target_post_id,content,post_reply_creator_id) " +
            "VALUES(#{targetPostId},#{content},#{postReplyCreatorId})")
    void addPostReply(@Param("prcDto") PostReplyCreateDto prcDto);

    @Select("SELECT * FROM post_reply WHERE id = #{id}")
    @Results({
            @Result(property = "targetPostId", column = "target_post_id"),
            @Result(property = "postReplyCreatorId", column = "post_reply_creator_id")
    })
    PostReply getPostReplyById(@Param("id") Integer id);

    @Select("SELECT * FROM post_reply WHERE target_post_id = #{targetPostId}")
    @Results({
            @Result(property = "targetPostId", column = "target_post_id"),
            @Result(property = "postReplyCreatorId", column = "post_reply_creator_id")
    })
    List<PostReply> findAllPostRepliesByPostId(@Param("targetPostId") Integer targetPostId);

    @Delete("DELETE FROM post_reply WHERE id=#{id}")
    void deletePostReply(@Param("id") Integer id);
}
