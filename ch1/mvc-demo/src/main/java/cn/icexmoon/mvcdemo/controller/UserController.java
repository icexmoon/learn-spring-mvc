package cn.icexmoon.mvcdemo.controller;

import cn.icexmoon.mvcdemo.entity.User;
import cn.icexmoon.mvcdemo.service.UserService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/save")
    @ResponseBody
    public String save() {
        return "{'result':true,'msg':'user saved.'}";
    }

    @RequestMapping("/user/{id}")
    @ResponseBody
    public String getUserInfo(@PathVariable("id") Integer id) {
        User user = userService.getById(id);
        System.out.println(user);
        return JSON.toJSONString(user);
    }
}
