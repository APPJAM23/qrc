package com.friends.sickseek.auth.exception;


import com.friends.sickseek.auth.exception.error.AuthErrorProperty;
import com.friends.sickseek.shared.error.SickseekException;

public class ExpiredTokenException extends SickseekException {

    public ExpiredTokenException() {
        super(AuthErrorProperty.EXPIRED_TOKEN);
    }
}
