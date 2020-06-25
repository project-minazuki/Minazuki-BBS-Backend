package com.minazuki.bbsbackend.bbs.Inbox.dao;

import com.minazuki.bbsbackend.bbs.Inbox.dataObject.InboxIndexDto;
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
        Inbox inbox = Inbox.builder().content("wdnmd").senderId(3)
                .recipientId(1).createdAt(LocalDateTime.now()).isChecked(false).build();
        inboxDao.addInbox(inbox);
    }

    @Test
    void deleteInbox() {
        Integer id = 1;
        inboxDao.deleteInbox(id);
    }

    @Test
    void getInboxById() {
        System.out.println(inboxDao.getInboxById(1));
    }

    @Test
    void findAllInboxesBetweenTwoUsers() {
        InboxIndexDto inboxIndexDto = new InboxIndexDto();
        inboxIndexDto.setThisUserId(1);
        inboxIndexDto.setTargetUserId(3);
        System.out.println(inboxDao.findAllInboxesBetweenTwoUsers(inboxIndexDto));
    }

    @Test
    void checkInbox() {
        inboxDao.checkInbox(1);
    }

    @Test
    void countUnCheckedInbox() {
        System.out.println(inboxDao.countUnCheckedInbox(1));
    }

    @Test
    void countUnCheckedInboxOfTwoUsers() {
        InboxIndexDto inboxIndexDto = new InboxIndexDto();
        inboxIndexDto.setThisUserId(1);
        inboxIndexDto.setTargetUserId(3);
        System.out.println(inboxDao.countUnCheckedInboxOfTwoUsers(inboxIndexDto));
    }
}