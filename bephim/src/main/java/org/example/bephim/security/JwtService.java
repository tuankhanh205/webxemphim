package org.example.bephim.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {
    @Value("${secret.key}")
    private String secretKey;
    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64URL.decode(secretKey);
        System.out.println("Độ dài khóa: " + keyBytes.length * 8 + " bit");
        return Keys.hmacShaKeyFor(keyBytes);

    }
    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 10; // 10 tiếng
    public String generateAccessToken(String userName, String role) {
        return Jwts.builder().setSubject(userName).setIssuedAt(new Date())
                .claim("role",role)
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();

    }
    public String generateRefreshToken(String userName) {
        return Jwts.builder()
                .setSubject(userName)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7)) // 7 ngày
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    public String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(getSignKey())
                .build().parseClaimsJws(token)
                .getBody().getSubject();

    }
    public boolean isTokenValid(String token, UserDetails userDetails) {
      String userNameExtra=  extractUsername(token);
      return userNameExtra.equals(userDetails.getUsername());
    }


}
