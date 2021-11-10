package com.lemonado.smartmeetserver.web.rest.models.requests;

import javax.validation.constraints.NotNull;

public record AssignUserRoleRequest(
        @NotNull
        Long roleId) {

}
