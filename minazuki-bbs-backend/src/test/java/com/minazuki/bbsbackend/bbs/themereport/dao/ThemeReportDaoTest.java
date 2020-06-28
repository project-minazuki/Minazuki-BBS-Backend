package com.minazuki.bbsbackend.bbs.themereport.dao;

import com.minazuki.bbsbackend.bbs.themereport.dataobject.ThemeReportCreateDto;
import com.minazuki.bbsbackend.bbs.themereport.pojo.ThemeReport;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class ThemeReportDaoTest {
    @Resource
    private ThemeReportDao themeReportDao;

    @Test
    void addThemeReport() {
        ThemeReportCreateDto themeReportCreateDto = new ThemeReportCreateDto();
        themeReportCreateDto.setThemeId(19);themeReportCreateDto.setReporterId(1);
        themeReportCreateDto.setReason("2版块的主题帖的举报2");
        themeReportDao.addThemeReport(themeReportCreateDto);
    }

    @Test
    void deleteThemeReport() {
        Integer id = 3;
        themeReportDao.deleteThemeReport(id);
    }

    @Test
    void getAllReportsOfTheme() {
        List<ThemeReport> list =themeReportDao.getAllReportsOfTheme(7);
        System.out.println(list);
    }

    @Test
    void getUncheckedReportsOfTheme() {
        List<ThemeReport> list = themeReportDao.getUncheckedReportsOfTheme(7);
        System.out.println(list);
    }

    @Test
    void setThemeReportChecked() {
        Integer id  = 2;
        themeReportDao.setThemeReportChecked(id);
    }

    @Test
    void deleteCheckedReports() {
        Integer themeId = 7;
        themeReportDao.deleteCheckedReports(themeId);
    }

    @Test
    void findAllThemeReportsByCategoryId(){
        Integer categoryId = 2;
        List<ThemeReport> list = themeReportDao.findAllThemeReportsByCategoryId(categoryId);
        System.out.println(list);
    }
}