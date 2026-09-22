package com.ProjectSpringboot.Point_of_sale.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI pointOfSaleOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Point of Sale API")
                        .description("REST API documentation for the Point of Sale application")
                        .version("1.0.0"));
    }

}
