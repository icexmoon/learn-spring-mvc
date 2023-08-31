package cn.icexmoon.mvcdemo.util;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : mvc-demo
 * @Package : cn.icexmoon.mvcdemo.util
 * @ClassName : .java
 * @createTime : 2023/8/30 10:12
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description : 系统异常
 */
public class SystemException extends AbsCustomException{
    public SystemException(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    public SystemException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    public SystemException(ErrorCode errorCode) {
        super(errorCode);
    }

    public SystemException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    /**
     * 系统异常的错误码
     */
    public enum ErrorCode implements IErrorCode {
        UNKNOWN("system.unknown","未知错误"),
        DB_CONN_TIMEOUT("system.db.timeout", "数据库连接超时"),
        CODE_WRITE("system.code.write","代码书写错误");

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
