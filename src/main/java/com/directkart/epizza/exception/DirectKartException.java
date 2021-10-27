package com.directkart.epizza.exception;

import lombok.Getter;

@Getter
public abstract class DirectKartException extends Exception {
    int httpResponseCode;
    String status;
    String errorCode;
    String errorMessage;

    public DirectKartException (int httpResponseCode, String status, String errorCode, String errorMessage) {
        super(errorMessage);
        this.httpResponseCode = httpResponseCode;
        this.status = status;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
