package com.annie.webapp.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

public class JWTTokenProvider {
    private static final String JWT_SECRET = "PhanAiNgoc";
    private static final long JWT_EXPIRATION = 86400000L;

    public static String generateToken(Long userId, String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);

        return JWT.create().withSubject(Long.toString(userId)).withClaim("username", username).withIssuedAt(expiryDate).sign(Algorithm.HMAC256(JWT_SECRET));
    }
}
