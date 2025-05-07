package com.streaming.project.demo.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.streaming.project.demo.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class JwtService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String GenerateToken(User user){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("streaming")
                    .withSubject(user.getEmail())
                    .withExpiresAt(TempoExpiracao())
                    .sign(algorithm);
                    return token;
        } catch (
                JWTCreationException exception){
                throw new JWTCreationException("Erro ao gerar token", exception);
        }
    }
    public String JWTVerifier(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("streaming")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception){
            throw new JWTVerificationException("Token inválido");
        }
    }


    public Instant TempoExpiracao(){
       return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
