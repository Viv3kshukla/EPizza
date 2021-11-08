package com.directkart.epizza.exception;

import lombok.Getter;

@Getter
public abstract class DirectKartRuntimeException extends RuntimeException{
    int httpResponseCode;
    String status;
    String errorCode;
    String errorMessage;

    public DirectKartRuntimeException (int httpResponseCode, String status, String errorCode, String errorMessage) {
        super(errorMessage);
        this.httpResponseCode = httpResponseCode;
        this.status = status;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}