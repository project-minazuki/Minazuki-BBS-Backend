package com.minazuki.bbsbackend.bbs.favorite.controller;

import com.minazuki.bbsbackend.bbs.favorite.dataobject.FavoriteCreateDto;
import com.minazuki.bbsbackend.bbs.favorite.pojo.Favorite;
import com.minazuki.bbsbackend.bbs.favorite.service.FavoriteService;
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
@Api(tags = "我的收藏相关接口")
@RequestMapping("/favorite")
public class FavoriteController {

    private final FavoriteService favoriteService;
    @Autowired
    public FavoriteController(FavoriteService favoriteService){
        this.favoriteService = favoriteService;
    }

    @PostMapping("/create")
    @ResponseBody
    @UserLoginRequired
    @ApiOperation(value = "加入收藏", notes = "需要登录", httpMethod = "POST")
    public StandardResponse<Object> addToFavorite(
            @ApiParam(name = "新建收藏入参", required = true)
            @RequestBody FavoriteCreateDto favoriteCreateDto
            ){
        this.favoriteService.addFavorite(favoriteCreateDto);
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE,
                "success",null);
    }

    @DeleteMapping("/{favoriteId}/delete")
    @ResponseBody
    @UserLoginRequired
    @ApiOperation(value = "根据Id删除收藏",notes = "需要登陆")
    public StandardResponse<Object> deleteFavoriteById(
            @ApiParam(name = "对应收藏项的Id",required = true)
            @PathVariable Integer favoriteId
            ){
        this.favoriteService.deleteFavorite(favoriteId);
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE,
                "success",null);
    }

    @GetMapping("/{favoriteId}/getAndUpdate")
    @ResponseBody
    @UserLoginRequired
    @ApiOperation(value = "根据收藏项的Id获取收藏并且更新最后查看时间", notes = "需要登录",httpMethod = "GET")
    public StandardResponse<Favorite> getFavoriteById(
            @ApiParam(name = "对应收藏项的Id", required = true)
            @PathVariable Integer favoriteId
    ){
        return new StandardResponse(StandardResponse.SUCCESS_CODE,
                "message", this.favoriteService.getByIndexAndUpdate(favoriteId));
    }

    @GetMapping("/myFavorite")
    @ResponseBody
    @UserLoginRequired
    @ApiOperation(value = "获取我的所有收藏",notes = "需要登陆", httpMethod = "GET")
    public StandardResponse<List<Favorite>> getMyFavorite(){
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE,
                "success", this.favoriteService.getAllFavorite());
    }

}
