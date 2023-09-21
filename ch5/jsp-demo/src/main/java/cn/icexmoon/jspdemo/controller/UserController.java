package cn.icexmoon.jspdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : jsp-demo
 * @Package : cn.icexmoon.jspdemo.controller
 * @ClassName : .java
 * @createTime : 2023/9/21 11:01
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/redirect")
    public String redirect(){
        return "redirect:/jsp/user/login.jsp";
    }

    @GetMapping("/loadLoginPage")
    public String loadLoginPage(){
        return "/jsp/user/login.jsp";
    }

    @GetMapping("/loadLoginPageAndData")
    public String loadLoginPageAndData(Model model) {
        String time = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        String message = "今天天气不错，现在的时间是：" + time;
        model.addAttribute("helloMessage", message);
        return "/jsp/user/login.jsp";
    }

    @GetMapping("/loadLoginPageAndData2")
    public ModelAndView loadLoginPageAndData2() {
        String time = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        String message = "今天天气不错，现在的时间是：" + time;
        ModelAndView modelAndView = new ModelAndView("/jsp/user/login.jsp");
        modelAndView.addObject("helloMessage", message);
        return modelAndView;
    }
}
