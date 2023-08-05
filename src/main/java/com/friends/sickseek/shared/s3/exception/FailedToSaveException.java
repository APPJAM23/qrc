package com.friends.sickseek.shared.s3.exception;

import com.friends.sickseek.shared.error.SickseekException;
import com.friends.sickseek.shared.s3.exception.error.S3ErrorProperty;

public class FailedToSaveException extends SickseekException {

    public FailedToSaveException() {
        super(S3ErrorProperty.FAILED_TO_SAVE);
    }
}
