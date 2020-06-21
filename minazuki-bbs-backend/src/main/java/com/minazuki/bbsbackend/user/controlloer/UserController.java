package com.minazuki.bbsbackend.user.controlloer;

import com.minazuki.bbsbackend.http.StandardResponse;
import com.minazuki.bbsbackend.user.dao.UserDao;
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
    public StandardResponse<Object> signUp(@RequestParam Map<String, Object> args) {
        try {
            userService.signUp(args);
        } catch (Exception e) {
            return new StandardResponse<>(StandardResponse.FAILURE_CODE, e.getMessage(), null);
        }
        return new StandardResponse<>(StandardResponse.SUCCESS_CODE, "success", args.get("username"));
    }

    @PostMapping("/signIn")
    public void signIn(HttpServletRequest request) {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
    }
}
