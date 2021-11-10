package com.lemonado.smartmeetserver.core.data.exceptions;

public class ActionOnAdminRoleException extends Exception {

    public ActionOnAdminRoleException() {
        super("Can not assign or remove assign 'Admin' role.");
    }
}
