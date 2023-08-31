package cn.icexmoon.mvcdemo.controller.advice;

import cn.icexmoon.mvcdemo.util.BusinessException;
import cn.icexmoon.mvcdemo.util.SystemException;
import cn.icexmoon.mvcdemo.util.WebResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : mvc-demo
 * @Package : cn.icexmoon.mvcdemo.util
 * @ClassName : .java
 * @createTime : 2023/8/29 18:32
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description : 异常拦截器
 */
@RestControllerAdvice
public class MyExceptionAdvice {
    /**
     * 处理业务异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public WebResult<Object> handleBusinessException(BusinessException e) {
        System.out.println(e);
        return WebResult.fail(e.getErrorCode().getErrorCode(), e.getMessage());
    }

    /**
     * 处理系统异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(SystemException.class)
    public WebResult<Object> handleSystemException(SystemException e) {
        //记录日志
        //发送邮件通知相关人员
        e.printStackTrace();
        return WebResult.fail(e.getErrorCode().getErrorCode(), "系统出错，请稍后重新再试");
    }

    /**
     * 处理未定义的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public WebResult<Object> handleOtherException(Exception e) {
        //将未定义异常当做未知的系统异常进行处理
        return handleSystemException(new SystemException(SystemException.ErrorCode.UNKNOWN, "未定义异常", e));
    }

    /**
     * 处理一些控制层无法用 AOP 捕获到的异常，将其作为业务异常或系统异常进行处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public WebResult<Object> handleOtherBusinessException(Exception e) {
        if (e instanceof MethodArgumentTypeMismatchException) {
            return handleBusinessException(new BusinessException(BusinessException.ErrorCode.USER_INPUT, "用户输入的参数类型不正确", e));
        } else {
            return handleOtherException(e);
        }
    }
}
