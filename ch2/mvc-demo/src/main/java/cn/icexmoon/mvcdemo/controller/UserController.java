package cn.icexmoon.mvcdemo.controller;

import cn.icexmoon.mvcdemo.entity.User;
import cn.icexmoon.mvcdemo.service.UserService;
import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : mvc-demo
 * @Package : cn.icexmoon.mvcdemo.controller
 * @ClassName : .java
 * @createTime : 2023/8/27 16:17
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/save")
    @ResponseBody
    public String save(String name) {
        System.out.println(name);
        return String.format("{'result':true,'msg':'%s user saved.'}", name);
    }

    @Data
    private static class UserDTO{
        private String name;
        private String age;
    }

    @RequestMapping("/save2")
    @ResponseBody
    public String save2(UserDTO dto) {
        System.out.println(String.format("User %s will be saved.", dto));
        return JSON.toJSONString(dto);
    }


    @Data
    private static class UserDTO2{
        @Data
        private static class Address{
            private String country;
            private String province;
        }
        private String name;
        private String age;
        private Address address;
    }

    @RequestMapping("/save3")
    @ResponseBody
    public String save3(UserDTO2 dto) {
        System.out.println(String.format("User %s will be saved.", dto));
        return JSON.toJSONString(dto);
    }

    @RequestMapping("/{id}")
    @ResponseBody
    public String getUserInfo(@PathVariable("id") Integer id) {
        User user = userService.getById(id);
        System.out.println(user);
        return JSON.toJSONString(user);
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam("user") String name) {
        String msg = String.format("hello, %s!", name);
        System.out.println(msg);
        return String.format("{'result':true,'msg':'%s'}", msg);
    }

    @RequestMapping("/hobbies")
    @ResponseBody
    public String hobbies(String[] hobby){
        System.out.println(hobby);
        return JSON.toJSONString(hobby);
    }

    @RequestMapping("/hobbiesList")
    @ResponseBody
    public String hobbiesList(@RequestParam List<String> hobby){
        System.out.println(hobby);
        return JSON.toJSONString(hobby);
    }

    @RequestMapping("/hobbiesJson")
    @ResponseBody
    public String hobbiesJson(@RequestBody List<String> hobbies){
        System.out.println(hobbies);
        return JSON.toJSONString(hobbies);
    }

    @Data
    private static class UserDTO3{
        private String name;
        private Integer age;
    }

    @RequestMapping("/save4")
    @ResponseBody
    public String saveUser4(@RequestBody UserDTO3 dto){
        System.out.println(dto);
        return JSON.toJSONString(dto);
    }

    @RequestMapping("/save/many")
    @ResponseBody
    public List<UserDTO3> saveUsers(@RequestBody List<UserDTO3> users){
        System.out.println(users);
        return users;
    }

    @RequestMapping("/time")
    @ResponseBody
    public String time(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                       @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime time){
        System.out.println(date);
        System.out.println(time);
        return "";
    }

    @RequestMapping("/helloPage")
    public String helloPage(){
        return "index.jsp";
    }

    @GetMapping("/url1")
    public String url1(HttpServletRequest request){
        request.setAttribute("msg", "hello");
        // 转发到 url2
        return "/user/url2";
    }

    @GetMapping("/url2")
    public String url2(HttpServletRequest request){
        // 获取域中的属性
        String msg = (String) request.getAttribute("msg");
        System.out.println(msg);
        return "/index.jsp";
    }

    @GetMapping("/url3")
    public String url3(HttpServletRequest request){
        request.setAttribute("msg", "hello");
        // 转发到 url2
        return "/user/url2";
    }

    @GetMapping("/url4")
    public String url4(@RequestAttribute("msg") String msg){
        // 获取域中的属性
        System.out.println(msg);
        return "/index.jsp";
    }

    @GetMapping("/request")
    public void request(HttpServletRequest request){
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            System.out.println(headerName);
        }
    }

    @GetMapping("/header")
    public void header(@RequestHeader("Accept-Language") String al){
        System.out.println(al);
    }

    @GetMapping("/allHeaders")
    public void allHeaders(@RequestHeader Map<String,String> headers){
        headers.forEach((name,values)->{
            System.out.printf("%s:%s%n", name, values);
        });
    }

    @GetMapping("/cookie")
    public void cookie(@CookieValue("JSESSIONID") String sessionId){
        System.out.println(sessionId);
    }

    @GetMapping("/session/write")
    public String writeSession(HttpServletRequest request){
        request.getSession().setAttribute("username", "icexmoon");
        request.getSession().setAttribute("msg", "hello");
        return "redirect:/user/session/read";
    }

    @GetMapping("/session/read")
    @ResponseBody
    public String readSession(@SessionAttribute("username") String username){
        System.out.println(username);
        return "";
    }
}

