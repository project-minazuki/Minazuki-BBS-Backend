package com.minazuki.bbsbackend.bbs.historyviewed.dao;

import com.minazuki.bbsbackend.bbs.historyviewed.pojo.HistoryViewed;
import org.assertj.core.error.ShouldBeAfterYear;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.time.LocalDateTime;

@SpringBootTest
class HistoryViewedDaoTest {

    @Resource
    private HistoryViewedDao historyViewedDao;

    @Test
    void addHistoryView() {
        HistoryViewed historyViewed = HistoryViewed.builder().ownerId(4).viewedAt(LocalDateTime.now()).viewedThemeId(1).build();
        this.historyViewedDao.addHistoryView(historyViewed);
    }

    @Test
    void deleteHistoryView() {
        this.historyViewedDao.deleteHistoryView(1);
    }

    @Test
    void getHistoryViewByIdTest() {
        System.out.println(this.historyViewedDao.getHistoryViewById(3));
    }

    @Test
    void findHistoryViews() {
        System.out.println(historyViewedDao.findHistoryViews(4));
    }
}