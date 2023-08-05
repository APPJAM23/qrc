package com.friends.sickseek.auth.exception;

import com.friends.sickseek.auth.exception.error.AuthErrorProperty;
import com.friends.sickseek.shared.error.SickseekException;

public class EmptyTokenException extends SickseekException {

    public EmptyTokenException() {
        super(AuthErrorProperty.EMPTY_TOKEN);
    }
}
