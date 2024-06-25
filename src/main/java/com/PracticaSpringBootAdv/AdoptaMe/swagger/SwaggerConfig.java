package com.PracticaSpringBootAdv.AdoptaMe.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    Docket createApiRestDoc() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.PracticaSpringBootAdv.AdoptaMe.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("ADOPTA-ME")
                .description("Documentación de la API de Adopcion de Mascotas")
                .termsOfServiceUrl("https//https://github.com/JuanDtrez")
                .contact(new Contact("Juan Caicedo", "www.juan.com", "juandtrez@gmail.com"))
                .version("1.0")
                .build();
    }
}
