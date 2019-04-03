package com.vivacom.library.security;

import com.vivacom.library.constants.ConstantValues;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

import static java.util.Collections.emptyList;

public class TokenAuthenticationService {


    static void addAuthentication(HttpServletResponse res, String username) throws IOException {
        String JWT = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + ConstantValues.EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, ConstantValues.SECRET)
                .compact();
        res.getWriter().write("{\n\""+ConstantValues.HEADER_STRING+"\":\""+ConstantValues.TOKEN_PREFIX + " " + JWT+"\"\n}");
        //res.addHeader(ConstantValues.HEADER_STRING, ConstantValues.TOKEN_PREFIX + " " + JWT);
    }

    static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(ConstantValues.HEADER_STRING);
        String user = null;
        if (token != null) {
            user = Jwts.parser()
                    .setSigningKey(ConstantValues.SECRET)
                    .parseClaimsJws(token.replace(ConstantValues.TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();

            return user != null ?
                    new UsernamePasswordAuthenticationToken(user, null, emptyList()) :
                    null;
        }
        return null;
    }
}