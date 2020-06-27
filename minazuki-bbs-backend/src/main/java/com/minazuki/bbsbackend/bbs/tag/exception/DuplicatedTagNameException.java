package com.minazuki.bbsbackend.bbs.tag.exception;


public class DuplicatedTagNameException extends Exception{
    public DuplicatedTagNameException(){super("Tag name is duplicated");}
}
