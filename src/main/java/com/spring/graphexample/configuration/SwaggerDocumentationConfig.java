package com.spring.graphexample.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.threeten.bp.LocalDate;
import org.threeten.bp.OffsetDateTime;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerDocumentationConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.spring.graphexample.api"))
                .build()
                .directModelSubstitute(LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(OffsetDateTime.class, java.util.Date.class)
                // Tutte le API richiedono il cookie "LtpaToken2"; centralizziamo
                // qui la sua documentazione, descrivendolo come header "Cookie"
                // perche' Swagger/OpenAPI 2.0 non contempla i cookie:
                // https://swagger.io/docs/specification/2-0/describing-parameters/
                // Con required=false in @CookieValue funziona anche
                // l'invocazione delle API da /swagger-ui.html !!!
                .globalOperationParameters(null)
                .apiInfo(new ApiInfoBuilder()
                        .title("Graph Dijkstra REST API")
                        .description("Dijkstra Algorithm for Vacancy Matching")
                        .version("1.0")
                        .build());
    }
}
