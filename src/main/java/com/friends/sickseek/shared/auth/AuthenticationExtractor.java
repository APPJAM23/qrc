package com.friends.sickseek.shared.auth;

import com.friends.sickseek.auth.exception.EmptyTokenException;
import com.friends.sickseek.auth.exception.InvalidTokenException;
import com.friends.sickseek.shared.config.properties.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;

@RequiredArgsConstructor
@Component
public class AuthenticationExtractor {

    private final JwtProperties jwtProperties;

    public String extract(NativeWebRequest request) {
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (authorizationHeader == null || authorizationHeader.isBlank()) {
            throw new EmptyTokenException();
        }

        if (!authorizationHeader.startsWith(jwtProperties.getPrefix())) {
            throw new InvalidTokenException();
        }

        return authorizationHeader.replace(jwtProperties.getPrefix(), "").trim();
    }
}