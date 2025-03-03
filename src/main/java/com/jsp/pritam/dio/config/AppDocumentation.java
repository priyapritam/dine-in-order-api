package com.jsp.pritam.dio.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
@OpenAPIDefinition
public class AppDocumentation {

    @Bean
    OpenAPI openAPI() {
        return new OpenAPI().info(info());
    }

    private Info info() {
        return new Info()
                .title("Dine-In Order API")
                .description("""
                        ## Description
                        **Dine In Order** is an API built using Spring Boot under REST Architecture.
                        The API is designed to serve as a backend to a application that deals in ordering food online.
                        
                        ## Tech-Stack
                        - Java 8
                        - Spring Boot
                        - Spring Data JPA
                        - MySQL Database
                        - Spring Security
                        """).contact(new Contact()
                        .name("Priya Pritam Behera")
                        .email("priyapritam.pritam@gmail.com")
                        .url("https://www.linkedin.com/in/priyapritam")).version("v1.0");

    }
}
