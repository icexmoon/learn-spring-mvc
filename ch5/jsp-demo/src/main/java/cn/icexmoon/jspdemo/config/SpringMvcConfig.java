package cn.icexmoon.jspdemo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : jsp-demo
 * @Package : cn.icexmoon.jspdemo
 * @ClassName : .java
 * @createTime : 2023/9/21 10:50
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Configuration
@ComponentScan({"cn.icexmoon.jspdemo.controller","cn.icexmoon.jspdemo.config"})
public class SpringMvcConfig {
}
