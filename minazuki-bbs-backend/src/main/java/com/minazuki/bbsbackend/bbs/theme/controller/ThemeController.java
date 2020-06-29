package com.minazuki.bbsbackend.bbs.theme.controller;

import com.minazuki.bbsbackend.bbs.tag.dataobject.ThemeTagLinkDto;
import com.minazuki.bbsbackend.bbs.tag.pojo.Tag;
import com.minazuki.bbsbackend.bbs.theme.dataobject.ThemeCreateDto;
import com.minazuki.bbsbackend.bbs.theme.dataobject.ThemeUpdateDto;
import com.minazuki.bbsbackend.bbs.theme.exception.DuplicateThemeInfoException;
import com.minazuki.bbsbackend.bbs.theme.pojo.Theme;
import com.minazuki.bbsbackend.bbs.theme.service.ThemeService;
import com.minazuki.bbsbackend.bbs.themereport.dataobject.ThemeReportCreateDto;
import com.minazuki.bbsbackend.bbs.themereport.service.ThemeReportService;
import com.minazuki.bbsbackend.http.StandardResponse;
import com.minazuki.bbsbackend.user.annotation.UserLoginRequired;
import com.minazuki.bbsbackend.user.exception.PermissionDeniedException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags = "主题相关接口")
@RequestMapping("/theme")
public class ThemeController {

    private final ThemeService themeService;
    private final ThemeReportService themeReportService;

    @Autowired
    public ThemeController(ThemeReportService themeReportService, ThemeService themeService) {
        this.themeReportService = themeReportService;
        this.themeService = themeService;
    }

    @PostMapping("/create")
    @ResponseBody
    @UserLoginRequired
    @ApiOperation(value = "创建主题帖", notes = "需要登录", httpMethod = "POST")
    public StandardResponse<Object> createTheme(
            @ApiParam(name = "新建主题入参数据模型", required = true)
            @RequestBody ThemeCreateDto themeCreateDto) {
        try {
            this.themeService.createTheme(themeCreateDto);
        } catch (DuplicateThemeInfoException e) {
            return new StandardResponse<>(StandardResponse.FAILURE_CODE, e.getMessage(), null);
        }
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE, "success", null);
    }

    @GetMapping("/{themeId}")
    @ResponseBody
    @ApiOperation(value = "查看主题帖详情", httpMethod = "GET")
    public StandardResponse<Theme> getThemeById(
            @ApiParam(name = "主题id", required = true)
            @PathVariable Integer themeId) {
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE,
                "success", this.themeService.getThemeByIndex(themeId));
    }

    @GetMapping("/top10/byThemeReplyCount")
    @ResponseBody
    @ApiOperation(value = "按回复数获取top10主题帖", notes = "不分版块", httpMethod = "GET")
    public StandardResponse<List<Theme>> findTop10ThemeByReplyCount() {
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE,
                "success", themeService.findTop10ByReplyCount());
    }

    @GetMapping("/top10/byThemeVisitsCount")
    @ResponseBody
    @ApiOperation(value = "按访问量获取top10主题帖", notes = "不分版块", httpMethod = "GET")
    public StandardResponse<List<Theme>> findTop10ThemeByVisitsCount() {
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE,
                "success", themeService.findTop10ByVisitsCount());
    }

    @GetMapping("/{categoryId}/all")
    @ResponseBody
    @ApiOperation(value = "查看指定版块下的所有主题帖", httpMethod = "GET")
    public StandardResponse<List<Theme>> findAllThemeByCategoryId(
            @ApiParam(name = "版块id", required = true)
            @PathVariable Integer categoryId) {
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE,
                "success", themeService.getThemeListByCategoryId(categoryId));
    }

    @GetMapping("/{categoryId}/highQuality")
    @ResponseBody
    @ApiOperation(value = "获取该版块所有的精品贴", httpMethod = "GET")
    public StandardResponse<List<Theme>> findAllHighQualityThemeByCategoryId(
            @ApiParam(name = "版块id", required = true)
            @PathVariable Integer categoryId) {
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE,
                "success", this.themeService.getHighQualityThemeByCategoryId(categoryId));
    }

    @GetMapping("/{categoryId}/top")
    @ResponseBody
    @ApiOperation(value = "获取该板块所有的置顶帖", httpMethod = "GET")
    public StandardResponse<List<Theme>> findAllTopThemeByCategoryId(
            @ApiParam(name = "版块id", required = true)
            @PathVariable Integer categoryId) {
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE,
                "success", themeService.getTopThemeByCategoryId(categoryId));
    }

    @GetMapping("/search")
    @ResponseBody
    @ApiOperation(value = "根据关键词搜索主题帖", notes = "模糊搜索", httpMethod = "GET")
    public StandardResponse<List<Theme>> searchThemeByTitle(
            @ApiParam(name = "搜索主题帖关键词", required = true)
            @RequestParam String keyword) {
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE,
                "success", this.themeService.searchThemeByTitle(keyword));
    }

    @GetMapping("/{categoryId}/selectByTag")
    @ResponseBody
    @ApiOperation(value = "根据tag筛选主题帖", notes = "可以多tag", httpMethod = "GET")
    public StandardResponse<List<Theme>> selectThemeByTag(
            @RequestBody List<Tag> tags,
            @PathVariable Integer categoryId) {
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE,
                "success", themeService.selectThemeByTag(tags, categoryId));
    }

    @PostMapping("/update")
    @ResponseBody
    @UserLoginRequired
    @ApiOperation(value = "修改主题帖", notes = "只有创建者有权限,需要登录")
    public StandardResponse<Object> updateTheme(
            @ApiParam(name = "更新主题帖入参", required = true)
            @RequestBody ThemeUpdateDto themeUpdateDto) throws PermissionDeniedException{
        try {
            this.themeService.updateThemeTitle(themeUpdateDto);
        } catch (DuplicateThemeInfoException e) {
            return new StandardResponse<>(StandardResponse.FAILURE_CODE, e.getMessage(), null);
        }
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE, "success", null);
    }

    @DeleteMapping("/{themeId}")
    @ResponseBody
    @UserLoginRequired
    @ApiOperation(value = "删除主题帖", notes = "只有创建者或者版主有权，需要登录")
    public StandardResponse<Object> deleteThemeById(
            @ApiParam(name = "主题帖id", required = true)
            @PathVariable Integer themeId) throws PermissionDeniedException{
        this.themeService.deleteThemeById(themeId);
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE, "success", null);
    }

    @GetMapping("/{themeId}/setHighQuality")
    @ResponseBody
    @UserLoginRequired
    @ApiOperation(value = "设置为精品贴", httpMethod = "GET")
    public StandardResponse<Object> setThemeHighQuality(
            @ApiParam(name = "themeId", required = true)
            @PathVariable Integer themeId) throws PermissionDeniedException{
        this.themeService.setHighQuality(themeId);
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE, "success", null);
    }

    @GetMapping("/{themeId}/cancelSetHighQuality")
    @ResponseBody
    @UserLoginRequired
    @ApiOperation(value = "取消精品贴", httpMethod = "GET")
    public StandardResponse<Object> cancelSetThemeHighQuality(
            @ApiParam(name = "themeId", required = true)
            @PathVariable Integer themeId) throws PermissionDeniedException{
        this.themeService.cancelHighQuality(themeId);
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE, "success", null);
    }

    @GetMapping("/{themeId}/setTop")
    @ResponseBody
    @UserLoginRequired
    @ApiOperation(value = "设置为置顶帖", httpMethod = "GET")
    public StandardResponse<Object> setThemeTop(
            @ApiParam(name = "themeId", required = true)
            @PathVariable Integer themeId) throws PermissionDeniedException{
        this.themeService.setTopById(themeId);
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE, "success", null);
    }

    @GetMapping("/{themeId}/cancelSetTop")
    @ResponseBody
    @UserLoginRequired
    @ApiOperation(value = "取消置顶贴", httpMethod = "GET")
    public StandardResponse<Object> cancelSetThemeTop(
            @ApiParam(name = "themeId", required = true)
            @PathVariable Integer themeId) throws PermissionDeniedException{
        this.themeService.setHighQuality(themeId);
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE, "success", null);
    }

    @GetMapping("/tag")
    @ResponseBody
    @ApiOperation(value = "获取所有可选tag", httpMethod = "GET")
    public StandardResponse<List<Tag>> getTagsList() {
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE, "success", themeService.getTagList());
    }


    @PostMapping("/tag/add")
    @ResponseBody
    @UserLoginRequired
    @ApiOperation(value = "给theme添加tag", httpMethod = "POST")
    public StandardResponse<Object> addTag(
            @ApiParam(name = "主题帖id和tag id入参", required = true)
            @RequestBody ThemeTagLinkDto themeTagLinkDto) throws PermissionDeniedException{
        this.themeService.addTagToTheme(themeTagLinkDto);
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE, "success", null);
    }

    @PostMapping("/tag/remove")
    @ResponseBody
    @UserLoginRequired
    @ApiOperation(value = "给theme移除tag", httpMethod = "POST")
    public StandardResponse<Object> removeTag(
            @ApiParam(name = "主题帖id和tag id入参", required = true)
            @RequestBody ThemeTagLinkDto themeTagLinkDto) throws PermissionDeniedException{
        this.themeService.removeTagFromTheme(themeTagLinkDto);
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE, "success", null);
    }

    @PostMapping("/report")
    @ResponseBody
    @UserLoginRequired
    @ApiOperation(value = "举报主题帖", httpMethod = "POST")
    public StandardResponse<Object> reportTheme(
            @RequestBody ThemeReportCreateDto trcDto) {
        this.themeReportService.createThemeReport(trcDto);
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE, "success", null);
    }

}
