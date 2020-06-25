package com.minazuki.bbsbackend.bbs.Notice.dao;

import com.minazuki.bbsbackend.bbs.Notice.dataObject.NoticeUpdateDto;
import com.minazuki.bbsbackend.bbs.Notice.pojo.Notice;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NoticeDao {
    private final SqlSession sqlSession;

    @Autowired
    public NoticeDao(SqlSession sqlSession){this.sqlSession = sqlSession;}

    public void addNotice(Notice notice){this.sqlSession.insert("addNotice",notice);}

    public void deleteNotice(Integer id){this.sqlSession.delete("deleteNotice",id);}

    public void updateNoticeById(NoticeUpdateDto noticeUpdateDto){this.sqlSession.update("updateNoticeById",noticeUpdateDto);}

}
