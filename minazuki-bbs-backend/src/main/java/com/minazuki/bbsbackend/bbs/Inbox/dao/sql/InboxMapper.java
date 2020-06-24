package com.minazuki.bbsbackend.bbs.Inbox.dao.sql;

import com.minazuki.bbsbackend.bbs.Inbox.pojo.Inbox;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InboxMapper {
    @Insert("INSERT INTO inbox(inbox_content,inbox_sender_id,inbox_recipient_id,created_time) " +
            "VALUES (#{content}, #{senderId}, #{recipientId}, #{createdAt})")
    void addInbox(@Param("inbox") Inbox inbox);

    @Delete("DELETE FROM inbox WHERE id=#{id}")
    void deleteInbox(@Param("id") Integer id);
}
