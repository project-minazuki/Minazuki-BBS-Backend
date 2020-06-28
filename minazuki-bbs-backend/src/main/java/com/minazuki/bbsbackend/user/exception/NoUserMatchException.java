package com.minazuki.bbsbackend.user.exception;

public class NoUserMatchException extends Exception{
    public NoUserMatchException() {
        super("no user matched or wrong info");
    }
}
