package com.friends.sickseek.missing.exception.error;

import com.friends.sickseek.shared.error.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum MissingErrorProperty implements ErrorProperty {
    MISSING_NOT_FOUND(HttpStatus.NOT_FOUND, "실종자가 없습니다."),
    ;

    private final HttpStatus status;
    private final String message;
}
