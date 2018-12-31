package org.moy.spring.test.example.shiro;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * <p>Description: [自定义 Jwt 加密 解密 校验工具 ]
 * </p>
 * Created on 2018/12/26
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public class JwtUtil {

    private static Logger LOG = LoggerFactory.getLogger(JwtUtil.class);

    /**
     * 校验token是否正确,不正确返回true
     *
     * @param token
     * @param username
     * @return
     */
    public static boolean verifyIsNotOk(String token, String username, String userCode) {
        return !verifyIsOk(token, username, userCode);
    }

    /**
     * 校验token是否正确,正确返回true
     *
     * @param token    密钥
     * @param username 用户名
     * @return 是否正确
     */
    public static boolean verifyIsOk(String token, String username, String userCode) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(JwtConst.JWT_SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim(JwtConst.JWT_CLAIM_USERNAME, username)
                    .withClaim(JwtConst.JWT_CLAIM_USER_CODE, userCode)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception exception) {
            LOG.error("verifyException : {}", exception.getMessage());
            return false;
        }
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(JwtConst.JWT_CLAIM_USERNAME).asString();
        } catch (JWTDecodeException e) {
            LOG.error("JWTDecodeException : {}", e.getMessage());
            return null;
        }
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @return token中包含的用户编码
     */
    public static String getUserCode(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(JwtConst.JWT_CLAIM_USER_CODE).asString();
        } catch (JWTDecodeException e) {
            LOG.error("JWTDecodeException : {}", e.getMessage());
            return null;
        }
    }

    /**
     * 生成签名
     *
     * @param username 用户名
     * @return 加密的token
     */
    public static String sign(String username, String userCode) {
        Date date = new Date(System.currentTimeMillis() + JwtConst.JWT_EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(JwtConst.JWT_SECRET);
        // 附带username信息
        return JWT.create()
                .withClaim(JwtConst.JWT_CLAIM_USERNAME, username)
                .withClaim(JwtConst.JWT_CLAIM_USER_CODE, userCode)
                .withExpiresAt(date)
                .sign(algorithm);
    }
}
