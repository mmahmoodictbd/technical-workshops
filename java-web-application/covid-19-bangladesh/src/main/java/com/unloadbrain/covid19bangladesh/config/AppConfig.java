package com.unloadbrain.covid19bangladesh.config;

import com.unloadbrain.covid19bangladesh.util.DateTimeUtil;
import com.unloadbrain.covid19bangladesh.util.JsoupUtil;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Provides application related beans.
 */
@Configuration
@AllArgsConstructor
public class AppConfig {

    @Bean
    public DateTimeUtil dateTimeUtil() {
        return new DateTimeUtil();
    }

    @Bean
    public JsoupUtil jsoupUtil() {
        return new JsoupUtil();
    }
}
