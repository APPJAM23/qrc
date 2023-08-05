package com.friends.sickseek.shared.config;

import com.friends.sickseek.shared.config.properties.JwtProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
        JwtProperties.class,
})
public class PropertiesConfig {
}