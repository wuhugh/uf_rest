package com.ufrest.utils;

import com.ufrest.ResponseObject;

public class ErrorHandler {
    public static Object get404ErrorResponse(String message) {
        return new ResponseObject(false, 404, null, message);
    }

    public static Object getExceptionResponse(Throwable throwable) {
        return new ResponseObject(false, 500, null, throwable.getMessage());
    }
}

