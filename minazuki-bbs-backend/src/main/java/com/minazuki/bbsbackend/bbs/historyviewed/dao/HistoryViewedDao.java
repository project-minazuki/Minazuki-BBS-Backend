package com.minazuki.bbsbackend.bbs.historyviewed.dao;

import com.minazuki.bbsbackend.bbs.historyviewed.pojo.HistoryViewed;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HistoryViewedDao {

    private final SqlSession sqlSession;

    @Autowired
    public HistoryViewedDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public void addHistoryView(HistoryViewed historyViewed) {
        this.sqlSession.insert("addHistoryView", historyViewed);
    }

    public void deleteHistoryView(Integer id) {
        this.sqlSession.delete("deleteHistoryView", id);
    }

    public HistoryViewed getHistoryViewById(Integer id) {
        return this.sqlSession.selectOne("getHistoryViewById", id);
    }

    public List<HistoryViewed> findHistoryViews(Integer ownerId) {
        return this.sqlSession.selectList("findAllHistoryViews", ownerId);
    }
}
