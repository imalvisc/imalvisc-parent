package com.imalvisc.api.auth.utils;

import com.imalvisc.api.auth.config.properties.JwtProperties;
import com.imalvisc.api.auth.model.state.AuthTokenType;
import com.imalvisc.common.utils.DateTimeUtils;
import com.imalvisc.common.utils.SpringUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtils {

    private static JwtProperties properties;

    static {
        properties = SpringUtils.getBean(JwtProperties.class);
    }

    public static String create(Object claim, AuthTokenType type) {
        Date expired = AuthTokenType.ACCESS_TOKEN.getValue().equals(type.getValue())
                ? DateTimeUtils.dateWithMillsPlus(properties.getAccessTokenExpired())
                : DateTimeUtils.dateWithMillsPlus(properties.getRefreshTokenExpired());
        return properties.getPrefix() + Jwts.builder()
                .claim(properties.getClaim(), claim)
                .setExpiration(expired)
                .signWith(SignatureAlgorithm.HS512, properties.getSecret())
                .compact();
    }

}
