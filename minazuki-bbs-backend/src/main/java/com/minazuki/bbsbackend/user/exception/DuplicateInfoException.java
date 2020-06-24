package com.minazuki.bbsbackend.user.exception;

import java.util.*;

public class DuplicateInfoException extends Exception {

    private final Set<String> duplicateInfo = new HashSet<>();

    public DuplicateInfoException() {
        super("duplicate information");
    }

    public Map<String, Object> getData() {
        Map<String, Object> data = new HashMap<>();
        data.put("duplicateInfo", this.duplicateInfo);
        data.put("duplicateInfoSize", this.duplicateInfo.size());
        return data;
    }

    public void addDuplicateInfo(String duplicateInfo) {
        this.duplicateInfo.add(duplicateInfo);
    }

    public void removeDuplicateInfo(String duplicateInfo) {
        this.duplicateInfo.remove(duplicateInfo);
    }

}