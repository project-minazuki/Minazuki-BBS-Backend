package com.minazuki.bbsbackend.bbs.postreport.dao;

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
        PostReport postReport = PostReport.builder().postId(2).reporterId(1).reason("包含不雅词汇")
                .createdAt(LocalDateTime.now()).checkedAt(LocalDateTime.now()).checked(true).build();
        postReportDao.addPostReport(postReport);
    }

    @Test
    void deletePostReport() {
        Integer id = 1;
        postReportDao.deletePostReport(id);
    }
}