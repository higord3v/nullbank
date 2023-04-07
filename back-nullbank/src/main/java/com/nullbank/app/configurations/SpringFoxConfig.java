package com.nullbank.app.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.stream.Collectors;

@Configuration
public class SpringFoxConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.apiInfo());
    }

    public ApiInfo apiInfo() {
        return new ApiInfo(
                "API Nullbank",
                "API com gerenciamento de clientes e empréstimos",
                "1.0.0",
                "Livre",
                new Contact("Higor Souza", "", "higord3v@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}
