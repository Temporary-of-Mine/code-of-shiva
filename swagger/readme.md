
knife4j 是一个贼不错的swagger扩展工具，有一套很不错的UI。

还带有离线文档下载，最让我喜欢的是每一行字段都直接动态对比说明。

- 访问地址：http://localhost:8080/doc.html

- 文档地址：[knife4j (xiaominfo.com)](https://doc.xiaominfo.com/knife4j/documentation/)


### 依赖


```xml
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.9.2</version>
</dependency>

<dependency>
    <groupId>com.github.xiaoymin</groupId>
    <artifactId>knife4j-spring-boot-starter</artifactId>
    <version>2.0.9</version>
</dependency>
```

### config

优秀的分组检测，能根据不同 group ，将不同的 apimodel 进行归类。

```java
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
```
