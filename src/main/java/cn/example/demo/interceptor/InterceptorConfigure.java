package cn.example.demo.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author liuwu4
 * 22:47
 * description: 拦截器实现
 */
@Configuration
public class InterceptorConfigure implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String [] pathLists= {
                "/**/*.css",
                "/**/*.js",
                "/**/*.png",
                "/**/*.jpg",
                "/**/*.html",
                "/login"
        };
       registry.addInterceptor(new InterceptorConfig())
               .addPathPatterns("/**")
               .excludePathPatterns(pathLists);
    }
}
