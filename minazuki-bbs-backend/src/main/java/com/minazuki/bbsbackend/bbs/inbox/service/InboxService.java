package com.minazuki.bbsbackend.bbs.inbox.service;

import com.minazuki.bbsbackend.bbs.inbox.dataobject.InboxCreateDto;
import com.minazuki.bbsbackend.bbs.inbox.dataobject.InboxIndexDto;
import com.minazuki.bbsbackend.bbs.inbox.pojo.Inbox;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InboxService {
    void createInbox(InboxCreateDto inboxCreateDto);

    void deleteInboxById(Integer inboxId);

    Inbox getInboxById(Integer inboxId);

    List<Inbox> findAllInboxesBetweenTwoUsers(InboxIndexDto inboxIndexDto);

    void checkInbox(Integer inboxId);

    Integer countUnCheckedInbox(Integer userId);

    Integer countUnCheckedInboxOfTwoUsers(InboxIndexDto inboxIndexDto);
}
