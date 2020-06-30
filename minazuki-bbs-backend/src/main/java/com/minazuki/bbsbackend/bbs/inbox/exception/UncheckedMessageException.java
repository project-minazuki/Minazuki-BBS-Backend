package com.minazuki.bbsbackend.bbs.inbox.exception;

public class UncheckedMessageException extends Exception{
    public UncheckedMessageException(){super("This message hasn't been checked");}
}
