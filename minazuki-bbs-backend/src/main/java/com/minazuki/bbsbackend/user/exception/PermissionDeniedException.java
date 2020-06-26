package com.minazuki.bbsbackend.user.exception;

public class PermissionDeniedException extends Exception{
    public PermissionDeniedException() {
        super("permission denied");
    }
}
