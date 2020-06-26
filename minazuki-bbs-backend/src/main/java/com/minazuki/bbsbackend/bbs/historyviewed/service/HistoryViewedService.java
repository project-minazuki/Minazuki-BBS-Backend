package com.minazuki.bbsbackend.bbs.historyviewed.service;

import com.minazuki.bbsbackend.bbs.historyviewed.dataobject.HistoryViewedCreateDto;
import com.minazuki.bbsbackend.bbs.historyviewed.pojo.HistoryViewed;

import java.util.List;

public interface HistoryViewedService {

    HistoryViewed getByIndex(Integer id);

    void addHistory(HistoryViewedCreateDto historyViewedCreateDto);

    void deleteHistory(Integer id);

    List<HistoryViewed> getAllHistoryByUserId(Integer userId);

}
