package com.friends.sickseek.shared.s3.exception;

import com.friends.sickseek.shared.error.SickseekException;
import com.friends.sickseek.shared.s3.exception.error.S3ErrorProperty;

public class ImageSizeMismatchException extends SickseekException {

    public ImageSizeMismatchException() {
        super(S3ErrorProperty.IMAGE_SIZE_MISMATCH);
    }
}
