package com.minazuki.bbsbackend.bbs.notification.dao;

import com.minazuki.bbsbackend.bbs.notification.dataobject.NotificationCreateDto;
import com.minazuki.bbsbackend.bbs.notification.pojo.Notification;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class NotificationDao {
    private final SqlSession sqlSession;
    @Autowired
    public NotificationDao(SqlSession sqlSession){this.sqlSession = sqlSession;}

    public void addNotification(NotificationCreateDto notificationCreateDto){this.sqlSession.insert("addNotification", notificationCreateDto);}

    public Notification getNotificationById(Integer id) {
        return this.sqlSession.selectOne("getNotificationById", id);
    }

    public void deleteNotification(Integer id){this.sqlSession.delete("deleteNotification",id);}

    public void checkNotification(Integer id) {
        this.sqlSession.update("checkNotification", id);
    }

    public List<Notification> findAllNotificationsByRecipientId(Integer recipientId) {
        return this.sqlSession.selectList("findAllNotificationsByRecipientId", recipientId);
    }
}
