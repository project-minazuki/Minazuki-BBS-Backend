package com.minazuki.bbsbackend.bbs.themereport.service;

import com.minazuki.bbsbackend.bbs.themereport.dataobject.ThemeReportCreateDto;
import com.minazuki.bbsbackend.bbs.themereport.exception.UncheckedThemeReportException;
import com.minazuki.bbsbackend.bbs.themereport.pojo.ThemeReport;
import com.minazuki.bbsbackend.user.exception.PermissionDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ThemeReportService {

    void setThemeReportChecked(Integer id)throws PermissionDeniedException;

    //主题帖是否有未检查的举报
    boolean isThemeHasUncheckedReport(Integer themeId);

    //获取主题帖所有未检查的举报
    public List<ThemeReport> getAllReportsOfTheme(Integer themeId);

    //新建举报
    public void createThemeReport(ThemeReportCreateDto themeReportCreateDto);

    void deleteReportById(Integer id)throws PermissionDeniedException, UncheckedThemeReportException;

}
