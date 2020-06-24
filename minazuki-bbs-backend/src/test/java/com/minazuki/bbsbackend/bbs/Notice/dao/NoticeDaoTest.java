package com.minazuki.bbsbackend.bbs.Notice.dao;

import com.minazuki.bbsbackend.bbs.Notice.pojo.Notice;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NoticeDaoTest {

    @Resource
    private NoticeDao noticeDao;

    @Test
    void addNotice() {
        Notice notice = Notice.builder().title("Notice标题").content("Notice内容").categoryId(1)
                .creatorId(1).createdAt(LocalDateTime.now()).updateAt(LocalDateTime.now()).build();
        noticeDao.addNotice(notice);
    }

    @Test
    void deleteNotice() {
        Integer id = 1;
        noticeDao.deleteNotice(id);
    }
}