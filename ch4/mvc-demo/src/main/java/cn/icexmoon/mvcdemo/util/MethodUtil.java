package cn.icexmoon.mvcdemo.util;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : mvc-demo
 * @Package : cn.icexmoon.mvcdemo.util
 * @ClassName : .java
 * @createTime : 2023/8/30 20:47
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class MethodUtil {
    public static void printMethod(Method method){
        Class<?> returnType = method.getReturnType();
        Class<?> declaringClass = method.getDeclaringClass();
        System.out.println(String.format("%s %s.%s() is called.",
                returnType.getSimpleName(),
                declaringClass.getName(),
                method.getName()));
    }
}
