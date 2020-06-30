package com.minazuki.bbsbackend.bbs.inbox.dao;

import com.minazuki.bbsbackend.bbs.inbox.dataobject.InboxCreateDto;
import com.minazuki.bbsbackend.bbs.inbox.dataobject.InboxIndexDto;
import com.minazuki.bbsbackend.bbs.inbox.pojo.Inbox;
import org.apache.ibatis.session.SqlSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InboxDao {
    private final SqlSession sqlSession;
    @Autowired
    public InboxDao(SqlSession sqlSession){this.sqlSession = sqlSession;}

    public void addInbox(InboxCreateDto inboxCreateDto){this.sqlSession.insert("addInbox", inboxCreateDto);}

    //当邮件已经被checked后收件人和发件人都可以删除
    public void deleteInbox(Integer id){this.sqlSession.delete("deleteInbox", id);}

    public Inbox getMessageById(Integer id){return this.sqlSession.selectOne("getMessageById", id);}

    /*
    //考虑删除
    public List<Inbox> findAllInboxesBetweenTwoUsers(InboxIndexDto inboxIndexDto) {
        return this.sqlSession.selectList("getInboxesByTwoUsers", inboxIndexDto);
    }
     */

    //获取邮件时将邮件设为checked
    public void checkInbox(Integer id) {
        this.sqlSession.update("checkInbox", id);
    }

    public Integer countUnCheckedInbox(Integer userId) {
        return this.sqlSession.selectOne("countUnCheckedInbox", userId);
    }

    /*
    //考虑删除
    public Integer countUnCheckedInboxOfTwoUsers(InboxIndexDto inboxIndexDto){
        return this.sqlSession.selectOne("countUnCheckedInboxOfTwoUsers", inboxIndexDto);
    }
     */

    //获取收件箱所有邮件
    public List<Inbox> getInboxByRecipientId(Integer recipientId){
        return this.sqlSession.selectList("getInboxByRecipientId",recipientId);
    }
    //获取发件箱所有邮件
    public List<Inbox> getOutBoxBySenderId(Integer senderId){
        return this.sqlSession.selectList("getOutBoxBySenderId",senderId);
    }

    /*
    //根据收件人check所有收件箱邮件，用在打开收件箱的操作中
    public void setMessageChecked(Integer recipientId){
        this.sqlSession.update("setMessageChecked", recipientId);
    }
     */

    public boolean isMessageChecked(Integer id){return this.sqlSession.selectOne("isMessageChecked",id);}
}
