package com.minazuki.bbsbackend.bbs.themereport.service;

import com.minazuki.bbsbackend.bbs.themereport.dao.ThemeReportDao;
import com.minazuki.bbsbackend.bbs.themereport.dataobject.ThemeReportCreateDto;
import com.minazuki.bbsbackend.bbs.themereport.exception.UncheckedThemeReportException;
import com.minazuki.bbsbackend.bbs.themereport.pojo.ThemeReport;
import com.minazuki.bbsbackend.user.exception.PermissionDeniedException;
import com.minazuki.bbsbackend.user.interceptor.AuthenticationInterceptor;
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
    public void setThemeReportChecked(Integer id) throws PermissionDeniedException {
        if(themeReportDao.isUserCategoryAdministrator(id)){
            themeReportDao.setThemeReportChecked(id);
        }
        else {
            throw new PermissionDeniedException();
        }
    }

    @Override
    public boolean isThemeHasUncheckedReport(Integer themeId) {
        if(themeReportDao.getUncheckedReportsOfTheme(themeId)!=null){
            return true;
        }
        else
            return false;

    }

    @Override
    public List<ThemeReport> getAllReportsOfTheme(Integer themeId) {
        List reportList = themeReportDao.getAllReportsOfTheme(themeId);
        return reportList;
    }

    @Override
    public void createThemeReport(ThemeReportCreateDto themeReportCreateDto) {
        themeReportCreateDto.setReporterId(AuthenticationInterceptor.getCurrentUserId());
        themeReportDao.addThemeReport(themeReportCreateDto);
    }

    @Override
    public void deleteReportById(Integer id) throws PermissionDeniedException,UncheckedThemeReportException {
        if(themeReportDao.isUserCategoryAdministrator(id)){
            if(themeReportDao.isChecked(id)){
                deleteReportById(id);
            }
            else throw new UncheckedThemeReportException();
        }
        else {
            throw new PermissionDeniedException();
        }
    }
}
