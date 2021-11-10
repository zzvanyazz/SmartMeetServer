package com.lemonado.smartmeetserver.core.data.exceptions;

public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String normalisedUserId) {
        super(String.format("User with name '%s' already exists", normalisedUserId));
    }
}
