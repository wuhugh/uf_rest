package com.ufrest.error;

public class UFRestException extends RuntimeException {
    private Throwable cause;
    private String message;

    public UFRestException(Throwable cause) {
        super(cause);
        this.cause = cause;
    }

    public UFRestException(String message) {
        super(message);
        this.message = message;
    }

    public UFRestException(Throwable cause, String message) {
        super(message, cause);
    }

}
