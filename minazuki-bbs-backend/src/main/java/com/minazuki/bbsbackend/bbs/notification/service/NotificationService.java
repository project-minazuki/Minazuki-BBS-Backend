package com.minazuki.bbsbackend.bbs.notification.service;

import com.minazuki.bbsbackend.bbs.notification.dataobject.NotificationCreateDto;
import com.minazuki.bbsbackend.bbs.notification.pojo.Notification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NotificationService {
    void addNotification(NotificationCreateDto notificationCreateDto);

    Notification getNotificationById(Integer id);

    void deleteNotification(Integer id);

    void checkNotification(Integer id);

    List<Notification> findAllNotificationsByRecipientId(Integer recipientId);
}
