package com.friends.sickseek.auth.presentation;

import com.friends.sickseek.auth.presentation.dto.request.LogInRequest;
import com.friends.sickseek.auth.presentation.dto.response.TokenResponse;
import com.friends.sickseek.auth.service.LogInUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {

    private final LogInUseCase logInUseCase;

    @PostMapping
    public TokenResponse logIn(@RequestBody @Valid LogInRequest request) {
        return logInUseCase.execute(request);
    }
}
