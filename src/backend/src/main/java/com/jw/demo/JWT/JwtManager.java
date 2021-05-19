package com.jw.demo.JWT;

import com.jw.demo.DTO.RedisUserDto;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component

public class JwtManager {
    @Value("${token_key}") //application.properties에서 token 생성할 key 가져옴
    private String securityKey;
    private final Long expiredTime = 1000 * 60L * 60L * 3L; //유효시간 3시간

    public String generateJwtToken(RedisUserDto user){
        Date curr = new Date();
        return Jwts.builder()
                .setSubject(user.getId())
                .setHeader(createHeader())
                .setClaims(createClaims(user))
                .setExpiration(new Date(curr.getTime() + expiredTime))
                .signWith(SignatureAlgorithm.HS256, securityKey)
                .compact();
    }

    private Map<String, Object> createHeader(){
        Map<String, Object> header = new HashMap<>();
        header.put("type", "JWT");
        header.put("alg", "HS256");
        header.put("regDate", System.currentTimeMillis());
        return header;
    }

    private Map<String, Object> createClaims(RedisUserDto user){
        Map<String, Object> claims = new HashMap<>();
        claims.put("userID", user.getId());
        return claims;
    }

    private Claims getClaims(String token){
        return Jwts.parser().setSigningKey(securityKey).parseClaimsJws(token).getBody();
    }

    public String getUserIdFromToken(String token){
        return (String)getClaims(token).get("userID");
    }
}
