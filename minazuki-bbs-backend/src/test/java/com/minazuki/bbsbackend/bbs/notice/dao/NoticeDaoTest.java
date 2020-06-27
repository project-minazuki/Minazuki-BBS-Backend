package com.minazuki.bbsbackend.bbs.notice.dao;

import com.minazuki.bbsbackend.bbs.notice.dataobject.NoticeCreateDto;
import com.minazuki.bbsbackend.bbs.notice.dataobject.NoticeUpdateDto;
import com.minazuki.bbsbackend.bbs.notice.pojo.Notice;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.time.LocalDateTime;

@SpringBootTest
class NoticeDaoTest {

    @Resource
    private NoticeDao noticeDao;

    @Test
    void addNotice() {
        NoticeCreateDto noticeCreateDto = new NoticeCreateDto();
        noticeCreateDto.setCategoryId(1);
        noticeCreateDto.setContent("通告内容");
        noticeCreateDto.setTitle("通告标题");
        noticeCreateDto.setCreatorId(4);
        noticeDao.addNotice(noticeCreateDto);
    }

    @Test
    void getNoticeByIdTest() {
        System.out.println(noticeDao.getNoticeById(1));
    }

    @Test
    void findNoticesTest() {
        System.out.println(noticeDao.findAllNotices(1));
    }

    @Test
    void deleteNotice() {
        Integer id = 1;
        noticeDao.deleteNotice(id);
    }

    @Test
    void updateNotice(){
        NoticeUpdateDto noticeUpdateDto = new NoticeUpdateDto();
        noticeUpdateDto.setTitle("公告更新");
        noticeUpdateDto.setContent("隔壁超市的薯片半价啦！！");
        noticeUpdateDto.setId(1);

        noticeDao.updateNoticeById(noticeUpdateDto);
    }
}