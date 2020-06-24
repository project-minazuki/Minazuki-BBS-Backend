package com.minazuki.bbsbackend.bbs.Inbox.dao;

import com.minazuki.bbsbackend.bbs.Inbox.pojo.Inbox;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InboxDaoTest {

    @Resource
    private InboxDao inboxDao;

    @Test
    void addInbox() {
        Inbox inbox = Inbox.builder().content("邮件内容").senderId(1)
                .recipientId(1).createdAt(LocalDateTime.now()).build();
        inboxDao.addInbox(inbox);
    }

    @Test
    void deleteInbox() {
        Integer id = 1;
        inboxDao.deleteInbox(id);
    }
}