package com.minazuki.bbsbackend.user.interceptor;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.minazuki.bbsbackend.user.annotation.AdminRequired;
import com.minazuki.bbsbackend.user.annotation.PassToken;
import com.minazuki.bbsbackend.user.annotation.UserLoginRequired;
import com.minazuki.bbsbackend.user.dataobject.UserJwtInfoDto;
import com.minazuki.bbsbackend.user.exception.PermissionDeniedException;
import com.minazuki.bbsbackend.user.exception.UnauthenticatedException;
import com.minazuki.bbsbackend.user.pojo.User;
import com.minazuki.bbsbackend.user.util.JwtUtil;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
    /**
     * @Description: 用户登录状态认证拦截器
     * @author hlodice
     * @date 2020/6/24 14:54
     */

    private static final ThreadLocal<Integer> tl = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        //如果不是映射到方法，直接跳过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //检查是否有passToken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        //检查有无需要用户权限的注解
        if (method.isAnnotationPresent(UserLoginRequired.class)) {
            UserLoginRequired userLoginRequired = method.getAnnotation(UserLoginRequired.class);
            if (userLoginRequired.required()) {
                return authenticate(token, true, false);
            }
        }
        if (method.isAnnotationPresent(AdminRequired.class)) {
            AdminRequired adminRequired = method.getAnnotation(AdminRequired.class);
            if (adminRequired.required()) {
                return authenticate(token, true, true);
            }
        }
        return authenticate(token, false, false);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        tl.remove();
    }

    private boolean authenticate(String token,  Boolean needLogin, Boolean needAdmin) throws UnauthenticatedException, PermissionDeniedException {
        UserJwtInfoDto userJwtInfoDto;
        // 倘若不需要登陆但token不为null，保存当前登录用户id
        if (!needLogin && token != null){
            try{
                userJwtInfoDto = JwtUtil.verify(token);
                tl.set(userJwtInfoDto.getUserId());
            } catch (JWTDecodeException e) {
                e.printStackTrace();
            }
            return true;
        }
        //倘若需要登陆且token是null，抛出异常
        if (needLogin && token == null) {
            throw new UnauthenticatedException("missing the token");
        }
        if (token == null) return true;
        //需要登陆时，进行相应认证
        try {
            userJwtInfoDto = JwtUtil.verify(token);
            tl.set(userJwtInfoDto.getUserId());
        } catch (TokenExpiredException e) {
            throw new UnauthenticatedException("The token expired", e);
        } catch (JWTVerificationException e) {
            throw new UnauthenticatedException("Token verify failed", e);
        }
        if(needAdmin) {
            //检测是否是管理员
            if(userJwtInfoDto.getIsAdmin()) return true;
            throw new PermissionDeniedException();
        }
        return true;
    }

    public static Integer getCurrentUserId() {
        /**
         * @Description: 获取当前登陆的用户id
         * @param []
         * @return java.lang.Integer
         * @author hlodice
         * @date 2020/6/24 14:54
         */
        return tl.get();
    }
}
