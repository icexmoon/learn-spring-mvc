package cn.icexmoon.mvcdemo.util;

import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : mvc-demo
 * @Package : cn.icexmoon.mvcdemo.util
 * @ClassName : .java
 * @createTime : 2023/8/30 20:27
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class HttpUtil {
    /**
     * 打印 HTTP 请求报文头
     * @param request
     */
    public static void printRequestHeaders(HttpServletRequest request){
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            Enumeration<String> headerValues = request.getHeaders(name);
            List<String> headerValuesList = new ArrayList<>();
            while (headerValues.hasMoreElements()){
                headerValuesList.add(headerValues.nextElement());
            }
            String values = headerValuesList.stream().collect(Collectors.joining(","));
            System.out.println(String.format("%s:%s", name, values));
        }
    }

    /**
     * 打印响应报文头信息
     * @param response
     */
    public static void printResponseHeaders(HttpServletResponse response){
        Collection<String> headerNames = response.getHeaderNames();
        for (String name: headerNames){
            Collection<String> headerValues = response.getHeaders(name);
            String values = headerValues.stream().collect(Collectors.joining(","));
            System.out.println(String.format("%s:%s", name, values));
        }
    }

    /**
     * 打印控制层方法（签名）
     * @param handlerMethod
     */
    public static void printHandlerMethod(HandlerMethod handlerMethod){
        MethodUtil.printMethod(handlerMethod.getMethod());
    }
}
