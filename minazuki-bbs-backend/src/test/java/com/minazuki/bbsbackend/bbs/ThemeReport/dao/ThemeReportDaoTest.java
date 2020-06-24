package com.minazuki.bbsbackend.bbs.ThemeReport.dao;

import com.minazuki.bbsbackend.bbs.ThemeReport.pojo.ThemeReport;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ThemeReportDaoTest {
    @Resource
    private ThemeReportDao themeReportDao;

    @Test
    void addThemeReport() {
        ThemeReport themeReport = ThemeReport.builder().themeId(2).reporterId(1).reason("此主题贴有问题")
                .createdAt(LocalDateTime.now()).checkedAt(LocalDateTime.now()).checked(true).build();
        themeReportDao.addThemeReport(themeReport);
    }

    @Test
    void deleteThemeReport() {
        Integer id = 2;
        themeReportDao.deleteThemeReport(id);
    }
}