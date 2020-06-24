package com.minazuki.bbsbackend.bbs.Notification.dao.sql;

import com.minazuki.bbsbackend.bbs.Notification.pojo.Notification;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface NotificationMapper {
    @Insert("INSERT INTO notification(notification_recipient_id,created_time,is_checked,checked_time,notification_content) " +
            "VALUES (#{recipientId},#{createdAt},#{checked},#{checkedAt},#{content})")
    void addNotification(@Param("notification") Notification notification);

    @Delete("DELETE FROM notification WHERE id=#{id}")
    void deleteNotification(@Param("id") Integer id);
}
