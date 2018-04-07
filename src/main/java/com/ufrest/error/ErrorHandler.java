package com.ufrest.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@SuppressWarnings("unused")
public class ErrorHandler extends ResponseEntityExceptionHandler  {

    @ExceptionHandler(UFRestException.class)
    protected ResponseEntity<Object> handleError(RuntimeException e, WebRequest webRequest) {
        return handleExceptionInternal(e, e, null, HttpStatus.INTERNAL_SERVER_ERROR, webRequest);
    }

}

