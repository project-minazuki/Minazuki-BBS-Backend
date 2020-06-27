package com.minazuki.bbsbackend.bbs.themereport.service;

import com.minazuki.bbsbackend.bbs.themereport.dao.ThemeReportDao;
import com.minazuki.bbsbackend.bbs.themereport.dataobject.ThemeReportCreateDto;
import com.minazuki.bbsbackend.bbs.themereport.pojo.ThemeReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ThemeReportServiceImpl implements ThemeReportService{

    public final ThemeReportDao themeReportDao;

    @Autowired
    public ThemeReportServiceImpl(ThemeReportDao themeReportDao){this.themeReportDao=themeReportDao;}

    @Override
    public void setThemeReportChecked(Integer id) {
        themeReportDao.setThemeReportChecked(id);
    }

    @Override
    public void deleteCheckedReports(Integer themeId) {
        themeReportDao.deleteCheckedReports(themeId);
    }

    @Override
    public boolean isThemeHasUncheckedReport(Integer themeId) {
        if(themeReportDao.getUncheckedReportsOfTheme(themeId)!=null){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public List<ThemeReport> getAllReportsOfTheme(Integer themeId) {
        List reportList = themeReportDao.getAllReportsOfTheme(themeId);
        return reportList;
    }

    @Override
    public void createThemeReport(ThemeReportCreateDto themeReportCreateDto) {
        themeReportDao.addThemeReport(themeReportCreateDto);
    }
}
