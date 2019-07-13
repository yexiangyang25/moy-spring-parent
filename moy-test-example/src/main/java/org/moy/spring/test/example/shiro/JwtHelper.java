package org.moy.spring.test.example.shiro;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * <p>Description: [自定义 Jwt 加密 解密 校验工具 ]
 * </p>
 * Created on 2018/12/26
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public class JwtHelper {

    private static final Logger LOG = LoggerFactory.getLogger(JwtHelper.class);

    /**
     * 过期时间,毫秒单位
     */
    public static final long JWT_EXPIRE_TIME = 12 * 60 * 60 * 1000;

    /**
     * 认证加密的SECRET
     */
    private static final String JWT_SECRET = "JWT_SECRET";

    /**
     * 默认 认证加密携带 信息
     */
    private static final String JWT_CLAIM_UNIQUE_CREDENTIAL = "jwt_default_unique_credential";

    /**
     * 校验token是否正确,不正确返回true
     *
     * @param token
     * @return 签名是否正确
     */
    public static boolean verifyIsNotOk(String token) {
        return !verifyIsOk(token);
    }


    /**
     * 校验token是否正确,正确返回true
     *
     * @param token 签名
     * @return 签名是否正确
     */
    public static boolean verifyIsOk(String token) {
        try {
            String uniqueCredential = getClaimInfoByKey(token, JWT_CLAIM_UNIQUE_CREDENTIAL);
            if (null != uniqueCredential) {
                Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);
                JWTVerifier verifier = JWT.require(algorithm)
                        .withClaim(JWT_CLAIM_UNIQUE_CREDENTIAL, uniqueCredential)
                        .build();
                verifier.verify(token);
                return true;
            }
        } catch (Exception exception) {
            LOG.error("verifyException : {}", exception.getMessage());
        }
        return false;
    }

    public static String getUniqueCredentialInfo(String token) {
        return getClaimInfoByKey(token, JWT_CLAIM_UNIQUE_CREDENTIAL);
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @param token 签名
     * @param key   key
     * @return token中包含的ClaimI
     */
    public static String getClaimInfoByKey(String token, String key) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(key).asString();
        } catch (JWTDecodeException e) {
            LOG.error("JWTDecodeException : {}", e.getMessage());
            return null;
        }
    }


    /**
     * 生成签名
     *
     * @param uniqueCredential 唯一值
     * @param expireTime       有效时间
     * @param extraInfoMap     附件信息
     * @return
     */
    public static String createToken(String uniqueCredential, long expireTime, Map<String, String> extraInfoMap) {

        JWTCreator.Builder builder = JWT.create().withClaim(JWT_CLAIM_UNIQUE_CREDENTIAL, uniqueCredential);

        putExtraInfo(builder, extraInfoMap);

        builder.withExpiresAt(new Date(System.currentTimeMillis() + expireTime));

        return builder.sign(Algorithm.HMAC256(JWT_SECRET));
    }

    private static void putExtraInfo(JWTCreator.Builder builder, Map<String, String> extraInfoMap) {
        if (null != extraInfoMap && !extraInfoMap.isEmpty()) {
            Set<Map.Entry<String, String>> entrySet = extraInfoMap.entrySet();

            for (Map.Entry<String, String> each : entrySet) {
                if (StringUtils.equals(each.getKey(), JWT_CLAIM_UNIQUE_CREDENTIAL)) {
                    throw new IllegalArgumentException("jwt  extraInfoMap has  invalid key :  " + JWT_CLAIM_UNIQUE_CREDENTIAL);
                } else {
                    builder.withClaim(each.getKey(), each.getValue());
                }
            }
        }
    }
}
