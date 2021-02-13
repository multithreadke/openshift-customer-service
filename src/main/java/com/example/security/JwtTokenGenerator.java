package com.example.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Generate token
 */
public class JwtTokenGenerator {

    public static void main(String[] args) {

        System.out.println("user:" + generateToken("johndoe", "user"));
        System.out.println("admin:" + generateToken("janedoe", "admin"));
    }

    public static String generateToken(String username, String authority) {
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("authorities", authority);
        String token = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, "demo".getBytes())
                .compact();
        return "Authorization: Bearer " + token;
    }

}
