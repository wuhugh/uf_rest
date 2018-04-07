package com.ufrest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * This is the global exception handler
 * To register a new exception to be handled, annotate it with @ServerExceptionHandler and
 * provide a handler function beneath
 */

@ControllerAdvice
@SuppressWarnings("unused")
public class ServerExceptionHandler extends ResponseEntityExceptionHandler  {

    @ExceptionHandler(GatorException.class)
    protected ResponseEntity<Object> handleError(RuntimeException e, WebRequest webRequest) {
        return handleExceptionInternal(e, e, null, HttpStatus.INTERNAL_SERVER_ERROR, webRequest);
    }

}

