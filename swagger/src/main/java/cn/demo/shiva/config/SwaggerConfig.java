package cn.demo.shiva.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author shiva   2021/9/2 22:43
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("api文档分组")
                .apiInfo(new ApiInfoBuilder()
                        .title("swagger 在线文档案例，api 分组")
                        .description("星宿老仙，法力无边")
                        .contact(new Contact("shiva", "http://localhost:8080/", "qianwei4712@163.com"))
                        .version("V1.0")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.demo.shiva.api"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket createFrontApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("front 文档分组")
                .apiInfo(new ApiInfoBuilder()
                        .title("swagger 在线文档案例，front 分组")
                        .description("神龙教主,仙福永享,寿与天齐")
                        .contact(new Contact("shiva", "http://localhost:8080/", "qianwei4712@163.com"))
                        .version("V1.0")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.demo.shiva.front"))
                .paths(PathSelectors.any())
                .build();
    }
}
