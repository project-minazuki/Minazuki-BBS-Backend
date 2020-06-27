package com.minazuki.bbsbackend.bbs.postreport.dao;

import com.minazuki.bbsbackend.bbs.postreply.dataobject.PostReplyCreateDto;
import com.minazuki.bbsbackend.bbs.postreport.dataobject.PostReportCreateDto;
import com.minazuki.bbsbackend.bbs.postreport.pojo.PostReport;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostReportDao {
    private final SqlSession sqlSession;

    @Autowired
    public PostReportDao(SqlSession sqlSession){this.sqlSession = sqlSession;}

    public void  addPostReport(PostReportCreateDto postReportCreateDto){this.sqlSession.insert("addPostReport",postReportCreateDto);}

    public void deletePostReport(Integer id){this.sqlSession.delete("deletePostReport",id);}

    public PostReport getPostReportById(Integer id) {
        return this.sqlSession.selectOne("getPostReportById", id);
    }

    public List<PostReport> findAllPostReports() {
        return this.sqlSession.selectList("findAllPostReports");
    }

    public List<PostReport> findAllPostReportsByCategoryId(Integer categoryId) {
        return this.sqlSession.selectList("findAllPostReportsByCategoryId",categoryId);
    }

    public void checkPostReport(Integer id) {
        this.sqlSession.update("checkPostReport", id);
    }


}
