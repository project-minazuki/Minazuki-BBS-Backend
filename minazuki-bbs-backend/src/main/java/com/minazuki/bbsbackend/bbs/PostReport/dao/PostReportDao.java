package com.minazuki.bbsbackend.bbs.PostReport.dao;

import com.minazuki.bbsbackend.bbs.PostReport.pojo.PostReport;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostReportDao {
    private final SqlSession sqlSession;

    @Autowired
    public PostReportDao(SqlSession sqlSession){this.sqlSession = sqlSession;}

    public void  addPostReport(PostReport postReport){this.sqlSession.insert("addPostReport",postReport);}

    public void deletePostReport(Integer id){this.sqlSession.delete("deletePostReport",id);}
}
