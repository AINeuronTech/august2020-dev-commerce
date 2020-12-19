package com.aint.commerce.api.documentation;


import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket apiDocumentation(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths((Predicate<String>) PathSelectors.ant("/api/*"))
                .apis((Predicate<RequestHandler>) RequestHandlerSelectors.any())
                .build()
                .apiInfo(apiInfo());

    }

    private ApiInfo apiInfo(){
        return new ApiInfo(
                "Product and Person API - CICD",
                "This API will provide list of Product and Person belongs to",
                "Version-1.1",
                "http://localhost.com/",
                new Contact("Sales Reps of AINEURONTECH","aineurontech.com","matiur@aineurontech.com"),
                "API License", "www.localhost.com/license", Collections.emptyList());

    }

}
