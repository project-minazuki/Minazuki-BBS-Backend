package com.minazuki.bbsbackend.bbs.postreport.dao;

import com.minazuki.bbsbackend.bbs.postreport.dataobject.PostReportCreateDto;
import com.minazuki.bbsbackend.bbs.postreport.pojo.PostReport;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.time.LocalDateTime;

@SpringBootTest
class PostReportDaoTest {

    @Resource
    private PostReportDao postReportDao;
    @Test
    void addPostReport() {
        PostReportCreateDto postReportCreateDto = new PostReportCreateDto();
        postReportCreateDto.setPostId(3);
        postReportCreateDto.setReason("不良词汇");
        postReportCreateDto.setReporterId(4);
        postReportDao.addPostReport(postReportCreateDto);
    }

    @Test
    void getPostReportByIdTest() {
        System.out.println(postReportDao.getPostReportById(1));
    }

    @Test
    void deletePostReport() {
        Integer id = 1;
        postReportDao.deletePostReport(id);
    }

    @Test
    void checkPostReportTest() {
        postReportDao.checkPostReport(1);
    }

    @Test
    void findAllPostReportsTest() {
        System.out.println(postReportDao.findAllPostReports());
    }

    @Test
    void findAllPostReportsByCategoryIdTest() {
        System.out.println(postReportDao.findAllPostReportsByCategoryId(2));
    }
}