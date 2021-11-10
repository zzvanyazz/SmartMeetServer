package com.lemonado.smartmeetserver.core.data.exceptions;

public class UserIsBlockedException extends Exception {

    public UserIsBlockedException() {
        super("This user is blocked.");
    }
}
