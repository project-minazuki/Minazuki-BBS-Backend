package com.minazuki.bbsbackend.global.controller;

import com.minazuki.bbsbackend.http.StandardResponse;
import com.minazuki.bbsbackend.user.exception.PermissionDeniedException;
import com.minazuki.bbsbackend.user.exception.UnauthenticatedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalController {

    @ResponseBody
    @ExceptionHandler({PermissionDeniedException.class})
    public StandardResponse<Object> permissionDeniedException(PermissionDeniedException e) {
        return new StandardResponse<>(StandardResponse.FAILURE_CODE, e.getMessage(), null);
    }

    @ResponseBody
    @ExceptionHandler({UnauthenticatedException.class})
    public StandardResponse<Object> authenticationException(UnauthenticatedException e) {
        return new StandardResponse<>(StandardResponse.FAILURE_CODE, e.getMessage(), null);
    }
}
