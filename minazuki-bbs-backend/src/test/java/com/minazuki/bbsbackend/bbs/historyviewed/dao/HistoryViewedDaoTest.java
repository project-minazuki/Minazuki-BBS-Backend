package com.minazuki.bbsbackend.bbs.historyviewed.dao;

import com.minazuki.bbsbackend.bbs.historyviewed.dataobject.HistoryViewedCreateDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class HistoryViewedDaoTest {

    @Resource
    private HistoryViewedDao historyViewedDao;

    @Test
    void addHistoryView() {
        HistoryViewedCreateDto hvcDto = new HistoryViewedCreateDto();
        hvcDto.setOwnerId(1);
        hvcDto.setViewedThemeId(1);
        this.historyViewedDao.addHistoryViewed(hvcDto);
    }

    @Test
    void deleteHistoryView() {
        this.historyViewedDao.deleteHistoryViewed(1);
    }

    @Test
    void getHistoryViewByIdTest() {
        System.out.println(this.historyViewedDao.getHistoryViewedById(3));
    }

    @Test
    void findHistoryViews() {
        System.out.println(historyViewedDao.findAllHistoryViewed(4));
    }
}