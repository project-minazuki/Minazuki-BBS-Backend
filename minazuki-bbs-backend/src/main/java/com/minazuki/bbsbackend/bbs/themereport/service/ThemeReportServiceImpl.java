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

    /*
    ******注：该方法应该写到Category的Service里
    @Override
    public void deleteCheckedReports(Integer categoryId) throws PermissionDeniedException{

        if(themeReportDao.isUserCategoryAdministrator(categoryId)){
            themeReportDao.deleteCheckedReports(categoryId);
        }
        else {
            throw new PermissionDeniedException();
        }
    }

     */

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

    /*
    ******注：该方法应该写到Category的Service里

    @Override
    public List<ThemeReport> findAllThemeReportsByCategoryId(Integer categoryId) throws PermissionDeniedException{
        return themeReportDao.findAllThemeReportsByCategoryId(categoryId);
    }

     */

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
