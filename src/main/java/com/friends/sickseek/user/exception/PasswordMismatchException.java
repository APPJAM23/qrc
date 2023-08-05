package com.friends.sickseek.user.exception;

import com.friends.sickseek.user.exception.error.UserErrorProperty;
import com.friends.sickseek.shared.error.SickseekException;

public class PasswordMismatchException extends SickseekException {

    public PasswordMismatchException() {
        super(UserErrorProperty.PASSWORD_MISMATCH);
    }
}
