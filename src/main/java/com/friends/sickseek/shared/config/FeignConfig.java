package com.friends.sickseek.shared.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(basePackages = "com.friends.sickseek.shared.feign")
@Configuration
public class FeignConfig {
}
