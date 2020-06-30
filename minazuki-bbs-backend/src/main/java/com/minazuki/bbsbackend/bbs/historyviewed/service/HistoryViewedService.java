package com.minazuki.bbsbackend.bbs.historyviewed.service;

import com.minazuki.bbsbackend.bbs.historyviewed.dataobject.HistoryViewedCreateDto;
import com.minazuki.bbsbackend.bbs.historyviewed.pojo.HistoryViewed;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HistoryViewedService {

    HistoryViewed getByIndex(Integer id);

    void addHistory(HistoryViewedCreateDto historyViewedCreateDto);

    void deleteHistory(Integer id);

    List<HistoryViewed> getAllHistory();

}
