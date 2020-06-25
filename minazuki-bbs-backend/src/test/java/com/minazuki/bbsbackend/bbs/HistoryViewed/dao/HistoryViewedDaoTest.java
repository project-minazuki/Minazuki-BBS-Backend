package com.minazuki.bbsbackend.bbs.HistoryViewed.dao;

import com.minazuki.bbsbackend.bbs.HistoryViewed.pojo.HistoryViewed;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HistoryViewedDaoTest {

    @Resource
    private HistoryViewedDao historyViewedDao;

    @Test
    void addHistoryView() {
        HistoryViewed historyViewed = HistoryViewed.builder().ownerId(1).viewedAt(LocalDateTime.now()).viewedThemeId(2).build();
        this.historyViewedDao.addHistoryView(historyViewed);
    }

    @Test
    void deleteHistoryView() {
        this.historyViewedDao.deleteHistoryView(1);
    }

    @Test
    void findHistoryViews() {
        System.out.println(historyViewedDao.findHistoryViews());
    }
}