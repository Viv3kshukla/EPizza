package com.directkart.epizza.exception;

public class InvalidRequestException extends DirectKartRuntimeException {
    public InvalidRequestException(int httpResponseCode, String status, String errorCode, String errorMessage) {
        super (httpResponseCode, status, errorCode, errorMessage);
    }

    public InvalidRequestException () {
        super(400, "invalid_request", "invalid_request", "Please pass valid arguments");
    }

}
