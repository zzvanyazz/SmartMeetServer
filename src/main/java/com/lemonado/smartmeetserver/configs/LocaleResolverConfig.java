package com.lemonado.smartmeetserver.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

import java.util.Locale;

@Configuration
public class LocaleResolverConfig {
    @Bean
    LocaleResolver localeResolver() {
        return new FixedLocaleResolver(Locale.ENGLISH);
    }
}
