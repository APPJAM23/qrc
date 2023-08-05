package com.friends.sickseek.auth.service;

import com.friends.sickseek.auth.exception.ExpiredTokenException;
import com.friends.sickseek.auth.exception.InvalidTokenException;
import com.friends.sickseek.shared.config.properties.JwtProperties;
import com.friends.sickseek.user.domain.User;
import com.friends.sickseek.user.service.UserFacade;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class TokenService {

    private final JwtProperties jwtProperties;
    private final UserFacade userFacade;

    public String generateAccessToken(String email) {
        return generateToken(email, jwtProperties.getAccessExpirationTime());
    }

    private String generateToken(String email, Long time) {
        Claims claims = Jwts.claims();
        claims.put("email", email);
        Date now = new Date();

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + time))
                .signWith(getSigningKey(jwtProperties.getSecretKey()), SignatureAlgorithm.HS256)
                .compact();
    }

    public User getUser(String token) {
        return userFacade.getUser(getEmail(token));
    }

    private String getEmail(String token) {
        return extractAllClaims(token).get("email", String.class);
    }

    private Claims extractAllClaims(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(getSigningKey(jwtProperties.getSecretKey()))
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw new ExpiredTokenException();
        } catch (Exception e) {
            throw new InvalidTokenException();
        }
    }

    private Key getSigningKey(String secretKey) {
        byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
