package com.minazuki.bbsbackend.bbs.notification.dao;

import com.minazuki.bbsbackend.bbs.notification.dataobject.NotificationCreateDto;
import com.minazuki.bbsbackend.bbs.notification.pojo.Notification;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.time.LocalDateTime;

@SpringBootTest
class NotificationDaoTest {

    @Resource
    private NotificationDao notificationDao;

    @Test
    void addNotification() {
        NotificationCreateDto notificationCreateDto = new NotificationCreateDto();
        notificationCreateDto.setRecipientId(4);
        notificationCreateDto.setContent("欢迎4545");
        notificationDao.addNotification(notificationCreateDto);
    }

    @Test
    void checkNotificationTest() {
        notificationDao.checkNotification(1);
    }

    @Test
    void getNotificationByIdTest() {
        System.out.println(notificationDao.getNotificationById(2));
    }

    @Test
    void deleteNotification() {
        Integer id = 1;
        notificationDao.deleteNotification(id);
    }

    @Test
    void findAllNotificationsByRecipientId() {
        System.out.println(notificationDao.findAllNotificationsByRecipientId(4));
    }
}