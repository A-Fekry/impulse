package com.spring.system.task_managment_system.config;


import com.spring.system.task_managment_system.dto.PersonDto;
import com.spring.system.task_managment_system.service.auth.ClientService;
import com.spring.system.task_managment_system.sitting.TokenConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

@Component
public class JwtTokenHandler {

    private JwtBuilder jwtBuilder;

    public JwtParser getJwtParser() {
        return jwtParser;
    }

    private static JwtParser jwtParser;

    private String secret;

    private Duration expiration;

    @Autowired
    private ClientService clientService;

    @Autowired
    public JwtTokenHandler(TokenConfig tokenConfig) {
        this.secret = tokenConfig.getSecret();
        this.expiration = tokenConfig.getExpiration();
        Key key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        jwtBuilder = Jwts.builder().signWith(key);
        jwtParser = Jwts.parserBuilder().setSigningKey(key).build();

    }

    public String createToken(PersonDto person) {
        Date issuesDate = new Date(); // current date
        Instant instant = issuesDate.toInstant().plus(expiration);
        Date dateOfExpired = Date.from(instant); // calculate the expired date starting from issueDate

        return jwtBuilder.setSubject(person.getEmail())
                .setIssuedAt(issuesDate)
                .setExpiration(dateOfExpired)
                .claim("roles", clientService.getRoles(person.getEmail())).compact();
    }

    public boolean validateToken(String token) {

        //  check if the token is created by the system or  not
        if (jwtParser.isSigned(token)) {

            // check if the token is valid
            Claims claims = jwtParser.parseClaimsJws(token).getBody();
            Date issue = claims.getIssuedAt();
            Date expired = claims.getExpiration();


            return expired.after(new Date()) && issue.before(expired);
        }

        return false;
    }

    public static String getUsername(String token) {
        String newToken = token.substring(7);
        Claims claims = jwtParser.parseClaimsJws(newToken).getBody();
        return claims.getSubject();
    }
}
