package cn.icexmoon.mvcdemo.controller.advice;

import cn.icexmoon.mvcdemo.util.SystemException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : mvc-demo
 * @Package : cn.icexmoon.mvcdemo.controller.advice
 * @ClassName : .java
 * @createTime : 2023/8/30 10:39
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description : 切面，转换控制层的常见异常为自定义异常
 */
@Order(1)
@Component
@Aspect
public class ControllerExceptionExchangeAspect {
    @Pointcut("execution(public * cn.icexmoon.mvcdemo.controller.*Controller.*(..))")
    public void anyControllerMethods() {
    }

    @Around("anyControllerMethods()")
    public Object changeException(ProceedingJoinPoint pjp) throws Throwable {
        try {
            return pjp.proceed();
        } catch (Exception e) {
            // 将已知的异常重新包装为业务异常
            if (e instanceof ArithmeticException) {
                throw new SystemException(SystemException.ErrorCode.CODE_WRITE, "除零异常", e);
            }
            throw e;
        }
    }
}
