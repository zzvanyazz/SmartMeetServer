package com.lemonado.smartmeetserver.core.data.models.registration;

public record StartRegistrationModel(
        String registrationCode,
        String email,
        long roleId) {

}
