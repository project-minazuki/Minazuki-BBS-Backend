package com.minazuki.bbsbackend.bbs.PostReply.dao.sql;

import com.minazuki.bbsbackend.bbs.PostReply.pojo.PostReply;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PostReplyMapper {
    @Insert("INSERT INTO post_reply(target_post_id,content,post_reply_creator_id) " +
            "VALUES(#{targetPostId},#{content},#{postReplyCreatorId})")
    void addPostReply(@Param("postReply") PostReply postReply);

    @Delete("DELETE FROM post_reply WHERE id=#{id}")
    void deletePostReply(@Param("id") Integer id);
}
