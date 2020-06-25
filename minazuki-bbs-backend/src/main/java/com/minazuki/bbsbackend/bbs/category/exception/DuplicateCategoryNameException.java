package com.minazuki.bbsbackend.bbs.category.exception;

public class DuplicateCategoryNameException extends Exception {
    public DuplicateCategoryNameException() {
        super("already have this category");
    }
}
