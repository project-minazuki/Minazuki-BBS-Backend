package com.minazuki.bbsbackend.bbs.post.controller;

import com.minazuki.bbsbackend.bbs.post.dataobject.PostCreateDto;
import com.minazuki.bbsbackend.bbs.post.dataobject.PostUpdateDto;
import com.minazuki.bbsbackend.bbs.post.pojo.Post;
import com.minazuki.bbsbackend.bbs.post.service.PostService;
import com.minazuki.bbsbackend.bbs.postreply.dataobject.PostReplyCreateDto;
import com.minazuki.bbsbackend.bbs.postreply.service.PostReplyService;
import com.minazuki.bbsbackend.bbs.postreport.service.PostReportService;
import com.minazuki.bbsbackend.http.StandardResponse;
import com.minazuki.bbsbackend.user.annotation.UserLoginRequired;
import com.minazuki.bbsbackend.user.exception.PermissionDeniedException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags = "普通帖子相关")
@RequestMapping("/post")
public class PostController {
    private final PostService postService;
    private final PostReplyService postReplyService;

    @Autowired
    public PostController(PostService postService, PostReplyService postReplyService) {
        this.postService = postService;
        this.postReplyService = postReplyService;
    }

    @GetMapping("/theme/{themeId}")
    @ResponseBody
    @ApiOperation(value = "获取指定主题帖下的所有帖子", notes = "包括楼中楼", httpMethod = "GET")
    public StandardResponse<List<Post>> getPostOfTheme(
            @ApiParam(name = "主题帖id", required = true)
            @PathVariable Integer themeId ){
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE,
                "success", this.postService.findAllPostsByThemeId(themeId));
    }

    @GetMapping("/{postId}")
    @ResponseBody
    @ApiOperation(value = "获取特定帖子详情", httpMethod = "GET")
    public StandardResponse<Post> getPostById(
            @ApiParam(name = "帖子id", required = true)
            @PathVariable Integer postId ){
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE,
                "success", this.postService.getPostById(postId));
    }

    @PostMapping("/create")
    @ResponseBody
    @UserLoginRequired
    @ApiOperation(value = "回帖，创建普通帖子", notes = "需要登录", httpMethod = "POST")
    public StandardResponse<Object> createPost(
            @ApiParam(name = "创建帖子入参", required = true)
            @RequestBody PostCreateDto postCreateDto ) {
        this.postService.addPost(postCreateDto);
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE, "success", null);
    }

    @DeleteMapping("/{postId}")
    @ResponseBody
    @UserLoginRequired
    @ApiOperation(value = "删除回帖", notes = "只有帖子创建者和主题帖创建者有权限", httpMethod = "DELETE")
    public StandardResponse<Object> deletePost(
            @ApiParam(name = "帖子id", required = true)
            @PathVariable Integer postId ) throws PermissionDeniedException {
        this.postService.deletePost(postId);
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE, "success", null);
    }

    @PostMapping("/update")
    @ResponseBody
    @UserLoginRequired
    @ApiOperation(value = "修改帖子内容", notes = "需要帖子作者权限", httpMethod = "POST")
    public StandardResponse<Object> updatePost(
            @ApiParam(name = "修改帖子入参", required = true)
            @RequestBody PostUpdateDto postUpdateDto ) throws PermissionDeniedException {
        this.postService.updatePost(postUpdateDto);
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE,"success", null);
    }

    @GetMapping("/{postId}/like")
    @ResponseBody
    @ApiOperation(value = "点赞帖子", httpMethod = "GET")
    public StandardResponse<Object> likePost(
            @ApiParam(name = "帖子id", required = true)
            @PathVariable Integer postId ) {
        this.postService.likePost(postId);
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE, "success", null);
    }

    @GetMapping("/{postId}/unlike")
    @ResponseBody
    @ApiOperation(value = "点踩帖子", httpMethod = "GET")
    public StandardResponse<Object> unlikePost(
            @ApiParam(name = "帖子id", required = true)
            @PathVariable Integer postId ) {
        this.postService.unlikePost(postId);
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE, "success", null);
    }

    @PostMapping("/reply/create")
    @ResponseBody
    @UserLoginRequired
    @ApiOperation(value = "普通帖子的回复，楼中楼", httpMethod = "POST")
    public StandardResponse<Object> createReplyPost(
            @ApiParam(name = "楼中楼入参", required = true)
            @RequestBody PostReplyCreateDto prcDto ) {
        this.postReplyService.addPostReply(prcDto);
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE,"success", null);
    }

    @DeleteMapping("/reply/{postReplyId}/delete")
    @ResponseBody
    @UserLoginRequired
    @ApiOperation(value = "删除楼中楼", notes = "需要作者", httpMethod = "DELETE")
    public StandardResponse<Object> deleteReplyPost(
            @ApiParam(name = "楼中楼id", required = true)
            @PathVariable Integer postReplyId ) throws PermissionDeniedException {
        this.postReplyService.deletePostReply(postReplyId);
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE,"success", null);
    }

}
