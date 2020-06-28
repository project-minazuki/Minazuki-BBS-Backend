package com.minazuki.bbsbackend.bbs.notice.dao;

import com.minazuki.bbsbackend.bbs.notice.dataobject.NoticeCreateDto;
import com.minazuki.bbsbackend.bbs.notice.dataobject.NoticeUpdateDto;
import com.minazuki.bbsbackend.bbs.notice.pojo.Notice;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.time.LocalDateTime;
import java.util.List;

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

        noticeDao.updateNotice(noticeUpdateDto);
    }

    @Test
    void getCategoryAdministrators(){
        Integer id = 1;
        List<Integer> list = noticeDao.getCategoryAdministrators(id);
        System.out.println(list);
    }

    @Test
    void getCreatorIdByNoticeId(){
        Integer id = 1;
        Integer list = noticeDao.getCreatorIdByNoticeId(id);
        System.out.println(list);
    }

    @Test
    void isUserCategoryAdministrator(){
        Integer id = 2;
        boolean flag = noticeDao.isUserCategoryAdministrator(id);
        System.out.println(flag);
    }

    @Test
    void isUserNoticeCreator(){
        Integer id = 2;
        boolean flag = noticeDao.isUserNoticeCreator(id);
        System.out.println(flag);
    }
}