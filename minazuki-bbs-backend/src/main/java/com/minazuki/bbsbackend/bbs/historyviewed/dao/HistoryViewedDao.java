package com.minazuki.bbsbackend.bbs.historyviewed.dao;

import com.minazuki.bbsbackend.bbs.historyviewed.dataobject.HistoryViewedCreateDto;
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

    public void addHistoryViewed(HistoryViewedCreateDto hvcDto) {
        this.sqlSession.insert("addHistoryViewed", hvcDto);
    }

    public void deleteHistoryViewed(Integer id) {
        this.sqlSession.delete("deleteHistoryViewed", id);
    }

    public HistoryViewed getHistoryViewedById(Integer id) {
        return this.sqlSession.selectOne("getHistoryViewedById", id);
    }

    public List<HistoryViewed> findAllHistoryViewed(Integer ownerId) {
        return this.sqlSession.selectList("findAllHistoryViewed", ownerId);
    }
}
