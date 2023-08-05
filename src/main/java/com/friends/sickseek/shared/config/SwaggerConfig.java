package com.friends.sickseek.shared.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

import static io.swagger.v3.oas.annotations.enums.SecuritySchemeType.HTTP;

@OpenAPIDefinition(
        info = @Info(title = "씩씩 API Document", version = "v0.0.0"),
        security = {
                @SecurityRequirement(name = "Authentication")
        }
)
@SecurityScheme(
        name = "SecretKey Authentication",
        type = HTTP,
        scheme = "Bearer",
        description = "access token"
)
@Configuration
class SwaggerConfig {
}