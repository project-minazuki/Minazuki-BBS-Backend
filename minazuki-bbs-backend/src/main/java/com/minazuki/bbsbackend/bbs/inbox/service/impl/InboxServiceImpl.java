package com.minazuki.bbsbackend.bbs.inbox.service.impl;

import com.minazuki.bbsbackend.bbs.inbox.dao.InboxDao;
import com.minazuki.bbsbackend.bbs.inbox.dataobject.InboxCreateDto;
import com.minazuki.bbsbackend.bbs.inbox.dataobject.InboxIndexDto;
import com.minazuki.bbsbackend.bbs.inbox.pojo.Inbox;
import com.minazuki.bbsbackend.bbs.inbox.service.InboxService;
import com.minazuki.bbsbackend.user.interceptor.AuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InboxServiceImpl implements InboxService{
    private final InboxDao inboxDao;
    @Autowired
    public InboxServiceImpl(InboxDao inboxDao){this.inboxDao = inboxDao;}


    @Override
    public void createInbox(InboxCreateDto inboxCreateDto) {
        inboxCreateDto.setSenderId(AuthenticationInterceptor.getCurrentUserId());
        inboxDao.addInbox(inboxCreateDto);
    }

    @Override
    public void deleteInboxById(Integer inboxId) {

    }

    @Override
    public Inbox getInboxById(Integer inboxId) {
        Inbox inbox = inboxDao.getInboxById(inboxId);
        return inbox;
    }

    @Override
    public List<Inbox> findAllInboxesBetweenTwoUsers(InboxIndexDto inboxIndexDto) {
        return inboxDao.findAllInboxesBetweenTwoUsers(inboxIndexDto);
    }

    @Override
    public void checkInbox(Integer inboxId) {
        inboxDao.checkInbox(inboxId);
    }

    @Override
    public Integer countUnCheckedInbox(Integer userId) {
        return inboxDao.countUnCheckedInbox(userId);
    }

    @Override
    public Integer countUnCheckedInboxOfTwoUsers(InboxIndexDto inboxIndexDto) {
        return inboxDao.countUnCheckedInboxOfTwoUsers(inboxIndexDto);
    }
}
