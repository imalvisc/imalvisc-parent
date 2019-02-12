package com.imalvisc.api.auth.utils;

import com.imalvisc.api.auth.model.state.TokenState;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtils {

    //JWT claim key
    private final static String CLAIM = "ID";

    private final static String JWT_PREFIX = "Bearer ";

    //短token失效毫秒数（1天）
    private final static int ACCESS_TOKEN_EXPIRED = 1000 * 60 * 60 * 24;
    //调试阶段（1分钟）
    //private final static int ACCESS_TOKEN_EXPIRED = 1000 * 60;

    //长token失效毫秒数（7天）
    private final static int REFRESH_TOKEN_EXPIRED = 1000 * 60 * 60 * 24 * 7;

    //JWT签名密钥
    private final static String SECRET_KEY = "SECRET_KEY";

    public static String create(Object claim, TokenState tokenState) {
        return JWT_PREFIX + Jwts.builder()
                .claim(CLAIM, claim)
                .setExpiration(new Date())
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

}
