package com.minazuki.bbsbackend.bbs.postreport.service;

import com.minazuki.bbsbackend.bbs.postreport.dataobject.PostReportCreateDto;
import com.minazuki.bbsbackend.bbs.postreport.pojo.PostReport;

import java.util.List;

public interface PostReportService {

    void addPostReport(PostReportCreateDto postReportCreateDto);

    void deletePostReport(Integer id);

    PostReport getPostReportById(Integer id);

    List<PostReport> findAllPostReports();

    List<PostReport> findAllPostReportsByCategoryId(Integer categoryId);

    void checkPostReport(Integer id);
}
