package com.minazuki.bbsbackend.user.interceptor;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.minazuki.bbsbackend.user.annotation.PassToken;
import com.minazuki.bbsbackend.user.annotation.UserLoginRequired;
import com.minazuki.bbsbackend.user.exception.UnauthenticatedException;
import com.minazuki.bbsbackend.user.util.JwtUtil;
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
                //执行认证
                if (token == null) {
                    throw new UnauthenticatedException("missing the token");
                }
                //获取 token 中的 userId信息
                try {
                    Integer id = JwtUtil.verify(token);
                    tl.set(id);
                } catch (TokenExpiredException e) {
                    throw new UnauthenticatedException("The token expired", e);
                }
                catch (JWTVerificationException e) {
                    throw new UnauthenticatedException("Token verify failed", e);
                }
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        tl.remove();
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
