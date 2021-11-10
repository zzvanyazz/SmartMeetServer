package com.lemonado.smartmeetserver.web.rest.models.auth;

import java.time.OffsetDateTime;

public record Token(
        long userId,
        OffsetDateTime issuedAt) {
}
