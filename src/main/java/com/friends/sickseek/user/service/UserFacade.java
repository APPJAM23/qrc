package com.friends.sickseek.user.service;

import com.friends.sickseek.user.domain.User;
import com.friends.sickseek.user.exception.UserNotFoundException;
import com.friends.sickseek.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public User getUser(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
    }
}
