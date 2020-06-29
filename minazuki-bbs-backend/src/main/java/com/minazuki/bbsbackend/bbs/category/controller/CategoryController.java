package com.minazuki.bbsbackend.bbs.category.controller;

import com.minazuki.bbsbackend.bbs.category.dataobject.CategoryCreateDto;
import com.minazuki.bbsbackend.bbs.category.dataobject.CategoryUpdateDto;
import com.minazuki.bbsbackend.bbs.category.exception.DuplicateCategoryNameException;
import com.minazuki.bbsbackend.bbs.category.pojo.Category;
import com.minazuki.bbsbackend.bbs.category.service.CategoryService;
import com.minazuki.bbsbackend.bbs.categorymoderator.dataobject.ModeratorPrimaryKeyDto;
import com.minazuki.bbsbackend.http.StandardResponse;
import com.minazuki.bbsbackend.user.annotation.AdminRequired;
import com.minazuki.bbsbackend.user.annotation.UserLoginRequired;
import com.minazuki.bbsbackend.user.dataobject.UserInfoOutDto;
import com.minazuki.bbsbackend.user.exception.PermissionDeniedException;
import com.minazuki.bbsbackend.user.interceptor.AuthenticationInterceptor;
import com.minazuki.bbsbackend.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@Api(tags = "版块相关接口")
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;
    private final UserService userService;

    @Autowired
    public CategoryController(CategoryService categoryService, UserService userService) {
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @GetMapping("")
    @ResponseBody
    @ApiOperation(value = "获取所有开启的版块", notes = "仅返回开启的版块", httpMethod = "GET")
    public StandardResponse<List<Category>> findAllOpenCategories() {
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE, "success",
                categoryService.getAllOpenCategories());
    }

    @GetMapping("/all")
    @ResponseBody
    @AdminRequired
    @ApiOperation(value = "获取所有版块", notes = "包括未开启的，需要管理员权限", httpMethod = "GET")
    public StandardResponse<List<Category>> findAllCategories() {
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE, "success",
                categoryService.getAllCategories());
    }

    @GetMapping("/{categoryId}")
    @ResponseBody
    @ApiOperation(value = "根据id获取板块信息", httpMethod = "GET")
    public StandardResponse<Category> getCategoryInfoById(
            @ApiParam(name = "版块id", required = true)
            @PathVariable Integer categoryId) {
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE, "success", categoryService.getByIndex(categoryId));
    }

    @GetMapping("/{categoryId}/close")
    @ResponseBody
    @AdminRequired
    @ApiOperation(value = "根据id关闭板块", httpMethod = "GET")
    public StandardResponse<Object> closeCategory(
            @ApiParam(name = "版块id", required = true)
            @PathVariable Integer categoryId) {
        this.categoryService.closeCategory(categoryId);
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE, "success", null);
    }

    @GetMapping("/{categoryId}/open")
    @ResponseBody
    @AdminRequired
    @ApiOperation(value = "根据id开启板块", httpMethod = "GET")
    public StandardResponse<Object> openCategory(
            @ApiParam(name = "版块id", required = true)
            @PathVariable Integer categoryId) {
        this.categoryService.openCategory(categoryId);
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE, "success", null);
    }

    @DeleteMapping("/{categoryId}")
    @ResponseBody
    @AdminRequired
    @ApiOperation(value = "根据id删除板块", notes = "需要管理员权限", httpMethod = "DELETE")
    public StandardResponse<Object> deleteCategoryById(
            @ApiParam(name = "版块id",required = true)
            @PathVariable Integer categoryId) {
        this.categoryService.deleteCategory(categoryId);
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE, "success", null);
    }

    @PostMapping("/create")
    @ResponseBody
    @AdminRequired
    @ApiOperation(value = "创建板块", notes = "需要管理员权限", httpMethod = "POST")
    public StandardResponse<String> createCategory(@RequestBody CategoryCreateDto categoryCreateDto) {
        try {
            categoryService.createCategory(categoryCreateDto);
        } catch (DuplicateCategoryNameException e) {
            return new StandardResponse<>(StandardResponse.FAILURE_CODE, e.getMessage(), null);
        }
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE, "success", null);
    }

    @PostMapping("/update")
    @ResponseBody
    @UserLoginRequired
    @ApiOperation(value = "修改版块信息", notes = "只有版主有权限", httpMethod = "POST")
    public StandardResponse<Object> updateCategory(
            @ApiParam(name = "修改板块入参", value = "版块id（必需）", required = true)
            @RequestBody CategoryUpdateDto categoryUpdateDto) throws PermissionDeniedException{
        try {
            categoryService.updateCategory(categoryUpdateDto);
        }catch(DuplicateCategoryNameException e) {
            return new StandardResponse<>(StandardResponse.FAILURE_CODE, e.getMessage(), null);
        }
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE, "success", null);
    }

    @GetMapping("/{categoryId}/moderator")
    @ResponseBody
    @ApiOperation(value = "获取该板块所有版主", notes = "可能不止一个", httpMethod = "GET")
    public StandardResponse<List<UserInfoOutDto>> getModerator(
            @ApiParam(name = "获取该版块所有版主", value = "版块id", required = true)
            @PathVariable Integer categoryId) {
        List<Integer> moderatorIds = categoryService.getModerators(categoryId);
        List<UserInfoOutDto> moderators = new ArrayList<>();
        for (Integer moderatorId: moderatorIds
             ) {
            moderators.add(userService.getByIndex(moderatorId));
        }
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE, "success", moderators);
    }

    @GetMapping("/manage")
    @ResponseBody
    @UserLoginRequired
    @ApiOperation(value = "获取该用户管理的所有板块", notes = "可能不止一个,不传默认当前用户,需要登陆", httpMethod = "GET")
    public StandardResponse<List<Category>> getManagedCategoriesByUserId(
            @ApiParam(name = "用户id")
            @RequestParam String userId) {
        Integer id;
        if (userId.equals("current")) {
            id = AuthenticationInterceptor.getCurrentUserId();
        }
        else {
            id = Integer.valueOf(userId);
        }
        List<Integer> categoryIds = categoryService.getManagedCategories(id);
        List<Category> categories = new ArrayList<>();
        for (Integer categoryId: categoryIds
             ) {
            categories.add(categoryService.getByIndex(categoryId));
        }
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE, "success", categories);
    }

    @DeleteMapping("/{categoryId}/moderator/{moderatorId}")
    @ResponseBody
    @AdminRequired
    @ApiOperation(value = "撤销版主身份", notes = "需要管理员权限", httpMethod = "DELETE")
    public StandardResponse<Object> dismissModerator(
            @ApiParam(name = "版块id", required = true)
            @PathVariable Integer categoryId,
            @ApiParam(name = "版主id", required = true)
            @PathVariable Integer moderatorId) {
        ModeratorPrimaryKeyDto mpkDto = new ModeratorPrimaryKeyDto();
        mpkDto.setCategoryId(categoryId);
        mpkDto.setModeratorId(moderatorId);
        this.categoryService.removeModerator(mpkDto);
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE, "success", null);
    }

}
