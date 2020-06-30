package com.minazuki.bbsbackend.bbs.inbox.service;

import com.minazuki.bbsbackend.bbs.inbox.dataobject.InboxCreateDto;
import com.minazuki.bbsbackend.bbs.inbox.dataobject.InboxIndexDto;
import com.minazuki.bbsbackend.bbs.inbox.exception.UncheckedMessageException;
import com.minazuki.bbsbackend.bbs.inbox.pojo.Inbox;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InboxService {
    //**********增，删**********//

    void createInbox(InboxCreateDto inboxCreateDto);

    //可能需要检测是否已经为checked状态（未添加）
    void deleteMessageById(Integer MessageId) throws UncheckedMessageException;


    //**********获取**********//

    Inbox getMessageById(Integer inboxId);

    //获取收件箱所有邮件,自动全部设为已读
    List<Inbox> getInboxByRecipientId(Integer recipientId);

    //获取发件箱所有邮件
    List<Inbox> getOutBoxBySenderId(Integer senderId);


    //**********其他**********//

    //进入收件箱时哦邮件自动设为已读
    void checkInbox(Integer inboxId);

    //计算收件箱里所有未读邮件的条数
    Integer countUnCheckedInbox(Integer userId);


    //**********删除**********//
    //List<Inbox> findAllInboxesBetweenTwoUsers(InboxIndexDto inboxIndexDto);
    //Integer countUnCheckedInboxOfTwoUsers(InboxIndexDto inboxIndexDto);
}
