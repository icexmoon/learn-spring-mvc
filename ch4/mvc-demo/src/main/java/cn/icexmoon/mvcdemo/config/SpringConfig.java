package cn.icexmoon.mvcdemo.config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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
@PropertySource("classpath:jdbc.properties")
@ComponentScan({
        "cn.icexmoon.mvcdemo.mapper",
        "cn.icexmoon.mvcdemo.service",
        "cn.icexmoon.mvcdemo.system"})
@Import({JdbcConfig.class, MyBatisConfig.class})
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class SpringConfig {
}
