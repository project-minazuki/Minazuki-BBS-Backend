package com.minazuki.bbsbackend.bbs.inbox.service.impl;

import com.minazuki.bbsbackend.bbs.inbox.dao.InboxDao;
import com.minazuki.bbsbackend.bbs.inbox.dataobject.InboxCreateDto;
import com.minazuki.bbsbackend.bbs.inbox.dataobject.InboxIndexDto;
import com.minazuki.bbsbackend.bbs.inbox.exception.UncheckedMessageException;
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
    public void deleteMessageById(Integer messageId) throws UncheckedMessageException {
        if(inboxDao.isMessageChecked(messageId)) {
            inboxDao.deleteInbox(messageId);
        }
        else throw new UncheckedMessageException();
    }

    @Override
    public Inbox getMessageById(Integer inboxId) {
        Inbox inbox = inboxDao.getMessageById(inboxId);
        //将对应的邮件设置为已读
        inboxDao.checkInbox(inboxId);
        return inbox;
    }

    @Override
    public List<Inbox> getInboxByRecipientId(Integer recipientId) {
        return inboxDao.getInboxByRecipientId(recipientId);
    }

    @Override
    public List<Inbox> getOutBoxBySenderId(Integer senderId) {
        return inboxDao.getOutBoxBySenderId(senderId);
    }

    @Override
    public void checkInbox(Integer inboxId) {
        inboxDao.checkInbox(inboxId);
    }

    @Override
    public Integer countUnCheckedInbox(Integer userId) {
        return inboxDao.countUnCheckedInbox(userId);
    }


/*
    @Override
    public Integer countUnCheckedInboxOfTwoUsers(InboxIndexDto inboxIndexDto) {
        return inboxDao.countUnCheckedInboxOfTwoUsers(inboxIndexDto);
    }

    @Override
    public List<Inbox> findAllInboxesBetweenTwoUsers(InboxIndexDto inboxIndexDto) {
        return inboxDao.findAllInboxesBetweenTwoUsers(inboxIndexDto);
    }
 */
}
