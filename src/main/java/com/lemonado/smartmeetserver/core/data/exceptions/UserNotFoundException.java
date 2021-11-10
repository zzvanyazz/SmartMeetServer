package com.lemonado.smartmeetserver.core.data.exceptions;

public class UserNotFoundException extends Exception {

    public UserNotFoundException() {
        super("Can not find a user.");
    }
}
