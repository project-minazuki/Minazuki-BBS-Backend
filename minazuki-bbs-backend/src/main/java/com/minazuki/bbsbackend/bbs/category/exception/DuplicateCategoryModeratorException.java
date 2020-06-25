package com.minazuki.bbsbackend.bbs.category.exception;

public class DuplicateCategoryModeratorException extends Exception {
    public DuplicateCategoryModeratorException() {
        super("already have this category");
    }
}
