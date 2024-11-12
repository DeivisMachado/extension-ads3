package com.backend.mapeamento.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    private static final String SECRET_KEY = "6fwfONERrNCXc17zmhWZJbg7avwzq4JY5xaDuFfI3wg=";
    
    public String extrairEmail(String token) {
        return extrairClaim(token, Claims::getSubject);
    }
    
    public String gerarToken(String email) {
        return gerarToken(new HashMap<>(), email);
    }
    
    public String gerarToken(Map<String, Object> extraClaims, String email) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    
    private Key getSignInKey() {
        byte[] keyBytes = java.util.Base64.getDecoder().decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    
    private Claims extrairTodasClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    
    public <T> T extrairClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extrairTodasClaims(token);
        return claimsResolver.apply(claims);
    }
    
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extrairEmail(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpirado(token);
    }
    
    private boolean isTokenExpirado(String token) {
        return extrairExpiracao(token).before(new Date());
    }
    
    private Date extrairExpiracao(String token) {
        return extrairClaim(token, Claims::getExpiration);
    }
}
