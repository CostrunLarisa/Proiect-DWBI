package com.unibuc.ro.exception;

public class InvalidUsernameException extends RuntimeException {
    public InvalidUsernameException(String choose_a_username) {
        super(choose_a_username);
    }
}
