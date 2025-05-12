package com.gmail.clarkin200.MutaphekApp.service.security;

import com.gmail.clarkin200.MutaphekApp.entity.user.UserPrincipal;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component("jwtCore")
public class JwtCore {
    @Value("${mutaphek.app.secret}")
    private String secret;

    @Value("${mutaphek.app.expirationMs}")
    private String lifetime;

    public String generateToken(Authentication authentication) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        return Jwts.builder().setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((System.currentTimeMillis() + Long.parseLong(lifetime))))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String getEmailFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

}
