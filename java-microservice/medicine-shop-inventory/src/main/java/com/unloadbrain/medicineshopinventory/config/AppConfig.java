package com.unloadbrain.medicineshopinventory.config;

import com.unloadbrain.medicineshopinventory.util.DateTimeUtil;
import com.unloadbrain.medicineshopinventory.util.UuidUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Load beans necessary objects.
 */
@Configuration
public class AppConfig {

    @Bean
    public DateTimeUtil dateTimeUtil() {
        return new DateTimeUtil();
    }

    @Bean
    public UuidUtil uuidUtil() {
        return new UuidUtil();
    }
}
