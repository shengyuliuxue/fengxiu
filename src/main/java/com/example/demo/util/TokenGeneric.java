package com.example.demo.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenGeneric {
    private static final String TOKEN_SECRET = "privatekey";
    public static String CreateToken(String openid){
        try{
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            Map<String, Object> header = new HashMap<String, Object>();
            header.put("typ","JWT");
            header.put("alg", "HS256");
            String token = JWT.create()
                    .withHeader(header)
                    .withIssuer("auth0")
                    .withIssuedAt(new Date())
                    .withExpiresAt(DateUtils.addHours(new Date(), 2))
                    .withClaim("openid",openid)
                    .sign(algorithm);
            System.out.println(token);
            return token;
        }catch (JWTCreationException exception){
            throw new RuntimeException(exception);
        }
    }
}
