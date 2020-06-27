package com.minazuki.bbsbackend.bbs.historyviewed.dao;

import com.minazuki.bbsbackend.bbs.historyviewed.dataobject.HistoryViewCreateDto;
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
        HistoryViewCreateDto hvcDto = new HistoryViewCreateDto();
        hvcDto.setOwnerId(4);
        hvcDto.setViewedThemeId(2);
        this.historyViewedDao.addHistoryView(hvcDto);
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