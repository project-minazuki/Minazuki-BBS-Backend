package com.minazuki.bbsbackend.bbs.Inbox.dao.sql;

import java.util.List;

import com.minazuki.bbsbackend.bbs.Inbox.dataObject.InboxIndexDto;
import com.minazuki.bbsbackend.bbs.Inbox.pojo.Inbox;
import org.apache.ibatis.annotations.*;

@Mapper
public interface InboxMapper {
    @Insert("INSERT INTO inbox(inbox_content,inbox_sender_id,inbox_recipient_id,created_time) " +
            "VALUES (#{content}, #{senderId}, #{recipientId}, #{createdAt})")
    void addInbox(@Param("inbox") Inbox inbox);

    @Delete("DELETE FROM inbox WHERE id=#{id}")
    void deleteInbox(@Param("id") Integer id);

    @Select("SELECT * FROM inbox WHERE (inbox_sender_id = #{thisUserId} AND inbox_recipient_id = #{targetUserId}) OR " +
            "(inbox_sender_id = #{targetUserId} AND inbox_recipient_id = #{thisUserId})")
    @Results({
            @Result(property = "senderId", column = "inbox_sender_id"),
            @Result(property = "recipientId", column = "inbox_recipient_id"),
            @Result(property = "createdAt", column = "created_time")
    })
    List<Inbox> getInboxesByTwoUsers(@Param("inboxIndexDto") InboxIndexDto inboxIndexDto);
}
