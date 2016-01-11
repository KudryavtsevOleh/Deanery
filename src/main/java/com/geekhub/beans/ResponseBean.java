package com.geekhub.beans;

/**
 * Created by oleh on 16.09.15.
 */
public enum ResponseBean {
    SUCCESS("success"),
    FAILED("failed");

    private final String response;

    private ResponseBean(String str) {
        response = str;
    }

    @Override
    public String toString() {
        return this.response;
    }
}
