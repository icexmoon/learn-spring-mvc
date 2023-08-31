package cn.icexmoon.mvcdemo.util;

import lombok.Getter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : mvc-demo
 * @Package : cn.icexmoon.mvcdemo.util
 * @ClassName : .java
 * @createTime : 2023/8/30 10:19
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description : 自定义异常基类
 */
public abstract class AbsCustomException extends RuntimeException {
    @Getter
    private final IErrorCode errorCode;
    public AbsCustomException(IErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public AbsCustomException(IErrorCode errorCode, Throwable cause) {
        super(errorCode.getDesc(), cause);
        this.errorCode = errorCode;
    }

    public AbsCustomException(IErrorCode errorCode) {
        super(errorCode.getDesc());
        this.errorCode = errorCode;
    }

    public AbsCustomException(IErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
