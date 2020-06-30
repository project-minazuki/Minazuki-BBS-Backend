package com.minazuki.bbsbackend.bbs.inbox.controller;

import com.minazuki.bbsbackend.bbs.inbox.dataobject.InboxCreateDto;
import com.minazuki.bbsbackend.bbs.inbox.exception.UncheckedMessageException;
import com.minazuki.bbsbackend.bbs.inbox.pojo.Inbox;
import com.minazuki.bbsbackend.bbs.inbox.service.InboxService;
import com.minazuki.bbsbackend.http.StandardResponse;
import com.minazuki.bbsbackend.user.annotation.UserLoginRequired;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.MediaSize;
import java.util.List;
import java.util.NavigableMap;

@Controller
@Api(tags = "邮件相关接口")
@RequestMapping("/inbox")
public class InboxController {
    public final InboxService inboxService;
    @Autowired
    public InboxController(InboxService inboxService){
        this.inboxService = inboxService;
    }

    @PostMapping("/create")
    @ResponseBody
    @UserLoginRequired
    @ApiOperation(value = "创建邮件",notes = "需要登陆",httpMethod = "POST")
    public StandardResponse<Object> createInbox(
            @ApiParam(name = "创建邮件入参",required = true)
            @RequestBody InboxCreateDto inboxCreateDto
            ){
        this.inboxService.createInbox(inboxCreateDto);
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE,"success",null);
    }

    @DeleteMapping("/{messageId}/delete")
    @ResponseBody
    @UserLoginRequired
    @ApiOperation(value = "删除指定邮件", notes = "需要登陆")
    public StandardResponse<Object> deleteMessageById(
            @ApiParam(name = "邮件的Id",required = true)
            @PathVariable Integer messageId
    ){
        try {
            this.inboxService.deleteMessageById(messageId);
        } catch (UncheckedMessageException e) {
            return new StandardResponse<>(StandardResponse.FAILURE_CODE,e.getMessage(),null);
        }
        return new StandardResponse<>(StandardResponse.FAILURE_CODE,"success",null);
    }

    @GetMapping("/{messageId}/get")
    @ResponseBody
    @UserLoginRequired
    @ApiOperation(value = "根据邮件Id获取邮件并将邮件设为已读",notes = "需要登录",httpMethod = "GET")
    public StandardResponse<Inbox> getMessageById(
            @ApiParam(name = "邮件的Id", required = true)
            @PathVariable Integer messageId
    ){
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE,
                "success",this.inboxService.getMessageById(messageId));
    }


    @GetMapping("/{userId}/myInbox/countAllUnchecked")
    @ResponseBody
    @UserLoginRequired
    @ApiOperation(value = "获取收件箱所有未确认邮件的数量",notes = "需要登录",httpMethod = "GET")
    public StandardResponse<Integer> countUncheckedInbox(
            @ApiParam(name = "用户Id",required = true)
            @PathVariable Integer userId
            ){
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE,"success", this.inboxService.countUnCheckedInbox(userId));
    }

    @GetMapping("/{userId}/myInbox")
    @ResponseBody
    @UserLoginRequired
    @ApiOperation(value = "查看收件箱", notes = "需要登录", httpMethod = "GET")
    public StandardResponse<List<Inbox>> getInbox(
            @ApiParam(name = "收件箱用户Id", required = true)
            @PathVariable Integer userId
    ){
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE,
                "success", this.inboxService.getInboxByRecipientId(userId));
    }

    @GetMapping("/{userId}/myOutbox")
    @ResponseBody
    @UserLoginRequired
    @ApiOperation(value = "查看发件箱",notes = "需要登录", httpMethod = "GET")
    public StandardResponse<List<Inbox>> getOutBox(
            @ApiParam(name = "发件箱用户Id",required = true)
            @PathVariable Integer userId
    ){
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE,
                "success",this.inboxService.getOutBoxBySenderId(userId));
    }

}
