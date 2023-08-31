package cn.icexmoon.mvcdemo.config;

import cn.icexmoon.mvcdemo.controller.interceptor.MyInterceptor1;
import cn.icexmoon.mvcdemo.controller.interceptor.MyInterceptor2;
import cn.icexmoon.mvcdemo.controller.interceptor.MyInterceptor3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : mvc-demo
 * @Package : PACKAGE_NAME
 * @ClassName : .java
 * @createTime : 2023/8/27 16:12
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Configuration
@ComponentScan({"cn.icexmoon.mvcdemo.controller"})
@EnableWebMvc
public class SpringMvcConfig implements WebMvcConfigurer {
    @Autowired
    private MyInterceptor1 myInterceptor1;
    @Autowired
    private MyInterceptor2 myInterceptor2;
    @Autowired
    private MyInterceptor3 myInterceptor3;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
        registry.addResourceHandler("/plugins/**").addResourceLocations("/plugins/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(myInterceptor1).addPathPatterns("/books", "/books/*");
        registry.addInterceptor(myInterceptor2).addPathPatterns("/books", "/books/*");
        registry.addInterceptor(myInterceptor3).addPathPatterns("/books", "/books/*");
    }
}
