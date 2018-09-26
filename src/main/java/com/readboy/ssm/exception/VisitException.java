package com.readboy.ssm.exception;



/**
 * Created by Wyd on 2018/1/12.
 * 拜访操作异常
 */
public class VisitException extends RuntimeException{
    private String message;

    public VisitException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
