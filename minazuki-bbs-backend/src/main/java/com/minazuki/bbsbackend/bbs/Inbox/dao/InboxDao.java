package com.minazuki.bbsbackend.bbs.Inbox.dao;

import com.minazuki.bbsbackend.bbs.Inbox.dataObject.InboxIndexDto;
import com.minazuki.bbsbackend.bbs.Inbox.pojo.Inbox;
import org.apache.ibatis.session.SqlSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InboxDao {
    private final SqlSession sqlSession;
    @Autowired
    public InboxDao(SqlSession sqlSession){this.sqlSession = sqlSession;}

    public void addInbox(Inbox inbox){this.sqlSession.insert("addInbox", inbox);}

    public void deleteInbox(Integer id){this.sqlSession.delete("deleteInbox", id);}

    public Inbox getInboxById(Integer id){return this.sqlSession.selectOne("getInboxById", id);}

    public List<Inbox> findAllInboxesBetweenTwoUsers(InboxIndexDto inboxIndexDto) {
        return this.sqlSession.selectList("getInboxesByTwoUsers", inboxIndexDto);
    }
}
