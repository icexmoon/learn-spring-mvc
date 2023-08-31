package cn.icexmoon.mvcdemo.util;

import lombok.Value;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : mvc-demo
 * @Package : cn.icexmoon.mvcdemo.util
 * @ClassName : .java
 * @createTime : 2023/8/29 11:42
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Value
public class WebResult<T> {
    boolean success;
    String errorCode;
    String errorMsg;
    T data;
    public static final String DEFAULT_ERROR_CODE = "error.other";
    //用户输入错误
    public static final String DEFAULT_INPUT_ERROR = "error.input";

    public static <D> WebResult<D> success() {
        return success(null);
    }

    public static <D> WebResult<D> success(D data) {
        return new WebResult<>(true, "", "", data);
    }

    public static <D> WebResult<D> fail(String errorCode, String errorMsg) {
        return new WebResult<>(false, errorCode, errorMsg, null);
    }

    public static <D> WebResult<D> fail(String errorMsg) {
        return fail(DEFAULT_ERROR_CODE, errorMsg);
    }
}
