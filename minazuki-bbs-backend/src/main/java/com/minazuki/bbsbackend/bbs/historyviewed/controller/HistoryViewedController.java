package com.minazuki.bbsbackend.bbs.historyviewed.controller;

import com.minazuki.bbsbackend.bbs.favorite.pojo.Favorite;
import com.minazuki.bbsbackend.bbs.historyviewed.dataobject.HistoryViewedCreateDto;
import com.minazuki.bbsbackend.bbs.historyviewed.pojo.HistoryViewed;
import com.minazuki.bbsbackend.bbs.historyviewed.service.HistoryViewedService;
import com.minazuki.bbsbackend.http.StandardResponse;
import com.minazuki.bbsbackend.user.annotation.UserLoginRequired;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags = "历史记录增删查接口")
@RequestMapping("/historyViewed")
public class HistoryViewedController {
    private final HistoryViewedService historyViewedService;
    @Autowired
    public HistoryViewedController(HistoryViewedService historyViewedService){
        this.historyViewedService = historyViewedService;
    }

    @DeleteMapping("/{historyViewedId}/delete")
    @ResponseBody
    @UserLoginRequired
    @ApiOperation(value = "根据Id删除历史记录",notes = "需要登陆")
    public StandardResponse<Object> deleteHistoryViewedById(
            @ApiParam(name = "历史记录Id",required = true)
            @PathVariable Integer historyViewedId
    ){
        this.historyViewedService.deleteHistory(historyViewedId);
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE,
                "success",null);
    }

    @GetMapping("/{historyViewedId}/getHistoryViewed")
    @ResponseBody
    @UserLoginRequired
    @ApiOperation(value = "根据Id获取历史记录",notes = "需要登陆",httpMethod = "GET")
    public StandardResponse<HistoryViewed> getFavoriteById(
            @ApiParam(name = "历史记录Id",required = true)
            @PathVariable Integer historyViewedId
    ){
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE,
        "success",this.historyViewedService.getByIndex(historyViewedId));
    }

    @GetMapping("/myHistories")
    @ResponseBody
    @UserLoginRequired
    @ApiOperation(value = "获取当前用户的所有历史记录",notes = "需要登陆",httpMethod = "GET")
    public StandardResponse<List<HistoryViewed>> getMyFavorite(){
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE,
                "success", this.historyViewedService.getAllHistory());
    }

}
