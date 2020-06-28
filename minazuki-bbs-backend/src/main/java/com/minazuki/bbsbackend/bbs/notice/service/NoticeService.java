package com.minazuki.bbsbackend.bbs.notice.service;

import com.minazuki.bbsbackend.bbs.notice.dataobject.NoticeCreateDto;
import com.minazuki.bbsbackend.bbs.notice.dataobject.NoticeUpdateDto;
import com.minazuki.bbsbackend.bbs.notice.pojo.Notice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoticeService {

    void addNotice(NoticeCreateDto noticeCreateDto);

    Notice getNoticeById(Integer id);

    List<Notice> findAllNoticesByCategoryId(Integer categoryId);

    void deleteNoticeById(Integer id);

    void updateNoticeById(NoticeUpdateDto noticeUpdateDto);

}
