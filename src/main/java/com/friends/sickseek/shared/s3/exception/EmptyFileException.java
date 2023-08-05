package com.friends.sickseek.shared.s3.exception;

import com.friends.sickseek.shared.error.SickseekException;
import com.friends.sickseek.shared.s3.exception.error.S3ErrorProperty;

public class EmptyFileException extends SickseekException {

    public EmptyFileException() {
        super(S3ErrorProperty.EMPTY_FILE);
    }
}
