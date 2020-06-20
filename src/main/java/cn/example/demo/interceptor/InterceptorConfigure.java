package cn.example.demo.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author liuwu4
 * 22:47
 * description: 拦截器实现
 */
@Configuration
public class InterceptorConfigure implements WebMvcConfigurer {
    /**
     * 拦截url
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String [] pathLists= {
                "/**/*.css",
                "/**/*.js",
                "/**/*.png",
                "/**/*.jpg",
                "/**/*.html",
                "/login",
                "/swagger-resources/**",
                "/swagger-ui.html/**"
        };
       registry.addInterceptor(new InterceptorConfig())
               .excludePathPatterns(pathLists)
               .addPathPatterns("/**");
    }

    /**
     * 配置接口跨域
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("*")
                .maxAge(3600)
        ;
    }
}
