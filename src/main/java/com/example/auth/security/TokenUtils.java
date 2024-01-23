package com.example.auth.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.security.Key;
import java.util.*;

public class TokenUtils {
    private final static String ACCESS_TOKEN_SECRET = "MY_CODE_SECRET";
    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000L;


    public static String createToken(String name, String email) {
        Long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1_000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        Map<String, Object> xtra = new HashMap<>();
        xtra.put("name", name);

        // produce el token
        return Jwts.builder()
                .setSubject(email)
                .setExpiration(expirationDate)
                .addClaims(xtra)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                .compact();
    }

    // inverse proccess to create a token
    public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(ACCESS_TOKEN_SECRET.
                            getBytes()).
                    build().parseClaimsJws(token)
                    .getBody();

            String email = claims.getSubject();
            // si se envia un token no valido
            return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
        } catch ( JwtException e) {
            return null;
        }

    }

}
