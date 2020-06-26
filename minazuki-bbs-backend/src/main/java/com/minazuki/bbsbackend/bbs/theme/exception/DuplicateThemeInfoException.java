package com.minazuki.bbsbackend.bbs.theme.exception;

public class DuplicateThemeInfoException extends Exception{

    //当输入的主题帖信息不正确时,抛出DuplicateThemeInfoException
    public DuplicateThemeInfoException(){super("ThemeInfo is not correct");}


}
