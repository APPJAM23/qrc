package com.friends.sickseek.auth.exception;

import com.friends.sickseek.auth.exception.error.AuthErrorProperty;
import com.friends.sickseek.shared.error.SickseekException;

public class AuthorityMismatchException extends SickseekException {

    public AuthorityMismatchException() {
        super(AuthErrorProperty.AUTHORITY_MISMATCH);
    }
}
