package com.lemonado.smartmeetserver.core.data.exceptions;

public class RegistrationCodeNotFoundException extends Exception {
    public RegistrationCodeNotFoundException() {
        super("Invalid registration code");
    }
}
