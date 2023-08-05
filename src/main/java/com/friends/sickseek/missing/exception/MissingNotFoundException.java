package com.friends.sickseek.missing.exception;

import com.friends.sickseek.missing.exception.error.MissingErrorProperty;
import com.friends.sickseek.shared.error.SickseekException;

public class MissingNotFoundException extends SickseekException {

    public MissingNotFoundException() {
        super(MissingErrorProperty.MISSING_NOT_FOUND);
    }
}
