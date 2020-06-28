package com.minazuki.bbsbackend.bbs.notification.service.impl;

import com.minazuki.bbsbackend.bbs.notice.service.impl.NoticeServiceImpl;
import com.minazuki.bbsbackend.bbs.notification.dao.NotificationDao;
import com.minazuki.bbsbackend.bbs.notification.dataobject.NotificationCreateDto;
import com.minazuki.bbsbackend.bbs.notification.pojo.Notification;
import com.minazuki.bbsbackend.bbs.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NotificationServiceImpl implements NotificationService {
    private final NotificationDao notificationDao;
    @Autowired
    public NotificationServiceImpl(NotificationDao notificationDao){
        this.notificationDao = notificationDao;
    }


    @Override
    public void addNotification(NotificationCreateDto notificationCreateDto) {
        notificationDao.addNotification(notificationCreateDto);
    }

    @Override
    public Notification getNotificationById(Integer id) {
        return notificationDao.getNotificationById(id);
    }

    @Override
    public void deleteNotification(Integer id) {
        notificationDao.deleteNotification(id);
    }

    @Override
    public void checkNotification(Integer id) {
        notificationDao.checkNotification(id);
    }

    @Override
    public List<Notification> findAllNotificationsByRecipientId(Integer recipientId) {
        return findAllNotificationsByRecipientId(recipientId);
    }
}
