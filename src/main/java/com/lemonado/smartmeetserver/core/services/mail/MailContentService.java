package com.lemonado.smartmeetserver.core.services.mail;

import org.springframework.stereotype.Service;

@Service
public class MailContentService {

    public String createRegistrationContent(String roleName, String roleDescription, String registrationCode) {
        return String.format(
                "Your role: %s (%s).\n Your registration code: %s",
                roleName,
                roleDescription,
                registrationCode);
    }

}
