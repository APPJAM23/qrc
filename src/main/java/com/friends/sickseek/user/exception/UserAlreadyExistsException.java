package com.friends.sickseek.user.exception;

import com.friends.sickseek.user.exception.error.UserErrorProperty;
import com.friends.sickseek.shared.error.SickseekException;

public class UserAlreadyExistsException extends SickseekException {

    public UserAlreadyExistsException() {
        super(UserErrorProperty.USER_ALREADY_EXISTS);
    }
}
