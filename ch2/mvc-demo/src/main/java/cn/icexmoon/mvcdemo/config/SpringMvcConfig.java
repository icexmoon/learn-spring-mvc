package cn.icexmoon.mvcdemo.config;

import cn.icexmoon.mvcdemo.config.annotation.NoSpringScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
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
}
