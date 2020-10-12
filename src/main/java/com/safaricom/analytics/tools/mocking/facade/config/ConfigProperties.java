package com.safaricom.analytics.tools.mocking.facade.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * The type Config properties.
 */
@Component
@ConfigurationProperties
public @Data
class ConfigProperties {
    private String streamName;
    private String redisHost;
    private String redisPort;
    private String redisPassword;
    private String secretKey;
}