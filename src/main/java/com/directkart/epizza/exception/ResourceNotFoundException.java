package com.directkart.epizza.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends DirectKartRuntimeException{

    public ResourceNotFoundException(int httpResponseCode, String status, String errorCode, String errorMessage) {
        super(httpResponseCode, status, errorCode, errorMessage);
    }

    public ResourceNotFoundException() {
        super(400, "resource_not_found", "resource_not_found", "Not able to found resource. Please check if passing valid request");
    }

}
