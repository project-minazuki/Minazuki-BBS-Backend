package com.minazuki.bbsbackend.bbs.Notification.dao;

import com.minazuki.bbsbackend.bbs.Notification.pojo.Notification;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationDao {
    private final SqlSession sqlSession;
    @Autowired
    public NotificationDao(SqlSession sqlSession){this.sqlSession = sqlSession;}

    public void addNotification(Notification notification){this.sqlSession.insert("addNotification", notification);}

    public void deleteNotification(Integer id){this.sqlSession.delete("deleteNotification",id);}
}
