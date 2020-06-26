package com.minazuki.bbsbackend.bbs.notification.dao.sql;

import com.minazuki.bbsbackend.bbs.notification.dataobject.NotificationCreateDto;
import com.minazuki.bbsbackend.bbs.notification.pojo.Notification;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NotificationMapper {
    @Insert("INSERT INTO notification(notification_recipient_id,created_time,is_checked,notification_content) " +
            "VALUES (#{recipientId},NOW(),0,#{content})")
    void addNotification(@Param("notificationCreateDto") NotificationCreateDto notificationCreateDto);

    @Select("SELECT * FROM notification WHERE id = #{id}")
    Notification getNotificationById(@Param("id") Integer id);

    @Delete("DELETE FROM notification WHERE id=#{id}")
    void deleteNotification(@Param("id") Integer id);

    @Update("UPDATE notification SET is_checked = 1, checked_time = NOW() WHERE id = #{id}")
    void checkNotification(@Param("id") Integer id);

    @Select("SELECT * FROM notification WHERE notification_recipient_id = #{recipientId}")
    List<Notification> findAllNotificationsByRecipientId(@Param("recipientId") Integer recipientId);
}
