package com.minazuki.bbsbackend.bbs.notice.dao;

import com.minazuki.bbsbackend.bbs.notice.dataobject.NoticeCreateDto;
import com.minazuki.bbsbackend.bbs.notice.dataobject.NoticeUpdateDto;
import com.minazuki.bbsbackend.bbs.notice.pojo.Notice;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NoticeDao {
    private final SqlSession sqlSession;

    @Autowired
    public NoticeDao(SqlSession sqlSession){this.sqlSession = sqlSession;}

    public void addNotice(NoticeCreateDto noticeCreateDto){this.sqlSession.insert("addNotice", noticeCreateDto);}

    public Notice getNoticeById(Integer id) {
        return this.sqlSession.selectOne("getNoticeById", id);
    }

    public List<Notice> findAllNotices(Integer categoryId) {
        return this.sqlSession.selectList("findAllNotices", categoryId);
    }

    public void deleteNotice(Integer id){this.sqlSession.delete("deleteNotice",id);}

    public void updateNotice(NoticeUpdateDto noticeUpdateDto){this.sqlSession.update("updateNotice",noticeUpdateDto);}

}
