package cn.icexmoon.mvcdemo.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : mvc-demo
 * @Package : cn.icexmoon.mvcdemo
 * @ClassName : .java
 * @createTime : 2023/8/27 16:13
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description : Tomcat 启动时加载 Spring 配置
 */
public class ServletContainerInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * spring 容器的配置类
     *
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    /**
     * spring MVC 容器的配置类
     *
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
                SpringMvcConfig.class};
    }

    /**
     * 哪些请求由 spring MVC 进行处理和响应
     *
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new CharacterEncodingFilter("UTF-8")};
    }
}
