//package com.app.product.service;
//
//import com.app.product.config.ServerConfig;
//import io.jsonwebtoken.*;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import io.jsonwebtoken.security.SignatureException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.security.Key;
//import java.util.Date;
//
//@Component
//public class JwtServiceImpl implements JwtService {
//
//    @Autowired
//    ServerConfig serverConfig;
//
//    @Value("${app.jwttoken.expirationTime}")
//    private long ACCESS_TOKEN_VALIDITY_SECONDS;
//
//    public String extractUsername(String token) throws Exception {
//        return extractClaim(token).getSubject();
//    }
//
//    private Key getSignKey() {
//        byte[] keyBytes= Decoders.BASE64.decode(serverConfig.getJwtSecret());
//        return Keys.hmacShaKeyFor(keyBytes);
//    }
//
//    private Boolean isTokenExpired(String token) throws Exception {
//        return extractExpiration(token).before(new Date());
//    }
//
//    public Date extractExpiration(String token) throws Exception {
//        return extractClaim(token).getExpiration();
//    }
//
//    public Claims extractClaim(String token) throws Exception{
//        return Jwts
//                .parser()
//                .setSigningKey(getSignKey())
//                .build()
//                .parseClaimsJws(token)
//                .getBody();
//    }
//
//    public Boolean validateToken(String token) throws Exception {
//        try {
//            extractClaim(token);
//            return !isTokenExpired(token);
//        } catch (SignatureException | MalformedJwtException | ExpiredJwtException | UnsupportedJwtException | IllegalArgumentException ex) {
//            return false;
//        }
//    }
//}
