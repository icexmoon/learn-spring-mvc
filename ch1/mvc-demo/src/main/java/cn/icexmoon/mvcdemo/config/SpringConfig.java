package cn.icexmoon.mvcdemo.config;

import cn.icexmoon.mvcdemo.config.annotation.NoSpringScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : mvc-demo
 * @Package : cn.icexmoon.mvcdemo.config
 * @ClassName : .java
 * @createTime : 2023/8/27 17:35
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Configuration
@ComponentScan(value = "cn.icexmoon.mvcdemo",
        excludeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ANNOTATION,
                        value = Controller.class
                ),
                @ComponentScan.Filter(
                        type = FilterType.ANNOTATION,
                        value = NoSpringScan.class)
        })
@PropertySource("classpath:jdbc.properties")
public class SpringConfig {
}
