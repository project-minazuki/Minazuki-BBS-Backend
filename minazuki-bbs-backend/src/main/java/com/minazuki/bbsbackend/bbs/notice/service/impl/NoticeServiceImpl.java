package com.minazuki.bbsbackend.bbs.notice.service.impl;

import com.minazuki.bbsbackend.bbs.notice.dao.NoticeDao;
import com.minazuki.bbsbackend.bbs.notice.dataobject.NoticeCreateDto;
import com.minazuki.bbsbackend.bbs.notice.dataobject.NoticeUpdateDto;
import com.minazuki.bbsbackend.bbs.notice.pojo.Notice;
import com.minazuki.bbsbackend.bbs.notice.service.NoticeService;
import com.minazuki.bbsbackend.user.exception.PermissionDeniedException;
import com.minazuki.bbsbackend.user.interceptor.AuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {
    private final NoticeDao noticeDao;
    @Autowired
    public NoticeServiceImpl(NoticeDao noticeDao){this.noticeDao = noticeDao;}


    @Override
    public void addNotice(NoticeCreateDto noticeCreateDto) throws PermissionDeniedException {
        if(noticeDao.isUserCategoryAdministrator(noticeCreateDto.getCreatorId())){
            noticeCreateDto.setCreatorId(AuthenticationInterceptor.getCurrentUserId());
            noticeDao.addNotice(noticeCreateDto);
        }
        else throw new PermissionDeniedException();
    }

    @Override
    public Notice getNoticeById(Integer id) {
        Notice notice = noticeDao.getNoticeById(id);
        return notice;
    }

    @Override
    public List<Notice> findAllNoticesByCategoryId(Integer categoryId) {
        return noticeDao.findAllNotices(categoryId);
    }

    @Override
    public void deleteNoticeById(Integer id) throws PermissionDeniedException{
        if(noticeDao.isUserCategoryAdministrator(id)){
            noticeDao.deleteNotice(id);
        }
        else {
            throw new PermissionDeniedException();
        }

    }

    @Override
    public void updateNoticeById(NoticeUpdateDto noticeUpdateDto) throws PermissionDeniedException{

        if (noticeDao.isUserNoticeCreator(noticeUpdateDto.getId())&&noticeDao.isUserCategoryAdministrator(noticeUpdateDto.getId())){
            if(noticeUpdateDto.isAllNull()) return;
            else noticeDao.updateNotice(noticeUpdateDto);
        }
        else {
            throw new PermissionDeniedException();
        }
    }
}
