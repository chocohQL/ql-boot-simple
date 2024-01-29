package com.chocoh.ql.exception;

/**
 * @author chocoh
 */
public class BaseException extends RuntimeException{
    private int code;

    private String defaultMessage;

    public BaseException() {
        super();
    }

    public BaseException(String message) {
        this.defaultMessage = message;
    }

    public BaseException(int code, String message) {
        this.code = code;
        this.defaultMessage = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }
}
