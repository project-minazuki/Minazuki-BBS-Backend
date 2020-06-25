package com.minazuki.bbsbackend.bbs.inbox.dao;

import com.minazuki.bbsbackend.bbs.inbox.pojo.Inbox;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;

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

    @Test
    void testAddInbox() {
    }

    @Test
    void testDeleteInbox() {
    }

    @Test
    void getInboxById() {
    }

    @Test
    void findAllInboxesBetweenTwoUsers() {
    }
}