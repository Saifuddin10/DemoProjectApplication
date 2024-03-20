//package com.java.saif.DemoProject.service;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.io.Decoder;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.DefaultMessageCodesResolver;
//
//import java.security.Key;
//import java.security.KeyStore;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
//public class JwtService {
//
//    public String generateToken(String userName) {
//        Map<String, Object> claims = new HashMap<>();
//        return createToken(claims, userName);
//    }
//
//    private String createToken(Map<String, Object> claims, String userName) {
//        return Jwts.builder()
//                .setClaims(claims)
//                .setSubject(userName)
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
//                .signWith(getSignKey())
//    }
//
//    private Key getSignKey() {
//        byte[] KeyBytes = Decoders.BASE64.decode(Secret);
//        return Keys.hmacShaKeyFor(KeyBytes);
//    }
//
//    public static final String Secret = "1b0f0145c4e7f216f337a0ce8d1cc08aa4ed4d24e1d27acddac0a699731fa30e";
//}
//
