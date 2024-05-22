package com.clean_architecture_java.cleanarchitecturejava.infrastructure.config;

//import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.cdimascio.dotenv.Dotenv;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    private final Dotenv dotenv;

    public SwaggerConfig(){
        this.dotenv = Dotenv.load();
    }

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
            .info(new Info()
                .title(this.dotenv.get("APP_NAME","API Documentation"))
                .version(this.dotenv.get("API_VERSION","1.0.0"))
                .description(this.dotenv.get("APP_DESCRIPTION","API documentation for the application")));
    }

    /*@Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("springshop-public")
                .pathsToMatch("/**")
                .build();
    }*/
}
