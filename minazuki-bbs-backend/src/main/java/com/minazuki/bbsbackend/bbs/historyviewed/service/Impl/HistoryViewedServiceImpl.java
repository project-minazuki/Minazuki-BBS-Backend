package com.minazuki.bbsbackend.bbs.historyviewed.service.Impl;

import com.minazuki.bbsbackend.bbs.historyviewed.dao.HistoryViewedDao;
import com.minazuki.bbsbackend.bbs.historyviewed.dataobject.HistoryViewedCreateDto;
import com.minazuki.bbsbackend.bbs.historyviewed.pojo.HistoryViewed;
import com.minazuki.bbsbackend.bbs.historyviewed.service.HistoryViewedService;
import com.minazuki.bbsbackend.user.interceptor.AuthenticationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HistoryViewedServiceImpl implements HistoryViewedService {

    private final HistoryViewedDao historyViewedDao;

    public HistoryViewedServiceImpl(HistoryViewedDao historyViewedDao){
        this.historyViewedDao = historyViewedDao;
    }


    @Override
    public HistoryViewed getByIndex(Integer id) {
        return historyViewedDao.getHistoryViewedById(id);
    }

    @Override
    public void addHistory(HistoryViewedCreateDto historyViewedCreateDto) {
        historyViewedCreateDto.setOwnerId(AuthenticationInterceptor.getCurrentUserId());
        historyViewedDao.addHistoryViewed(historyViewedCreateDto);
    }

    @Override
    public void deleteHistory(Integer id) {
        historyViewedDao.deleteHistoryViewed(id);
    }

    @Override
    public List<HistoryViewed> getAllHistory() {
        Integer userId = AuthenticationInterceptor.getCurrentUserId();
        return historyViewedDao.findAllHistoryViewed(userId);
    }
}
