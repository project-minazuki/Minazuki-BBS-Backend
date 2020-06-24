package com.minazuki.bbsbackend.bbs.Notification.dao;

import com.minazuki.bbsbackend.bbs.Notification.pojo.Notification;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NotificationDaoTest {

    @Resource
    private NotificationDao notificationDao;

    @Test
    void addNotification() {
        Notification notification = Notification.builder().recipientId(1).createdAt(LocalDateTime.now())
                .checked(true).checkedAt(LocalDateTime.now()).content("您被通知了消息").build();
        notificationDao.addNotification(notification);
    }

    @Test
    void deleteNotification() {
        Integer id = 1;
        notificationDao.deleteNotification(id);
    }
}