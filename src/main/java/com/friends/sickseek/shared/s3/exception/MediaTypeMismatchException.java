package com.friends.sickseek.shared.s3.exception;

import com.friends.sickseek.shared.error.SickseekException;
import com.friends.sickseek.shared.s3.exception.error.S3ErrorProperty;

public class MediaTypeMismatchException extends SickseekException {

    public MediaTypeMismatchException() {
        super(S3ErrorProperty.MEDIA_TYPE_MISMATCH);
    }
}
