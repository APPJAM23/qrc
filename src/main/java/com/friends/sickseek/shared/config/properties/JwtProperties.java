package com.friends.sickseek.shared.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ConfigurationProperties("jwt")
public class JwtProperties {

    private Long accessExpirationTime;
    private String prefix;
    private String secretKey;
}