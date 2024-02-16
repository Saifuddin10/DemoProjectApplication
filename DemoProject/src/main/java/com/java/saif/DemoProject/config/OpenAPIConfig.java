package com.java.saif.DemoProject.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(servers = {@Server(url = "http://localhost:8080", description = "default server url")})
@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI documentation() {
        return new OpenAPI()
                .info(new Info()
                        .title("Demo Project for Spring Boot")
                        .version("3.0.0")
                        .contact(new Contact().name("Saifuddin").email("xyz@email.com"))
                        .license(new License().name("Demo Project")))
                .components(new Components());
    }
}