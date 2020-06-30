package com.minazuki.bbsbackend.bbs.inbox.dao;

import com.minazuki.bbsbackend.bbs.inbox.dataobject.InboxCreateDto;
import com.minazuki.bbsbackend.bbs.inbox.dataobject.InboxIndexDto;
import com.minazuki.bbsbackend.bbs.inbox.pojo.Inbox;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class InboxDaoTest {

    @Resource
    private InboxDao inboxDao;

    @Test
    void addInbox() {
        InboxCreateDto inboxCreateDto = new InboxCreateDto();
        inboxCreateDto.setContent("你你你送你点覅三年覅四年");
        inboxCreateDto.setSenderId(1);
        inboxCreateDto.setRecipientId(4);
        inboxDao.addInbox(inboxCreateDto);
    }

    @Test
    void deleteInbox() {
        Integer id = 1;
        inboxDao.deleteInbox(id);
    }

    @Test
    void getInboxById() {
        System.out.println(inboxDao.getMessageById(1));
    }
/*
    @Test
    void findAllInboxesBetweenTwoUsers() {
        InboxIndexDto inboxIndexDto = new InboxIndexDto();
        inboxIndexDto.setThisUserId(1);
        inboxIndexDto.setTargetUserId(3);
        System.out.println(inboxDao.findAllInboxesBetweenTwoUsers(inboxIndexDto));
    }

 */

    @Test
    void checkInbox() {
        inboxDao.checkInbox(1);
    }

    @Test
    void countUnCheckedInbox() {
        System.out.println(inboxDao.countUnCheckedInbox(1));
    }

    /*
    @Test
    void countUnCheckedInboxOfTwoUsers() {
        InboxIndexDto inboxIndexDto = new InboxIndexDto();
        inboxIndexDto.setThisUserId(1);
        inboxIndexDto.setTargetUserId(3);
        System.out.println(inboxDao.countUnCheckedInboxOfTwoUsers(inboxIndexDto));
    }
     */

    @Test
    public void getInboxByRecipient(){
        List<Inbox> list = inboxDao.getInboxByRecipientId(3);
        System.out.println(list);
    }
    @Test
    public void getOutBoxBySenderId(){
        List<Inbox> list = inboxDao.getOutBoxBySenderId(1);
        System.out.println(list);
    }

    /*
    @Test
    public void setMessageChecked(){
        Integer id = 3;
        inboxDao.setMessageChecked(id);
    }

     */

}