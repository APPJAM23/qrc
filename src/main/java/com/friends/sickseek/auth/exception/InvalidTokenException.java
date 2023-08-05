package com.friends.sickseek.auth.exception;

import com.friends.sickseek.auth.exception.error.AuthErrorProperty;
import com.friends.sickseek.shared.error.SickseekException;

public class InvalidTokenException extends SickseekException {

    public InvalidTokenException() {
        super(AuthErrorProperty.INVALID_TOKEN);
    }
}
