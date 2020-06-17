package com.minazuki.bbsbackend.user.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.minazuki.bbsbackend.user.pojo.User;
import com.minazuki.bbsbackend.util.DateUtil;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * jwt工具类
 * @author hlodice
 * @date 2020/6/17 17:00
 */
@Slf4j
public class JwtUtil {
    private static final String SECRET_KEY = "bbs-secret-key";

    public static String sign(User user) {
        /**
         * @Description:生成token
         * @param [user]
         * @return java.lang.String
         * @author hlodice
         * @date 2020/6/17 17:11
         */
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
        Map<String, Object> map = new HashMap<>(16);
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        return JWT.create().withHeader(map)
                .withClaim("userId", user.getId())
                .withClaim("username", user.getUserName())
                .withIssuer("minazuki-bbs")
                .withIssuedAt(DateUtil.localDateTimeToDate(LocalDateTime.now()))
                .withExpiresAt(DateUtil.localDateTimeToDate(LocalDateTime.now().plusHours(2)))
                .sign(algorithm);
    }

    public static Long verify(String token) {
        Long userId = 0L;
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            JWTVerifier jwtVerifier = JWT.require(algorithm)
                    .withIssuer("minazuki-bbs")
                    .build();
            DecodedJWT decodedJWT = jwtVerifier.verify(token);
            userId = decodedJWT.getClaim("userId").asLong();
        } catch (JWTVerificationException e) {
            log.error("解析token失败, exception = ", e.toString());
        }
        return userId;
    }
}
