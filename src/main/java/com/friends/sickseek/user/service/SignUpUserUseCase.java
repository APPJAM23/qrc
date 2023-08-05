package com.friends.sickseek.user.service;

import com.friends.sickseek.shared.annotation.UseCase;
import com.friends.sickseek.user.domain.User;
import com.friends.sickseek.user.exception.UserAlreadyExistsException;
import com.friends.sickseek.user.presentation.dto.request.SignUpUserRequest;
import com.friends.sickseek.user.repository.UserRepository;
import com.friends.sickseek.user.domain.type.Authority;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
public class SignUpUserUseCase {

    private final UserRepository userRepository;

    @Transactional
    public void execute(SignUpUserRequest request) {
        validate(request);

        userRepository.save(
                User.builder()
                        .email(request.getEmail())
                        .password(request.getPassword())
                        .authority(Authority.USER)
                        .build()
        );
    }

    private void validate(SignUpUserRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException();
        }
    }
}
