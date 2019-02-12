package com.imalvisc.api.auth.utils;

import com.imalvisc.api.auth.config.properties.JwtProperties;
import com.imalvisc.api.auth.model.state.TokenType;
import com.imalvisc.common.utils.SpringUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtils {

    private static JwtProperties properties;

    static {
        properties = SpringUtils.getBean(JwtProperties.class);
    }

    public static String create(Object claim, TokenType tokenType) {
        return properties.getPrefix() + Jwts.builder()
                .claim(properties.getClaim(), claim)
                .setExpiration(new Date())
                .signWith(SignatureAlgorithm.HS512, properties.getSecret())
                .compact();
    }

}
