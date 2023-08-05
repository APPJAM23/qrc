package com.friends.sickseek.shared.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class SickseekException extends RuntimeException {

    private final ErrorProperty errorProperty;
}
