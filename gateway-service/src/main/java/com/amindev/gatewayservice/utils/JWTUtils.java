package com.amindev.gatewayservice.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.security.Key;

@Component
public class JWTUtils implements Serializable {

    public static final String SECRET= "8a2f8c8e27bbf37b6b031b11f53ddbc9b1f0901dd2d7e7c2ebe576a2c57e9f08";

    public void validateToken(final String token) {
        Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
