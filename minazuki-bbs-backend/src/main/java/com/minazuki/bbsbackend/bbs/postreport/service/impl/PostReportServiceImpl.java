package com.minazuki.bbsbackend.bbs.postreport.service.impl;

import com.minazuki.bbsbackend.bbs.postreport.dao.PostReportDao;
import com.minazuki.bbsbackend.bbs.postreport.dataobject.PostReportCreateDto;
import com.minazuki.bbsbackend.bbs.postreport.pojo.PostReport;
import com.minazuki.bbsbackend.bbs.postreport.service.PostReportService;
import com.minazuki.bbsbackend.user.interceptor.AuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostReportServiceImpl implements PostReportService {

    private final PostReportDao postReportDao;

    @Autowired
    public PostReportServiceImpl(PostReportDao postReportDao) {
        this.postReportDao = postReportDao;
    }


    @Override
    public void addPostReport(PostReportCreateDto postReportCreateDto) {
        postReportCreateDto.setReporterId(AuthenticationInterceptor.getCurrentUserId());
        this.postReportDao.addPostReport(postReportCreateDto);
    }

    @Override
    public void deletePostReport(Integer id) {
        this.postReportDao.deletePostReport(id);
    }

    @Override
    public PostReport getPostReportById(Integer id) {
        return this.postReportDao.getPostReportById(id);
    }

    @Override
    public List<PostReport> findAllPostReports() {
        return this.postReportDao.findAllPostReports();
    }

    @Override
    public List<PostReport> findAllPostReportsByCategoryId(Integer categoryId) {
        return this.postReportDao.findAllPostReportsByCategoryId(categoryId);
    }

    @Override
    public void checkPostReport(Integer id) {
        this.postReportDao.checkPostReport(id);
    }
}
