package com.friends.sickseek.shared.s3.exception;

import com.friends.sickseek.shared.error.SickseekException;
import com.friends.sickseek.shared.s3.exception.error.S3ErrorProperty;

public class FileSizeLimitExceededException extends SickseekException {

    public FileSizeLimitExceededException() {
        super(S3ErrorProperty.FILE_SIZE_LIMIT_EXCEEDED);
    }
}
