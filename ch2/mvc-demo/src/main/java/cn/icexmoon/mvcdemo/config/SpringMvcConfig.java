package cn.icexmoon.mvcdemo.config;

import cn.icexmoon.mvcdemo.config.annotation.NoSpringScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

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
@NoSpringScan
@Configuration
@ComponentScan("cn.icexmoon.mvcdemo.controller")
@EnableWebMvc
public class SpringMvcConfig {
    /**
     * 文件上传解析器（Bean 名称必须是 multipartResolver）
     * @return
     */
    @Bean
    public MultipartResolver multipartResolver(){
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        // 默认文件编码
        multipartResolver.setDefaultEncoding("UTF-8");
        // 总上传文件的最大容量
        multipartResolver.setMaxUploadSize(3145728);
        // 单个上传文件的最大容量
        multipartResolver.setMaxUploadSizePerFile(1048576);
        // 上传文件缓存大小
        multipartResolver.setMaxInMemorySize(1048576);
        return multipartResolver;
    }
}
