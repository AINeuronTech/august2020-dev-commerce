package com.aint.commerce.api.documentation;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket apiDocs(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/api/*"))
                .build()
                .apiInfo(apiInfo());

    }
    private ApiInfo apiInfo(){
        return new ApiInfo(
                "Product API",
                "This API return a list of products.",
                "V-1.1",
                "http://localhost.com/",
                new Contact("Matiur Rahman","aineurontech.com","matiur@aineurontech.com"),
                "API License","www.aineurontech.com/license", Collections.emptyList());

    }
}
