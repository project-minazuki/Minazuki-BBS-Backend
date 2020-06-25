package com.minazuki.bbsbackend.user.controlloer;

import com.minazuki.bbsbackend.http.StandardResponse;
import com.minazuki.bbsbackend.user.annotation.UserLoginRequired;
import com.minazuki.bbsbackend.user.dataobject.UserInfoOutDto;
import com.minazuki.bbsbackend.user.dataobject.UserRegistrationDto;
import com.minazuki.bbsbackend.user.dataobject.UserSignInDto;
import com.minazuki.bbsbackend.user.dataobject.UserUpdateDto;
import com.minazuki.bbsbackend.user.exception.DuplicateUserInfoException;
import com.minazuki.bbsbackend.user.exception.NoUserMatchException;
import com.minazuki.bbsbackend.user.exception.UnauthenticatedException;
import com.minazuki.bbsbackend.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "用户相关接口")
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/{userId}")
    @ResponseBody
    @UserLoginRequired
    @ApiOperation(value = "查看用户详情", notes = "查看用户详情", httpMethod = "GET")
    public StandardResponse<UserInfoOutDto> getUserById(@ApiParam(name = "用户id", value = "用户id", required = true)@PathVariable Integer userId) {
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE, "success", userService.getByIndex(userId));
    }

    @GetMapping("/search")
    @ResponseBody
    public StandardResponse<List<UserInfoOutDto>> searchUsers(@RequestParam String keyword) {
        List<UserInfoOutDto> userInfoOutDtoList = userService.search(keyword);
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE, "success", userInfoOutDtoList);
    }

    @PostMapping("/update")
    @ResponseBody
    @ApiOperation(value = "修改用户资料", notes = "只传入需要修改的部分，其他如果未修改不传即可", httpMethod = "POST")
    public StandardResponse<Object> updateUser(@RequestBody UserUpdateDto userUpdateDto) {
        try {
            userService.updateUser(userUpdateDto);
        } catch (DuplicateUserInfoException e) {
            return new StandardResponse<>(StandardResponse.FAILURE_CODE, "duplicated info", e.getData());
        }
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE, "success", null);
    }

    @PostMapping("/signUp")
    @ResponseBody
    @ApiOperation(value = "用户注册", notes = "注册信息不允许重复并且5个值缺一不可", httpMethod = "POST")
    public StandardResponse<Object> signUp(@ApiParam(name = "注册信息", value = "昵称、用户名、密码、邮件、电话号码", required = true) @RequestBody UserRegistrationDto userRegistrationDto) {
        try {
            userService.signUp(userRegistrationDto);
        } catch (DuplicateUserInfoException e) {
            return new StandardResponse<>(StandardResponse.FAILURE_CODE, e.getMessage(), e.getData());
        }
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE, "success", null);
    }

    @PostMapping("/signIn")
    @ResponseBody
    @ApiOperation(value = "用户登录", notes = "登陆成功返回token", httpMethod = "POST")
    public StandardResponse<String> signIn(@ApiParam(name = "登录信息", value = "用户名/电话号码/邮件 、 密码") @RequestBody UserSignInDto userSignInDto) {
        String token;
        try {
            token = userService.signIn(userSignInDto);
        } catch (NoUserMatchException e) {
            return new StandardResponse<>(StandardResponse.FAILURE_CODE, "failure", null);
        }
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE, "success", token);
    }

    @ResponseBody
    @ExceptionHandler({UnauthenticatedException.class})
    public StandardResponse<Object> authenticationException(UnauthenticatedException e) {
        return new StandardResponse<>(StandardResponse.FAILURE_CODE, e.getMessage(), null);
    }
}
