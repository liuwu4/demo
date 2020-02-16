package cn.example.demo.swagger2;

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

/**
 * @author liuwu4
 * description: swagger2接口文档描述
 */
@Configuration
@EnableSwagger2
public class Swagger2Entry {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //控制暴露出去的路径下的实例
                //如果某个接口不想暴露,可以使用以下注解
                //@ApiIgnore 这样,该接口就不会暴露在 swagger2 的页面下
                .apis(RequestHandlerSelectors.basePackage("cn.example.demo.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("liuwu4",
                "https://github.com/liuwu4",
                "liuwu4@yeah.net");
        return new ApiInfoBuilder()
                //页面标题
                .title("接口")
                //条款地址
                .termsOfServiceUrl("https://liuwu4.github.io/")
                .version("1.0")
                .contact(contact)
                //描述
                .description("API 描述")
                .build();
    }
}
