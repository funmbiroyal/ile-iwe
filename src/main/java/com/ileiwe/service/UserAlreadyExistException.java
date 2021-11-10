package com.ileiwe.service;

public class UserAlreadyExistException extends Throwable {
    public UserAlreadyExistException(String s) {
        super(s);
    }
}
