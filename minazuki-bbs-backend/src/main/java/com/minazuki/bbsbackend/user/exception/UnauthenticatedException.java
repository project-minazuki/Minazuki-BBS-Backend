package com.minazuki.bbsbackend.user.exception;

public class UnauthenticatedException extends Exception {
    public UnauthenticatedException(String msg) {
        super(msg);
    }

    public UnauthenticatedException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
