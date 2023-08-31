package cn.icexmoon.mvcdemo.util;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : mvc-demo
 * @Package : cn.icexmoon.mvcdemo.util
 * @ClassName : .java
 * @createTime : 2023/8/30 10:29
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description : 业务异常
 */
public class BusinessException extends AbsCustomException{
    public BusinessException(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    public BusinessException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode);
    }

    public BusinessException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    /**
     * 业务异常的错误码
     */
    public enum ErrorCode implements IErrorCode{
        USER_INPUT("business.user.input","用户输入错误"),
        USER_PARAMS_CHECK("business.user.params.check","用户输入参数检查出错");

        private final String errorCode;
        private final String desc;

        ErrorCode(String errorCode, String desc) {
            this.errorCode = errorCode;
            this.desc = desc;
        }

        @Override
        public String getErrorCode() {
            return errorCode;
        }

        @Override
        public String getDesc() {
            return desc;
        }
    }
}
