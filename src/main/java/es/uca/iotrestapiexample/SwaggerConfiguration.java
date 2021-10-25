package es.uca.iotrestapiexample;

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
public class SwaggerConfiguration {
    @Bean
    public Docket bookHotelApi() {
        return new Docket( DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage("es.uca.iotrestapiexample.books"))
                .paths( PathSelectors.any())
                .build()
                .apiInfo(getApiInfo())
                .useDefaultResponseMessages(false);
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("API Documentation of the Tiny Amazonia Library")
                .version("1.0")
                .description("This is the first version of the REST API of the Tiny Amazonia Library")
                .contact(new Contact("Antonio Velez-Estevez", "https://www.uca.es", "antonio.velez@uca.es"))
                .license("ISC")
                .build();
    }
}