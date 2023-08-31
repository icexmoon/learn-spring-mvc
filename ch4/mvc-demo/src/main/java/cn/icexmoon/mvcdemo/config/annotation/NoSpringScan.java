package cn.icexmoon.mvcdemo.config.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : mvc-demo
 * @Package : cn.icexmoon.mvcdemo.config.annotation
 * @ClassName : .java
 * @createTime : 2023/8/27 17:40
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description : 不被 Spring 配置扫描
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface NoSpringScan {
}
