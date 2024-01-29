package com.chocoh.ql.exception;

import lombok.Getter;

/**
 * @author chocoh
 */
public class GlobalException extends RuntimeException {

    private String message;

    @Getter
    private String detailMessage;

    public GlobalException() {
    }

    public GlobalException(String message) {
        this.message = message;
    }

    public GlobalException setDetailMessage(String detailMessage) {
        this.detailMessage = detailMessage;
        return this;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public GlobalException setMessage(String message) {
        this.message = message;
        return this;
    }
}
