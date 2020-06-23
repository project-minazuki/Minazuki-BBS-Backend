package com.minazuki.bbsbackend.user.controlloer;

import com.minazuki.bbsbackend.http.StandardResponse;
import com.minazuki.bbsbackend.user.annotation.UserLoginToken;
import com.minazuki.bbsbackend.user.dao.UserDao;
import com.minazuki.bbsbackend.user.exception.DuplicateRegistrationInfoException;
import com.minazuki.bbsbackend.user.exception.NoUserMatchException;
import com.minazuki.bbsbackend.user.exception.UnauthenticatedException;
import com.minazuki.bbsbackend.user.pojo.User;
import com.minazuki.bbsbackend.user.pojo.User.UserBuilder;
import com.minazuki.bbsbackend.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/{userId}")
    @ResponseBody
    @UserLoginToken
    public StandardResponse<User> getUserById(@PathVariable int userId) {
        User user = userService.index(userId);
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE, "success", user);
    }

    @GetMapping("/search")
    @ResponseBody
    public StandardResponse<List<User>> searchUsers(@RequestParam Map<String, Object> args) {
        List<User> users = userService.search(args);
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE, "success", users);
    }

    @PostMapping("/signUp")
    @ResponseBody
    public StandardResponse<Object> signUp(@RequestParam Map<String, Object> signUpInfo) {
        try {
            userService.signUp(signUpInfo);
        } catch (DuplicateRegistrationInfoException e) {
            return new StandardResponse<>(StandardResponse.FAILURE_CODE, e.getMessage(), e.getData());
        }
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE, "success", null);
    }

    @PostMapping("/signIn")
    @ResponseBody
    public StandardResponse<String> signIn(@RequestParam Map<String, Object> signInInfo) {
        String token = "";
        try {
            token = userService.signIn(signInInfo);
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
