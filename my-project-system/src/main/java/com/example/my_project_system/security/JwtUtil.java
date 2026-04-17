package com.example.my_project_system.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {
    private static final String SECRET="jwt-secret-key";
    public static String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis()+3600_000))
                .signWith(SignatureAlgorithm.HS256,SECRET)
                .compact();
    }
}
