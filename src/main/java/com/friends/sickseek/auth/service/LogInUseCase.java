package com.friends.sickseek.auth.service;

import com.friends.sickseek.auth.presentation.dto.request.LogInRequest;
import com.friends.sickseek.auth.presentation.dto.response.TokenResponse;
import com.friends.sickseek.shared.annotation.UseCase;
import com.friends.sickseek.user.domain.User;
import com.friends.sickseek.user.exception.PasswordMismatchException;
import com.friends.sickseek.user.service.UserFacade;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class LogInUseCase {

    private final TokenService tokenService;
    private final UserFacade userFacade;

    public TokenResponse execute(LogInRequest request) {
        User user = userFacade.getUser(request.getEmail());
        if (!user.getPassword().match(request.getPassword())) {
            throw new PasswordMismatchException();
        }

        return TokenResponse.builder()
                .accessToken(tokenService.generateAccessToken(user.getEmail()))
                .build();
    }
}
