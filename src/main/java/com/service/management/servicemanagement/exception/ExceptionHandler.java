package com.service.management.servicemanagement.exception;

public class ExceptionHandler extends Exception {
    private String errorcode;

    public ExceptionHandler() {
    }

    public ExceptionHandler(String errorcode, String message) {
        super(message);
        this.errorcode = errorcode;
    }

    public String getErrorcode() {
        return errorcode;
    }

    public ExceptionHandler(Throwable cause) {
        super(cause);
    }
}
