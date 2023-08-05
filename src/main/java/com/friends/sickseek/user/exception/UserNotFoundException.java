package com.friends.sickseek.user.exception;

import com.friends.sickseek.user.exception.error.UserErrorProperty;
import com.friends.sickseek.shared.error.SickseekException;

public class UserNotFoundException extends SickseekException {

    public UserNotFoundException() {
        super(UserErrorProperty.USER_NOT_FOUND);
    }
}
