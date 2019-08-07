package com.tm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SwaggerAPI設定クラス。
 */
@Configuration
@EnableSwagger2
public class SwaggerApiConfigurer {

    @Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(paths())
                .apis(RequestHandlerSelectors.basePackage("com.tm.controller"))
                .build()
                .apiInfo(apiInfo());
    }

    private Predicate<String> paths() {
        return Predicates.and(Predicates.containsPattern(""));
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Parallel")
                .description("Parallel APIのAPI仕様書")
                .version("1.0.0")
                .build();
    }

    /**
     * UI設定
     * @return UiConfigurationインスタンス
     */
    @Bean
    public UiConfiguration configUi(){
        return UiConfigurationBuilder.builder()
                .displayOperationId(false)
                .build();
    }

}
