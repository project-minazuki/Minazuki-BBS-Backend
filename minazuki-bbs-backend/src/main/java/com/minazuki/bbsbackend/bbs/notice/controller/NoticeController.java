package com.minazuki.bbsbackend.bbs.notice.controller;

import com.minazuki.bbsbackend.bbs.notice.dataobject.NoticeCreateDto;
import com.minazuki.bbsbackend.bbs.notice.dataobject.NoticeUpdateDto;
import com.minazuki.bbsbackend.bbs.notice.pojo.Notice;
import com.minazuki.bbsbackend.bbs.notice.service.NoticeService;
import com.minazuki.bbsbackend.http.StandardResponse;
import com.minazuki.bbsbackend.user.annotation.UserLoginRequired;
import com.minazuki.bbsbackend.user.exception.PermissionDeniedException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags = "Notice相关接口")
@RequestMapping("/notice")
public class NoticeController {
    private final NoticeService noticeService;
    @Autowired
    public NoticeController(NoticeService noticeService){
        this.noticeService = noticeService;
    }

    @PostMapping("/create")
    @ResponseBody
    @UserLoginRequired
    @ApiOperation(value = "创建公告", notes = "需要登陆且是版块版主", httpMethod = "POST")
    public StandardResponse<Object> createNotice(
            @ApiParam(name = "创建公告入参", required = true)
            @RequestBody NoticeCreateDto noticeCreateDto
            ) throws PermissionDeniedException{
        this.noticeService.addNotice(noticeCreateDto);
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE, "success", null);
    }

    @GetMapping("/{noticeId}/getNoticeById")
    @ResponseBody
    @ApiOperation(value = "查看公告详情", httpMethod = "GET")
    public StandardResponse<Notice> getNoticeById(
            @ApiParam(name = "公告Id", required = true)
            @PathVariable Integer noticeId
    ){
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE,
                "success", this.noticeService.getNoticeById(noticeId));
    }

    @GetMapping("/{categoryId}/all")
    @ResponseBody
    @ApiOperation(value = "查看指定版块下的所有公告", httpMethod = "GET")
    public StandardResponse<List<Notice>> findAllNoticeByCategoryId(
            @ApiParam(name = "公告Id", required = true)
            @PathVariable Integer categoryId
    ){
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE,
                "success",noticeService.findAllNoticesByCategoryId(categoryId));
    }

    @DeleteMapping("/{noticeId}/delete")
    @ResponseBody
    @UserLoginRequired
    @ApiOperation(value = "删除公告", notes = "是版块的版主")
    public StandardResponse<Object> deleteNoticeById(
            @ApiParam(name = "删除公告",required = true)
            @PathVariable Integer noticeId
    ) throws PermissionDeniedException{
        this.noticeService.deleteNoticeById(noticeId);
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE,"success",null);
    }

    @PostMapping("/update")
    @ResponseBody
    @UserLoginRequired
    @ApiOperation(value = "修改公告",notes = "是创建者且是版块版主")
    public StandardResponse<Object> updateNotice(
            @ApiParam(name = "Notice更新的数据结构",required = true)
            @RequestBody NoticeUpdateDto noticeUpdateDto
            ) throws PermissionDeniedException{
        this.noticeService.updateNoticeById(noticeUpdateDto);
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE,"success",null);
    }


}
