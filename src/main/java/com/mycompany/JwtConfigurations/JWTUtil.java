package com.mycompany.JwtConfigurations;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTUtil {

    private Key key;

    private String secretKey;

    @Value("${jwt.token.expiration_time}")
    private Long tokenExpirationTime;

    @Value("${company.name}")
    private String companyName;

    public JWTUtil() {

    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<String, Object>();
        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String username) {
        this.key = Keys.secretKeyFor(SignatureAlgorithm.HS384);
        this.secretKey = Encoders.BASE64.encode(key.getEncoded());
        return Jwts.builder()
                // Setting Custom Claims
                .setClaims(claims)
                // Setting Standard Claims
                .setSubject(username).setIssuer(companyName).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpirationTime))
                // Setting Up Algorithm to be used
                .signWith(key, SignatureAlgorithm.HS384).compact();
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }
}
