package com.lemonado.smartmeetserver.web.rest.models.dto;

import java.time.OffsetDateTime;

public record UserDto(
        long id,
        String username,
        String email,
        OffsetDateTime deleteTimestamp,
        OffsetDateTime validTokenTimestamp) {

}
